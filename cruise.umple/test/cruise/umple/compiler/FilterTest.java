/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.junit.*;
import cruise.umple.parser.ErrorTypeSingleton;
import cruise.umple.parser.ParseResult;

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
    assertEquals(0, model.getFilters().size());
  }

  @Test
  public void getFilter_defaultsToNull()
  {
    assertEquals(null, model.getFilter("aaa"));
  }

  @Test
  public void getFilterTest()
  {
    model = parse("601_simpleFilter.ump");
    assertEquals(1, model.getFilters().size());
    assertNotNull(model.getFilter("roles"));  
  }
  
  @Test
  public void isSettableInModel()
  {
    Filter f = new Filter("aaa");
    model.addFilter(f);
    model.getFilter("aaa").addValue("Student");
    model.getFilter("aaa").addValue("Mentor");
    assertEquals(f, model.getFilter("aaa"));
    assertEquals("aaa", model.getFilter("aaa").getName());
    assertEquals("Student",model.getFilter("aaa").getValue(0));
    assertEquals("Mentor",model.getFilter("aaa").getValue(1));
  }
 
  @Test
  public void hasAssociationTest()
  {
    Filter f = new Filter("aaa");
    assertEquals(false, f.hasAssociation());
    f.setAssociationCount(-2);
    assertEquals(false, f.hasAssociation());
    f.setAssociationCount(0);
    assertEquals(false, f.hasAssociation());
    f.setAssociationCount(1);
    assertEquals(true, f.hasAssociation());
  }

  @Test
  public void hasSuperTest()
  {
    Filter f = new Filter("aaa");
    assertEquals(false, f.hasSuper());
    f.setSuperCount(-1);
    assertEquals(false, f.hasSuper());
    f.setSuperCount(1);
    assertEquals(true, f.hasSuper());
  }
  
  @Test 
  public void hasSubTest()
  {
    Filter f = new Filter("aaa");
    assertEquals(false, f.hasSub());
    f.setSubCount(0);
    assertEquals(false, f.hasSub());
    f.setSubCount(1);
    assertEquals(true, f.hasSub());
    f.setSubCount(-1);
    assertEquals(false, f.hasSub());
  }
  
  @Test 
  public void hasNestedFilter()
  {
    Filter f = new Filter("aaa");
    assertEquals(false, f.hasNestedFilter());
    f.addFilterValue("bbb");
    assertEquals(true, f.hasNestedFilter());
  }

  @Test
  public void isIncluded()
  {
    Filter f = new Filter("aaa");

    f.addValue("Student");
    f.addValue("Mentor");

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
    model = parse("601_simpleFilter.ump");
    model.applyFilter("roles");
    Assert.assertEquals(2, model.numberOfUmpleClasses());
  }
  
  @Test
  public void applyFilter_Association()
  {
    model = parse("601_simpleFilter.ump");
    model.applyFilter("roles");
    Assert.assertEquals(1, model.numberOfAssociations());
  }

  @Test
  public void applyFilter_Empty()
  {
    model = parse("603_defaultFilter.ump");
    Assert.assertEquals(3, model.numberOfUmpleClasses());
    model.applyFilter(null);
    Assert.assertEquals(3, model.numberOfUmpleClasses());
  }

  @Test
  public void applyFilter_IncludeAll()
  {
    model = parse("603_defaultFilter.ump");
    Filter f = new Filter("includeAll");
    f.addValue("*");
    model.applyFilter("includeAll");
    Assert.assertEquals(3, model.numberOfUmpleClasses());
  }

  @Test
  public void applyFilter_NullCheck()
  {
    Filter f = new Filter("aaa");
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    model.addFilter(f);
    model.getFilter("aaa").addValue(null);
    model.applyFilter("aaa");
    Assert.assertEquals(0, model.numberOfUmpleClasses());
  }
  
  @Test
  public void oneAssociationHop()
  {
    model = parse("602_associationFilter.ump");
    Filter f = new Filter("association_one");
    f.setAssociationCount(1);
    f.addValue("X");
    model.addFilter(f);
    model.applyFilter("association_one");
    Assert.assertEquals(2, model.numberOfUmpleClasses());
    ArrayList<String> names = new ArrayList<String>();
    names.add("X");
    names.add("Y");
    assertFiltered(names, model.getUmpleClasses());
  }
  
  @Test
  public void multipleAssociationHops()
  {
    model = parse("602_associationFilter.ump");
    Filter f = new Filter("association_multiple");
    f.setAssociationCount(2);
    f.addValue("X");
    model.addFilter(f);
    model.applyFilter("association_multiple");
    Assert.assertEquals(3, model.numberOfUmpleClasses());
    ArrayList<String> names = new ArrayList<String>();
    names.add("X");
    names.add("Y");
    names.add("Z");
    assertFiltered(names, model.getUmpleClasses());
    
    model = parse("602_associationFilter.ump");
    f.setAssociationCount(3);
    model.addFilter(f);
    model.applyFilter("association_multiple");
    Assert.assertEquals(4, model.numberOfUmpleClasses());
    names.add("P");
    assertFiltered(names, model.getUmpleClasses());
    
    model = parse("602_associationFilter.ump");
    f.setAssociationCount(4);
    model.addFilter(f);
    model.applyFilter("association_multiple");
    Assert.assertEquals(5, model.numberOfUmpleClasses());
    names.add("Q");
    assertFiltered(names, model.getUmpleClasses());
  }

  
  @Test
  public void applyFilter_includeAllSuperClass()
  {
    model = parse("604_inheritanceFilter.ump");
    Filter f = new Filter("inheritance");
    model.addFilter(f);
    model.getFilter("inheritance").addValue("Y");
    model.applyFilter("inheritance");
    ArrayList<String> names = new ArrayList<String>();
    names.add("Y");
    names.add("Z");
    names.add("P");
    names.add("Q");
    Assert.assertEquals(4, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses());
  }
  
  @Test
  public void applyFilter_overWriteSuper()
  {
    model = parse("604_inheritanceFilter.ump");
    Filter f = new Filter("inheritance");
    f.setSuperCount(2);
    model.addFilter(f);
    model.getFilter("inheritance").addValue("Y");
    model.applyFilter("inheritance");
    ArrayList<String> names = new ArrayList<String>();
    names.add("Y");
    names.add("Z");
    names.add("P");
    Assert.assertEquals(3, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses());
    
    model = parse("604_inheritanceFilter.ump");
    f.setSuperCount(0);
    model.addFilter(f);
    model.applyFilter("inheritance");
    names = new ArrayList<String>();
    names.add("Y");
    Assert.assertEquals(1, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses());
  }
  
  @Test
  public void applyFilter_defaultSub()
  {
    model = parse("604_inheritanceFilter.ump");
    Filter f = new Filter("inheritance");
    model.addFilter(f);
    model.getFilter("inheritance").addValue("P");
    model.applyFilter("inheritance");
    ArrayList<String> names = new ArrayList<String>();
    names.add("P");
    names.add("Q");
    Assert.assertEquals(2, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses());
  }
  
  @Test
  public void applyFilter_overWriteSub()
  {
    model = parse("604_inheritanceFilter.ump");
    Filter f = new Filter("inheritance");
    f.setSubCount(2);
    model.addFilter(f);
    model.getFilter("inheritance").addValue("P");
    model.applyFilter("inheritance");
    ArrayList<String> names = new ArrayList<String>();
    names.add("Y");
    names.add("Z");
    names.add("P");
    names.add("Q");
    Assert.assertEquals(4, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses());
  }
  
  @Test
  public void applyFilter_NestedFilter()
  {
    model = parse("601_simpleFilter.ump");
    Filter nf = new Filter("nestedFilter");
    nf.addFilterValue("StudentFilter");
    nf.addFilterValue("MentorFilter");
    model.addFilter(nf);
    Filter sf = new Filter("StudentFilter");
    sf.addValue("Student");
    model.addFilter(sf);
    Filter mf = new Filter("MentorFilter");
    mf.addValue("Mentor");
    model.addFilter(mf);
    model.applyFilter("nestedFilter");
    ArrayList<String> names = new ArrayList<String>();
    names.add("Student");
    names.add("Mentor");
    Assert.assertEquals(2, model.numberOfUmpleClasses());
    assertFiltered(names, model.getUmpleClasses()); 
  }
  
  private void assertFiltered(ArrayList<String> names, List<UmpleClass> list)
  {
    ArrayList<String> className = new ArrayList<String>();
    for(UmpleClass c : list)
    {
      className.add(c.getName());
    }
    Assert.assertEquals(names, className);
  }
  
  public UmpleModel parse(String filename)
  {
    //String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    File file = new File(pathToInput,filename);
    ErrorTypeSingleton.getInstance().reset();
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    parser = new UmpleInternalParser(umpleParserName,model,rbp);
    ParseResult result = rbp.parse(file);
    model.setLastResult(result);
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
