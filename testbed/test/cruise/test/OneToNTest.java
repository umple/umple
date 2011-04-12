package cruise.test;

import org.junit.*;

public class OneToNTest
{

  @Test(expected=RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new StudentL(99,null);
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorL m = new MentorL("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void CannotSetMentorNull()
  {
    MentorL m = new MentorL("blah");
    StudentL s = new StudentL(99,m);
    
    Assert.assertEquals(false,s.setMentor(null));
  }  

  @Test
  public void CannotSetMentorAlreadyAtMax()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");
    
    new StudentL(99,m);
    new StudentL(99,m);
    
    new StudentL(99,m2);
    StudentL s = new StudentL(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());
  }    

  @Test
  public void CannotSetMentorExistingAtMin()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");
    
    new StudentL(99,m);
    new StudentL(99,m);
    
    new StudentL(99,m2);
    StudentL s = new StudentL(99,m2);
    Assert.assertEquals(false,s.setMentor(m));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(m2,s.getMentor());

  
  }   
  
  @Test
  public void CreateStudentFromMentor()
  {
    MentorL m = new MentorL("blah");
    StudentL s = new StudentL(99,m);

    Assert.assertEquals(99,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test
  public void addStudentViaConstructorInformation()
  {
    MentorL m = new MentorL("blah");
    StudentL s = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }

  @Test
  public void addStudentViaConstructorInformation_tooMany()
  {
    MentorL m = new MentorL("blah");
    m.addStudent(10);
    m.addStudent(11);
    m.addStudent(12);
    Assert.assertEquals(null, m.addStudent(13));
  }
  
  @Test(expected=RuntimeException.class)
  public void createStudentWhenMentorAlreadyHasEnogh()
  {
    MentorL m = new MentorL("blah");
    new StudentL(10,m);
    new StudentL(10,m);
    new StudentL(10,m);
    new StudentL(10,m);
  }  
  
  
  @Test
  public void cannotReplaceMentor()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");

    StudentL s = m.addStudent(123);
    m2.addStudent(125);
    
    Assert.assertEquals(false,s.setMentor(m2));
    Assert.assertEquals(m, s.getMentor());
    Assert.assertEquals(1, m2.numberOfStudents());
    
    Assert.assertEquals(1, m.numberOfStudents());
    
  } 
  
  @Test
  public void cannotReassign()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");

    StudentL s = m.addStudent(123);
    Assert.assertEquals(false,m2.addStudent(s));
  }  
  
  @Test
  public void cannotRemoveFromExistingMentor()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");

    StudentL s1 = m.addStudent(123);
    m.addStudent(124);
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());
    
    Assert.assertEquals(false,m2.addStudent(s1));
  }
  
  @Test
  public void isNumberOfStudentsValid()
  {
    MentorL m = new MentorL("blah");
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentL(99,m);
    Assert.assertEquals(false,m.isNumberOfStudentsValid());

    new StudentL(99,m);
    Assert.assertEquals(true,m.isNumberOfStudentsValid());

  }
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(2,MentorL.minimumNumberOfStudents());
    Assert.assertEquals(2,MentorL.maximumNumberOfStudents());
  }  

  @Test
  public void addStudentWhenMentorHasTooMany()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    
    m2.addStudent(21);
    m2.addStudent(22);
    StudentL s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
  }  

  @Test
  public void addStudentWhenMentorHasTooFew()
  {
    MentorL m = new MentorL("blah");
    MentorL m2 = new MentorL("blah2");
    
    m.addStudent(12);
    m.addStudent(13);
    
    m2.addStudent(21);
    StudentL s = m2.addStudent(23);
    
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
  }  
}
