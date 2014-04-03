package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_level1_1
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine ePooledSM_NestedState_L1_1cept timed events and auto-transition
	  Assert.assertEquals(7, PooledSM_NestedState_L1_1.MessageType.values().length);
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e1_M").equals(PooledSM_NestedState_L1_1.MessageType.e1_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e2_M").equals(PooledSM_NestedState_L1_1.MessageType.e2_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e3_M").equals(PooledSM_NestedState_L1_1.MessageType.e3_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e4_M").equals(PooledSM_NestedState_L1_1.MessageType.e4_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e5_M").equals(PooledSM_NestedState_L1_1.MessageType.e5_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("e6_M").equals(PooledSM_NestedState_L1_1.MessageType.e6_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L1_1.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((PooledSM_NestedState_L1_1.SmS2.values().length+PooledSM_NestedState_L1_1.Sm.values().length+PooledSM_NestedState_L1_1.SmS1.values().length), PooledSM_NestedState_L1_1.stateMessageMap.keySet().size());
	  Assert.assertEquals(8, PooledSM_NestedState_L1_1.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.Sm.s1));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.Sm.s2));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS1.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS1.s1a));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS1.s1b));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS2.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS2.s2a));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_1.stateMessageMap.containsKey(PooledSM_NestedState_L1_1.SmS2.s2b));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s1).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s2).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1a).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1b).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2a).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2b).size());
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s1).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s1)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s2).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.Sm.s2)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.Null).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1a).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1b).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS1.s1b)));
      Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.Null).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2a).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2b).containsAll(PooledSM_NestedState_L1_1.stateMessageMap.get(PooledSM_NestedState_L1_1.SmS2.s2b)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(8, PooledSM_NestedState_L1_1.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  PooledSM_NestedState_L1_1 psm = new PooledSM_NestedState_L1_1();
	  // check initial state is s1
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	 
	  psm.e1();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.e2();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1b, psm.getSmS1());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.e3();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.e2();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e2_M, msg.type);
      }
	  
	  psm.e6();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  Assert.assertEquals(2, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e6_M))
		  {
		    Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e6_M, msg.type);
		  }
      }
	  
	  psm.e5();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS2.s2a, psm.getSmS2());
	  Assert.assertEquals(1, psm.pool.messages.size());	  
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e2_M, msg.type);
      }
	  
	  psm.e4();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1b, psm.getSmS1());
	  Assert.assertEquals(0, psm.pool.messages.size());	  
	  
	  psm.e1();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(0, psm.pool.messages.size());	  

	  psm.e3();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e3_M, msg.type);
      }
	  
	  psm.e5();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(2, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e5_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e5_M, msg.type);
		  }
      }
	  
	  psm.e3();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(3, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e3_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e3_M, msg.type);
		  }
      }

	  psm.e4();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(4, psm.pool.messages.size());
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e4_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e4_M, msg.type);
		  }
      }
	  
	  psm.e2();
	  Thread.sleep(10);
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
	  
	  //check that there are two events left in the queue
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
  }
}