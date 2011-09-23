package cruise.umple.compiler;

import org.junit.*;

public class CommentTest
{
  
  @Test
  public void constructor()
  {
    Comment c = new Comment("blah2");
    Assert.assertEquals("blah2",c.getText());
  }
  
}
