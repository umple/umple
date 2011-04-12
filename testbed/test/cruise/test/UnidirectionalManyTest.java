package cruise.test;

import org.junit.*;

public class UnidirectionalManyTest
{

  @Test
  public void addStudent()
  {
    MentorP m = new MentorP("blah");
    StudentP s = new StudentP(1);
    m.addStudent(s);
    Assert.assertEquals(s, m.getStudent(0));
  }
  
  @Test
  public void addSameStudent()
  {
    MentorP m = new MentorP("blah");
    StudentP s = new StudentP(1);
    
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(false,m.addStudent(s));

    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(s, m.getStudent(0));
  }  
  
  @Test
  public void removeStudent()
  {
    MentorP m = new MentorP("blah");
    StudentP s = new StudentP(1);
    
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.removeStudent(s));
    Assert.assertEquals(false,m.removeStudent(s));

    Assert.assertEquals(0, m.numberOfStudents());
  }   

  @Test
  public void addMultipleMentors()
  {
    MentorP m = new MentorP("blah");
    MentorP m2 = new MentorP("blah2");

    StudentP s = new StudentP(99);
    Assert.assertEquals(0, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());

    m.addStudent(s);
    
    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());

    m2.addStudent(s);

    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());

    Assert.assertEquals(s, m.getStudent(0));
    Assert.assertEquals(s, m2.getStudent(0));
  }
  
  @Test
  public void deleteDoesNotRemoveStudentsFromMentors()
  {
    MentorP m = new MentorP("blah");
    MentorP m2 = new MentorP("blah2");
    MentorP m3 = new MentorP("blah3");
    
    StudentP s = new StudentP(99);
    StudentP s2 = new StudentP(98);
    StudentP s3 = new StudentP(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    
    m2.addStudent(s);
    m3.addStudent(s3);
    
    s.delete();
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());
    Assert.assertEquals(1, m3.numberOfStudents());
  }
  
}
