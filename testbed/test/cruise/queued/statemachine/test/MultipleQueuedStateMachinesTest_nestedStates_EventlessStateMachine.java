package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class MultipleQueuedStateMachinesTest_nestedStates_EventlessStateMachine
{ 

  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(6, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.values().length);
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e1_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e1_M));
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e2_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e2_M));
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e3_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e3_M));
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e4_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e4_M));
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e5_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e5_M));
	  Assert.assertEquals(true, MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.valueOf("e6_M").equals(MultipleQueuedSMs_nestedStates_EventlessSM.MessageType.e6_M));
  } 
  
  
  @Ignore
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultipleQueuedSMs_nestedStates_EventlessSM psm = new MultipleQueuedSMs_nestedStates_EventlessSM();
	  
	  // check initial states are s1 - s21
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed
	  // state machine sm: transition to: s1a 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  //event e2 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  // event e3 is taken off the queue and is processed
	  // state machine sm1: transition to: s4 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	 
	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);
	  // event e4 is taken off the queue and is processed
	  // state machine sm1: transition to: s4 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e5 is called
	  psm.e5();//event e5 is added to the queue
	  Thread.sleep(10);
	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  // event e5 is taken off the queue and is processed
	  // state machine smS1: transition to: s1b 
	  // event e3 is taken off the queue and is processed
	  // state machine smS1: transition to: s4 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1b, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e6 is called
	  psm.e6();//event e6 is added to the queue
	  Thread.sleep(10);
	  // event e6 is taken off the queue and is processed
	  // state machine sm: transition to: s2 
	  // state machine smS1: transition to: Null 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	 
	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);   
	  //event e3 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  //event e3 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);
	  // event e4 is taken off the queue and is processed
	  // state machine sm: transition to: s3 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e5 is called
	  psm.e5();//event e5 is added to the queue
	  Thread.sleep(10);
	  // event e5 is taken off the queue and is processed
	  // state machine sm: transition to: s1 
	  // state machine smS1: transition to: Null 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);
	  // event e4 is taken off the queue and is processed
	  // state machine sm: transition to: s3 
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, psm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.queue.messages.size());	
  }
}