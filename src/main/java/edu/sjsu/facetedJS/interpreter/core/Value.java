package edu.sjsu.facetedJS.interpreter.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import edu.sjsu.facetedJS.interpreter.core.env.Branch;
import edu.sjsu.facetedJS.interpreter.core.env.Environment;
import edu.sjsu.facetedJS.interpreter.core.env.Perm;
import edu.sjsu.facetedJS.interpreter.core.env.ProgramCounter;

/**
 * Faceted values in FWJS.
 * Evaluating a FWJS expression should return a FWJS value.
 */
public interface Value {
	default Value applyOp(Operator op, Value v) {
		throw new RuntimeException("Type mismatch");
	};
	default Value applyOp(Operator op) {
		return new UndefinedVal();
	};
	default String toScreen() {
		return this.toString();
	}
	Value eliminateFace(ProgramCounter pc);    // eliminate excessive facets
	Value project(Perm perms); // project faceted value into actual value
}

/**
 * Label Value
 */
class LabelVal implements Value {
	private String ref;
	public LabelVal(long ref) {
		String str = "0x" + Long.toHexString(ref);
		this.ref = str;
	}
	public String getRef(){
		return ref;
	}
	@Override
	public boolean equals(Object that) {
		return this == that;
	}
	@Override
	public String toString() {
		return ref;
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
}

/**
 * Null values.
 */
class NullVal implements Value {
	@Override
	public boolean equals(Object that) {
		return (that instanceof NullVal);
	}
	@Override
	public String toString() {
		return "null";
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			if (v instanceof StringVal) {
				return new StringVal(this.toString() + v.toString());
			}
			return new UndefinedVal();
    	case EQ:
    		if (v instanceof NullVal || v instanceof UndefinedVal){
    			return  new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case NEQ:
    		if (v instanceof NullVal || v instanceof UndefinedVal){
    			return  new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case S_EQ:
    		if (v instanceof NullVal){
    			return new BoolVal(true); 
    		}
    		return new BoolVal(false);
    	case S_NEQ:
    		if (v instanceof NullVal){
    			return new BoolVal(false); 
    		}
    		return new BoolVal(true);
    	case AND:
    		return new NullVal();
    	case OR:
    		return v;    		
		default:
			return new UndefinedVal();
        }
	};
}

/**
 * Undefined values.
 */
class UndefinedVal implements Value {
	@Override
	public boolean equals(Object that) {
		return (that instanceof UndefinedVal);
	}
	@Override
	public String toString() {
		return "undefined";
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			if (v instanceof StringVal) {
				return new StringVal(this.toString() + v.toString());
			}
			return new UndefinedVal();
    	case EQ:
    		if (v instanceof NullVal || v instanceof UndefinedVal){    			
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case NEQ:
    		if (v instanceof NullVal || v instanceof UndefinedVal){    			
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case S_EQ:
    		if (v instanceof UndefinedVal){
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case S_NEQ:
    		if (v instanceof UndefinedVal){
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case AND:
    		return new UndefinedVal();
    	case OR:
    		return v;    
		default:
			return new UndefinedVal();
        }
	};
}

/**
 * Boolean values.
 */
class BoolVal implements Value {
	private boolean boolVal;
	public BoolVal(boolean b) { 
		this.boolVal = b;
	}
	public boolean toBoolean() { return this.boolVal; }
	@Override
	public boolean equals(Object that) {
		if (that instanceof BoolVal){
			return this.boolVal == ((BoolVal) that).boolVal;
		}		
		return false;
	}
	@Override
	public String toString() {
		return "" + this.boolVal;
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			if (v instanceof StringVal) {
				return new StringVal(this.toString() + v.toString());
			}
			return new UndefinedVal();
    	case EQ:
    		if ((v instanceof BoolVal && boolVal == ((BoolVal) v).boolVal) 
    				|| (boolVal == false && v instanceof IntVal && ((IntVal) v).toInt() == 0)
    				|| (boolVal == true && v instanceof IntVal && ((IntVal) v).toInt() != 0)
    				|| v instanceof NullVal 
    				|| v instanceof UndefinedVal) {
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case NEQ:
    		if ((v instanceof BoolVal && boolVal == ((BoolVal) v).boolVal) 
    				|| (boolVal == false && v instanceof IntVal && ((IntVal) v).toInt() == 0)
    				|| (boolVal == true && v instanceof IntVal && ((IntVal) v).toInt() != 0)
    				|| v instanceof NullVal 
    				|| v instanceof UndefinedVal) {
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case S_EQ:
    		if (v instanceof BoolVal && boolVal == ((BoolVal) v).boolVal) {
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case S_NEQ:
    		if (v instanceof BoolVal && boolVal == ((BoolVal) v).boolVal) {
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case AND:
    		if (boolVal){
    			return v;
    		}
    		return this;
    	case OR:
    		if (boolVal){
    			return this;
    		}
    		return v;    
		default:
			return new UndefinedVal();
        }
	};
}

/**
 * String values.
 */
class StringVal implements Value {
	private String stringVal;
	public StringVal(String s) { 
		this.stringVal = s;
	}
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof StringVal)) return false;
		return this.stringVal.equals(((StringVal) that).stringVal);
	}
	@Override
	public String toString() {
		return this.stringVal;
	}
	@Override
	public String toScreen() {
		return "\"" + this.toString() + "\"";
	}	
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			return new StringVal(this.toString() + v.toString());
    	case EQ:
    		if (stringVal.equals(v.toString())){
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case NEQ:
    		if (stringVal.equals(v.toString())){
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case S_EQ:
    		if (v instanceof StringVal && stringVal.equals(v.toString())){
    			return new BoolVal(true);
    		}
    		return new BoolVal(false);
    	case S_NEQ:
    		if (v instanceof StringVal && stringVal.equals(v.toString())){
    			return new BoolVal(false);
    		}
    		return new BoolVal(true);
    	case AND:
    		if (stringVal.length() == 0){
    			return new NullVal();    			
    		}
    		return v;
    	case OR:
    		if (stringVal.length() == 0){
    			return v;    			
    		}
    		return this;    
		default:
			return new UndefinedVal();
        }
		
	};
}

/**
 * Numbers.  Only integers are supported.
 */
class IntVal implements Value {
	private long i;
	public IntVal(long i) {
		this.i = i;
	}
	public long toInt() { 
		return this.i; 
	}
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof IntVal)) return false;
		return this.i == ((IntVal) that).i;
	}
	@Override
	public String toString() {
		return "" + this.i;
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	@Override
	public Value applyOp(Operator op) {
		switch(op) {
		case ADD:
			return this;
        case SUB:
        	return new IntVal(-1 * i);
        default:
        	return new UndefinedVal();
		}
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		long val;
		if (v instanceof IntVal) {
			val = ((IntVal)v).i;
		} else if (v instanceof BoolVal) {
			val = ((BoolVal)v).toBoolean() ? 1 : 0;
		} else if (v instanceof StringVal) {
			try {
				val = Long.parseLong(((StringVal)v).toString(), 10); 
			} catch ( NumberFormatException e) {
				val = 0;
			}
		} else {
			val = 0;
		}
		switch(op) {
		case ADD:
			if (v instanceof StringVal) {
				return new StringVal(this.toString() + v.toString());
			}
			return new IntVal(i + val);
        case SUB:
        	return new IntVal(i - val);
    	case MUL:
    		return new IntVal(i * val);
    	case DIV:
    		return new IntVal(i / val);
    	case MOD:
    		return new IntVal(i % val);
    	case GT:
    		return new BoolVal(i > val);
    	case GE:
    		return new BoolVal(i >= val);
    	case LT:
    		return new BoolVal(i < val);
    	case LE:
    		return new BoolVal(i <= val);
    	case EQ:
    		return new BoolVal(i == val);
    	case NEQ:
    		return new BoolVal(i != val);
    	case S_EQ:
    		if (v instanceof IntVal && ((IntVal)v).i == i){
    			return new BoolVal(true); 
    		}
    		return new BoolVal(false); 
    	case S_NEQ:
    		if (v instanceof IntVal && ((IntVal)v).i == i){
    			return new BoolVal(false); 
    		}
    		return new BoolVal(true); 
    	case AND:
    		if (i == 0){
    			return this;    			
    		}
    		return v;
    	case OR:
    		if (i == 0){
    			return v;    			
    		}
    		return this; 
		default:
			return new BoolVal(false);
        }
	};
}

/**
 * Array Value
 */
class ArrayVal implements Value {
    private List<Value> lst;
    public ArrayVal() {
        this.lst = new ArrayList<Value>();
    }
    public Value getProp(Value prop) {
    	if (!(prop instanceof IntVal)){
    		
    	}
    	IntVal idx = (IntVal)prop;
    	return lst.get((int)idx.toInt());
    }
    public void addElem(Value v) {
    	lst.add(v);
    }
    public void set(Value idx, Value val) {
    	if (!(idx instanceof IntVal)){
    		throw new RuntimeException("Invalid variable type.");
    	}
    	long index = ((IntVal)idx).toInt();
    	lst.set((int)index, val);
    }
    public Value getLength() {
    	Value length = new IntVal(lst.size());
    	return length;
    }
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		ArrayVal array = new ArrayVal();
		for (Value v : lst){
			Value val = v.project(perms);
			array.addElem(val);
		}
		return array;
	}
	@Override
	public String toString() {
		String str = "[";
		String sep = "";
		for (Value v : lst){
			str += sep + v.toScreen();
			sep = ", ";
		}
		str += "]";
		return str;
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			return new StringVal(this.toString() + v.toString());
    	case EQ:
    	case S_EQ:
    		return new BoolVal(this == v);
    	case NEQ:
    	case S_NEQ:
    		return new BoolVal(this != v);
    	case AND:
    		return v;
    	case OR:
    		return this; 
		default:
			return new UndefinedVal();
        }
	};
}

/**
 * Object Value
 */
class ObjectVal implements Value {
	private HashMap<String, Value> hm;
	public ObjectVal() {
		this.hm = new HashMap<String, Value>();
	}
    public Value getPropById(String propId) {
    	if (hm.containsKey(propId)){
    		return hm.get(propId);
    	}
    	return new UndefinedVal();
    }
    public void set(String propId, Value v) {
    	hm.put(propId, v);
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		ObjectVal obj = new ObjectVal();
		for (Entry<String, Value> entry : hm.entrySet()) {
			String key = entry.getKey();
			Value val = hm.get(key).project(perms);
			obj.set(key, val);
		}
		return obj;
	}
	@Override
	public String toString() {
		String str = "{";
		String sep = "";
		for (Entry<String, Value> entry : hm.entrySet()) {
			String key = entry.getKey();
			Value v = entry.getValue();
			str += sep + key + ": " + v.toScreen();
			sep = ", ";	
		}
		str += "}";
		return str;
	}
	@Override
	public Value applyOp(Operator op, Value v) {		
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			return new StringVal(this.toString() + v.toString());
    	case EQ:
    	case S_EQ:
    		return new BoolVal(this == v);
    	case NEQ:
    	case S_NEQ:
    		return new BoolVal(this != v);
    	case AND:
    		return v;
    	case OR:
    		return this; 
		default:
			return new UndefinedVal();
        }
	};
}

