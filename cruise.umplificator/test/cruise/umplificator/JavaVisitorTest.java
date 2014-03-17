package cruise.umplificator;

import java.io.File;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;
import cruise.umplificator.parser.JavaParser;
import cruise.umplificator.visitor.JavaClassVisitor;

public class JavaVisitorTest {

	String pathToInput;
	JavaClassVisitor visitor = new JavaClassVisitor();
	
	@Before
	public void setUp() throws Exception {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/javavisitor_test.txt");
		File testFile = new File(pathToInput);
		String code = SampleFileWriter.readContent(testFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit compilationUnit = javaParser.parseUnit(code);
    	visitor = new JavaClassVisitor();
    	compilationUnit.accept(visitor);
	}
	
	@Test
	public void imports_returned()
	{
		int nbImports = visitor.numberOfImportDeclarations();
		 Assert.assertEquals(1, nbImports);
	}
	
	
	@Test
	public void methods_returned()
	{
		int nbMethods = visitor.numberOfMethodDeclarations();
		 Assert.assertEquals(2, nbMethods);
	}
	
}
