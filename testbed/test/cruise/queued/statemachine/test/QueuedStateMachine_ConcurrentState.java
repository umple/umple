package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class QueuedStateMachine_ConcurrentState
{ 
	
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(5, QueuedSM_ConcurrentState.MessageType.values().length);
	  Assert.assertEquals(true, QueuedSM_ConcurrentState.MessageType.valueOf("e1_M").equals(QueuedSM_ConcurrentState.MessageType.e1_M));
	  Assert.assertEquals(true, QueuedSM_ConcurrentState.MessageType.valueOf("e2_M").equals(QueuedSM_ConcurrentState.MessageType.e2_M));
	  Assert.assertEquals(true, QueuedSM_ConcurrentState.MessageType.valueOf("e3_M").equals(QueuedSM_ConcurrentState.MessageType.e3_M));
	  Assert.assertEquals(true, QueuedSM_ConcurrentState.MessageType.valueOf("e4_M").equals(QueuedSM_ConcurrentState.MessageType.e4_M));
	  Assert.assertEquals(true, QueuedSM_ConcurrentState.MessageType.valueOf("e5_M").equals(QueuedSM_ConcurrentState.MessageType.e5_M));
  }
    
  @Test 
  public void processEvents() throws InterruptedException
  {
	  QueuedSM_ConcurrentState psm = new QueuedSM_ConcurrentState();
	  // check initial states are s1 - Null - Null
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, psm.getSmS2c());
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  // event e2 is taken off the queue and is processed: transition to: s1 - Null - Null 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e3 is called
      psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  // event e3 is taken off the queue and is processed: transition to: s2 - s2b - s2c 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e4 is called
	  psm.e4();//event e4 is added to the queue
	  Thread.sleep(10);
	  // event e4 is taken off the queue and is processed: transition to: s2 - s2b - s2d 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e5 is called
	  psm.e5();//event e5 is added to the queue
	  Thread.sleep(10);
	  //event e5 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  // event e3 is taken off the queue and is processed: transition to: s2 - s2a - s2d
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the queue
	  Thread.sleep(10);
	  // event e2 is taken off the queue and is processed: transition to: s1 - Null - Null 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());	  

	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c 
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());

	  //event e3 is called
	  psm.e3();//event e3 is added to the queue
	  Thread.sleep(10);
	  //event e3 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());	  

	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  //event e1 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	   
	  //event e1 is called
	  psm.e1();//event e1 is added to the queue
	  Thread.sleep(10);
	  //event e1 is unspecified, it is ignored, current states are not changed
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, psm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, psm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, psm.queue.messages.size());
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.queue.messages.size());	  
  }
}