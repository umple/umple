package cruise.vml;

import org.junit.*;

public class VmlSystemTest
{

  @Test
  public void getConcern_ByName()
  {
    VmlSystem system = new VmlSystem();
    Concern c = new Concern("x");
    
    Assert.assertEquals(null, system.getConcern("x"));
    Assert.assertEquals(null, system.getConcern(null));
    
    system.addConcern(c);
    Assert.assertEquals(c, system.getConcern("x"));
  }
  
  @Test
  public void getCode()
  {
    VmlSystem system = new VmlSystem();
    Assert.assertEquals("",system.getCode());
    
    system.addCodeSnippet(new CodeSnippet("a"));
    Assert.assertEquals("a\n",system.getCode());

    system.addCodeSnippet(new CodeSnippet("b"));
    Assert.assertEquals("a\nb\n",system.getCode());
  }
}
