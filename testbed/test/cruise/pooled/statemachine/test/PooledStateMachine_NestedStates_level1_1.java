package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_NestedStates_level1_1
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

	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed: transition to state s1a 
	  // Now, the pool is empty
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  // Now, the pool is empty
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is taken off the pool and is processed: transition to state s2 
	  // Now, the pool is empty
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e2 event saved at its head
	  // The size of pool is 1: e2 
	  psm.e6();//event e6 is called and is added to the pool
	  // event e6 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e2, and e6 events saved at its head
	  // The size of pool is 2: e2 and e6
	  psm.e5();//event e5 is called and is added to the pool
	  // event e5 is taken off the pool and is processed: transition to state s2b 
	  // event e6 is taken off the pool and is processed: transition to state s2a 
	  // The pool has e2 event saved at its head
	  // The size of pool is 1: e2 
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed: transition to state s1 
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  // Now, the pool is empty
	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed: transition to state s1a 
	  // Now, the pool is empty
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e3 event saved at its head
	  // The size of pool is 1: e3 
	  psm.e5();//event e5 is called and is added to the pool
	  // event e5 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e3, and e5 events saved at its head
	  // The size of pool is 2: e3 and e5 
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e3,e5, and e3 events saved at its head
	  // The size of pool is 3: e3, e5, and e3
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e3,e5,e3, and e4 events saved at its head
	  // The size of pool is 4: e3, e5, e3 and e4 
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  // event e3 is taken off the pool and is processed: transition to state s2 
	  // event e5 is taken off the pool and is processed: transition to state s2b
	  // event e4 is taken off the pool and is processed: transition to state s1 
	  // The pool has e3 event saved at its head
	  // The size of pool is 1: e3 

	  // Check that the pool has only one event
	  while(psm.pool.messages.size() != 1)
	  {
		  Thread.sleep(10);
	  }
	  
	  // There is only one event 'e3' left in the pool
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e3_M, msg.type);
      }
	  
	  // The size of pool is 1
	  Assert.assertEquals(1, psm.pool.messages.size());

	  
	  // Check the current state is s1 and the current substate is s1a
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1a, psm.getSmS1());
	  
  }
}