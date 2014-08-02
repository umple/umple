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

  @Test
  public void SingleAttributeRecord1()
  {
    AssertAttr("TraceSingleAttributeRecord1.ump","TraceSingleAttributeRecord1.");
  }
  
  @Test @Ignore
  public void SingleAttributeRecord2()
  {
    AssertAttr("TraceSingleAttributeRecord2.ump","TraceSingleAttributeRecord2.");
  }
  
  @Test
  public void SingleAttributeRecord3()
  {
    AssertAttr("TraceSingleAttributeRecord3.ump","TraceSingleAttributeRecord3.");
  }
  
  @Test @Ignore
  public void SingleAttributeRecord4()
  {
    AssertAttr("TraceSingleAttributeRecord4.ump","TraceSingleAttributeRecord4.");
  }

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

  @Test @Ignore
  public void MultipleAttributeAfterCondition()
  {
    AssertAttr("TraceMultipleAttributeAfter.ump","TraceMultipleAttributeAfter.");
  }

  @Test  @Ignore
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
  
  @Test @Ignore
  public void tmp()
  {
    AssertAttr("tmp.ump","tmp.");
  }

  public void AssertAttr( String inputUmplefile, String expectedOutputFile)
  {	  
    assertUmpleTemplateFor( "attributes/" + inputUmplefile,
        languagePath + tracerPath + expectedOutputFile + languagePath +".txt",
        "Tracer",
        false);
  }

}
