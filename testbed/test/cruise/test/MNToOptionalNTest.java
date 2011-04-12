package cruise.test;

import org.junit.*;

public class MNToOptionalNTest
{

  @Test
  public void CreateStudentWihtoutMentor()
  {
    StudentAB s =new StudentAB(99);
    Assert.assertEquals(false,s.isNumberOfMentorsValid());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorAB m = new MentorAB("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void AddStudentsAndMentorsOkay()
  {
    MentorAB m = new MentorAB("blah");
    MentorAB m2 = new MentorAB("blah2");
    MentorAB m3 = new MentorAB("blah3");
    MentorAB m4 = new MentorAB("blah4");
    MentorAB m5 = new MentorAB("blah5");
    MentorAB m6 = new MentorAB("blah6");
    
    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    StudentAB s3 = new StudentAB(97);

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(false,m.addStudent(s3));
    
    Assert.assertEquals(true,s.addMentor(m2));
    Assert.assertEquals(true,s.addMentor(m3));
    Assert.assertEquals(true,s.addMentor(m4));
    Assert.assertEquals(true,s.addMentor(m5));
    Assert.assertEquals(false,s.addMentor(m6));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m4,s.getMentor(3));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(5,s.numberOfMentors());
  }   
  
  @Test
  public void RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    StudentAB s = new StudentAB(99);
    
    MentorAB m = new MentorAB("blah");
    MentorAB m2 = new MentorAB("blah2");
    MentorAB m3 = new MentorAB("blah3");

    s.addMentor(m);
    s.addMentor(m2);
    s.addMentor(m3);
    Assert.assertEquals(false,s.removeMentor(m2));
    Assert.assertEquals(3, s.numberOfMentors());
    Assert.assertEquals(m2,s.getMentor(1));
  } 
  
  @Test
  public void RemoveStudents()
  {
    MentorAB m = new MentorAB("blah");
    MentorAB m2 = new MentorAB("blah2");
    MentorAB m3 = new MentorAB("blah3");
    MentorAB m4 = new MentorAB("blah3");
    
    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    StudentAB s3 = new StudentAB(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    m3.addStudent(s);
    m3.addStudent(s2);
    m4.addStudent(s);
    m4.addStudent(s2);
    
    Assert.assertEquals(false,m.removeStudent(s3));
    Assert.assertEquals(true,m.removeStudent(s2));
    
    Assert.assertEquals(3,s2.numberOfMentors());
    Assert.assertEquals(1, m.numberOfStudents());
  } 
  
  @Test
  public void SetStudentsTooMany()
  {
    MentorAB m = new MentorAB("blah");
    
    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    StudentAB s3 = new StudentAB(97);
    
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(false,m.addStudent(s3));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(0,s3.numberOfMentors());
  }   
  
  @Test
  public void MentorAlreadyHasEnoughStudents()
  {
    MentorAB m = new MentorAB("blah");
    
    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    StudentAB s3 = new StudentAB(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    
    Assert.assertEquals(false,m.addStudent(s3));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(0,s3.numberOfMentors());
  }    
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(2,MentorAB.maximumNumberOfStudents());
  }  
  
  @Test
  public void getBoundsForMentor()
  {
    Assert.assertEquals(3,StudentAB.minimumNumberOfMentors());
    Assert.assertEquals(5,StudentAB.maximumNumberOfMentors());
  }    
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorAB m = new MentorAB("blah");
    MentorAB m2 = new MentorAB("blah2");
    MentorAB m3 = new MentorAB("blah2");
    MentorAB m4 = new MentorAB("blah2");

    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    m3.addStudent(s);
    m3.addStudent(s2);
    m4.addStudent(s);
    m4.addStudent(s2);
    
    ProgramAB p = new ProgramAB();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(3,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorAB m = new MentorAB("blah");
    MentorAB m2 = new MentorAB("blah2");
    MentorAB m3 = new MentorAB("blah3");

    StudentAB s = new StudentAB(99);
    StudentAB s2 = new StudentAB(98);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    m3.addStudent(s);
    m3.addStudent(s2);
    
    ProgramAB p = new ProgramAB();
    s.setProgram(p);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(3,s.numberOfMentors());
    Assert.assertEquals(3,s2.numberOfMentors());
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,m3.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(0,s2.numberOfMentors());
  }  

}
