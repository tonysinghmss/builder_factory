package com.helper.mani.domain;

import java.util.List;

public class ClassBody {
	private List<String> modifiers;
	private List<Method> methods;
	private List<Constructor> constructors;
	//private List<String> fields;
	public List<String> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}
	public List<Method> getMethods() {
		return methods;
	}
	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}
	public List<Constructor> getConstructors() {
		return constructors;
	}
	public void setConstructors(List<Constructor> constructors) {
		this.constructors = constructors;
	}
	
}
