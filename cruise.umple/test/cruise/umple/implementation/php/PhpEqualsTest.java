package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.EqualsTest;

public class PhpEqualsTest extends EqualsTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
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
