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
	JavaClassVisitor umple_visitor =  new JavaClassVisitor();
	
	@Before
	public void setUp() throws Exception {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/");
		File testFile = new File(pathToInput+"javavisitor_test.txt");
		String code = SampleFileWriter.readContent(testFile);
		File umpleFile = new File(pathToInput+"umplevisitor_test.ump");
		String umpleCode = SampleFileWriter.readContent(umpleFile);
	   	JavaParser javaParser = new JavaParser(visitor);
		javaParser.parseUnit(code);
		JavaParser umpleParser = new JavaParser(umple_visitor);
		umpleParser.parseUnit(umpleCode);
	}
	
	@Test
	public void field_declarations_returned_in_java_file()
	{
		 Assert.assertEquals(7, visitor.numberOfFieldDeclarations());
	}
	
	@Test
	public void field_declarations_returned_in_umple_file()
	{
		 Assert.assertEquals(4, umple_visitor.numberOfFieldDeclarations());
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
