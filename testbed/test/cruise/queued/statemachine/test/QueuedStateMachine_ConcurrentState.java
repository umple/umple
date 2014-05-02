package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

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
	  QueuedSM_ConcurrentState qsm = new QueuedSM_ConcurrentState();
	  int numChecks;

	  // check initial states are s1 - Null - Null
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, qsm.getSmS2c());
	  
	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && !qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2a) && !qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2c)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e2 is called
	  qsm.e2();//event e2 is added to the queue
	  // event e2 is taken off the queue and is processed: transition to: s1 - Null - Null 
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s1) && !qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.Null) && !qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.Null)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c 
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && !qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2a) && !qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2c)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e3 is called
      qsm.e3();//event e3 is added to the queue
	  // event e3 is taken off the queue and is processed: transition to: s2 - s2b - s2c 
      numChecks=200; // we will check for a second
	  while(!qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e4 is called
	  qsm.e4();//event e4 is added to the queue
	  // event e4 is taken off the queue and is processed: transition to: s2 - s2b - s2d 
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2d) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e5 is called
	  qsm.e5();//event e5 is added to the queue
	  //event e5 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && (qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2b) && qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2d))) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, qsm.getSmS2c());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e3 is called
	  qsm.e3();//event e3 is added to the queue
	  // event e3 is taken off the queue and is processed: transition to: s2 - s2a - s2d
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2a) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2d, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e2 is called
	  qsm.e2();//event e2 is added to the queue
	  // event e2 is taken off the queue and is processed: transition to: s1 - Null - Null 
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s1) && !qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.Null) && !qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.Null)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s1, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.Null, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.Null, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  // event e1 is taken off the queue and is processed: transition to: s2 - s2a - s2c 
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && !qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2a) && !qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2c)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2a, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e3 is called
	  qsm.e3();//event e3 is added to the queue
	  //event e3 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }	  
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  //event e1 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && (qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2b) && qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2c))) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	   
	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  //event e1 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && (qsm.getSm().equals(QueuedSM_ConcurrentState.Sm.s2) && qsm.getSmS2a().equals(QueuedSM_ConcurrentState.SmS2a.s2b) && qsm.getSmS2c().equals(QueuedSM_ConcurrentState.SmS2c.s2c))) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
			Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_ConcurrentState.Sm.s2, qsm.getSm());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2a.s2b, qsm.getSmS2a());
	  Assert.assertEquals(QueuedSM_ConcurrentState.SmS2c.s2c, qsm.getSmS2c());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  
  }
}