package cruise.test;

import org.junit.*;

public class OneToMandatoryManyTest
{

  @Test(expected=RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new StudentM(99,null);
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorM m = new MentorM("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void CannotSetMentorNull()
  {
    MentorM m = new MentorM("blah");
    StudentM s = new StudentM(99,m);
    
    Assert.assertEquals(false,s.setMentor(null));
  }  

  @Test
  public void CanAlwaysSetMentorNeverAtMax()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");
    
    new StudentM(99,m);
    new StudentM(99,m);
    new StudentM(99,m);
    
    new StudentM(99,m2);
    new StudentM(99,m2);
    
    for (int i=1; i<=10; i++)
    {
      StudentM s = new StudentM(99,m2);
      Assert.assertEquals(true,s.setMentor(m));
      Assert.assertEquals(2,m2.numberOfStudents());
      Assert.assertEquals(3+i,m.numberOfStudents());
    }
  }    

  @Test
  public void CannotSetMentorExistingAtMin()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");
    
    new StudentM(99,m);
    new StudentM(99,m);
    
    new StudentM(99,m2);
    StudentM s = new StudentM(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());

  
  }   
  
  @Test
  public void CreateStudentFromMentor()
  {
    MentorM m = new MentorM("blah");
    StudentM s = new StudentM(99,m);

    Assert.assertEquals(99,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test
  public void addStudentViaConstructorInformation()
  {
    MentorM m = new MentorM("blah");
    StudentM s = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }

  @Test
  public void addStudentViaConstructorInformation_neverTooMany()
  {
    MentorM m = new MentorM("blah");
    
    for (int i=1; i<10; i++)
    {
      StudentM s = m.addStudent(i);
      Assert.assertEquals(true,s != null);
      Assert.assertEquals(i,m.numberOfStudents());
    }
  }
  
  @Test
  public void createStudentMentoNeverHasEnough()
  {
    MentorM m = new MentorM("blah");
    for (int i=1; i<12; i++)
    {
      new StudentM(10,m);
      Assert.assertEquals(i,m.numberOfStudents());
    }
  }  
  
  
  @Test
  public void cannotReplaceMentorIfNotLeftWithoutEnoughStudents()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");

    StudentM s = m.addStudent(123);
    m2.addStudent(125);
    
    Assert.assertEquals(false,s.setMentor(m2));
  }
  
  @Test
  public void replaceMentor()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");

    StudentM s = m.addStudent(123);
    m.addStudent(125);
    m.addStudent(124);
    
    StudentM s2 = m2.addStudent(122);
    
    
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
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");

    StudentM s = m.addStudent(123);
    m.addStudent(123);
    m.addStudent(123);
    
    Assert.assertEquals(true,m2.addStudent(s));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(2, m.numberOfStudents());
  }  
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");

    StudentM s1 = m.addStudent(123);
    StudentM s2 = m.addStudent(124);
    StudentM s3 = m.addStudent(125);
    
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
    MentorM m = new MentorM("blah");
    StudentM s = new StudentM(99,m);
    new StudentM(98,m);
    new StudentM(97,m);
    
    MentorM m2 = new MentorM("blah2");
    
    Assert.assertEquals(true,s.setMentor(m2));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(2, m.numberOfStudents());    
  }
  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorM m = new MentorM("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentM(99,m);
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentM(99,m);
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

    new StudentM(99,m);
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(2,MentorM.minimumNumberOfStudents());
  }  

  @Test
  public void addStudentMentorNeverHasTooMany()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    m.addStudent(14);
    
    m2.addStudent(21);
    m2.addStudent(22);
    StudentM s = m2.addStudent(23);
    
    Assert.assertEquals(true,m.addStudent(s));

    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
  }  

  @Test
  public void addStudentWhenMentorHasTooFew()
  {
    MentorM m = new MentorM("blah");
    MentorM m2 = new MentorM("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    
    m2.addStudent(21);
    StudentM s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
  }  
}
