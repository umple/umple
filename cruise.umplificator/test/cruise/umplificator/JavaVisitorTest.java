package cruise.umplificator;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.util.SampleFileWriter;
import cruise.umplificator.parser.JavaParser;
import cruise.umplificator.visitor.JavaClassVisitor;

public class JavaVisitorTest {

	String pathToInput;
	JavaClassVisitor visitor ;
	JavaClassVisitor umple_visitor ;
	
	@Before
	public void setUp() throws Exception {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/visitorTestFiles/");
		File testFile = new File(pathToInput+"InputForVisitorTest.java");
		String code = SampleFileWriter.readContent(testFile);
		File umpleFile = new File(pathToInput+"umplevisitor_test.ump");
	   	JavaParser javaParser = new JavaParser();
		javaParser.parseUnit(code);
		JavaParser umpleParser = new JavaParser();
		// Parsing umpleFile
		UmpleFile umpFile  = new  UmpleFile(umpleFile);
		UmpleModel umpModel = new UmpleModel(umpFile);
		umpModel.run();
		UmpleClass umpClass = umpModel.getUmpleClass(0);
		umpleParser.parseBodyDeclarations(umpClass.getExtraCode());
		umple_visitor = umpleParser.getJavaVisitor();
		visitor = javaParser.getJavaVisitor();
	}
	
	@Test
	public void field_declarations_returned_in_java_file()
	{
		 Assert.assertEquals(7, visitor.numberOfFieldDeclarations());
	}
	
	
	@Test
	public void field_declarations_returned_in_umple_file()
	{
		 Assert.assertEquals(3, umple_visitor.numberOfFieldDeclarations());
	}
	
	@Test
	public void imports_returned()
	{
		int nbImports = visitor.numberOfImportDeclarations();
		 Assert.assertEquals(2, nbImports);
	}
	
	@Test
	public void packages_returned()
	{
		String packageName = visitor.getPackageDeclaration().getName().getFullyQualifiedName();
		Assert.assertEquals("cruise.umplificator.visitorTestFiles", packageName);
	}
	
	
	@Test
	public void methods_returned()
	{
		int nbMethods = visitor.numberOfMethodDeclarations();
		 Assert.assertEquals(3, nbMethods);
	}
	
}
