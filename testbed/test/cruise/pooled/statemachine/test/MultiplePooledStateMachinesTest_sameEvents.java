package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

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
  @Ignore
  @Test 
  public void processEvents() throws InterruptedException
  {
	  MultiplePooledSMs_sameEvents psm = new MultiplePooledSMs_sameEvents();
	  
	  // check initial states are s1 - s21
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());
	  
	  //event ev1 is called
	  psm.ev1();//event ev1 is added to the pool
	  Thread.sleep(10);
	  // event ev1 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s22
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event ev2 is called
	  psm.ev2();//event ev2 is added to the pool
	  Thread.sleep(10);
	  // event ev2 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // state machine sm1: transition to: s22
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event ev2 is called
	  psm.ev2();//event ev2 is added to the pool
	  Thread.sleep(10);
	  //event ev2 is unspecified, it is saved at the head of the queue, current states are not changed
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev2 saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	 
	  //event ev4 is called
	  psm.ev4();//event ev4 is added to the pool
	  Thread.sleep(10);
	  //event ev4 is unspecified, it is saved at the head of the queue, current states are not changed
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev2, ev4 saved at its head
	  Assert.assertEquals(2, psm.pool.messages.size());

	  //event ev1 is called
	  psm.ev1();//event ev1 is added to the pool
	  Thread.sleep(10);
	  //event ev1 is unspecified, it is saved at the head of the queue, current states are not changed
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev2, ev4, ev1 saved at its head
	  Assert.assertEquals(3, psm.pool.messages.size());

	  //event ev1 is called
	  psm.ev1();//event ev1 is added to the pool
	  Thread.sleep(10);
	  //event ev1 is unspecified, it is saved at the head of the queue, current states are not changed
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev2, ev4, ev1, ev1 saved at its head
	  Assert.assertEquals(4, psm.pool.messages.size());
	 
	  //event ev3 is called
	  psm.ev3();//event ev3 is added to the pool
	  Thread.sleep(10);  
	  // event ev3 is taken off the pool and is processed 
	  // state machine sm: transition to: s4 
	  // state machine sm1: transition to: s22
	  // process event ev4 state machine sm: transition to: s1
	  // process event ev1 state machine sm: transition to: s2
	  // process event ev2 state machine sm: transition to: s3
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev1 saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());

	  //event ev3 is called
	  psm.ev3();//event ev3 is added to the pool
	  Thread.sleep(10);
	  // event ev3 is taken off the pool and is processed
	  // state machine sm: transition to: s4 
	  // state machine sm1: transition to: s22
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s4, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool has ev1 saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
	  //event ev4 is called
	  psm.ev4();//event ev4 is added to the pool
	  Thread.sleep(10);
	  // event ev4 is taken off the pool and is processed
	  // state machine sm: transition to: s1 
	  // state machine sm1: transition to: s22
	  // process event ev1 state machine sm: transition to: s2
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s22, psm.getSm1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event ev7 is called
	  psm.ev7();//event ev7 is added to the pool
	  Thread.sleep(10);
	  // event ev7 is taken off the pool and is processed
	  // state machine sm: transition to: s2 
	  // state machine sm1: transition to: s21
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  
	  //event ev4 is called
	  psm.ev4();//event ev4 is added to the pool
	  Thread.sleep(10);
	  //event ev4 is unspecified, it is saved at the head of the queue, current states are not changed
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s2, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());
	  // pool has ev4 saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());

      //event ev2 is called
	  psm.ev2();//event ev2 is added to the pool
	  Thread.sleep(10);
	  // event ev2 is taken off the pool and is processed
	  // state machine sm: transition to: s3 
	  // state machine sm1: transition to: s21
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s3, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());
	  // pool has ev4 saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());	  
	  	  
      //event ev3 is called
	  psm.ev3();//event ev3 is added to the pool
	  Thread.sleep(10);
	  // event ev3 is taken off the pool and is processed
	  // state machine sm: transition to: s4
	  // state machine sm1: transition to: s21
	  // process event ev4 state machine sm: transition to: s1
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm.s1, psm.getSm());
	  Assert.assertEquals(MultiplePooledSMs_sameEvents.Sm1.s21, psm.getSm1());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());	
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());	 
  }
}