package cruise.umple.compiler;

import org.junit.*;

public class CoupleTest
{

  @Test
  public void isBalanced_empty()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(true,couple.isBalanced(null));
    Assert.assertEquals(true,couple.isBalanced(""));
  }
  
  @Test
  public void isBalanced_notPresent()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(true,couple.isBalanced("no brackets"));
  }  

  @Test
  public void isBalanced_okay()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(true,couple.isBalanced("[brackets]"));
    Assert.assertEquals(true,couple.isBalanced("yes [brackets]"));
    Assert.assertEquals(true,couple.isBalanced("[brackets] yes"));
    Assert.assertEquals(true,couple.isBalanced("yes [please brackets] yes"));
  }  

  @Test
  public void isBalanced_no()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(false,couple.isBalanced("[brackets"));
    Assert.assertEquals(false,couple.isBalanced("yes [brackets"));
    Assert.assertEquals(false,couple.isBalanced("[brackets yes"));
    Assert.assertEquals(false,couple.isBalanced("yes [please brackets yes"));
  }  

  @Test
  public void isBalanced_nestedNo()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(false,couple.isBalanced("[[brackets]"));
    Assert.assertEquals(false,couple.isBalanced("[ye[s [brackets"));
    Assert.assertEquals(false,couple.isBalanced("b[rackets yes["));
  }  
  
  @Test
  public void isBalanced_ignoreStuff()
  {
    Couple couple = new Couple("[","]");
    Assert.assertEquals(false,couple.isBalanced("a [ --Ignore between [ dashes- ]"));
    Assert.assertEquals(true,couple.isBalanced("a [ --Ignore between ] dashes- "));
    couple.addIgnore(new Couple("--","-"));
    Assert.assertEquals(true,couple.isBalanced("a [ --Ignore between [ dashes- ]"));
    Assert.assertEquals(false,couple.isBalanced("a [ --Ignore between ] dashes- "));
  }

  @Test
  public void removeIgnoredText()
  {
    Couple couple = new Couple("[","]");
    couple.addIgnore(new Couple("---","--"));
    Assert.assertEquals("",couple.removeIgnoredText("-----"));
    Assert.assertEquals("",couple.removeIgnoredText("--- --"));
    Assert.assertEquals("x",couple.removeIgnoredText("x--- --"));
    Assert.assertEquals("y",couple.removeIgnoredText("--- --y"));
    Assert.assertEquals("xy",couple.removeIgnoredText("x--- --y"));
    Assert.assertEquals("xyz",couple.removeIgnoredText("xyz"));
    Assert.assertEquals("x",couple.removeIgnoredText("x---yz"));
    Assert.assertEquals("x--yz",couple.removeIgnoredText("x--yz"));
    
  }

  @Test
  public void removeIgnoredText_nested()
  {
    Couple couple = new Couple("[","]");
    Couple ignore1 = new Couple("---","--");
    Couple ignore2 = new Couple("{","}");
    
    couple.addIgnore(ignore1);
    ignore1.addIgnore(ignore2);
    
    Assert.assertEquals("",couple.removeIgnoredText("{ }--- --"));
  }

}
