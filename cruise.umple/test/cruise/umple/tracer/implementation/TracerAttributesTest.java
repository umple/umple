/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

@Ignore
public class TracerAttributesTest extends TracerStateMachinesTest
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
	
	@Test  @Ignore
	public void MultipleAttributeOccurences()
	{
		assertUmpleTemplateFor("TraceMultipleAttributeOccurences.ump",languagePath + tracerPath+"TraceMultipleAttributeOccurences."+ languagePath +".txt","Tracer");
	}
	
	@Test  @Ignore
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
	
}
