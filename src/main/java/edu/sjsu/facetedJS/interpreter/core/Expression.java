package edu.sjsu.facetedJS.interpreter.core;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import edu.sjsu.facetedJS.interpreter.core.env.Branch;
import edu.sjsu.facetedJS.interpreter.core.env.Environment;
import edu.sjsu.facetedJS.interpreter.core.env.ProgramCounter;

/**
 * Faceted FWJS expressions.
 */
public interface Expression extends Element {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env, ProgramCounter pc, boolean s);
}

/**
 *  label expression.
 */
class LabelExpr implements Expression {
	public LabelExpr(){
	}
	@Override
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		return new LabelVal(Environment.labelRef++);
	}
}

/**
 *  set security expression.
 */
class SetSecurityExpr implements Expression {
	private Expression k;
	private Expression hi;
	private Expression lo;
	public SetSecurityExpr(Expression k, Expression hi, Expression lo){
		this.k = k;
		this.hi = hi;
		this.lo = lo;
	}
	@Override
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value l = k.evaluate(env, pc, s);
		if (!(l instanceof LabelVal)){
			System.out.println("Incompatible type. (expected Label)");
			return new UndefinedVal();
		}
		String label = ((LabelVal)l).getRef();
		FacetedExpr fe = new FacetedExpr(label, hi, lo);
		Value v = fe.evaluate(env, pc, s);
		return v;
	}
}

/**
 *  defacet expression
 */
class DefacetExpr implements Expression {
	private Expression k;
	private Expression hi;
	public DefacetExpr(Expression k, Expression hi){
		this.k = k;
		this.hi = hi;
	}
	@Override
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value l = k.evaluate(env, pc, s);
		if (!(l instanceof LabelVal)){
			return new UndefinedVal();
		}
		String label = ((LabelVal)l).toString();
		Value hiVal = hi.evaluate(env, pc, s);
		ProgramCounter pList = new ProgramCounter(label, true);
		Value v = hiVal.eliminateFace(pList);
		return v;
	}
}

/**
 *  alloc label expression.
 */
class LabelRefExpr implements Expression {
	public LabelRefExpr(){
	}
	@Override
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		String l = "k" + Environment.labelRef++;
		return new StringVal(l);
	}
}

/**
 * value expression.
 */
class ValueExpr implements Expression {
    private Value val;
    public ValueExpr(Value v) {
        this.val = v;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        Value v = val.eliminateFace(pc);
        return v;
    }
}

/**
 * variable expression.
 */
class VarExpr implements Expression {
    private String varName;
    public VarExpr(String varName) {
        this.varName = varName;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	Value v = env.resolveVar(varName);
    	return v == null ? new UndefinedVal() : v.eliminateFace(pc);
    }
	public String getVarName() {
		return varName;
	}
}

/**
 * array expression.
 */
class ArrayExpr implements Expression {
    private List<Expression> lst;
    public ArrayExpr() {
    	lst = new ArrayList<Expression>();
    }
    public void addElem(Expression expr){
    	lst.add(expr);
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	ArrayVal ary = new ArrayVal();
    	for (Expression e : lst){
    		ary.addElem(e.evaluate(env, pc, s));
    	}
    	return ary;
    }
}

/**
 * object expression.
 */
class ObjectExpr implements Expression {
	private HashMap<String, Expression> hm;
	public ObjectExpr() {
		this.hm = new HashMap<String, Expression>();
	}
	public void set(String propId, Expression expr){
		hm.put(propId, expr);
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		ObjectVal obj = new ObjectVal();
		for (Entry<String, Expression> entry : hm.entrySet()) {
			String key = entry.getKey();
			Expression expr = entry.getValue();
			Value v = expr.evaluate(env, pc, s);
			obj.set(key, v);
		}
    	return obj;
	}
}

/**
 * bracket notation expression.
 */
