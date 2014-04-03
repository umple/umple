package cruise.pooled.statemachine.test;

import org.junit.Assert;
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
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  LightFixture psm = new LightFixture(100);
	  Assert.assertEquals(100, psm.getDimmer());
	  Assert.assertEquals(0, psm.getBrightness());
	  // check initial state is Off
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  
	  psm.turnDimmer(20);
	  Thread.sleep(10);
	  Assert.assertEquals(20, psm.getBrightness());
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.entry();
	  Thread.sleep(10);
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  Assert.assertEquals(100, psm.getDimmer());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  for (LightFixture.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(LightFixture.MessageType.entry_M, msg.type);
      }
	  
	  
	  psm.flipSwitch();
	  Thread.sleep(10);
	  Assert.assertEquals(LightFixture.Bulb.On, psm.getBulb());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.turnDimmer(30);
	  Thread.sleep(10);
	  Assert.assertEquals(30, psm.getBrightness());
	  Assert.assertEquals(LightFixture.Bulb.Dimmed, psm.getBulb());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.flipSwitch();
	  Thread.sleep(10);
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  psm.setDimmer(50);
	  psm.entry();
	  Thread.sleep(10);
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  Assert.assertEquals(50, psm.getDimmer());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  for (LightFixture.Message msg: psm.pool.messages)
      {
		  Assert.assertEquals(LightFixture.MessageType.entry_M, msg.type);
      }
	  
	  psm.turnDimmer(40);
	  Thread.sleep(10);
	  Assert.assertEquals(40, psm.getBrightness());
	  Assert.assertEquals(LightFixture.Bulb.Off, psm.getBulb());
	  Assert.assertEquals(1, psm.pool.messages.size());
	  
	  psm.flipSwitch();
	  Thread.sleep(10);
	  Assert.assertEquals(LightFixture.Bulb.Dimmed, psm.getBulb());
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  //check that there are two events left in the queue
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
  }
  

}