package cruise.umple.implementation.cpp;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class CppInterfaceTemplateTest extends InterfaceTemplateTest
{

	@Before
	public void setUp()
	{
		super.setUp();
		language = "SimpleCpp";
		languagePath = "cpp";
	}
	
	@Test
	public void MethodsInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_Methods."+ languagePath +".txt","ICodeTranslator");
	}
	
	@Test
	public void isASingleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_singleImplements."+ languagePath +".txt","IFirstChild");
	}
	@Test
	public void isAMultipleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_multipleImplements."+ languagePath +".txt","ISecondChild");
	}
	
}
