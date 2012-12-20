/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class GeneratedClassTest
{

  @Test
  public void getLookup()
  {
    GeneratedClass g = new GeneratedClass(new UmpleModel(null),new UmpleClass("Blah"));
    Assert.assertEquals(null,g.getLookup(null));
    Assert.assertEquals(null,g.getLookup("unknown"));
    g.setLookup("a","b");
    Assert.assertEquals("b",g.getLookup("a"));
    g.setLookup("a","c");
    Assert.assertEquals("c",g.getLookup("a"));
    g.setLookup("d","123");
    Assert.assertEquals("c",g.getLookup("a"));
    Assert.assertEquals("123",g.getLookup("d"));
  }
  
  @Test
  public void getMultiLookup_null()
  {
    GeneratedClass g = new GeneratedClass(new UmpleModel(null),new UmpleClass("Blah"));
    Assert.assertEquals(0,g.getMultiLookup(null).length);
    Assert.assertEquals(0,g.getMultiLookup("unknown").length);
    
  }

  @Test
  public void getMultiLookup_multiple()
  {
    GeneratedClass g = new GeneratedClass(new UmpleModel(null),new UmpleClass("Blah"));
    String[] allLookups;
    
    g.addMultiLookup("import", "a");
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(1,allLookups.length);
    Assert.assertEquals("a",allLookups[0]);

    g.addMultiLookup("import", "b");
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(2,allLookups.length);
    Assert.assertEquals("a",allLookups[0]);
    Assert.assertEquals("b",allLookups[1]);
  }
  
  @Test
  public void getMultiLookup_doNotAddNullOrEmptyString()
  {
    GeneratedClass g = new GeneratedClass(new UmpleModel(null),new UmpleClass("Blah"));
    String[] allLookups;
    
    g.addMultiLookup("import", null);
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(0,allLookups.length);

    g.addMultiLookup("import", "");
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(0,allLookups.length);

    
    g.addMultiLookup("import", "b");
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(1,allLookups.length);
    Assert.assertEquals("b",allLookups[0]);
  }
  
  @Test
  public void getMultiLookup_doNotAllowDuplicates()
  {
    GeneratedClass g = new GeneratedClass(new UmpleModel(null),new UmpleClass("Blah"));
    String[] allLookups;
    
    Assert.assertEquals(true,g.addMultiLookup("import", "a"));
    Assert.assertEquals(false,g.addMultiLookup("import", "a"));
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(1,allLookups.length);
    Assert.assertEquals("a",allLookups[0]);

    Assert.assertEquals(true,g.addMultiLookup("import", "b"));
    allLookups = g.getMultiLookup("import");
    Assert.assertEquals(2,allLookups.length);
    Assert.assertEquals("a",allLookups[0]);
    Assert.assertEquals("b",allLookups[1]);
  }

}
