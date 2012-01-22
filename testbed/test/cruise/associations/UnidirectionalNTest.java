package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAK;
import cruise.associations.ProgramAK;
import cruise.associations.StudentAK;

public class UnidirectionalNTest
{

  @Test
  public void constructorEmpty()
  {
    MentorAK m = new MentorAK("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void setTooMany()
  {
    StudentAK s = new StudentAK(99);
    StudentAK s2 = new StudentAK(98);
    StudentAK s3 = new StudentAK(97);
    StudentAK s4 = new StudentAK(96);
    
    MentorAK m = new MentorAK("blah");
    Assert.assertEquals(false,m.setStudents(s,s2,s3,s4));
    Assert.assertEquals(0, m.numberOfStudents());
  }

  
  @Test
  public void setStudents()
  {
    StudentAK s = new StudentAK(99);
    StudentAK s2 = new StudentAK(98);
    StudentAK s3 = new StudentAK(97);
    StudentAK s4 = new StudentAK(97);
    
    MentorAK m = new MentorAK("blah");
    
    Assert.assertEquals(false,m.setStudents(s,s2,s3,s4));
    Assert.assertEquals(false,m.setStudents(s,s2,s2));
    Assert.assertEquals(true,m.setStudents(s,s2));
    
    Assert.assertEquals(2,m.numberOfStudents());
  }
  
  @Test
  public void deleteDoesNotChangeStudent()
  {
    StudentAK s = new StudentAK(99);
    StudentAK s2 = new StudentAK(98);
    StudentAK s3 = new StudentAK(97);

    ProgramAK p = new ProgramAK();
    s.setProgram(p);
    
    MentorAK m = new MentorAK("blah");
    m.setStudents(s,s2,s3);
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
  }
}
