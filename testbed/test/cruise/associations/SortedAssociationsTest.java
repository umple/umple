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
  
  
}
