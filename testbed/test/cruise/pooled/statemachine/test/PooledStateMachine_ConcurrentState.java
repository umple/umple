package cruise.pooled.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_ConcurrentState
{ 
	
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(6, PooledSM_ConcurrentState.MessageType.values().length);
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("e1_M").equals(PooledSM_ConcurrentState.MessageType.e1_M));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("e2_M").equals(PooledSM_ConcurrentState.MessageType.e2_M));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("e3_M").equals(PooledSM_ConcurrentState.MessageType.e3_M));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("e4_M").equals(PooledSM_ConcurrentState.MessageType.e4_M));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("e5_M").equals(PooledSM_ConcurrentState.MessageType.e5_M));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.MessageType.valueOf("null_M").equals(PooledSM_ConcurrentState.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((PooledSM_ConcurrentState.SmS2S2c.values().length+PooledSM_ConcurrentState.SmS2S2a.values().length+PooledSM_ConcurrentState.Sm.values().length), PooledSM_ConcurrentState.stateMessageMap.keySet().size());
	  Assert.assertEquals(8, PooledSM_ConcurrentState.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.Sm.s1));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.Sm.s2));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2a.Null));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2a.s2a));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2a.s2b));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2c.Null));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2c.s2c));
	  Assert.assertEquals(true, PooledSM_ConcurrentState.stateMessageMap.containsKey(PooledSM_ConcurrentState.SmS2S2c.s2d));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s1).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s2).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.Null).size());
	  Assert.assertEquals(2, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2a).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2b).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.Null).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2c).size());
	  Assert.assertEquals(1, PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2d).size());
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s1).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s1)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s2).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.Sm.s2)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.Null).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.Null)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2a).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2a)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2b).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2a.s2b)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.Null).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.Null)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2c).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2c)));
	  Assert.assertEquals(true , PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2d).containsAll(PooledSM_ConcurrentState.stateMessageMap.get(PooledSM_ConcurrentState.SmS2S2c.s2d)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(8, PooledSM_ConcurrentState.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  PooledSM_ConcurrentState psm = new PooledSM_ConcurrentState();
	  int numChecks;
	  
	  // check initial states are s1 - Null - Null
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  // event e1 is taken off the pool and is processed: transition to: s2 - s2a - s2c
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSm().equals(PooledSM_ConcurrentState.Sm.s2))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2a, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2c, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the pool
	  // event e2 is taken off the pool and is processed: transition to: s1 - Null - Null 
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSm().equals(PooledSM_ConcurrentState.Sm.s1))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());

	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  // event e1 is taken off the pool and is processed: transition to: s2 - s2a - s2c 
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSm().equals(PooledSM_ConcurrentState.Sm.s2))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2a, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2c, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e3 is called
      psm.e3();//event e3 is added to the pool
	  // event e3 is taken off the pool and is processed: transition to: s2 - s2b - s2c 
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSmS2S2a().equals(PooledSM_ConcurrentState.SmS2S2a.s2b))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2b, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2c, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());

	  //event e4 is called
	  psm.e4();//event e4 is added to the pool
	  // event e4 is taken off the pool and is processed: transition to: s2 - s2b - s2d 
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSmS2S2c().equals(PooledSM_ConcurrentState.SmS2S2c.s2d))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2b, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2d, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e5 is called
	  psm.e5();//event e5 is added to the pool
	  //event e5 is unspecified, it is saved at the head of the queue, current states are not changed
	  numChecks=200;
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(psm.pool.messages.size() == 1 && psm.pool.messages.element().type.equals(PooledSM_ConcurrentState.MessageType.e5_M) )
		  {
			  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  break;
		  }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2b, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2d, psm.getSmS2S2c());
	  //the pool has e5 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event e5 is saved in it
	  for (PooledSM_ConcurrentState.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_ConcurrentState.MessageType.e5_M, msg.type);
      }

	  //event e3 is called
	  psm.e3();//event e3 is added to the pool
	  // event e3 is taken off the pool and is processed: transition to: s2 - s2a - s2d
	  // event e5 is taken off the pool and is processed: transition to: s1 - Null - Null
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSm().equals(PooledSM_ConcurrentState.Sm.s1))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e2 is called
	  psm.e2();//event e2 is added to the pool
	  //event e2 is unspecified, it is saved at the head of the queue, current states are not changed
	  numChecks=200;
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(psm.pool.messages.size() == 1 && psm.pool.messages.element().type.equals(PooledSM_ConcurrentState.MessageType.e2_M) )
		  {
			  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  break;
		  }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  //the pool has e2 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());	  
	  //check the pool to see if event e2 is saved in it
	  for (PooledSM_ConcurrentState.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_ConcurrentState.MessageType.e2_M, msg.type);
      }

	  //event e3 is called
	  psm.e3();//event e3 is added to the pool
	  //event e3 is unspecified, it is saved at the head of the queue, current states are not changed
	  numChecks=200;
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(psm.pool.messages.size() == 2)
		  {
			  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  break;
		  }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  //the pool has e2,e3 event saved at its head
	  Assert.assertEquals(2, psm.pool.messages.size());	  
	  //check the pool to see if event e3 is saved in it
	  for (PooledSM_ConcurrentState.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_ConcurrentState.MessageType.e3_M))
		  {
		    Assert.assertEquals(PooledSM_ConcurrentState.MessageType.e3_M, msg.type);
		  }
      }

	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  // event e1 is taken off the pool and is processed: transition to: s2 - s2a - s2c
	  // event e2 is taken off the pool and is processed: transition to: s1 - Null - Null
	  numChecks=200;
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(psm.pool.messages.size() == 1 && psm.pool.messages.element().type.equals(PooledSM_ConcurrentState.MessageType.e3_M) )
		  {
			  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  break;
		  }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s1, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.Null, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.Null, psm.getSmS2S2c());
	  //the pool has e3 event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event e3 is saved in it
	  for (PooledSM_ConcurrentState.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_ConcurrentState.MessageType.e3_M, msg.type);
      }
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  // event e1 is taken off the pool and is processed: transition to: s2 - s2a - s2c 
	  // event e3 is taken off the pool and is processed: transition to: s2 - s2b - s2c 
	  numChecks=200;
	  while(numChecks>0 && !psm.pool.messages.isEmpty()) {
		  if(!psm.getSm().equals(PooledSM_ConcurrentState.Sm.s2))
		  {
			  Thread.sleep(5);
			  numChecks--;
		  }		  
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_ConcurrentState.Sm.s2, psm.getSm());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2a.s2b, psm.getSmS2S2a());
	  Assert.assertEquals(PooledSM_ConcurrentState.SmS2S2c.s2c, psm.getSmS2S2c());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());	  
  }
}