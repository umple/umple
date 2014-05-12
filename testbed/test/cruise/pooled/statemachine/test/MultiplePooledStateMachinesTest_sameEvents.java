package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class MultiplePooledStateMachinesTest_sameEvents
{ 

  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(6, MultiplePooledSMs_sameEvents.MessageType.values().length);
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev1_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev1_M));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev2_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev2_M));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev3_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev3_M));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev4_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev4_M));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev5_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev5_M));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.MessageType.valueOf("ev7_M").equals(MultiplePooledSMs_sameEvents.MessageType.ev7_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((MultiplePooledSMs_sameEvents.Sm1.values().length+MultiplePooledSMs_sameEvents.Sm.values().length), MultiplePooledSMs_sameEvents.stateMessageMap.keySet().size());
	  Assert.assertEquals(6, MultiplePooledSMs_sameEvents.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm.s1));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm.s2));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm.s3));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm.s4));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm1.s21));
	  Assert.assertEquals(true, MultiplePooledSMs_sameEvents.stateMessageMap.containsKey(MultiplePooledSMs_sameEvents.Sm1.s22));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(2, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s1).size());
	  Assert.assertEquals(1, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s2).size());
	  Assert.assertEquals(1, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s3).size());
	  Assert.assertEquals(1, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s4).size());
	  Assert.assertEquals(1, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s21).size());
	  Assert.assertEquals(1, MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s22).size());
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s1).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s1)));
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s2).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s2)));
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s3).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s3)));
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s4).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm.s4)));
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s21).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s21)));
	  Assert.assertEquals(true , MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s22).containsAll(MultiplePooledSMs_sameEvents.stateMessageMap.get(MultiplePooledSMs_sameEvents.Sm1.s22)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(6, MultiplePooledSMs_sameEvents.stateMessageMap.size());
  }

  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultiplePooledSMs_sameEvents psm = new MultiplePooledSMs_sameEvents();
	  
	  // check initial states are s1 - s21
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());

	  psm.ev1();//event ev1 is called and is added to the pool
	  // event ev1 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s22
	  // Now, the pool is empty
	  psm.ev2();//event ev2 is called and is added to the pool
	  // event ev2 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // state machine sm1: transition to: s22
	  // Now, the pool is empty
	  psm.ev2();//event ev2 is called and is added to the pool
	  // event ev2 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has ev2 saved at its head
	  // The size of pool is 1: ev2
	  psm.ev4();//event ev4 is called and is added to the pool
	  // event ev4 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has ev2, ev4 saved at its head
	  // The size of pool is 2: ev2 and ev4
	  psm.ev1();//event ev1 is called and is added to the pool
	  // event ev1 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has ev2, ev4, and ev1 saved at its head
	  // The size of pool is 3: ev2, ev4 and ev1
	  psm.ev1();//event ev1 is called and is added to the pool
	  // event ev1 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has ev2, ev4, ev1, and ev1 saved at its head
	  // The size of pool is 4: ev2, ev4 and ev1
	  psm.ev3();//event ev3 is called and is added to the pool
	  // event ev3 is taken off the pool and is processed 
	  // state machine sm: transition to: s4 
	  // state machine sm1: transition to: s22
	  // process event ev4 state machine sm: transition to: s1
	  // process event ev1 state machine sm: transition to: s2
	  // process event ev2 state machine sm: transition to: s3
	  // The pool has ev1 saved at its head
	  // The size of pool is 1: ev1
	  psm.ev3();//event ev3 is called and is added to the pool
	  // event ev3 is taken off the pool and is processed
	  // state machine sm: transition to: s4 
	  // state machine sm1: transition to: s22
	  // The pool has ev1 saved at its head
	  // The size of pool is 1: ev1
	  psm.ev4();//event ev4 is called and is added to the pool
	  // event ev4 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s22
	  // process event ev1 state machine sm: transition to: s2
	  // Now, the pool is empty
	  psm.ev7();//event ev7 is called and is added to the pool
	  // event ev7 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s21
	  // Now, the pool is empty
	  psm.ev4();//event ev4 is called and is added to the pool
	  // event ev4 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has ev4 saved at its head
	  // The size of pool is 1: ev4
	  psm.ev2();//event ev2 is called and is added to the pool
	  // event ev2 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // state machine sm1: transition to: s21
	  // The pool has ev4 saved at its head
	  // The size of pool is 1: ev4
	  psm.ev3();//event ev3 is called and is added to the pool
	  // event ev3 is taken off the pool and is processed
	  // state machine sm: transition to: s4
	  // state machine sm1: transition to: s21
	  // process event ev4 state machine sm: transition to: s1
	  // Now, the pool is empty
	  
	  
	  // Check that the pool has no event
	  while(!psm.pool.messages.isEmpty())
	  {
		  Thread.sleep(10);
	  }

	  // The size of pool is 0
	  Assert.assertEquals(0, psm.pool.messages.size());	  
	  
	  // Check the current state of Sm is s1 and the current state of Sm1 is s21
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());

  }
}