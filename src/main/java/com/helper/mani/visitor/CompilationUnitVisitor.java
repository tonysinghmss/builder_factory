package com.helper.mani.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.helper.mani.domain.CompilationUnit;
import com.helper.mani.domain.TypeDeclaration;
import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;
import com.helper.mani.grammar.JavaParser.ImportDeclarationContext;
import com.helper.mani.grammar.JavaParser.PackageDeclarationContext;
import com.helper.mani.grammar.JavaParser.TypeDeclarationContext;

public class CompilationUnitVisitor extends JavaBaseVisitor<CompilationUnit> {
	
	@Override
	public CompilationUnit visitCompilationUnit(JavaParser.CompilationUnitContext ctx) {		
		CompilationUnit cu = new CompilationUnit();
		PackageDeclarationContext pkgCtx = ctx.packageDeclaration();
		if(pkgCtx!=null){
			PackageDeclarationVisitor visitor = new PackageDeclarationVisitor();
			String pkg = pkgCtx.accept(visitor);
			cu.setPackageName(pkg);
		}
		List<String> imports = new ArrayList<>(0);
		ImportDeclarationVisitor imprtVisitor = new ImportDeclarationVisitor();
		List<ImportDeclarationContext> imprtsctx = ctx.importDeclaration();
		if(imprtsctx!=null){
			imports = imprtsctx.stream()
					.filter(i -> i!=null)
					.map(i -> i.accept(imprtVisitor))
					.collect(Collectors.toList());
		}
		cu.setImportStatements(imports);
		List<TypeDeclarationContext> typDeclrsCtx = ctx.typeDeclaration();
		List<TypeDeclaration> typDeclrs = new ArrayList<>(0);
		if(typDeclrsCtx!=null){
			TypeDeclarationVisitor visitor = new TypeDeclarationVisitor();
			typDeclrs = typDeclrsCtx.stream()
					.filter(t -> t!=null)
					.map(t -> t.accept(visitor))
					.collect(Collectors.toList());
			
		}
		cu.setTypeDeclarations(typDeclrs);
		return cu;
	}
	
	
	/*@Override
	public String visitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) { 
		List<ClassOrInterfaceModifierContext> modifiers = ctx.classOrInterfaceModifier();
		for(ClassOrInterfaceModifierContext mod : modifiers){
			System.out.println(mod.getText());
		}
		ClassDeclarationContext clazzCtx = ctx.classDeclaration();
		ClassVisitor classVisitor = new ClassVisitor();
		classVisitor.visit(clazzCtx);
		return null;
	}*/
	
}