class ReturnVal implements Value {
	private Value v;
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm pc) {
		return this;
	}
	public  ReturnVal(Value v){
		this.v = v;
	}
	public Value toVal() { return this.v; }
}

/**
 * A closure value
 * Note that a closure remembers its surrounding scope.
 */
class ClosureVal implements Value {
	private List<String> params;
	private Statement body;
	private Environment outerEnv;
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		return this;
	}
	@Override
	public Value project(Perm perms) {
		return this;
	}
	/**
	 * The environment is the environment where the function was created.
	 * This design is what makes this expression a closure.
	 */
	public ClosureVal(List<String> params, Statement body, Environment env) {
		this.params = params;
		this.body = body;
		this.outerEnv = env;
	}
	public String toString() {
		String s = "function(";
		String sep = "";
		for (int i=0; i<params.size(); i++) {
			s += sep + params.get(i);
			sep = ",";
		}
		s += ") {...};";
		return s;
	}
	/**
	 * To apply a closure, first create a new local environment, with an outer scope
	 * of the environment where the function was created. Each parameter should
	 * be bound to its matching argument and added to the new local environment.
	 * NOTE: the environment passed into this function is ignored.
	 */
	public Value apply(ReturnType returnType, List<Value> argVals, Environment doNotUseThisEnvironment, ProgramCounter pc, boolean s) {
		Environment newEnv = new Environment(outerEnv);
		for (int i=0; i<argVals.size(); i++) {
			String varName = params.get(i);
			Value v = argVals.get(i);
			newEnv.createVar(varName, v, s);
		}
		newEnv.createVar("this", new ObjectVal(), s);
		Value r = body.evaluate(newEnv, pc, s);
		if (returnType == ReturnType.OBJECT){
			Value thisObj = newEnv.resolveVar("this");
			return thisObj;
		}
		if (r instanceof ReturnVal){
			Value returnVal = ((ReturnVal) r).toVal();
			return returnVal;
		}
		return new UndefinedVal();
	}
	@Override
	public Value applyOp(Operator op, Value v) {		
		if (v instanceof FacetedVal){
			return FacetedValFactory.applyFacetedOp(this, op, v);			
		}
		switch(op) {
		case ADD:
			return new StringVal(this.toString() + v.toString());
    	case EQ:
    	case S_EQ:
    		return new BoolVal(this == v);
    	case NEQ:
    	case S_NEQ:
    		return new BoolVal(this != v);
    	case AND:
    		return v;
    	case OR:
    		return this; 
		default:
			return new UndefinedVal();
        }
	};
}

