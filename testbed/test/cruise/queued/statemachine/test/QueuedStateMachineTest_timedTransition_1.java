package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;


public class QueuedStateMachineTest_timedTransition_1
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
    // compare the number of messages in MessageType is equal to the number of events in State Machine 
    Assert.assertEquals(4, QueuedSM_timedTransition_1.MessageType.values().length); 
  }
  
  @Test
  public void processEvents() throws InterruptedException
  {
	  QueuedSM_timedTransition_1 qsm = new QueuedSM_timedTransition_1();
	  int numChecks = 0;
	  // check initial state is s0
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s0, qsm.getSm());
	  Assert.assertEquals("running", qsm.getLog());
	  
	  //ev0 is triggered: ev0 is queued
	  qsm.ev0();	
	  //ev0 is dequeued and processed: transition to s1
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(QueuedSM_timedTransition_1.Sm.s1) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s1, qsm.getSm());
	  // check if there is a message saved in the queue
	  noMessageIsSaved(qsm);
	  
	  
	  //ev3 is triggered: ev3 is queued
	  qsm.ev3();
	  //ev3 is dequeued and ignored (not processed: case of unspecified reception)
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(QueuedSM_timedTransition_1.Sm.s1)) {
	    if(!qsm.queue.messages.isEmpty()){
	   	  Thread.sleep(5);
		  numChecks--;
		}
	    else
	    {
		  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s1, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
	    }
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s1, qsm.getSm());
	  // check if there is a message saved in the queue
	  noMessageIsSaved(qsm);

		
	  //waiting for 2 seconds before transition to s2
	  wait(3);
	  
	  //transition to s2
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s2, qsm.getSm()); 
      
	  //ev2 is triggered
	  qsm.ev2();	
	  //ev2 is dequeued and processed: transition to s3
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(QueuedSM_timedTransition_1.Sm.s3) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s3, qsm.getSm());
	  // check if there is a message saved in the queue
	  noMessageIsSaved(qsm);

	  //ev3 is triggered
	  qsm.ev3();	
	  //ev3 is dequeued and processed: transition to s4
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(QueuedSM_timedTransition_1.Sm.s4) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(QueuedSM_timedTransition_1.Sm.s4, qsm.getSm());
	  // check if there is a message saved in the queue
	  noMessageIsSaved(qsm);
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
      
  }
  
  public static void wait(int seconds)
  {
    try
    {
      Thread.sleep(seconds*1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }    
  }
  
  public void noMessageIsSaved(QueuedSM_timedTransition_1 qsm)
  {
	  if(!qsm.queue.messages.isEmpty())
	  {
		  Assert.assertEquals(false, qsm.queue.messages.isEmpty());
	  }
	  else
		  Assert.assertEquals(0, qsm.queue.messages.size());
  }
}