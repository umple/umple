package cruise.associations;

import org.junit.*;

import cruise.associations.MentorI;
import cruise.associations.ProgramI;
import cruise.associations.StudentI;

public class UnidirectionalMNTest
{

  @Test(expected=RuntimeException.class)
  public void constructorTooFew()
  {
    StudentI s = new StudentI(99);
    new MentorI("blah",s);
  }
  
  @Test(expected=RuntimeException.class)
  public void constructorTooMany()
  {
    StudentI s = new StudentI(99);
    StudentI s2 = new StudentI(98);
    StudentI s3 = new StudentI(97);
    StudentI s4 = new StudentI(96);
    StudentI s5 = new StudentI(96);
    
    new MentorI("blah",s,s2,s3,s4,s5);
  }

  
  @Test
  public void constructorRequiresMinimumToMaximum()
  {
    StudentI s = new StudentI(99);
    StudentI s2 = new StudentI(98);
    StudentI s3 = new StudentI(97);
    StudentI s4 = new StudentI(96);
    
    MentorI m = new MentorI("blah",s,s2);
    Assert.assertEquals(2,m.numberOfStudents());

    MentorI m2 = new MentorI("blah2",s,s2,s3,s4);
    Assert.assertEquals(4,m2.numberOfStudents());
  }
  
  @Test
  public void addRemoveWithinLimits()
  {
    StudentI s = new StudentI(99);
    StudentI s2 = new StudentI(98);
    StudentI s3 = new StudentI(97);
    StudentI s4 = new StudentI(96);
    StudentI s5 = new StudentI(95);
    
    MentorI m = new MentorI("blah",s,s2);
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(true,m.addStudent(s3));
    Assert.assertEquals(true,m.addStudent(s4));
    Assert.assertEquals(false,m.addStudent(s4));
    
    Assert.assertEquals(4,m.numberOfStudents());
    
    Assert.assertEquals(false,m.removeStudent(s5));
    Assert.assertEquals(true,m.removeStudent(s3));
    Assert.assertEquals(true,m.removeStudent(s4));
    Assert.assertEquals(false,m.removeStudent(s));
    Assert.assertEquals(2,m.numberOfStudents());
  }
  
  
  @Test
  public void deleteDoesNotChangeStudent()
  {
    StudentI s = new StudentI(99);
    StudentI s2 = new StudentI(98);

    ProgramI p = new ProgramI();
    s.setProgram(p);
    
    MentorI m = new MentorI("blah",s,s2);
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
  }
}
