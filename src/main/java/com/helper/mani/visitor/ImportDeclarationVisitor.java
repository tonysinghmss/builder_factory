package com.helper.mani.visitor;

import org.antlr.v4.runtime.TokenStream;

import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;

public class ImportDeclarationVisitor extends JavaBaseVisitor<String> {
	private TokenStream tokens;
	public ImportDeclarationVisitor(TokenStream tokens) {
		this.tokens = tokens;
	}

	public String visitImportDeclaration(JavaParser.ImportDeclarationContext ctx) { 
		//TODO: Refactoring needed
		return ctx.getText();
	}
}
