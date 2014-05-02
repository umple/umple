package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class MultipleQueuedStateMachinesTest
{ 
	
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(3, MultipleQueuedSMs.MessageType.values().length);
	  Assert.assertEquals(true, MultipleQueuedSMs.MessageType.valueOf("e1_M").equals(MultipleQueuedSMs.MessageType.e1_M));
	  Assert.assertEquals(true, MultipleQueuedSMs.MessageType.valueOf("e2_M").equals(MultipleQueuedSMs.MessageType.e2_M));
	  Assert.assertEquals(true, MultipleQueuedSMs.MessageType.valueOf("e4_M").equals(MultipleQueuedSMs.MessageType.e4_M));
  }
  @Ignore  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultipleQueuedSMs psm = new MultipleQueuedSMs();
	  
	  // check initial states are s1 - s3
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s3
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  // event e2 is taken off the queue and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s4
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s4, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  //event e2 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s4, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);
	  // event e4 is taken off the queue and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s3
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s3
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  //event e1 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);  
	  //event e4 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10); 
	  //event e4 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s3, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

      //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  // event e2 is taken off the queue and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s4
	  Assert.assertEquals(MultipleQueuedSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs.Sm1.s4, psm.getSm1());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());	  
	  	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.queue.messages.size());	  
  }
}