
import org.junit.*;

public class StudentTest
{
  
  @Test
  public void constructor()
  {
    Student s = new Student("a");
    Assert.assertEquals("a",s.getName());
  }
  
  @Test
  public void attribute_name()
  {
    Student s = new Student("a");
    Assert.assertEquals("a",s.getName());
    
    Assert.assertEquals(true,s.setName("x"));
    Assert.assertEquals("x",s.getName());

    Assert.assertEquals(true,s.setName("y"));
    Assert.assertEquals("y",s.getName());
  }
  
}