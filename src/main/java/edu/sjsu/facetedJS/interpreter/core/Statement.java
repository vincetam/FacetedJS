package edu.sjsu.facetedJS.interpreter.core;

import java.util.List;

import edu.sjsu.facetedJS.interpreter.core.env.Environment;
import edu.sjsu.facetedJS.interpreter.core.env.Perm;
import edu.sjsu.facetedJS.interpreter.core.env.ProgramCounter;

/**
 * Faceted FWJS statements.
 */
public interface Statement extends Element {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env, ProgramCounter pc, boolean s);
}

/**
 *  Create output channel
 */
class writeChannelExpr implements Statement {
	private Expression labels;
	private Expression msg;
	public writeChannelExpr(Expression labels, Expression msg){
		this.labels = labels;
		this.msg = msg;
	}
	@Override
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value perms = labels.evaluate(env, pc, s);
		if (!(perms instanceof ArrayVal)){
			System.out.println("Incompatible type. (expected Array of Label)");
			return null;
		}
		ArrayVal array = (ArrayVal)perms;
		Perm p = new Perm();
		long length = ((IntVal)array.getLength()).toInt();
		for (int i = 0; i < length; i++){
			LabelVal label = ((LabelVal)array.getProp(new IntVal(i)));
			if (!(label instanceof LabelVal)){
				System.out.println("Incompatible type. (expected Label)");
				return null;
			}
			p.add(label.toString());
		}
		Value val = msg.evaluate(env, pc, s).project(p);
		if (pc.visibleTo(p)){			
			System.out.println(val); 
		}
		return null;
	}
}

/**
 * expression type statement
 */
class Expr implements Statement {
    private Expression e;
    public Expr(Expression e) {
        this.e = e;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        e.evaluate(env, pc, s);
        return null;
    }
}

/**
 * function expression.
 */
class NamedFunctionExpr implements Statement {
	private String funcName;
    private List<String> params;
    private Statement body;
    public NamedFunctionExpr(String funcName, List<String> params, Statement body) {
    	this.funcName = funcName;
        this.params = params;
        this.body = body;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	VarExpr varExpr = new VarExpr(funcName);
    	Expression funcExpr = new FunctionExpr(params, body);
    	Expression assignExpr = new AssignExpr(varExpr, Operator.ASSIGN_REG, funcExpr);
		Value v = assignExpr.evaluate(env, pc, s);
		return v;
    }
}

/**
 * sequence statements
 */
class SeqExpr implements Statement {
    private Statement e1;
    private Statement e2;
    public SeqExpr(Statement e1, Statement e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        Value r = e1.evaluate(env, pc, s);
        if (r instanceof ReturnVal){
        	return r;
        }
        return e2.evaluate(env, pc, s);
    }
}

/**
 * if expressions.
 */
class IfExpr implements Statement {
    private Expression cond;
    private Statement thn;
    private Statement els;
    public IfExpr(Expression cond, Statement thn, Statement els) {
        this.cond = cond;
        this.thn = thn;
        this.els = els;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        Value condVal = this.cond.evaluate(env, pc, s);
        
        if (condVal instanceof NullVal
        	|| condVal instanceof UndefinedVal) {
        	return this.els != null ? this.els.evaluate(env, pc, s) : null;
        }
        if (condVal instanceof BoolVal) {
        	BoolVal bv = (BoolVal) condVal;
        	if (bv.toBoolean()) {
        		return this.thn.evaluate(env, pc, s);
        	} else {
        		return this.els != null ? this.els.evaluate(env, pc, s) : null;
			}
        }
        // eval sub branches
        if (condVal instanceof FacetedVal) {
        	FacetedVal fv = (FacetedVal) condVal;
        	String k = fv.getLabel();
        	IfExpr lBranch = new IfExpr(new ValueExpr(fv.getLeft()),thn, els);
        	IfExpr rBranch = new IfExpr(new ValueExpr(fv.getRight()),thn, els);
        	lBranch.evaluate(env, pc.add(k, true), s);
        	rBranch.evaluate(env, pc.add(k, false), s);
        	return null;
        }
        throw new RuntimeException("Expected boolean, but got " + cond);
    }
}

/**
 * while statements
 */
class WhileExpr implements Statement {
    private Expression cond;
    private Statement body;
    public WhileExpr(Expression cond, Statement body) {
        this.cond = cond;
        this.body = body;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	Statement whileExpr = new WhileExpr(cond, body);
    	Statement seqExpr = new SeqExpr(body, whileExpr);
    	Statement ifExpr = new IfExpr(cond, seqExpr, null);
    	Value v = ifExpr.evaluate(env, pc, s);
    	
    	return v;
    }
}

/**
 * do while statements
 */
class DoWhileExpr implements Statement {
    private Expression cond;
    private Statement body;
    public DoWhileExpr(Expression cond, Statement body) {
        this.cond = cond;
        this.body = body;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) { 
    	Statement whileExpr = new WhileExpr(cond, body);
    	Statement seqExpr = new SeqExpr(body, whileExpr);
    	Value v = seqExpr.evaluate(env, pc, s);
    	
    	return v;
    }
}

/**
 * for statements (treated as expressions in FWJS, unlike JS).
 */
class ForExpr implements Statement {
	private Expression init;
    private Expression cond;
    private Expression inc;
    private Statement body;
    public ForExpr(Expression init, Expression cond, Expression inc, Statement body) {
    	this.init = init;
        this.cond = cond;
        this.inc = inc;
        this.body = body;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) { 
    	Statement seqExpr1 = new SeqExpr(body, new Expr(inc));
    	Statement whileExpr = new WhileExpr(cond, seqExpr1);
    	Statement seqExpr2 = new SeqExpr(new Expr(init), whileExpr);
    	Value v = seqExpr2.evaluate(env, pc, s);
    	
    	return v;
    }
}

/**
 * return expression.
 */
class ReturnExpr implements Statement {
	private Expression exp;
	public ReturnExpr(Expression exp) {
		this.exp = exp;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value v = exp.evaluate(env, pc, s);
		return new ReturnVal(v);
	}
}

/**
 * system log expression.
 */
class SystemLogExpr implements Statement {
	private Expression exp;
	public SystemLogExpr(Expression exp) {
		this.exp = exp;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value v = exp.evaluate(env, pc, s);
		System.out.println(v);
		return v;
	}
}

/**
 * alert expression
 */
class AlertExpr implements Statement {
	public Perm pms;
	private Expression msg;
	
	public AlertExpr(Expression msg) {
		pms = new Perm();
		pms.add("k3").add("k1").add("k2");
		this.msg = msg;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value v = msg.evaluate(env, pc, s).project(pms);
		System.out.println("[ Display an alert box : " + v.toString() + " ]");
		return v;
	}
}

/**
 * window.open expression
 */
class WinOpenExpr implements Statement {
	public Perm pms;
	private Expression url;
	
	public WinOpenExpr(Expression url) {
		pms = new Perm();
		this.url = url;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value v = url.evaluate(env, pc, s).project(pms);
		System.out.println("[ Go to URL : " + v + " ]");
		return v;
	}
}