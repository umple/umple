/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.Transition;
import cruise.umple.util.SampleFileWriter;

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
  
  @Test
  public void isAutoTransition()
  {
    Transition t = new Transition(from,too);
    Assert.assertEquals(false,t.isAutoTransition());
    t.setAutoTransition(true);
    Assert.assertEquals(true,t.isAutoTransition());
  }
  
  @Test
  public void createPlaceholder()
  {
    Transition t = Transition.createPlaceholder(too);
    Assert.assertEquals("null",t.getFromState().getName());
    Assert.assertEquals(too, t.getNextState());
  }
  
  @Test
  public void equalsChecksGuard()
  {
    Transition t = new Transition(from, too);
    Transition t2 =  new Transition(from, too);
    Transition t3 = Transition.createPlaceholder(too);

    t.setGuard(new Guard());
    UmpleClass uClass = new UmpleClass("Blah",new UmpleModel(new UmpleFile(SampleFileWriter.rationalize("test/cruise/umple/compiler"),"700_BasicConstraint3.ump")));
    Attribute x = new Attribute("x","String","","",false,uClass);
    Attribute y = new Attribute("y","String","","",false,uClass);
    t.getGuard().addElement(new ConstraintAttribute(x));
    t2.setGuard(new Guard());
    t2.getGuard().addElement(new ConstraintAttribute(x));
    Assert.assertEquals(t, t2);

    t3.setGuard(new Guard());
    t3.getGuard().addElement(new ConstraintAttribute(y));
    Assert.assertEquals(false, t.getGuard().equals(t3.getGuard()));
  
  }
  
  @Test
  public void equalsChecksEvent()
  {
    Transition t =  new Transition(from, too);
    Transition t2 =  new Transition(from, too);

    t.setEvent(new Event("e"));
    t2.setEvent(new Event("e"));
    
    Assert.assertEquals(t, t2);

    t2.setEvent(new Event("y"));
    Assert.assertEquals(false, t.equals(t2));
  }
  
  @Test
  public void equalsChecksAction()
  {
    Transition t =  new Transition(from, too);
    Transition t2 =  new Transition(from, too);

    t.setAction(new Action("a"));
    t2.setAction(new Action("a"));
    
    Assert.assertEquals(t, t2);

    t2.setAction(new Action("y"));
    Assert.assertEquals(false, t.equals(t2));
  }  
  
}