/**
 * A faceted value.
 * < k ? hi : lo>
 */
class FacetedVal implements Value {
	private String k;
	private Value hi;
	private Value lo;
	
	public String getLabel() { return k; }
	public Value getLeft() { return hi; }
	public Value getRight() { return lo; }

	public FacetedVal(String k, Value hi, Value lo) {
		this.k = k;
		this.hi = hi;
		this.lo = lo;
	}
	@Override
	public boolean equals(Object that) {
		if (that instanceof FacetedVal) {
			FacetedVal thatFv = (FacetedVal) that;
			return k.equals(thatFv.k) && hi.equals(thatFv.hi) && lo.equals(thatFv.lo);
		}
		return false;
	}
	@Override
	public String toString() {
		String h = hi.toScreen();
		String l = lo.toScreen();
//		String h = hi instanceof StringVal ? "\"" + hi + "\"" : hi.toString();
//		String l = lo instanceof StringVal ? "\"" + lo + "\"" : lo.toString();
		return "< " + k + " ? " + h + " : " + l + " >";
	}
	@Override
	public Value eliminateFace(ProgramCounter pc) {
		// need optimize
		Branch fv = pc.checkExecType(k);
		if (fv == Branch.LEFT) return hi.eliminateFace(pc);
		if (fv == Branch.RIGHT) return lo.eliminateFace(pc);
		Value hiBranch = hi.eliminateFace(pc);
		Value loBranch = lo.eliminateFace(pc);
		return new FacetedVal(k, hiBranch, loBranch);
	}
	@Override
	public Value project(Perm perms) {
		return perms.has(k) ? hi.project(perms) : lo.project(perms);
	}
	@Override
	public Value applyOp(Operator op, Value v) {
		// build facet (checking)
		if (v instanceof FacetedVal) {
			FacetedVal fv =  (FacetedVal)v;
			return FacetedValFactory.buildFacet(k, hi.applyOp(op, fv), lo.applyOp(op, fv));
		}
		// build facet (no checking)
		return FacetedValFactory.build(k, hi.applyOp(op, v), lo.applyOp(op, v));
	};
}