class BracketExpr implements Expression {
	private Expression ref;
	private Expression propExpr;
	public BracketExpr(Expression ref, Expression propExpr) {
		this.ref = ref;
		this.propExpr = propExpr;
	}
	public Expression getRef() {
		return ref;
	}
	public Expression getPropExpr() {
		return propExpr;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value lst = ref.evaluate(env, pc, s);
		Value prop = propExpr.evaluate(env, pc, s);
		if (lst instanceof ArrayVal){
			Value v = ((ArrayVal)lst).getProp(prop);
			v = v.eliminateFace(pc);
			return v;
		}
		if (lst instanceof ObjectVal){
			if (prop instanceof StringVal){
				String propId = ((StringVal)prop).toString();
				Value v = ((ObjectVal)lst).getPropById(propId);
				v = v.eliminateFace(pc);
				return v;
			}
		}
		if (lst instanceof FacetedVal){
			FacetedVal fv = (FacetedVal) lst;
			String k = fv.getLabel();
			Expression hiExpr = new BracketExpr(new ValueExpr(fv.getLeft()), new ValueExpr(prop));
			Expression loExpr = new BracketExpr(new ValueExpr(fv.getRight()), new ValueExpr(prop));
			Value hi = hiExpr.evaluate(env, pc.add(k, true), s);
			Value lo = loExpr.evaluate(env, pc.add(k, false), s);
			Value v = FacetedValFactory.buildFacet(k, hi, lo);
			v = v.eliminateFace(pc);
			return v;
		}
		System.out.println("Braceket notation only supports in Array/Objects");
		return new UndefinedVal();
	}
}

/**
 * dot notation expression.
 */
class DotExpr implements Expression {
	private Expression ref;
	private String propId;
	public DotExpr(Expression ref, String propId) {
		this.ref = ref;
		this.propId = propId;
	}
	public Expression getRef() {
		return ref;
	}
	public String getPropId() {
		return propId;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value obj = ref.evaluate(env, pc, s);
		
		if (obj instanceof ObjectVal){
			Value v = ((ObjectVal)obj).getPropById(propId);
			v = v.eliminateFace(pc);
			return v;
		}
		if (obj instanceof FacetedVal){
			FacetedVal fv = (FacetedVal) obj;
			String k = fv.getLabel();
			Expression hiExpr = new DotExpr(new ValueExpr(fv.getLeft()), propId);
			Expression loExpr = new DotExpr(new ValueExpr(fv.getRight()), propId);
			Value hi = hiExpr.evaluate(env, pc.add(k, true), s);
			Value lo = loExpr.evaluate(env, pc.add(k, false), s);
			Value v = FacetedValFactory.buildFacet(k, hi, lo);
			v = v.eliminateFace(pc);
			return v;
		}
		System.out.println("Dot notation only supports in Objects");
		return new UndefinedVal();
	}
}

/**
 * pre/post increment expression.
 */
class IncDecExpr implements Expression {
	private Expression varExpr;
	private Operator op;
	private boolean postProcess;
	public IncDecExpr(Expression varExpr, Operator op, boolean postProcess) {
		this.varExpr = varExpr;
		this.op = op;
		this.postProcess = postProcess;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value old = varExpr.evaluate(env, pc, s);
		Operator operator = op == Operator.INC ? Operator.ASSIGN_ADD : Operator.ASSIGN_SUB;
		Expression expr = new AssignExpr(varExpr, operator, new ValueExpr(new IntVal(1)));
		Value v = expr.evaluate(env, pc, s);
		return postProcess ? old : v;
	}
}

/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class BinOpExpr implements Expression {
    private Operator op;
    private Expression e1;
    private Expression e2;
    public BinOpExpr(Operator op, Expression e1, Expression e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        Value v1 = e1.evaluate(env, pc, s);
        Value v2 = e2 == null ? null : e2.evaluate(env, pc, s);
        return v1.applyOp(op, v2);
    }
}

/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class UnaOpExpr implements Expression {
	private Operator op;
	private Expression e;
	public UnaOpExpr(Operator op, Expression e) {
		this.op = op;
		this.e = e;
	}
	public Expression getExpr() {
		return e;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value v = e.evaluate(env, pc, s);
		return v.applyOp(op);
	}
}

