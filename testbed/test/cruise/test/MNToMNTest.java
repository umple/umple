package cruise.test;

import org.junit.*;

public class MNToMNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentS s = new StudentS(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorS m = new MentorS("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustEnough()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
  }  
  
  @Test
  public void SetStudentsAtMax()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4,s5));
    
    Assert.assertEquals(5, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
    Assert.assertEquals(m,s5.getMentor(0));
  }   
  
  @Test
  public void AddStudents_DuplicateNotOkay()
  {
    MentorS m = new MentorS("blah");
    StudentS s = new StudentS(99);    

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(false,m.addStudent(s));
    Assert.assertEquals(1,m.numberOfStudents());
  }
  
  @Test
  public void AddStudents()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    StudentS s6 = new StudentS(94);

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(true,m.addStudent(s3));
    Assert.assertEquals(true,m.addStudent(s4));
    Assert.assertEquals(true,m.addStudent(s5));
    Assert.assertEquals(false,m.addStudent(s6));
    
    Assert.assertEquals(5, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
    Assert.assertEquals(m,s5.getMentor(0));
    Assert.assertEquals(0,s6.numberOfMentors());
  }   
  
  @Test
  public void RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);


    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    Assert.assertEquals(false,m.removeStudent(s2));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(s2,m.getStudent(1));
  } 
  
  @Test
  public void RemoveStudents()
  {
    MentorS m = new MentorS("blah");
    MentorS m2 = new MentorS("blah2");
    MentorS m3 = new MentorS("blah3");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    StudentS s6 = new StudentS(94);

    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    m3.setStudents(s,s2,s3,s4,s5);
    
    
    Assert.assertEquals(false,m.removeStudent(s6));
    Assert.assertEquals(true,m.removeStudent(s5));
    
    Assert.assertEquals(2,s5.numberOfMentors());
    Assert.assertEquals(4, m.numberOfStudents());
  } 
  
  @Test
  public void SetStudentsTooManyAndTooFew()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    StudentS s6 = new StudentS(94);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(false,m.setStudents(s4,s5));
    Assert.assertEquals(false,m.setStudents(s4,s5,s,s2,s3,s6));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    Assert.assertEquals(0,s6.numberOfMentors());
  }   
  
  @Test
  public void MentorAlreadyHasEnoughStudents()
  {
    MentorS m = new MentorS("blah");
    
    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    StudentS s7 = new StudentS(94);    
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4,s5));
    
    StudentS s6 = new StudentS(94);
    Assert.assertEquals(false,m.addStudent(s6));
    Assert.assertEquals(false,s7.addMentor(m));
    
    Assert.assertEquals(5, m.numberOfStudents());
    Assert.assertEquals(0,s6.numberOfMentors());
  }    

  @Test
  public void replaceMentor()
  {
    MentorS m = new MentorS("blah");
    MentorS m2 = new MentorS("blah2");
    MentorS m3 = new MentorS("blah2");

    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    
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
    MentorS m = new MentorS("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentS(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentS(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentS(99));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorS.minimumNumberOfStudents());
    Assert.assertEquals(5,MentorS.maximumNumberOfStudents());
  }  
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorS m = new MentorS("blah");
    MentorS m2 = new MentorS("blah2");
    MentorS m3 = new MentorS("blah2");

    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    m3.setStudents(s,s2,s3,s4,s5);
    
    ProgramS p = new ProgramS();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(2,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorS m = new MentorS("blah");
    MentorS m2 = new MentorS("blah2");

    StudentS s = new StudentS(99);
    StudentS s2 = new StudentS(98);
    StudentS s3 = new StudentS(97);
    StudentS s4 = new StudentS(96);
    StudentS s5 = new StudentS(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3);
    
    ProgramS p = new ProgramS();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
