package com.helper.mani.visitor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.TokenStream;

import com.helper.mani.domain.Clazz;
import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;
import com.helper.mani.grammar.JavaParser.ClassBodyContext;
import com.helper.mani.grammar.JavaParser.TypeListContext;
import com.helper.mani.grammar.JavaParser.TypeParameterContext;
import com.helper.mani.grammar.JavaParser.TypeParametersContext;
import com.helper.mani.grammar.JavaParser.TypeTypeContext;

public class ClassVisitor extends JavaBaseVisitor<Clazz>{
	private TokenStream tokens;
	
	public ClassVisitor(TokenStream tokens) {
		this.tokens = tokens;
	}

	public Clazz visitClassDeclaration(JavaParser.ClassDeclarationContext ctx){
		Clazz clz = new Clazz();
		clz.setIdentifier(ctx.Identifier().getText());
		ExpressionVisitor expVisitor = new ExpressionVisitor(this.tokens);
		//Type parameters 
		TypeParametersContext typPrmsCtx = ctx.typeParameters();
		if(typPrmsCtx!=null && !typPrmsCtx.isEmpty()){
			List<TypeParameterContext> typPrmCtx = typPrmsCtx.typeParameter();
			List<String> typPrmList = typPrmCtx.stream()
			.filter(t -> t!=null)
			.map(t -> expVisitor.visitTypeParameter(t))
			.collect(Collectors.toList());
			clz.setTypeParams(typPrmList);
		}
		//extends TypeType
		TypeTypeContext typtypCtx = ctx.typeType();
		if(typtypCtx!=null){
			String typtypStr = expVisitor.visitTypeType(typtypCtx);
			clz.setTypeType(typtypStr);
		}
		// implements TypeList
		TypeListContext typListCtx = ctx.typeList();
		if(typListCtx!=null){
			String typeListStr = expVisitor.visitTypeList(typListCtx);
			List<String> typeList = Arrays.asList(typeListStr.split(","));
			clz.setTypeList(typeList);
		}
		ClassBodyContext clsBdyCtx = ctx.classBody();
		if(clsBdyCtx!=null){
			System.out.println(clsBdyCtx.getText());
		}
		//System.out.println(clz);
		return null;
	}
	
	//public 
}
