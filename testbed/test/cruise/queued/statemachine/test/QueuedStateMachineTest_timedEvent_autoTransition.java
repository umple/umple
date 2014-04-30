package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;


public class QueuedStateMachineTest_timedEvent_autoTransition
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
    // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
    Assert.assertEquals(1, QueuedSM_autoTransition_timedEvent.MessageType.values().length);
    Assert.assertEquals(true, QueuedSM_autoTransition_timedEvent.MessageType.valueOf("e1_M").equals(QueuedSM_autoTransition_timedEvent.MessageType.e1_M));
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
    QueuedSM_autoTransition_timedEvent qsm = new QueuedSM_autoTransition_timedEvent();
    // check initial state is s1
    //auto-transition to state s2
    Assert.assertEquals(QueuedSM_autoTransition_timedEvent.Sm.s2, qsm.getSm());
    //wait for 2 seconds before transition to s3
    wait(3);
      
    Assert.assertEquals(QueuedSM_autoTransition_timedEvent.Sm.s3, qsm.getSm());
      
    //check that there is no event left in the queue
    Assert.assertEquals(0, qsm.pool.messages.size());
      
  }
    
  public static void wait(int seconds)
  {
    try
    {
      Thread.sleep(seconds*1000);
    }
    catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
  }
}