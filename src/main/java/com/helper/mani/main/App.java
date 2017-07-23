package com.helper.mani.main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.helper.mani.grammar.JavaLexer;
import com.helper.mani.grammar.JavaParser;
import com.helper.mani.visitor.CompilationUnitVisitor;

public class App {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("/home/tony/TLAB/Jworkspace/builder_factory/src/main/java/com/helper/mani/visitor/ClassVisitor.java");
		try (InputStream fis = Files.newInputStream(path)) {
			CharStream charStream = new ANTLRInputStream(fis);
			JavaLexer lexer = new JavaLexer(charStream);
			TokenStream tokens = new CommonTokenStream(lexer);
			JavaParser parser = new JavaParser(tokens);
			ParseTree tree = parser.compilationUnit();
			//System.out.println(tree.toStringTree(parser));
			//System.out.println(tree.toStringTree());
			CompilationUnitVisitor cmpUntVisitor = new CompilationUnitVisitor();
			cmpUntVisitor.visit(tree);
			//tree.accept(cmpUntVisitor);
			//System.out.println(a);
		}

	}

}
