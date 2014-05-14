/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.util;

import org.junit.*;

public class GlossaryTest 
{
  
  private Glossary g;
  
  @Before
  public void SetUp()
  {
    g = new Glossary();
  }

  @Test
  public void getSingular_known()
  {
    Assert.assertEquals("x",g.getSingular("x"));
    Assert.assertEquals("xs",g.getPlural("x"));
    g.addWord(new Word("x","xss"));
    Assert.assertEquals("x",g.getSingular("xss"));
    Assert.assertEquals("xss",g.getPlural("x"));
  }
  
  @Test
  public void handle_s()
  {
    Assert.assertEquals("s",g.getSingular("s"));
    Assert.assertEquals("ses",g.getPlural("s"));

    Assert.assertEquals("s",g.getSingular("ses"));
    Assert.assertEquals("ses",g.getPlural("ses"));
  }
  
  @Test
  public void getSingular_unknownEntry()
  {
    Assert.assertEquals("",g.getSingular(""));
    Assert.assertEquals("",g.getSingular(null));
    Assert.assertEquals("name",g.getSingular("names"));
    Assert.assertEquals("person",g.getSingular("persons"));
    Assert.assertEquals("garble",g.getSingular("garble"));
  }

  @Test
  public void getSingular_unknownEntryButAlreadySingular()
  {
    Assert.assertEquals("",g.getSingular(""));
    Assert.assertEquals("",g.getSingular(null));
    Assert.assertEquals("name",g.getSingular("name"));
    Assert.assertEquals("person",g.getSingular("person"));
    Assert.assertEquals("garble",g.getSingular("garble"));
  }
  
  @Test
  public void getPlural_unknownEntry()
  {
    Assert.assertEquals("s",g.getPlural(""));
    Assert.assertEquals("s",g.getPlural(null));
    Assert.assertEquals("names",g.getPlural("name"));
    Assert.assertEquals("persons",g.getPlural("person"));
    Assert.assertEquals("garbles",g.getPlural("garbles"));
  }  
	
  @Test
  public void getPlural_unknownEntryButAlreadyPlural()
  {
    Assert.assertEquals("ses",g.getPlural("s"));
    Assert.assertEquals("names",g.getPlural("names"));
    Assert.assertEquals("persons",g.getPlural("persons"));
    Assert.assertEquals("garbles",g.getPlural("garbles"));
  }  	
  
  @Test
  public void customDefaultEntries()
  {
    Assert.assertEquals("fish",g.getPlural("fish"));
    Assert.assertEquals("fish",g.getSingular("fish"));
    
    Assert.assertEquals("sheep",g.getPlural("sheep"));
    Assert.assertEquals("sheep",g.getSingular("sheep"));

    Assert.assertEquals("series",g.getPlural("series"));
    Assert.assertEquals("series",g.getSingular("series"));

    Assert.assertEquals("species",g.getPlural("species"));
    Assert.assertEquals("species",g.getSingular("species"));

    Assert.assertEquals("money",g.getPlural("money"));
    Assert.assertEquals("money",g.getSingular("money"));

    Assert.assertEquals("rice",g.getPlural("rice"));
    Assert.assertEquals("rice",g.getSingular("rice"));

    Assert.assertEquals("information",g.getPlural("information"));
    Assert.assertEquals("information",g.getSingular("information"));

    Assert.assertEquals("equipment",g.getPlural("equipment"));
    Assert.assertEquals("equipment",g.getSingular("equipment"));
    
    Assert.assertEquals("men",g.getPlural("man"));
    Assert.assertEquals("man",g.getSingular("men"));

    Assert.assertEquals("children",g.getPlural("child"));
    Assert.assertEquals("child",g.getSingular("children"));

    Assert.assertEquals("sexes",g.getPlural("sex"));
    Assert.assertEquals("sex",g.getSingular("sexes"));

    Assert.assertEquals("moves",g.getPlural("move"));
    Assert.assertEquals("move",g.getSingular("moves"));

    Assert.assertEquals("shoes",g.getPlural("shoe"));
    Assert.assertEquals("shoe",g.getSingular("shoes"));

    Assert.assertEquals("axes",g.getPlural("axis"));
    Assert.assertEquals("axis",g.getSingular("axes"));

    Assert.assertEquals("testes",g.getPlural("testis"));
    Assert.assertEquals("testis",g.getSingular("testes"));

    Assert.assertEquals("crises",g.getPlural("crisis"));
    Assert.assertEquals("crisis",g.getSingular("crises"));

    Assert.assertEquals("octopi",g.getPlural("octopus"));
    Assert.assertEquals("octopus",g.getSingular("octopi"));

    Assert.assertEquals("statuses",g.getPlural("status"));
    Assert.assertEquals("status",g.getSingular("statuses"));

    Assert.assertEquals("aliases",g.getPlural("alias"));
    Assert.assertEquals("alias",g.getSingular("aliases"));

    Assert.assertEquals("oxen",g.getPlural("ox"));
    Assert.assertEquals("ox",g.getSingular("oxen"));

    Assert.assertEquals("indices",g.getPlural("index"));
    Assert.assertEquals("index",g.getSingular("indices"));

    Assert.assertEquals("vertices",g.getPlural("vertex"));
    Assert.assertEquals("vertex",g.getSingular("vertices"));

    Assert.assertEquals("quizzes",g.getPlural("quiz"));
    Assert.assertEquals("quiz",g.getSingular("quizzes"));

    Assert.assertEquals("matrices",g.getPlural("matrix"));
    Assert.assertEquals("matrix",g.getSingular("matrices"));    

    Assert.assertEquals("radii",g.getPlural("radius"));
    Assert.assertEquals("radius",g.getSingular("radii"));    

  }
  
  @Test
  public void generalRules()
  {
    Assert.assertEquals("parties",g.getPlural("party"));
    Assert.assertEquals("party",g.getSingular("party"));
    Assert.assertEquals("parties",g.getPlural("parties"));
    Assert.assertEquals("party",g.getSingular("parties"));    
    
    Assert.assertEquals("classes",g.getPlural("class"));
    Assert.assertEquals("class",g.getSingular("class"));
    Assert.assertEquals("classes",g.getPlural("classes"));
    Assert.assertEquals("class",g.getSingular("classes"));    

    Assert.assertEquals("statuses",g.getPlural("status"));
    Assert.assertEquals("status",g.getSingular("status"));
    Assert.assertEquals("statuses",g.getPlural("statuses"));
    Assert.assertEquals("status",g.getSingular("statuses"));    

  }
  
  
}
