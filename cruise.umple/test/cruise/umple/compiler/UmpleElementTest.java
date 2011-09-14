package cruise.umple.compiler;

import org.junit.*;

public class UmpleElementTest
{
  
  UmpleElement ele;
  
  @Before
  public void setUp()
  {
    ele = new UmpleElement("x");
  }

  @Test
  public void appendExtraCode()
  {
    Assert.assertEquals("",ele.getExtraCode());
    ele.appendExtraCode("a");
    Assert.assertEquals("a",ele.getExtraCode());
    ele.appendExtraCode("b");
     Assert.assertEquals("a" + System.getProperty("line.separator") + 
                         "b",ele.getExtraCode());
  }

  @Test
  public void appendExtraCodeNoNewline()
  {
    Assert.assertEquals("",ele.getExtraCode());
    ele.appendExtraCode("a");
    Assert.assertEquals("a",ele.getExtraCode());
    ele.appendExtraCode("b",false);
    Assert.assertEquals("ab",ele.getExtraCode());
  }

  @Test
  public void appendExtraCodeNull()
  {
    Assert.assertEquals("",ele.getExtraCode());
    ele.appendExtraCode(null);
    Assert.assertEquals("",ele.getExtraCode());
    ele.appendExtraCode("b");
    Assert.assertEquals("b",ele.getExtraCode());
    ele.appendExtraCode(null);
    Assert.assertEquals("b",ele.getExtraCode());
  }

}
