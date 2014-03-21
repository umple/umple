package cruise.umplificator;

import java.io.File;
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
	   	visitor = new JavaClassVisitor();
		JavaParser javaParser = new JavaParser(visitor);
		javaParser.parseUnit(code);
	}
	
	@Test
	public void imports_returned()
	{
		int nbImports = visitor.numberOfImportDeclarations();
		 Assert.assertEquals(3, nbImports);
	}
	
	@Test
	public void packages_returned()
	{
		String packageName = visitor.getPackageDeclaration().getName().getFullyQualifiedName();
		Assert.assertEquals("cruise.umplificator", packageName);
	}
	
	
	@Test
	public void methods_returned()
	{
		int nbMethods = visitor.numberOfMethodDeclarations();
		 Assert.assertEquals(3, nbMethods);
	}
	
}
