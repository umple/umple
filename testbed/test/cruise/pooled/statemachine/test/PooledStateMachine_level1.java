package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_level1
{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine ePooledSM_NestedState_L1cept timed events and auto-transition
//	  Assert.assertEquals(6, PooledSM_NestedState_L1.MessageType.values().length);
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("e1_M").equals(PooledSM_NestedState_L1.MessageType.e1_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("e2_M").equals(PooledSM_NestedState_L1.MessageType.e2_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("e3_M").equals(PooledSM_NestedState_L1.MessageType.e3_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("e4_M").equals(PooledSM_NestedState_L1.MessageType.e4_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("e5_M").equals(PooledSM_NestedState_L1.MessageType.e5_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L1.MessageType.null_M));
//  }
//  
//  @Test 
//  public void numberOfKeysInstateMessageMap()
//  {
//	  // compare the number of states is equal to the number of keys in stateMessageMap
//	  Assert.assertEquals((PooledSM_NestedState_L1.SmS2.values().length+PooledSM_NestedState_L1.Sm.values().length), PooledSM_NestedState_L1.stateMessageMap.keySet().size());
//	  Assert.assertEquals(5, PooledSM_NestedState_L1.stateMessageMap.keySet().size());
//  }
//  
//  @Test 
//  public void eachStateOfStateMachineAddedTostateMessageMap()
//  {
//	  //check that every state of SM it is put in stateMessageMap
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.stateMessageMap.containsKey(PooledSM_NestedState_L1.Sm.s1));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.stateMessageMap.containsKey(PooledSM_NestedState_L1.Sm.s2));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.stateMessageMap.containsKey(PooledSM_NestedState_L1.SmS2.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.stateMessageMap.containsKey(PooledSM_NestedState_L1.SmS2.s2a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1.stateMessageMap.containsKey(PooledSM_NestedState_L1.SmS2.s2b));
//  }
//  
//  @Test 
//  public void everyStateHasListOfMessages()
//  {
//	  //check that every state has its list Of messages
//	  Assert.assertEquals(2, PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s1).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s2).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.Null).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2a).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2b).size());
//	  Assert.assertEquals(true , PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s1).containsAll(PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s1)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s2).containsAll(PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.Sm.s2)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.Null).containsAll(PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2a).containsAll(PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2b).containsAll(PooledSM_NestedState_L1.stateMessageMap.get(PooledSM_NestedState_L1.SmS2.s2b)));
//  }
//  
//  @Test 
//  public void sizeOfstateMessageMap()
//  {
//	  //size of stateMessageMap which contains (state, list of MessageTypes)
//	  Assert.assertEquals(5, PooledSM_NestedState_L1.stateMessageMap.size());
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  PooledSM_NestedState_L1 psm = new PooledSM_NestedState_L1();
//	  // check initial state is s1
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s1, psm.getSm());
//	  
//	  psm.e1();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s2, psm.getSm());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  psm.e3();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s1, psm.getSm());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  psm.e2();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2b, psm.getSmS2());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  psm.e1();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2b, psm.getSmS2());
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e1_M, msg.type);
//      }
//	  
//	  psm.e5();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2a, psm.getSmS2());
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  
//	  psm.e2();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2a, psm.getSmS2());
//	  Assert.assertEquals(2, psm.pool.messages.size());	  
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1.MessageType.e2_M))
//		  {
//		    Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e2_M, msg.type);
//		  }
//      }
//	  
//	  psm.e3();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s2, psm.getSm());
//	  Assert.assertEquals(1, psm.pool.messages.size());	  
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e2_M, msg.type);
//      }
//	  
//	  psm.e5();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s2, psm.getSm());
//	  Assert.assertEquals(2, psm.pool.messages.size());	  
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1.MessageType.e5_M))
//		  {
//		    Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e5_M, msg.type);
//		  }
//      }
//	  
//	  psm.e4();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2a, psm.getSmS2());
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e2_M, msg.type);
//      }
//	  
//	  psm.e3();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2b, psm.getSmS2());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  psm.e5();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2a, psm.getSmS2());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  psm.e1();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.SmS2.s2a, psm.getSmS2());
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  for (PooledSM_NestedState_L1.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1.MessageType.e1_M, msg.type);
//      }
//	  
//	  psm.e3();
//	  Thread.sleep(10);
//	  Assert.assertEquals(PooledSM_NestedState_L1.Sm.s2, psm.getSm());
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  
//	  //check that there are two events left in the queue
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//  }
}