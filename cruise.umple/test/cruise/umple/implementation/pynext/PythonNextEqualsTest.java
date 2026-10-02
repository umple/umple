package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.EqualsTest;

public class PythonNextEqualsTest extends EqualsTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
  
  @Test
  public void indexOf_noKey()
  {
    assertUmpleTemplateFor("indexOf_NoKey.ump",languagePath + "/indexOf_NoKey."+ languagePath +".txt","Student");
  }

  @Test
  public void indexOf_Key()
  {
    assertUmpleTemplateFor("indexOf_Key.ump",languagePath + "/indexOf_Key."+ languagePath +".txt","Student");
  }
}
