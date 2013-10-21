package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;

public class ConstraintExpressionsTest extends TemplateTest{
	
	@Test
	public void BasicConstraint1() //[(age<18)]
	{
		assertUmpleTemplateFor("BasicConstraint1.ump", languagePath + "/BasicConstraint1."+ languagePath +".txt", "student");
	}

	@Test
	public void BasicConstraint3(){ // [age > minAge]
		assertUmpleTemplateFor("BasicConstraint3.ump", languagePath + "/BasicConstraint3."+ languagePath +".txt", "Client");
	}
	
	@Test @Ignore
	public void BasicConstraint4(){ // [(18>age)]
		assertUmpleTemplateFor("BasicConstraint4.ump", languagePath + "/BasicConstraint4."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint5(){ // [18 > age && 3 < weight]
		assertUmpleTemplateFor("BasicConstraint5.ump", languagePath + "/BasicConstraint5."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint6(){ // [18 > age || 3 < weight]
		assertUmpleTemplateFor("BasicConstraint6.ump", languagePath + "/BasicConstraint6."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint7(){ // [! (18 > age)]
		assertUmpleTemplateFor("BasicConstraint7.ump", languagePath + "/BasicConstraint7."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint8(){ // [! (18 > age)]
		assertUmpleTemplateFor("BasicConstraint8.ump", languagePath + "/BasicConstraint8."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicPrecondition1(){ // [pre: arg > 5] , [pre: minAge < 8]
		assertUmpleTemplateFor("BasicPrecondition1.ump", languagePath + "/BasicPrecondition1."+ languagePath +".txt", "Client");
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
