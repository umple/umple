package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class MultiplePooledStateMachinesTest
{ 
	
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(3, MultiplePooledSMs.MessageType.values().length);
	  Assert.assertEquals(true, MultiplePooledSMs.MessageType.valueOf("e1_M").equals(MultiplePooledSMs.MessageType.e1_M));
	  Assert.assertEquals(true, MultiplePooledSMs.MessageType.valueOf("e2_M").equals(MultiplePooledSMs.MessageType.e2_M));
	  Assert.assertEquals(true, MultiplePooledSMs.MessageType.valueOf("e4_M").equals(MultiplePooledSMs.MessageType.e4_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((MultiplePooledSMs.Sm1.values().length+MultiplePooledSMs.Sm.values().length), MultiplePooledSMs.stateMessageMap.keySet().size());
	  Assert.assertEquals(4, MultiplePooledSMs.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, MultiplePooledSMs.stateMessageMap.containsKey(MultiplePooledSMs.Sm.s1));
	  Assert.assertEquals(true, MultiplePooledSMs.stateMessageMap.containsKey(MultiplePooledSMs.Sm.s2));
	  Assert.assertEquals(true, MultiplePooledSMs.stateMessageMap.containsKey(MultiplePooledSMs.Sm1.s3));
	  Assert.assertEquals(true, MultiplePooledSMs.stateMessageMap.containsKey(MultiplePooledSMs.Sm1.s4));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s1).size());
	  Assert.assertEquals(1, MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s2).size());
	  Assert.assertEquals(1, MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s3).size());
	  Assert.assertEquals(1, MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s4).size());
	  Assert.assertEquals(true , MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s1).containsAll(MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s1)));
	  Assert.assertEquals(true , MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s2).containsAll(MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm.s2)));
	  Assert.assertEquals(true , MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s3).containsAll(MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s3)));
	  Assert.assertEquals(true , MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s4).containsAll(MultiplePooledSMs.stateMessageMap.get(MultiplePooledSMs.Sm1.s4)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(4, MultiplePooledSMs.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultiplePooledSMs psm = new MultiplePooledSMs();
	  
	  // check initial states are s1 - s3
	  Assert.assertEquals(MultiplePooledSMs.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs.Sm1.s3, psm.getSm1());

	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // Now, the pool is empty
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s4
	  // Now, the pool is empty
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has e2 saved at its head
	  // The size of pool is 1: e2
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed 
	  // process event e2 of second state machine sm1: transition to: s3
	  // state machine sm: transition to: s1 
	  // process event e4 state machine sm1: transition to: s4
	  // Now, the pool is empty
	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s4
	  // Now, the pool is empty
	  psm.e1();//event e1 is called and is added to the pool
	  // event e1 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has e1 saved at its head
	  // The size of pool is 1: e1
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is taken off the pool and is processed 
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s3
	  // The pool has e1 saved at its head
	  // The size of pool is 1: e1
	  psm.e4();//event e4 is called and is added to the pool
	  // event e4 is unspecified, it is saved at the head of the pool, current states are not changed
	  // The pool has e1, and e4 saved at its head
	  // The size of pool is 2: e1 and e4
	  psm.e2();//event e2 is called and is added to the pool
	  // event e2 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s4
	  // process event e1 state machine sm: transition to: s2
	  // process event e4 state machine sm1: transition to: s3
	  // Now, the pool is empty
	  	  
	  
	  // Check that the pool has no event
	  while(!psm.pool.messages.isEmpty())
	  {
		  Thread.sleep(10);
	  }

	  // The size of pool is 0
	  Assert.assertEquals(0, psm.pool.messages.size());	  
	  
	  // Check the current state of Sm is s2 and the current state of Sm1 is s3
	  Assert.assertEquals(MultiplePooledSMs.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs.Sm1.s3, psm.getSm1());
	  
  }
}