package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;


public class QueuedStateMachineTest_NestedStates_level1
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(3, QueuedSM_NestedStates_level1.MessageType.values().length);
	  Assert.assertEquals(true, QueuedSM_NestedStates_level1.MessageType.valueOf("e1_M").equals(QueuedSM_NestedStates_level1.MessageType.e1_M));
	  Assert.assertEquals(true, QueuedSM_NestedStates_level1.MessageType.valueOf("e2_M").equals(QueuedSM_NestedStates_level1.MessageType.e2_M));  
	  Assert.assertEquals(true, QueuedSM_NestedStates_level1.MessageType.valueOf("e3_M").equals(QueuedSM_NestedStates_level1.MessageType.e3_M));  
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  QueuedSM_NestedStates_level1 qsm = new QueuedSM_NestedStates_level1();
	  //initial state is s1
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s1, qsm.getSm());
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  Thread.sleep(10);
	  //e2 is dequeued and ignored (not processed: case of unspecified reception)
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s1, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  Thread.sleep(10);
	  //e1 is dequeued and processed: transition to s2
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s2, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  
	  
	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  Thread.sleep(10);
	  //e3 is dequeued and ignored (not processed: case of unspecified reception)
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s2, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  Thread.sleep(10);
	  //e2 is dequeued and processed: transition to s2b
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  
	  
	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  Thread.sleep(10);
	  //e1 is dequeued and ignored (not processed: case of unspecified reception)
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  Thread.sleep(10);
	  //e3 is dequeued and processed: transition to s2a
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  Thread.sleep(10);
	  //e2 is dequeued and processed: transition to s2b
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  Thread.sleep(10);
	  //e3 is dequeued and processed: transition to s2a
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  Thread.sleep(10);
	  //e1 is dequeued and ignored (not processed: case of unspecified reception)
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  Thread.sleep(10);
	  //e2 is dequeued and processed: transition to s2b
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  Thread.sleep(10);
	  //e3 is dequeued and processed: transition to s2a
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());	  

	  //check that there is no events left in the queue
	  Assert.assertEquals(0, qsm.pool.messages.size());
	  
  }
}