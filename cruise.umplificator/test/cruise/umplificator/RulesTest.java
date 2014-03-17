package cruise.umplificator;

import java.io.File;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
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
	
	@Before
	public void setUp() throws Exception {
		
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/javavisitor_test.txt");
		File testFile = new File(pathToInput);
		String code = SampleFileWriter.readContent(testFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit compilationUnit = javaParser.parseUnit(code);
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
		FieldDeclaration field = visitor.getFieldDeclaration(0); // private int b;
		// Insert fact into knowledge base
		kieSession.insert( field);
		// Fire rules
		kieSession.fireAllRules();
		// Retrieve attribute and compare
		Attribute attr = uClass.getAttribute(0);
		// Is not Null
		Assert.assertNotNull(attr);
		// Type has been set correctly
		Assert.assertEquals("Integer", attr.getType());
		// Name has been correctly set
		Assert.assertEquals("b", attr.getName());
	}

	@After
	public void tearDown() throws Exception {
		runner.dispose();
	}

}
