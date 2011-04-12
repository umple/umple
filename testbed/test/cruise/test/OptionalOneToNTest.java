package cruise.test;

import org.junit.*;

public class OptionalOneToNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentD s = new StudentD();
    Assert.assertEquals(null,s.getMentor());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithoutNStudents()
  {
    StudentD s = new StudentD();
    StudentD s2 = new StudentD();    
    new MentorD(s,s2);
  }
  
  @Test
  public void setStudents_makeSureAlwaysN()
  {
    StudentD s = new StudentD();
    StudentD s2 = new StudentD();
    StudentD s3 = new StudentD();

    MentorD m = new MentorD(s,s2,s3);
    StudentD s4 = new StudentD();
    StudentD s5 = new StudentD();
    StudentD s6 = new StudentD();
    
    Assert.assertEquals(true, m.setStudents(s, s2, s3));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());

    Assert.assertEquals(true, m.setStudents(s4, s5, s6));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(null,s.getMentor());
    Assert.assertEquals(null,s2.getMentor());
    Assert.assertEquals(null,s3.getMentor());
    Assert.assertEquals(m,s4.getMentor());
    Assert.assertEquals(m,s5.getMentor());
    Assert.assertEquals(m,s6.getMentor());
  }

  @Test(expected=RuntimeException.class)
  public void setStudents_watchOutForDuplicateEntries()
  {
    StudentD s = new StudentD();
    StudentD s2 = new StudentD();
    new MentorD(s, s2, s);
  }
  
  
  @Test
  public void setStudents_replaceExisitingmakeSureAlwaysN()
  {
    StudentD s = new StudentD();
    StudentD s2 = new StudentD();
    StudentD s3 = new StudentD();

    MentorD m = new MentorD(s, s2, s3);
    StudentD s4 = new StudentD();
    
    Assert.assertEquals(false, m.setStudents(s, s2));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor());
    Assert.assertEquals(m,s2.getMentor());
    Assert.assertEquals(m,s3.getMentor());
    Assert.assertEquals(null,s4.getMentor());    
    
    Assert.assertEquals(false, m.setStudents(s, s2, s3, s4));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(null,s4.getMentor());

  }

  @Test
  public void setStudents_empty()
  {
    StudentD s = new StudentD();
    StudentD s2 = new StudentD();
    StudentD s3 = new StudentD();
    MentorD m = new MentorD(s,s2,s3);

    
    Assert.assertEquals(true, m.setStudents(s, s2, s3));
    Assert.assertEquals(3,m.numberOfStudents());

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test(expected=RuntimeException.class)
  public void checkForExistingMentor()
  {
    StudentD s1 = new StudentD();
    StudentD s2 = new StudentD();
    StudentD s3 = new StudentD();

    MentorD m = new MentorD(s1,s2,s3);

    StudentD s4 = new StudentD();
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor());
    Assert.assertEquals(m, s2.getMentor());
    Assert.assertEquals(m, s3.getMentor());    
    Assert.assertEquals(null, s4.getMentor());    

    new MentorD(s1,s2,s4);
  }   
  
  @Test
  public void deletStudentDeletesTheMentor()
  {
    StudentD s1 = new StudentD();
    StudentD s2 = new StudentD();
    StudentD s3 = new StudentD();

    MentorD m = new MentorD(s1,s2,s3);
    ProgramD studentP = new ProgramD();
    ProgramD mentorP = new ProgramD();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(null,m.getProgram());
    Assert.assertEquals(null,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(null,s1.getMentor());
  }  

  
  
}
