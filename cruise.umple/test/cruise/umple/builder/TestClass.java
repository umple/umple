package cruise.umple.builder;

import org.junit.*;

public class TestClass
{
  int i = 0;
  
  public void inc()
  {
    i += 1;
  }
  
  public int i()
  {
    return i;
  }
  
  public String alwaysNull()
  {
    return null;
  }
  
  @Test
  public void toKeepJunitAndAntQuiet()
  {
    Assert.assertEquals(1,1);
  }
  
}