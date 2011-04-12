package cruise.test;

import org.junit.*;

public class UnidirectionalMStarTest
{

  @Test(expected=RuntimeException.class)
  public void constructorTooFew()
  {
    StudentAL s = new StudentAL(99);
    StudentAL s2 = new StudentAL(98);
    new MentorAL("blah",s,s2);
  }
  
  
  @Test
  public void constructorRequiresMinimum()
  {
    StudentAL s = new StudentAL(99);
    StudentAL s2 = new StudentAL(98);
    StudentAL s3 = new StudentAL(97);
    
    MentorAL m = new MentorAL("blah",s,s2,s3);
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test
  public void addRemoveWithinLimits()
  {
    StudentAL s = new StudentAL(99);
    StudentAL s2 = new StudentAL(98);
    StudentAL s3 = new StudentAL(97);
    StudentAL s4 = new StudentAL(96);
    StudentAL s5 = new StudentAL(95);
    StudentAL s6 = new StudentAL(94);
    
    MentorAL m = new MentorAL("blah",s,s2,s3);
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(true,m.addStudent(s4));
    Assert.assertEquals(true,m.addStudent(s5));
    
    Assert.assertEquals(5,m.numberOfStudents());
    
    Assert.assertEquals(false,m.removeStudent(s6));
    Assert.assertEquals(true,m.removeStudent(s3));
    Assert.assertEquals(true,m.removeStudent(s4));
    Assert.assertEquals(false,m.removeStudent(s));
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  
  @Test
  public void deleteDoesNotChangeStudent()
  {
    StudentAL s = new StudentAL(99);
    StudentAL s2 = new StudentAL(98);
    StudentAL s3 = new StudentAL(98);

    ProgramAL p = new ProgramAL();
    s.setProgram(p);
    
    MentorAL m = new MentorAL("blah",s,s2,s3);
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
  }
}
