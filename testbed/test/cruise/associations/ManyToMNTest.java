package cruise.associations;

import org.junit.*;

import cruise.associations.MentorO;
import cruise.associations.ProgramO;
import cruise.associations.StudentO;

public class ManyToMNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentO s = new StudentO(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooFew()
  {
    StudentO s = new StudentO(99);
    new MentorO("blah",s);
  }

  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooMany()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);
    StudentO s5 = new StudentO(95);
    new MentorO("blah",s,s2,s3,s4,s5);
  }
  
  
  @Test
  public void constructorJustBigEnough()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);

    MentorO m = new MentorO("blah",s,s2);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
  }
  
  @Test
  public void constructorJustSmallEnough()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);

    MentorO m = new MentorO("blah",s,s2,s3,s4);

    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));
  }  


  @Test(expected=RuntimeException.class)
  public void constructorWatchOutForDuplicateEntries()
  {
    StudentO s = new StudentO(99);
    new MentorO("blah",s, s);
  }
  
  @Test
  public void constructorExistingMentorsOkay()
  {
    StudentO s1 = new StudentO(99);
    StudentO s2 = new StudentO(98);
    StudentO s3 = new StudentO(97);
    
    MentorO m = new MentorO("blah",s1,s2);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(0, s3.numberOfMentors());    

    MentorO m2 = new MentorO("blah2",s1,s2,s3);
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    
    Assert.assertEquals(3, m2.numberOfStudents());
    Assert.assertEquals(m2, s1.getMentor(1));
    Assert.assertEquals(m2, s2.getMentor(1));
    Assert.assertEquals(m2, s3.getMentor(0));

  }   
  
  @Test
  public void setStudents_outsideNM()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);
    StudentO s5 = new StudentO(95);

    MentorO m = new MentorO("blah",s, s2);
    
    Assert.assertEquals(false, m.setStudents(s2, s3, s4, s5, s));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(0,s3.numberOfMentors());
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());

    Assert.assertEquals(false, m.setStudents(s5));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(0,s3.numberOfMentors());
    Assert.assertEquals(0,s4.numberOfMentors());
    Assert.assertEquals(0,s5.numberOfMentors());
    
    
  }

  @Test
  public void setStudents_doNotAllowDuplicatesNM()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);

    MentorO m = new MentorO("blah",s, s2);
    Assert.assertEquals(false, m.setStudents(s2, s2, s3));
  }

  @Test
  public void setStudents_withinNM()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);

    MentorO m = new MentorO("blah",s, s2);
    
    Assert.assertEquals(true, m.setStudents(s2, s3, s4));
    Assert.assertEquals(3,m.numberOfStudents());

    Assert.assertEquals(0,s.numberOfMentors());

    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));    
  }
  
  @Test
  public void addMentorTooMany()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);
    StudentO s5 = new StudentO(95);

    MentorO m = new MentorO("blah",s,s2,s3,s4);
    
    Assert.assertEquals(false,s5.addMentor(m));
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(0,s5.numberOfMentors());
    
  }

  @Test
  public void addMentorTOkay()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s5 = new StudentO(95);

    MentorO m = new MentorO("blah",s,s2,s3);
    
    Assert.assertEquals(true,s5.addMentor(m));
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(1,s5.numberOfMentors());
    
  }
  
  
  @Test
  public void addStudent()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);
    StudentO s5 = new StudentO(95);

    MentorO m = new MentorO("blah",s,s2,s3);

    Assert.assertEquals(3,m.numberOfStudents());
    
    Assert.assertEquals(true,m.addStudent(s4));
    
    Assert.assertEquals(4,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
    Assert.assertEquals(m,s4.getMentor(0));    
   
    Assert.assertEquals(false,m.addStudent(s5));
    Assert.assertEquals(4,m.numberOfStudents());
  
  }  

  @Test
  public void addStudentHasExistingMentor()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);
    StudentO s5 = new StudentO(95);
    StudentO s6 = new StudentO(94);

    MentorO m = new MentorO("blah",s,s2,s3);
    MentorO m2 = new MentorO("blah2",s4,s5,s6);

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

    Assert.assertEquals(false,m.addStudent(s5));
  }  

  @Test
  public void removeStudent()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);    
    StudentO s3 = new StudentO(97);
    StudentO s4 = new StudentO(96);

    MentorO m = new MentorO("blah",s,s2,s3);
    
    Assert.assertEquals(false,m.removeStudent(s4));
    Assert.assertEquals(true,m.removeStudent(s3));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(0,s3.numberOfMentors());
    Assert.assertEquals(0,s4.numberOfMentors());    

    Assert.assertEquals(false,m.removeStudent(s2));
    Assert.assertEquals(2,m.numberOfStudents());
  }  
  
  
  
  
  @Test
  public void setStudents_empty()
  {
    StudentO s = new StudentO(99);
    StudentO s2 = new StudentO(98);
    StudentO s3 = new StudentO(97);
    MentorO m = new MentorO("blah",s,s2,s3);

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(3,m.numberOfStudents());
  }
  
  @Test
  public void deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    StudentO s1 = new StudentO(99);
    StudentO s2 = new StudentO(98);

    MentorO m = new MentorO("blah",s1,s2);
    ProgramO studentP = new ProgramO();
    ProgramO mentorP = new ProgramO();
    
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
    StudentO s1 = new StudentO(99);
    StudentO s2 = new StudentO(98);
    StudentO s3 = new StudentO(97);

    MentorO m = new MentorO("blah",s1,s2,s3);
    ProgramO studentP = new ProgramO();
    ProgramO mentorP = new ProgramO();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(mentorP,m.getProgram());
    Assert.assertEquals(m,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(0,s1.numberOfMentors());
  } 

  
  
}
