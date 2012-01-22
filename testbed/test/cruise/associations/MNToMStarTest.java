package cruise.associations;

import org.junit.*;

import cruise.associations.MentorU;
import cruise.associations.ProgramU;
import cruise.associations.StudentU;

public class MNToMStarTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentU s = new StudentU(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorU m = new MentorU("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustEnough()
  {
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(97);
    
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
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    StudentU s6 = new StudentU(95);
    StudentU s7 = new StudentU(95);
    StudentU s8 = new StudentU(95);
    StudentU s9 = new StudentU(95);
    
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
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    
    Assert.assertEquals(true,m.addStudent(s));
    
    for (int i=2; i<10; i++)
    {
      StudentU s2 = new StudentU(i);
      Assert.assertEquals(true,m.addStudent(s2));
      Assert.assertEquals(i,m.numberOfStudents());
      Assert.assertEquals(m,s2.getMentor(0));
    }
  }   
  
  @Test
  public void RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(97);


    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4));
    Assert.assertEquals(false,m.removeStudent(s2));
    
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(s2,m.getStudent(1));
  } 
  
  @Test
  public void RemoveStudents()
  {
    MentorU m = new MentorU("blah");
    MentorU m2 = new MentorU("blah2");
    MentorU m3 = new MentorU("blah3");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    StudentU s6 = new StudentU(94);

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
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    StudentU s6 = new StudentU(94);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3,s4));
    
    Assert.assertEquals(false,m.setStudents(s4,s5,s3));
    
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
    Assert.assertEquals(0,s5.numberOfMentors());
    Assert.assertEquals(0,s6.numberOfMentors());
  }   
  
  @Test
  public void MentorNeverHasEnoughStudents()
  {
    MentorU m = new MentorU("blah");
    
    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    
    StudentU s6 = new StudentU(94);
    Assert.assertEquals(true,m.addStudent(s6));
    
    Assert.assertEquals(6, m.numberOfStudents());
    Assert.assertEquals(1,s6.numberOfMentors());
  }    

  @Test
  public void replaceMentor()
  {
    MentorU m = new MentorU("blah");
    MentorU m2 = new MentorU("blah2");
    MentorU m3 = new MentorU("blah2");

    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    
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
    MentorU m = new MentorU("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentU(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentU(98));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentU(97));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentU(96));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());
  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(4,MentorU.minimumNumberOfStudents());
  }  
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorU m = new MentorU("blah");
    MentorU m2 = new MentorU("blah2");
    MentorU m3 = new MentorU("blah2");

    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3,s4,s5);
    m3.setStudents(s,s2,s3,s4,s5);
    
    ProgramU p = new ProgramU();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(2,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorU m = new MentorU("blah");
    MentorU m2 = new MentorU("blah2");

    StudentU s = new StudentU(99);
    StudentU s2 = new StudentU(98);
    StudentU s3 = new StudentU(97);
    StudentU s4 = new StudentU(96);
    StudentU s5 = new StudentU(95);
    
    m.setStudents(s,s2,s3,s4,s5);
    m2.setStudents(s,s2,s3);
    
    ProgramU p = new ProgramU();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
