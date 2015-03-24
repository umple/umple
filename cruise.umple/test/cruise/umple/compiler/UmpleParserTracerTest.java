/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;

import org.junit.*;

import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.compiler.*;

public class UmpleParserTracerTest
{
  
	UmpleParser parser;
	UmpleModel model;
	UmpleFile uFile;
	String code;
	String pathToInput;
	String umpleParserName;

  @Before
  public void setUp()
  {
      pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
	  umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  @After
  public void tearDown()
  {
	  SampleFileWriter.destroy(pathToInput+"/traceTest.ump");
	  SampleFileWriter.destroy(pathToInput+"/Tracer.java");	
  }
 
  //------------------------
  // Tracers
  //------------------------
  
  @Test
  public void traceType_Console()
  {
	  code = "tracer Console;";
	  assertParse(code,"[tracerDirective][tracerType:Console]");
	  Assert.assertEquals("console",model.getTraceType());
  }
  
  @Test
  public void traceType_File()
  {
	  code = "tracer File;";
	  assertParse(code,"[tracerDirective][tracerType:File]");
	  Assert.assertEquals("file",model.getTraceType());
  }
  
  @Test
  public void traceType_FileWithFileNameProvided()
  {
	  code = "tracer File log.txt;";
	  assertParse(code,"[tracerDirective][tracerType:File][tracerArgument:log.txt]");
	  Assert.assertEquals("file",model.getTraceType());
  }
  
  @Test
  public void traceType_String()
  {
	  code = "tracer String;";
	  assertParse(code,"[tracerDirective][tracerType:String]");
	  Assert.assertEquals("string",model.getTraceType());
  }
  
  @Test
  public void traceType_JavaAPI()
  {
    code = "tracer JavaAPI;";
    assertParse(code,"[tracerDirective][tracerType:JavaAPI]");
    Assert.assertEquals("javaapi",model.getTraceType());
  }
  
  @Test
  public void traceType_log4j()
  {
    code = "tracer log4j;";
    assertParse(code,"[tracerDirective][tracerType:log4j]");
    Assert.assertEquals("log4j",model.getTraceType());
  }
  
  @Test
  public void traceType_lttng()
  {
    code = "tracer LttngJNI;";
    assertParse(code,"[tracerDirective][tracerType:LttngJNI]");
    Assert.assertEquals("lttngjni",model.getTraceType());
  }
  
  @Test
  public void traceType_log4jConfigOptions()
  {
    code = "tracer log4j (error)=(console,file);";
    assertParse(code,"[tracerDirective][tracerType:log4j][logConfig][logLevel:error][logAppender:console][logAppender:file]");
    Assert.assertEquals("log4j",model.getTraceType());
    
    LogConfiguration log = model.getTracer().getLogConfiguration();
    Assert.assertEquals("info",log.getRootLogger());
    Assert.assertEquals("console",log.getLoggerAppender(0).getAppender(0));
    Assert.assertEquals("file",log.getLoggerAppender(0).getAppender(1));
    Assert.assertEquals("error",log.getLoggerAppender(0).getLevel(0));
  }
  
  @Test
  public void traceType_log4jMonitorInterval()
  {
    code = "tracer log4j monitorInterval=30;";
    assertParse(code,"[tracerDirective][tracerType:log4j][logConfig][monitorInterval:30]");
    LogConfiguration log = model.getTracer().getLogConfiguration();
    Assert.assertEquals(30,log.getMonitorInterval());
  }
  
  @Test
  public void traceType_DefaultIsConsole()
  {
	  code = "class Tracer{x; trace x;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][name:x][trace][traceDirective][trace_entity:x]");
	  Assert.assertEquals("console",model.getTraceType());
  }
  
  @Test
  public void traceType_TracerNameCaseInsensitive()
  {
	  code = "tracer FILE;";
	  assertParse(code,"[tracerDirective][tracerType:FILE]");
	  Assert.assertEquals("file",model.getTraceType());
  }
  
  @Test
  public void traceType_TraceMessageOnSwitch()
  {
	  code = "tracer console on : Time,Thread;";
	  assertParse(code,"[tracerDirective][tracerType:console][traceMsgHeader][switch:on][option:Time][option:Thread]");
	  Assert.assertEquals("console",model.getTraceType());
	  
	  TraceMessageSwitch tms = model.getTracer().getTraceMessageSwitch();
	  Assert.assertEquals(true,tms.getOn());
	  Assert.assertEquals("Time",tms.getOption(0));
	  Assert.assertEquals("Thread",tms.getOption(1));
  }
  
