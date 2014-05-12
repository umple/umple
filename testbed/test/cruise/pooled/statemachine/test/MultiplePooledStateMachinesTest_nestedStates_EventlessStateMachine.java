package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class MultiplePooledStateMachinesTest_nestedStates_EventlessStateMachine
{ 

  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(7, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.values().length);
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e1_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e1_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e2_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e2_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e3_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e3_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e4_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e4_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e5_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e5_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("e6_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.e6_M));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.MessageType.valueOf("null_M").equals(MultiplePooledSMs_nestedStates_EventlessSM.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((MultiplePooledSMs_nestedStates_EventlessSM.Sm.values().length+MultiplePooledSMs_nestedStates_EventlessSM.Sm1.values().length+MultiplePooledSMs_nestedStates_EventlessSM.SmS1.values().length), MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.keySet().size());
	  Assert.assertEquals(7, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s2));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s3));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s4));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.Null));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1a));
	  Assert.assertEquals(true, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1b));
	  Assert.assertEquals(false, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.q));
	  Assert.assertEquals(false, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.containsKey(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.s));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s2).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s3).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s4).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.Null).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1a).size());
	  Assert.assertEquals(1, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1b).size());
	  Assert.assertEquals(null, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.q));
	  Assert.assertEquals(null, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.s));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s2).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s2)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s3).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s3)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s4).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s4)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.Null).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.Null)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1a).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1a)));
	  Assert.assertEquals(true , MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1b).containsAll(MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.get(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1b)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(7, MultiplePooledSMs_nestedStates_EventlessSM.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultiplePooledSMs_nestedStates_EventlessSM psm = new MultiplePooledSMs_nestedStates_EventlessSM();
	  
	  // check initial states are s1 - s21
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s3, psm.getSm1());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1a, psm.getSmS1());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  
	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed
	  // state machine sm: transition to sub-state: s1a 
	  // Now, the pool is empty
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is unspecified, it is saved at the head of the queue, current states are not changed
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is taken off the pool and is processed
	  // state machine sm1: transition to: s4 
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed
	  // state machine sm1: transition to: s4 
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e5();//event e5 is called and is added to the pool
	  // event e5 is taken off the pool and is processed
	  // state machine smS1: transition to: s1b 
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is taken off the pool and is processed
	  // state machine smS1: transition to: s4 
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e6();//event e6 is called and is added to the pool
	  // event e6 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine smS1: transition to: s1a 
	  // event e2 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // Now, the pool is empty
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is unspecified, it is saved at the head of the queue, current states are not changed
	  // The pool has e3 saved at its head
	  // The size of pool is 1: e3
	  psm.e3();//event e3 is called and is added to the pool
	  // event e3 is unspecified, it is saved at the head of the queue, current states are not changed
	  // The pool has e3, e3 saved at its head
	  // The size of pool is 2: e3 and e3
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // event e3 is taken off the pool and is processed
	  // state machine sm: transition to: s4 
	  // The pool has e3 saved at its head
	  // The size of pool is 1: e3
	  psm.e5();//event e5 is called and is added to the pool
	  // event e5 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // state machine smS1: transition to: s1b 
	  // The pool has e3 saved at its head
	  // The size of pool is 1: e3
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // event e3 is taken off the pool and is processed
	  // state machine sm: transition to: s4 
	  // Now, the pool is empty
	  
	  
	  // Check that the pool has no event
	  while(!psm.pool.messages.isEmpty())
	  {
		  Thread.sleep(10);
	  }

	  // The size of pool is 0
	  Assert.assertEquals(0, psm.pool.messages.size());	  
	  
	  // Check the current state of Sm is s1 and the current sub-state state is s1b
	  // Check the current state of Sm1 is s4 
	  // Check the current state of Sm2 is q
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.SmS1.s1b, psm.getSmS1());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm1.s4, psm.getSm1());
	  Assert.assertEquals(MultiplePooledSMs_nestedStates_EventlessSM.Sm2.q, psm.getSm2());
	  
  }
}