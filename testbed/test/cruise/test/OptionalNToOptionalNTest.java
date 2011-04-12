package cruise.test;

import org.junit.*;

public class OptionalNToOptionalNTest
{

  @Test
  public void CreateNew()
  {
    StudentAE s = new StudentAE(99);
    Assert.assertEquals(0,s.numberOfMentors());
    
    MentorAE m = new MentorAE("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void addStudent()
  {
    MentorAE m = new MentorAE("blah");
    StudentAE s = new StudentAE(99);
    m.addStudent(s);
    
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(s, m.getStudent(0));
  }

  
  @Test
  public void addStudentToMultipleMentors()
  {
    MentorAE m = new MentorAE("blah");
    MentorAE m2 = new MentorAE("blah2");
    
    
    StudentAE s = new StudentAE(99);
    StudentAE s2 = new StudentAE(992);
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
    MentorAE m = new MentorAE("blah");
    MentorAE m2 = new MentorAE("blah2");
    StudentAE s = new StudentAE(99);
    
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
    MentorAE m = new MentorAE("blah");
    MentorAE m2 = new MentorAE("blah2");

    StudentAE s1 = new StudentAE(99);
    StudentAE s2 = new StudentAE(98);
    
    m.addStudent(s1);
    m.addStudent(s2);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());
    
    m2.addStudent(s1);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(s1, m.getStudent(0));
    Assert.assertEquals(s2, m.getStudent(1));
    
    Assert.assertEquals(1, m2.numberOfStudents());
    Assert.assertEquals(s1, m2.getStudent(0));
    
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m2, s1.getMentor(1));
    
    Assert.assertEquals(m, s2.getMentor(0));
  }   
  
  @Test
  public void removeStudent()
  {
    MentorAE m = new MentorAE("blah");
    StudentAE s = new StudentAE(99);
    
    m.addStudent(s);
    m.removeStudent(s);
    
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(0,m.numberOfStudents());
  }  

  @Test
  public void deleteAll()
  {
    MentorAE m = new MentorAE("blah");
    MentorAE m2 = new MentorAE("blah2");
    
    StudentAE s = new StudentAE(99);
    StudentAE s2 = new StudentAE(98);
    StudentAE s3 = new StudentAE(97);
    
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
  
  @Test
  public void isMaxNumber()
  {
    Assert.assertEquals(3,StudentAE.maximumNumberOfMentors());
    Assert.assertEquals(2,MentorAE.maximumNumberOfStudents());
  }
  
  @Test
  public void addStudentsMax()
  {
    MentorAE m = new MentorAE("blah");
    Assert.assertEquals(true,m.addStudent(new StudentAE(99)));
    Assert.assertEquals(true,m.addStudent(new StudentAE(98)));
    Assert.assertEquals(false,m.addStudent(new StudentAE(97)));
  }

  @Test
  public void addMentorsMax()
  {
    StudentAE s = new StudentAE(98);
    Assert.assertEquals(true,s.addMentor(new MentorAE("blah")));
    Assert.assertEquals(true,s.addMentor(new MentorAE("blah2")));
    Assert.assertEquals(true,s.addMentor(new MentorAE("blah3")));
    Assert.assertEquals(false,s.addMentor(new MentorAE("blah4")));
  }

}
