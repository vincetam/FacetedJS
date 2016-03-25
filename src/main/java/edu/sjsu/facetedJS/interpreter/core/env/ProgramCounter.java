package edu.sjsu.facetedJS.interpreter.core.env;

import java.util.ArrayList;
import java.util.List;
/**
 * program counter
 * to keep track of the variable in different branches
 */
public class ProgramCounter {
	private String label;
	private boolean priv;
	private ProgramCounter parent;
	
	public ProgramCounter() {}
	public ProgramCounter(String label, boolean priv) {
		this.label = label;
		this.priv = priv;
		this.parent = new ProgramCounter();
	}
	public ProgramCounter add(String label, boolean priv) {
		return new ProgramCounter(label, priv, this);
	}
	private ProgramCounter(String label, boolean priv, ProgramCounter parent) {
		this.label = label;
		this.priv = priv;
		this.parent = parent;
	}
	@Override
	public String toString() {
		return priv ? label : label+"'";
	}
	
	/**
     * split into two branches if needed
     */
	public Branch checkExecType(String label){
		// PC root
		if (parent == null) return Branch.SPLIT;
		
		// PC children
		if (this.label.equals(label)){
			if (this.priv){
				return Branch.LEFT;
			} else {
				return Branch.RIGHT;
			}
		}
		// check parents
		return parent.checkExecType(label);
	}

	public String getLabel() {
		return label;
	}
	
	public boolean isPriv() {
		return priv;
	}

	public List<ProgramCounter> buildList() {
		if (parent == null) return new ArrayList<ProgramCounter>();
		List<ProgramCounter> lst = this.parent.buildList();
		lst.add(this);
		return lst;
	}
	public boolean visibleTo(Perm perms) {
		if (parent == null) return true;
		if (priv){
			if (perms.has(label)){
				return parent.visibleTo(perms);
			}else{
				return false;
			}
		}else{
			if (perms.has(label)){
				return false;
			}else{
				return parent.visibleTo(perms);
			}
		}
	}
}