/**
 * local variable declaration expression.
 */
class VarDeclExpr implements Expression {
    private String varName;
    private Operator op;
    private Expression exp;
    public VarDeclExpr(String varName, Operator op, Expression exp) {
        this.varName = varName;
        this.op = op;
        this.exp = exp;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	if (op != Operator.ASSIGN_REG){
    		throw new RuntimeException("Unrecognized operator / type mismatch");
    	}
        env.createVar(varName, new UndefinedVal(), s);
        Expression assignExpr = new AssignExpr(new VarExpr(varName), Operator.ASSIGN_REG, exp);
        Value v = assignExpr.evaluate(env, pc, s);
        return v;
    }
}

/**
 * assignment expression.
 */
class AssignExpr implements Expression {
    private Expression varExpr;
    private Operator op;
    private Expression e;
    public AssignExpr(Expression varExpr, Operator op, Expression e) {
        this.varExpr = varExpr;
        this.op = op;
        this.e = e;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
    	Value v;
    	Expression expr;
    	Operator operator = null;
    	
    	if (op != Operator.ASSIGN_REG){
    		switch(op) {
        	case ASSIGN_ADD:
        		operator = Operator.ADD;
        		break;
        	case ASSIGN_SUB:
        		operator = Operator.SUB;
        		break;
        	case ASSIGN_MUL:
        		operator = Operator.MUL;
        		break;
        	case ASSIGN_DIV:
        		operator = Operator.DIV;
        		break;
        	default:
        		break;
        	}
    		expr = new AssignExpr(varExpr, Operator.ASSIGN_REG, new BinOpExpr(operator, varExpr, e));
    		v = expr.evaluate(env, pc, s);
    		return v;
    	}
    	
    	if (varExpr instanceof VarExpr){
	    	String varName = ((VarExpr)varExpr).getVarName();
	    	v = e.evaluate(env, pc, s);
	    	String pcLabel = pc.getLabel();
	    	if (pcLabel == null){
	    		env.updateVar(varName, v, s);
	    		return v;
	    	}
	    	Value oldVar = env.resolveVar(varName);
	    	Value oldV = oldVar == null ? new UndefinedVal() : oldVar;
	    	Value fv = FacetedValFactory.updateFacet(pc, v, oldV);
	    	env.updateVar(varName, fv, s);
	    	return v;
    	} else if (varExpr instanceof BracketExpr){
    		Expression refExpr = ((BracketExpr)varExpr).getRef();
    		Expression propExpr = ((BracketExpr)varExpr).getPropExpr();
    		Value ref = refExpr.evaluate(env, pc, s);
    		v = e.evaluate(env, pc, s);
    		Value idx = propExpr.evaluate(env, pc, s);
    		if (ref instanceof ArrayVal){
    			ArrayVal array = (ArrayVal)ref;
    			Value oldV = array.getProp(idx);
    	    	Value fv = FacetedValFactory.updateFacet(pc, v, oldV);
    			array.set(idx, fv);
    		}
    		if (ref instanceof ObjectVal) {
    			if (idx instanceof StringVal){
    				String propId = ((StringVal)idx).toString();
    				ObjectVal obj = (ObjectVal)ref;
        			Value oldV = obj.getPropById(propId);
        	    	Value fv = FacetedValFactory.updateFacet(pc, v, oldV);
        			obj.set(propId, fv);
    			}
    		}
    		if (ref instanceof FacetedVal){
    			FacetedVal fv = (FacetedVal) ref;
    			String k = fv.getLabel();
    			Expression hiExpr = new AssignExpr(new BracketExpr(new ValueExpr(fv.getLeft()), new ValueExpr(idx)), op, new ValueExpr(v));
    			Expression loExpr = new AssignExpr(new BracketExpr(new ValueExpr(fv.getRight()), new ValueExpr(idx)), op, new ValueExpr(v));
    			hiExpr.evaluate(env, pc.add(k, true), s);
    			loExpr.evaluate(env, pc.add(k, false), s);
    		}
    		return v;
    	} else if (varExpr instanceof DotExpr){
    		Expression refExpr = ((DotExpr)varExpr).getRef();
    		String propId = ((DotExpr)varExpr).getPropId();
    		Value ref = refExpr.evaluate(env, pc, s);
    		v = e.evaluate(env, pc, s);
    		if (ref instanceof ObjectVal){
    			ObjectVal obj = (ObjectVal)ref;
    			Value oldV = obj.getPropById(propId);
    	    	Value fv = FacetedValFactory.updateFacet(pc, v, oldV);
    			obj.set(propId, fv);
    		}
    		if (ref instanceof FacetedVal){
    			FacetedVal fv = (FacetedVal) ref;
    			String k = fv.getLabel();
    			Expression hiExpr = new AssignExpr(new DotExpr(new ValueExpr(fv.getLeft()), propId), op, new ValueExpr(v));
    			Expression loExpr = new AssignExpr(new DotExpr(new ValueExpr(fv.getRight()), propId), op, new ValueExpr(v));
    			hiExpr.evaluate(env, pc.add(k, true), s);
    			loExpr.evaluate(env, pc.add(k, false), s);
    		}
    		return v;
    	}
    	
    	System.out.println("ERROR: Invalid variable type.");
    	return new UndefinedVal();
    }
}

