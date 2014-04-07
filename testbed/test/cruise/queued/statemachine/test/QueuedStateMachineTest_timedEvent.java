package cruise.queued.statemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;


public class QueuedStateMachineTest_timedEvent
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
    // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
    Assert.assertEquals(0, QueuedSM_timedEvent.MessageType.values().length); 
  }
  
  @Ignore @Test
  // Test ignored for now as it is nondeterministic - the waiting times are
  // not guaranteed. Test needs replacing
  public void processEvents() throws InterruptedException
  {
    QueuedSM_timedEvent qsm = new QueuedSM_timedEvent();
    // check initial state is s1
    Assert.assertEquals(QueuedSM_timedEvent.Status.s1, qsm.getStatus());
    Assert.assertEquals(3, qsm.getTimer());
    //waiting for 2 seconds before transition to s2
    wait(3);
      
    //transition to s2
    Assert.assertEquals(QueuedSM_timedEvent.Status.s2, qsm.getStatus()); 
      
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
      e.printStackTrace();
    }    
  }
}