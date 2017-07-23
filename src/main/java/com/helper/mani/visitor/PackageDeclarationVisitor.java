package com.helper.mani.visitor;

import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;

public class PackageDeclarationVisitor extends JavaBaseVisitor<String> {
	public String visitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
		return ctx.getText();
	}
}
