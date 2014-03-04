/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

import cruise.umple.implementation.TemplateTest;

@Ignore
public class TracerTest extends TracerTemplateTest
{
		
	//------ Trace Attributes 
	
	@Test 
	public void SingleAttribute()
	{
		assertUmpleTemplateFor("TraceSingleAttribute.ump",languagePath + tracerPath+"TraceSingleAttribute."+ languagePath +".txt","Tracer",false);
	}
	
	@Test 
	public void TraceAttributeWildcard()
	{
		assertUmpleTemplateFor("TraceAttributeWilcard.ump",languagePath + tracerPath+"TraceAttributeWildcard."+ languagePath +".txt","Tracer",false);
	}
	
	@Test
	public void SingleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("TraceSingleAttributeWhere.ump",languagePath + tracerPath+"TraceSingleAttributeWhere."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test
	public void SingleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("TraceSingleAttributeUntil.ump",languagePath + tracerPath+"TraceSingleAttributeUntil."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test
	public void SingleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("TraceSingleAttributeAfter.ump",languagePath + tracerPath+"TraceSingleAttributeAfter."+ languagePath +".txt","Tracer",false);
	}
	
	@Test
	public void SingleAttributePostCondition()
	{
		assertUmpleTemplateFor("TraceSingleAttributePostCondition.ump",languagePath + tracerPath+"TraceSingleAttributePostCondition."+ languagePath +".txt","Tracer",false);
	}
	
	@Test @Ignore
	public void SingleAttributePeriod()
	{
		assertUmpleTemplateFor("TraceSingleAttributePeriod.ump",languagePath + tracerPath+"TraceSingleAttributePeriod."+ languagePath +".txt","Tracer",false);
	}
	
//	@Test
//	public void SingleAttributeRecord1()
//	{
//		assertUmpleTemplateFor("TraceSingleAttributeRecord1.ump",languagePath + tracerPath+"TraceSingleAttributeRecord1."+ languagePath +".txt","Tracer",false);
//	}
//	
//	@Test
//	public void SingleAttributeRecord2()
//	{
//		assertUmpleTemplateFor("TraceSingleAttributeRecord2.ump",languagePath + tracerPath+"TraceSingleAttributeRecord2."+ languagePath +".txt","Tracer",false);
//	}
//	
//	@Test
//	public void SingleAttributeRecord3()
//	{
//		assertUmpleTemplateFor("TraceSingleAttributeRecord3.ump",languagePath + tracerPath+"TraceSingleAttributeRecord3."+ languagePath +".txt","Tracer",false);
//	}
//	
//	@Test
//	public void SingleAttributeRecord4()
//	{
//		assertUmpleTemplateFor("TraceSingleAttributeRecord4.ump",languagePath + tracerPath+"TraceSingleAttributeRecord4."+ languagePath +".txt","Tracer",false);
//	}	  
	
	@Test
	public void SingleAttributeSet()
	{
		assertUmpleTemplateFor("TraceSingleAttributeSet.ump",languagePath + tracerPath+"TraceSingleAttributeSet."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test
	public void SingleAttributeGet()
	{
		assertUmpleTemplateFor("TraceSingleAttributeGet.ump",languagePath + tracerPath+"TraceSingleAttributeGet."+ languagePath +".txt","Tracer",false);
	}
	
	@Test
	public void SingleAttributeSetGet()
	{
		assertUmpleTemplateFor("TraceSingleAttributeSetGet.ump",languagePath + tracerPath+"TraceSingleAttributeSetGet."+ languagePath +".txt","Tracer",false);
	}
	
	@Test @Ignore
	public void SingleAttributeOccurences()
	{
		assertUmpleTemplateFor("TraceSingleAttributeOccurences.ump",languagePath + tracerPath+"TraceSingleAttributeOccurences."+ languagePath +".txt","Tracer",false);
	}	  
	
	@Test  
	public void MultipleAttributes()
	{
		assertUmpleTemplateFor("TraceMultipleAttribute.ump",languagePath + tracerPath+"TraceMultipleAttribute."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test  
	public void MultipleAttributeWhereCondition()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeWhere.ump",languagePath + tracerPath+"TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test  
	public void MultipleAttributeAfterCondition()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeAfter.ump",languagePath + tracerPath+"TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	
	@Test  
	public void MultipleAttributeUntilCondition()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeUntil.ump",languagePath + tracerPath+"TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	
	@Test  
	public void MultipleAttributePostCondition()
	{
		assertUmpleTemplateFor("TraceMultipleAttributePostCondition.ump",languagePath + tracerPath+"TraceMultipleAttributePostCondition."+ languagePath +".txt","Tracer",false);
	}

	@Test
	public void MultipleAttributeSet()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeSet.ump",languagePath + tracerPath+"TraceMultipleAttributeSet."+ languagePath +".txt","Tracer",false);
	}
	  
	@Test
	public void MultipleAttributeGet()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeGet.ump",languagePath + tracerPath+"TraceMultipleAttributeGet."+ languagePath +".txt","Tracer",false);
	}
	
	@Test  
	public void MultipleAttributeSetGet()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeSetGet.ump",languagePath + tracerPath+"TraceMultipleAttributeSetGet."+ languagePath +".txt","Tracer",false);
	}
	
	@Test  
	public void MultipleAttributeOccurences()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeOccurences.ump",languagePath + tracerPath+"TraceMultipleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test  
	public void MultipleAttributesPeriod()
	{
		assertUmpleTemplateFor("TraceMultipleAttributePeriod.ump",languagePath + tracerPath+"TraceMultipleAttributePeriod."+ languagePath +".txt","Tracer",false);
	}
	
//	@Test  
//	public void MultipleAttributesRecord1()
//	{
//		assertUmpleTemplateFor("TraceMultipleAttributeRecord1.ump",languagePath + tracerPath+"TraceMultipleAttributeRecord1."+ languagePath +".txt","Tracer",false);
//	}	
//	
//	@Test  
//	public void MultipleAttributesRecord2()
//	{
//		assertUmpleTemplateFor("TraceMultipleAttributeRecord2.ump",languagePath + tracerPath+"TraceMultipleAttributeRecord2."+ languagePath +".txt","Tracer",false);
//	}
//	
//	@Test  
//	public void MultipleAttributesRecord3()
//	{
//		assertUmpleTemplateFor("TraceMultipleAttributeRecord3.ump",languagePath + tracerPath+"TraceMultipleAttributeRecord3."+ languagePath +".txt","Tracer",false);
//	}
//	
//	@Test  
//	public void MultipleAttributesRecord4()
//	{
//		assertUmpleTemplateFor("TraceMultipleAttributeRecord4.ump",languagePath + tracerPath+"TraceMultipleAttributeRecord4."+ languagePath +".txt","Tracer",false);
//	}
	
	
	
	
	
	
	 
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
		


	
	//========= File tracer
	@Test @Ignore 
	public void FileTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttribute.ump",languagePath + "/FileTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeSet.ump",languagePath + "/FileTracer_TraceSingleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_SingleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeGet.ump",languagePath + "/FileTracer_TraceSingleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeSetGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeSetGet.ump",languagePath + "/FileTracer_TraceSingleAttributeSetGet."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeAfter.ump",languagePath + "/FileTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeUntil.ump",languagePath + "/FileTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeWhere.ump",languagePath + "/FileTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeOccurences()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeOccurences.ump",languagePath + "/FileTracer_TraceSingleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributePeriod()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributePeriod.ump",languagePath + "/FileTracer_TraceSingleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_SingleAttributeRecord1()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord1.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord1."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeRecord2()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord2.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeRecord3()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord3.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_SingleAttributeRecord4()
	{
		assertUmpleTemplateFor("FileTracer_TraceSingleAttributeRecord4.ump",languagePath + "/FileTracer_TraceSingleAttributeRecord4."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributes()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttribute.ump",languagePath + "/FileTracer_TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_MultipleAttributeSet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeSet.ump",languagePath + "/FileTracer_TraceMultipleAttributeSet."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_MultipleAttributeGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeGet."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributeSetGet()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeSetGet.ump",languagePath + "/FileTracer_TraceMultipleAttributeSetGet."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesAfter()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeAfter.ump",languagePath + "/FileTracer_TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_MultipleAttributesUntil()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeUntil.ump",languagePath + "/FileTracer_TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void FileTracer_MultipleAttributesWhere()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeWhere.ump",languagePath + "/FileTracer_TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributeOccurences()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeOccurences.ump",languagePath + "/FileTracer_TraceMultipleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesPeriod()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributePeriod.ump",languagePath + "/FileTracer_TraceMultipleAttributePeriod."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesRecord1()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord1.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord1."+ languagePath +".txt","Tracer");
	}	
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesRecord2()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord2.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord2."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesRecord3()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord3.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord3."+ languagePath +".txt","Tracer");
	}
	
	@Test @Ignore 
	public void FileTracer_MultipleAttributesRecord4()
	{
		assertUmpleTemplateFor("FileTracer_TraceMultipleAttributeRecord4.ump",languagePath + "/FileTracer_TraceMultipleAttributeRecord4."+ languagePath +".txt","Tracer");
	}
	
	//========= String tracer
	@Test @Ignore 
	public void StringTracer_SingleAttribute()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttribute.ump",languagePath + "/StringTracer_TraceSingleAttribute."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void StringTracer_SingleAttributeAfter()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeAfter.ump",languagePath + "/StringTracer_TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void StringTracer_SingleAttributeUntil()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeUntil.ump",languagePath + "/StringTracer_TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	}
	  
	@Test @Ignore 
	public void StringTracer_SingleAttributeWhere()
	{
		assertUmpleTemplateFor("StringTracer_TraceSingleAttributeWhere.ump",languagePath + "/StringTracer_TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	}
	
	//*******************************//
	//**** Trace State Machines *****//
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
	public void ConsoleTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryAction.ump",languagePath + "/ConsoleTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceBigStateMachine()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceBigStateMachine.ump",languagePath + "/ConsoleTracer_TraceBigStateMachine."+ languagePath +".txt","StateMachineTest");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceNestedStateEntryRecord()
	{
//		assertUmpleTemplateFor("ConsoleTracer_TraceNestedStateEntryRecord.ump",languagePath + "/ConsoleTracer_TraceNestedStateEntryRecord."+ languagePath +".txt","StateMachineTest");
	}

	@Test @Ignore 
	public void ConsoleTracer_TraceStateEntryWhere()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateEntryWhere.ump",languagePath + "/ConsoleTracer_TraceStateEntryWhere."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceStateExitWhere()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitWhere.ump",languagePath + "/ConsoleTracer_TraceStateExitWhere."+ languagePath +".txt","Light");
	}
		
	@Test @Ignore 
	public void ConsoleTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceStateExitAction.ump",languagePath + "/ConsoleTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void ConsoleTracer_TraceTransition()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceTransition.ump",languagePath + "/ConsoleTracer_TraceTransition."+ languagePath +".txt","Light");
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
	
	//====== File tracer
	@Test @Ignore
	public void FileTracer_State()
	{
		assertUmpleTemplateFor("FileTracer_TraceState.ump",languagePath + "/FileTracer_TraceState."+ languagePath +".txt","GarageDoor");
	}
	
	@Test @Ignore 
	public void FileTracer_TraceStateEntryAction()
	{
		assertUmpleTemplateFor("FileTracer_TraceStateEntryAction.ump",languagePath + "/FileTracer_TraceStateEntryAction."+ languagePath +".txt","Light");
	}
	
	@Test @Ignore 
	public void FileTracer_TraceStateExitAction()
	{
		assertUmpleTemplateFor("FileTracer_TraceStateExitAction.ump",languagePath + "/FileTracer_TraceStateExitAction."+ languagePath +".txt","Light");
	}
	
	//***************************//
	//**** Trace Association ****//
	//***************************//
	@Test @Ignore 
	public void ConsoleTracer_TraceAssociationCardinality1()
	{
		assertUmpleTemplateFor("ConsoleTracer_TraceAssociationCardinality1.ump",languagePath + "/ConsoleTracer_TraceAssociationCardinality1."+ languagePath +".txt","Company");
	}
	  
	@Test @Ignore
	public void TracesSupportAssoiations()
	{
		assertUmpleTemplateFor("AssociationTrace.ump",languagePath + "/AssociationTrace."+ languagePath +".txt","Tracer");
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
