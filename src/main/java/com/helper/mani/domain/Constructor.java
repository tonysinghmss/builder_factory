package com.helper.mani.domain;

import java.util.List;

public class Constructor {
	private String identifier;
	//private List<String> modifiers;
	//private String returnType;
	private List<String> formalParameters;
	private List<String> throwsList;
	private String construtorBody;
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	/*public List<String> getModifiers() {
		return modifiers;
	}
	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}*/
	public List<String> getFormalParameters() {
		return formalParameters;
	}
	public void setFormalParameters(List<String> formalParameters) {
		this.formalParameters = formalParameters;
	}
	public List<String> getThrowsList() {
		return throwsList;
	}
	public void setThrowsList(List<String> throwsList) {
		this.throwsList = throwsList;
	}
	public String getConstrutorBody() {
		return construtorBody;
	}
	public void setConstrutorBody(String construtorBody) {
		this.construtorBody = construtorBody;
	}
	
}
