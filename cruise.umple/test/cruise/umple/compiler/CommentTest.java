package cruise.umple.compiler;

import java.util.*;
import org.junit.*;

public class CommentTest
{
  
  ArrayList<Comment> allComments;
  
  @Before
  public void setUp()
  {
    allComments = new ArrayList<Comment>();
  }
  
  @Test
  public void constructor()
  {
    Comment c = new Comment("blah2");
    Assert.assertEquals("blah2",c.getText());
  }
  
  @Test
  public void format_null()
  {
    String output = Comment.format("Slashes",allComments);
    Assert.assertEquals(null,output);
  }
  
  @Test
  public void format_oneComment()
  {
    allComments.add(new Comment("a"));
    String output = Comment.format("Slashes",allComments);
    Assert.assertEquals("// a",output);
  }
  

  @Test
  public void format_multiplecomments()
  {
    allComments.add(new Comment("a"));
    allComments.add(new Comment("a2"));
    String output = Comment.format("Slashes",allComments);
    Assert.assertEquals("// a\n// a2",output);
  }

  @Test
  public void format_hash()
  {
    allComments.add(new Comment("a"));
    String output = Comment.format("Hash",allComments);
    Assert.assertEquals("# a",output);
  }

  @Test
  public void format_unknown()
  {
    allComments.add(new Comment("a"));
    String output = Comment.format("Garble",allComments);
    Assert.assertEquals("// a",output);
  }

  
  @Test
  public void format_slashes()
  {
    allComments.add(new Comment("a"));
    String output = Comment.format("Slashes",allComments);
    Assert.assertEquals("// a",output);
  }
  
  
}
