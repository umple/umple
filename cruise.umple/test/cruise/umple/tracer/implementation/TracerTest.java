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
	public void ConsoleTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttribute.ump",languagePath + "/ConsoleTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_SingleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeWhere.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_SingleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeUntil.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_SingleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeAfter.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributePostCondition1()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributePostCondition1.ump",languagePath + "/ConsoleTracer_TraceSingleAttributePostCondition1."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributePostCondition2()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributePostCondition2.ump",languagePath + "/ConsoleTracer_TraceSingleAttributePostCondition2."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_SingleAttributePeriod()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributePeriod.ump",languagePath + "/ConsoleTracer_TraceSingleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeRecord1()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeRecord1.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeRecord1."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeRecord2()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeRecord2.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeRecord3()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeRecord3.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeRecord4()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeRecord4.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeRecord4."+ languagePath +".txt","Tracer");
	}	  
	
	@Test
	public void ConsoleTracer_SingleAttributeSet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeSet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_SingleAttributeGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeGet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeOnlyGet.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_SingleAttributeOccurences()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceSingleAttributeOccurences.ump",languagePath + "/ConsoleTracer_TraceSingleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributeSet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeSet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_MultipleAttributeGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeGet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeOnlyGet.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributeOccurences()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeOccurences.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributesPeriod()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributePeriod.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributesRecord1()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeRecord1.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeRecord1."+ languagePath +".txt","Tracer");
	}	
	
	@Test
	public void ConsoleTracer_MultipleAttributesRecord2()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeRecord2.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributesRecord3()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeRecord3.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributesRecord4()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeRecord4.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeRecord4."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttribute.ump",languagePath + "/ConsoleTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_MultipleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeWhere.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_MultipleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeAfter.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void ConsoleTracer_MultipleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributeUntil.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void ConsoleTracer_MultipleAttributePostCondition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceMultipleAttributePostCondition.ump",languagePath + "/ConsoleTracer_TraceMultipleAttributePostCondition."+ languagePath +".txt","Tracer");
	}
	
	//========= File tracer
	@Test
	public void FileTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttribute.ump",languagePath + "/FileTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeSet.ump",languagePath + "/FileTracer_TraceSingleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_SingleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeGet.ump",languagePath + "/FileTracer_TraceSingleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeOnlyGet.ump",languagePath + "/FileTracer_TraceSingleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeAfter.ump",languagePath + "/FileTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeUntil.ump",languagePath + "/FileTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeWhere.ump",languagePath + "/FileTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeOccurences()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeOccurences.ump",languagePath + "/FileTracer_TraceSingleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributePeriod()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributePeriod.ump",languagePath + "/FileTracer_TraceSingleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_SingleAttributeRecord1()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord1.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord1."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeRecord2()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord2.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeRecord3()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord3.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_SingleAttributeRecord4()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord4.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord4."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttribute.ump",languagePath + "/FileTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_MultipleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeSet.ump",languagePath + "/FileTracer_TraceMultipleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_MultipleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributeOnlyGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeOnlyGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeOnlyGet."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributesAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeAfter.ump",languagePath + "/FileTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_MultipleAttributesUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeUntil.ump",languagePath + "/FileTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void FileTracer_MultipleAttributesWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeWhere.ump",languagePath + "/FileTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributeOccurences()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeOccurences.ump",languagePath + "/FileTracer_TraceMultipleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributesPeriod()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributePeriod.ump",languagePath + "/FileTracer_TraceMultipleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributesRecord1()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord1.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord1."+ languagePath +".txt","Tracer");
	}	
	
	@Test
	public void FileTracer_MultipleAttributesRecord2()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord2.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributesRecord3()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord3.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void FileTracer_MultipleAttributesRecord4()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord4.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord4."+ languagePath +".txt","Tracer");
	}
	
	//========= String tracer
	@Test
	public void StringTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttribute.ump",languagePath + "/StringTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeAfter.ump",languagePath + "/StringTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeUntil.ump",languagePath + "/StringTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeWhere.ump",languagePath + "/StringTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test
	public void StringTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttribute.ump",languagePath + "/FileTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_MultipleAttributesAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeAfter.ump",languagePath + "/FileTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_MultipleAttributesUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeUntil.ump",languagePath + "/FileTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test
	public void StringTracer_MultipleAttributesWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeWhere.ump",languagePath + "/FileTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	//*******************************//
	//**** Trace State Machines *****//
	//****    Code Generation   *****//
	//*******************************//	

	//====== Console tracer
	@Test @Ignore
	public void ConsoleTracer_StateMachine()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateMachine.ump",languagePath + "/ConsoleTracer_TraceStateMachine."+ languagePath +".txt","GarageDoor");
	}
	
	@Test @Ignore
	public void ConsoleTracer_State()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceState.ump",languagePath + "/ConsoleTracer_TraceState."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore
	public void ConsoleTracer_EmptyAndNonEmptyStates()
	{
		assertUmpleTemplateFor("ConsoleTracer_EmptyAndNonEmptyStates.ump",languagePath + "/ConsoleTracer_EmptyAndNonEmptyStates."+ languagePath +".txt","Light");
	}
	
	@Test
	public void ConsoleTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryAction.ump",languagePath + "/ConsoleTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore
	public void ConsoleTracer_TraceStateEntryRecord()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test
	public void ConsoleTracer_TraceNestedStateEntryRecord()
	{
//		assertUmpleTemplateFor("ConsoleTracer_TraceNestedStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceNestedStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test
	public void ConsoleTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitAction.ump",languagePath + "/ConsoleTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	//====== File tracer
	@Test @Ignore
	public void FileTracer_State()
	{
		assertUmpleTemplateFor("FileTracer_TraceState.ump",languagePath + "/FileTracer_TraceState."+ languagePath +".txt","GarageDoor");
	}
	
	@Test
	public void FileTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("FileTracer_TraceStateEntryAction.ump",languagePath + "/FileTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test
	public void FileTracer_TraceStateExitAction()
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
