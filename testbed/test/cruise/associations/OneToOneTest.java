package cruise.associations;

import org.junit.*;

import cruise.associations.MentorG;
import cruise.associations.ProgramG;
import cruise.associations.StudentG;

public class OneToOneTest
{

  @Test
  public void ConstructorBuildsBoth()
  {
    MentorG m = new MentorG("a",1);
    Assert.assertEquals("a",m.getName());
    Assert.assertEquals(1, m.getStudent().getNumber());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorIfAlreadySet()
  {
    MentorG m = new MentorG("a",1);
    new StudentG(1,m);
  }  
  
  @Test(expected=RuntimeException.class)
  public void ConstructorCannotSetNull()
  {
    new MentorG("a",(StudentG)null);
  }   
  
  @Test
  public void delete()
  {
    MentorG m = new MentorG("a",1);
    StudentG s = m.getStudent();
    m.getStudent().setProgram(new ProgramG());
    m.delete();
    Assert.assertEquals(null, m.getStudent());
    Assert.assertEquals(null, m.getProgram());
    Assert.assertEquals(null, s.getMentor());
    Assert.assertEquals(null, s.getProgram());
    
  }
  
}
