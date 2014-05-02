package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class QueuedStateMachineTest
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(2, QueuedSM.MessageType.values().length);
	  Assert.assertEquals(true, QueuedSM.MessageType.valueOf("e1_M").equals(QueuedSM.MessageType.e1_M));
	  Assert.assertEquals(true, QueuedSM.MessageType.valueOf("e2_M").equals(QueuedSM.MessageType.e2_M));  
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
    QueuedSM qsm = new QueuedSM();
    int numChecks;
	//initial state is s1
	Assert.assertEquals(QueuedSM.Sm.s1, qsm.getSm());
	  
	//e1 is triggered: e1 is queued
	qsm.e1();	
	//e1 is dequeued and processed: transition to s2
	numChecks=200; // we will check for a second
	while(!qsm.getSm().equals(QueuedSM.Sm.s2) && numChecks>0) {
	  Thread.sleep(5);
      numChecks--;
	}
	assertThat(numChecks, not(equalTo(0)));
	Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
    // check if there is a message saved in the queue
    noMessageIsSaved(qsm);
	
    
    //e2 is triggered: e2 is queued
	qsm.e2();
	//e2 is dequeued and processed: transition to s2
	numChecks=200; // we will check for a second
	while(numChecks>0 && qsm.getSm().equals(QueuedSM.Sm.s2)) {
	  if(!qsm.queue.messages.isEmpty()){
	    Thread.sleep(5);
		numChecks--;
	  }
      else
	  {
	    Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
		Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		break;
	  }
	}
	assertThat(numChecks, not(equalTo(0)));
	Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
	// check if there is a message saved in the queue
	noMessageIsSaved(qsm);
  
	
	//e2 is triggered: e2 is queued
	qsm.e2();
	//e2 is dequeued and processed: transition to s2
	numChecks=200; // we will check for a second
    while(numChecks>0 && qsm.getSm().equals(QueuedSM.Sm.s2)) {
	  if(!qsm.queue.messages.isEmpty()){
	    Thread.sleep(5);
		numChecks--;
	  }
	  else
	  {
		Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
		Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		break;
	  }
    }
    assertThat(numChecks, not(equalTo(0)));
	Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());	
	// check if there is a message saved in the queue
	noMessageIsSaved(qsm);
	
	
	//e1 is triggered: e1 is queued
	qsm.e1();
	//e1 is dequeued and ignored (not processed: case of unspecified reception)
	numChecks=200; // we will check for a second
	while(numChecks>0 && qsm.getSm().equals(QueuedSM.Sm.s2)) {
	  if(!qsm.queue.messages.isEmpty()){
		Thread.sleep(5);
		numChecks--;
	  }
	  else
	  {
		Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
		Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		break;
	  }
    }
    assertThat(numChecks, not(equalTo(0)));
	Assert.assertEquals(QueuedSM.Sm.s2, qsm.getSm());
	// check if there is a message saved in the queue
	noMessageIsSaved(qsm);
	  
	//check that there is no events left in the queue
	Assert.assertEquals(0, qsm.queue.messages.size());	  
  }
  
  
  public void noMessageIsSaved(QueuedSM qsm)
  {
	  if(!qsm.queue.messages.isEmpty())
	  {
		  Assert.assertEquals(false, qsm.queue.messages.isEmpty());
	  }
	  else
		  Assert.assertEquals(0, qsm.queue.messages.size());
  }
}