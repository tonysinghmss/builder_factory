package com.helper.mani.domain;

import java.util.List;

public class Clazz {
	private String identifier;
	/*private String packageName;
	private List<String> importStatements;*/
	private List<String> typeParams;
	private String typeType;
	private List<String> typeList;
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public List<String> getTypeParams() {
		return typeParams;
	}
	public void setTypeParams(List<String> typeParams) {
		this.typeParams = typeParams;
	}
	public String getTypeType() {
		return typeType;
	}
	public void setTypeType(String typeType) {
		this.typeType = typeType;
	}
	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
	
}
