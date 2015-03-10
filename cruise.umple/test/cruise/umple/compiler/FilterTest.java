/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;


import static org.junit.Assert.*;

import org.junit.*;

import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.SampleFileWriter;

public class FilterTest
{

  UmpleFile uFile;
  UmpleModel model;
  String pathToInput;
  String umpleParserName;
  UmpleParser parser;
  @Before
  public void setUp()
  {
    SampleFileWriter.createFile("model.ump", "class Student {}");
    uFile = new UmpleFile("model.ump");
    model = new UmpleModel(new UmpleFile("model.ump"));
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("model.ump");
  }

  @Test
  public void byDefaultNoFilterPresent()
  {
    assertEquals(null, model.getFilter());
  }

  @Test
  public void getFilter_defaultsToNull()
  {
    assertEquals(null, model.getFilter());
  }

  @Test
  public void isSettableInModel()
  {
    Filter f = new Filter("aaa");
    model.setFilter(f);
    model.getFilter().addValue("Student");
    model.getFilter().addValue("Mentor");
    assertEquals(f, model.getFilter());
    assertEquals("aaa", model.getFilter().getName());
    assertEquals("Student",model.getFilter().getValue(0));
    assertEquals("Mentor",model.getFilter().getValue(1));
  }

  @Test
  public void isIncluded()
  {
    Filter f = new Filter("aaa");
    model.setFilter(f);
    model.getFilter().addValue("Student");
    model.getFilter().addValue("Mentor");

    Assert.assertEquals(true, f.isIncluded("Student"));
    Assert.assertEquals(false, f.isIncluded("Blah"));
    Assert.assertEquals(false, f.isIncluded((String)null));

    Assert.assertEquals(true, f.isIncluded(new UmpleClass("Student")));
    Assert.assertEquals(false, f.isIncluded(new UmpleClass("Blah")));
    Assert.assertEquals(false, f.isIncluded((UmpleClass)null));
  }

  @Test
  public void isEmpty_hasNothing()
  {
    Filter f = new Filter("bbb");
    Assert.assertEquals(true, f.isEmpty());
  }

  @Test
  public void isEmpty_handlesNull()
  {
    Filter f = new Filter("bbb");
    f.addValue(null);
    Assert.assertEquals(false, f.isEmpty());
  }

  @Test
  public void isEmpty_hasValues()
  {
    Filter f = new Filter("bbb");
    f.addValue("abc");
    Assert.assertEquals(false, f.isEmpty());
  }

  @Test
  public void applyFilter_OnlyKeepListedClasses()
  {
    UmpleModel model = parse("601_simpleFilter.ump");
    model.applyFilter();
    Assert.assertEquals(2, model.numberOfUmpleClasses());
  }

  @Test
  public void applyFilter_Association()
  {
    UmpleModel model = parse("602_associationFilter.ump");
    model.applyFilter();
    Assert.assertEquals(1, model.getAssociations().size());
  }

  @Test
  public void applyFilter_Empty()
  {
    UmpleModel model = parse("603_defaultFilter.ump");
    model.applyFilter();
    Assert.assertEquals(3, model.numberOfUmpleClasses());
  }

  @Test
  public void applyFilter_IncludeAll()
  {
    UmpleModel model = parse("603_includeAllFilter.ump");
    model.applyFilter();
    Assert.assertEquals(3, model.numberOfUmpleClasses());
  }


  @Test
  public void applyFilter_NullCheck()
  {
    Filter f = new Filter("aaa");
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    model.setFilter(f);
    model.getFilter().addValue(null);
    model.applyFilter();
    Assert.assertEquals(0, model.numberOfUmpleClasses());
  }

  public UmpleModel parse(String filename)
  {
    //String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    UmpleFile file = new UmpleFile(pathToInput,filename);
    ErrorTypeSingleton.getInstance().reset();
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser(model);
    parser = new UmpleInternalParser(umpleParserName,model,rbp);
    ParseResult result = rbp.parse(file);
    model.setLastResult(result);
    System.out.println(rbp.getRootToken());
    boolean answer = result.getWasSuccess();
    if (answer)
    {
      parser.analyze(false).getWasSuccess();
    }
    else
    {
      Assert.fail("Unable to parse " + filename);
    }
    return model;
  }


}
