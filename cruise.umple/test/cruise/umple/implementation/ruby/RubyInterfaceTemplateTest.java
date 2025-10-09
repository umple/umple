package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.InterfaceTemplateTest;

public class RubyInterfaceTemplateTest extends InterfaceTemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }

  // Generated ruby class is missing constants. Determine intended behavior at a later date
  @Test @Ignore
  public void Interface()
  {
    assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest."+ languagePath +".txt","ISomething");
  }

  // Generated ruby class is empty. Determine intended behavior at a later date
  @Test @Ignore
	public void MethodsInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_Methods."+ languagePath +".txt","ICodeTranslator");
	}

  // Generated ruby class is empty. Determine intended behavior at a later date
  @Test @Ignore
	public void isASingleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_singleImplements."+ languagePath +".txt","IFirstChild");
	}
	
  // Generated ruby class is empty. Determine intended behavior at a later date
	@Test @Ignore
	public void isAMultipleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_multipleImplements."+ languagePath +".txt","ISecondChild");
	}
  
}
