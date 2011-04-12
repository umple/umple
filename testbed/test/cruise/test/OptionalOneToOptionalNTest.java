package cruise.test;

import org.junit.*;

public class OptionalOneToOptionalNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentY s = new StudentY(99);
    Assert.assertEquals(null,s.getMentor());
  }
  
  @Test
  public void addStudent()
  {
    MentorY m = new MentorY("blah");
    StudentY s = new StudentY(99);
    m.addStudent(s);
    
    Assert.assertEquals(m, s.getMentor());
    Assert.assertEquals(s, m.getStudent(0));
  }

  @Test
  public void addStudentCannotAddForever()
  {
    MentorY m = new MentorY("blah");
    Assert.assertEquals(true,m.addStudent(new StudentY(99)));
    Assert.assertEquals(true,m.addStudent(new StudentY(98)));
    Assert.assertEquals(true,m.addStudent(new StudentY(97)));
    Assert.assertEquals(true,m.addStudent(new StudentY(96)));
    Assert.assertEquals(false,m.addStudent(new StudentY(95)));
  }

  
  @Test
  public void replaceMentor()
  {
    MentorY m = new MentorY("blah");
    MentorY m2 = new MentorY("blah2");

    StudentY s = new StudentY(99);
    m.addStudent(s);
    s.setMentor(m2);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  } 

  @Test
  public void cannotReplaceIfFull()
  {
    MentorY m = new MentorY("blah");
    MentorY m2 = new MentorY("blah2");

    m2.addStudent(new StudentY(99));
    m2.addStudent(new StudentY(98));
    m2.addStudent(new StudentY(97));
    m2.addStudent(new StudentY(96));
    
    StudentY s = new StudentY(95);
    
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(false,s.setMentor(m2));
    
    Assert.assertEquals(m, s.getMentor());
    Assert.assertEquals(4, m2.numberOfStudents());
    Assert.assertEquals(1, m.numberOfStudents());
  } 
  
  @Test
  public void addToNewMentor()
  {
    MentorY m = new MentorY("blah");
    MentorY m2 = new MentorY("blah2");
    StudentY s = new StudentY(99);
    
    m.addStudent(s);
    m2.addStudent(s);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  }  
  
  @Test
  public void cannotAddToFullMentor()
  {
    MentorY m = new MentorY("blah");
    MentorY m2 = new MentorY("blah2");
    StudentY s = new StudentY(99);
    
    m.addStudent(new StudentY(99));
    m.addStudent(new StudentY(98));
    m.addStudent(new StudentY(97));
    m.addStudent(new StudentY(96));
    
    m2.addStudent(s);
    Assert.assertEquals(false,m.addStudent(s));
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(4, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());
  }
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorY m = new MentorY("blah");
    MentorY m2 = new MentorY("blah2");

    StudentY s1 = new StudentY(99);
    StudentY s2 = new StudentY(98);
    StudentY s3 = new StudentY(97);
    
    m.addStudent(s1);
    m.addStudent(s2);
    m.addStudent(s3);

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
  public void removeStudent()
  {
    MentorY m = new MentorY("blah");
    StudentY s = new StudentY(99);
    
    m.addStudent(s);
    m.removeStudent(s);
    
    Assert.assertEquals(null,s.getMentor());
    Assert.assertEquals(0,m.numberOfStudents());
    
  }  

  @Test
  public void maximumNumberOfStudents()
  {
    Assert.assertEquals(4,MentorY.maximumNumberOfStudents());
  }
  
  
}
