package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

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
  
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultipleQueuedSMs_nestedStates_EventlessSM qsm = new MultipleQueuedSMs_nestedStates_EventlessSM();
	  int numChecks;
	  
	  // check initial states are s1 - s21
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  
	  
	  //event e1 is called
	  qsm.e1();//event e1 is added to the queue
	  // event e1 is taken off the queue and is processed
	  // state machine sm: transition to: s1a 
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSmS1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e2 is called
	  qsm.e2();//event e2 is added to the queue
	  //event e2 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && !qsm.getSm().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e3 is called
	  qsm.e3();//event e3 is added to the queue
	  // event e3 is taken off the queue and is processed
	  // state machine sm1: transition to: s4 
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	 
	  //event e4 is called
	  qsm.e4();//event e4 is added to the queue
	  // event e4 is taken off the queue and is processed
	  // state machine sm1: transition to: s4 
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1a, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e5 is called
	  qsm.e5();//event e5 is added to the queue
	  //event e3 is called
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmS1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1b) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  qsm.e3();//event e3 is added to the queue
	  // event e5 is taken off the queue and is processed
	  // state machine smS1: transition to: s1b 
	  // event e3 is taken off the queue and is processed
	  // state machine smS1: transition to: s4 
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.s1b, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //event e6 is called
	  qsm.e6();//event e6 is added to the queue
	  // event e6 is taken off the queue and is processed
	  // state machine sm: transition to: s2 
	  // state machine smS1: transition to: Null 
	  numChecks=200; // we will check for a second
	  while((!qsm.getSm().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2) && !qsm.getSmS1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null)) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e3 is called
	  qsm.e3();//event e3 is added to the queue
	  //event e3 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e3 is called
	  qsm.e3();//event e3 is added to the queue
	  //event e3 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e4 is called
	  qsm.e4();//event e4 is added to the queue
	  // event e4 is taken off the queue and is processed
	  // state machine sm: transition to: s3 
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3) && numChecks>0) {
		Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e5 is called
	  qsm.e5();//event e5 is added to the queue
	  //event e5 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && !qsm.getSm().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s1)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
      Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //event e4 is called
	  qsm.e4();//event e4 is added to the queue
	  //event e4 is unspecified, it is ignored, current states are not changed
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && !qsm.getSm1().equals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s4)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
	      numChecks--;
		}
		else
		{
			Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
			Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
      Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm.s2, qsm.getSm());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.SmS1.Null, qsm.getSmS1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm1.s3, qsm.getSm1());
	  Assert.assertEquals(MultipleQueuedSMs_nestedStates_EventlessSM.Sm2.q, qsm.getSm2());
	  // queue is empty
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());	
  }
}