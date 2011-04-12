package cruise.test;

import org.junit.*;

public class NToMStarTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentW s = new StudentW(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorW m = new MentorW("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustEnough()
  {
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(97);
    
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
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    StudentW s6 = new StudentW(95);
    StudentW s7 = new StudentW(95);
    StudentW s8 = new StudentW(95);
    StudentW s9 = new StudentW(95);
    
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
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    
    Assert.assertEquals(true,m.addStudent(s));
    
    for (int i=2; i<10; i++)
    {
      StudentW s2 = new StudentW(i);
      Assert.assertEquals(true,m.addStudent(s2));
      Assert.assertEquals(i,m.numberOfStudents());
      Assert.assertEquals(m,s2.getMentor(0));
    }
  }   
  
  @Test
  public void RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(97);


    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4));
    Assert.assertEquals(false,m.removeStudent(s2));
    
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(s2,m.getStudent(1));
  } 
  
  @Test
  public void CannotRemoveStudentsBecauseNeedsFixedNumberOfMentors()
  {
    MentorW m = new MentorW("blah");
    MentorW m2 = new MentorW("blah2");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    StudentW s6 = new StudentW(94);

    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    
    Assert.assertEquals(false,m.removeStudent(s6));
    Assert.assertEquals(false,m.removeStudent(s5));
    
    Assert.assertEquals(2,s5.numberOfMentors());
    Assert.assertEquals(5, m.numberOfStudents());
  } 
  
  @Test
  public void SetStudentsTooFew()
  {
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    StudentW s6 = new StudentW(94);
    
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
    MentorW m = new MentorW("blah");
    
    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    
    StudentW s6 = new StudentW(94);
    Assert.assertEquals(true,m.addStudent(s6));
    
    Assert.assertEquals(6, m.numberOfStudents());
    Assert.assertEquals(1,s6.numberOfMentors());
  }    

  @Test
  public void replaceMentor()
  {
    MentorW m = new MentorW("blah");
    MentorW m2 = new MentorW("blah2");
    MentorW m3 = new MentorW("blah2");

    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    
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
    MentorW m = new MentorW("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentW(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentW(98));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentW(97));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorW.minimumNumberOfStudents());
  }  
  
  @Test
  public void deleteMentorDeletesStudents()
  {
    MentorW m = new MentorW("blah");
    MentorW m2 = new MentorW("blah2");

    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    
    ProgramW p = new ProgramW();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(null,s.getProgram());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorDeletesStudentThatThenDeletesMentor()
  {
    MentorW m = new MentorW("blah");
    MentorW m2 = new MentorW("blah2");

    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    
    m.setStudents(s,s2,s3,s4);
    m2.setStudents(s,s2,s3);
    
    ProgramW p = new ProgramW();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(null,s.getProgram());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorW m = new MentorW("blah");
    MentorW m2 = new MentorW("blah2");

    StudentW s = new StudentW(99);
    StudentW s2 = new StudentW(98);
    StudentW s3 = new StudentW(97);
    StudentW s4 = new StudentW(96);
    StudentW s5 = new StudentW(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3);
    
    ProgramW p = new ProgramW();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
