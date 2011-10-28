/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.util;

import org.junit.*;

public class JsonTest 
{

  @Test
  public void Constructor()
  {
    Json attr = new Json("one","1");
    Assert.assertEquals("one", attr.getName());
    Assert.assertEquals("1", attr.getValue());
  }
  
  @Test
  public void getIntValue()
  {
    Json attr = new Json("one","1");
    Assert.assertEquals("one", attr.getName());
    Assert.assertEquals(1, attr.getIntValue());
  }  

  @Test
  public void getIntValueInvalid()
  {
    Json attr = new Json("one","unknown");
    Assert.assertEquals("one", attr.getName());
    Assert.assertEquals(-1, attr.getIntValue());
  }  
  
  @Test
  public void isComposite()
  {
    Json attr = new Json("one",null);
    Assert.assertEquals(true,attr.isComposite());
    
    attr = new Json("one","1");
    Assert.assertEquals(false,attr.isComposite());
  }
  
  @Test
  public void addComposite()
  {
    Json position = new Json("position",null);
    position.addComposite(new Json("x","70"));
    
    Assert.assertEquals("70",position.getValue("x"));
    Assert.assertEquals(70,position.getIntValue("x"));
    Assert.assertEquals(null,position.getValue(null));
    
  }

  @Test
  public void addArray()
  {
    Json position = new Json("position",null);
    
    Json array = new Json("attributes",null);
    array.addArrayEntity("String : one");
    array.addArrayEntity("Integer: id");

    Json emptyArray = new Json("empty",null);

    position.addArray(array);
    position.addArray(emptyArray);
    
    Json[] allValues = position.getArray("attributes");
    Assert.assertEquals(2,allValues.length);
    Assert.assertEquals(null,allValues[0].getName());
    Assert.assertEquals(null,allValues[1].getName());
    Assert.assertEquals("String : one",allValues[0].getValue());
    Assert.assertEquals("Integer: id",allValues[1].getValue());
    
    allValues = position.getArray("unknown");
    Assert.assertNull(allValues);

    allValues = position.getArray("empty");
    Assert.assertEquals(0,allValues.length);
    
  }  
  
  @Test
  public void getAttribute()
  {
    Json position = new Json("position",null);
    Json name = new Json("name",null);
    name.addComposite("first","andrew");
    name.addComposite("last","james");
    
    position.addComposite(name);
    position.addComposite("x","1");
    position.addComposite("y","2");
    
    Assert.assertEquals(name,position.getAttribute("name"));
    
    Assert.assertEquals("1",position.getValue("x"));
    Assert.assertEquals(1,position.getIntValue("x"));
    Assert.assertEquals(null,position.getValue(null));
    
  }

}
