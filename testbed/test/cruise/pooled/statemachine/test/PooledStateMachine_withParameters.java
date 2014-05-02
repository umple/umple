package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PooledStateMachine_withParameters
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(3, LightFixture.MessageType.values().length);
	  Assert.assertEquals(true, LightFixture.MessageType.valueOf("turnDimmer_M").equals(LightFixture.MessageType.turnDimmer_M));
	  Assert.assertEquals(true, LightFixture.MessageType.valueOf("flipSwitch_M").equals(LightFixture.MessageType.flipSwitch_M));
	  Assert.assertEquals(true, LightFixture.MessageType.valueOf("entry_M").equals(LightFixture.MessageType.entry_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals(LightFixture.Bulb.values().length, LightFixture.stateMessageMap.keySet().size());
	  Assert.assertEquals(3, LightFixture.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, LightFixture.stateMessageMap.containsKey(LightFixture.Bulb.Off));
	  Assert.assertEquals(true, LightFixture.stateMessageMap.containsKey(LightFixture.Bulb.Dimmed));
	  Assert.assertEquals(true, LightFixture.stateMessageMap.containsKey(LightFixture.Bulb.On));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(2, LightFixture.stateMessageMap.get(LightFixture.Bulb.Off).size());
	  Assert.assertEquals(3, LightFixture.stateMessageMap.get(LightFixture.Bulb.Dimmed).size());
	  Assert.assertEquals(2, LightFixture.stateMessageMap.get(LightFixture.Bulb.On).size());
	  Assert.assertEquals(true , LightFixture.stateMessageMap.get(LightFixture.Bulb.Off).containsAll(LightFixture.stateMessageMap.get(LightFixture.Bulb.Off)));
	  Assert.assertEquals(true , LightFixture.stateMessageMap.get(LightFixture.Bulb.Dimmed).containsAll(LightFixture.stateMessageMap.get(LightFixture.Bulb.Dimmed)));
	  Assert.assertEquals(true , LightFixture.stateMessageMap.get(LightFixture.Bulb.On).containsAll(LightFixture.stateMessageMap.get(LightFixture.Bulb.On)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(3, LightFixture.stateMessageMap.size());
  }
  
  @Ignore
  @Test 
  public void processEvents() throws InterruptedException
  {
	  LightFixture psm = new LightFixture(100);
	  //check that the value of dimmer=100
	  Assert.assertEquals(100, psm.getDimmer());
	  //check that the value of brightness=0
	  Assert.assertEquals(0, psm.getBrightness());
	  // check initial state is Off
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  
	  //event turnDimmer is called
	  psm.turnDimmer(20);//event turnDimmer is added to the pool
	  Thread.sleep(10);
	  //check that the value of brightness is changed to be 20
	  Assert.assertEquals(20, psm.getBrightness());
	  // event turnDimmer is taken off the pool and is processed: transition to state Off 
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event entry is called
	  psm.entry();//event entry is added to the pool
	  Thread.sleep(10);
	  //event entry is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  //check that the value of dimmer is still 100
	  Assert.assertEquals(100, psm.getDimmer());
	  //the pool has entry event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event entry is saved in it
	  for (LightFixture.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(LightFixture.MessageType.entry_M, msg.type);
      }
	  
	  
	  //event flipSwitch is called
	  psm.flipSwitch();//event flipSwitch is added to the pool
	  Thread.sleep(10);
	  // event flipSwitch is taken off the pool and is processed: transition to state Dimmed 
	  // event entry is taken off the pool and is processed: transition to state On 
	  Assert.assertEquals(LightFixture.Bulb.On, psm.getBulb());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event turnDimmer is called
	  psm.turnDimmer(30);//event turnDimmer is added to the pool
	  Thread.sleep(10);
	  //check that the value of brightness is changed to 30
	  Assert.assertEquals(30, psm.getBrightness());
	  // event turnDimmer is taken off the pool and is processed: transition to state Dimmed 
	  Assert.assertEquals(LightFixture.Bulb.Dimmed, psm.getBulb());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //event flipSwitch is called
	  psm.flipSwitch();//event flipSwitch is added to the pool
	  Thread.sleep(10);
	  // event flipSwitch is taken off the pool and is processed: transition to state Off 
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //change the value of dimmer to be 50
	  psm.setDimmer(50);
	  //event entry is called
	  psm.entry();//event entry is added to the pool
	  Thread.sleep(10);
	  //event entry is unspecified, it is saved at the head of the queue, current sate is not changed
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  //check that the value of dimmer=50
	  Assert.assertEquals(50, psm.getDimmer());
	  //the pool has entry event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  //check the pool to see if event entry is saved in it
	  for (LightFixture.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(LightFixture.MessageType.entry_M, msg.type);
      }
	  
	  //event turnDimmer is called
	  psm.turnDimmer(40);//event turnDimmer is added to the pool
	  Thread.sleep(10);
	  //check that the value of brightness is changed to 40
	  Assert.assertEquals(40, psm.getBrightness());
	  // event turnDimmer is taken off the pool and is processed: transition to state Off 
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  //the pool has entry event saved at its head
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
	  //event flipSwitch is called
	  psm.flipSwitch();//event flipSwitch is added to the pool
	  Thread.sleep(10);
	  // event flipSwitch is taken off the pool and is processed: transition to state Dimmed 
	  // event entry is taken off the pool and is processed and condition is false: stay at Dimmed
	  Assert.assertEquals(LightFixture.Bulb.Dimmed, psm.getBulb());
	  // pool is empty
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //check that there is no event left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
  }
  

}