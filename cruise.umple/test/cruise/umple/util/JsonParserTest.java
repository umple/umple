/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.util;

import org.junit.*;

import cruise.umple.parser.ParseResult;

public class JsonParserTest 
{
  
  JsonParser p;
  
  @Before
  public void SetUp()
  {
    p = new JsonParser("json");
  }

  @Test
  public void Empty()
  {
    ParseResult result = p.parse("json", "{}");
    Assert.assertEquals(true,result.getWasSuccess());
    
    Json json = p.analyze();
    Assert.assertEquals(true,json.isComposite());
    Assert.assertEquals(0,json.numberOfComposites());
  }
  
  @Test
  public void OneAttribute()
  {
    ParseResult result = p.parse("json", "{a:1}");
    Assert.assertEquals(true,result.getWasSuccess());

    Json json = p.analyze();
    Assert.assertEquals(1,json.numberOfComposites());
    Assert.assertEquals("1",json.getValue("a"));
  }
  
  @Test
  public void MultipleAttributes()
  {
    ParseResult result = p.parse("json", "{a:1,b:2,c:3}");
    Assert.assertEquals(true,result.getWasSuccess());
    
    Json json = p.analyze();
    Assert.assertEquals(3,json.numberOfComposites());
    Assert.assertEquals("1",json.getValue("a"));
    Assert.assertEquals("2",json.getValue("b"));
    Assert.assertEquals("3",json.getValue("c"));
  }  

  
  @Test
  public void Quotes()
  {
    ParseResult result = p.parse("json", "{\"a\":1,b:\"2\"}");
    Assert.assertEquals(true,result.getWasSuccess());

    Json json = p.analyze();
    Assert.assertEquals(2,json.numberOfComposites());
    Assert.assertEquals("1",json.getValue("a"));
    Assert.assertEquals("2",json.getValue("b"));
  }    
  
  @Test
  public void NestedAttribute()
  {
    ParseResult result = p.parse("json", "{position:{x:1,y:2}}");
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    Assert.assertEquals(1,json.numberOfComposites());
    
    Json attr = json.getAttribute("position");
    Assert.assertEquals(2,attr.numberOfComposites());
    Assert.assertEquals("1",attr.getValue("x"));
    Assert.assertEquals("2",attr.getValue("y"));
  }
  
  @Test
  public void AttributeArrays()
  {
    ParseResult result = p.parse("json", "{ name : [ \"blah\", \"blah2\" ] }");
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    
    Json[] allValues = json.getArray("name");
    Assert.assertNotNull(allValues);
    Assert.assertEquals(2,allValues.length);
    
  }
  
  @Test
  public void AttributeArraysNone()
  {
    ParseResult result = p.parse("json", "{ name : [  ] }");
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    
    Json[] allValues = json.getArray("name");
    Assert.assertNotNull(allValues);
    Assert.assertEquals(0,allValues.length);
    
  }  

  @Test
  public void AttributeArraysComplex()
  {
    ParseResult result = p.parse("json", "{\"position\" : {\"x\" : \"272\",\"y\" : \"54\",\"width\" : \"0\",\"height\" : \"0\"},\"attributes\" : [{\"type\" : \"Time\",\"name\" : \"t\"},{\"type\" : \"Integer\",\"name\" : \"flightNbr\"}],\"id\" : \"RegularFlight\",\"name\" : \"RegularFlight\",\"oldname\" : \"RegularFlight\"}");
    
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    
    Json[] allValues = json.getArray("attributes");
    Assert.assertNotNull(allValues);
    Assert.assertEquals(2,allValues.length);
  }

  @Test
  public void ArraysOfObjects()
  {
    ParseResult result = p.parse("json", "{\"position\" : {\"x\" : \"105\",\"y\" : \"81\",\"width\" : \"81\",\"height\" : \"41\"},\"attributes\" : [{\"type\" : \"String\",\"name\" : \"username\"},{\"type\" : \"Integer\",\"name\" : \"id\" } ] , \"id\" : \"umpleClass_0\",\"name\" : \"One\"}");
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    
    Json[] allValues = json.getArray("attributes");
    Assert.assertNotNull(allValues);
    Assert.assertEquals(2,allValues.length);
    
    
    Assert.assertEquals("String",allValues[0].getValue("type"));
    Assert.assertEquals("username",allValues[0].getValue("name"));
    Assert.assertEquals("Integer",allValues[1].getValue("type"));
    Assert.assertEquals("id",allValues[1].getValue("name"));
    
  }
  

  
  @Test
  public void NestedAndSimpleAttribute()
  {
    
    ParseResult result = p.parse("json", "{first_name:andrew,position:{x:1,y:2},last_name:forward,dob:{y:1950,m:12,d:1}}");
    Assert.assertEquals(true,result.getWasSuccess());
    Json json = p.analyze();
    Assert.assertEquals(4,json.numberOfComposites());
    Assert.assertEquals("andrew",json.getValue("first_name"));
    Assert.assertEquals("forward",json.getValue("last_name"));

    
    Json attr = json.getAttribute("position");
    Assert.assertEquals(2,attr.numberOfComposites());
    Assert.assertEquals("1",attr.getValue("x"));
    Assert.assertEquals("2",attr.getValue("y"));

    attr = json.getAttribute("dob");
    Assert.assertEquals(3,attr.numberOfComposites());
    Assert.assertEquals("1950",attr.getValue("y"));
    Assert.assertEquals("12",attr.getValue("m"));
    Assert.assertEquals("1",attr.getValue("d"));
    
  }  
  
  @Test
  public void AttributesExample()
  {
    ParseResult result = p.parse("json","{\"position\" : {\"x\" : \"168\",\"y\" : \"43\",\"width\" : \"94\",\"height\" : \"57\"},\"attributes\" : [{\"type\" : \"String \",\"name\" : \" id\"},{\"type\" : \"String\",\"name\" : \"name\"}],\"id\" : \"umpleClass_0\",\"name\" : \"NewClass\",\"oldname\" : \"NewClass\"}");
    Assert.assertEquals(true,result.getWasSuccess());
  }
  
  @Test
  public void StripQuotesOnNested()
  {
    String input = "{\"position\":{\"x\":70,\"y\":94,\"width\":0,\"height\":0},\"id\":\"umpleClass_0\",\"name\":\"NewClass\"}";
    ParseResult result = p.parse("json", input);
    Assert.assertEquals(true,result.getWasSuccess());
    
    Json json = p.analyze();
    Assert.assertNotNull(json.getAttribute("position"));
    
  }
}