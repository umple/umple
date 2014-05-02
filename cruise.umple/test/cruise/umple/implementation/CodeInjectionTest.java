/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class CodeInjectionTest extends TemplateTest
{

  @Test
  public void AttributesAndDelete()
  {
	assertUmpleTemplateFor("CodeInjectionTest.ump",languagePath + "/CodeInjectionTest_Attributes."+ languagePath +".txt","Student");
  }

  @Test
  public void SupportUnderscoreNamingToo()
  {
    assertUmpleTemplateFor("CodeInjectionTest_underscore.ump",languagePath + "/CodeInjectionTest_underscore."+ languagePath +".txt","Student");
  }

  @Test
  public void Associations()
  {
    assertUmpleTemplateFor("CodeInjectionAssociationTest.ump",languagePath + "/CodeInjectionTest_Association."+ languagePath +".txt","Student");
  }

  @Test
  public void WildCard()
  {
    assertUmpleTemplateFor("CodeInjectionWildCardTest.ump",languagePath + "/CodeInjectionWildCardTest."+ languagePath +".txt","Student");
  }

  @Test 
  public void StateMachines()
  {
	  assertUmpleTemplateFor("CodeInjectionStateMachineTest.ump",languagePath + "/CodeInjectionStateMachineTest."+ languagePath +".txt","Example");
  }
  
}
