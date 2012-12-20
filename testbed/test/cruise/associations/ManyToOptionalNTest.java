package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAA;
import cruise.associations.ProgramAA;
import cruise.associations.StudentAA;

public class ManyToOptionalNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentAA s = new StudentAA(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorAA m = new MentorAA("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }

  @Test
  public void setTooMany()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);
    MentorAA m = new MentorAA("blah");
    Assert.assertEquals(false,m.setStudents(s,s2,s3)); 
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(0,s2.numberOfMentors());
    Assert.assertEquals(0,s3.numberOfMentors());
  }
  
  
  @Test
  public void setStudentsAtMax()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);

    MentorAA m = new MentorAA("blah");
    m.setStudents(s,s2);
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
  }
  
  @Test
  public void setStudentsWatchOutForDuplicates()
  {
    StudentAA s = new StudentAA(99);
    MentorAA m = new MentorAA("blah");
    Assert.assertEquals(false,m.setStudents(s,s));
  }
  
  @Test
  public void setStudentsDoNotEraseExisting()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);
    StudentAA s3 = new StudentAA(97);
    
    MentorAA m = new MentorAA("blah");
    m.setStudents(s,s2);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(0, s3.numberOfMentors());    

    MentorAA m2 = new MentorAA("blah2");
    m2.setStudents(s,s3);
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(m2, s.getMentor(1));
    Assert.assertEquals(m2, s3.getMentor(0));

  }   
  
  @Test
  public void setStudents_aboveNKeepsExistingIntact()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);
    StudentAA s4 = new StudentAA(96);
    StudentAA s5 = new StudentAA(95);

    MentorAA m = new MentorAA("blah");
    
    Assert.assertEquals(true,m.setStudents(s,s2));
    Assert.assertEquals(false, m.setStudents(s2, s3, s4, s5, s));
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
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    

    MentorAA m = new MentorAA("blah");
    Assert.assertEquals(false, m.setStudents(s, s2, s));
  }

  @Test
  public void setStudents_atNOverwritesExisting()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);

    MentorAA m = new MentorAA("blah");
    
    Assert.assertEquals(true, m.setStudents(s, s2));
    Assert.assertEquals(true, m.setStudents(s2, s3));
    Assert.assertEquals(2,m.numberOfStudents());

    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
   
  }
  
  @Test
  public void addMentorTooMany()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);

    MentorAA m = new MentorAA("blah");
    m.setStudents(s,s2);
    
    Assert.assertEquals(false,s3.addMentor(m));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(0,s3.numberOfMentors());
    
  }

  @Test
  public void addMentorTOkay()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    

    MentorAA m = new MentorAA("blah");
    m.setStudents(s);
    
    Assert.assertEquals(true,s2.addMentor(m));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(1,s2.numberOfMentors());
    
  }
  
  
  @Test
  public void addStudent()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);
    StudentAA s3 = new StudentAA(97); 

    MentorAA m = new MentorAA("blah");
    Assert.assertEquals(true,m.setStudents(s));

    Assert.assertEquals(1,m.numberOfStudents());
    
    Assert.assertEquals(true,m.addStudent(s2));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
   
    Assert.assertEquals(false,m.addStudent(s3));
    Assert.assertEquals(2,m.numberOfStudents());
  
  }  

  @Test
  public void addStudentHasExistingMentor()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);

    MentorAA m = new MentorAA("blah");
    MentorAA m2 = new MentorAA("blah2");

    m.setStudents(s,s2);
    m2.setStudents(s3);
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(1,m2.numberOfStudents());

    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
    
    Assert.assertEquals(m2,s3.getMentor(0));
    
    Assert.assertEquals(true,m2.addStudent(s2));
    
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    
    Assert.assertEquals(2,s2.numberOfMentors());    
    Assert.assertEquals(m,s2.getMentor(0));    
    Assert.assertEquals(m2,s2.getMentor(1));

    Assert.assertEquals(false,m.addStudent(s3));
  }  

  @Test
  public void removeStudent()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);    
    StudentAA s3 = new StudentAA(97);

    MentorAA m = new MentorAA("blah");
    m.setStudents(s,s2);
    
    Assert.assertEquals(false,m.removeStudent(s3));
    Assert.assertEquals(true,m.removeStudent(s2));
    
    Assert.assertEquals(1,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(0,s2.numberOfMentors());
    Assert.assertEquals(0,s3.numberOfMentors());

    Assert.assertEquals(true,m.removeStudent(s));
    Assert.assertEquals(0,m.numberOfStudents());
  }  
  
  
  
  
  @Test
  public void setStudents_empty()
  {
    StudentAA s = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);
    MentorAA m = new MentorAA("blah");
    m.setStudents(s,s2);
    Assert.assertEquals(true, m.setStudents());
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
    Assert.assertEquals(0,s2.numberOfMentors());
  }

  
  @Test
  public void deleteStudentLeavesMentorAlone()
  {
    StudentAA s1 = new StudentAA(99);
    StudentAA s2 = new StudentAA(98);

    MentorAA m = new MentorAA("blah");
    m.setStudents(s1,s2);
    ProgramAA studentP = new ProgramAA();
    ProgramAA mentorP = new ProgramAA();
    
    s2.setProgram(studentP);
    m.setProgram(mentorP);

    s1.delete();
    
    Assert.assertEquals(1,m.numberOfStudents());
    Assert.assertEquals(mentorP,m.getProgram());
    Assert.assertEquals(m,mentorP.getMentor());
    Assert.assertEquals(studentP,s2.getProgram());
    Assert.assertEquals(0,s1.numberOfMentors());
  } 
  
  @Test
  public void studentBounds()
  {
    Assert.assertEquals(2,MentorAA.maximumNumberOfStudents());
  }

  
  
}