/**
 * function expression.
 */
class FunctionExpr implements Expression {
	private List<String> params;
	private Statement body;
	public FunctionExpr(List<String> params, Statement body) {
		this.params = params;
		this.body = body;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		return new ClosureVal(this.params, this.body, env);
	}
}

class FunctionAppExpr implements Expression {
    private Expression f;
    private ReturnType returnType;
    private List<Expression> args;
    public FunctionAppExpr(Expression f, List<Expression> args) {
        this.f = f;
        this.returnType = ReturnType.VALUE;
        this.args = args;
    }
    public void setReturnType(ReturnType returnType){
    	this.returnType = returnType;
    }
    public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
        Value closure = f.evaluate(env, pc, s);
        List<Value> argVals = new ArrayList<Value>();
        
        if (closure instanceof ClosureVal) {
        	for (Expression arg : args) {
                if (arg != null){
                	argVals.add(arg.evaluate(env, pc, s));
                } else {
                	argVals.addAll(null);
                }
            }
            return ((ClosureVal)closure).apply(returnType, argVals, env, pc, s);
        } else if (closure instanceof FacetedVal){
        	FacetedVal fv = (FacetedVal) closure;
        	String k = fv.getLabel();
        	Expression hFunc = new ValueExpr(fv.getLeft());
        	Expression lFunc = new ValueExpr(fv.getRight());
        	Expression fExpr = new FacetedExpr(k, new FunctionAppExpr(hFunc, args), new FunctionAppExpr(lFunc, args));
        	return fExpr.evaluate(env, pc, s);
        }
        
        System.out.println("ERROR: Undefined function ");
        return new UndefinedVal(); 
    }
}

/**
 * function application expression.
 */
class ObjectInstantExpr implements Expression {
	private Expression f;
	public ObjectInstantExpr(Expression f) {
		this.f = f;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		if (f instanceof FunctionAppExpr){
			FunctionAppExpr func = (FunctionAppExpr)f;
			func.setReturnType(ReturnType.OBJECT);
			return func.evaluate(env, pc, s);
		}
		return new UndefinedVal(); 
	}
}

/**
 * Faceted expression.
 */
class FacetedExpr implements Expression {
	private String k;
	private Expression hi;
	private Expression lo;

	public FacetedExpr(String k, Expression hi, Expression lo) {
		this.k = k;
		this.hi = hi;
		this.lo = lo;
	}
	
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Branch fv = pc.checkExecType(k);
		if (fv == Branch.LEFT) return hi.evaluate(env, pc, s);
		if (fv == Branch.RIGHT)  return lo.evaluate(env, pc, s);
		Value hiExec = hi.evaluate(env, pc.add(k, true), s);
		Value loExec = lo.evaluate(env, pc.add(k, false), s);
		return FacetedValFactory.build(k, hiExec, loExec);
	}
}

