package cruise.queued.statemachine.test;

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
    //initial state is idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    
    //cardInserted is triggered: cardInserted is queued
    qsm.cardInserted();
    Thread.sleep(10);
    //cardInserted is dequeued and processed: transition to active
    Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
    Assert.assertEquals("Card is read", qsm.getLog(0));
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
    
    
    //validated is triggered: validated is queued
    qsm.validated();
    Thread.sleep(10);
    //validated is dequeued and processed: transition to selecting
    Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
      
    //select is triggered: select is queued
    qsm.select();
    Thread.sleep(10);
    //select is dequeued and processed: transition to processing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //finish is triggered: finish is queued
    qsm.finish();
    Thread.sleep(10);
    //finish is dequeued and processed: transition to printing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.printing, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //receiptPrinted is triggered: receiptPrinted is queued
    qsm.receiptPrinted();
    Thread.sleep(10);
    //receiptPrinted is dequeued and processed: transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //selectAnotherTransiction is triggered: selectAnotherTransiction is queued
    qsm.selectAnotherTransiction();
    Thread.sleep(10);
    //selectAnotherTransiction is dequeued: it is unspecified, unspecified method is called to handle this error
    //transition to error1
    //auto-transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //maintain is triggered: maintain is queued
    qsm.maintain();
    Thread.sleep(10);
    //maintain is dequeued and processed: transition to maintenance
    Assert.assertEquals(AutomatedTellerMachine.Sm.maintenance, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //isMaintained is triggered: isMaintained is queued
    qsm.isMaintained();
    Thread.sleep(10);
    //isMaintained is dequeued and processed: transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //cancel is triggered: cancel is queued
    qsm.cancel();
    Thread.sleep(10);
    //cancel is dequeued: it is unspecified, unspecified method is called to handle this error
    //transition to error1
    //auto-transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //cardInserted is triggered: cardInserted is queued
    qsm.cardInserted();
    Thread.sleep(10);
    //cardInserted is dequeued and processed: transition to active
    Assert.assertEquals(AutomatedTellerMachine.Sm.active, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //select is triggered: select is queued
    qsm.select();
    Thread.sleep(10);
    //select is dequeued: it is unspecified, unspecified method is called to handle this error
    //transition to error2
    //auto-transition to validating
    Assert.assertEquals(AutomatedTellerMachine.SmActive.validating, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //validated is triggered: validated is queued
    qsm.validated();
    Thread.sleep(10);
    //validated is dequeued and processed: transition to selecting
    Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
      
    //select is triggered: select is queued
    qsm.select();
    Thread.sleep(10);
    //select is dequeued and processed: transition to processing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //selectAnotherTransiction is triggered: selectAnotherTransiction is queued
    qsm.selectAnotherTransiction();
    Thread.sleep(10);
    //selectAnotherTransiction is dequeued and processed: transition to processing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.selecting, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //select is triggered: select is queued
    qsm.select();
    Thread.sleep(10);
    //select is dequeued and processed: transition to processing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.processing, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //finish is triggered: finish is queued
    qsm.finish();
    Thread.sleep(10);
    //finish is dequeued and processed: transition to printing
    Assert.assertEquals(AutomatedTellerMachine.SmActive.printing, qsm.getSmActive());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //receiptPrinted is triggered: receiptPrinted is queued
    qsm.receiptPrinted();
    Thread.sleep(10);
    //receiptPrinted is dequeued and processed: transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());

    //finish is triggered: finish is queued
    qsm.finish();
    Thread.sleep(10);
    //finish is dequeued: it is unspecified, unspecified method is called to handle this error
    //transition to error1
    //auto-transition to idle
    Assert.assertEquals(AutomatedTellerMachine.Sm.idle, qsm.getSm());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
    
    //check that there is no events left in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
    
  }
}