package cruise.umple.implementation;

import org.junit.*;

public class AssociationImportTest extends TemplateTest
{

  @Test
  public void UnawareShouldNotHaveReferenceToAware()
  {
    assertUmpleTemplateFor("AssociationImportTest.ump",languagePath + "/AssociationImportTest_Unaware."+ languagePath +".txt","Student");
  }
  
  @Test
  public void AwareShouldHaveReference()
  {
    assertUmpleTemplateFor("AssociationImportTest.ump",languagePath + "/AssociationImportTest_Aware."+ languagePath +".txt","Mentor");
  }    
  
}
