/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

public class TracerTest extends TracerTemplateTest
{
	
	//***************************//
	
	 
	@Test  
	public void TraceSupportFileTracer()
	{
	    assertUmpleTemplateFor("FileTracer.ump",languagePath + "/FileTracer."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportStringTracer()
	{
	    assertUmpleTemplateFor("StringTracer.ump",languagePath + "/StringTracer."+ languagePath +".txt","Tracer");
	}
		
	//***************************//
	//**** Trace Attributes *****//
	//**** Code Generation  *****//
	//***************************//
		

	//====== Console tracer
	@Test
	public void TraceSupportSingleAttribute()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttribute.ump",languagePath + "/ConsoleTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportSingleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeWhere.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportSingleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeUntil.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportSingleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeAfter.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore
	public void TraceSupportSingleAttributePeriod()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributePeriod.ump",languagePath + "/ConsoleTracer_TraceSingleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupportSingleAttributeRecord()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeRecord.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeRecord."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TracesSupportMultipleAttributes()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttribute.ump",languagePath + "/ConsoleTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportMultipleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeWhere.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportMultipleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeAfter.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportMultipleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeUntil.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupportSingleAttributeSet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeSet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportSingleAttributeGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeGet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupportSingleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeOnlyGet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupportMultipleAttributeSet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeSet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupportMultipleAttributeGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeGet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupportMultipleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeOnlyGet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	//========= File tracer
	@Test
	public void TraceSupport_FileTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttribute.ump",languagePath + "/FileTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_FileTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeAfter.ump",languagePath + "/FileTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_FileTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeUntil.ump",languagePath + "/FileTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_FileTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeWhere.ump",languagePath + "/FileTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TracesSupport_FileTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttribute.ump",languagePath + "/FileTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TracesSupport_FileTracer_MultipleAttributesAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeAfter.ump",languagePath + "/FileTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TracesSupport_FileTracer_MultipleAttributesUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeUntil.ump",languagePath + "/FileTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TracesSupport_FileTracer_MultipleAttributesWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeWhere.ump",languagePath + "/FileTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupport_FileTracer_SingleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeSet.ump",languagePath + "/FileTracer_TraceSingleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_FileTracer_SingleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeGet.ump",languagePath + "/FileTracer_TraceSingleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupport_FileTracer_SingleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeOnlyGet.ump",languagePath + "/FileTracer_TraceSingleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupport_FileTracer_MultipleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeSet.ump",languagePath + "/FileTracer_TraceMultipleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_FileTracer_MultipleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupport_FileTracer_MultipleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeOnlyGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	//========= String tracer
	@Test
	public void TraceSupport_StringTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttribute.ump",languagePath + "/StringTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeAfter.ump",languagePath + "/StringTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeUntil.ump",languagePath + "/StringTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeWhere.ump",languagePath + "/StringTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void TraceSupport_StringTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttribute.ump",languagePath + "/FileTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_MultipleAttributesAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeAfter.ump",languagePath + "/FileTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_MultipleAttributesUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeUntil.ump",languagePath + "/FileTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void TraceSupport_StringTracer_MultipleAttributesWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeWhere.ump",languagePath + "/FileTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	
	//*******************************//
	//**** Trace State Machines *****//
	//****    Code Generation   *****//
	//*******************************//	

	//====== Console tracer
	@Test @Ignore
	public void TraceSupport_ConsoleTracer_StateMachine()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateMachine.ump",languagePath + "/ConsoleTracer_TraceStateMachine."+ languagePath +".txt","GarageDoor");
	}
	
	@Test @Ignore
	public void TraceSupport_ConsoleTracer_State()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceState.ump",languagePath + "/ConsoleTracer_TraceState."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore
	public void TraceSupport_ConsoleTracer_EmptyAndNonEmptyStates()
	{
		assertUmpleTemplateFor("ConsoleTracer_EmptyAndNonEmptyStates.ump",languagePath + "/ConsoleTracer_EmptyAndNonEmptyStates."+ languagePath +".txt","Light");
	}
	
	@Test
	public void TraceSupport_ConsoleTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryAction.ump",languagePath + "/ConsoleTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore
	public void TraceSupport_ConsoleTracer_TraceStateEntryRecord()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test
	public void TraceSupport_ConsoleTracer_TraceNestedStateEntryRecord()
	{
//		assertUmpleTemplateFor("ConsoleTracer_TraceNestedStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceNestedStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test
	public void TraceSupport_ConsoleTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitAction.ump",languagePath + "/ConsoleTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	//====== File tracer
	@Test @Ignore
	public void TraceSupport_FileTracer_State()
	{
		assertUmpleTemplateFor("FileTracer_TraceState.ump",languagePath + "/FileTracer_TraceState."+ languagePath +".txt","GarageDoor");
	}
	
	@Test
	public void TraceSupport_FileTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("FileTracer_TraceStateEntryAction.ump",languagePath + "/FileTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test
	public void TraceSupport_FileTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("FileTracer_TraceStateExitAction.ump",languagePath + "/FileTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	//***************************//
	//**** Trace Association ****//
	//****  Code Generation  ****//
	//***************************//
	  
	@Test @Ignore
	public void TracesSupportAssoiations()
	{
		assertUmpleTemplateFor("AssociationTrace.ump",languagePath + "/AssociationTrace."+ languagePath +".txt","Tracer");
	}
}
