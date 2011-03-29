package cruise.umple.implementation;

import org.junit.Test;

public class MNToNTest extends TemplateTest
{

  @Test
  public void MN()
  {
    assertUmpleTemplateFor("MNToNTest.ump",languagePath + "/MNToNTest_MN."+ languagePath +".txt","Mentor");
  }
  
  @Test
  public void N()
  {
    assertUmpleTemplateFor("MNToNTest.ump",languagePath + "/MNToNTest_N."+ languagePath +".txt","Student");
  }  
}
