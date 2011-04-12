package cruise.test;

import org.junit.*;

public class OneToOptionalNTest
{

  @Test(expected=RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new StudentZ(99,null);
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorZ m = new MentorZ("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }

  @Test
  public void CannotSetMentorNull()
  {
    MentorZ m = new MentorZ("blah");
    StudentZ s = new StudentZ(99,m);
    
    Assert.assertEquals(false,s.setMentor(null));
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(s,m.getStudent(0));
  } 
  
  @Test
  public void CreateStudentFromMentor()
  {
    MentorZ m = new MentorZ("blah");
    StudentZ s = new StudentZ(99,m);

    Assert.assertEquals(99,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test(expected=RuntimeException.class)
  public void CreateStudentFromMentorTooMany()
  {
    MentorZ m = new MentorZ("blah");
    new StudentZ(99,m);
    new StudentZ(99,m);
    new StudentZ(99,m);
    new StudentZ(99,m);
  }  
  
  @Test
  public void CannotSetMentorAlreadyAtMax()
  {
    MentorZ m = new MentorZ("blah");
    MentorZ m2 = new MentorZ("blah2");
    
    new StudentZ(99,m);
    new StudentZ(99,m);
    new StudentZ(99,m);
    
    new StudentZ(99,m2);
    new StudentZ(99,m2);
    StudentZ s = new StudentZ(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());
  }    

  
  @Test
  public void CreateStudentFromMentorJustEnough()
  {
    MentorZ m = new MentorZ("blah");
    StudentZ s = new StudentZ(99,m);
    StudentZ s2 = new StudentZ(99,m);
    StudentZ s3 = new StudentZ(99,m);
    
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
  }   
  
  @Test
  public void MaximumNumberOfStudents()
  {
    Assert.assertEquals(3,MentorZ.maximumNumberOfStudents());
  }
  
  @Test
  public void addStudentViaConstructorInformation()
  {
    MentorZ m = new MentorZ("blah");
    StudentZ s = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }
  
  @Test
  public void addStudentViaConstructorInformationTooMany()
  {
    MentorZ m = new MentorZ("blah");
    StudentZ s = m.addStudent(10);
    StudentZ s2 = m.addStudent(10);
    StudentZ s3 = m.addStudent(10);
    StudentZ s4 = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
    Assert.assertEquals(s2, m.getStudent(1));
    Assert.assertEquals(s3, m.getStudent(2));
    Assert.assertEquals(null,s4);
  }  
  
  @Test
  public void replaceMentor()
  {
    MentorZ m = new MentorZ("blah");
    MentorZ m2 = new MentorZ("blah2");

    StudentZ s = m.addStudent(123);
    StudentZ s2 = m2.addStudent(125);
    
    Assert.assertEquals(true,s.setMentor(m2));
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(s2, m2.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(1));
    
    Assert.assertEquals(0, m.numberOfStudents());
    
  } 
  
  @Test
  public void addToNewMentor()
  {
    MentorZ m = new MentorZ("blah");
    MentorZ m2 = new MentorZ("blah2");

    StudentZ s = m.addStudent(123);
    m2.addStudent(s);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  }  
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorZ m = new MentorZ("blah");
    MentorZ m2 = new MentorZ("blah2");

    StudentZ s1 = m.addStudent(123);
    StudentZ s2 = m.addStudent(124);
    StudentZ s3 = m.addStudent(125);
    
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
    MentorZ m = new MentorZ("blah");
    StudentZ s = new StudentZ(99,m);
    
    MentorZ m2 = new MentorZ("blah2");
    
    s.setMentor(m2);
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());    
  }  
  
  @Test
  public void addStudentWhenMentorHasTooMany()
  {
    MentorZ m = new MentorZ("blah");
    MentorZ m2 = new MentorZ("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    m.addStudent(14);
    
    m2.addStudent(21);
    m2.addStudent(22);
    StudentZ s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(3,m2.numberOfStudents());
  }
}
