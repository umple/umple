/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.util.*;

import org.junit.*;

import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.*;
import java.io.*;

public class UmpleUSEParserTest
{

  public UmpleParser parser;
  public UmpleModel model;
  public String pathToInput;
  public String umpleParserName;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  @Test
  public void oneEmptyClass()
  {
    assertParse("useOneEmptyClass.use");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    Assert.assertEquals("Employee", model.getUmpleClass(0).getName());
  }
  
  @Test
  public void twoEmptyClasses()
  {
    assertParse("useTwoEmptyClasses.use");
    Assert.assertEquals(2, model.numberOfUmpleClasses());
    Assert.assertEquals("Employee", model.getUmpleClass(0).getName());
    Assert.assertEquals("Customer", model.getUmpleClass(1).getName());
  }
  
  @Test
  public void oneAttribute()
  {
    assertParse("useOneAttribute.use");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    Assert.assertEquals("Employee", model.getUmpleClass(0).getName());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttributes().size() == 1);
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("name") != null);
    Assert.assertEquals("String", model.getUmpleClass("Employee").getAttribute("name").getType());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("name").isPrimitive());
  }
  
  @Test
  public void twoAttributes()
  {
    assertParse("useTwoAttributes.use");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    Assert.assertEquals("Employee", model.getUmpleClass(0).getName());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttributes().size() == 2);
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("name") != null);
    Assert.assertEquals("String", model.getUmpleClass("Employee").getAttribute("name").getType());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("name").isPrimitive());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("budget") != null);
    Assert.assertEquals("Integer", model.getUmpleClass("Employee").getAttribute("budget").getType());
    Assert.assertTrue(model.getUmpleClass("Employee").getAttribute("budget").isPrimitive());
  }
  
  // Assertion case where we expect the parse to succeed - may be overridden
  public void assertParse(String filename)
  {
    Assert.assertEquals(true,parse(filename));
  }
  
  public boolean parse(String filename)
  {
    //String input = SampleFileWriter.readContent(new File(pathToInput, filename));
	UmpleFile file = new UmpleFile(pathToInput,filename);
    ErrorTypeSingleton.getInstance().reset();
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    parser = new UmpleInternalParser(umpleParserName,model,rbp);
    ParseResult result = rbp.parse(file);
    model.setLastResult(result);
    System.out.println(rbp.getRootToken());
    boolean answer = result.getWasSuccess();
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }
    return answer;
  }
}