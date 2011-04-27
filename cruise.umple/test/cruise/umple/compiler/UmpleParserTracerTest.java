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

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
  }
  
  @Test
  public void attributeTrace()
  {
    assertParse("300_tracer.ump","[classDefinition][name:LightFixture][attribute][name:x][trace][trace_code:x]");
    
    Assert.assertEquals("Console",model.getTraceType());
    UmpleClass clazz = model.getUmpleClass("LightFixture");
    Assert.assertEquals(1,clazz.numberOfTraceItems());
    TraceItem traceItem = clazz.getTraceItem(0);
    Assert.assertEquals(clazz.getAttribute("x"),traceItem.getAttribute());
  }

  @Test
  public void traceType_String()
  {
    assertParse("300_tracerType_String.ump","[traceType:String]");
    Assert.assertEquals("String",model.getTraceType());
  }
  
  
  @Test
  public void executeWithRecord()
  {
    assertParse("300_tracer_record.ump","[classDefinition][name:LightFixture][trace][trace_code:m1()][trace_execute:record(\"x\");]");
  }
  

  @Test
  public void multipleTraces()
  {
    assertParse("300_tracer_multipleTraces.ump","[classDefinition][name:LightFixture][trace][trace_code:m2();\n    m3();][trace_execute:record(\"x\",result);]");
  }
  
  @Test
  public void whereClause()
  {
    assertParse("300_tracer_whereClause.ump","[classDefinition][name:LightFixture][trace][trace_code:m4()][trace_execute:\"y\"][trace_where:attr7>5]");
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
    parser = new UmpleParser(model);
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
