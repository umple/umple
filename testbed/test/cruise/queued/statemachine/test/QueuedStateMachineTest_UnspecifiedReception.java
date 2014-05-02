package cruise.queued.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;


public class QueuedStateMachineTest_UnspecifiedReception
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
      // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(9, AutomatedTellerMachine.MessageType.values().length);
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("cardInserted_M").equals(AutomatedTellerMachine.MessageType.cardInserted_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("maintain_M").equals(AutomatedTellerMachine.MessageType.maintain_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("isMaintained_M").equals(AutomatedTellerMachine.MessageType.isMaintained_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("cancel_M").equals(AutomatedTellerMachine.MessageType.cancel_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("validated_M").equals(AutomatedTellerMachine.MessageType.validated_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("select_M").equals(AutomatedTellerMachine.MessageType.select_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("selectAnotherTransiction_M").equals(AutomatedTellerMachine.MessageType.selectAnotherTransiction_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("finish_M").equals(AutomatedTellerMachine.MessageType.finish_M));
	  Assert.assertEquals(true, AutomatedTellerMachine.MessageType.valueOf("receiptPrinted_M").equals(AutomatedTellerMachine.MessageType.receiptPrinted_M));
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  AutomatedTellerMachine qsm = new AutomatedTellerMachine();
      int numChecks;
	  //initial state is idle
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());

	  //cardInserted is triggered: cardInserted is queued
	  qsm.cardInserted();
	  //cardInserted is dequeued and processed: transition to active
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.active) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  Assert.assertEquals("Card is read", qsm.getLog(0));
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  
	  //validated is triggered: validated is queued
	  qsm.validated();
	  //validated is dequeued and processed: transition to selecting
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.selecting) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	    
	  //select is triggered: select is queued
	  qsm.select();
	  //select is dequeued and processed: transition to processing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.processing) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //finish is triggered: finish is queued
	  qsm.finish();
	  //finish is dequeued and processed: transition to printing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.printing) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.printing, qsm.getSmActive());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //receiptPrinted is triggered: receiptPrinted is queued
	  qsm.receiptPrinted();
	  //receiptPrinted is dequeued and processed: transition to idle
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.idle) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //selectAnotherTransiction is triggered: selectAnotherTransiction is queued
	  qsm.selectAnotherTransiction();
	  //selectAnotherTransiction is dequeued: it is unspecified, unspecified method is called to handle this error
	  //transition to error1
	  //auto-transition to idle
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(AutomatedTellerMachine.Sm.idle)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
		  numChecks--;
		}
	    else
	    {
		  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
		}
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //maintain is triggered: maintain is queued
	  qsm.maintain();
	  //maintain is dequeued and processed: transition to maintenance
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.maintenance) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.maintenance, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //isMaintained is triggered: isMaintained is queued
	  qsm.isMaintained();
	  //isMaintained is dequeued and processed: transition to idle
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.idle) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //cancel is triggered: cancel is queued
	  qsm.cancel();
	  //cancel is dequeued: it is unspecified, unspecified method is called to handle this error
	  //transition to error1
	  //auto-transition to idle
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(AutomatedTellerMachine.Sm.idle)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
		  numChecks--;
		}
	    else
	    {
		  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
		}
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //cardInserted is triggered: cardInserted is queued
	  qsm.cardInserted();
	  //cardInserted is dequeued and processed: transition to active
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.active) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //select is triggered: select is queued
	  qsm.select();
	  Thread.sleep(10);
	  //select is dequeued: it is unspecified, unspecified method is called to handle this error
	  //transition to error2
	  //auto-transition to validating
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.validating) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.validating, qsm.getSmActive());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //validated is triggered: validated is queued
	  qsm.validated();
	  //validated is dequeued and processed: transition to selecting
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.selecting) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	    
	  //select is triggered: select is queued
	  qsm.select();
	  //select is dequeued and processed: transition to processing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.processing) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //selectAnotherTransiction is triggered: selectAnotherTransiction is queued
	  qsm.selectAnotherTransiction();
	  //selectAnotherTransiction is dequeued and processed: transition to processing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.selecting) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //select is triggered: select is queued
	  qsm.select();
	  //select is dequeued and processed: transition to processing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.processing) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //finish is triggered: finish is queued
	  qsm.finish();
	  //finish is dequeued and processed: transition to printing
	  numChecks=200; // we will check for a second
	  while(!qsm.getSmActive().equals(AutomatedTellerMachine.SmActive.printing) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.SmActive.printing, qsm.getSmActive());
	  Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //receiptPrinted is triggered: receiptPrinted is queued
	  qsm.receiptPrinted();
	  //receiptPrinted is dequeued and processed: transition to idle
	  numChecks=200; // we will check for a second
	  while(!qsm.getSm().equals(AutomatedTellerMachine.Sm.idle) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());

	  //finish is triggered: finish is queued
	  qsm.finish();
	  //finish is dequeued: it is unspecified, unspecified method is called to handle this error
	  //transition to error1
	  //auto-transition to idle
	  numChecks=200; // we will check for a second
	  while(numChecks>0 && qsm.getSm().equals(AutomatedTellerMachine.Sm.idle)) {
		if(!qsm.queue.messages.isEmpty()){
		  Thread.sleep(5);
		  numChecks--;
		}
	    else
	    {
		  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
		  Assert.assertEquals(true, qsm.queue.messages.isEmpty());
		  break;
		}
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
	  // check if there is a message saved in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
	  //check that there is no events left in the queue
	  Assert.assertEquals(0, qsm.queue.messages.size());
	  
  }
}