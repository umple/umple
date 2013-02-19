package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;

public class ConstraintExpressionsTest extends TemplateTest{
	
	UmpleParserTest upt;
	
	@Before
	public void additionalSetUp(){
		upt = new UmpleParserTest();
		upt.setUp();
		upt.pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
	}

	@Test
	public void BasicConstraint1() //[(age<18)]
	{
		assertUmpleTemplateFor("BasicConstraint1.ump", languagePath + "/BasicConstraint1."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint2(){ // [agedfd > 12]
		upt.assertFailedParse("BasicConstraint2.ump",28);
	}
	
	@Test
	public void BasicConstraint3(){ // [age > minAge]
		upt.assertParse("BasicConstraint3.ump");
	}
	
	@Test
	public void BasicConstraint4(){ // [(18>age)]
		upt.assertParse("BasicConstraint4.ump");
	}
	
//	@Test
//	public void BasicConstraint2()
//	{
//		assertUmpleTemplateFor("BasicConstraint2.ump", languagePath + "/BasicConstraint2."+ languagePath +".txt", "X");
//	}
//	@Test
//	public void NegativeBasicConstrain1t()
//	{
//		assertUmpleTemplateFor("NegativeBasicConstraint1.ump", languagePath + "/NegativeBasicConstraint1."+ languagePath +".txt", "X");
//	}
//	@Test
//	public void NegativeBasicConstraint2()
//	{
//		assertUmpleTemplateFor("NegativeBasicConstraint1.ump", languagePath + "/NegativeBasicConstraint1."+ languagePath +".txt", "X");
//	}
}
