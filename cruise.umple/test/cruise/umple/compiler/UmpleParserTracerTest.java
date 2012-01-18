/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

public class UmpleParserTracerTest
{

  UmpleParser parser;
  UmpleModel model;
  String pathToInput;
  String umpleParserName;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }

  @Test
  public void traceType_Console()
  {
    assertParse("300_tracerType_Console.ump","[traceType:Console]");
    Assert.assertEquals("Console",model.getTraceType());
  }
  
  @Test
  public void traceType_File()
  {
    assertParse("300_tracerType_File.ump","[traceType:File]");
    Assert.assertEquals("File",model.getTraceType());
  }
  
  @Test
  public void traceType_String()
  {
    assertParse("300_tracerType_String.ump","[traceType:String]");
    Assert.assertEquals("String",model.getTraceType());
  }
  
  @Test
  public void traceType_DefaultIsConsole()
  {
    assertParse("300_defaultTracer.ump","[classDefinition][name:Tracer][attribute][name:x][trace][trace_entity:x]");
    Assert.assertEquals("Console",model.getTraceType());
  }
  
  //***************************************************
  //*************   Tracing Attributes   **************
  //***************************************************
  
  @Test
  public void traceSingleAttributeString()
  {
	  assertParse("310_traceSingleAttributeString.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][trace][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  Attribute_TraceItem tarceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals(0,tarceAttr.getForClause());
	  Assert.assertEquals(null,tarceAttr.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr.getDuringClause());
	  Assert.assertEquals(null,tarceAttr.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeInteger()
  {
	  assertParse("310_traceSingleAttributeInteger.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][trace][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  Attribute_TraceItem tarceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals(0,tarceAttr.getForClause());
	  Assert.assertEquals(null,tarceAttr.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr.getDuringClause());
	  Assert.assertEquals(null,tarceAttr.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeBoolean()
  {
	  assertParse("310_traceSingleAttributeBoolean.ump","[classDefinition][name:LightFixture][attribute][type:Boolean][name:flag][trace][trace_entity:flag]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Boolean",clazz.getAttribute("flag").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  Attribute_TraceItem tarceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("flag"),tarceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals(0,tarceAttr.getForClause());
	  Assert.assertEquals(null,tarceAttr.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr.getDuringClause());
	  Assert.assertEquals(null,tarceAttr.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeList()
  {
//	  assertParse("310_traceSingleAttributeList.ump","[classDefinition][name:LightFixture][attribute][type:Integer][list:[]][name:id][attribute][type:String][list:[]][name:name][trace][trace_entity:id][trace][trace_entity:name]");
  }
  
  @Test
  public void traceSingleAttributeWithCondition()
  {
	  assertParse("311_traceSingleAttributeWithCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceWhere][LHS:id][comparison_operator:==][RHS:30][trace][trace_entity:id][traceWhere][LHS:id][comparison_operator:>][RHS:500]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "30", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "500", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeUntilCondition()
  {
	  assertParse("313_traceSingleAttributeUntilCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceUntil][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][traceUntil][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "6", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeAfterCondition()
  {
	  assertParse("314_traceSingleAttributeAfterCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceAfter][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][traceAfter][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "6", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeOccurences()
  {
	  assertParse("315_traceSingleAttributeOccurences.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_for:5][trace][trace_entity:id][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(5,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(100,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributePeriod()
  {
	  assertParse("316_traceSingleAttributePeriod.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_period:30ms][trace][trace_entity:id][trace_period:100s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);  
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals("30ms",tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals("100s",tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeDuration()
  {
	  assertParse("317_traceSingleAttributeDuration.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_duration:50s][trace][trace_entity:id][trace_duration:100ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals("50s",tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals("100ms",tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
	  
  }
  
  @Test
  public void traceSingleAttributeExecuteClause()
  {
	  assertParse("318_traceSingleAttributeExecuteClause.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_execute:\"somthing\"][trace][trace_entity:id][trace_execute:record(\"objectBeingTraced\")][trace][trace_entity:name][trace_execute:record(\"x\",name)][trace_for:100][trace][trace_entity:id][trace_execute:record (\"objectBeingTraced\"), record(\"x\",name)][traceWhere][LHS:id][comparison_operator:>][RHS:500]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(4,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1), traceDirective3 = clazz.getTraceDirective(2) ,traceDirective4 = clazz.getTraceDirective(3);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals("\"somthing\"",tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals("record(\"objectBeingTraced\")",tarceAttr2.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr3 = traceDirective3.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr3.getAttribute(0));
	  Assert.assertEquals(0,traceDirective3.numberOfCondition());
	  Assert.assertEquals(100,tarceAttr3.getForClause());
	  Assert.assertEquals(null,tarceAttr3.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr3.getDuringClause());
	  Assert.assertEquals("record(\"x\",name)",tarceAttr3.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr4 = traceDirective4.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr4.getAttribute(0));
	  Assert.assertEquals(1,traceDirective4.numberOfCondition());
	  assertCondition(traceDirective4, "where", "id", ">", "500", 0);
	  Assert.assertEquals(0,tarceAttr4.getForClause());
	  Assert.assertEquals(null,tarceAttr4.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr4.getDuringClause());
	  Assert.assertEquals("record (\"objectBeingTraced\"), record(\"x\",name)",tarceAttr4.getExecuteClause());
  }
  
  @Test
  public void traceSingleAttributeRecord()
  {
	  assertParse("318_traceSingleAttributeRecord.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_record:id]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals("id",record.getRecord());
  }
  
  @Test
  public void traceMultipleAttribute()
  {
	  assertParse("319_traceMultipleAttribute.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  
	  Attribute_TraceItem tarceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr.getAttribute(1));
	  Assert.assertEquals(0,traceDirective.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr.getForClause());
	  Assert.assertEquals(null,tarceAttr.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr.getDuringClause());
	  Assert.assertEquals(null,tarceAttr.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeWithCondition()
  {
	  assertParse("320_traceMultipleAttributeWithCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceWhere][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][trace_entity:name][traceWhere][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", "==", "234", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeUntilCondition()
  {
	  assertParse("321_traceMultipleAttributeUntilCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceUntil][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:name][trace_entity:id][traceUntil][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "234", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeAfterCondition()
  {
	  assertParse("322_traceMultipleAttributeAfterCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceAfter][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:name][trace_entity:id][traceAfter][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "234", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeOccurences()
  {
	  assertParse("323_traceMultipleAttributeOccurences.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_for:5][trace][trace_entity:name][trace_entity:id][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(5,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(100,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributePeriod()
  {
	  assertParse("324_traceMultipleAttributePeriod.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_period:30ms][trace][trace_entity:name][trace_entity:id][trace_period:1s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals("30ms",tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals("1s",tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeDuration()
  {
	  assertParse("325_traceMultipleAttributeDuration.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_duration:150s][trace][trace_entity:name][trace_entity:id][trace_duration:200ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals("150s",tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals("200ms",tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleAttributeExecuteClause()
  {
	  assertParse("326_traceMultipleAttributeExecuteClause.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:id][trace_entity:name][trace_execute:\"something\"][trace_duration:30ms][trace][trace_entity:name][trace_entity:id][trace_execute:record(\"x\")][traceWhere][LHS:id][comparison_operator:>][RHS:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Attribute_TraceItem tarceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr1.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr1.getAttribute(1));	  
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals("30ms",tarceAttr1.getDuringClause());
	  Assert.assertEquals("\"something\"",tarceAttr1.getExecuteClause());

	  Attribute_TraceItem tarceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals(clazz.getAttribute("name"),tarceAttr2.getAttribute(0));
	  Assert.assertEquals(clazz.getAttribute("id"),tarceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "100", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals("record(\"x\")",tarceAttr2.getExecuteClause());
  }
  
  //***************************************************
  //*************   Tracing Methods     ***************
  //***************************************************
  
  @Test
  public void traceSingleMethod()
  {
	  assertParse("350_traceSingleMethod.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace][trace_entity:method2()][trace][trace_entity:getName()]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(3,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1), traceDirective3 = clazz.getTraceDirective(2);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective3.getMethodTraceEntity(0).getName(),"getName()");
	  Assert.assertEquals(false,traceDirective3.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective3.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective3.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective3.getForClause());
//	  Assert.assertEquals(null,traceDirective3.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective3.getDuringClause());
//	  Assert.assertEquals(null,traceDirective3.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodEntry()
  {
	  assertParse("351_traceSingleMethodEntry.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace][trace_entity:method2()]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodExit()
  {
	  assertParse("352_traceSingleMethodExit.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace][trace_entity:method2()]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodWithCondition()
  {
	  assertParse("353_traceSingleMethodWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhere][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhere][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodEntryWithCondition()
  {
	  assertParse("353_traceSingleMethodEntryWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhere][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhere][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodExitWithCondition()
  {
	  assertParse("353_traceSingleMethodExitWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhere][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhere][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodUntilCondition()
  {
	  assertParse("354_traceSingleMethodUntilCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceUntil][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method2()][traceUntil][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "6", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodAfterCondition()
  {
	  assertParse("355_traceSingleMethodAfterCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceAfter][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method2()][traceAfter][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "6", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodOccurences()
  {
	  assertParse("356_traceSingleMethodOccurences.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_for:5][trace][trace_entity:method2()][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(5,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(100,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodPeriod()
  {
	  assertParse("357_traceSingleMethodPeriod.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_period:30ms][trace][trace_entity:method2()][trace_period:100s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals("30ms",traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals("100s",traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodDuration()
  {
	  assertParse("358_traceSingleMethodDuration.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_duration:50s][trace][trace_entity:method2()][trace_duration:100ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("50s",traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals("100ms",traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceSingleMethodExecuteClause()
  {
	  assertParse("359_traceSingleMethodExecuteClause.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_execute:\"somthing\"][trace][trace_entity:getName()][trace_execute:record(\"objectBeingTraced\")][trace][trace_entity:setName()][trace_execute:record(\"x\",name)][trace_for:100][trace][trace_entity:method2()][trace_execute:record (\"objectBeingTraced\"), record(\"x\",name)][trace_period:100ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(4,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1), traceDirective3 = clazz.getTraceDirective(2), traceDirective4 = clazz.getTraceDirective(3);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals("\"somthing\"",traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"getName()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals("record(\"objectBeingTraced\")",traceDirective2.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective3.getMethodTraceEntity(0).getName(),"setName()");
	  Assert.assertEquals(false,traceDirective3.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective3.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective3.numberOfCondition());
//	  Assert.assertEquals(100,traceDirective3.getForClause());
//	  Assert.assertEquals(null,traceDirective3.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective3.getDuringClause());
//	  Assert.assertEquals("record(\"x\",name)",traceDirective3.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective4.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective4.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective4.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective4.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective4.getForClause());
//	  Assert.assertEquals("100ms",traceDirective4.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective4.getDuringClause());
//	  Assert.assertEquals("record (\"objectBeingTraced\"), record(\"x\",name)",traceDirective4.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethod()
  {
	  assertParse("360_traceMultipleMethod.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodWithCondition()
  {
	  assertParse("361_traceMultipleMethodWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()][traceWhere][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:setName()][trace_entity:method3()][traceWhere][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"setName()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"method3()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodUntilCondition()
  {
	  assertParse("362_traceMultipleMethodUntilCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()][traceUntil][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:getName()][trace_entity:method3()][traceUntil][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"getName()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"method3()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodAfterCondition()
  {
	  assertParse("363_traceMultipleMethodAfterCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:m1()][trace_entity:m2()][traceAfter][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:m()][trace_entity:n()][traceAfter][LHS:id][comparison_operator:==][RHS:444]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"m1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"m2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"m()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"n()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "444", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodOccurences()
  {
	  assertParse("364_traceMultipleMethodOccurences.ump","[classDefinition][name:LightFixture][trace][trace_entity:add()][trace_entity:subtract()][trace_for:5][trace][trace_entity:m()][trace_entity:n()][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"add()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"subtract()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(5,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"m()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"n()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(100,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodPeriod()
  {
	  assertParse("365_traceMultipleMethodPeriod.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()][trace_period:30ms][trace][trace_entity:x()][trace_entity:y()][trace_period:1s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals("30ms",traceDirective1.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"x()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"y()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals("1s",traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodDuration()
  {
	  assertParse("366_traceMultipleMethodDuration.ump","[classDefinition][name:LightFixture][trace][trace_entity:m1()][trace_entity:m2()][trace_duration:150s][trace][trace_entity:x()][trace_entity:y()][trace_duration:200ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"m1()");
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(1).getName(),"m2()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("150s",traceDirective1.getDuringClause());
//	  Assert.assertEquals(null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"x()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"y()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals("200ms",traceDirective2.getDuringClause());
//	  Assert.assertEquals(null,traceDirective2.getExecuteClause());
  }
  
  @Test
  public void traceMultipleMethodExecuteClause()
  {
	  assertParse("367_traceMultipleMethodExecuteClause.ump","[classDefinition][name:LightFixture][trace][trace_entity:method()][trace_execute:\"something\"][trace_duration:30ms][trace][trace_entity:setName()][trace_entity:getName()][trace_execute:record(\"x\")][traceWhere][LHS:id][comparison_operator:>][RHS:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals(null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("30ms",traceDirective1.getDuringClause());
//	  Assert.assertEquals("\"something\"",traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"setName()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"getName()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "100", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals(null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals(null,traceDirective2.getDuringClause());
//	  Assert.assertEquals("record(\"x\")",traceDirective2.getExecuteClause());
  }
  
  //***************************************************
  //*************   Tracing association     ***********
  //***************************************************
  @Test
  public void traceAssociation()
  {
	  assertParse("370_traceAssociation.ump","[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  @Test
  public void traceCardinality()
  {
	  assertParse("371_traceCardinality.ump","[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  //***************************************************
  //*************        Trace Cases         **********
  //***************************************************
  
  @Test
  public void traceCaseSingleTD()
  {
	  assertParse("400_traceCaseSingleTD.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][trace][tracecase_name:tc1][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(1,tc.numberOfTraceDirectives());
	  
	  TraceDirective td = tc.getTraceDirective(0);
	  Attribute_TraceItem tarceAttr = td.getAttributeTraceItem(0);
	  Assert.assertEquals(tarceAttr.getAttribute(0),clazz.getAttribute("name"));
	  Assert.assertEquals(0,td.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr.getForClause());
	  Assert.assertEquals(null,tarceAttr.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr.getDuringClause());
	  Assert.assertEquals(null,tarceAttr.getExecuteClause());
  }
  
  @Test
  public void traceCaseMultipleTD()
  {
	  assertParse("401_traceCaseMultipleTD.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][attribute][type:Integer][name:id][trace][tracecase_name:tc1][trace_entity:name][trace_entity:id][traceWhere][LHS:name][comparison_operator:==][RHS:\"tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(2,tc.numberOfTraceDirectives());
	  
	  TraceDirective td1 = tc.getTraceDirective(0);
	  Attribute_TraceItem tarceAttr1 = td1.getAttributeTraceItem(0);
	  Assert.assertEquals(tarceAttr1.getAttribute(0),clazz.getAttribute("name"));
	  Assert.assertEquals(0,td1.numberOfCondition());
	  Assert.assertEquals(0,tarceAttr1.getForClause());
	  Assert.assertEquals(null,tarceAttr1.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr1.getDuringClause());
	  Assert.assertEquals(null,tarceAttr1.getExecuteClause());
	  
	  TraceDirective td2 = tc.getTraceDirective(1);
	  Attribute_TraceItem tarceAttr2 = td2.getAttributeTraceItem(0);
	  Assert.assertEquals(tarceAttr2.getAttribute(0),clazz.getAttribute("id"));
	  Assert.assertEquals(1,td2.numberOfCondition());
	  assertCondition(td2, "where", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals(0,tarceAttr2.getForClause());
	  Assert.assertEquals(null,tarceAttr2.getPeriodClause());
	  Assert.assertEquals(null,tarceAttr2.getDuringClause());
	  Assert.assertEquals(null,tarceAttr2.getExecuteClause());
  }
  
  @Test
  public void traceCaseActivation()
  {
	  assertParse("402_traceCaseActivation.ump","[classDefinition][name:LightFixture][trace][tracecase_act_name:tc1]");
  }
  
  @Test
  public void traceCaseDeactivation()
  {
	  assertParse("403_traceCaseDeactivation.ump","[classDefinition][name:LightFixture][trace][tracecase_deact_name:tc1][trace][tracecase_deact_name:tc2][deactivate_for:1s]");
  }
    
  //***************************************************
  //*************   Tracing State Machines     ********
  //***************************************************
  
  @Test
  public void traceStateMachine()
  {
	  assertParse("375_traceStateMachine.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][trace_entity:status]");
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachine stm = clazz.getTraceDirective(0).getStateMachineTraceItem(0).getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),5);
	  Assert.assertEquals(stm.getStartState(),clazz.getStateMachine(0).getStartState());
	  Assert.assertEquals(stm.getNestedStateMachines(),clazz.getStateMachine(0).getNestedStateMachines());
	  Assert.assertEquals(stm.getState(0),clazz.getStateMachine(0).getState(0));
	  Assert.assertEquals(stm.getState(1),clazz.getStateMachine(0).getState(1));
	  Assert.assertEquals(stm.getState(2),clazz.getStateMachine(0).getState(2));
	  Assert.assertEquals(stm.getState(3),clazz.getStateMachine(0).getState(3));
	  Assert.assertEquals(stm.getState(4),clazz.getStateMachine(0).getState(4));
  }
  
  @Test
  public void traceState()
  {
	  assertParse("375_traceState.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][trace_entity:Closing]");
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachine_TraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), true);
	  Assert.assertEquals(traceState.getExit(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceEmptyAndNonEmptyState()
  {
	  assertParse("375_traceEmptyAndNonEmptyStates.ump","[namespace:example][classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][trace][trace_entity:status]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachine_TraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), true);
	  Assert.assertEquals(traceState.getExit(), true);
	  Assert.assertEquals(traceState.getTraceStateMachineFlag(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),2);
	  Assert.assertEquals(stm,clazz.getStateMachine(0));
  }
  
  @Test
  public void traceEntryOfState()
  {
	  assertParse("376_traceEntryOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:On]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachine_TraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test
  public void traceEntryOfState2()
  {
	  assertParse("376_traceEntryOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:Off]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachine_TraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceExitOfState()
  {
	  assertParse("377_traceExitOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:On]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachine_TraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test
  public void traceExitOfState2()
  {
	  assertParse("377_traceExitOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][actionCode:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:Off]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachine_TraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceStateRecord()
  {
	  assertParse("378_traceStateRecord.ump","[classDefinition][name:Light][attribute][type:Integer][name:v][value:0][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][action][actionCode:setV(2);][stateName:On][trace][trace_entity:On][trace_record:v]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  TraceDirective tc = clazz.getTraceDirective(0);
	  Assert.assertEquals(tc.getTraceRecord().getRecord(),"v");
	  StateMachine_TraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals(state,clazz.getStateMachine(0).getState(0));
  }
  
  //===================================
  
  @Test
  public void X()
  {
	  //assertParse("311_traceSingleVariableWithCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name]");
  }
  
  public void assertCondition( TraceDirective td, String conditionType, String lhs, String co, String rhs, int index)
  {
	  Assert.assertEquals(conditionType,td.getCondition(index).getConditionType());
	  Assert.assertEquals(lhs, td.getCondition(index).getLhs());
	  Assert.assertEquals(co, td.getCondition(index).getRhs().getComparisonOperator());
	  Assert.assertEquals(rhs, td.getCondition(index).getRhs().getRhs());
  }
  
  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename,expectedOutput,true);
  }
  
  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    parser = UmpleParserFactory.create(umpleParserName,model,true);
    
    boolean answer = parser.parse("program", input).getWasSuccess();
    
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }

    if (answer == false && expected)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }
    
    Assert.assertEquals(expected, answer);
    if (expected)
    {
      Assert.assertEquals(expectedOutput, parser.toString());  
    }
  }

}
