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
	  AssertAttr("TraceSingleAttribute.ump","TraceSingleAttribute.");
	}
	
	@Test 
	public void TraceAttributeWildcard()
	{
	  AssertAttr("TraceAttributeWildcard.ump","TraceAttributeWildcard.");
	}
	
	@Test
	public void SingleAttributeWhereCondition()
	{
	  AssertAttr("TraceSingleAttributeWhere.ump","TraceSingleAttributeWhere.");
	}
	  
	@Test
	public void SingleAttributeUntilCondition()
	{
	  AssertAttr("TraceSingleAttributeUntil.ump","TraceSingleAttributeUntil.");
	}
	  
	@Test
	public void SingleAttributeAfterCondition()
	{
	  AssertAttr("TraceSingleAttributeUntil.ump","TraceSingleAttributeUntil.");
	}
	
	@Test
	public void SingleAttributePostCondition()
	{
	  AssertAttr("TraceSingleAttributePostCondition.ump","TraceSingleAttributePostCondition.");
	}
	
	@Test @Ignore
	public void SingleAttributePeriod()
	{
	  AssertAttr("TraceSingleAttributePeriod.ump","TraceSingleAttributePeriod.");
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
	  AssertAttr("TraceSingleAttributeSet.ump","TraceSingleAttributeSet.");
	}
	  
	@Test
	public void SingleAttributeGet()
	{
	  AssertAttr("TraceSingleAttributeGet.ump","TraceSingleAttributeGet.");
	}
	
	@Test
	public void SingleAttributeSetGet()
	{
	  AssertAttr("TraceSingleAttributeSetGet.ump","TraceSingleAttributeSetGet.");
	}
	
	@Test @Ignore
	public void SingleAttributeOccurences()
	{
	  AssertAttr("TraceSingleAttributeOccurences.ump","TraceSingleAttributeOccurences.");
	}	  
	
	@Test  
	public void MultipleAttributes()
	{
	  AssertAttr("TraceMultipleAttribute.ump","TraceMultipleAttribute.");
	}
	  
	@Test  
	public void MultipleAttributeWhereCondition()
	{
	  AssertAttr("TraceMultipleAttributeWhere.ump","TraceMultipleAttributeWhere.");
	}
	  
	@Test  
	public void MultipleAttributeAfterCondition()
	{
	  AssertAttr("TraceMultipleAttributeAfter.ump","TraceMultipleAttributeAfter.");
	}
	
	@Test  
	public void MultipleAttributeUntilCondition()
	{
	  AssertAttr("TraceMultipleAttributeUntil.ump","TraceMultipleAttributeUntil.");
	}
	
	@Test  
	public void MultipleAttributePostCondition()
	{
	  AssertAttr("TraceMultipleAttributePostCondition.ump","TraceMultipleAttributePostCondition.");
	}

	@Test
	public void MultipleAttributeSet()
	{
	  AssertAttr("TraceMultipleAttributeSet.ump","TraceMultipleAttributeSet.");
	}
	  
	@Test
	public void MultipleAttributeGet()
	{
	  AssertAttr("TraceMultipleAttributeGet.ump","TraceMultipleAttributeGet.");
	}
	
	@Test  
	public void MultipleAttributeSetGet()
	{
	  AssertAttr("TraceMultipleAttributeSetGet.ump","TraceMultipleAttributeSetGet.");
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
	
	public void AssertAttr( String inputUmplefile, String expectedOutputFile)
	{	  
	  assertUmpleTemplateFor( "attributes/" + inputUmplefile,
	      languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
	      "Tracer",
	      false);
	}
	
}
