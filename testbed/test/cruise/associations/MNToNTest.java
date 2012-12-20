package cruise.associations;

import org.junit.*;

import cruise.associations.MentorT;
import cruise.associations.ProgramT;
import cruise.associations.StudentT;

public class MNToNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentT s = new StudentT(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorT m = new MentorT("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetStudentsJustRightEnough()
  {
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    
    Assert.assertEquals(true,m.setStudents(s,s2,s3));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
  }  
  
  @Test
  public void SetStudentsTooMany()
  {
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    StudentT s4 = new StudentT(96);
    
    Assert.assertEquals(false,m.setStudents(s,s2,s3,s4));
  }   
  
  @Test
  public void AddStudents()
  {
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    StudentT s4 = new StudentT(96);
    StudentT s5 = new StudentT(95);
    StudentT s6 = new StudentT(94);

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
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);

    m.setStudents(s,s2,s3);
    Assert.assertEquals(false, m.removeStudent(s3));
  } 
  
  @Test
  public void SetStudentsTooManyAndTooFew()
  {
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    StudentT s4 = new StudentT(96);
    StudentT s5 = new StudentT(95);
    
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
    MentorT m = new MentorT("blah");
    
    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    
    m.setStudents(s,s2,s3);
    
    StudentT s6 = new StudentT(94);
    Assert.assertEquals(false,m.addStudent(s6));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(0,s6.numberOfMentors());
  }    

  @Test
  public void setMentors()
  {
    MentorT m2 = new MentorT("blah2");
    MentorT m3 = new MentorT("blah2");

    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    
    Assert.assertEquals(true,s.setMentors(m2,m3));
    Assert.assertEquals(true,m2.addStudent(s2));

    
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(1,m3.numberOfStudents());
    Assert.assertEquals(2,s.numberOfMentors());
  } 

  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorT m = new MentorT("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentT(99));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentT(98));
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    m.addStudent(new StudentT(97));
    Assert.assertEquals(true,m.isNumberOfStudentsValid());
  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorT.minimumNumberOfStudents());
    Assert.assertEquals(3,MentorT.maximumNumberOfStudents());
  }  
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorT m = new MentorT("blah");
    MentorT m2 = new MentorT("blah2");
    MentorT m3 = new MentorT("blah2");

    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    
    m.setStudents(s,s2,s3);
    m2.setStudents(s,s2,s3);
    m3.setStudents(s,s2,s3);
    
    ProgramT p = new ProgramT();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(2,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorT m = new MentorT("blah");
    MentorT m2 = new MentorT("blah2");

    StudentT s = new StudentT(99);
    StudentT s2 = new StudentT(98);
    StudentT s3 = new StudentT(97);
    
    m.setStudents(s,s2,s3);
    m2.setStudents(s,s2,s3);
    
    ProgramT p = new ProgramT();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
