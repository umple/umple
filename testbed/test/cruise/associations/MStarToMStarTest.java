package cruise.associations;

import org.junit.*;

import cruise.associations.MentorX;
import cruise.associations.ProgramX;
import cruise.associations.StudentX;

public class MStarToMStarTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentX s = new StudentX(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorX m = new MentorX("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustEnough()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(97);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4));
    
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
  }  
  
  @Test
  public void SetStudentsNeverAtMax()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    StudentX s6 = new StudentX(95);
    StudentX s7 = new StudentX(95);
    StudentX s8 = new StudentX(95);
    StudentX s9 = new StudentX(95);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4,s5,s6,s7,s8,s9));
    
    Assert.assertEquals(9, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
    Assert.assertEquals(m,s5.getMentor(0));
    Assert.assertEquals(m,s6.getMentor(0));
    Assert.assertEquals(m,s7.getMentor(0));
    Assert.assertEquals(m,s8.getMentor(0));
    Assert.assertEquals(m,s9.getMentor(0));
  }   
  
  @Test
  public void AddStudents()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    
    Assert.assertEquals(true,m.addStudent(s));
    
    for (int i=2; i<10; i++)
    {
      StudentX s2 = new StudentX(i);
      Assert.assertEquals(true,m.addStudent(s2));
      Assert.assertEquals(i,m.numberOfStudents());
      Assert.assertEquals(m,s2.getMentor(0));
    }
  }   
  
  @Test
  public void RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(97);


    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4));
    Assert.assertEquals(false,m.removeStudent(s2));
    
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(s2,m.getStudent(1));
  } 
  
  @Test
  public void RemoveStudents()
  {
    MentorX m = new MentorX("blah");
    MentorX m2 = new MentorX("blah2");
    MentorX m3 = new MentorX("blah3");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    StudentX s6 = new StudentX(94);

    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    m3.setStudents(s,s2,s3,s4,s5);
    
    
    Assert.assertEquals(false,m.removeStudent(s6));
    Assert.assertEquals(true,m.removeStudent(s5));
    
    Assert.assertEquals(2,s5.numberOfMentors());
    Assert.assertEquals(4, m.numberOfStudents());
  } 
  
  @Test
  public void SetStudentsTooFew()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    StudentX s6 = new StudentX(94);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(false,m.setStudents(s4,s5));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    Assert.assertEquals(0,s6.numberOfMentors());
  }   
  
  @Test
  public void MentorNeverHasEnoughStudents()
  {
    MentorX m = new MentorX("blah");
    
    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    
    StudentX s6 = new StudentX(94);
    Assert.assertEquals(true,m.addStudent(s6));
    
    Assert.assertEquals(6, m.numberOfStudents());
    Assert.assertEquals(1,s6.numberOfMentors());
  }    

  @Test
  public void replaceMentor()
  {
    MentorX m = new MentorX("blah");
    MentorX m2 = new MentorX("blah2");
    MentorX m3 = new MentorX("blah2");

    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    Assert.assertEquals(true,s.setMentors(m2,m3));

    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(1,m2.numberOfStudents());
    Assert.assertEquals(1,m3.numberOfStudents());
    Assert.assertEquals(2,s.numberOfMentors());
  } 

  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorX m = new MentorX("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentX(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentX(98));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentX(97));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

    m.addStudent(new StudentX(96));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());
  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorX.minimumNumberOfStudents());
  }  
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorX m = new MentorX("blah");
    MentorX m2 = new MentorX("blah2");
    MentorX m3 = new MentorX("blah2");

    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    m3.setStudents(s,s2,s3,s4,s5);
    
    ProgramX p = new ProgramX();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(2,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorX m = new MentorX("blah");
    MentorX m2 = new MentorX("blah2");

    StudentX s = new StudentX(99);
    StudentX s2 = new StudentX(98);
    StudentX s3 = new StudentX(97);
    StudentX s4 = new StudentX(96);
    StudentX s5 = new StudentX(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3);
    
    ProgramX p = new ProgramX();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
