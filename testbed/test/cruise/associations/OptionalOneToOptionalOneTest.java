package cruise.associations;

import org.junit.*;

import cruise.associations.MentorA;
import cruise.associations.StudentA;

public class OptionalOneToOptionalOneTest
{

  @Test
  public void Constructor()
  {
    MentorA mentor = new MentorA();
    StudentA student = new StudentA();
    
    Assert.assertEquals(null,mentor.getStudent());
    Assert.assertEquals(null,student.getMentor());
  }
  
  @Test
  public void NewRelationshipReplaceExisting()
  {
    MentorA m1 = new MentorA();
    StudentA sA = new StudentA();
    MentorA m2 = new MentorA();
    StudentA sB = new StudentA();
    
    m1.setStudent(sA);
    m2.setStudent(sB);

    Assert.assertEquals(sA, m1.getStudent());
    Assert.assertEquals(m1, sA.getMentor());
    Assert.assertEquals(sB, m2.getStudent());
    Assert.assertEquals(m2, sB.getMentor());
    
    m2.setStudent(sA);
    
    Assert.assertEquals(sA, m2.getStudent());
    Assert.assertEquals(m2, sA.getMentor());
    Assert.assertEquals(null, m1.getStudent());
    Assert.assertEquals(null, sB.getMentor());
  }  
  
  @Test
  public void NewRelationshipWhenNm1Existed()
  {
    MentorA m1 = new MentorA();
    StudentA sA = new StudentA();
    MentorA m2 = new MentorA();
    
    m1.setStudent(sA);
    m2.setStudent(sA);
    
    Assert.assertEquals(sA, m2.getStudent());
    Assert.assertEquals(m2, sA.getMentor());
    Assert.assertEquals(null, m1.getStudent());
  }
  
  @Test
  public void RemoveRelationship()
  {
    MentorA m1 = new MentorA();
    StudentA sA = new StudentA();
    m1.setStudent(sA);
    
    m1.setStudent(null);
    
    Assert.assertEquals(null, m1.getStudent());
    Assert.assertEquals(null, sA.getMentor());
  }   
  
  @Test
  public void RemoveRelationshipThatNeverWas()
  {
    MentorA m1 = new MentorA();
    m1.setStudent(null);
    
    Assert.assertEquals(null, m1.getStudent());
  }   
  
  @Test
  public void DeleteRelationship()
  {
    MentorA m1 = new MentorA();
    StudentA sA = new StudentA();
    m1.setStudent(sA);
    
    m1.delete();

    Assert.assertEquals(null, m1.getStudent());
    Assert.assertEquals(null, sA.getMentor());
  }
  
  @Test
  public void DeleteRelationshipThatNeverExisted()
  {
    MentorA m1 = new MentorA();
    StudentA sA = new StudentA();
    
    m1.delete();

    Assert.assertEquals(null, m1.getStudent());
    Assert.assertEquals(null, sA.getMentor());
  }  
  
}