  @Test
  public void traceType_TraceMessageOffSwitch()
  {
	  code = "tracer console off : Object;";
	  assertParse(code,"[tracerDirective][tracerType:console][traceMsgHeader][switch:off][option:Object]");
	  Assert.assertEquals("console",model.getTraceType());
	  
	  TraceMessageSwitch tms = model.getTracer().getTraceMessageSwitch();
	  Assert.assertEquals(true,tms.getOff());
	  Assert.assertEquals("Object",tms.getOption(0));
  }
  	
  //------------------------
  // Tracing Attributes
  //------------------------
  
  @Test
  public void traceSingleAttributeString()
  {
	  code = "class Tracer { String name; trace name;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:String][name:name][trace][traceDirective][trace_entity:name]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
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
  
  @Test
  public void traceSingleAttributeInteger()
  {
	  code = "class Tracer{ Integer id; trace id ;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][trace][traceDirective][trace_entity:id]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
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
  
  @Test
  public void traceSingleAttributeBoolean()
  {
	  code = "class Tracer{ Boolean flag; trace flag; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Boolean][name:flag][trace][traceDirective][trace_entity:flag]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
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
  
  @Test
  public void traceAttributesWildcard()
  {
	  code = "class Tracer{x; y; z; trace *attribute; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][name:x][attribute][name:y][attribute][name:z][trace][traceDirective][trace_entity:*attribute]");
  }
  
  @Test
  public void traceSingleAttributeSet()
  {
	  code = "class Tracer{Integer id; String name; trace set id , name;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][traceOptions][traceOption][option:set][trace_entity:id][trace_entity:name]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(false,traceAttr1.getTraceGet());
  }
  
  @Test
  public void traceSingleAttributeGet()
  {
	  code = "class Tracer{x; trace get x;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][name:x][trace][traceDirective][traceOptions][traceOption][option:get][trace_entity:x]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("x"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
  }
  
  @Test
  public void traceSingleAttributeSetGet()
  {
	  code = "class Tracer{x; trace set,get x;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][name:x][trace][traceDirective][traceOptions][traceOption][option:set][traceOption][option:get][trace_entity:x]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("x"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
  }
  
  @Test
  public void traceSingleAttributeWithCondition()
  {
	  code = "class Tracer{ Integer id; String name; trace name where [id == 30]; trace id where [id > 500];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:30][trace][traceDirective][trace_entity:id][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:id][moreOp:>][number:500]");
	 
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(traceAttr1.getConditionType(),"where");
	  Assert.assertEquals(((ConstraintAttribute)((ConstraintTree)((ConstraintOperator)((TraceConstraint)traceAttr1.getConstraint().getRoot()).getRoot()).getLeft()).getRoot()).getAttribute().getName(), "id");
	  Assert.assertEquals(((ConstraintOperator)((TraceConstraint)traceAttr1.getConstraint().getRoot()).getRoot()).getValue(), "==");
	  Assert.assertEquals(((ConstraintLiteral)((ConstraintOperator)((TraceConstraint)traceAttr1.getConstraint().getRoot()).getRoot()).getRight()).getValue(), "30");

	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(traceAttr2.getConditionType(),"where");
	  Assert.assertEquals(((ConstraintAttribute)((ConstraintTree)((ConstraintOperator)((TraceConstraint)traceAttr2.getConstraint().getRoot()).getRoot()).getLeft()).getRoot()).getAttribute().getName(), "id");
	  Assert.assertEquals(((ConstraintOperator)((TraceConstraint)traceAttr2.getConstraint().getRoot()).getRoot()).getValue(), ">");
	  Assert.assertEquals(((ConstraintLiteral)((ConstraintOperator)((TraceConstraint)traceAttr2.getConstraint().getRoot()).getRoot()).getRight()).getValue(), "500");

  }
  
  @Test
  public void traceSingleAttributeUntilCondition()
  {
	  code = "class Tracer{Integer id; String name; trace name until [name == \"tim\"]; trace id until [id == 6];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][traceWhen][conditionType:until][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:tim][trace][traceDirective][trace_entity:id][traceWhen][conditionType:until][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:6]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(traceAttr1.getConditionType(),"until");
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(traceAttr2.getConditionType(),"until");

  }
  
  @Test
  public void traceSingleAttributeAfterCondition()
  {
	  code = "class Tracer{Integer id; String name; trace name after [name == \"tim\"]; trace id after [id == 6];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][traceWhen][conditionType:after][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:tim][trace][traceDirective][trace_entity:id][traceWhen][conditionType:after][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:6]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(traceAttr1.getConditionType(),"after");

	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals(traceAttr2.getConditionType(),"after");
  }
  
  @Test 
  public void traceSingleAttributePreCondition1()
  {
	  code = "class Tracer{Integer a; Integer b; trace where [a < b];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][trace][traceDirective][trace_entity:where][traceWhen][constraintToken][numExpr][constraintName][name:a][smallerOp:<][constraintName][name:b]");  
  }
  
