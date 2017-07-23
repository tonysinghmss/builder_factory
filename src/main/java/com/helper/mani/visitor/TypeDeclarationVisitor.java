package com.helper.mani.visitor;

import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.TokenStream;

import com.helper.mani.domain.Clazz;
import com.helper.mani.domain.TypeDeclaration;
import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;
import com.helper.mani.grammar.JavaParser.ClassDeclarationContext;
import com.helper.mani.grammar.JavaParser.ClassOrInterfaceModifierContext;

public class TypeDeclarationVisitor extends JavaBaseVisitor<TypeDeclaration> {
	private TokenStream tokens;
	public TypeDeclarationVisitor(TokenStream tokens) {
		this.tokens = tokens;
	}

	public TypeDeclaration visitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) { 
		TypeDeclaration td = new TypeDeclaration();
		ExpressionVisitor modExpVisitor = new ExpressionVisitor(this.tokens);
		List<ClassOrInterfaceModifierContext> clsIntfModsCtx = ctx.classOrInterfaceModifier();
		if(clsIntfModsCtx!=null){
			List<String> clsIntfMods = clsIntfModsCtx.stream()
				.filter(c -> c!=null)
				.map(c -> c.accept(modExpVisitor))
				.collect(Collectors.toList());
			td.setClsIntfModifiers(clsIntfMods);
		}
		//Class declaration
		ClassDeclarationContext cdCtx = ctx.classDeclaration();
		if(cdCtx!=null){
			ClassVisitor visitor = new ClassVisitor(this.tokens);
			Clazz cls = cdCtx.accept(visitor);
			td.setClazz(cls);
		}
		//enum, annotation left for next release 
		return td;
	}
}
