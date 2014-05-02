package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class QueuedStateMachineTest_NestedStates_level2
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(8, QueuedSM_NestedStates_level2.MessageType.values().length);
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("e_M").equals(QueuedSM_NestedStates_level2.MessageType.e_M));
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("f_M").equals(QueuedSM_NestedStates_level2.MessageType.f_M));  
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("g_M").equals(QueuedSM_NestedStates_level2.MessageType.g_M));
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("h_M").equals(QueuedSM_NestedStates_level2.MessageType.h_M));  
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("i_M").equals(QueuedSM_NestedStates_level2.MessageType.i_M));
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("j_M").equals(QueuedSM_NestedStates_level2.MessageType.j_M));  
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("k_M").equals(QueuedSM_NestedStates_level2.MessageType.k_M));  
	  Assert.assertEquals(true, QueuedSM_NestedStates_level2.MessageType.valueOf("m_M").equals(QueuedSM_NestedStates_level2.MessageType.m_M));  
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  QueuedSM_NestedStates_level2 qsm = new QueuedSM_NestedStates_level2();
	  int numChecks;
	  //initial state is s1
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  
	  //g is triggered: g is queued
	  qsm.g();
	  //g is dequeued and processed: transition to s1a
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1S1().equals(QueuedSM_NestedStates_level2.Sm1S1.s1a)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e is triggered: e is queued
	  qsm.e();
	  //e is dequeued and processed: transition to s2
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s2) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //f is triggered: f is queued
	  qsm.f();
	  //f is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s2)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.Null, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //j is triggered:j  is queued
	  qsm.j();
	  //j is dequeued and processed: transition to s1b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1S1().equals(QueuedSM_NestedStates_level2.Sm1S1.s1b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1b, qsm.getSm1S1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  // i is triggered: i is queued
	  qsm.i();
	  //i is dequeued and processed: transition to s2b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1S2().equals(QueuedSM_NestedStates_level2.Sm1S2.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  // k is triggered: k is queued
	  qsm.k();
	  //k is dequeued and processed: transition to s1
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e is triggered: e is queued
	  qsm.e();
	  //e is dequeued and processed: transition to s2
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s2) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //e is triggered: e is queued
	  qsm.e();
	  //e is dequeued and processed: transition to s1
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //h is triggered: h is queued
	  qsm.h();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //m is triggered:m  is queued
	  qsm.m();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //i is triggered: i is queued
	  qsm.i();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //h is triggered: h is queued
	  qsm.h();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //k is triggered: k is queued
	  qsm.k();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //f is triggered: f is queued
	  qsm.f();
	  //f is dequeued and processed: transition to s2b
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1S2().equals(QueuedSM_NestedStates_level2.Sm1S2.s2b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //g is triggered: g is queued
	  qsm.g();
	  // is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && (qsm.getSm1().equals(QueuedSM_NestedStates_level2.Sm1.s2) && qsm.getSm1S2().equals(QueuedSM_NestedStates_level2.Sm1S2.s2b))) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
		  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //m is triggered: m is queued
	  qsm.m();
	  //m is dequeued and processed: transition to s2b2
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1S2S2b().equals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b2) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b2, qsm.getSm1S2S2b());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  //m is triggered: m is queued
	  qsm.m();
	  //m is dequeued and processed: transition to s2b1
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1S2S2b().equals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b1) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
      assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b1, qsm.getSm1S2S2b());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	  

	  
	  //check that there is no events left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
  }
}