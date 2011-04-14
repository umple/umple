package cruise.umple.compiler;

import org.junit.*;

public class TransitionTest
{

  StateMachine sm;
  State from;
  State too;
  
  @Before
  public void setUp()
  {
    sm = new StateMachine("sm");
    from = new State("from",sm);
    too = new State("too",sm);
  }
  
  @Test
  public void getIsInternal()
  {
    Transition t = new Transition(from,too);
    Assert.assertEquals(false,t.getIsInternal());
    t.setIsInternal(true);
    Assert.assertEquals(true,t.getIsInternal());
  }
  
}
