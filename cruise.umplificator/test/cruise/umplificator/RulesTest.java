package cruise.umplificator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import cruise.umple.compiler.UmpleClass;
import cruise.umplificator.rules.RuleRunner;
import cruise.umplificator.rules.RuleService;
import cruise.umplificator.visitor.JavaClassVisitor;

@SuppressWarnings("restriction")
public class RulesTest {
	
	String pathToInput;
	JavaClassVisitor visitor = new JavaClassVisitor();
	RuleRunner runner  = new RuleRunner();
	RuleService ruleService= new RuleService(runner);
	KieSession kieSession;

	@Before
	public void setUp() throws Exception {
		/*
		pathToInput = SampleFileWriter.rationalize("test/cruise/umplificator/javavisitor_test.txt");
		File testFile = new File(pathToInput);
		String code = SampleFileWriter.readContent(testFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit compilationUnit = javaParser.parseUnit(code);
    	visitor = new JavaClassVisitor();
    	compilationUnit.accept(visitor);
    	*/
	    kieSession = ruleService.startRuleEngine();
	}

	@Test
	public void testNumberOfObjectsInWorkingMemory() {
		UmpleClass uClass = new UmpleClass("A");
		kieSession.insert( uClass);
		Assert.assertEquals(1, kieSession.getObjects().size());
	}

	@After
	public void tearDown() throws Exception {
		runner.dispose();
	}
}
