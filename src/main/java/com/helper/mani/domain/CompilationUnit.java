package com.helper.mani.domain;

import java.util.List;

public class CompilationUnit {
	private String packageName;
	private List<String> importStatements;
	private List<TypeDeclaration> typeDeclarations;
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<String> getImportStatements() {
		return importStatements;
	}
	public void setImportStatements(List<String> importStatements) {
		this.importStatements = importStatements;
	}
	public List<TypeDeclaration> getTypeDeclarations() {
		return this.typeDeclarations;
	}
	public void setTypeDeclarations(List<TypeDeclaration> typeDeclaration) {
		this.typeDeclarations = typeDeclaration;
	}	
}
