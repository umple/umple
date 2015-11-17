/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerStateMachinesTest extends TracerAssociationsTest
{
	
	//------ Trace State Machines 
	
	@Test
	public void TraceGarageDoor()
	{
	  AssertStm("TraceGarageDoor.ump","TraceGarageDoor.");
	}
	
	@Test
	public void TraceGarageDoorOneState()
	{
	  AssertStm("TraceGarageDoorOneState.ump","TraceGarageDoorOneState.");
	}
	
	@Test
	public void TraceGarageDoorEntryState()
	{
	  AssertStm("TraceGarageDoorEntryState.ump","TraceGarageDoorEntryState.");
	}
	
	@Test
	public void TraceGarageDoorExitState()
	{
	  AssertStm("TraceGarageDoorExitState.ump","TraceGarageDoorExitState.");
	}
	
	@Test
	public void TraceLightDoActivity()
	{
	  AssertStm("TraceLightDoActivity.ump","TraceLightDoActivity.");
	}
	
	@Test
	public void TraceNestedStates()
	{
	  AssertStm("TraceNestedStates.ump","TraceNestedStates.");
	}
	
	@Test @Ignore
	public void TraceNestedStatesB()
	{
	  AssertStm("TraceNestedStatesB.ump","TraceNestedStatesB.");
	}
	
	@Test
	public void TraceDeepNestedStates()
	{
	  AssertStm("TraceDeepNestedStates.ump","TraceDeepNestedStates.");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel1()
	{
	  AssertStm("TraceDeepNestedStatesLevel1.ump","TraceDeepNestedStatesLevel1.");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel2()
	{
	  AssertStm("TraceDeepNestedStatesLevel2.ump","TraceDeepNestedStatesLevel2.");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel4()
	{
	  AssertStm("TraceDeepNestedStatesLevel4.ump","TraceDeepNestedStatesLevel4.");
	}
	
	@Test
	public void TraceState()
	{
	  AssertStm("TraceState.ump","TraceState.");
	}

	@Test
	public void TraceEvent()
	{
	  AssertStm("TraceEvent.ump","TraceEvent.");
	}
	
	@Test @Ignore
	public void TraceConcurrentStmA()
	{
	  AssertStm("TraceConcurrentStmA.ump","TraceConcurrentStmA.");
	}
	
	//-------- LightBulb trace tests
	
	@Test
	public void TraceLightBulbState()
	{
	  AssertStm("TraceLightBulbState.ump","TraceLightBulbState.","LightBulb");
	}
	
	@Test
	public void TraceLightBulbEvent()
	{
	  AssertStm("TraceLightBulbEvent.ump","TraceLightBulbEvent.","LightBulb");
	}
	
	@Test
	public void TraceLightBulbPostfix()
	{
	  AssertStm("TraceLightBulbPostfix.ump","TraceLightBulbPostfix.","LightBulb");
	}
	
	//-------- Events with Parameters trace tests
	
	@Test
	public void TraceEventParameter()
	{
	  AssertStm("TraceEventParameter.ump","TraceEventParameter.");
	}
	
	@Test
	public void TraceEventParameterPostfix()
	{
	  AssertStm("TraceEventParameterPostfix.ump","TraceEventParameterPostfix.");
	}
	
	//-------- to be added
	
	@Test @Ignore
	public void TracePooledStateMachine()
	{
	  AssertStm("TracePooledStateMachine.ump","TracePooledStateMachine.");
	}
	
	@Test @Ignore
	public void ConsoleTracer_StateMachine()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateMachine.ump",languagePath + tracerPath + "/ConsoleTracer_TraceStateMachine."+ languagePath +".txt","GarageDoor");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceBigStateMachine()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceBigStateMachine.ump",languagePath + tracerPath + "/ConsoleTracer_TraceBigStateMachine."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceNestedStateEntryRecord()
	{
//	  Assert(".ump",".");
//		assertUmpleTemplateFor(path+"ConsoleTracer_TraceNestedStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceNestedStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}

	@Test @Ignore 
	public void TraceStateWhere()
	{
		assertUmpleTemplateFor("TraceStateWhere.ump",languagePath + tracerPath + "/TraceStateWhere."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceStateExitWhere()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitWhere.ump",languagePath + "/ConsoleTracer_TraceStateExitWhere."+ languagePath +".txt","Light");
	}
		
	@Test @Ignore 
	public void ConsoleTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitAction.ump",languagePath + tracerPath + "/ConsoleTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceTransition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceTransition.ump",languagePath + tracerPath + "/ConsoleTracer_TraceTransition."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceStateRecordAttr()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateRecordAttr.ump",languagePath + "/ConsoleTracer_TraceStateRecordAttr."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceStateRecordAttr2()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateRecordAttr2.ump",languagePath + "/ConsoleTracer_TraceStateRecordAttr2."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceTransitionRecordAttr()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceTransitionRecordAttr.ump",languagePath + "/ConsoleTracer_TraceTransitionRecordAttr."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore
	public void TraceSupportFileTracer()
	{
	    assertUmpleTemplateFor("FileTracer.ump",languagePath + "/FileTracer."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test @Ignore
	public void TraceSupportStringTracer()
	{
	    assertUmpleTemplateFor("StringTracer.ump",languagePath + "/StringTracer."+ languagePath +".txt","Tracer");
	}
	
	//***************************//
	//****    Systems        ****//
	//***************************//
	
	@Test
	public void ConsoleTracer_Phone()
	{
		AssertStm("Phone.ump","PhoneLine.","PhoneLine");
		AssertStm("Phone.ump","PhoneSystemSimulation.","PhoneSystemSimulation");
	}
	
	
  public void AssertStm( String inputUmplefile, String expectedOutputFile)
  {   
    assertUmpleTemplateFor( "statemachines/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        "Tracer",
        false);
  }
  
  public void AssertStm( String inputUmplefile, String expectedOutputFile, String className)
  {   
    assertUmpleTemplateFor( "statemachines/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        className,
        false);
  }
}