/**
 * Built-in functions
 */

/**
 * Get Length built-in function
 */
class GetLengthExpr implements Expression {
	private Expression ref;
	public GetLengthExpr(Expression ref) {
		this.ref = ref;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value obj = ref.evaluate(env, pc, s);

		// built-in function : length
		if (obj instanceof ArrayVal){
			ArrayVal array = (ArrayVal)obj;
			Value length = array.getLength();
			return length;
		}
		if (obj instanceof FacetedVal){
			FacetedVal fv = (FacetedVal) obj;
			String k = fv.getLabel();
			Expression hiExpr = new GetLengthExpr(new ValueExpr(fv.getLeft()));
			Expression loExpr = new GetLengthExpr(new ValueExpr(fv.getRight()));
			Value hi = hiExpr.evaluate(env, pc.add(k, true), s);
			Value lo = loExpr.evaluate(env, pc.add(k, false), s);
			Value v = FacetedValFactory.buildFacet(k, hi, lo);
			return v;
		}
		System.out.println("get length only supports in Array");
		return new UndefinedVal();
	}
}

/**
 * Push built-in function
 */
class PushExpr implements Expression {
	private Expression ref;
	private Expression elem;
	public PushExpr(Expression ref, Expression elem) {
		this.ref = ref;
		this.elem = elem;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value obj = ref.evaluate(env, pc, s);

		if (obj instanceof ArrayVal){
			ArrayVal array = (ArrayVal)obj;
			Value v = elem.evaluate(env, pc, s);
			array.addElem(v);
			Value length = array.getLength();
			return length;
		}
		if (obj instanceof FacetedVal){
			FacetedVal fv = (FacetedVal) obj;
			String k = fv.getLabel();
			Expression hiExpr = new PushExpr(new ValueExpr(fv.getLeft()), elem);
			Expression loExpr = new PushExpr(new ValueExpr(fv.getRight()), elem);
			Value hi = hiExpr.evaluate(env, pc.add(k, true), s);
			Value lo = loExpr.evaluate(env, pc.add(k, false), s);
			Value v = FacetedValFactory.buildFacet(k, hi, lo);
			return v;
		}
		System.out.println("Push only supports in Array");
		return new UndefinedVal();
	}
}

/**
 * MD5 built-in function
 */
class HashExpr implements Expression {
	private Expression expr;
	public HashExpr(Expression expr) {
		this.expr = expr;
	}
	public Value evaluate(Environment env, ProgramCounter pc, boolean s) {
		Value obj = expr.evaluate(env, pc, s);
		Value v = new UndefinedVal();
		
		if (obj instanceof ArrayVal || obj instanceof ObjectVal){
			System.out.println("Hash function do not supports Object/Array");
			return v;
		}
		if (obj instanceof FacetedVal){
			FacetedVal fv = (FacetedVal) obj;
			String k = fv.getLabel();
			Expression hiExpr = new HashExpr(new ValueExpr(fv.getLeft()));
			Expression loExpr = new HashExpr(new ValueExpr(fv.getRight()));
			Value hi = hiExpr.evaluate(env, pc.add(k, true), s);
			Value lo = loExpr.evaluate(env, pc.add(k, false), s);
			v = FacetedValFactory.buildFacet(k, hi, lo);
			return v;
		}
		String str = obj.toString();
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes("UTF-8"));
			String bytes = bytesToHex(messageDigest.digest());
			v = new StringVal(bytes);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println("Hash function exceptions.");
		}
		return v;
	}
	public String bytesToHex(byte[] b) {
	  char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                     '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	  StringBuffer buf = new StringBuffer();
	  for (int j=0; j<b.length; j++) {
	     buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	     buf.append(hexDigit[b[j] & 0x0f]);
	  }
	  return buf.toString();
	}
}



