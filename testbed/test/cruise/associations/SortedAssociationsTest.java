package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAI;
import cruise.associations.ProgramAI;
import cruise.associations.StudentAI;

public class SortedAssociationsTest
{

  @Test
  public void setStudent()
  {
  	ClassThatWillHaveSortedAssociationOne t = new ClassThatWillHaveSortedAssociationOne("Tom Jim");
  	ClassThatWillHaveSortedAssociationOne j = new ClassThatWillHaveSortedAssociationOne("Jim Tom");
  	ClassThatWillHaveSortedAssociationTwo check = new ClassThatWillHaveSortedAssociationTwo();
  	check.addMass(t);
  	check.addMass(j);
  	Assert.assertEquals(j,check.getMass(0));
  }
  
  @Test
  public void multipleSorted()
  {
    MultipleSortedAcademy ac = new MultipleSortedAcademy();
    MultipleSortedStudent j = ac.addRegistrant(12,"Jim");
    MultipleSortedStudent a = ac.addRegistrant(4,"Ali");
    MultipleSortedStudent m = ac.addRegistrant(8,"Mary");
    MultipleSortedStudent f = ac.addRegistrant(3,"Francois");
    MultipleSortedCourse c = ac.addMultipleSortedCourse("CS191");
    MultipleSortedCourse c2 =ac.addMultipleSortedCourse("AN234");
    j.addMultipleSortedRegistration(c);
    a.addMultipleSortedRegistration(c);
    m.addMultipleSortedRegistration(c);
    f.addMultipleSortedRegistration(c);
    m.addMultipleSortedRegistration(c2);
    f.addMultipleSortedRegistration(c2);
    
    Assert.assertEquals(a,c.getMultipleSortedRegistration(0).getMultipleSortedStudent());
    Assert.assertEquals(f,c.getMultipleSortedRegistration(1).getMultipleSortedStudent());
    Assert.assertEquals(j,c.getMultipleSortedRegistration(2).getMultipleSortedStudent());        
    Assert.assertEquals(m,c.getMultipleSortedRegistration(3).getMultipleSortedStudent());
    
    Assert.assertEquals(f,c2.getMultipleSortedRegistration(0).getMultipleSortedStudent());
    Assert.assertEquals(m,c2.getMultipleSortedRegistration(1).getMultipleSortedStudent());
  }
}
