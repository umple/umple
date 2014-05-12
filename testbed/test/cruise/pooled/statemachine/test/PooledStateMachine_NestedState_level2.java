package cruise.pooled.statemachine.test;

import org.junit.Assert;
import org.junit.Test;

public class PooledStateMachine_NestedState_level2
{ 
  @Test 
  public void numberOfMessagesInMessageType()
  {
	  // compare the number of messages in MessageType is equal to the number of events in State Machine except timed events and auto-transition
	  Assert.assertEquals(9, PooledSM_NestedState_L2.MessageType.values().length);
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("e_M").equals(PooledSM_NestedState_L2.MessageType.e_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("f_M").equals(PooledSM_NestedState_L2.MessageType.f_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("g_M").equals(PooledSM_NestedState_L2.MessageType.g_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("h_M").equals(PooledSM_NestedState_L2.MessageType.h_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("i_M").equals(PooledSM_NestedState_L2.MessageType.i_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("j_M").equals(PooledSM_NestedState_L2.MessageType.j_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("k_M").equals(PooledSM_NestedState_L2.MessageType.k_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("m_M").equals(PooledSM_NestedState_L2.MessageType.m_M));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.MessageType.valueOf("null_M").equals(PooledSM_NestedState_L2.MessageType.null_M));
  }
  
  @Test 
  public void numberOfKeysInstateMessageMap()
  {
	  // compare the number of states is equal to the number of keys in stateMessageMap
	  Assert.assertEquals((PooledSM_NestedState_L2.Sm1S2.values().length+PooledSM_NestedState_L2.Sm1.values().length+PooledSM_NestedState_L2.Sm1S1.values().length+PooledSM_NestedState_L2.Sm1S2S2b.values().length), PooledSM_NestedState_L2.stateMessageMap.keySet().size());
	  Assert.assertEquals(11, PooledSM_NestedState_L2.stateMessageMap.keySet().size());
  }
  
  @Test 
  public void eachStateOfStateMachineAddedTostateMessageMap()
  {
	  //check that every state of SM it is put in stateMessageMap
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1.s1));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1.s2));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.s1a));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S1.s1b));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.s2a));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2.s2b));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.Null));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.s2b1));
	  Assert.assertEquals(true, PooledSM_NestedState_L2.stateMessageMap.containsKey(PooledSM_NestedState_L2.Sm1S2S2b.s2b2));
  }
  
  @Test 
  public void everyStateHasListOfMessages()
  {
	  //check that every state has its list Of messages
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null).size());
	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a).size());
	  Assert.assertEquals(3, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null).size());
	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a).size());
	  Assert.assertEquals(2, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).size());
	  Assert.assertEquals(1, PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b2).size());
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s1)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1.s2)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S1.s1b)));
      Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2a)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2.s2b)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.Null)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1)));
	  Assert.assertEquals(true , PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b1).containsAll(PooledSM_NestedState_L2.stateMessageMap.get(PooledSM_NestedState_L2.Sm1S2S2b.s2b2)));
  }
  
  @Test 
  public void sizeOfstateMessageMap()
  {
	  //size of stateMessageMap which contains (state, list of MessageTypes)
	  Assert.assertEquals(11, PooledSM_NestedState_L2.stateMessageMap.size());
  }
  
  @Test 
  public void processEvents() throws InterruptedException
  {
	  PooledSM_NestedState_L2 psm = new PooledSM_NestedState_L2();
	  // check initial state is s1
	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
	 
	  psm.g();// event g is called and is added to the pool
	  // event g is taken off the pool and is processed: transition to state s1a
	  // Now, the pool is empty
	  psm.e();// event e is called and is added to the pool
	  // event e is taken off the pool and is processed: transition to state s2
	  // Now, the pool is empty
	  psm.f();// event f is called and is added to the pool
	  // event f is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has f event saved at its head
	  // Now, the size of pool is 1
	  psm.j();// event j is called and is added to the pool
	  // event j is taken off the pool and is processed: transition to state s1b 
	  // The pool has f event saved at its head
	  // Now, the size of pool is 1
	  psm.i();// event i is called and is added to the pool
	  // event i is taken off the pool and is processed: transition to state s2b 
	  // The pool has f event saved at its head
	  // Now, the size of pool is 1
	  psm.k();// event k is called and is added to the pool
	  // event k is taken off the pool and is processed: transition to state s1 
	  // event f is taken off the pool and is processed: transition to state s2b
	  // Now, the pool is empty
	  psm.e();// event e is called and is added to the pool
	  // event e is taken off the pool and is processed: transition to state s1 
	  // Now, the pool is empty
	  psm.e();// event e is called and is added to the pool
	  // event e is taken off the pool and is processed: transition to state s2 
	  // Now, the pool is empty
	  psm.h();// event h is called and is added to the pool
	  // event h is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has h event saved at its head
	  // Now, the size of pool is 1
	  psm.m();// event m is called and is added to the pool
	  // event m is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has h,and m events saved at its head
	  // Now, the size of pool is 2: h,and m
	  psm.i();// event i is called and is added to the pool
	  // event i is taken off the pool and is processed: transition to state s2b 
	  // event h is taken off the pool and is processed: transition to state s2a
	  // The pool has m event saved at its head
	  // Now, the size of pool is 1: m 
	  psm.h();// event h is called and is added to the pool
	  // event h is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has m, and h events saved at its head
	  // Now, the size of pool is 2: m, and h
	  psm.k();// event k is called and is added to the pool
	  // event  is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has m,h,k event saved at its head
	  // Now, the size of pool is 3: m, h, and k
	  psm.k();// event k is called and is added to the pool
	  // event  is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has m,h,k,k event saved at its head
	  // Now, the size of pool is 4: m, h, k and k
	  psm.f();// event f is called and is added to the pool
	  // event  is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has m,h,k,k,f event saved at its head
	  // Now, the size of pool is 5: m, h, k, k and f
	  psm.g();// event g is called and is added to the pool
	  // event g is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has m,h,k,k,f,g event saved at its head
	  // Now, the size of pool is 6: m, h, k, k, f and g
	  psm.e();// event e is called and is added to the pool
	  // event e is taken off the pool and is processed: transition to state s1 
	  // event f is taken off the pool and is processed: transition to state s2b 
	  // event m is taken off the pool and is processed: transition to state s2b2 
	  // event h is taken off the pool and is processed: transition to state s2a 
	  // The pool has k,k,g event saved at its head
	  // Now, the size of pool is 3: k, k and g
	  psm.i();// event i is called and is added to the pool
	  // event i is taken off the pool and is processed: transition to state s2b 
	  // event k is taken off the pool and is processed: transition to state s1 
	  // event g is taken off the pool and is processed: transition to state s1a 
	  // The pool has k event saved at its head
	  // Now, the size of pool is 1: k
	  psm.k();// event k is called and is added to the pool
	  // event k is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has k, and k events saved at its head
	  // Now, the size of pool is 2: k, and k
	  psm.j();// event j is called and is added to the pool
	  // event j is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has k,k, and j event saved at its head
	  // Now, the size of pool is 3: k, k and j
	  psm.g();// event g is called and is added to the pool
	  // event g is taken off the pool and is processed: transition to state s1a 
	  // The pool has k,k, and j events saved at its head
	  // Now, the size of pool is 3: k,k  and j
	  psm.f();// event f is called and is added to the pool
	  // event f is taken off the pool and is processed: transition to state s2b 
	  // event k is taken off the pool and is processed: transition to state s1a 
	  // The pool has k,j event saved at its head
	  // Now, the size of pool is 2: k and j
	  psm.m();// event m is called and is added to the pool
	  // event m is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has k,j,m event saved at its head
	  // Now, the size of pool is 3: k, j and m
	  psm.m();// event m is called and is added to the pool
	  // event m is unspecified, it is saved at the head of the pool, current sate is not changed
	  // The pool has k,j,m,m event saved at its head
	  // Now, the size of pool is 4: k, j, m and m
	  psm.g();// event g is called and is added to the pool
	  // event g is taken off the pool and is processed: transition to state  s1
	  // The pool has k,j,m,m event saved at its head
	  // Now, the size of pool is 4: k, j, m and m
	  psm.f();// event f is called and is added to the pool
	  // event f is taken off the pool and is processed: transition to state s2b 
	  // event k is taken off the pool and is processed: transition to state s1 
      // The pool has j,m,m event saved at its head
	  // Now, the size of pool is 3: k, m and m
	  psm.f();// event f is called and is added to the pool
	  // event f is taken off the pool and is processed: transition to state s2b
	  // event m is taken off the pool and is processed: transition to state s2b2 
	  // event m is taken off the pool and is processed: transition to state s2b1 
	  // The pool has j event saved at its head
	  // Now, the size of pool is 1: j
	  psm.h();// event h is called and is added to the pool
	  // event h is taken off the pool and is processed: transition to state s2a
	  // event j is taken off the pool and is processed: transition to state s1b 
	  // Now, the pool is empty

	  
	  // Check that the pool does not have events
	  while(!psm.pool.messages.isEmpty())
	  {
		  Thread.sleep(10);
	  }

	  // There is not any event left in the pool
	  Assert.assertEquals(0, psm.pool.messages.size());
	  
	  // Check the current state is s1 and the current substate is s1b
	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1.s1, psm.getSm1());
	  Assert.assertEquals(PooledSM_NestedState_L2.Sm1S1.s1b, psm.getSm1S1());

  }
}