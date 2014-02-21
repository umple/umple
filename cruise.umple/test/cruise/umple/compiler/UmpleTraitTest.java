package cruise.umple.compiler;


import junit.framework.Assert;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.docs.DocumenterMain.UmpleExceptionHandler;
import cruise.umple.util.SampleFileWriter;

public class UmpleTraitTest {
	String pathToInput;
	UmpleModel uMode;
	
	@Before
	public void setup() {	
		String  code = "class A { isA T;}"
				+ "trait T {"
				+ "depend cruise.umple.util.*;"
				+ " tName;"
				+ " Integer tAge;"
				+ " abstract; singleton; void xFun() {} "
				+ "[tAge>=18]"
				+ "}"; 	
		uMode = getRunModel(code);
	}	
	@After
	public void tearDown()
	{
		SampleFileWriter.destroy("traitTest.ump");
		SampleFileWriter.destroy("A.java");		
	}
	
	@Test 
	public void traitDetectionTest() {
		Assert.assertEquals(1,uMode.numberOfUmpleTraits());
	}

	@Test 
	public void attributeDetectionTest() {
		Assert.assertEquals(2,uMode.getUmpleTrait("T").numberOfAttributes());
		Assert.assertEquals(2,uMode.getUmpleClass("A").numberOfAttributes());
	}
	
	@Test 
	public void traitInheritanceTest() {
		Assert.assertEquals(1,uMode.getUmpleClass("A").numberOfExtendsTraits());
		Assert.assertEquals(1,uMode.getUmpleTrait("T").numberOfSubClasses());
	}
	
	@Test 
	public void abstractionTest() {
		Assert.assertEquals(true,uMode.getUmpleClass("A").isIsAbstract());
	}
	
	@Test
	public void singletonTest() {
		Assert.assertEquals(true,uMode.getUmpleClass("A").isIsSingleton());
	}
	
	@Test
	public void methodsTest() {
		Assert.assertEquals(1,uMode.getUmpleClass("A").numberOfMethods());
	}
	
	@Test
	public void dependTest() {
		Assert.assertEquals(1,uMode.getUmpleClass("A").numberOfDepends());
	}	
	
	@Test
	public void constraintTest() {
		Assert.assertEquals(1,uMode.getUmpleTrait("T").numberOfConstraints());
		Assert.assertEquals(1,uMode.getUmpleClass("A").numberOfConstraints());
	}
	
	@Test
	public void selfInheritanceTest() {
		String code = "class A{isA T;} trait T { isA T;}";
		UmpleModel model = getModel(code);
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2551");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}
	
	@Test
	public void cyclicInheritanceTest() {
		String code = "class A{isA T;} trait T { isA T1;} trait T1 {isA T;}";
		UmpleModel model = getModel(code);
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2553");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}	

	@Test
	public void multipleInheritanceTraitsTest() {
		String code = "class A {isA T1; isA T2;} trait T1 { lazy name1;} trait T2 {lazy name2;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfAttributes());		
	}	
	
	@Test
	public void stateMachineTraitsTest() {
		String code = "class A {isA T1;} trait T1 { isA T2; status { on { turnOn -> on;}} } trait T2 {sm { active { goActive -> active;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfStateMachines());		
	}	
	
	@Test
	public void codeInjectTraitsTest() {
		String code = "class A {isA T;} trait T { Integer x; after getX { x = 0;} before getX { x = 0;} } ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfCodeInjections());		
	}		
	
//-------------------------------------------------------------------------------------	
//----------------------- Functional methods for this test case -----------------------
	private UmpleModel getRunModel(String inCode) {
		SampleFileWriter.createFile("traitTest.ump",inCode);	
		UmpleFile uFile = new UmpleFile("traitTest.ump");	
		uMode = new UmpleModel(uFile);
		try {
			uMode.run();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
			SampleFileWriter.destroy("A.java");	
		}
		return uMode;
	}
	
	private UmpleModel getModel(String inCode) {
		SampleFileWriter.createFile("traitTest.ump",inCode);	
		UmpleFile uFile = new UmpleFile("traitTest.ump");	
		uMode = new UmpleModel(uFile);
		return uMode;
	}	
}
