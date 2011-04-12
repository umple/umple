package cruise.test;

import org.junit.*;

public class ManyToManyTest
{

  @Test
  public void CreateNew()
  {
    StudentN s = new StudentN(99);
    Assert.assertEquals(0,s.numberOfMentors());
    
    MentorN m = new MentorN("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void addStudent()
  {
    MentorN m = new MentorN("blah");
    StudentN s = new StudentN(99);
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(false,m.addStudent(s));
    
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(s, m.getStudent(0));
  }

  
  @Test
  public void addStudentToMultipleMentors()
  {
    MentorN m = new MentorN("blah");
    MentorN m2 = new MentorN("blah2");
    
    
    StudentN s = new StudentN(99);
    StudentN s2 = new StudentN(992);
    m.addStudent(s);
    m2.addStudent(s2);
    m2.addStudent(s);
    s2.addMentor(m);
    
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(m2, s.getMentor(1));
    Assert.assertEquals(m2, s2.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(1));

    
    Assert.assertEquals(s, m.getStudent(0));
    Assert.assertEquals(s2, m.getStudent(1));
    Assert.assertEquals(s2, m2.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(1));
  }
  
  @Test
  public void addToNewMentor()
  {
    MentorN m = new MentorN("blah");
    MentorN m2 = new MentorN("blah2");
    StudentN s = new StudentN(99);
    
    m.addStudent(s);
    m2.addStudent(s);
    
    Assert.assertEquals(2, s.numberOfMentors());
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(m2, s.getMentor(1));

    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());

    Assert.assertEquals(s, m.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(0));
  }  
  
  @Test
  public void doNotRemoveFromExistingMentor()
  {
    MentorN m = new MentorN("blah");
    MentorN m2 = new MentorN("blah2");

    StudentN s1 = new StudentN(99);
    StudentN s2 = new StudentN(98);
    StudentN s3 = new StudentN(97);
    
    m.addStudent(s1);
    m.addStudent(s2);
    m.addStudent(s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());
    
    m2.addStudent(s1);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(s1, m.getStudent(0));
    Assert.assertEquals(s2, m.getStudent(1));
    Assert.assertEquals(s3, m.getStudent(2));
    
    Assert.assertEquals(1, m2.numberOfStudents());
    Assert.assertEquals(s1, m2.getStudent(0));
    
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m2, s1.getMentor(1));
    
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(m, s3.getMentor(0));
  }   
  
  @Test
  public void removeStudent()
  {
    MentorN m = new MentorN("blah");
    StudentN s = new StudentN(99);
    
    m.addStudent(s);
    m.removeStudent(s);
    
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(0,m.numberOfStudents());
  }  

  @Test
  public void deleteAll()
  {
    MentorN m = new MentorN("blah");
    MentorN m2 = new MentorN("blah2");
    
    StudentN s = new StudentN(99);
    StudentN s2 = new StudentN(98);
    StudentN s3 = new StudentN(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    m.addStudent(s3);

    m2.addStudent(s2);
    
    m.delete();

    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(1,m2.numberOfStudents());
    
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(1,s2.numberOfMentors());
    Assert.assertEquals(0,s3.numberOfMentors());
  }  
  
  
}
