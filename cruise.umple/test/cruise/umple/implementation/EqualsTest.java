package cruise.umple.implementation;

import org.junit.*;

public class EqualsTest extends TemplateTest
{

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("EqualsTest.ump",languagePath + "/EqualsTest_Attributes."+ languagePath +".txt","Student");
  }

  @Test
  public void Associations()
  {
    assertUmpleTemplateFor("EqualsTest.ump", languagePath + "/EqualsTest_Associations."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void AlreadyImmutable()
  {
    assertUmpleTemplateFor("EqualsTest_AlreadyImmutable.ump",languagePath + "/EqualsTest_AlreadyImmutable."+ languagePath +".txt","Student");
  }

}
