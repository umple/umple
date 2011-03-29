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
  
  
}
