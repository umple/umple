/*

Copyright 2010 Omar Badreddin, Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

Test class for code generation for state machines

*/

package cruise.umple.statemachine.implementation;

import org.junit.*;

public class StateMachineTest extends StateMachineTemplateTest
{

  @Test
  public void NoStates()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine."+ languagePath +".txt","Mentor");
  }

  @Test
  public void OneState()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine_OneState."+ languagePath +".txt","Student");
  }

  @Test
  public void TwoState()
  {
    assertUmpleTemplateFor("SimpleStateMachine.ump",languagePath + "/SimpleStateMachine_TwoStates."+ languagePath +".txt","Course");
  }

  @Test
  public void EventTransitionSameState()
  {
    assertUmpleTemplateFor("EventTransition.ump",languagePath + "/EventTransition."+ languagePath +".txt","Course");
  }
  
  @Test
  public void EventTransitionNewState()
  {
    assertUmpleTemplateFor("EventTransition.ump",languagePath + "/EventTransition_NewState."+ languagePath +".txt","Light");
  }  
  
  @Test
  public void EmptyAndNonEmptyStates()
  {
    assertUmpleTemplateFor("EmptyAndNonEmptyStates.ump",languagePath + "/EmptyAndNonEmptyStates."+ languagePath +".txt","Light");
  }   
  
  @Test
  public void oneGuard()
  {
    assertUmpleTemplateFor("oneGuard.ump",languagePath + "/oneGuard."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void multipleGuardsSameEvent()
  {
    assertUmpleTemplateFor("multipleGuardsSameEvent.ump",languagePath + "/multipleGuardsSameEvent."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void multipleGuardsSameEventWithDefaultNoGuard()
  {
    assertUmpleTemplateFor("multipleGuardsSameEventWithDefaultNoGuard.ump",languagePath + "/multipleGuardsSameEventWithDefaultNoGuard."+ languagePath +".txt","LightFixture");
  }
  
  @Test
  public void transitionAction()
  {
    assertUmpleTemplateFor("transitionAction.ump",languagePath + "/transitionAction."+ languagePath +".txt","Course");
  }
  
  @Test 
  public void entryAction()
  {
    assertUmpleTemplateFor("entryAction.ump",languagePath + "/entryAction."+ languagePath +".txt","Light");
  }
  
  @Test
  public void doActivity()
  {
    assertUmpleTemplateFor("doActivity.ump",languagePath + "/doActivity."+ languagePath +".txt","Switch");
  }
  
  @Test
  public void doActivity_Multiple()
  {
    assertUmpleTemplateFor("doActivity.ump",languagePath + "/doActivityMultiple."+ languagePath +".txt","Lamp");
  }
  
  @Test 
  public void exitAction()
  {
    assertUmpleTemplateFor("exitAction.ump",languagePath + "/exitAction."+ languagePath +".txt","LightFixture");
  }

  @Test 
  public void entryExitTransitionAction()
  {
    assertUmpleTemplateFor("entryExitTransitionAction.ump",languagePath + "/entryExitTransitionAction."+ languagePath +".txt","LightFixture");
  }

  @Test 
  public void entryExitTransitionActionWithGuard()
  {
    assertUmpleTemplateFor("entryExitTransitionActionWithGuard.ump",languagePath + "/entryExitTransitionActionWithGuard."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void externalStateMachine()
  {
    assertUmpleTemplateFor("externalStateMachine.ump",languagePath + "/externalStateMachine."+ languagePath +".txt","Course");
  }
  
  @Test
  public void timedEvent()
  {
    assertUmpleTemplateFor("timedEvent.ump",languagePath + "/timedEvent."+ languagePath +".txt","Mentor");
  }

  @Test
  public void sameEvent_twoStates_differentStatemachines()
  {
    assertUmpleTemplateFor("sameEvent_twoStates_differentStatemachines.ump",languagePath + "/sameEvent_twoStates_differentStatemachines."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void nestedStates()
  {
    assertUmpleTemplateFor("nestedStates.ump",languagePath + "/nestedStates."+ languagePath +".txt","LightFixture");
  }

  @Test
  public void nestedStates_exitInnerBeforeOutter()
  {
    assertUmpleTemplateFor("nestedStates_exitInnerBeforeOutter.ump",languagePath + "/nestedStates_exitInnerBeforeOutter."+ languagePath +".txt","LightFixture");
  }


}
