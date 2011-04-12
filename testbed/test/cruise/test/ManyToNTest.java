package cruise.test;

import org.junit.*;

public class ManyToNTest
{

  @Test
  public void CreateStudentWithoutMentor()
  {
    StudentQ s = new StudentQ(99);
    Assert.assertEquals(0,s.numberOfMentors());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooFew()
  {
    StudentQ s = new StudentQ(99);
    new MentorQ("blah",s);
  }

  @Test(expected=RuntimeException.class)
  public void ConstructorWithTooMany()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);    
    StudentQ s3 = new StudentQ(97);
    new MentorQ("blah",s,s2,s3);
  }
  
  
  @Test
  public void constructorJustRight()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);

    MentorQ m = new MentorQ("blah",s,s2);

    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(m,s.getMentor(0));
    Assert.assertEquals(m,s2.getMentor(0));
  }
  
  @Test(expected=RuntimeException.class)
  public void constructorWatchOutForDuplicateEntries()
  {
    StudentQ s = new StudentQ(99);
    new MentorQ("blah",s, s);
  }
  
  @Test
  public void constructorExistingMentorsOkay()
  {
    StudentQ s1 = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);
    StudentQ s3 = new StudentQ(97);
    
    MentorQ m = new MentorQ("blah",s1,s2);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    Assert.assertEquals(0, s3.numberOfMentors());    

    MentorQ m2 = new MentorQ("blah2",s2,s3);
    
    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(m, s1.getMentor(0));
    Assert.assertEquals(m, s2.getMentor(0));
    
    Assert.assertEquals(2, m2.numberOfStudents());
    Assert.assertEquals(m2, s2.getMentor(1));
    Assert.assertEquals(m2, s3.getMentor(0));

  }   
  
  @Test
  public void setStudents_outsideN()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);    
    StudentQ s3 = new StudentQ(97);
    StudentQ s4 = new StudentQ(96);
    StudentQ s5 = new StudentQ(95);

    MentorQ m = new MentorQ("blah",s, s2);
    
    Assert.assertEquals(false, m.setStudents(s2, s3, s4));
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
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);    
    StudentQ s3 = new StudentQ(97);

    MentorQ m = new MentorQ("blah",s, s2);
    Assert.assertEquals(false, m.setStudents(s2, s2, s3));
  }

  @Test
  public void setStudents_withinN()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);    
    StudentQ s3 = new StudentQ(97);

    MentorQ m = new MentorQ("blah",s, s2);
    
    Assert.assertEquals(true, m.setStudents(s3, s2));
    Assert.assertEquals(2,m.numberOfStudents());

    Assert.assertEquals(0,s.numberOfMentors());

    Assert.assertEquals(m,s2.getMentor(0));
    Assert.assertEquals(m,s3.getMentor(0));
  }
  


  @Test
  public void setStudents_empty()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);
    MentorQ m = new MentorQ("blah",s,s2);

    Assert.assertEquals(false, m.setStudents());
    Assert.assertEquals(2,m.numberOfStudents());
  }
  
  @Test
  public void deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    StudentQ s1 = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);

    MentorQ m = new MentorQ("blah",s1,s2);
    ProgramQ studentP = new ProgramQ();
    ProgramQ mentorP = new ProgramQ();
    
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
  public void addMentorTooMany()
  {
    StudentQ s = new StudentQ(99);
    StudentQ s2 = new StudentQ(98);    
    StudentQ s3 = new StudentQ(97);

    MentorQ m = new MentorQ("blah",s,s2);
    
    Assert.assertEquals(false,s3.addMentor(m));
    Assert.assertEquals(2,m.numberOfStudents());
    Assert.assertEquals(0,s3.numberOfMentors());
    
  }

}
