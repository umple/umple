package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_NestedStates_level1_2
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(10, PooledSM_NestedState_L1_2.MessageType.values().length);
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e1_M").equals(PooledSM_NestedState_L1_2.MessageType.e1_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e2_M").equals(PooledSM_NestedState_L1_2.MessageType.e2_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e3_M").equals(PooledSM_NestedState_L1_2.MessageType.e3_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e4_M").equals(PooledSM_NestedState_L1_2.MessageType.e4_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e5_M").equals(PooledSM_NestedState_L1_2.MessageType.e5_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e6_M").equals(PooledSM_NestedState_L1_2.MessageType.e6_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e7_M").equals(PooledSM_NestedState_L1_2.MessageType.e7_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e8_M").equals(PooledSM_NestedState_L1_2.MessageType.e8_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e9_M").equals(PooledSM_NestedState_L1_2.MessageType.e9_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L1_2.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((PooledSM_NestedState_L1_2.SmS2.values().length+PooledSM_NestedState_L1_2.Sm.values().length+PooledSM_NestedState_L1_2.SmS1.values().length+PooledSM_NestedState_L1_2.SmS3.values().length), PooledSM_NestedState_L1_2.stateMessageMap.keySet().size());
	  Assert.assertEquals(12, PooledSM_NestedState_L1_2.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.Sm.s1));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.Sm.s2));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.s1a));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.s1b));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.s2a));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.s2b));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.s3a));
	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.s3b));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b).size());
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b)));
      Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(12, PooledSM_NestedState_L1_2.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  PooledSM_NestedState_L1_2 psm = new PooledSM_NestedState_L1_2();
	  // check initial state is s1
	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
	 
	  psm.e1();// event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed: transition to state s1a
	  // Now, the pool is empty
	  psm.e2();// event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b
	  // Now, the pool is empty
	  psm.e1();// event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed: transition to state s1a
	  // Now, the pool is empty
	  psm.e2();// event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b
	  // Now, the pool is empty
	  psm.e3();// event e3 is called and is added to the pool
	  // event e3 is taken off the pool and is processed: transition to state s2
	  // Now, the pool is empty
	  psm.e8();// event e8 is called and is added to the pool
	  // event e8 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e8 event saved at its head
	  // The size of pool is 1: e8
	  psm.e9();// event e9 is called and is added to the pool
	  // event e9 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e8, and e9 events saved at its head
	  // The size of pool is 2: e8 and e9
	  psm.e5();// event e5 is called and is added to the pool
	  // event e5 is taken off the pool and is processed: transition to state s2b
	  // The pool has e8, and e9 events saved at its head
	  // The size of pool is 2: e8 and e9
	  psm.e6();// event e6 is called and is added to the pool
	  // event e6 is taken off the pool and is processed: transition to state s3
	  // event e8 is taken off the pool and is processed: transition to state s1b
	  // event e9 is taken off the pool and is processed: transition to state s3a
	  // Now, the pool is empty
	  psm.e4();// event e4 is called and is added to the pool
	  // event e4 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e4 event saved at its head
	  // The size of pool is 1: e4
	  psm.e2();// event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b
	  // The pool has e4 event saved at its head
	  // The size of pool is 1: e4
	  psm.e7();// event e7 is called and is added to the pool
	  // event e7 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e4, and e7 events saved at its head
	  // The size of pool is 2: e4 and e7
	  psm.e1();// event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed: transition to state s1a
	  // The pool has e4, and e7 events saved at its head
	  // The size of pool is 2: e4 and e7
	  psm.e2();// event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b
	  // The pool has e4, and e7 events saved at its head
	  // The size of pool is 2: e4 and e7
	  psm.e6();// event e6 is called and is added to the pool
	  // event e6 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e4,e7, and e6 events saved at its head
	  // The size of pool is 3: e4, e7 and e6
	  psm.e7();// event e7 is called and is added to the pool
	  // event e7 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e4,e7,e6, and e7 events saved at its head
	  // The size of pool is 4: e4, e7, e6 and e7
	  psm.e9();// event e9 is called and is added to the pool
	  // event e9 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e4,e7,e6,e7, and e9 events saved at its head
	  // The size of pool is 5: e4, e7, e6, e7 and e9
	  psm.e3();// event e3 is called and is added to the pool
	  // event e3 is taken off the pool and is processed: transition to state s2
	  // event e4 is taken off the pool and is processed: transition to state s1
	  // The pool has e7,e6,e7, and e9 events saved at its head
	  // The size of pool is 4: e7, e6, e7 and e9
	  psm.e8();// event e8 is called and is added to the pool
	  // event e8 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e7,e6,e7,e9, and e8 event saved at its head
	  // The size of pool is 5: e7, e6, e7, e9 and e8
	  psm.e3();// event e3 is called and is added to the pool
	  // event e3 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e7,e6,e7,e9,e8, and e3 events saved at its head
	  // The size of pool is 6: e7, e6, e7, e9, e8 and e3
	  psm.e5();// event e5 is called and is added to the pool
	  // event e5 is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has e7,e6,e7,e9,e8,e3, and e5 events saved at its head
	  // The size of pool is 7: e7, e6, e7, e9, e8, e3 and e5
	  psm.e2();// event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed: transition to state s1b
	  // event e3 is taken off the pool and is processed: transition to state s2
	  // event e5 is taken off the pool and is processed: transition to state s2b
	  // event e6 is taken off the pool and is processed: transition to state s3
	  // event e7 is taken off the pool and is processed: transition to state s2
	  // The pool has e7,e9, and e8 events saved at its head
	  // The size of pool is 3: e7, e9 and e8

	  // Check that the pool has 3 events
	  while(psm.pool.messages.size() != 3)
	  {
		  Thread.sleep(10);
	  }
	  
	  // There are 'e7', 'e9' and 'e8' left in the pool
	  PooledSM_NestedState_L1_2.Message msg1=null;
	  PooledSM_NestedState_L1_2.Message msg2=null;
	  PooledSM_NestedState_L1_2.Message msg3=null;	  
	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e7_M)){
			  msg1 = msg;
		  }
		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e9_M)){
			  msg2 = msg;
		  }
		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e8_M)){
			  msg3 = msg;
		  }
      }	  
	  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e7_M, msg1.type);
	  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e9_M, msg2.type);
	  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e8_M, msg3.type);
	  
	  // The size of pool is 1
	  Assert.assertEquals(3, psm.pool.messages.size());
	  
	  // Check the current state is s2 and the current substate is s2a
	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS2.s2a, psm.getSmS2());

  }
}