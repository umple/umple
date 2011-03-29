package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.EqualsTest;

public class RubyEqualsTest extends EqualsTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
  
  @Test
  public void indexOf_noKey()
  {
    assertUmpleTemplateFor("indexOf_NoKey.ump",languagePath + "/indexOf_NoKey."+ languagePath +".txt","Student");
  }

  @Test
  public void indexOf_Key()
  {    assertUmpleTemplateFor("indexOf_Key.ump",languagePath + "/indexOf_Key."+ languagePath +".txt","Student");

  }

}
