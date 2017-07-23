package com.helper.mani.domain;

import java.util.List;

public class TypeDeclaration {
	private List<String> clsIntfModifiers;
	private Clazz clazz;
	
	
	public List<String> getClsIntfModifiers() {
		return clsIntfModifiers;
	}
	public void setClsIntfModifiers(List<String> clsIntfModifiers) {
		this.clsIntfModifiers = clsIntfModifiers;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
}
