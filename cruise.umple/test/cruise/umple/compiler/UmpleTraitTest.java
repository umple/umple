package cruise.umple.compiler;


import junit.framework.Assert;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class UmpleTraitTest {
	String pathToInput;
	UmpleModel uMode;
	
	@Before
	public void setup() {
		SampleFileWriter.createFile("traitTest.ump", 
				"class A { isA T;}"
				+ "trait T {"
				+ "depend cruise.umple.util.*;"
				+ " tName;"
				+ " tAge;"
				+ " abstract; singleton; void xFun() {} "
				+ "[tage>=18]"
				+ "}");	
		UmpleFile uFile = new UmpleFile("traitTest.ump");	
		uMode = new UmpleModel(uFile);
		try {
			uMode.run();
		} catch (Exception e) {
			e.printStackTrace();
		}	
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
	//	Assert.assertEquals(1,uMode.getUmpleTrait("T").numberOfConstraints());
	//	Assert.assertEquals(1,uMode.getUmpleClass("A").numberOfConstraints());
	}	
}
