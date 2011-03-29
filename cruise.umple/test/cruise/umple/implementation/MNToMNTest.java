package cruise.umple.implementation;

import org.junit.Test;

public class MNToMNTest extends TemplateTest
{

  @Test
  public void Association()
  {
    assertUmpleTemplateFor("MNToMNTest.ump",languagePath + "/MNToMNTest_Association."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void Association2()
  {
    assertUmpleTemplateFor("MNToMNTest.ump",languagePath + "/MNToMNTest_Association2."+ languagePath +".txt","Student");
  }  
}
