package cruise.umple.implementation;

import org.junit.*;

public class ReflexiveAssociationTest extends TemplateTest
{
   
  @Test
  public void OptionalOneSymmetric()
  {
    assertUmpleTemplateFor("ReflexiveAssociationTest.ump",languagePath + "/ReflexiveAssociationTest_OptionalOneSymmetric."+ languagePath +".txt","Mentor");
  }   
  
  @Test
  public void OptionalOneAsymmetric()
  {
    assertUmpleTemplateFor("ReflexiveAssociationTest.ump",languagePath + "/ReflexiveAssociationTest_OptionalOneAsymmetric."+ languagePath +".txt","Student");
  }
  
  @Test
  public void OneSymmetric()
  {
    assertUmpleTemplateFor("ReflexiveAssociationTest.ump",languagePath + "/ReflexiveAssociationTest_OneSymmetric."+ languagePath +".txt","OneSymmetric");
  }

  @Test
  public void OneSymmetricNoParam()
  {
    assertUmpleTemplateFor("ReflexiveAssociationTest.ump",languagePath + "/ReflexiveAssociationTest_OneSymmetricNoParam."+ languagePath +".txt","OneSymmetricNoParam");
  }
  
  @Test
  public void OneToMany()
  {
    assertUmpleTemplateFor("ReflexiveAssociationTest.ump",languagePath + "/ReflexiveAssociationTest_OneToMany."+ languagePath +".txt","OneToMany");
  }  

}