/**
 * A faceted value Factory.
 * build optimized faceted value
 */
class FacetedValFactory {
	// create facet value
	public static Value build(String k, Value hi, Value lo) {
		return hi.equals(lo) ? hi : new FacetedVal(k, hi, lo);
	}
	// build secure value - need optimize
	public static Value buildFacet(String k, Value hi, Value lo) {
		FacetedVal fv = new FacetedVal(k, hi, lo);
		Value v = optimizedVal(new ProgramCounter(), fv);
		return v;
	}
	private static Value optimizedVal(ProgramCounter pc, Value v) {
		if (v instanceof FacetedVal) {
			FacetedVal fv = (FacetedVal)v;
			String k = fv.getLabel();
			Value left = fv.getLeft();
			Value right = fv.getRight();
			
			switch (pc.checkExecType(k)) {
			case LEFT:
				return optimizedVal(pc.add(k, true), left);
			case RIGHT:
				return optimizedVal(pc.add(k, false), right);
			case SPLIT:
				Value lBch = optimizedVal(pc.add(k, true), left);
				Value rBch = optimizedVal(pc.add(k, false), right);
				return FacetedValFactory.build(k, lBch, rBch);
			}
		}
		return v;
	}
	
	// build secure assignment value (by Program Counter)
	public static Value updateFacet(ProgramCounter pc, Value v, Value oldV) {
		return updateFacet(pc.buildList(), v, oldV);
	}
	private static Value updateFacet(List<ProgramCounter> pcLst, Value v, Value oldV) {
		if (pcLst.isEmpty()) {
			return v;
		}
		ProgramCounter p = pcLst.get(0);
		String label = p.getLabel();
		pcLst.remove(0);
		Value acc = oldV.eliminateFace(new ProgramCounter(label, p.isPriv()));
		Value fv = updateFacet(pcLst, v, acc);
		if (p.isPriv()){
			Value oldBranch = oldV.eliminateFace(new ProgramCounter(label, false));
			return new FacetedVal(label, fv, oldBranch);
		} else {
			Value oldBranch = oldV.eliminateFace(new ProgramCounter(label, true));
			return new FacetedVal(label, oldBranch, fv);
		}
	}
	
	// apply a Faceted Value Operation on a non-Faceted value
	public static Value applyFacetedOp(Value fst, Operator op, Value snd){
		if (snd instanceof FacetedVal) {
			FacetedVal fv = (FacetedVal)snd;
			Value l = fv.getLeft();
			Value r = fv.getRight();
			return FacetedValFactory.build(fv.getLabel(), fst.applyOp(op, l), fst.applyOp(op, r));
		}
		return new UndefinedVal();
	}
}