  @Test
  public void traceSingleAttributePreCondition2()
  {
	  code = "class Tracer{Integer a; Integer b; Integer c; trace c where [a < b];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][traceDirective][trace_entity:c][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:a][smallerOp:<][constraintName][name:b]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(traceAttr1.getConditionType(),"where");
  }
  
  @Test
  public void traceSingleAttributePreCondition3()
  {
	  code = "class Tracer{Integer a; Integer b; Integer c; trace get c where [a < b];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][traceDirective][traceOptions][traceOption][option:get][trace_entity:c][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:a][smallerOp:<][constraintName][name:b]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
	  Assert.assertEquals(traceAttr1.getConditionType(),"where");
  }
  
  @Test
  public void traceSingleAttributePostCondition1()
  {
	  code = "class Tracer{Integer a; Integer b; trace [a < b];}";
//	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][traceWhen][conditionType:after][LHS:name][comparison_operator:==][RHS:\"tim\"][trace][traceDirective][trace_entity:id][traceWhen][conditionType:after][LHS:id][comparison_operator:==][RHS:6]");
  }
  
  @Test
  public void traceSingleAttributePostCondition2()
  {
	  code = "class Tracer{Integer a; Integer b; trace giving [a < b];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][trace][traceDirective][trace_entity:giving][traceWhen][constraintToken][numExpr][constraintName][name:a][smallerOp:<][constraintName][name:b]");
  }
  
  @Test
  public void traceSingleAttributePostCondition3()
  {
	  code = "class Tracer{Integer a; Integer b; Integer c; trace c giving [a < b];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:a][attribute][type:Integer][name:b][attribute][type:Integer][name:c][trace][traceDirective][trace_entity:c][traceWhen][conditionType:giving][constraintToken][numExpr][constraintName][name:a][smallerOp:<][constraintName][name:b]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);

	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("c"),traceAttr1.getAttribute(0));
	  Assert.assertEquals(traceAttr1.getConditionType(),"giving");
  }
  
  @Test
  public void traceSingleAttributeOccurences()
  {
	  code = "class Tracer{Integer id; String name; trace name for 5; trace id for 100;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_for:5][trace][traceDirective][trace_entity:id][trace_for:100]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals("traceFlag1",traceAttr1.getForClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals("traceFlag2",traceAttr2.getForClause());
  }
  
  @Test
  public void traceSingleAttributePeriod()
  {
	  code = "class Tracer{Integer id; String name; trace name period 30ms; trace id period 100s; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_period:30ms][trace][traceDirective][trace_entity:id][trace_period:100s]");

	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);  
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals("30ms",traceAttr1.getPeriodClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals("100s",traceAttr2.getPeriodClause());

  }
  
  @Test
  public void traceSingleAttributeDuration()
  {
	  code = "class Tracer{Integer id; String name; trace name during 50s; trace id during 100ms;;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_duration:50s][trace][traceDirective][trace_entity:id][trace_duration:100ms]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals("50s",traceAttr1.getDuringClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals("100ms",traceAttr2.getDuringClause());
	  
  }
  
  @Test
  public void traceSingleAttributeExecuteClause()
  {
	  code = "class Tracer{Integer id;	String name; "
			  +	" trace name execute { \"somthing\" }; "
			  + " trace id execute { record(\"objectBeingTraced\") }; "
			  + " trace name execute { record(\"x\",name) } for 100; "
			  + " trace id execute { record (\"objectBeingTraced\"), record(\"x\",name) } where [id > 500];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_execute:\"somthing\"][trace][traceDirective][trace_entity:id][trace_execute:record(\"objectBeingTraced\")][trace][traceDirective][trace_entity:name][trace_execute:record(\"x\",name)][trace_for:100][trace][traceDirective][trace_entity:id][trace_execute:record (\"objectBeingTraced\"), record(\"x\",name)][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:id][moreOp:>][number:500]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(4,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1), traceDirective3 = clazz.getTraceDirective(2) ,traceDirective4 = clazz.getTraceDirective(3);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals("\"somthing\"",traceAttr1.getExecuteClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals("record(\"objectBeingTraced\")",traceAttr2.getExecuteClause());
	  
	  AttributeTraceItem traceAttr3 = traceDirective3.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr3.getAttribute(0));
	  Assert.assertEquals("traceFlag1",traceAttr3.getForClause());
	  Assert.assertEquals("record(\"x\",name)",traceAttr3.getExecuteClause());
	  
	  AttributeTraceItem traceAttr4 = traceDirective4.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr4.getAttribute(0));
	  Assert.assertEquals("record (\"objectBeingTraced\"), record(\"x\",name)",traceAttr4.getExecuteClause());
	  Assert.assertEquals(traceAttr4.getConditionType(),"where");

  }
  
  @Test
  public void traceSingleAttributeRecord1()
  {
	  code = "class Tracer{Integer id; String name; trace name record id;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_record:id]");
	 
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),record.getAttribute(0));
  }
  
  @Test
  public void traceSingleAttributeRecord2()
  {
	  code = "class Tracer{Integer id; String name; trace name record only id;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_record:id]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecordOnly(),true);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),record.getAttribute(0));
  }
  
  @Test
  public void traceSingleAttributeRecord3()
  {
	  code = "class Tracer{Integer id; String name; trace name record \"i am tracing name\";}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_record_string:i am tracing name]");

	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecord(0),"i am tracing name");
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
  }
  
  @Test
  public void traceSingleAttributeRecord4()
  {
	  code = "class Tracer{Integer id; Integer contact;	String name;trace name record id,contact; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:Integer][name:contact][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_record:id][trace_record:contact]");
	 
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  TraceRecord record = traceDirective1.getTraceRecord();
	  Assert.assertEquals((Object)record.getRecordOnly(),false);
	  Assert.assertEquals((Object)record.getAttribute(0),clazz.getAttribute("id"));
	  Assert.assertEquals((Object)record.getAttribute(1),clazz.getAttribute("contact"));
  }
  
  @Test
  public void traceMultipleAttribute()
  {
	  code = "class Tracer{Integer id; String name; trace name,id; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr = traceDirective.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr.getAttribute(1));
  }
  
  @Test
  public void traceMultipleAttributeWithCondition()
  {
	  code = "class Tracer{Integer id; String name; trace name , id where [name == \"tim\"]; trace id , name where [id == 234];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][traceWhen][conditionType:where][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:tim][trace][traceDirective][trace_entity:id][trace_entity:name][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:234]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(traceAttr1.getConditionType(),"where");
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(traceAttr2.getConditionType(),"where");
  }
  
  @Test
  public void traceMultipleAttributeUntilCondition()
  {
	  code = "class Tracer{Integer id; String name; trace name , id until [name == \"tim\"]; trace name,id until [id == 234];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][traceWhen][conditionType:until][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:tim][trace][traceDirective][trace_entity:name][trace_entity:id][traceWhen][conditionType:until][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:234]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(traceAttr1.getConditionType(),"until");
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(traceAttr2.getConditionType(),"until");
  }
  
  @Test
  public void traceMultipleAttributeAfterCondition()
  {
	  code = "class Tracer{Integer id; String name; trace name, id after [name == \"tim\"]; trace name , id after [id == 234];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][traceWhen][conditionType:after][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:tim][trace][traceDirective][trace_entity:name][trace_entity:id][traceWhen][conditionType:after][constraintToken][numExpr][constraintName][name:id][equalsOp:==][number:234]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(traceAttr1.getConditionType(),"after");
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals(traceAttr2.getConditionType(),"after");
  }
  
  @Test
  public void traceMultipleAttributeOccurences()
  {
	  code = "class Tracer{Integer id; String name;	trace name , id for 5; trace name , id for 100;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][trace_for:5][trace][traceDirective][trace_entity:name][trace_entity:id][trace_for:100]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals("traceFlag1",traceAttr1.getForClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals("traceFlag2",traceAttr2.getForClause());
  }
  
  @Test
  public void traceMultipleAttributePeriod()
  {
	  code = "class Tracer{Integer id; String name;	trace name,id period 30ms; trace name, id period 1s; }";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][trace_period:30ms][trace][traceDirective][trace_entity:name][trace_entity:id][trace_period:1s]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals("30ms",traceAttr1.getPeriodClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals("1s",traceAttr2.getPeriodClause());
  }
  
  @Test
  public void traceMultipleAttributeDuration()
  {
	  code = "class Tracer{Integer id; String name;	trace name , id during 150s; trace name , id during 200ms;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:name][trace_entity:id][trace_duration:150s][trace][traceDirective][trace_entity:name][trace_entity:id][trace_duration:200ms]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(1));
	  Assert.assertEquals("150s",traceAttr1.getDuringClause());
	  
	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals("200ms",traceAttr2.getDuringClause());
  }
  
  @Test
  public void traceMultipleAttributeExecuteClause()
  {
	  code = "class Tracer{Integer id; String name; trace id , name execute { \"something\" } during 30ms; trace name, id execute {record(\"x\")} where [id > 100];}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][trace_entity:id][trace_entity:name][trace_execute:\"something\"][trace_duration:30ms][trace][traceDirective][trace_entity:name][trace_entity:id][trace_execute:record(\"x\")][traceWhen][conditionType:where][constraintToken][numExpr][constraintName][name:id][moreOp:>][number:100]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));	  
	  Assert.assertEquals("30ms",traceAttr1.getDuringClause());
	  Assert.assertEquals("\"something\"",traceAttr1.getExecuteClause());

	  AttributeTraceItem traceAttr2 = traceDirective2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr2.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr2.getAttribute(1));
	  Assert.assertEquals("record(\"x\")",traceAttr2.getExecuteClause());
	  Assert.assertEquals(traceAttr2.getConditionType(),"where");
  }
  
  @Test
  public void traceMultipleAttributeSet()
  {
	  code = "class Tracer{Integer id; String name;	trace set id , name;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][traceOptions][traceOption][option:set][trace_entity:id][trace_entity:name]");	  
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(false,traceAttr1.getTraceGet());
  }
  
  @Test
  public void traceMultipleAttributeGet()
  {
	  code = "class Tracer{Integer id; String name; trace get id , name;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][traceOptions][traceOption][option:get][trace_entity:id][trace_entity:name]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(false,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
  }
  
  @Test
  public void traceMultipleAttributeSetGet()
  {
	  code = "class Tracer{Integer id; String name; trace set,get id , name;}";
	  assertParse(code,"[classDefinition][name:Tracer][attribute][type:Integer][name:id][attribute][type:String][name:name][trace][traceDirective][traceOptions][traceOption][option:set][traceOption][option:get][trace_entity:id][trace_entity:name]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  AttributeTraceItem traceAttr1 = traceDirective1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)clazz.getAttribute("id"),traceAttr1.getAttribute(0));
	  Assert.assertEquals((Object)clazz.getAttribute("name"),traceAttr1.getAttribute(1));
	  Assert.assertEquals(true,traceAttr1.getTraceSet());
	  Assert.assertEquals(true,traceAttr1.getTraceGet());
  }
  
  //------------------------
  // Tracing State Machines
  //------------------------
  
  @Test
  public void traceStateMachine()
  {
	  assertParse("375_traceStateMachine.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][traceDirective][trace_entity:status]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachine stm = clazz.getTraceDirective(0).getStateMachineTraceItem(0).getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),5);
	  Assert.assertEquals(clazz.getTraceDirective(0).getStateMachineTraceItem(0).getTraceStateMachineFlag(),true);
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
	  assertParse("375_traceState.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][traceDirective][trace_entity:Closing]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), false);
	  Assert.assertEquals(traceState.getExit(), false);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),5);
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test
  public void traceState2()
  {
	  assertParse("375_traceState2.ump","[classDefinition][name:GarageDoor][stateMachine][inlineStateMachine][name:status][state][stateName:Open][transition][event:buttonOrObstacle][stateName:Closing][state][stateName:Closing][transition][event:buttonOrObstacle][stateName:Opening][transition][event:reachBottom][stateName:Closed][state][stateName:Closed][transition][event:buttonOrObstacle][stateName:Opening][state][stateName:Opening][transition][event:buttonOrObstacle][stateName:HalfOpen][transition][event:reachTop][stateName:Open][state][stateName:HalfOpen][transition][event:buttonOrObstacle][stateName:Opening][trace][traceDirective][trace_entity:status.Closing]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("GarageDoor");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getExit(), false);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals(traceState.getState(),clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceEmptyAndNonEmptyState()
  {
	  assertParse("375_traceEmptyAndNonEmptyStates.ump","[namespace:example][classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][trace][traceDirective][trace_entity:status]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem traceState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(traceState.getEntry(), false);
	  Assert.assertEquals(traceState.getExit(), false);
	  Assert.assertEquals(traceState.getTraceStateMachineFlag(), true);
	  StateMachine stm = traceState.getStateMachine();
	  Assert.assertEquals((Object)stm.numberOfStates(),2);
	  Assert.assertEquals((Object)stm,clazz.getStateMachine(0));
  }
  
  @Test
  public void traceEntryOfState()
  {
	  assertParse("376_traceEntryOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][traceDirective][traceOptions][traceOption][option:entry][trace_entity:On]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  State state = stm.getState(0);
	  Assert.assertEquals((Object)state,clazz.getStateMachine(0).getState(0));
  }
  
  @Test
  public void traceEntryOfState2()
  {
	  assertParse("376_traceEntryOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][traceDirective][traceOptions][traceOption][option:entry][trace_entity:Off]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),true);
	  Assert.assertEquals(tracedState.getExit(),false);
	  StateMachine stm = tracedState.getStateMachine();
	  Assert.assertEquals(tracedState.getState(),clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceExitOfState()
  {
	  assertParse("377_traceExitOfState.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][traceDirective][traceOptions][traceOption][option:exit][trace_entity:On]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  Assert.assertEquals(tracedState.getState(),clazz.getStateMachine(0).getState(0));
  }
  
  @Test
  public void traceExitOfState2()
  {
	  assertParse("377_traceExitOfState2.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][traceDirective][traceOptions][traceOption][option:exit][trace_entity:Off]",true);	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),true);
	  Assert.assertEquals(tracedState.getState(),clazz.getStateMachine(0).getState(1));
  }
  
  @Test
  public void traceStateRecord()
  {
	  assertParse("378_traceStateRecord.ump","[classDefinition][name:Light][attribute][type:Integer][name:v][value:0][stateMachine][inlineStateMachine][name:status][state][stateName:On][transition][event:flip][stateName:Off][state][stateName:Off][transition][event:flip][action][code:setV(2);][stateName:On][trace][traceDirective][trace_entity:On][trace_record:v]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  TraceDirective tc = clazz.getTraceDirective(0);
	  TraceRecord traceRecord = tc.getTraceRecord();
	  Assert.assertEquals((Object)traceRecord.getAttribute(0),clazz.getAttribute("v"));
	  Assert.assertEquals(traceRecord.getRecordOnly(),false);
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Assert.assertEquals(tracedState.getEntry(),false);
	  Assert.assertEquals(tracedState.getExit(),false);
	  Assert.assertEquals(tracedState.getState(),clazz.getStateMachine(0).getState(0));
  }
  
  @Test @Ignore
  public void traceTransition()
  {
	  assertParse("379_traceTransition.ump","[classDefinition][name:Light][stateMachine][inlineStateMachine][name:status][state][stateName:On][entryOrExitAction][type:entry][code:System.out.println(\"entry state On\");][transition][event:flip][stateName:Off][state][stateName:Off][entryOrExitAction][type:entry][code:System.out.println(\"entry state Off\");][transition][event:flip][stateName:On][trace][traceDirective][trace_entity:flip]");
	  
	  UmpleClass clazz = model.getUmpleClass("Light");
	  StateMachineTraceItem tracedState = clazz.getTraceDirective(0).getStateMachineTraceItem(0);
	  Transition tran = tracedState.getTransition();
	  Assert.assertEquals((Object)tran,clazz.getStateMachine(0).getState(0).getNextTransition(0));

  }
    
  //------------------------
  // Tracing Association
  //------------------------
  
  @Test
  public void traceAssociation()
  {
	  code = "class Student { 2..3 -- 0..1 Mentor aMentor; trace aMentor; } " +
	  		 "class Mentor {}";
	  assertParse(code,"[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][traceDirective][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  @Test
  public void traceCardinality()
  {
	  code = "class Student { 2..3 -- 0..1 Mentor aMentor; trace cardinality aMentor; }" +
	  		 "class Mentor {}";
	  assertParse(code,"[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][trace][traceDirective][traceOptions][traceOption][option:cardinality][trace_entity:aMentor][classDefinition][name:Mentor]");
  }
  
  //------------------------
  // Tracing Methods
  //------------------------
  
  @Test
  public void traceSingleMethod()
  {
	  code = "class Tracer { void method1() {}; int method2() {}; trace method1(); trace method2(); }";
	  assertParse(code,"[classDefinition][name:Tracer][concreteMethodDeclaration][type:void][methodDeclarator][methodName:method1][parameterList][code:][concreteMethodDeclaration][type:int][methodDeclarator][methodName:method2][parameterList][code:][trace][traceDirective][trace_entity:method1][trace][traceDirective][trace_entity:method2]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(2,clazz.numberOfTraceDirectives());
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0), traceDirective2 = clazz.getTraceDirective(1);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceItem(0).getMethod(0).getName(),"method1");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceItem(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceItem(0).getExit());
	  
	  Assert.assertEquals(traceDirective2.getMethodTraceItem(0).getMethod(0).getName(),"method2");
	  Assert.assertEquals(true,traceDirective2.getMethodTraceItem(0).getEntry());
	  Assert.assertEquals(false,traceDirective2.getMethodTraceItem(0).getExit());
  }
  
  @Test
  public void traceSingleMethodEntry()
  {
	  code = "class Tracer { void method1() {}; trace entry method1(); }";
	  assertParse(code,"[classDefinition][name:Tracer][concreteMethodDeclaration][type:void][methodDeclarator][methodName:method1][parameterList][code:][trace][traceDirective][traceOptions][traceOption][option:entry][trace_entity:method1]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceItem(0).getMethod(0).getName(),"method1");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceItem(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceItem(0).getExit());
  }
  
  @Test
  public void traceSingleMethodExit()
  {
	  code = "class Tracer { void method1() {}; trace exit method1(); }";
	  assertParse(code,"[classDefinition][name:Tracer][concreteMethodDeclaration][type:void][methodDeclarator][methodName:method1][parameterList][code:][trace][traceDirective][traceOptions][traceOption][option:exit][trace_entity:method1]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceItem(0).getMethod(0).getName(),"method1");
	  Assert.assertEquals(false,traceDirective1.getMethodTraceItem(0).getEntry());
	  Assert.assertEquals(true,traceDirective1.getMethodTraceItem(0).getExit());
  }
  
  @Test
  public void traceMultipleMethod()
  {
	  code = "class Tracer { void method1() {}; int method2() {}; trace method1(),method2(); }";
	  assertParse(code,"[classDefinition][name:Tracer][concreteMethodDeclaration][type:void][methodDeclarator][methodName:method1][parameterList][code:][concreteMethodDeclaration][type:int][methodDeclarator][methodName:method2][parameterList][code:][trace][traceDirective][trace_entity:method1][trace_entity:method2]");
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceDirective traceDirective1 = clazz.getTraceDirective(0);
	  
	  Assert.assertEquals(traceDirective1.getMethodTraceItem(0).getMethod(0).getName(),"method1");
	  Assert.assertEquals(traceDirective1.getMethodTraceItem(0).getMethod(1).getName(),"method2");
	  Assert.assertEquals(true,traceDirective1.getMethodTraceItem(0).getEntry());
	  Assert.assertEquals(false,traceDirective1.getMethodTraceItem(0).getExit());
  }
  
  //------------------------
  // Trace Cases
  //------------------------

  @Test
  public void traceCaseSingleTD()
  {
	  assertParse("400_traceCaseSingleTD.ump","[classDefinition][name:Tracer][attribute][type:String][name:name][trace][traceCase][tracecase_name:tc1][traceDirective][trace_entity:name][trace][traceCase][tracecase_act_name:tc1]",true);
	 
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(1,tc.numberOfTraceDirectives());
	  
	  TraceDirective td = tc.getTraceDirective(0);
	  AttributeTraceItem traceAttr = td.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr.getAttribute(0),clazz.getAttribute("name"));
	  Assert.assertEquals(tc.getActivation(), true);
  }
  
  @Test
  public void traceCaseMultipleTD()
  {
	  assertParse("401_traceCaseMultipleTD.ump","[classDefinition][name:Tracer][attribute][type:String][name:name][attribute][type:Integer][name:id][trace][traceCase][tracecase_name:tc1][traceDirective][trace_entity:name][traceDirective][trace_entity:id][traceWhen][conditionType:where][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:Hamoud][trace][traceCase][tracecase_act_name:tc1]",true);
	  
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  Assert.assertEquals(1,clazz.numberOfTraceCases());
	  
	  TraceCase tc = clazz.getTraceCase(0);
	  Assert.assertEquals("tc1",tc.getName());
	  Assert.assertEquals(2,tc.numberOfTraceDirectives());
	  
	  TraceDirective td1 = tc.getTraceDirective(0);
	  AttributeTraceItem traceAttr1 = td1.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr1.getAttribute(0),clazz.getAttribute("name"));
	  
	  TraceDirective td2 = tc.getTraceDirective(1);
	  AttributeTraceItem traceAttr2 = td2.getAttributeTraceItem(0);
	  Assert.assertEquals((Object)traceAttr2.getAttribute(0),clazz.getAttribute("id"));
  }
    
  @Test
  public void traceCaseDeactivation()
  {
	  assertParse("403_traceCaseDeactivation.ump","[classDefinition][name:Tracer][attribute][type:String][name:name][trace][traceCase][tracecase_name:tc1][traceDirective][trace_entity:name][trace][traceCase][tracecase_name:tc2][traceDirective][trace_entity:name][traceDirective][trace_entity:id][traceWhen][conditionType:where][constraintToken][stringExpr][stringComplexExpression][constraintName][name:name][equalsOp:==][stringComplexExpression][quote:Hamoud][trace][traceCase][tracecase_deact_name:tc1][trace][traceCase][tracecase_deact_name:tc2][deactivate_for:1s]",true);
	  UmpleClass clazz = model.getUmpleClass("Tracer");
	  TraceCase tc1 = clazz.getTraceCase(0);
	  TraceCase tc2 = clazz.getTraceCase(1);
	  Assert.assertEquals(tc1.getActivation(), false);
	  Assert.assertEquals(tc2.getActivation(), false);
  }
  
  //------------------------
  // Assert methods
  //------------------------
  
  private void assertParse(String inCode, String expectedOutput)
  {
	  SampleFileWriter.createFile(pathToInput+"/traceTest.ump",inCode);	
	  uFile = new UmpleFile(pathToInput+"/traceTest.ump");	
	  assertParse("traceTest.ump",expectedOutput,true);
  }
  
  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
	UmpleFile file = new UmpleFile(pathToInput,filename);
	ErrorTypeSingleton.getInstance().reset();
	model = new UmpleModel(new UmpleFile(pathToInput,filename));
	model.setShouldGenerate(false);
	RuleBasedParser rbp = new RuleBasedParser(model);
	parser = new UmpleInternalParser(umpleParserName,model,rbp);
	ParseResult result = rbp.parse(file);
	model.setLastResult(result);
	
	boolean answer = result.getWasSuccess();
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
  
  public void assertCondition( TraceDirective td, String conditionType, String lhs, String co, String rhs, int index)
  {
	  Assert.assertEquals(conditionType,td.getCondition(index).getConditionType());
	  Assert.assertEquals(lhs, td.getCondition(index).getLhs());
	  Assert.assertEquals(co, td.getCondition(index).getRhs().getComparisonOperator());
	  Assert.assertEquals(rhs, td.getCondition(index).getRhs().getRhs());
  }
  
}
