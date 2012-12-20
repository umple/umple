package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAD;
import cruise.associations.ProgramAD;
import cruise.associations.StudentAD;

public class MStarToOptionalNTest
{

  @Test
  public void CreateStudentWihtoutMentor()
  {
    StudentAD s =new StudentAD(99);
    Assert.assertEquals(false,s.isNumberOfMentorsValid());
  }
  
  @Test
  public void CreateMentorWithoutStudent()
  {
    MentorAD m = new MentorAD("blah");
    Assert.assertEquals(0,m.numberOfStudents());
  }
  
  @Test
  public void AddStudentsAndMentorsOkay()
  {
    MentorAD m = new MentorAD("blah");
    MentorAD m2 = new MentorAD("blah2");
    MentorAD m3 = new MentorAD("blah3");
    MentorAD m4 = new MentorAD("blah4");
    MentorAD m5 = new MentorAD("blah5");
    MentorAD m6 = new MentorAD("blah6");
    
    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    StudentAD s3 = new StudentAD(97);

    Assert.assertEquals(true,m.addStudent(s));
    Assert.assertEquals(true,m.addStudent(s2));
    Assert.assertEquals(false,m.addStudent(s3));
    
    Assert.assertEquals(true,s.addMentor(m2));
    Assert.assertEquals(true,s.addMentor(m3));
    Assert.assertEquals(true,s.addMentor(m4));
    Assert.assertEquals(true,s.addMentor(m5));
    Assert.assertEquals(true,s.addMentor(m6));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m4,s.getMentor(3));
    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(6,s.numberOfMentors());
  }
  
  @Test
  public void isNumberOfValid()
  {
    StudentAD s = new StudentAD(99);
    Assert.assertEquals(false,s.isNumberOfMentorsValid());

    s.addMentor(new MentorAD("blah"));
    Assert.assertEquals(false,s.isNumberOfMentorsValid());

    s.addMentor(new MentorAD("blah2"));
    Assert.assertEquals(false,s.isNumberOfMentorsValid());

    s.addMentor(new MentorAD("blah3"));
    Assert.assertEquals(true,s.isNumberOfMentorsValid());

    s.addMentor(new MentorAD("blah4"));
    Assert.assertEquals(true,s.isNumberOfMentorsValid());
  }
  
  @Test
  public void RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    StudentAD s = new StudentAD(99);
    
    MentorAD m = new MentorAD("blah");
    MentorAD m2 = new MentorAD("blah2");
    MentorAD m3 = new MentorAD("blah3");

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
    MentorAD m = new MentorAD("blah");
    MentorAD m2 = new MentorAD("blah2");
    MentorAD m3 = new MentorAD("blah3");
    MentorAD m4 = new MentorAD("blah3");
    
    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    StudentAD s3 = new StudentAD(97);
    
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
    MentorAD m = new MentorAD("blah");
    
    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    StudentAD s3 = new StudentAD(97);
    
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
    MentorAD m = new MentorAD("blah");
    
    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    StudentAD s3 = new StudentAD(97);
    
    m.addStudent(s);
    m.addStudent(s2);
    
    Assert.assertEquals(false,m.addStudent(s3));
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(0,s3.numberOfMentors());
  }    
  
  @Test
  public void getBoundsForStudent()
  {
    Assert.assertEquals(2,MentorAD.maximumNumberOfStudents());
  }  
  
  @Test
  public void getBoundsForMentor()
  {
    Assert.assertEquals(3,StudentAD.minimumNumberOfMentors());
  }    
  
  @Test
  public void deleteMentorAndStudentHasEnough()
  {
    
    MentorAD m = new MentorAD("blah");
    MentorAD m2 = new MentorAD("blah2");
    MentorAD m3 = new MentorAD("blah2");
    MentorAD m4 = new MentorAD("blah2");

    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    m3.addStudent(s);
    m3.addStudent(s2);
    m4.addStudent(s);
    m4.addStudent(s2);
    
    ProgramAD p = new ProgramAD();
    s.setProgram(p);
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(p,s.getProgram());
    Assert.assertEquals(3,s.numberOfMentors());
  }  

  @Test
  public void deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    MentorAD m = new MentorAD("blah");
    MentorAD m2 = new MentorAD("blah2");
    MentorAD m3 = new MentorAD("blah2");

    StudentAD s = new StudentAD(99);
    StudentAD s2 = new StudentAD(98);
    
    m.addStudent(s);
    m.addStudent(s2);
    m2.addStudent(s);
    m2.addStudent(s2);
    m3.addStudent(s);
    m3.addStudent(s2);
    
    ProgramAD p = new ProgramAD();
    s.setProgram(p);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(2,m2.numberOfStudents());
    Assert.assertEquals(3,s.numberOfMentors());
    
    m.delete();
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertEquals(0,m2.numberOfStudents());
    Assert.assertEquals(0,s.numberOfMentors());
  }  

}
