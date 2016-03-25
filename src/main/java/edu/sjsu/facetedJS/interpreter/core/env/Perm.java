package edu.sjsu.facetedJS.interpreter.core.env;

import java.util.HashSet;

/**
 * Permission
 * consisiting a list of security label
 */

public class Perm {
	private HashSet<String> perms;
	
	public Perm(){
		perms = new HashSet<String>();
	}
	
	// add permission to the list
	public Perm add(String perm){
		perms.add(perm);
		return this;
	}
	
	// check for permission
	public boolean has(String perm){
		return perms.contains(perm);
	}
}
