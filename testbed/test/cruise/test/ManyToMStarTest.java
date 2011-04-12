package cruise.test;

import org.junit.*;

public class ManyToMStarTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentR s = new StudentR(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooFew()
  {
    StudentR s = new StudentR(99);
    new MentorR("blah",s);
  }

  @Test
  public void ConstructorCannotHaveTooMany()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);
    StudentR s6 = new StudentR(94);
    StudentR s7 = new StudentR(93);
    StudentR s8 = new StudentR(92);
    new MentorR("blah",s,s2,s3,s4,s5,s6,s7,s8);
  }
  
  
  @Test
  public void constructorJustBigEnough()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);
    StudentR s3 = new StudentR(97);

    MentorR m = new MentorR("blah",s,s2,s3);

    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
  }
  
  @Test
  public void constructorMoreThanBigEnough()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);

    MentorR m = new MentorR("blah",s,s2,s3,s4);

    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
  }  


  @Test(expected=RuntimeException.class)
  public void constructorWatchOutForDuplicateEntries()
  {
    StudentR s = new StudentR(99);
    new MentorR("blah",s, s);
  }
  
  @Test
  public void constructorExistingMentorsOkay()
  {
    StudentR s1 = new StudentR(99);
    StudentR s2 = new StudentR(98);
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    
    MentorR m = new MentorR("blah",s1,s2,s3);

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(m, s3.getMentor(0));
    Assert.assertEquals(0, s4.numberOfMentors());    

    MentorR m2 = new MentorR("blah2",s1,s2,s4);
    
    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(m, s3.getMentor(0));
    
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m2, s1.getMentor(1));
    Assert.assertEquals(m2, s2.getMentor(1));
    Assert.assertEquals(m2, s4.getMentor(0));

  }   
  
  @Test
  public void setStudents_tooFew()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);

    MentorR m = new MentorR("blah",s, s2, s3);
    
    Assert.assertEquals(false, m.setStudents(s5, s4));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    
    
  }

  @Test
  public void setStudents_doNotAllowDuplicates()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    
    MentorR m = new MentorR("blah",s, s2, s3);
    Assert.assertEquals(false, m.setStudents(s2, s2, s3));
  }

  @Test
  public void setStudents_aboveMinimum()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);

    MentorR m = new MentorR("blah",s, s2, s3);
    
    Assert.assertEquals(true, m.setStudents(s2, s3, s4));
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());

    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));    
  }
  
  @Test
  public void addMentorNeverTooMany()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);

    MentorR m = new MentorR("blah",s,s2,s3,s4);
    
    Assert.assertEquals(true,s5.addMentor(m));
    Assert.assertEquals(5,m.numberOfStudents());
    Assert.assertEquals(1,s5.numberOfMentors());
    
  }
  
  @Test
  public void addStudent()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);

    MentorR m = new MentorR("blah",s,s2,s3);

    Assert.assertEquals(3,m.numberOfStudents());
    
    Assert.assertEquals(true,m.addStudent(s4));
    
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));    
   
    Assert.assertEquals(true,m.addStudent(s5));
    Assert.assertEquals(5,m.numberOfStudents());
  
  }  

  @Test
  public void addStudentHasExistingMentor()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);
    StudentR s6 = new StudentR(94);

    MentorR m = new MentorR("blah",s,s2,s3);
    MentorR m2 = new MentorR("blah2",s4,s5,s6);

    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    
    Assert.assertEquals(m2,s4.getMentor(0));
    Assert.assertEquals(m2,s5.getMentor(0));
    Assert.assertEquals(m2,s6.getMentor(0));
    
    Assert.assertEquals(true,m.addStudent(s4));
    
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(3,m2.numberOfStudents());
    
    Assert.assertEquals(2,s4.numberOfMentors());    
    Assert.assertEquals(m2,s4.getMentor(0));    
    Assert.assertEquals(m,s4.getMentor(1));

    Assert.assertEquals(true,m.addStudent(s5));
  }  

  @Test
  public void removeStudent()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);    
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);
    StudentR s5 = new StudentR(95);

    MentorR m = new MentorR("blah",s,s2,s3,s5);
    
    Assert.assertEquals(false,m.removeStudent(s4));
    Assert.assertEquals(true,m.removeStudent(s3));
    
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(0,s3.numberOfMentors());
    Assert.assertEquals(0,s4.numberOfMentors());   
    Assert.assertEquals(m,s5.getMentor(0));

    Assert.assertEquals(false,m.removeStudent(s2));
    Assert.assertEquals(3,m.numberOfStudents());
  }  
  
  
  
  
  @Test
  public void setStudents_empty()
  {
    StudentR s = new StudentR(99);
    StudentR s2 = new StudentR(98);
    StudentR s3 = new StudentR(97);
    MentorR m = new MentorR("blah",s,s2,s3);

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test
  public void deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    StudentR s1 = new StudentR(99);
    StudentR s2 = new StudentR(98);
    StudentR s3 = new StudentR(97);

    MentorR m = new MentorR("blah",s1,s2,s3);
    ProgramR studentP = new ProgramR();
    ProgramR mentorP = new ProgramR();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(null,m.getProgram());
    Assert.assertEquals(null,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(0,s1.numberOfMentors());
  }  
  
  @Test
  public void deleteStudentLeavesMentorAloneIfHasEnough()
  {
    StudentR s1 = new StudentR(99);
    StudentR s2 = new StudentR(98);
    StudentR s3 = new StudentR(97);
    StudentR s4 = new StudentR(96);

    MentorR m = new MentorR("blah",s1,s2,s3,s4);
    ProgramR studentP = new ProgramR();
    ProgramR mentorP = new ProgramR();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(3,m.numberOfStudents());
    Assert.assertEquals(mentorP,m.getProgram());
    Assert.assertEquals(m,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(0,s1.numberOfMentors());
  } 

  
  
}
