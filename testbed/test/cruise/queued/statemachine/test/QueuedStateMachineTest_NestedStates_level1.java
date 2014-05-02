package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

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
	  int numChecks;
	  //initial state is s1
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s1, qsm.getSm());
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  //e2 is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(QueuedSM_NestedStates_level1.Sm.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
	  	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s1, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s1, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  //e1 is dequeued and processed: transition to s2
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(QueuedSM_NestedStates_level1.Sm.s2) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s2, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  
	  
	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  //e3 is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(QueuedSM_NestedStates_level1.Sm.s2)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
	  	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s2, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.Sm.s2, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  //e2 is dequeued and processed: transition to s2b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  
	  
	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  //e1 is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2b)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
	  	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  //e3 is dequeued and processed: transition to s2a
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2a) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  //e2 is dequeued and processed: transition to s2b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  //e3 is dequeued and processed: transition to s2a
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2a) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e1 is triggered: e1 is queued
	  qsm.e1();
	  //e1 is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2a)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
	  	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  
	  
	  //e2 is triggered: e2 is queued
	  qsm.e2();
	  //e2 is dequeued and processed: transition to s2b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2b, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e3 is triggered: e3 is queued
	  qsm.e3();
	  //e3 is dequeued and processed: transition to s2a
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS2().equals(QueuedSM_NestedStates_level1.SmS2.s2a) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level1.SmS2.s2a, qsm.getSmS2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //check that there is no events left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
  }
}