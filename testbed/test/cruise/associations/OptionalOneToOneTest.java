package cruise.associations;

import org.junit.*;

import cruise.associations.MentorB;
import cruise.associations.ProgramB;
import cruise.associations.StudentB;

public class OptionalOneToOneTest
{

  @Test
  public void Constructor()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    
    Assert.assertEquals(student,mentor.getStudent());
    Assert.assertEquals(mentor,student.getMentor());
  } 
  
  @Test
  public void CannotSetStudentBToNull()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    
    Assert.assertEquals(false,mentor.setStudent(null));
  }
    
  @Test
  public void SetStudent()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    
    StudentB student2 = new StudentB();
    Assert.assertEquals(true, mentor.setStudent(student2));
    
    
    Assert.assertEquals(mentor,student2.getMentor());
    Assert.assertEquals(student2,mentor.getStudent());
    Assert.assertEquals(null,student.getMentor());
  } 
  
  @Test
  public void SetMentorCannotReset()
  {
    StudentB s = new StudentB();
    MentorB m = new MentorB(s);
    
    StudentB s2 = new StudentB();
    MentorB m2 = new MentorB(s2);
    
    Assert.assertEquals(false,m.setStudent(s2));
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(s,m.getStudent());
    Assert.assertEquals(m2,s2.getMentor());
    Assert.assertEquals(s2,m2.getStudent());
  } 
  
  @Test
  public void SetMentor()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    
    StudentB student2 = new StudentB();
    student2.setMentor(mentor);
    
    Assert.assertEquals(mentor,student2.getMentor());
    Assert.assertEquals(student2,mentor.getStudent());
    Assert.assertEquals(null,student.getMentor());
  }   
  
  @Test(expected=RuntimeException.class)
  public void UnableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver()
  {
    StudentB student = new StudentB();
    new MentorB(student);
    new MentorB(student); 
  } 

  @Test
  public void DeleteDriverStudentHasNoMentor()
  {
    StudentB student = new StudentB();
    student.delete();
    Assert.assertEquals(null, student.getMentor());
  }
  
  @Test
  public void DeleteDriverRemovesSubordinate()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    ProgramB program = new ProgramB();
    mentor.setProgram(program);
    
    student.delete();
    Assert.assertEquals(null, student.getMentor());
    Assert.assertEquals(null, mentor.getStudent());
    Assert.assertEquals(null, mentor.getProgram());
  }  
  
  @Test
  public void DeleteSubordinateKeepDriver()
  {
    StudentB student = new StudentB();
    MentorB mentor = new MentorB(student);
    ProgramB program = new ProgramB();
    student.setProgram(program);
    
    mentor.delete();
    Assert.assertEquals(null, student.getMentor());
    Assert.assertEquals(null, mentor.getStudent());
    Assert.assertEquals(program, student.getProgram());
  }  
  
}
