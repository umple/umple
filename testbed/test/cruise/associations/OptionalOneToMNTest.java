package cruise.associations;

import org.junit.*;

import cruise.associations.MentorE;
import cruise.associations.ProgramE;
import cruise.associations.StudentE;

public class OptionalOneToMNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentE s = new StudentE();
    Assert.assertEquals(null,s.getMentor());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooFew()
  {
    StudentE s = new StudentE();
    new MentorE(s);
  }

  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooMany()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();
    StudentE s6 = new StudentE();
    new MentorE(s,s2,s3,s4,s5,s6);
  }
  
  
  @Test
  public void constructorJustBigEnough()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();

    MentorE m = new MentorE(s,s2);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
  }
  
  @Test
  public void constructorJustSmallEnough()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();

    MentorE m = new MentorE(s,s2,s3,s4,s5);

    Assert.assertEquals(5,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());
    Assert.assertEquals(m,s5.getMentor());
  }  


  @Test(expected=RuntimeException.class)
  public void constructorWatchOutForDuplicateEntries()
  {
    StudentE s = new StudentE();
    new MentorE(s, s);
  }
  
  @Test(expected=RuntimeException.class)
  public void constructorCheckForExistingMentorNotEnoughToSurvive()
  {
    StudentE s1 = new StudentE();
    StudentE s2 = new StudentE();
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    
    MentorE m = new MentorE(s1,s2,s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(null, s4.getMentor());    

    new MentorE(s1,s2,s4);
  }   
  
  @Test
  public void constructorCheckForExistingMentorEnoughToShare()
  {
    StudentE s1 = new StudentE();
    StudentE s2 = new StudentE();
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();
    
    MentorE m = new MentorE(s1,s2,s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(null, s4.getMentor());    
    Assert.assertEquals(null, s5.getMentor());

    MentorE m2 = new MentorE(s2,s4,s5);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m2, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(m2, s4.getMentor());    
    Assert.assertEquals(m2, s5.getMentor());
  }   
  
  
  @Test
  public void setStudents_outsideNM()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();
    StudentE s6 = new StudentE();

    MentorE m = new MentorE(s, s2);
    
    Assert.assertEquals(false, m.setStudents(s, s2, s3, s4, s5, s6));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(null,s3.getMentor());
    Assert.assertEquals(null,s4.getMentor());    
    Assert.assertEquals(null,s5.getMentor());    
    Assert.assertEquals(null,s6.getMentor());    

    Assert.assertEquals(false, m.setStudents(s));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(null,s3.getMentor());
    Assert.assertEquals(null,s4.getMentor());    
    Assert.assertEquals(null,s5.getMentor());    
    Assert.assertEquals(null,s6.getMentor());    
    
    
  }

  @Test
  public void setStudents_withinNM()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();

    MentorE m = new MentorE(s, s2);
    
    Assert.assertEquals(true, m.setStudents(s2, s3, s4));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(null,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());    
  }
  
  @Test
  public void addStudent()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();
    StudentE s6 = new StudentE();

    MentorE m = new MentorE(s,s2,s3,s4);

    Assert.assertEquals(4,m.numberOfStudents());
    
    
    Assert.assertEquals(true,m.addStudent(s5));
    
    Assert.assertEquals(5,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());    
    Assert.assertEquals(m,s5.getMentor());    

    Assert.assertEquals(false,m.addStudent(s6));
    Assert.assertEquals(5,m.numberOfStudents());
  
  }  

  @Test
  public void addStudentHasExistingMentor()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();
    StudentE s5 = new StudentE();
    StudentE s6 = new StudentE();

    MentorE m = new MentorE(s,s2,s3);
    MentorE m2 = new MentorE(s4,s5,s6);
    
    Assert.assertEquals(true,m.addStudent(s4));
    
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());    
    Assert.assertEquals(m2,s5.getMentor());    
    Assert.assertEquals(m2,s6.getMentor());

    Assert.assertEquals(false,m.addStudent(s5));
  }  

  @Test
  public void removeStudent()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();    
    StudentE s3 = new StudentE();
    StudentE s4 = new StudentE();

    MentorE m = new MentorE(s,s2,s3);
    
    Assert.assertEquals(false,m.removeStudent(s4));
    Assert.assertEquals(true,m.removeStudent(s3));
    Assert.assertEquals(2,m.numberOfStudents());
    
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(null,s3.getMentor());
    Assert.assertEquals(null,s4.getMentor());    

    Assert.assertEquals(false,m.removeStudent(s2));
    Assert.assertEquals(2,m.numberOfStudents());
    
    
  }  
  
  
  
  
  @Test
  public void setStudents_empty()
  {
    StudentE s = new StudentE();
    StudentE s2 = new StudentE();
    StudentE s3 = new StudentE();
    MentorE m = new MentorE(s,s2,s3);

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test
  public void deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    StudentE s1 = new StudentE();
    StudentE s2 = new StudentE();

    MentorE m = new MentorE(s1,s2);
    ProgramE studentP = new ProgramE();
    ProgramE mentorP = new ProgramE();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(null,m.getProgram());
    Assert.assertEquals(null,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(null,s1.getMentor());
  }  
  
  @Test
  public void deleteStudentLeavesMentorAloneIfHasEnough()
  {
    StudentE s1 = new StudentE();
    StudentE s2 = new StudentE();
    StudentE s3 = new StudentE();

    MentorE m = new MentorE(s1,s2,s3);
    ProgramE studentP = new ProgramE();
    ProgramE mentorP = new ProgramE();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(mentorP,m.getProgram());
    Assert.assertEquals(m,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(null,s1.getMentor());
  } 

  
  
}
