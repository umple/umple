package cruise.test;

import org.junit.*;

public class OptionalOneToMStarTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentF s = new StudentF();
    Assert.assertEquals(null,s.getMentor());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooFew()
  {
    StudentF s = new StudentF();
    new MentorF(s);
  }
  
  
  @Test
  public void constructorJustBigEnough()
  {
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();

    MentorF m = new MentorF(s,s2);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
  }
  

  @Test(expected=RuntimeException.class)
  public void constructorWatchOutForDuplicateEntries()
  {
    StudentF s = new StudentF();
    new MentorF(s, s);
  }
  
  @Test(expected=RuntimeException.class)
  public void constructorCheckForExistingMentorNotEnoughToSurvive()
  {
    StudentF s1 = new StudentF();
    StudentF s2 = new StudentF();
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();
    
    MentorF m = new MentorF(s1,s2,s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(null, s4.getMentor());    

    new MentorF(s1,s2,s4);
  }   
  
  @Test
  public void constructorCheckForExistingMentorFnoughToShare()
  {
    StudentF s1 = new StudentF();
    StudentF s2 = new StudentF();
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();
    StudentF s5 = new StudentF();
    
    MentorF m = new MentorF(s1,s2,s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(null, s4.getMentor());    
    Assert.assertEquals(null, s5.getMentor());

    MentorF m2 = new MentorF(s2,s4,s5);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m2, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(m2, s4.getMentor());    
    Assert.assertEquals(m2, s5.getMentor());
  }   
  
  
  @Test
  public void setStudents_lessThanM()
  {
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();    
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();
    StudentF s5 = new StudentF();
    StudentF s6 = new StudentF();

    MentorF m = new MentorF(s, s2);
    
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
  public void setStudents_aLot()
  {
    StudentF[] allStudents = new StudentF[100];
    
    for (int i=0; i<100; i++)
    {
      allStudents[i] = new StudentF();
    }
    
    MentorF m = new MentorF(allStudents);
    Assert.assertEquals(100,m.numberOfStudents());
  }
  
  
  @Test
  public void setStudents_atLeastM()
  {
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();    
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();

    MentorF m = new MentorF(s, s2);
    
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
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();    
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();
    StudentF s5 = new StudentF();
    StudentF s6 = new StudentF();

    MentorF m = new MentorF(s,s2,s3,s4);

    Assert.assertEquals(4,m.numberOfStudents());
    
    
    Assert.assertEquals(true,m.addStudent(s5));
    
    Assert.assertEquals(5,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());    
    Assert.assertEquals(m,s5.getMentor());    

    Assert.assertEquals(true,m.addStudent(s6));
    Assert.assertEquals(6,m.numberOfStudents());
  
  }  

  @Test
  public void addStudentHasExistingMentor()
  {
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();    
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();
    StudentF s5 = new StudentF();
    StudentF s6 = new StudentF();

    MentorF m = new MentorF(s,s2,s3);
    MentorF m2 = new MentorF(s4,s5,s6);
    
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
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();    
    StudentF s3 = new StudentF();
    StudentF s4 = new StudentF();

    MentorF m = new MentorF(s,s2,s3);
    
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
    StudentF s = new StudentF();
    StudentF s2 = new StudentF();
    StudentF s3 = new StudentF();
    MentorF m = new MentorF(s,s2,s3);

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test
  public void deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    StudentF s1 = new StudentF();
    StudentF s2 = new StudentF();

    MentorF m = new MentorF(s1,s2);
    ProgramF studentP = new ProgramF();
    ProgramF mentorP = new ProgramF();
    
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
    StudentF s1 = new StudentF();
    StudentF s2 = new StudentF();
    StudentF s3 = new StudentF();

    MentorF m = new MentorF(s1,s2,s3);
    ProgramF studentP = new ProgramF();
    ProgramF mentorP = new ProgramF();
    
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
