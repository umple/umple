package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_NestedState_level2
{ 
//  @Test 
//  public void numberOfMessagesInMessageType()
//  {
//	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
//	  Assert.assertEquals(9, PooledSM_NestedState_L2.MessageType.values().length);
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("e_M").equals(PooledSM_NestedState_L2.MessageType.e_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("f_M").equals(PooledSM_NestedState_L2.MessageType.f_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("g_M").equals(PooledSM_NestedState_L2.MessageType.g_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("h_M").equals(PooledSM_NestedState_L2.MessageType.h_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("i_M").equals(PooledSM_NestedState_L2.MessageType.i_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("j_M").equals(PooledSM_NestedState_L2.MessageType.j_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("k_M").equals(PooledSM_NestedState_L2.MessageType.k_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("m_M").equals(PooledSM_NestedState_L2.MessageType.m_M));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L2.MessageType.null_M));
//  }
//  
//  @Test 
//  public void numberOfKeysInstateMessageMap()
//  {
//	  // compare the number of states is equal to the number of keys in stateMessageMap
//	  Assert.assertEquals((PooledSM_NestedState_L2.Sm1S2.values().length+PooledSM_NestedState_L2.Sm1.values().length+PooledSM_NestedState_L2.Sm1S1.values().length+PooledSM_NestedState_L2.Sm1S2S2b.values().length), PooledSM_NestedState_L2.stateMessageMap.keySet().size());
//	  Assert.assertEquals(11, PooledSM_NestedState_L2.stateMessageMap.keySet().size());
//  }
//  
//  @Test 
//  public void eachStateOfStateMachineAddedTostateMessageMap()
//  {
//	  //check that every state of SM it is put in stateMessageMap
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1.s1));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1.s2));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.s1a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.s1b));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.s2a));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.s2b));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.Null));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.s2b1));
//	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.s2b2));
//  }
//  
//  @Test 
//  public void everyStateHasListOfMessages()
//  {
//	  //check that every state has its list Of messages
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null).size());
//	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a).size());
//	  Assert.assertEquals(3, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null).size());
//	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a).size());
//	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).size());
//	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b2).size());
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b)));
//      Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1)));
//	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b2)));
//  }
//  
//  @Test 
//  public void sizeOfstateMessageMap()
//  {
//	  //size of stateMessageMap which contains (state, list of MessageTypes)
//	  Assert.assertEquals(11, PooledSM_NestedState_L2.stateMessageMap.size());
//  }
//  
//  @Test 
//  public void processEvents() throws InterruptedException
//  {
//	  PooledSM_NestedState_L2 psm = new PooledSM_NestedState_L2();
//	  // check initial state is s1
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//	 
//	  //event g is called
//	  psm.g(); // event g is added to the pool
//	  Thread.sleep(10);
//	  // event g is taken off the pool and is processed: transition to state s1a
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e is called
//	  psm.e();//event e is added to the pool
//	  Thread.sleep(10);
//	  // event e is taken off the pool and is processed: transition to state s2 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s2, psm.getSm1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//      //event f is called
//	  psm.f();// event f is added to the pool
//	  Thread.sleep(10);
//	  //event f is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s2, psm.getSm1());
//	  //the pool has f event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event f is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.f_M, msg.type);
//      }
//	  
//	  //event j is called
//	  psm.j();// event j is added to the pool
//	  Thread.sleep(10);
//	  // event j is taken off the pool and is processed: transition to state s1b 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1b, psm.getSm1S1());
//	  //the pool has f event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	 
//	  //event i is called
//	  psm.i();// event i is added to the pool
//	  Thread.sleep(10);
//	  // event i is taken off the pool and is processed: transition to state s2b 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2b, psm.getSm1S2());
//	  //the pool has f event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  
//	  //event k is called
//	  psm.k();// event k is added to the pool
//	  Thread.sleep(10);
//	  // event k is taken off the pool and is processed: transition to state s1 
//	  // event f is taken off the pool and is processed: transition to state s2b
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2b, psm.getSm1S2());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	
//	  //event e is called
//	  psm.e();// event e is added to the pool
//	  Thread.sleep(10);
//	  // event e is taken off the pool and is processed: transition to state s1 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event e is called
//	  psm.e();// event e is added to the pool
//	  Thread.sleep(10);
//	  // event e is taken off the pool and is processed: transition to state s2 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s2, psm.getSm1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  //event h is called
//	  psm.h();// event h is added to the pool
//	  Thread.sleep(10);
//	  //event h is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s2, psm.getSm1());
//	  //the pool has h event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event h is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.h_M, msg.type);
//      }
//	  
//	  //event m is called
//	  psm.m();// event m is added to the pool
//	  Thread.sleep(10);
//	  //event m is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s2, psm.getSm1());
//	  //the pool has h,m event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.m_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.m_M, msg.type);
//		  }
//      }
//	  
//	  //event i is called
//	  psm.i();// event i is added to the pool
//	  Thread.sleep(10);
//	  // event i is taken off the pool and is processed: transition to state s2b 
//	  // event h is taken off the pool and is processed: transition to state s2a
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());	  
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.m_M, msg.type);
//      }	  
//	  
//	  //event h is called
//	  psm.h();// event h is added to the pool
//	  Thread.sleep(10);
//	  //event  is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m,h event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());	  
//	  //check the pool to see if event h is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.h_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.h_M, msg.type);
//		  }
//      }
//	  
//	  //event k is called
//	  psm.k();// event k is added to the pool
//	  Thread.sleep(10);
//	  //event  is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m,h,k event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());	  
//	  //check the pool to see if event k is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.k_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.k_M, msg.type);
//		  }
//      }
//	  
//	  //event k is called
//	  psm.k();// event k is added to the pool
//	  Thread.sleep(10);
//	  //event  is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m,h,k,k event saved at its head
//	  Assert.assertEquals(4, psm.pool.messages.size());	  
//	  //check the pool to see if event k is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.k_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.k_M, msg.type);
//		  }
//      }
//	  
//	  //event f is called
//	  psm.f();// event f is added to the pool
//	  Thread.sleep(10);
//	  //event  is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m,h,k,k,f event saved at its head
//	  Assert.assertEquals(5, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.f_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.f_M, msg.type);
//		  }
//      }
//	  
//	  //event g is called
//	  psm.g();// event g is added to the pool
//	  Thread.sleep(10);
//	  //event g is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has m,h,k,k,f,g event saved at its head
//	  Assert.assertEquals(6, psm.pool.messages.size());
//	  //check the pool to see if event g is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.g_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.g_M, msg.type);
//		  }
//      }
//	  
//	  //event e is called
//	  psm.e();// event e is added to the pool
//	  Thread.sleep(10);
//	  // event e is taken off the pool and is processed: transition to state s1 
//	  // event f is taken off the pool and is processed: transition to state s2b 
//	  // event m is taken off the pool and is processed: transition to state s2b2 
//	  // event h is taken off the pool and is processed: transition to state s2a 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2a, psm.getSm1S2());
//	  //the pool has k,k,g event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  
//	  //event i is called
//	  psm.i();// event i is added to the pool
//	  Thread.sleep(10);
//	  // event i is taken off the pool and is processed: transition to state s2b 
//	  // event k is taken off the pool and is processed: transition to state s1 
//	  // event g is taken off the pool and is processed: transition to state s1a 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  //the pool has k event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.k_M, msg.type);
//      }
//	  
//	  //event k is called
//	  psm.k();// event k is added to the pool
//	  Thread.sleep(10);
//	  //event k is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  //the pool has k,k event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  //check the pool to see if event k is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.k_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.k_M, msg.type);
//		  }
//      }
//	  
//	  //event j is called
//	  psm.j();// event j is added to the pool
//	  Thread.sleep(10);
//	  //event j is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  //the pool has k,k,j event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  //check the pool to see if event j is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.j_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.j_M, msg.type);
//		  }
//      }
//      
//	  //event g is called
//	  psm.g();// event g is added to the pool
//	  Thread.sleep(10);
//	  // event g is taken off the pool and is processed: transition to state s1a 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  //the pool has k,k,j event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//      
//	  //event f is called
//	  psm.f();// event f is added to the pool
//	  Thread.sleep(10);
//	  // event f is taken off the pool and is processed: transition to state s2b 
//	  // event k is taken off the pool and is processed: transition to state s1a 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1a, psm.getSm1S1());
//	  //the pool has k,j event saved at its head
//	  Assert.assertEquals(2, psm.pool.messages.size());
//	  
//	  //event m is called
//	  psm.m();// event m is added to the pool
//	  Thread.sleep(10);
//	  //event m is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//	  //the pool has k,j,m event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.m_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.m_M, msg.type);
//		  }
//      }
//	  
//	  //event m is called
//	  psm.m();// event m is added to the pool
//	  Thread.sleep(10);
//	  //event m is unspecified, it is saved at the head of the queue, current sate is not changed
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//	  //the pool has k,j,m,m event saved at its head
//	  Assert.assertEquals(4, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  if(msg.type.equals(PooledSM_NestedState_L2.MessageType.m_M))
//		  {
//			  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.m_M, msg.type);
//		  }
//      }
//	  
//	  //event g is called
//	  psm.g();// event g is added to the pool
//	  Thread.sleep(10);
//	  // event g is taken off the pool and is processed: transition to state  s1
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//	  //the pool has k,j,m,m event saved at its head
//	  Assert.assertEquals(4, psm.pool.messages.size());
//	  
//	  //event f is called
//	  psm.f();// event f is added to the pool
//	  Thread.sleep(10);
//	  // event f is taken off the pool and is processed: transition to state s2b 
//	  // event k is taken off the pool and is processed: transition to state s1 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
//      //the pool has j,m,m event saved at its head
//	  Assert.assertEquals(3, psm.pool.messages.size());
//	  
//	  //event f is called
//	  psm.f();// event f is added to the pool
//	  Thread.sleep(10);
//	  // event f is taken off the pool and is processed: transition to state s2b
//	  // event m is taken off the pool and is processed: transition to state s2b2 
//	  // event m is taken off the pool and is processed: transition to state s2b1 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S2.s2b, psm.getSm1S2());
//	  //the pool has j event saved at its head
//	  Assert.assertEquals(1, psm.pool.messages.size());
//	  //check the pool to see if event m is saved in it
//	  for (PooledSM_NestedState_L2.Message msg: psm.pool.messages)
//      {
//		  Assert.assertEquals(PooledSM_NestedState_L2.MessageType.j_M, msg.type);
//      }
//	  
//	  //event h is called
//	  psm.h();// event h is added to the pool
//	  Thread.sleep(10);
//	  // event h is taken off the pool and is processed: transition to state s2a
//	  // event j is taken off the pool and is processed: transition to state s1b 
//	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1b, psm.getSm1S1());
//	  // pool is empty
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//	  
//	  //check that there is no events left in the queue
//	  Assert.assertEquals(0, psm.pool.messages.size());
//	  
//  }
}