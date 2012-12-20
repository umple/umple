package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAM;
import cruise.associations.StudentAM;

public class AddAtIndexTest
{
  
  @Test
  public void SoAntDoesntComplain()
  {
    
  }

//  @Test
//  public void AddAtStart()
//  {
//     StudentAM s = new StudentAM(98);
//     StudentAM s2 = new StudentAM(99);
//     MentorAM m = new MentorAM("a");
//
//     Assert.assertEquals(0,m.numberOfStudents());
//     m.addStudent(s,0);
//     Assert.assertEquals(1,m.numberOfStudents());
//     
//     m.addStudent(s2,0);
//     Assert.assertEquals(2,m.numberOfStudents());
//     
//     Assert.assertEquals(99,m.getStudent(0).getId());
//     Assert.assertEquals(98,m.getStudent(1).getId());
//  }
//
//  @Test
//  public void AddInMiddle()
//  {
//    StudentAM s = new StudentAM(98);
//    StudentAM s2 = new StudentAM(99);
//    StudentAM s3 = new StudentAM(100);
//
//    MentorAM m = new MentorAM("a");
//    
//    m.addStudent(s);
//    m.addStudent(s3);
//    m.addStudent(s2,1);
//    
//    Assert.assertEquals(98,m.getStudent(0).getId());
//    Assert.assertEquals(99,m.getStudent(1).getId());
//    Assert.assertEquals(100,m.getStudent(2).getId());
//  }
//  
//  @Test
//  public void AddAtEnd()
//  {
//    StudentAM s = new StudentAM(98);
//    StudentAM s2 = new StudentAM(99);
//    StudentAM s3 = new StudentAM(100);
//
//    MentorAM m = new MentorAM("a");
//    
//    m.addStudent(s);
//    m.addStudent(s2);
//    m.addStudent(s3,2);
//    
//    Assert.assertEquals(98,m.getStudent(0).getId());
//    Assert.assertEquals(99,m.getStudent(1).getId());
//    Assert.assertEquals(100,m.getStudent(2).getId());
//  }
// 
//  @Test
//  public void AddOutsideRange()
//  {
//    StudentAM s = new StudentAM(98);
//    StudentAM s2 = new StudentAM(99);
//
//    MentorAM m = new MentorAM("a");
//    
//    m.addStudent(s);
//    Assert.assertEquals(false,m.addStudent(s2,-1));
//    Assert.assertEquals(false,m.addStudent(s2,2));
//    Assert.assertEquals(1,m.numberOfStudents());    
//  }
  

}