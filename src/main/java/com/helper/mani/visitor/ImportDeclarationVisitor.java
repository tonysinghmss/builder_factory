package com.helper.mani.visitor;

import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;

public class ImportDeclarationVisitor extends JavaBaseVisitor<String> {
	public String visitImportDeclaration(JavaParser.ImportDeclarationContext ctx) { 
		//TODO: Refactoring needed
		return ctx.getText();
	}
}
