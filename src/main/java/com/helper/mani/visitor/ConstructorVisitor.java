package com.helper.mani.visitor;

import com.helper.mani.domain.Constructor;
import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;

public class ConstructorVisitor extends JavaBaseVisitor<Constructor>{
	
	public Constructor visitConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx){
		String cons = ctx.getPayload().getText();
		System.out.println(cons);
		return null;
	}

}
