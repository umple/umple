//package cruise.queued.statemachine.test;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//
//public class QueuedStateMachineTest_autoTransition
//{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
//	  Assert.assertEquals(0, QueuedSM_autoTransition.MessageType.values().length); 
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  QueuedSM_autoTransition qsm = new QueuedSM_autoTransition();
//	  // check initial state is s1
//	  Assert.assertEquals(QueuedSM_autoTransition.Sm.s2, qsm.getSm());	    
//		  
//	  //check that there is no event left in the queue
//	  Assert.assertEquals(0, qsm.pool.messages.size());
//		  
//  }
//}