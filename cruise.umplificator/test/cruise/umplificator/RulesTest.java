package cruise.umplificator;

import java.io.File;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import cruise.umple.compiler.*;
import cruise.umple.util.SampleFileWriter;
import cruise.umplificator.parser.JavaParser;
import cruise.umplificator.rules.RuleRunner;
import cruise.umplificator.rules.RuleService;
import cruise.umplificator.visitor.JavaClassVisitor;

public class RulesTest {

	String pathToInput;
	JavaClassVisitor visitor = new JavaClassVisitor();
	RuleRunner runner  = new RuleRunner();
	RuleService ruleService= new RuleService(runner);
	KieSession kieSession;
	UmpleClass uClass;
	CompilationUnit compilationUnit;
	
	@Before
	public void setUp() throws Exception {
		
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/javavisitor_test.txt");
		File testFile = new File(pathToInput);
		String code = SampleFileWriter.readContent(testFile);
	   	visitor = new JavaClassVisitor();
		JavaParser javaParser = new JavaParser(visitor);
		javaParser.parseUnit(code);
    	visitor = new JavaClassVisitor();
    	compilationUnit.accept(visitor);
		uClass = new UmpleClass("A");
	    kieSession = ruleService.startRuleEngine();
		kieSession.insert( uClass);
	}

	@Test
	public void testNumberOfObjectsInWorkingMemory() {
		Assert.assertEquals(1, kieSession.getObjects().size());
	}
	
	@Test
	public void testCorrectMappingBetweenPrimitiveField_UmpleAttribute() {
		// Insert facts into knowledge base
		for(FieldDeclaration field: visitor.getFieldDeclarations()){
			kieSession.insert(field);
		}
		// Fire rules
		kieSession.fireAllRules();
		// Is not Null
		Assert.assertNotNull( uClass.getAttribute(0));
		Assert.assertNotNull( uClass.getAttribute(1));
		Assert.assertNotNull( uClass.getAttribute(2));
		Assert.assertNotNull( uClass.getAttribute(3));
		Assert.assertNotNull( uClass.getAttribute(4));
		Assert.assertNotNull( uClass.getAttribute(5));
		Assert.assertNotNull( uClass.getAttribute(6));

		// Type has been set correctly
		Assert.assertEquals("Boolean", uClass.getAttribute(0).getType());
		Assert.assertEquals("String", uClass.getAttribute(1).getType());
		Assert.assertEquals("Integer", uClass.getAttribute(2).getType());
		Assert.assertEquals("Integer", uClass.getAttribute(3).getType());
		Assert.assertEquals("Integer", uClass.getAttribute(4).getType());
		Assert.assertEquals("Double", uClass.getAttribute(5).getType());
		Assert.assertEquals("Double", uClass.getAttribute(6).getType());
		// Name has been correctly set
		Assert.assertEquals("result", uClass.getAttribute(0).getName());
		Assert.assertEquals("capitalC", uClass.getAttribute(1).getName());
		Assert.assertEquals("b", uClass.getAttribute(2).getName());
		Assert.assertEquals("s", uClass.getAttribute(3).getName());
		Assert.assertEquals("i", uClass.getAttribute(4).getName());
		Assert.assertEquals("d1", uClass.getAttribute(5).getName());
		Assert.assertEquals("creditCardNumber", uClass.getAttribute(6).getName());
	}
	
	@Test
	public void testCorrectMappingBetweenImport_Depend() {
		for(ImportDeclaration importDecl: visitor.getImportDeclarations()){
			kieSession.insert(importDecl);
		}
		kieSession.fireAllRules();
		Assert.assertEquals(3, uClass.getDepends().size());
		Assert.assertEquals("java.util.*", uClass.getDepends().get(0).getName());
		Assert.assertEquals("java.io.*", uClass.getDepends().get(1).getName());
		Assert.assertEquals("java.io.File", uClass.getDepends().get(2).getName());
	}
	
	@After
	public void tearDown() throws Exception {
		runner.dispose();		
	}

}
