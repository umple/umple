/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerStateMachinesTest extends TracerTemplateTest
{
	
	//------ Trace State Machines 
	
	@Test
	public void TraceGarageDoor()
	{
		assertUmpleTemplateFor("TraceGarageDoor.ump",languagePath + tracerPath+"/TraceGarageDoor."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceGarageDoorOneState()
	{
		assertUmpleTemplateFor("TraceGarageDoorOneState.ump",languagePath + tracerPath+"/TraceGarageDoorOneState."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceGarageDoorEntryState()
	{
		assertUmpleTemplateFor("TraceGarageDoorEntryState.ump",languagePath + tracerPath+"/TraceGarageDoorEntryState."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceGarageDoorExitState()
	{
		assertUmpleTemplateFor("TraceGarageDoorExitState.ump",languagePath + tracerPath+"/TraceGarageDoorExitState."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceLightDoActivity()
	{
		assertUmpleTemplateFor("TraceLightDoActivity.ump",languagePath + tracerPath+"/TraceLightDoActivity."+ languagePath +".txt","LightFixtureA");
	}
	
	@Test
	public void TraceNestedStates()
	{
		assertUmpleTemplateFor("TraceNestedStates.ump",languagePath + tracerPath+"/TraceNestedStates."+ languagePath +".txt","LightFixture");
	}
	
	@Test @Ignore
	public void TraceNestedStatesB()
	{
		assertUmpleTemplateFor("TraceNestedStatesB.ump",languagePath + tracerPath+"/TraceNestedStatesB."+ languagePath +".txt","LightFixture");
	}
	
	@Test
	public void TraceDeepNestedStates()
	{
		assertUmpleTemplateFor("TraceDeepNestedStates.ump",languagePath + tracerPath+"/TraceDeepNestedStates."+ languagePath +".txt","NestedState");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel1()
	{
		assertUmpleTemplateFor("TraceDeepNestedStatesLevel1.ump",languagePath + tracerPath+"/TraceDeepNestedStatesLevel1."+ languagePath +".txt","NestedState");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel2()
	{
		assertUmpleTemplateFor("TraceDeepNestedStatesLevel2.ump",languagePath + tracerPath+"/TraceDeepNestedStatesLevel2."+ languagePath +".txt","NestedState");
	}
	
	@Test
	public void TraceDeepNestedStatesLevel4()
	{
		assertUmpleTemplateFor("TraceDeepNestedStatesLevel4.ump",languagePath + tracerPath+"/TraceDeepNestedStatesLevel4."+ languagePath +".txt","NestedState");
	}
	
	@Test
	public void TraceState()
	{
		assertUmpleTemplateFor("TraceState.ump",languagePath + tracerPath+"/TraceState."+ languagePath +".txt","Light");
	}

	@Test
	public void TraceTransition()
	{
		assertUmpleTemplateFor("TraceTransition.ump",languagePath + tracerPath+ "/TraceTransition."+ languagePath +".txt","GarageDoor");
	}
	
	@Test
	public void TracePooledStateMachine()
	{
		assertUmpleTemplateFor("TracePooledStateMachine.ump",languagePath + tracerPath+"/TracePooledStateMachine."+ languagePath +".txt","Course");
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
//		assertUmpleTemplateFor("ConsoleTracer_TraceNestedStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceNestedStateEntryRecord."+ languagePath +".txt","StateMachineTest");
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
	//**** Trace Examples    ****//
	//***************************//
	@Test @Ignore 
	public void ConsoleTracer_Phone()
	{
		assertUmpleTemplateFor("Phone.ump",languagePath + "/Phone."+ languagePath +".txt","PhoneLine");
	}
	
}
