package cruise.pooled.statemachine.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;


public class PooledStateMachine_timedTransition_1
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	// compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	Assert.assertEquals(5, PooledSM_timedTransition_1.MessageType.values().length);
	Assert.assertEquals(true, PooledSM_timedTransition_1.MessageType.valueOf("ev0_M").equals(PooledSM_timedTransition_1.MessageType.ev0_M));
    Assert.assertEquals(true, PooledSM_timedTransition_1.MessageType.valueOf("timeouts1Tos2_M").equals(PooledSM_timedTransition_1.MessageType.timeouts1Tos2_M));  
	Assert.assertEquals(true, PooledSM_timedTransition_1.MessageType.valueOf("ev2_M").equals(PooledSM_timedTransition_1.MessageType.ev2_M));
    Assert.assertEquals(true, PooledSM_timedTransition_1.MessageType.valueOf("ev3_M").equals(PooledSM_timedTransition_1.MessageType.ev3_M));  
	Assert.assertEquals(true, PooledSM_timedTransition_1.MessageType.valueOf("null_M").equals(PooledSM_timedTransition_1.MessageType.null_M));
  }
	  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	// compare the number of states is equal to the number of keys in stateMessageMap
	Assert.assertEquals(PooledSM_timedTransition_1.Sm.values().length, PooledSM_timedTransition_1.stateMessageMap.keySet().size());
    Assert.assertEquals(5, PooledSM_timedTransition_1.stateMessageMap.keySet().size());
  }
	  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	//check that every state of SM it is put in stateMessageMap
	Assert.assertEquals(true, PooledSM_timedTransition_1.stateMessageMap.containsKey(PooledSM_timedTransition_1.Sm.s0));
    Assert.assertEquals(true, PooledSM_timedTransition_1.stateMessageMap.containsKey(PooledSM_timedTransition_1.Sm.s1));
    Assert.assertEquals(true, PooledSM_timedTransition_1.stateMessageMap.containsKey(PooledSM_timedTransition_1.Sm.s2));
    Assert.assertEquals(true, PooledSM_timedTransition_1.stateMessageMap.containsKey(PooledSM_timedTransition_1.Sm.s3));
    Assert.assertEquals(true, PooledSM_timedTransition_1.stateMessageMap.containsKey(PooledSM_timedTransition_1.Sm.s4));
  }
	  
  @Test 
  public void everyStateHasListOfMessages()
  {
	//check that every state has its list Of messages
	Assert.assertEquals(1, PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s0).size());
    Assert.assertEquals(1, PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s1).size());
    Assert.assertEquals(1, PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s2).size());
    Assert.assertEquals(1, PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s3).size());
    Assert.assertEquals(1, PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s4).size());
	Assert.assertEquals(true , PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s0).containsAll(PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s0)));
    Assert.assertEquals(true , PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s1).containsAll(PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s1)));
    Assert.assertEquals(true , PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s2).containsAll(PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s2)));
    Assert.assertEquals(true , PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s3).containsAll(PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s3)));
    Assert.assertEquals(true , PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s4).containsAll(PooledSM_timedTransition_1.stateMessageMap.get(PooledSM_timedTransition_1.Sm.s4)));
  }
	  
  @Test 
  public void sizeOfstateMessageMap()
  {
    //size of stateMessageMap which contains (state, list of MessageTypes)
    Assert.assertEquals(5, PooledSM_timedTransition_1.stateMessageMap.size());
  }
	  
  @Test
  public void processEvents() throws InterruptedException
  {
	  PooledSM_timedTransition_1 psm = new PooledSM_timedTransition_1();
	  int numChecks = 0;
	  // check initial state is s0
	  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s0, psm.getSm());
	  Assert.assertEquals("running", psm.getLog());
	  
	  //ev0 is triggered: ev0 is Pooled
	  psm.ev0();	
	  //ev0 is dePooled and processed: transition to s1
	  numChecks=200; // we will check for a second
	  while(!psm.getSm().equals(PooledSM_timedTransition_1.Sm.s1) && numChecks>0) {
	    Thread.sleep(5);
	    numChecks--;
	  }
	  assertThat(numChecks, not(equalTo(0)));
	  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s1, psm.getSm());
	  // check if there is a message saved in the pool
	  
	  
	  //ev3 is triggered: ev3 is Pooled
	  psm.ev3();
      // ev3 is pooled at the head of pool: it is not processed
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(!psm.pool.messages.isEmpty())
		  {
			  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s1, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  if(psm.pool.messages.size() == 1 && psm.pool.messages.element().type.equals(PooledSM_timedTransition_1.MessageType.ev3_M))
			  {
				  break;
			  }
	      }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s1, psm.getSm());
	  // check that the message 'ev3_M' is pooled
	  for (PooledSM_timedTransition_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_timedTransition_1.MessageType.ev3_M, msg.type);
      }
	  //Now, there is one message saved at the head of the pool: ev3
	  Assert.assertEquals(1, psm.pool.messages.size());	  

	  
	  //ev2 is triggered: ev2 is Pooled
	  psm.ev2();
      // ev2 is pooled at the head of pool: it is not processed
	  while(numChecks>0) {
		  Thread.sleep(5);
		  numChecks--;
		  if(!psm.pool.messages.isEmpty())
		  {
			  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s1, psm.getSm());
			  Assert.assertEquals(false, psm.pool.messages.isEmpty());
			  if(psm.pool.messages.size() == 2)
			  {
				  break;
			  }
	      }
	  }	  
	  assertThat(numChecks, not(equalTo(0)));		
	  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s1, psm.getSm());
	  // check that the message 'ev2_M' is pooled
	  for (PooledSM_timedTransition_1.Message msg: psm.pool.messages)
      {
		  if(msg.type.equals(PooledSM_timedTransition_1.MessageType.ev2_M))
		  {
			  Assert.assertEquals(PooledSM_timedTransition_1.MessageType.ev2_M, msg.type);
		  }
      }
	  //Now, there is two message saved at the head of the pool: ev3 and ev2
	  Assert.assertEquals(2, psm.pool.messages.size());	  
	  
		
	  //waiting for 2 seconds before transition to s2
	  wait(3);
	
	  //ev2 is taken off the pool and is processed
	  //transition to s4
	  Assert.assertEquals(PooledSM_timedTransition_1.Sm.s4, psm.getSm()); 
      
	  
	  //check that there is one event left in the pool: ev3
	  Assert.assertEquals(1, psm.pool.messages.size());
	  for (PooledSM_timedTransition_1.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(PooledSM_timedTransition_1.MessageType.ev3_M, msg.type);
      }
      
  }
  
  public static void wait(int seconds)
  {
    try
    {
      Thread.sleep(seconds*1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }    
  }
}