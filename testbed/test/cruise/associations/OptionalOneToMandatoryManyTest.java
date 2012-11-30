/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

 In this case, there is no maximum bound on the number of StudentAR's contained
 within MentorAR. so a getMaximumNumberOfStudents() method should NOT generate in
 MentorAR
*/

package cruise.associations;

import org.junit.*;

public class OptionalOneToMandatoryManyTest
{
	
  @Test 
  public void TestTruth()
  {
  	Assert.assertTrue(true);
  }

  @Test
  public void TestA_InitMentorARIsNull()
  {
	  // Each StudentAR may have 0 or 1 MentorARs. This class gets the setMentorAR() method
	  // Each MentorAR must have at least one StudentAR. There is no setStudentAR method
	  // NOTE - There should be consideration for maximum number of StudentARs in the set method!
	  //  Currently this is not considered because the method is not generated for the class unless
	  //  there actually is a maximum number of StudentARs.
	  StudentAR	S1, S2, S3;
	  
	  // Test to ensure we can create StudentARs with no MentorARs Initially
	  S1 = new StudentAR();
	  S2 = new StudentAR();
	  S3 = new StudentAR();
	  
	  Assert.assertEquals(null,S1.getMentorAR());
	  Assert.assertEquals(null,S2.getMentorAR());
	  Assert.assertEquals(null,S3.getMentorAR());

  }
	
  @Test
  public void TestB_MentorARCtorAcceptsStudentARAsArgumentProperly()
  {
	  StudentAR S1;
	  MentorAR  M1;
	  int	  idx;
	  
	  S1 = new StudentAR();
	  // Check to ensure that Creating a MentorAR with StudentAR sets
	  // association properly
	  
	  M1 = new MentorAR(S1);
	 
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertEquals(S1, M1.getStudentAR(0));
	  Assert.assertEquals(1, M1.numberOfStudentARs());
	 
	  idx = M1.indexOfStudentAR(S1);
	  Assert.assertEquals(true, (idx>=0 && idx < M1.numberOfStudentARs()));
  }
  
  @Test
  public void TestC_FromNullToValue()
  {
	  
	StudentAR S1, S2;
	MentorAR  M1;
	
	S1 = new StudentAR();
	S2 = new StudentAR();
	M1 = new MentorAR(S1);
	
	// ensure that we have things set up properly
	Assert.assertEquals(S1.getMentorAR(), M1);
	Assert.assertEquals(null,S2.getMentorAR());
	
	// Ensure that setting the MentorAR of S2 -> M1 only adds S2 to M1's StudentAR list
	S2.setMentorAR(M1);
    Assert.assertEquals(2, M1.numberOfStudentARs());
	Assert.assertEquals(M1, S2.getMentorAR());	  
  }
  
  @Test
  public void TestD_FailsWhenStudentARIsMandatory()
  {
	  StudentAR S1;
	  MentorAR  M1;
	  
	  S1 = new StudentAR();
	  M1 = new MentorAR(S1);
	  
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertFalse(S1.setMentorAR(null));
  }
  
  @Test
  public void TestE_SucceedsWhenStudentARIsNotMandatory()
  {
	  StudentAR S1, S2;
	  MentorAR  M1;
	  
	  S1 = new StudentAR();
	  S2 = new StudentAR();
	  M1 = new MentorAR(S1);
	  S2.setMentorAR(M1);
	  
	  Assert.assertEquals(2, M1.numberOfStudentARs());
	  Assert.assertTrue(S1.setMentorAR(null));
  }
  
  @Test
  public void TestF_ChangingMentorARMovesStudentARFromListAndAddsToNewList()
  {
	  StudentAR S1, S2, S3;
	  MentorAR M1, M2;
	  
	  S1 = new StudentAR();
	  S2 = new StudentAR();
	  S3 = new StudentAR();
	  M1 = new MentorAR(S1);
	  M2 = new MentorAR(S2);
	  
	  Assert.assertTrue(S3.setMentorAR(M1));
	  
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertEquals(M2, S2.getMentorAR());
	  Assert.assertEquals(M1, S3.getMentorAR());
	  Assert.assertEquals(2, M1.numberOfStudentARs());
	  Assert.assertEquals(1, M2.numberOfStudentARs());
	  
	  Assert.assertTrue(S3.setMentorAR(M2));
	  
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertEquals(M2, S2.getMentorAR());
	  Assert.assertEquals(M2, S3.getMentorAR());
	  Assert.assertEquals(1, M1.numberOfStudentARs());
	  Assert.assertEquals(2, M2.numberOfStudentARs());
  }
	
  @Test
  public void TestG_WhenStudentARIsMandatoryChangeFails()
  {
	  StudentAR S1, S2;
	  MentorAR M1, M2;
	  
	  S1 = new StudentAR();
	  S2 = new StudentAR();
	  M1 = new MentorAR(S1);
	  M2 = new MentorAR(S2);
	  
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertEquals(M2, S2.getMentorAR());
	  Assert.assertEquals(1, M1.numberOfStudentARs());
	  Assert.assertEquals(1, M2.numberOfStudentARs());
	  
	  Assert.assertFalse(S1.setMentorAR(M2));
	  
	  Assert.assertEquals(M1, S1.getMentorAR());
	  Assert.assertEquals(M2, S2.getMentorAR());
	  Assert.assertEquals(1, M1.numberOfStudentARs());
	  Assert.assertEquals(1, M2.numberOfStudentARs());
  }

  @Test
  public void TestConsideration_OptionalOne_To_Mandatory_M_With_Maximum_N()
  {
	// If you are reading this. Then you must consider that there should be
	// a maximumNumberOfStudentARs() variable. Due to the association, there
	// is no maximum bound so the method should not generate.
	  
  	Assert.assertTrue(true);
  }
	
}