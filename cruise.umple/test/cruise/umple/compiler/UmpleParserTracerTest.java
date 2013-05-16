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
import org.junit.*;

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

  @Test @Ignore
  public void traceType_Console()
  {
    assertParse("300_tracerType_Console.ump","[traceType][tracerType:Console]");
    Assert.assertEquals("Console",model.getTraceType());
  }
  
  @Test @Ignore
  public void traceType_File()
  {
    assertParse("300_tracerType_File.ump","[traceType][tracerType:File]");
    Assert.assertEquals("File",model.getTraceType());
  }
  
  @Test @Ignore
  public void traceType_String()
  {
    assertParse("300_tracerType_String.ump","[traceType][tracerType:String]");
    Assert.assertEquals("String",model.getTraceType());
  }
  
  @Test @Ignore
  public void traceType_DefaultIsConsole()
  {
    assertParse("300_defaultTracer.ump","[classDefinition][name:Tracer][attribute][name:x][trace][trace_entity:x]");
    Assert.assertEquals("Console",model.getTraceType());
  }
  
  //***************************************************
  //*************   Tracing Attributes   **************
  //***************************************************
  
  @Test @Ignore
  public void traceSingleAttributeString()
  {
	  assertParse("310_traceSingleAttributeString.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][trace][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals((Object)null,traceAttr.getForClause());
	  Assert.assertEquals((Object)(Object)null,traceAttr.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeInteger()
  {
	  assertParse("310_traceSingleAttributeInteger.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][trace][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals((Object)null,traceAttr.getForClause());
	  Assert.assertEquals((Object)null,traceAttr.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeBoolean()
  {
	  assertParse("310_traceSingleAttributeBoolean.ump","[classDefinition][name:LightFixture][attribute][type:Boolean][name:flag][trace][trace_entity:flag]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Boolean",clazz.getAttribute("flag").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("flag"),traceAttr.getAttribute(0));
	  Assert.assertEquals(false,traceDirective.hasCondition());
	  Assert.assertEquals((Object)null,traceAttr.getForClause());
	  Assert.assertEquals((Object)null,traceAttr.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeList()
  {
//	  assertParse("310_traceSingleAttributeList.ump","[classDefinition][name:LightFixture][attribute][type:Integer][list:[]][name:id][attribute][type:String][list:[]][name:name][trace][trace_entity:id][trace][trace_entity:name]");
  }
  
  @Test @Ignore
  public void traceSingleAttributeWithCondition()
  {
	  assertParse("311_traceSingleAttributeWithCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:30][trace][trace_entity:id][traceWhen][conditionType:where][LHS:id][comparison_operator:>][RHS:500]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "30", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "500", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeUntilCondition()
  {
	  assertParse("313_traceSingleAttributeUntilCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceWhen][conditionType:until][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][traceWhen][conditionType:until][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "6", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeAfterCondition()
  {
	  assertParse("314_traceSingleAttributeAfterCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "6", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributePreCondition1()
  {
	  assertParse("312_traceSingleAttributePreCondition1.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][trace][LHS:a][comparison_operator:<][RHS:b]");
  }
  
  @Test @Ignore
  public void traceSingleAttributePreCondition2()
  {
	  assertParse("312_traceSingleAttributePreCondition2.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][trace_entity:c][traceWhen][conditionType:where][LHS:a][comparison_operator:<][RHS:b]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "a", "<", "b", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributePreCondition3()
  {
	  assertParse("312_traceSingleAttributePreCondition3.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][trace_entity:c][traceWhen][conditionType:where][LHS:a][comparison_operator:<][RHS:b]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "a", "<", "b", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributePostCondition1()
  {
//	  assertParse("311_traceSingleAttributePostCondition1.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:6]");
  }
  
  @Test @Ignore
  public void traceSingleAttributePostCondition2()
  {
	  assertParse("311_traceSingleAttributePostCondition2.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][trace][LHS:a][comparison_operator:<][RHS:b]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("a"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "giving", "a", "<", "b", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributePostCondition3()
  {
	  assertParse("311_traceSingleAttributePostCondition3.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][trace_entity:c][traceWhen][conditionType:giving][LHS:a][comparison_operator:<][RHS:b]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "giving", "a", "<", "b", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeOccurences()
  {
	  assertParse("315_traceSingleAttributeOccurences.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_for:5][trace][trace_entity:id][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals("traceFlag1",traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals("traceFlag2",traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributePeriod()
  {
	  assertParse("316_traceSingleAttributePeriod.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_period:30ms][trace][trace_entity:id][trace_period:100s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);  
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals("30ms",traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals("100s",traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeDuration()
  {
	  assertParse("317_traceSingleAttributeDuration.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_duration:50s][trace][trace_entity:id][trace_duration:100ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals("50s",traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals("100ms",traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
	  
  }
  
  @Test @Ignore
  public void traceSingleAttributeExecuteClause()
  {
	  assertParse("318_traceSingleAttributeExecuteClause.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_execute:\"somthing\"][trace][trace_entity:id][trace_execute:record(\"objectBeingTraced\")][trace][trace_entity:name][trace_execute:record(\"x\",name)][trace_for:100][trace][trace_entity:id][trace_execute:record (\"objectBeingTraced\"), record(\"x\",name)][traceWhen][conditionType:where][LHS:id][comparison_operator:>][RHS:500]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(4,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1), traceDirective3 = clazz.getTraceDirective(2) ,traceDirective4 = clazz.getTraceDirective(3);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals("\"somthing\"",traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals("record(\"objectBeingTraced\")",traceAttr2.getExecuteClause());
	  
	  AttributeTraceItem traceAttr3 = traceDirective3.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr3.getAttribute(0));
	  Assert.assertEquals(0,traceDirective3.numberOfCondition());
	  Assert.assertEquals(100,traceAttr3.getForClause());
	  Assert.assertEquals((Object)null,traceAttr3.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr3.getDuringClause());
	  Assert.assertEquals("record(\"x\",name)",traceAttr3.getExecuteClause());
	  
	  AttributeTraceItem traceAttr4 = traceDirective4.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr4.getAttribute(0));
	  Assert.assertEquals(1,traceDirective4.numberOfCondition());
	  assertCondition(traceDirective4, "where", "id", ">", "500", 0);
	  Assert.assertEquals(0,traceAttr4.getForClause());
	  Assert.assertEquals((Object)null,traceAttr4.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr4.getDuringClause());
	  Assert.assertEquals("record (\"objectBeingTraced\"), record(\"x\",name)",traceAttr4.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeRecord1()
  {
	  assertParse("318_traceSingleAttributeRecord1.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_record:id]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecord(),(Object)null);
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),record.getAttribute(0));
  }
  
  @Test @Ignore
  public void traceSingleAttributeRecord2()
  {
	  assertParse("318_traceSingleAttributeRecord2.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_record:id]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecord(),(Object)null);
	  Assert.assertEquals((Object)record.getRecordOnly(),true);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),record.getAttribute(0));
  }
  
  @Test @Ignore
  public void traceSingleAttributeRecord3()
  {
	  assertParse("318_traceSingleAttributeRecord3.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_record:\"i am tracing name\"]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecord(),"\"i am tracing name\"");
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
  }
  
  @Test @Ignore
  public void traceSingleAttributeRecord4()
  {
	  assertParse("318_traceSingleAttributeRecord4.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:Integer][name:contact][attribute][type:String][name:name][trace][trace_entity:name][trace_record:id][trace_record:contact]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecord(),(Object)null);
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
	  Assert.assertEquals((Object)record.getAttribute(0),clazz.getAttribute("id"));
	  Assert.assertEquals((Object)record.getAttribute(1),clazz.getAttribute("contact"));
  }
  
  @Test @Ignore
  public void traceMultipleAttribute()
  {
	  assertParse("319_traceMultipleAttribute.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr.getAttribute(1));
	  Assert.assertEquals(0,traceDirective.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr.getForClause());
	  Assert.assertEquals((Object)null,traceAttr.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeWithCondition()
  {
	  assertParse("320_traceMultipleAttributeWithCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceWhen][conditionType:where][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:id][trace_entity:name][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", "==", "234", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeUntilCondition()
  {
	  assertParse("321_traceMultipleAttributeUntilCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceWhen][conditionType:until][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:name][trace_entity:id][traceWhen][conditionType:until][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "234", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeAfterCondition()
  {
	  assertParse("322_traceMultipleAttributeAfterCondition.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:name][trace_entity:id][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:234]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "234", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeOccurences()
  {
	  assertParse("323_traceMultipleAttributeOccurences.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_for:5][trace][trace_entity:name][trace_entity:id][trace_for:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals("traceFlag1",traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals("traceFlag2",traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributePeriod()
  {
	  assertParse("324_traceMultipleAttributePeriod.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_period:30ms][trace][trace_entity:name][trace_entity:id][trace_period:1s]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals("30ms",traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals("1s",traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeDuration()
  {
	  assertParse("325_traceMultipleAttributeDuration.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:name][trace_entity:id][trace_duration:150s][trace][trace_entity:name][trace_entity:id][trace_duration:200ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals("150s",traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals("200ms",traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeExecuteClause()
  {
	  assertParse("326_traceMultipleAttributeExecuteClause.ump","[classDefinition][name:LightFixture][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:id][trace_entity:name][trace_execute:\"something\"][trace_duration:30ms][trace][trace_entity:name][trace_entity:id][trace_execute:record(\"x\")][traceWhen][conditionType:where][LHS:id][comparison_operator:>][RHS:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));	  
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals("30ms",traceAttr1.getDuringClause());
	  Assert.assertEquals("\"something\"",traceAttr1.getExecuteClause());

	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "100", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals("record(\"x\")",traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleAttributeSet()
  {
	  assertParse("327_traceSingleAttributeSet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][trace][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(false,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());  
  }
  
  @Test @Ignore
  public void traceMultipleAttributeSet()
  {
	  assertParse("327_traceMultipleAttributeSet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:id][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(false,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());  
  }
  
  @Test @Ignore
  public void traceSingleAttributeGet()
  {
	  assertParse("328_traceSingleAttributeGet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][trace][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause()); 
  }
  
  @Test @Ignore
  public void traceMultipleAttributeGet()
  {
	  assertParse("328_traceMultipleAttributeGet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:id][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());  
  }
  
  @Test @Ignore
  public void traceSingleAttributeSetGet()
  {
	  assertParse("329_traceSingleAttributeSetGet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][trace][trace_entity:id]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleAttributeSetGet()
  {
	  assertParse("329_traceMultipleAttributeSetGet.ump","[namespace:example][classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][trace_entity:id][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());  
  }
  
  //***************************************************
  //*************   Tracing Methods     ***************
  //***************************************************
  
  @Test @Ignore
  public void traceSingleMethod()
  {
	  assertParse("350_traceSingleMethod.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace][trace_entity:method2()]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
	  
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodWithCondition()
  {
	  assertParse("353_traceSingleMethodWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhen][conditionType:where][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodEntryWithCondition()
  {
	  assertParse("353_traceSingleMethodEntryWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhen][conditionType:where][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodExitWithCondition()
  {
	  assertParse("353_traceSingleMethodExitWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:234][trace][trace_entity:method2()][traceWhen][conditionType:where][LHS:name][comparison_operator:>][RHS:\"Tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(true,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "name", ">", "\"Tim\"", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodUntilCondition()
  {
	  assertParse("354_traceSingleMethodUntilCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhen][conditionType:until][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method2()][traceWhen][conditionType:until][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "until", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "6", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodAfterCondition()
  {
	  assertParse("355_traceSingleMethodAfterCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method2()][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:6]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective1.numberOfCondition());
	  assertCondition(traceDirective1, "after", "name", "==", "\"tim\"", 0);
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "6", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(100,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals("100s",traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("50s",traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals("100ms",traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceSingleMethodExecuteClause()
  {
	  assertParse("359_traceSingleMethodExecuteClause.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_execute:\"somthing\"][trace][trace_entity:method2()][trace_execute:record (\"objectBeingTraced\"), record(\"x\",name)][trace_period:100ms]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method1()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals("\"somthing\"",traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective4.getForClause());
//	  Assert.assertEquals("100ms",traceDirective4.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective4.getDuringClause());
//	  Assert.assertEquals("record (\"objectBeingTraced\"), record(\"x\",name)",traceDirective4.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleMethodWithCondition()
  {
	  assertParse("361_traceMultipleMethodWithCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()][traceWhen][conditionType:where][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method4()][trace_entity:method3()][traceWhen][conditionType:where][LHS:id][comparison_operator:==][RHS:234]");
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method4()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"method3()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleMethodUntilCondition()
  {
	  assertParse("362_traceMultipleMethodUntilCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:method1()][trace_entity:method2()][traceWhen][conditionType:until][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:method4()][trace_entity:method3()][traceWhen][conditionType:until][LHS:id][comparison_operator:==][RHS:234]");
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"method4()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"method3()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "until", "id", "==", "234", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleMethodAfterCondition()
  {
	  assertParse("363_traceMultipleMethodAfterCondition.ump","[classDefinition][name:LightFixture][trace][trace_entity:m1()][trace_entity:m2()][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][trace_entity:m()][trace_entity:n()][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:444]");
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"m()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"n()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "after", "id", "==", "444", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"m()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"n()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(100,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"x()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"y()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals("1s",traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
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
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("150s",traceDirective1.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"x()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"y()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(0,traceDirective2.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals("200ms",traceDirective2.getDuringClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceMultipleMethodExecuteClause()
  {
	  assertParse("367_traceMultipleMethodExecuteClause.ump","[classDefinition][name:LightFixture][trace][trace_entity:method()][trace_execute:\"something\"][trace_duration:30ms][trace][trace_entity:m1()][trace_entity:m2()][trace_execute:record(\"x\")][traceWhen][conditionType:where][LHS:id][comparison_operator:>][RHS:100]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceEntity(0).getName(),"method()");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(0,traceDirective1.numberOfCondition());
//	  Assert.assertEquals(0,traceDirective1.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective1.getPeriodClause());
//	  Assert.assertEquals("30ms",traceDirective1.getDuringClause());
//	  Assert.assertEquals("\"something\"",traceDirective1.getExecuteClause());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(0).getName(),"m1()");
	  Assert.assertEquals(traceDirective2.getMethodTraceEntity(1).getName(),"m2()");
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(0).getExit());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceEntity(1).getExit());
	  Assert.assertEquals(1,traceDirective2.numberOfCondition());
	  assertCondition(traceDirective2, "where", "id", ">", "100", 0);
//	  Assert.assertEquals(0,traceDirective2.getForClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getPeriodClause());
//	  Assert.assertEquals((Object)null,traceDirective2.getDuringClause());
//	  Assert.assertEquals("record(\"x\")",traceDirective2.getExecuteClause());
  }
  
  //***************************************************
  //*************   Tracing association     ***********
  //***************************************************
  @Test @Ignore
  public void traceAssociation()
  {
	  assertParse("370_traceAssociation.ump","[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  @Test @Ignore
  public void traceCardinality()
  {
	  assertParse("371_traceCardinality.ump","[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  //***************************************************
  //*************        Trace Cases         **********
  //***************************************************
  
  @Test @Ignore
  public void traceCaseSingleTD()
  {
	  assertParse("400_traceCaseSingleTD.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][trace][tracecase_name:tc1][trace_entity:name]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(1,tc.numberOfTraceDirectives());
	  
	  TraceDirective td = tc.getTraceDirective(0);
	  AttributeTraceItem traceAttr = td.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr.getAttribute(0),clazz.getAttribute("name"));
	  Assert.assertEquals(0,td.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr.getForClause());
	  Assert.assertEquals((Object)null,traceAttr.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceCaseMultipleTD()
  {
	  assertParse("401_traceCaseMultipleTD.ump","[classDefinition][name:LightFixture][attribute][type:String][name:name][attribute][type:Integer][name:id][trace][tracecase_name:tc1][trace_entity:name][trace_entity:id][traceWhen][conditionType:where][LHS:name][comparison_operator:==][RHS:\"tim\"]");
	  UmpleClass clazz = model.getUmpleClass("LightFixture");
	  Assert.assertEquals("Integer",clazz.getAttribute("id").getType());
	  Assert.assertEquals("String",clazz.getAttribute("name").getType());
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(2,tc.numberOfTraceDirectives());
	  
	  TraceDirective td1 = tc.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = td1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr1.getAttribute(0),clazz.getAttribute("name"));
	  Assert.assertEquals(0,td1.numberOfCondition());
	  Assert.assertEquals((Object)null,traceAttr1.getForClause());
	  Assert.assertEquals((Object)null,traceAttr1.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr1.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr1.getExecuteClause());
	  
	  TraceDirective td2 = tc.getTraceDirective(1);
	  AttributeTraceItem traceAttr2 = td2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr2.getAttribute(0),clazz.getAttribute("id"));
	  Assert.assertEquals(1,td2.numberOfCondition());
	  assertCondition(td2, "where", "name", "==", "\"tim\"", 0);
	  Assert.assertEquals((Object)null,traceAttr2.getForClause());
	  Assert.assertEquals((Object)null,traceAttr2.getPeriodClause());
	  Assert.assertEquals((Object)null,traceAttr2.getDuringClause());
	  Assert.assertEquals((Object)null,traceAttr2.getExecuteClause());
  }
  
  @Test @Ignore
  public void traceCaseActivation()
  {
	  assertParse("402_traceCaseActivation.ump","[classDefinition][name:LightFixture][trace][tracecase_act_name:tc1]");
  }
  
  @Test @Ignore
  public void traceCaseDeactivation()
  {
	  assertParse("403_traceCaseDeactivation.ump","[classDefinition][name:LightFixture][trace][tracecase_deact_name:tc1][trace][tracecase_deact_name:tc2][deactivate_for:1s]");
  }
    
  //***************************************************
  //*************   Tracing State Machines     ********
  //***************************************************
  
  @Test @Ignore
  public void traceStateMachine()
  {
	  assertParse("375_traceStateMachine.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][trace_entity:status]");
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachine stm = clazz.getTraceDirective(0).getStateMachineTraceItem(0).getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),5);
	  Assert.assertEquals((Object)stm.getStartState(),clazz.getStateMachine(0).getStartState());
	  Assert.assertEquals((Object)stm.getNestedStateMachines(),clazz.getStateMachine(0).getNestedStateMachines());
	  Assert.assertEquals((Object)stm.getState(0),clazz.getStateMachine(0).getState(0));
	  Assert.assertEquals((Object)stm.getState(1),clazz.getStateMachine(0).getState(1));
	  Assert.assertEquals((Object)stm.getState(2),clazz.getStateMachine(0).getState(2));
	  Assert.assertEquals((Object)stm.getState(3),clazz.getStateMachine(0).getState(3));
	  Assert.assertEquals((Object)stm.getState(4),clazz.getStateMachine(0).getState(4));
  }
  
  @Test @Ignore
  public void traceState()
  {
	  assertParse("375_traceState.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][trace_entity:Closing]");
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), true);
	  Assert.assertEquals(traceState.getExit(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test @Ignore
  public void traceState2()
  {
	  assertParse("375_traceState2.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][trace_entity:status.Closing]");
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), true);
	  Assert.assertEquals(traceState.getExit(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test @Ignore
  public void traceEmptyAndNonEmptyState()
  {
	  assertParse("375_traceEmptyAndNonEmptyStates.ump","[namespace:example][classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][trace][trace_entity:status]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), true);
	  Assert.assertEquals(traceState.getExit(), true);
	  Assert.assertEquals(traceState.getTraceStateMachineFlag(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),2);
	  Assert.assertEquals((Object)stm,clazz.getStateMachine(0));
  }
  
  @Test @Ignore
  public void traceEntryOfState()
  {
	  assertParse("376_traceEntryOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:On]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test @Ignore
  public void traceEntryOfState2()
  {
	  assertParse("376_traceEntryOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:Off]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test @Ignore
  public void traceExitOfState()
  {
	  assertParse("377_traceExitOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:On]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test @Ignore
  public void traceExitOfState2()
  {
	  assertParse("377_traceExitOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:Off]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(1));
  }
  
  @Test @Ignore
  public void traceStateRecord()
  {
	  assertParse("378_traceStateRecord.ump","[classDefinition][name:Light][attribute][type:Integer][name:v][value:0][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][action][code:setV(2);][stateName:On][trace][trace_entity:On][trace_record:v]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  TraceDirective tc = clazz.getTraceDirective(0);
	  TraceRecord traceRecord = tc.getTraceRecord();
	  Assert.assertEquals((Object)traceRecord.getAttribute(0),clazz.getAttribute("v"));
	  Assert.assertEquals(traceRecord.getRecord(),(Object)null);
	  Assert.assertEquals(traceRecord.getRecordOnly(),false);
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),true);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),1);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test @Ignore
  public void traceTransition()
  {
	  assertParse("379_traceTransition.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][trace_entity:flip]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Transition tran = tracedState.getTransition();
	  Assert.assertEquals((Object)tran,clazz.getStateMachine(0).getState(0).getNextTransition(0));

  }
  
  //===================================
  
  @Test @Ignore
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
