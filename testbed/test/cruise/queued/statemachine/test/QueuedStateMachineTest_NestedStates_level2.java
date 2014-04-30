package cruise.queued.statemachine.test;

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
    //initial state is s1
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    
    //g is triggered: g is queued
    qsm.g();
    Thread.sleep(10);
    //g is dequeued and processed: transition to s1a
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1a, qsm.getSm1S1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //e is triggered: e is queued
    qsm.e();
    Thread.sleep(10);
    //e is dequeued and processed: transition to s2
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //f is triggered: f is queued
    qsm.f();
    Thread.sleep(10);
    //f is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //j is triggered:j  is queued
    qsm.j();
    Thread.sleep(10);
    //j is dequeued and processed: transition to s1b
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S1.s1b, qsm.getSm1S1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    // i is triggered: i is queued
    qsm.i();
    Thread.sleep(10);
    //i is dequeued and processed: transition to s2b
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    // k is triggered: k is queued
    qsm.k();
    Thread.sleep(10);
    //k is dequeued and processed: transition to s1
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //e is triggered: e is queued
    qsm.e();
    Thread.sleep(10);
    //e is dequeued and processed: transition to s2
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s2, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //e is triggered: e is queued
    qsm.e();
    Thread.sleep(10);
    //e is dequeued and processed: transition to s1
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //h is triggered: h is queued
    qsm.h();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //m is triggered:m  is queued
    qsm.m();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //i is triggered: i is queued
    qsm.i();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //h is triggered: h is queued
    qsm.h();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //k is triggered: k is queued
    qsm.k();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1.s1, qsm.getSm1());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //f is triggered: f is queued
    qsm.f();
    Thread.sleep(10);
    //f is dequeued and processed: transition to s2b
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //g is triggered: g is queued
    qsm.g();
    Thread.sleep(10);
    // is dequeued and ignored (not processed: case of unspecified reception)
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2.s2b, qsm.getSm1S2());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //m is triggered: m is queued
    qsm.m();
    Thread.sleep(10);
    //m is dequeued and processed: transition to s2b2
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b2, qsm.getSm1S2S2b());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    //m is triggered: m is queued
    qsm.m();
    Thread.sleep(10);
    //m is dequeued and processed: transition to s2b1
    Assert.assertEquals(QueuedSM_NestedStates_level2.Sm1S2S2b.s2b1, qsm.getSm1S2S2b());
    // check if there is a message saved in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());    

    
    //check that there is no events left in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
    
  }
}