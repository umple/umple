/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class InterfaceTemplateTest extends TemplateTest
{
  
  @Test
  public void Interface()
  {
    assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest."+ languagePath +".txt","ISomething");
  }
  
  @Test
  public void Implements()
  {
	  assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_Implements."+ languagePath +".txt","Something");
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
	
  @Test
	public void implementsMultipleInterface()
	{
		assertUmpleTemplateFor("InterfaceTemplateTest.ump",languagePath + "/InterfaceTemplateTest_implementsMultipleInterface."+ languagePath +".txt","A");
	}

}
