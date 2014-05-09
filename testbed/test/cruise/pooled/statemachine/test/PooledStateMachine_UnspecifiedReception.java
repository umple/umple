package cruise.pooled.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_UnspecifiedReception
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.MessageType.values().length);
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("e1_M").equals(PooledSMwithUnspecifiedReception.MessageType.e1_M));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("unspecified_M").equals(PooledSMwithUnspecifiedReception.MessageType.unspecified_M));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.MessageType.valueOf("null_M").equals(PooledSMwithUnspecifiedReception.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.values().length, PooledSMwithUnspecifiedReception.stateMessageMap.keySet().size());
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.s1));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.s2));
	  Assert.assertEquals(true, PooledSMwithUnspecifiedReception.stateMessageMap.containsKey(PooledSMwithUnspecifiedReception.Sm.error1));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(2, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1).size());
	  Assert.assertEquals(1, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2).size());
	  Assert.assertEquals(1, PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1).size());
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s1)));
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.s2)));
	  Assert.assertEquals(true , PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1).containsAll(PooledSMwithUnspecifiedReception.stateMessageMap.get(PooledSMwithUnspecifiedReception.Sm.error1)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(3, PooledSMwithUnspecifiedReception.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  int numChecks;
	  //Unspecified error handling is not compatible with pooled state machine
	  //unspecified event is treated like any regular event, is not special any more
	  PooledSMwithUnspecifiedReception psm = new PooledSMwithUnspecifiedReception();
	  // check initial state is s1
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s1, psm.getSm());
	  
	  
	  //event unspecified is called
	  psm.unspecified();//event unspecified is added to the pool
	  numChecks=200;
	  // event unspecified is taken off the pool and is processed: transition to state s1 
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(psm.pool.messages.isEmpty())
		  {
			  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s1, psm.getSm());
			  Assert.assertEquals(true, psm.pool.messages.isEmpty());
	    	  break;
	      }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s1, psm.getSm());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event e1 is called
	  psm.e1();//event e1 is added to the pool
	  numChecks=200;
	  // event e1 is taken off the pool and is processed: transition to state s2 
	  while(!psm.pool.messages.isEmpty() && numChecks>0) {
		if(!psm.getSm().equals(PooledSMwithUnspecifiedReception.Sm.s2))
		{
			Thread.sleep(5);
		    numChecks--;
		}
	  }
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSMwithUnspecifiedReception.Sm.s2, psm.getSm());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
  }
  


}