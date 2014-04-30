package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_timedEvent_autoTransition
{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
//	  Assert.assertEquals(2, X.MessageType.values().length);
//	  Assert.assertEquals(true, X.MessageType.valueOf("e1_M").equals(X.MessageType.e1_M));
//	  Assert.assertEquals(true, X.MessageType.valueOf("null_M").equals(X.MessageType.null_M));
//  }
//  
//  @Test 
//  public void numberOfKeysInstateMessageMap()
//  {
//	  // compare the number of states is equal to the number of keys in stateMessageMap
//	  Assert.assertEquals(X.Sm.values().length, X.stateMessageMap.keySet().size());
//	  Assert.assertEquals(3, X.stateMessageMap.keySet().size());
//  }
//  
//  @Test 
//  public void eachStateOfStateMachineAddedTostateMessageMap()
//  {
//	  //check that every state of SM it is put in stateMessageMap
//	  Assert.assertEquals(true, X.stateMessageMap.containsKey(X.Sm.s1));
//	  Assert.assertEquals(true, X.stateMessageMap.containsKey(X.Sm.s2));
//	  Assert.assertEquals(true, X.stateMessageMap.containsKey(X.Sm.s3));
//  }
//  
//  @Test 
//  public void everyStateHasListOfMessages()
//  {
//	  //check that every state has its list Of messages
//	  Assert.assertEquals(1, X.stateMessageMap.get(X.Sm.s1).size());
//	  Assert.assertEquals(1, X.stateMessageMap.get(X.Sm.s2).size());
//	  Assert.assertEquals(1, X.stateMessageMap.get(X.Sm.s3).size());
//	  Assert.assertEquals(true , X.stateMessageMap.get(X.Sm.s1).containsAll(X.stateMessageMap.get(X.Sm.s1)));
//	  Assert.assertEquals(true , X.stateMessageMap.get(X.Sm.s2).containsAll(X.stateMessageMap.get(X.Sm.s2)));
//	  Assert.assertEquals(true , X.stateMessageMap.get(X.Sm.s3).containsAll(X.stateMessageMap.get(X.Sm.s3)));
//  }
//  
//  @Test 
//  public void sizeOfstateMessageMap()
//  {
//	  //size of stateMessageMap which contains (state, list of MessageTypes)
//	  Assert.assertEquals(3, X.stateMessageMap.size());
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  X psm = new X();
//	  // check initial state is s1
//	  //auto-transition to state s2
//	  Assert.assertEquals(X.Sm.s2, psm.getSm());
//	  //wait for 3 seconds before transition to s3
//	  wait(4);
//	  
//	  Assert.assertEquals(X.Sm.s3, psm.getSm());
//	  
//	  //check that there is no event left in the queue
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//  }
//  
//  public static void wait(int seconds)
//  {
//    try
//    {
//      Thread.sleep(seconds*1000);
//    }
//    catch (InterruptedException e)
//    {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }    
//  }
//
}