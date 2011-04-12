package cruise.test;

import org.junit.*;

public class NToOptionalNTest
{

  @Test
  public void CreateStudentWithoutMentors()
  {
    new StudentAC(99);
  }
  
  @Test
  public void CreateStudentJustEnoughMentors()
  {
    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");
    MentorAC m3 = new MentorAC("blah2");
    StudentAC s = new StudentAC(99);
    
    Assert.assertEquals(true,s.addMentor(m));
    Assert.assertEquals(true,s.addMentor(m2));
    Assert.assertEquals(false,s.addMentor(m3));
    Assert.assertEquals(2,s.numberOfMentors());
  }

  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorAC m = new MentorAC("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void SetMentorsOutsideRange()
  {
    StudentAC s = new StudentAC(99);

    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");
    MentorAC m3 = new MentorAC("blah3");

    Assert.assertEquals(true,s.addMentor(m));
    Assert.assertEquals(true,s.addMentor(m2));
    Assert.assertEquals(false,s.addMentor(m3));
    
    Assert.assertEquals(2, s.numberOfMentors());
    Assert.assertEquals(s,m.getStudent(0));
    Assert.assertEquals(s,m2.getStudent(0));
    Assert.assertEquals(0,m3.numberOfStudents());
  }
  
  @Test
  public void AddStudents()
  {
    MentorAC m = new MentorAC("blah");
    
    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    StudentAC s3 = new StudentAC(97);
    StudentAC s4 = new StudentAC(96);

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(true,m.addStudent(s3));
    Assert.assertEquals(false,m.addStudent(s4));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(1,s3.numberOfMentors());
  }   
  
  @Test
  public void RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    StudentAC s = new StudentAC(99);
    
    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");

    s.addMentor(m);
    s.addMentor(m2);
    Assert.assertEquals(false,s.removeMentor(m2));
    
    Assert.assertEquals(2, s.numberOfMentors());
    Assert.assertEquals(m2,s.getMentor(1));
  } 
  
  @Test
  public void CannotRemoveStudents()
  {
    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");
    MentorAC m3 = new MentorAC("blah3");
    
    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    StudentAC s3 = new StudentAC(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    Assert.assertEquals(false,m3.addStudent(s));
    Assert.assertEquals(false,m3.addStudent(s2));
    
    Assert.assertEquals(false,m.removeStudent(s3));
    Assert.assertEquals(false,m.removeStudent(s2));
    
    Assert.assertEquals(2,s2.numberOfMentors());
    Assert.assertEquals(2, m.numberOfStudents());
  } 
  
  @Test
  public void SetStudentsTooMany()
  {
    MentorAC m = new MentorAC("blah");
    
    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    StudentAC s3 = new StudentAC(97);
    StudentAC s4 = new StudentAC(96);
    
    m.addStudent(s);
    m.addStudent(s2);
    Assert.assertEquals(true,m.addStudent(s3));
    Assert.assertEquals(false,m.addStudent(s4));
  }   
  
  @Test
  public void MentorAlreadyHasEnoughStudents()
  {
    MentorAC m = new MentorAC("blah");
    
    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    StudentAC s3 = new StudentAC(97);
    StudentAC s4 = new StudentAC(96);
    
    m.addStudent(s);
    m.addStudent(s2);
    m.addStudent(s3);
    
    Assert.assertEquals(false,m.addStudent(s4));
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(1,s3.numberOfMentors());
  }    

  @Test
  public void addMentor()
  {
    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");
    MentorAC m3 = new MentorAC("blah2");

    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    
    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(true,s.addMentor(m2));
    Assert.assertEquals(false,s.addMentor(m3));

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(1,m2.numberOfStudents());
    Assert.assertEquals(0,m3.numberOfStudents());
    Assert.assertEquals(2,s.numberOfMentors());
  } 
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(3,MentorAC.maximumNumberOfStudents());
  }  
  
  @Test
  public void getBoundsForMentor()
  {
    Assert.assertEquals(2,StudentAC.minimumNumberOfMentors());
    Assert.assertEquals(2,StudentAC.maximumNumberOfMentors());
  }    
  
  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorAC m = new MentorAC("blah");
    MentorAC m2 = new MentorAC("blah2");
    MentorAC m3 = new MentorAC("blah2");

    StudentAC s = new StudentAC(99);
    StudentAC s2 = new StudentAC(98);
    
    s.addMentor(m);
    s.addMentor(m2);
    s.addMentor(m3);
    s2.addMentor(m);
    s2.addMentor(m2);
    s2.addMentor(m3);
    
    m3.addStudent(s);
    m3.addStudent(s2);
    
    ProgramAC p = new ProgramAC();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
