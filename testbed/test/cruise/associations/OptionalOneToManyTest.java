package cruise.associations;

import org.junit.*;

import cruise.associations.MentorC;
import cruise.associations.StudentC;

public class OptionalOneToManyTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentC s = new StudentC(99);
    Assert.assertEquals(null,s.getMentor());
  }
  
  @Test
  public void addStudent()
  {
    MentorC m = new MentorC("m1");
    StudentC s = new StudentC(99);
    m.addStudent(s);
    
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(m, s.getMentor());
    Assert.assertEquals(s, m.getStudent(0));
  }
  
  @Test
  public void replaceMentor()
  {
    MentorC m = new MentorC("m1");
    MentorC m2 = new MentorC("m2");

    StudentC s = new StudentC(99);
    m.addStudent(s);
    Assert.assertEquals(1, m.numberOfStudents());

    
    s.setMentor(m2);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  } 
  
  @Test
  public void addToNewMentor()
  {
    MentorC m = new MentorC("m1");
    MentorC m2 = new MentorC("m2");
    StudentC s = new StudentC(99);
    
    m.addStudent(s);
    m2.addStudent(s);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  }  
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorC m = new MentorC("m1");
    MentorC m2 = new MentorC("m2");

    StudentC s1 = new StudentC(99);
    StudentC s2 = new StudentC(98);
    StudentC s3 = new StudentC(97);
    
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
    MentorC m = new MentorC("m1");
    StudentC s = new StudentC(99);
    
    m.addStudent(s);
    m.removeStudent(s);
    
    Assert.assertEquals(null,s.getMentor());
    Assert.assertEquals(0,m.numberOfStudents());
    
  }  

  
  
}
