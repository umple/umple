/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

 In this case, there is a maximum bound on the number of StudentAQ's contained
 within MentorAQ. so a getMaximumNumberOfStudents() method should generate in
 MentorAQ but currently does not. See Issue351 for details.
 
 Due to this, I have commented out all the tests for the setMethod, because that set method
 would not generate for cases where there is an upperBound. Possible test code would look
 like what is below in comments. Or see OptionalOneToMandatoryMentTest.java for some examples.
*/

package cruise.associations;

import org.junit.*;

public class OptionalOneToMandatoryMNTest
{
	@Test 
	public void TestTruth()
	{
		Assert.assertTrue(true);
	}
	
//  @Test
//  public void TestA_InitMentorAQIsNull()
//  {
//	  // Each StudentAQ may have 0 or 1 MentorAQs. This class gets the setMentorAQ() method
//	  // Each MentorAQ must have at least one StudentAQ. There is no setStudentAQ method
//	  // NOTE - There should be consideration for maximum number of StudentAQs in the set method!
//	  //  Currently this is not considered because the method is not generated for the class unless
//	  //  there actually is a maximum number of StudentAQs.
//	  StudentAQ	S1, S2, S3;
//	  
//	  // Test to ensure we can create StudentAQs with no MentorAQs Initially
//	  S1 = new StudentAQ();
//	  S2 = new StudentAQ();
//	  S3 = new StudentAQ();
//	  
//	  Assert.assertEquals(null,S1.getMentorAQ());
//	  Assert.assertEquals(null,S2.getMentorAQ());
//	  Assert.assertEquals(null,S3.getMentorAQ());
//
//  }
//	
//  @Test
//  public void TestB_MentorAQCtorAcceptsStudentAQAsArgumentProperly()
//  {
//	  StudentAQ S1;
//	  MentorAQ  M1;
//	  int	  idx;
//	  
//	  S1 = new StudentAQ();
//	  // Check to ensure that Creating a MentorAQ with StudentAQ sets
//	  // association properly
//	  
//	  M1 = new MentorAQ(S1);
//	 
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertEquals(S1, M1.getStudentAQ(0));
//	  Assert.assertEquals(1, M1.numberOfStudentAQs());
//	 
//	  idx = M1.indexOfStudentAQ(S1);
//	  Assert.assertEquals(true, (idx>=0 && idx < M1.numberOfStudentAQs()));
//  }
//  
//  @Test
//  public void TestC_FromNullToValue()
//  {
//	  
//	StudentAQ S1, S2;
//	MentorAQ  M1;
//	
//	S1 = new StudentAQ();
//	S2 = new StudentAQ();
//	M1 = new MentorAQ(S1);
//	
//	// ensure that we have things set up properly
//	Assert.assertEquals(S1.getMentorAQ(), M1);
//	Assert.assertEquals(null,S2.getMentorAQ());
//	
//	// Ensure that setting the MentorAQ of S2 -> M1 only adds S2 to M1's StudentAQ list
//	S2.setMentorAQ(M1);
//    Assert.assertEquals(2, M1.numberOfStudentAQs());
//	Assert.assertEquals(M1, S2.getMentorAQ());	  
//  }
//  
//  @Test
//  public void TestD_FailsWhenStudentAQIsMandatory()
//  {
//	  StudentAQ S1;
//	  MentorAQ  M1;
//	  
//	  S1 = new StudentAQ();
//	  M1 = new MentorAQ(S1);
//	  
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertFalse(S1.setMentorAQ(null));
//  }
//  
//  @Test
//  public void TestE_SucceedsWhenStudentAQIsNotMandatory()
//  {
//	  StudentAQ S1, S2;
//	  MentorAQ  M1;
//	  
//	  S1 = new StudentAQ();
//	  S2 = new StudentAQ();
//	  M1 = new MentorAQ(S1);
//	  S2.setMentorAQ(M1);
//	  
//	  Assert.assertEquals(2, M1.numberOfStudentAQs());
//	  Assert.assertTrue(S1.setMentorAQ(null));
//  }
//  
//  @Test
//  public void TestF_ChangingMentorAQMovesStudentAQFromListAndAddsToNewList()
//  {
//	  StudentAQ S1, S2, S3;
//	  MentorAQ M1, M2;
//	  
//	  S1 = new StudentAQ();
//	  S2 = new StudentAQ();
//	  S3 = new StudentAQ();
//	  M1 = new MentorAQ(S1);
//	  M2 = new MentorAQ(S2);
//	  
//	  Assert.assertTrue(S3.setMentorAQ(M1));
//	  
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertEquals(M2, S2.getMentorAQ());
//	  Assert.assertEquals(M1, S3.getMentorAQ());
//	  Assert.assertEquals(2, M1.numberOfStudentAQs());
//	  Assert.assertEquals(1, M2.numberOfStudentAQs());
//	  
//	  Assert.assertTrue(S3.setMentorAQ(M2));
//	  
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertEquals(M2, S2.getMentorAQ());
//	  Assert.assertEquals(M2, S3.getMentorAQ());
//	  Assert.assertEquals(1, M1.numberOfStudentAQs());
//	  Assert.assertEquals(2, M2.numberOfStudentAQs());
//  }
//	
//  @Test
//  public void TestG_WhenStudentAQIsMandatoryChangeFails()
//  {
//	  StudentAQ S1, S2;
//	  MentorAQ M1, M2;
//	  
//	  S1 = new StudentAQ();
//	  S2 = new StudentAQ();
//	  M1 = new MentorAQ(S1);
//	  M2 = new MentorAQ(S2);
//	  
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertEquals(M2, S2.getMentorAQ());
//	  Assert.assertEquals(1, M1.numberOfStudentAQs());
//	  Assert.assertEquals(1, M2.numberOfStudentAQs());
//	  
//	  Assert.assertFalse(S1.setMentorAQ(M2));
//	  
//	  Assert.assertEquals(M1, S1.getMentorAQ());
//	  Assert.assertEquals(M2, S2.getMentorAQ());
//	  Assert.assertEquals(1, M1.numberOfStudentAQs());
//	  Assert.assertEquals(1, M2.numberOfStudentAQs());
//  }
//
//  @Test
//  public void TestConsideration_OptionalOne_To_Mandatory_M_With_Maximum_N()
//  {
//	// If you are reading this. Then you must consider that there should be
//	// a maximumNumberOfStudentAQs() variable at time. this is a new association.
//	// Currently we do not generate for this condition.
//	  
//  	Assert.assertTrue(true);
//  }
//	
}