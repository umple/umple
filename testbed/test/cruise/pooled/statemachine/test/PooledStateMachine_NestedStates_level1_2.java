//package cruise.pooled.statemachine.test;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class PooledStateMachine_NestedStates_level1_2
//{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
//	  Assert.assertEquals(10, PooledSM_NestedState_L1_2.MessageType.values().length);
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e1_M").equals(PooledSM_NestedState_L1_2.MessageType.e1_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e2_M").equals(PooledSM_NestedState_L1_2.MessageType.e2_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e3_M").equals(PooledSM_NestedState_L1_2.MessageType.e3_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e4_M").equals(PooledSM_NestedState_L1_2.MessageType.e4_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e5_M").equals(PooledSM_NestedState_L1_2.MessageType.e5_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e6_M").equals(PooledSM_NestedState_L1_2.MessageType.e6_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e7_M").equals(PooledSM_NestedState_L1_2.MessageType.e7_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e8_M").equals(PooledSM_NestedState_L1_2.MessageType.e8_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("e9_M").equals(PooledSM_NestedState_L1_2.MessageType.e9_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L1_2.MessageType.null_M));
//  }
//  
//  @Test 
//  public void numberOfKeysInstateMessageMap()
//  {
//	  // compare the number of states is equal to the number of keys in stateMessageMap
//	  Assert.assertEquals((PooledSM_NestedState_L1_2.SmS2.values().length+PooledSM_NestedState_L1_2.Sm.values().length+PooledSM_NestedState_L1_2.SmS1.values().length+PooledSM_NestedState_L1_2.SmS3.values().length), PooledSM_NestedState_L1_2.stateMessageMap.keySet().size());
//	  Assert.assertEquals(12, PooledSM_NestedState_L1_2.stateMessageMap.keySet().size());
//  }
//  
//  @Test 
//  public void eachStateOfStateMachineAddedTostateMessageMap()
//  {
//	  //check that every state of SM it is put in stateMessageMap
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.Sm.s1));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.Sm.s2));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.s1a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS1.s1b));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.s2a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS2.s2b));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.s3a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L1_2.stateMessageMap.containsKey(PooledSM_NestedState_L1_2.SmS3.s3b));
//  }
//  
//  @Test 
//  public void everyStateHasListOfMessages()
//  {
//	  //check that every state has its list Of messages
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b).size());
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s1)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.Sm.s2)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS1.s1b)));
//      Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS2.s2b)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b).containsAll(PooledSM_NestedState_L1_2.stateMessageMap.get(PooledSM_NestedState_L1_2.SmS3.s3b)));
//  }
//  
//  @Test 
//  public void sizeOfstateMessageMap()
//  {
//	  //size of stateMessageMap which contains (state, list of MessageTypes)
//	  Assert.assertEquals(12, PooledSM_NestedState_L1_2.stateMessageMap.size());
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  PooledSM_NestedState_L1_2 psm = new PooledSM_NestedState_L1_2();
//	  // check initial state is s1
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
//	 
//	  //event e1 is called
//	  psm.e1();// event e1 is added to the pool
//	  Thread.sleep(10);
//	  // event e1 is taken off the pool and is processed: transition to state s1a
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1a, psm.getSmS1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e2 is called
//	  psm.e2();// event e2 is added to the pool
//	  Thread.sleep(10);
//	  // event e2 is taken off the pool and is processed: transition to state s1b
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e1 is called
//	  psm.e1();// event e1 is added to the pool
//	  Thread.sleep(10);
//	  // event e1 is taken off the pool and is processed: transition to state s1a
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1a, psm.getSmS1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e2 is called
//	  psm.e2();// event e2 is added to the pool
//	  Thread.sleep(10);
//	  // event e2 is taken off the pool and is processed: transition to state s1b
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e3 is called
//	  psm.e3();// event e3 is added to the pool
//	  Thread.sleep(10);
//	  // event e3 is taken off the pool and is processed: transition to state s2
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s2, psm.getSm());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  	  
//	  //event e8 is called
//	  psm.e8();// event e8 is added to the pool
//	  Thread.sleep(10);
//	  //event e8 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s2, psm.getSm());
//	  //the pool has e8 event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event e8 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e8_M, msg.type);
//      }
//	  
//	  //event e9 is called
//	  psm.e9();// event e9 is added to the pool
//	  Thread.sleep(10);
//	  //event e9 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s2, psm.getSm());
//	  //the pool has e8,e9 event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());	  
//	  //check the pool to see if event e9 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e9_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e9_M, msg.type);
//		  }
//      }	  
//	  
//	  //event e5 is called
//	  psm.e5();// event e5 is added to the pool
//	  Thread.sleep(10);
//	  // event e5 is taken off the pool and is processed: transition to state s2b
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS2.s2b, psm.getSmS2());
//	  //the pool has e8,e9 event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());	  
//	  
//	  //event e6 is called
//	  psm.e6();// event e6 is added to the pool
//	  Thread.sleep(10);
//	  // event e6 is taken off the pool and is processed: transition to state s3
//	  // event e8 is taken off the pool and is processed: transition to state s1b
//	  // event e9 is taken off the pool and is processed: transition to state s3a
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1a, psm.getSmS1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());	  
//	  
//	  //event e4 is called
//	  psm.e4();// event e4 is added to the pool
//	  Thread.sleep(10);
//	  //event e4 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1a, psm.getSmS1());
//	  //the pool has e4 event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event e4 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e4_M, msg.type);
//      }
//	  
//	  //event e2 is called
//	  psm.e2();// event e2 is added to the pool
//	  Thread.sleep(10);
//	  // event e2 is taken off the pool and is processed: transition to state s1b
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4 event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  
//	  //event e7 is called
//	  psm.e7();// event e7 is added to the pool
//	  Thread.sleep(10);
//	  //event e7 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4,e7 event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  //check the pool to see if event e7 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e7_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e7_M, msg.type);
//		  }
//      }
//	  
//	  //event e1 is called
//	  psm.e1();// event e1 is added to the pool
//	  Thread.sleep(10);
//	  // event e1 is taken off the pool and is processed: transition to state s1a
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1a, psm.getSmS1());
//	  //the pool has e4,e7 event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  
//	  //event e2 is called
//	  psm.e2();// event e2 is added to the pool
//	  Thread.sleep(10);
//	  // event e2 is taken off the pool and is processed: transition to state s1b
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4,e7 event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  
//	  //event e6 is called
//	  psm.e6();// event e6 is added to the pool
//	  Thread.sleep(10);
//	  //event e6 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4,e7,e6 event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  //check the pool to see if event e6 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e6_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e6_M, msg.type);
//		  }
//      }
//	  
//	  //event e7 is called
//	  psm.e7();// event e7 is added to the pool
//	  Thread.sleep(10);
//	  //event e7 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4,e7,e6,e7 event saved at its head
//	  Assert.assertEquals(4, psm.pool.messages.size());
//	  //check the pool to see if event e7 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e7_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e7_M, msg.type);
//		  }
//      }
//      
//	  //event e9 is called
//	  psm.e9();// event e9 is added to the pool
//	  Thread.sleep(10);
//	  //event e9 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.SmS1.s1b, psm.getSmS1());
//	  //the pool has e4,e7,e6,e7,e9 event saved at its head
//	  Assert.assertEquals(5, psm.pool.messages.size());
//	  //check the pool to see if event e9 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e9_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e9_M, msg.type);
//		  }
//      }
//      
//	  //event e3 is called
//	  psm.e3();// event e3 is added to the pool
//	  Thread.sleep(10);
//	  // event e3 is taken off the pool and is processed: transition to state s2
//	  // event e4 is taken off the pool and is processed: transition to state s1
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
//	  //the pool has e7,e6,e7,e9 event saved at its head
//	  Assert.assertEquals(4, psm.pool.messages.size());
//	  
//	  //event e8 is called
//	  psm.e8();// event e8 is added to the pool
//	  Thread.sleep(10);
//	  //event e8 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
//	  //the pool has e7,e6,e7,e9,e8 event saved at its head
//	  Assert.assertEquals(5, psm.pool.messages.size());
//	  //check the pool to see if event e8 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e8_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e8_M, msg.type);
//		  }
//      }
//	  
//	  //event e3 is called
//	  psm.e3();// event e3 is added to the pool
//	  Thread.sleep(10);
//	  //event e3 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
//	  //the pool has e7,e6,e7,e9,e8,e3 event saved at its head
//	  Assert.assertEquals(6, psm.pool.messages.size());
//	  //check the pool to see if event e3 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e3_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e3_M, msg.type);
//		  }
//      }
//
//	  //event e5 is called
//	  psm.e5();// event e5 is added to the pool
//	  Thread.sleep(10);
//	  //event e5 is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s1, psm.getSm());
//	  //the pool has e7,e6,e7,e9,e8,e3,e5 event saved at its head
//	  Assert.assertEquals(7, psm.pool.messages.size());
//	  //check the pool to see if event e5 is saved in it
//	  for (PooledSM_NestedState_L1_2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L1_2.MessageType.e5_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L1_2.MessageType.e5_M, msg.type);
//		  }
//      }
//	  
//	  //event e2 is called
//	  psm.e2();// event e2 is added to the pool
//	  Thread.sleep(10);
//	  // event e2 is taken off the pool and is processed: transition to state s1b
//	  // event e3 is taken off the pool and is processed: transition to state s2
//	  // event e5 is taken off the pool and is processed: transition to state s2b
//	  // event e6 is taken off the pool and is processed: transition to state s3
//	  // event e7 is taken off the pool and is processed: transition to state s2
//	  Assert.assertEquals(PooledSM_NestedState_L1_2.Sm.s2, psm.getSm());
//	  //the pool has e7,e9,e8 event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//
//	  //check that there are three events left in the queue
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  
//  }
//}