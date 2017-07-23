package com.helper.mani.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.helper.mani.grammar.JavaBaseVisitor;
import com.helper.mani.grammar.JavaParser;
import com.helper.mani.grammar.JavaParser.AnnotationContext;
import com.helper.mani.grammar.JavaParser.ClassOrInterfaceTypeContext;
import com.helper.mani.grammar.JavaParser.PrimitiveTypeContext;
import com.helper.mani.grammar.JavaParser.QualifiedNameContext;
import com.helper.mani.grammar.JavaParser.TypeArgumentContext;
import com.helper.mani.grammar.JavaParser.TypeArgumentsContext;
import com.helper.mani.grammar.JavaParser.TypeBoundContext;
import com.helper.mani.grammar.JavaParser.TypeParameterContext;
import com.helper.mani.grammar.JavaParser.TypeTypeContext;

public class ExpressionVisitor extends JavaBaseVisitor<String> {
	public String visitModifier(JavaParser.ModifierContext ctx) {
		if (ctx.classOrInterfaceModifier() != null) {
			return this.visitClassOrInterfaceModifier(ctx.classOrInterfaceModifier());
		} else {
			return ctx.getText();
		}
	}

	public String visitClassOrInterfaceModifier(JavaParser.ClassOrInterfaceModifierContext ctx) {
		AnnotationContext annotation = ctx.annotation();
		if (annotation != null) {
			// Left for next release
			// Return empty string instead of Null
			return "";
		} else {
			return ctx.getText();
		}

	}

	public String visitVariableModifier(JavaParser.VariableModifierContext ctx) {
		if (ctx.annotation() != null) {
			// Left for next release
			return "";
		} else {
			return ctx.getText();
		}
	}

	public String visitTypeParameters(JavaParser.TypeParametersContext ctx) {
		List<String> typParams = new ArrayList<>(0);
		List<TypeParameterContext> typParamsCtx = ctx.typeParameter();
		if (!typParamsCtx.isEmpty()) {
			typParams = typParamsCtx.stream().filter(t -> t != null).map(t -> this.visitTypeParameter(t)).collect(Collectors.toList());
		}
		return typParams.stream().collect(Collectors.joining(",", "<", ">"));
	}

	public String visitTypeParameter(JavaParser.TypeParameterContext ctx) {
		StringBuilder typParam = new StringBuilder(ctx.Identifier().getText());
		TypeBoundContext typBoundCtx = ctx.typeBound();
		if(typBoundCtx!=null){
			String typeBound = this.visitTypeBound(typBoundCtx);
			typParam.append(" ").append("extends").append(typeBound);
		}
		return typParam.toString();
	}

	public String visitTypeBound(JavaParser.TypeBoundContext ctx) {
		List<TypeTypeContext> typtypCtx = ctx.typeType();
		String typtyp = "";
		if(typtypCtx!=null){
			typtyp = typtypCtx.stream()
					.filter(t -> t!=null)
					.map(t -> this.visitTypeType(t))
					.collect(Collectors.joining(" & "));
		}
		return typtyp;
	}

	public String visitTypeList(JavaParser.TypeListContext ctx) {
		List<TypeTypeContext> typtypCtx = ctx.typeType();
		String typtyp = "";
		if(typtypCtx!=null){
			typtyp = typtypCtx.stream()
					.filter(t -> t!=null)
					.map(t -> this.visitTypeType(t))
					.collect(Collectors.joining(" , "));
		}
		return typtyp;
	}

	public String visitTypeType(JavaParser.TypeTypeContext ctx) {
		StringBuilder typTyp = new StringBuilder("");
		ClassOrInterfaceTypeContext coitCtx = ctx.classOrInterfaceType();
		PrimitiveTypeContext ptCtx = ctx.primitiveType();
		//TokenStream tokens = parser
		if(coitCtx!=null){
			typTyp.append(this.visitClassOrInterfaceType(coitCtx));
			//ctx.getRuleContext(ctxType, i)
			//Todo : Code for []*
		}
		else if(ptCtx!=null){
			typTyp.append(ptCtx.getText());
			//Todo : Code for []*
		}
		return typTyp.toString();
	}

	public String visitClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
		StringBuilder clsIntr = new StringBuilder("");
		//List<TerminalNode> idTns = ctx.Identifier();
		int n = ctx.getChildCount();
		for(int i = 0; i < n; i++){
			
			TerminalNode id = ctx.Identifier(i);
			if(id!=null){
				clsIntr.append(id.getText()).append(" ");
			}
			TypeArgumentsContext typArgCtx =ctx.typeArguments(i);
			if(typArgCtx!=null){
				String val = this.visitTypeArguments(typArgCtx);
				clsIntr.append(val);
			}
		}
		return clsIntr.toString();
	}

	

	public String visitPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
		return ctx.getText();
	}

	public String visitTypeArguments(JavaParser.TypeArgumentsContext ctx) {
		String typeArguments = "";
		List<TypeArgumentContext> typArgsCtx =ctx.typeArgument();
		if(typArgsCtx!=null){
			typeArguments = typArgsCtx.stream()
			.filter(t -> t!=null)
			.map(t -> visitTypeArgument(t))
			.collect(Collectors.joining(" , ", "<", ">"));
			
		}
		return typeArguments;
	}

	public String visitTypeArgument(JavaParser.TypeArgumentContext ctx) {
		//TypeTypeVisitor visitor = new TypeTypeVisitor();
		TypeTypeContext typTypCtx = ctx.typeType();	
		//TODO: Check for second rule  '?' (('extends' | 'super') typeType)?
		 return this.visitTypeType(typTypCtx);
	}

	public String visitQualifiedNameList(JavaParser.QualifiedNameListContext ctx) {
		List<QualifiedNameContext> qnsCtx = ctx.qualifiedName();
		String qnList = "";
		if(qnsCtx!=null){
		qnList = qnsCtx.stream()
		.filter(qn-> qn!=null)
		.map(qn -> this.visitQualifiedName(qn))
		.collect(Collectors.joining(" , "));
		}
		return qnList;
	}
	
	public String visitQualifiedName(JavaParser.QualifiedNameContext ctx) {
		List<TerminalNode> idTns = ctx.Identifier();
		String qn = "";
		if(idTns!=null){
			qn = idTns.stream()
					.filter(i -> i!=null)
					.map(i -> i.getText())
					.collect(Collectors.joining("."));
		}
		return qn; 
	}

}
