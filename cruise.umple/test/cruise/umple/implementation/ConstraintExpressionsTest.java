package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;

public class ConstraintExpressionsTest extends TemplateTest{
	@Test
	public void BasicConstraint1()
	{
		assertUmpleTemplateFor("BasicConstraint1.ump", languagePath + "/BasicConstraint1."+ languagePath +".txt", "student");
	}
	
	@Test
	public void BasicConstraint2(){
		UmpleParserTest upt = new UmpleParserTest();
		upt.setUp();
		upt.pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
		upt.assertFailedParse("BasicConstraint2.ump",28);
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
