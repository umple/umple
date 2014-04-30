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
	 
	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  Thread.sleep(10);
	  // event e1 is taken off the pool and is processed: transition to state s1a 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1a, psm.getSmS1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the pool
	  Thread.sleep(10);
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1b, psm.getSmS1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e3 is called
	  psm.e3();//event e3 is added to the pool
	  Thread.sleep(10);
	  // event e3 is taken off the pool and is processed: transition to state s2 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the pool
	  Thread.sleep(10);
	  //event e2 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  //the pool has e2 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event e2 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e2_M, msg.type);
      }
	  
	  //event e6 is called
	  psm.e6();//event e6 is added to the pool
	  Thread.sleep(10);
	  //event e6 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s2, psm.getSm());
	  //the pool has e2,e6 event saved at its head
	  Assert.assertEquals(2, psm.pool.messages.size());
	  //check the pool to see if event e6 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e6_M))
		  {
		    Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e6_M, msg.type);
		  }
      }
	  
	  //event e5 is called
	  psm.e5();//event e5 is added to the pool
	  Thread.sleep(10);
	  // event e5 is taken off the pool and is processed: transition to state s2b 
	  // event e6 is taken off the pool and is processed: transition to state s2a 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS2.s2a, psm.getSmS2());
	  //the pool has e2 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());	  
	  //check the pool to see if event e2 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e2_M, msg.type);
      }
	  
	  //event e4 is called
	  psm.e4();//event e4 is added to the pool
	  Thread.sleep(10);
	  // event e4 is taken off the pool and is processed: transition to state s1 
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1b, psm.getSmS1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());	  
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  Thread.sleep(10);
	  // event e1 is taken off the pool and is processed: transition to state s1a 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.SmS1.s1a, psm.getSmS1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());	  

	  //event e3 is called
	  psm.e3();//event e3 is added to the pool
	  Thread.sleep(10);
	  //event e3 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  //the pool has e3 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event e3 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e3_M, msg.type);
      }
	  
	  //event e5 is called
	  psm.e5();//event e5 is added to the pool
	  Thread.sleep(10);
	  //event e5 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  //the pool has e3,e5 event saved at its head
	  Assert.assertEquals(2, psm.pool.messages.size());
	  //check the pool to see if event e5 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e5_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e5_M, msg.type);
		  }
      }
	  
	  //event e3 is called
	  psm.e3();//event e3 is added to the pool
	  Thread.sleep(10);
	  //event e3 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  //the pool has e3,e5,e3 event saved at its head
	  Assert.assertEquals(3, psm.pool.messages.size());
	  //check the pool to see if event e3 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e3_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e3_M, msg.type);
		  }
      }

	  //event e4 is called
	  psm.e4();//event e4 is added to the pool
	  Thread.sleep(10);
	  //event e4 is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  //the pool has e3,e5,e3,e4 event saved at its head
	  Assert.assertEquals(4, psm.pool.messages.size());
	  //check the pool to see if event e4 is saved in it
	  for (PooledSM_NestedState_L1_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_NestedState_L1_1.MessageType.e4_M))
		  {
			  Assert.assertEquals(PooledSM_NestedState_L1_1.MessageType.e4_M, msg.type);
		  }
      }
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the pool
	  Thread.sleep(10);
	  // event e2 is taken off the pool and is processed: transition to state s1b 
	  // event e3 is taken off the pool and is processed: transition to state s2 
	  // event e5 is taken off the pool and is processed: transition to state s2b
	  // event e4 is taken off the pool and is processed: transition to state s1 
	  Assert.assertEquals(PooledSM_NestedState_L1_1.Sm.s1, psm.getSm());
	  //the pool has e3 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
	  //check that there is one event left in the queue
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
  }
}