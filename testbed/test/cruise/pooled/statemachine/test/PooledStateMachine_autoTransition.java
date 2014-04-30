package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_autoTransition
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
    // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
    Assert.assertEquals(1, Light.MessageType.values().length);
    Assert.assertEquals(true, Light.MessageType.valueOf("null_M").equals(Light.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
    // compare the number of states is equal to the number of keys in stateMessageMap
    Assert.assertEquals(Light.Bulb.values().length, Light.stateMessageMap.keySet().size());
    Assert.assertEquals(2, Light.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
    //check that every state of SM it is put in stateMessageMap
    Assert.assertEquals(true, Light.stateMessageMap.containsKey(Light.Bulb.Off));
    Assert.assertEquals(true, Light.stateMessageMap.containsKey(Light.Bulb.On));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
    //check that every state has its list Of messages
    Assert.assertEquals(1, Light.stateMessageMap.get(Light.Bulb.Off).size());
    Assert.assertEquals(1, Light.stateMessageMap.get(Light.Bulb.On).size());
    Assert.assertEquals(true , Light.stateMessageMap.get(Light.Bulb.Off).containsAll(Light.stateMessageMap.get(Light.Bulb.Off)));
    Assert.assertEquals(true , Light.stateMessageMap.get(Light.Bulb.On).containsAll(Light.stateMessageMap.get(Light.Bulb.On)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
    //size of stateMessageMap which contains (state, list of MessageTypes)
    Assert.assertEquals(2, Light.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
    Light psm = new Light();
    // check initial state is Off
    Assert.assertEquals(Light.Bulb.On, psm.getBulb());
    
    //check that there is no event left in the queue
    Assert.assertEquals(0, psm.pool.messages.size());
    
  }
  

}