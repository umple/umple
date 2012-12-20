package cruise.associations;

import org.junit.*;

import cruise.associations.MentorK;
import cruise.associations.StudentK;

public class OneToMNTest
{

  @Test(expected=RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new StudentK(99,null);
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorK m = new MentorK("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void CannotSetMentorNull()
  {
    MentorK m = new MentorK("blah");
    StudentK s = new StudentK(99,m);
    
    Assert.assertEquals(false,s.setMentor(null));
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(s,m.getStudent(0));
    
  }  

  @Test
  public void CannotSetMentorAlreadyAtMax()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");
    
    new StudentK(99,m);
    new StudentK(99,m);
    new StudentK(99,m);
    
    new StudentK(99,m2);
    new StudentK(99,m2);
    StudentK s = new StudentK(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());
  }    

  @Test
  public void CannotSetMentorExistingAtMin()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");
    
    new StudentK(99,m);
    new StudentK(99,m);
    
    new StudentK(99,m2);
    StudentK s = new StudentK(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());

  
  }   
  
  @Test
  public void CreateStudentFromMentor()
  {
    MentorK m = new MentorK("blah");
    StudentK s = new StudentK(99,m);

    Assert.assertEquals(99,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test
  public void addStudentViaConstructorInformation()
  {
    MentorK m = new MentorK("blah");
    StudentK s = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }

  @Test
  public void addStudentViaConstructorInformationTooMany()
  {
    MentorK m = new MentorK("blah");
    m.addStudent(10);
    m.addStudent(11);
    m.addStudent(12);
    Assert.assertEquals(null, m.addStudent(13));
  }
  
  @Test(expected=RuntimeException.class)
  public void createStudentWhenMentorAlreadyHasEnogh()
  {
    MentorK m = new MentorK("blah");
    new StudentK(10,m);
    new StudentK(10,m);
    new StudentK(10,m);
    new StudentK(10,m);
  }  
  
  
  @Test
  public void replaceMentor()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");

    StudentK s = m.addStudent(123);
    m.addStudent(125);
    m.addStudent(126);
    StudentK s2 = m2.addStudent(124);
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());
    
    Assert.assertEquals(true,s.setMentor(m2));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(s2, m2.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(1));
    
    Assert.assertEquals(2, m.numberOfStudents());
  } 
  
  @Test
  public void addToNewMentor()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");

    StudentK s = m.addStudent(123);
    m.addStudent(124);
    m.addStudent(125);
    
    Assert.assertEquals(true, m2.addStudent(s));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(2, m.numberOfStudents());
  }  
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");

    StudentK s1 = m.addStudent(123);
    StudentK s2 = m.addStudent(124);
    StudentK s3 = m.addStudent(125);
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());
    
    m2.addStudent(s1);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(s2, m.getStudent(0));
    Assert.assertEquals(s3, m.getStudent(1));
    
    Assert.assertEquals(1, m2.numberOfStudents());
    Assert.assertEquals(s1, m2.getStudent(0));
    
    Assert.assertEquals(m2, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());
  }   
  
  @Test
  public void setMentorReplacesExistingMentor()
  {
    MentorK m = new MentorK("blah");
    StudentK s = new StudentK(99,m);
    new StudentK(98,m);
    new StudentK(97,m);
    
    MentorK m2 = new MentorK("blah2");
    
    Assert.assertEquals(true,s.setMentor(m2));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(2, m.numberOfStudents());    
  }
  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorK m = new MentorK("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentK(99,m);
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentK(99,m);
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

    new StudentK(99,m);
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(2,MentorK.minimumNumberOfStudents());
    Assert.assertEquals(3,MentorK.maximumNumberOfStudents());
  }  

  @Test
  public void addStudentWhenMentorHasTooMany()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    m.addStudent(14);
    
    m2.addStudent(21);
    m2.addStudent(22);
    StudentK s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(3,m2.numberOfStudents());
  }  

  @Test
  public void addStudentWhenMentorHasTooFew()
  {
    MentorK m = new MentorK("blah");
    MentorK m2 = new MentorK("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    
    m2.addStudent(21);
    StudentK s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
  }  
}
