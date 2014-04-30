//package cruise.pooled.statemachine.test;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//
//public class PooledStateMachineTest
//{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
//	  Assert.assertEquals(2, PooledSM.MessageType.values().length);
//	  Assert.assertEquals(true, PooledSM.MessageType.valueOf("reject_M").equals(PooledSM.MessageType.reject_M));
//	  Assert.assertEquals(true, PooledSM.MessageType.valueOf("register_M").equals(PooledSM.MessageType.register_M));  
//  }
//  
//  @Test 
//  public void numberOfKeysInstateMessageMap()
//  {
//	  // compare the number of states is equal to the number of keys in stateMessageMap
//	  Assert.assertEquals(PooledSM.Status.values().length, PooledSM.stateMessageMap.keySet().size());
//	  Assert.assertEquals(2, PooledSM.stateMessageMap.keySet().size());
//  }
//  
//  @Test 
//  public void eachStateOfStateMachineAddedTostateMessageMap()
//  {
//	  //check that every state of SM it is put in stateMessageMap
//	  Assert.assertEquals(true, PooledSM.stateMessageMap.containsKey(PooledSM.Status.Full));
//	  Assert.assertEquals(true, PooledSM.stateMessageMap.containsKey(PooledSM.Status.Open));
//  }
//  
//  @Test 
//  public void everyStateHasListOfMessages()
//  {
//	  //check that every state has its list Of messages
//	  Assert.assertEquals(1, PooledSM.stateMessageMap.get(PooledSM.Status.Open).size());
//	  Assert.assertEquals(1, PooledSM.stateMessageMap.get(PooledSM.Status.Full).size());
//	  Assert.assertEquals(true , PooledSM.stateMessageMap.get(PooledSM.Status.Full).containsAll(PooledSM.stateMessageMap.get(PooledSM.Status.Full)));
//	  Assert.assertEquals(true , PooledSM.stateMessageMap.get(PooledSM.Status.Open).containsAll(PooledSM.stateMessageMap.get(PooledSM.Status.Open)));
//  }
//  
//  @Test 
//  public void sizeOfstateMessageMap()
//  {
//	  //size of stateMessageMap which contains (state, list of MessageTypes)
//	  Assert.assertEquals(2, PooledSM.stateMessageMap.size());
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  PooledSM psm = new PooledSM();
//	  // check initial state is Open
//	  Assert.assertEquals(PooledSM.Status.Open, psm.getStatus());
//	  
//	  // reject is triggered: reject is added to the message pool(queue)
//	  psm.reject();
//	  Thread.sleep(10);
//	  // reject is pooled at the head of queue: it is not processed
//	  Assert.assertEquals(PooledSM.Status.Open, psm.getStatus());
//	  // check that the message 'reject_M' is pooled
//	  for (PooledSM.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM.MessageType.reject_M, msg.type);
//      }
//	  //Now, there is one message saved at the head of the queue
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  
//	  // register is triggered: register is added to the message pool(queue)
//	  psm.register();
//	  Thread.sleep(10);
//	  // register is removed from the queue and is processed: transition to Full
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  // reject is removed and processed: transition to Full
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  //there is no message saved : reject is dequeued and processed
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  // reject is triggered: reject is added to the message pool(queue)
//	  psm.reject();
//	  Thread.sleep(10);
//	  // reject is removed from the queue and is processed: transition to Full
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  //there is no message saved 
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  // register is triggered: register is added to the message pool(queue)
//	  psm.register();
//	  Thread.sleep(10);
//	  // register is pooled at the head of queue: it is not processed
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  // check that the message 'register_M' is pooled
//	  for (PooledSM.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM.MessageType.register_M, msg.type);
//      }
//	  //Now, there is one message saved at the head of the queue
//	  Assert.assertEquals(1, psm.pool.messages.size());
//		  
//	  // register is triggered: register is added to the message pool(queue)
//	  psm.register();
//	  Thread.sleep(10);
//	  // register is pooled at the head of queue: it is not processed
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  // check that the message 'register_M' is pooled
//	  for (PooledSM.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM.MessageType.register_M))
//		  {
//			  Assert.assertEquals(PooledSM.MessageType.register_M, msg.type);
//		  }
//      }
//	  //Now, there are two messages saved at the head of the queue
//	  Assert.assertEquals(2, psm.pool.messages.size());
//			
//		  
//	  // reject is triggered: reject is added to the message pool(queue)
//	  psm.reject();
//	  Thread.sleep(10);
//	  // reject is removed from the queue and is processed: transition to Full
//	  Assert.assertEquals(PooledSM.Status.Full, psm.getStatus());
//	  //there are two messages saved at the head of the queue
//	  Assert.assertEquals(2, psm.pool.messages.size());
//		  
//	  
//	 //check that there are two events left in the queue
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  
//  }
//}
