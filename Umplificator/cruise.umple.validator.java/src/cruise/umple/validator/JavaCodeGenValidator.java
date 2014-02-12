package cruise.umple.validator;

import java.util.List;

import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.java.JavaClassGenerator;

public class JavaCodeGenValidator implements CodeGenValidator {

	@Override
	public  boolean validateGeneratedCode(String uFilename) {
        UmpleFile umpleFile = new UmpleFile(uFilename);
	    UmpleModel model = new UmpleModel(umpleFile);
	    model.run();
	    model.generate();
	    
	    JavaClassGenerator generator = new JavaClassGenerator();
	    
	    UmpleClass hasTime = model.getUmpleClass("Test");
	    String code = generator.getCode(model,hasTime);
		CompilationUnit unit = parse(code);
		IProblem[] problems = unit.getProblems();
		if( problems == null || problems.length > 0){
			for (IProblem problem : problems ){
				System.out.print(problem);	
			}
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateGeneratedCode(List<String> uFiles) {
		// TODO Auto-generated method stub
		return false;
	}

	protected static CompilationUnit parse(String source) {
		ASTParser parser = ASTParser.newParser(AST.JLS3); 
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(source.toCharArray()); // set source
		parser.setResolveBindings(true); // we need bindings later on
		return (CompilationUnit) parser.createAST(null);
	}

}
