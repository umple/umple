package cruise.umple.compiler;


import junit.framework.Assert;

import org.junit.*;

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
		SampleFileWriter.destroy("B.java");
		SampleFileWriter.destroy("I.java");
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
	public void checkValidNameTest() {
		String code = "class A{isA 12T;}trait 12T{}";
		UmpleModel model = getModel(code);
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2500");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}

	@Test
	public void checkUniqueNameTest() {
		String code = "class A{isA A;}trait A{}";
		UmpleModel model = getModel(code);
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2550");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
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
		String code = "class A {isA T1;} class B {isA T1;} trait T1 { isA T2; status { on { turnOn -> on;}} } trait T2 {sm { active { goActive -> active;}} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfStateMachines());
		Assert.assertEquals(2, model.getUmpleClass("B").numberOfStateMachines());		
	}	
	
	@Test
	public void codeInjectTraitsTest() {
		String code = "class A {isA T;} trait T { Integer x; after getX { x = 0;} before getX { x = 0;} } ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfCodeInjections());		
	}	
	
	@Test
	public void extraCodeTraitsTest() {
		String code = "class A {isA T;} trait T { cout<<x; } ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(false, model.getUmpleClass("A").getExtraCode().isEmpty());		
	}	

	@Test
	public void associationTraitsTest() {
		String code = "class A {isA T;} class B {} trait T { 1 -- * B;} ";
		UmpleModel model = getRunModel(code);
		SampleFileWriter.destroy("B.java");	
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfAssociationVariables());	
		Assert.assertEquals(1, model.getUmpleClass("B").numberOfAssociationVariables());
	}
	
	@Test
	public void checkRequiredMethodTest() {
		String code = "class A{isA T;} trait T { String test();}";
		UmpleModel model = getModel(code);
		
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2555");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}	
	
	@Test
	public void GeneraParameterTest() {
		String code = "class A{isA T<fname>;} trait T<p1> { %p1;}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("fname", model.getUmpleClass("A").getAttribute(0).getName());	
		
	}	
	
	@Test
	public void checkDuplicatedMethods1Test() {
		String code = "class A{isA T1; isA T2;} trait T1 { String test(){}} trait T2 { String test(){}}";
		UmpleModel model = getModel(code);
		
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2557");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}
	
	@Test
	public void checkDuplicatedMethods2Test() {
		String code = "class A{isA T;}trait T{isA T1;isA T2;}trait T1{void test(){/*T1*/}}trait T2{void test(){/*T2*/}}";
		UmpleModel model = getModel(code);
		
		try {
			model.run();	
		} catch (Exception e) {
			boolean result = e.getMessage().contains("2557");
			Assert.assertTrue(result);
		} finally {
			SampleFileWriter.destroy("traitTest.ump");
		}	
	}
	
	@Test
	public void compositionTraitClassRule1Test() {
		String code = "class A{isA T;void test() {/*A*/} } trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/",model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());	
		
	}
	
	@Test
	public void compositionTraitClassRule2Test() {		
		String code = "class A{void test() {/*A*/}}class B{isA A;isA T;}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*T*/",model.getUmpleClass("B").getMethod(0).getMethodBody().getExtraCode());	
		
	}
	
	@Test
	public void compositionTraitClassRule3Test() {	
		String code = "class A{void test() {/*A*/}}class B{isA A;isA T;void test(){/*B*/}}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*B*/",model.getUmpleClass("B").getMethod(0).getMethodBody().getExtraCode());		
	}
	
	@Test
	public void compositionTraitClassRule4Test() {	
		String code = "interface I{void test();}class A{isA I;isA T;void test(){/*A*/}}trait T{void test() {/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/",model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());		
	}
	
	@Test
	public void compositionTraitClassRule5Test() {
		String code = "interface I { void test();} class A { isA I; isA T; } trait T { void test() {/*T*/} }";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
	 }
	
	@Test
	public void compositionTraitClassRule6Test() {
		String code = "class A{isA T;void need(){/*A*/}}trait T{void need();void show(){need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals("/*A*/",model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	 }
	
	@Test
	public void compositionTraitClassRule7Test() {
		String code = "class A{isA T1;void test1() {/*A*/}isA T4;}trait T4{void test1() {/*T4*/}}trait T1{void test1() {/*T1*/}isA T2;}trait T2{isA T3;	void test2() {/*T2*/}}trait T3{void test3() {/*T3*/}void test2() {/*T3*/}void test1() {/*T3*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(3, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("test1")){
				Assert.assertEquals("/*A*/",method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test2")){
				Assert.assertEquals("/*T2*/",method.getMethodBody().getExtraCode());
			} else if (method.getName().equals("test3")){
				Assert.assertEquals("/*T3*/",method.getMethodBody().getExtraCode());
			}
		}

	 }
	
	@Test
	public void compositionTraitClassRule8Test() {
		String code = "class A{isA T;}trait T{isA T1;void need(){/*T*/}}trait T1{void need();void show(){	need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")){
				Assert.assertEquals("/*T*/",method.getMethodBody().getExtraCode());
			}
		}
	 }	
	
	@Test
	public void compositionTraitClassRule9Test() {
		String code = "class A{isA T;void need(){/*A*/}	}trait T{isA T1;void need(){/*T*/}}trait T1{void need();void show(){need();}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")){
				Assert.assertEquals("/*A*/",method.getMethodBody().getExtraCode());
			}
		}
	 }
	
	@Test
	public void compositionTraitClassRule10Test() {
		String code = "class A{isA T1,T2;}trait T1{isA T;}trait T2{isA T;}trait T{void test(){/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(1, model.getUmpleClass("A").numberOfMethods());
		Assert.assertEquals("/*T*/",model.getUmpleClass("A").getMethod(0).getMethodBody().getExtraCode());
	 }
	
	@Test
	public void compositionTraitClassRule11Test() {
		String code = "class A{isA T;}trait T{void test1(){/*T*/}}trait T{void test2(){/*T*/}}";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
	 }	
	
	@Test
	public void compositionTraitClassRule12Test() {
		String code = "class A{isA T; }trait T{ isA T1; void need(); void show(){test(); }}trait T1{ void need(){ /*T1*/ }} ";
		UmpleModel model = getRunModel(code);
		Assert.assertEquals(2, model.getUmpleClass("A").numberOfMethods());
		for (Method method : model.getUmpleClass("A").getMethods()) {
			if (method.getName().equals("need")){
				Assert.assertEquals("/*T1*/",method.getMethodBody().getExtraCode());
			}
		}
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
