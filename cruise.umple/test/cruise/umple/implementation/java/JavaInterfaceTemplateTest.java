package cruise.umple.implementation.java;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;


public class JavaInterfaceTemplateTest extends InterfaceTemplateTest
{

	@Before
	public void setUp()
	{
		super.setUp();
		language = "Java";
		languagePath = "java";
	}
	
	
	@Test
	public void extendsImplementsMultipleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest2.ump",languagePath + "/InterfaceTemplateTest_extendsImplementsMultipleInterface."+ languagePath +".txt","B");
		assertUmpleTemplateFor("InterfaceTemplateTest3.ump",languagePath + "/InterfaceTemplateTest_extendsImplementsMultipleInterface2."+ languagePath +".txt","A");
	}
}
