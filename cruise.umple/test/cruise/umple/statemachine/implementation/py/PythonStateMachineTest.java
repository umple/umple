package cruise.umple.statemachine.implementation.py;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.compiler.Event;

public class PythonStateMachineTest extends StateMachineTest
{
 @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  

  @Test
  @Override
  public void testTwoParameterGuard_1()
  {
    assertUmpleTemplateFor(languagePath + "/testTwoParameterGuardPython.ump",languagePath + "/testTwoParameterGuard."+ languagePath +".txt","A_Guard");
  }

  @Override
  @Test
  public void guardNameBothAttributeAndMethod()
  {
	// Reset autotransition counter so isn't carried over to the next test (it's passed from the java test to the php test)
	Event.setNextAutoTransitionId(1); 
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethodPython.ump",languagePath + "/guardNameBothAttributeAndMethod."+ languagePath +".txt","A");
	Event.setNextAutoTransitionId(1); 
  }
  
  @Override
  @Test
  public void guardNameBothAttributeAndMethod2()
  {
	Event.setNextAutoTransitionId(1); 
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethod2Python.ump",languagePath + "/guardNameBothAttributeAndMethod2."+ languagePath +".txt","A");
    Event.setNextAutoTransitionId(1);
  }
  

  @Override
  @Test
  public void guardNameBothAttributeAndMethod3()
  {
	Event.setNextAutoTransitionId(1); 
	assertUmpleTemplateFor(languagePath + "/guardNameBothAttributeAndMethod3Python.ump",languagePath + "/guardNameBothAttributeAndMethod3."+ languagePath +".txt","A");
    Event.setNextAutoTransitionId(1);
  }

  @Override
  @Test
  public void doActivity()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityPython.ump",languagePath + "/doActivity."+ languagePath +".txt","Switch");
  }

  @Override
  @Test
  public void doActivity_Multiple()
  {
    assertUmpleTemplateFor(languagePath + "/doActivityPython.ump",languagePath + "/doActivityMultiple."+ languagePath +".txt","Lamp");
  }
}