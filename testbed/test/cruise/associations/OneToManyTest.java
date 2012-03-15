package cruise.associations;

import org.junit.*;

import cruise.associations.MentorJ;
import cruise.associations.StudentJ;

public class OneToManyTest
{

  @Test(expected=RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new StudentJ(99,null);
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorJ m = new MentorJ("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }

  @Test
  public void CreateStudentFromMentor()
  {
    MentorJ m = new MentorJ("blah");
    StudentJ s = new StudentJ(99,m);

    Assert.assertEquals(99,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test
  public void addStudentViaConstructorInformation()
  {
    MentorJ m = new MentorJ("blah");
    StudentJ s = m.addStudent(10);

    Assert.assertEquals(10,s.getNumber());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }
  
  @Test
  public void replaceMentor()
  {
    MentorJ m = new MentorJ("blah");
    MentorJ m2 = new MentorJ("blah2");

    StudentJ s = m.addStudent(123);
    StudentJ s2 = m2.addStudent(125);
    
    s.setMentor(m2);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(s2, m2.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(1));
    
    Assert.assertEquals(0, m.numberOfStudents());
    
  } 
  
  @Test
  public void addToNewMentor()
  {
    MentorJ m = new MentorJ("blah");
    MentorJ m2 = new MentorJ("blah2");

    StudentJ s = m.addStudent(123);
    m2.addStudent(s);
    
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());
  }  
  
  @Test
  public void removeFromExistingMentor()
  {
    MentorJ m = new MentorJ("blah");
    MentorJ m2 = new MentorJ("blah2");

    StudentJ s1 = m.addStudent(123);
    StudentJ s2 = m.addStudent(124);
    StudentJ s3 = m.addStudent(125);
    
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
  public void cannotSetMentorNull()
  {
    MentorJ m = new MentorJ("blah");
    StudentJ s = new StudentJ(99,m);
    Assert.assertEquals(false,s.setMentor(null));
    Assert.assertEquals(m, s.getMentor());
    Assert.assertEquals(s,m.getStudent(0));
  }
  
  @Test
  public void setMentorReplacesExistingMentor()
  {
    MentorJ m = new MentorJ("blah");
    StudentJ s = new StudentJ(99,m);
    
    MentorJ m2 = new MentorJ("blah2");
    
    s.setMentor(m2);
    Assert.assertEquals(m2, s.getMentor());
    Assert.assertEquals(s, m2.getStudent(0));
    Assert.assertEquals(0, m.numberOfStudents());    
  }  
  
  @Test
  public void deleteManyEnd()
  {
    MentorJ m = new MentorJ("blah");
    StudentJ s1 = new StudentJ(99,m);
    StudentJ s2 = new StudentJ(98,m);
    
    Assert.assertEquals(2, m.numberOfStudents()); 
    Assert.assertEquals(m,s1.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    
    s1.delete();
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(null,s1.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    
    s2.delete();
    Assert.assertEquals(null,s1.getMentor());
    Assert.assertEquals(null,s2.getMentor());
  }
  
}
