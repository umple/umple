package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_UnspecifiedReception
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine ePooledSMwithUnspecifiedReceptioncept timed events and auto-transition
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.MessageType.values().length);
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("e1_M").equals(PooledSMwithUnspecifiedReception.MessageType.e1_M));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("unspecified_M").equals(PooledSMwithUnspecifiedReception.MessageType.unspecified_M));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("null_M").equals(PooledSMwithUnspecifiedReception.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.values().length, PooledSMwithUnspecifiedReception.stateMessageMap.keySet().size());
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.s1));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.s2));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.error1));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(2, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1).size());
	  Assert.assertEquals(1, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2).size());
	  Assert.assertEquals(1, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1).size());
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1)));
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2)));
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  PooledSMwithUnspecifiedReception psm = new PooledSMwithUnspecifiedReception();
	  // check initial state is s1
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s1, psm.getSm());
	  
	  
	  psm.unspecified();
	  Thread.sleep(10);
	  
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s1, psm.getSm());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.e1();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s2, psm.getSm());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //check that there are two events left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
  }
  


}