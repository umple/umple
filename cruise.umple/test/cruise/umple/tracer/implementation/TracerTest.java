/*

Copyright 2010 Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

Test class for code generation for state machines

*/

package cruise.umple.tracer.implementation;

import org.junit.*;

public class TracerTest extends TracerTemplateTest
{
	  //***************************//
	  //****   File Tracer    *****//
	  //**** Code Generation  *****//
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
		  assertUmpleTemplateFor("TraceSingleAttribute.ump",languagePath + "/TraceSingleAttribute."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportSingleAttributeWhereCondition()
	  {
		  assertUmpleTemplateFor("TraceSingleAttributeWhere.ump",languagePath + "/TraceSingleAttributeWhere."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportSingleAttributeUntilCondition()
	  {
		  assertUmpleTemplateFor("TraceSingleAttributeUntil.ump",languagePath + "/TraceSingleAttributeUntil."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportSingleAttributeAfterCondition()
	  {
		  assertUmpleTemplateFor("TraceSingleAttributeAfter.ump",languagePath + "/TraceSingleAttributeAfter."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test @Ignore
	  public void TraceSupportSingleAttributePeriod()
	  {
		  assertUmpleTemplateFor("TraceSingleAttributePeriod.ump",languagePath + "/TraceSingleAttributePeriod."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TracesSupportMultipleAttributes()
	  {
		assertUmpleTemplateFor("TraceMultipleAttribute.ump",languagePath + "/TraceMultipleAttribute."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportMultipleAttributeWhereCondition()
	  {
		  assertUmpleTemplateFor("TraceMultipleAttributeWhere.ump",languagePath + "/TraceMultipleAttributeWhere."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportMultipleAttributeAfterCondition()
	  {
		  assertUmpleTemplateFor("TraceMultipleAttributeAfter.ump",languagePath + "/TraceMultipleAttributeAfter."+ languagePath +".txt","Tracer");
	  }
	  
	  @Test
	  public void TraceSupportMultipleAttributeUntilCondition()
	  {
		  assertUmpleTemplateFor("TraceMultipleAttributeUntil.ump",languagePath + "/TraceMultipleAttributeUntil."+ languagePath +".txt","Tracer");
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
