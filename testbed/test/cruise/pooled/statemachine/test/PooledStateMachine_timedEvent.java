package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_timedEvent
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(2, Mentor.MessageType.values().length);
	  Assert.assertEquals(true, Mentor.MessageType.valueOf("null_M").equals(Mentor.MessageType.null_M));
	  Assert.assertEquals(true, Mentor.MessageType.valueOf("timeoutOkToNotOk_M").equals(Mentor.MessageType.timeoutOkToNotOk_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals(Mentor.Status.values().length, Mentor.stateMessageMap.keySet().size());
	  Assert.assertEquals(2, Mentor.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, Mentor.stateMessageMap.containsKey(Mentor.Status.Ok));
	  Assert.assertEquals(true, Mentor.stateMessageMap.containsKey(Mentor.Status.NotOk));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, Mentor.stateMessageMap.get(Mentor.Status.Ok).size());
	  Assert.assertEquals(1, Mentor.stateMessageMap.get(Mentor.Status.NotOk).size());
	  Assert.assertEquals(true , Mentor.stateMessageMap.get(Mentor.Status.Ok).containsAll(Mentor.stateMessageMap.get(Mentor.Status.Ok)));
	  Assert.assertEquals(true , Mentor.stateMessageMap.get(Mentor.Status.NotOk).containsAll(Mentor.stateMessageMap.get(Mentor.Status.NotOk)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(2, Mentor.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  Mentor psm = new Mentor();
	  // check initial state is Ok
	  Assert.assertEquals(Mentor.Status.Ok, psm.getStatus());
	  //waiting for 2 seconds before transition to NotOk
	  wait(3);
	  
	  //transition to NotOk
	  Assert.assertEquals(Mentor.Status.NotOk, psm.getStatus());

	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
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