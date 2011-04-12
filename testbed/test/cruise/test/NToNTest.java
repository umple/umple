package cruise.test;

import org.junit.*;

public class NToNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentV s = new StudentV(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorV m = new MentorV("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustRightEnough()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
  }  
  
  @Test
  public void SetStudentsTooMany()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    StudentV s4 = new StudentV(96);
    
    Assert.assertEquals(false,m.setStudents(s,s2,s3,s4));
  }   
  
  @Test
  public void AddStudents()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    StudentV s4 = new StudentV(96);
    StudentV s5 = new StudentV(95);
    StudentV s6 = new StudentV(94);

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(true,m.addStudent(s3));
    Assert.assertEquals(false,m.addStudent(s4));
    Assert.assertEquals(false,m.addStudent(s5));
    Assert.assertEquals(false,m.addStudent(s6));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    Assert.assertEquals(0,s6.numberOfMentors());
  }   
  
  @Test
  public void CannotRemoveStudents()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);

    m.setStudents(s,s2,s3);
    Assert.assertEquals(false, m.removeStudent(s3));
  } 
  
  @Test
  public void SetStudentsTooManyAndTooFew()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    StudentV s4 = new StudentV(96);
    StudentV s5 = new StudentV(95);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(false,m.setStudents(s4,s5));
    Assert.assertEquals(false,m.setStudents(s4,s5,s,s2));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
  }   
  
  @Test
  public void MentorAlreadyHasEnoughStudents()
  {
    MentorV m = new MentorV("blah");
    
    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    
    m.setStudents(s,s2,s3);
    
    StudentV s6 = new StudentV(94);
    Assert.assertEquals(false,m.addStudent(s6));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(0,s6.numberOfMentors());
  }    

  @Test
  public void setMentors()
  {
    MentorV m = new MentorV("blah2");
    MentorV m2 = new MentorV("blah2");
    MentorV m3 = new MentorV("blah2");
    MentorV m4 = new MentorV("blah2");

    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    
    Assert.assertEquals(true,s.setMentors(m2,m3,m,m4));
    Assert.assertEquals(true,m2.addStudent(s2));

    
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(1,m3.numberOfStudents());
    Assert.assertEquals(4,s.numberOfMentors());
  } 

  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorV m = new MentorV("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentV(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentV(98));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentV(97));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());
  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorV.minimumNumberOfStudents());
    Assert.assertEquals(3,MentorV.maximumNumberOfStudents());
  }  
  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorV m = new MentorV("blah");
    MentorV m2 = new MentorV("blah2");

    StudentV s = new StudentV(99);
    StudentV s2 = new StudentV(98);
    StudentV s3 = new StudentV(97);
    
    m.setStudents(s,s2,s3);
    m2.setStudents(s,s2,s3);
    
    ProgramV p = new ProgramV();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
