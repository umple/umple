/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import cruise.umple.parser.Position;

import org.junit.*;

public class RulePartTest
{
  
  @Test
  public void isValidInnerValues()
  {
    RulePart part = new RulePart(null,null);
    Assert.assertEquals(false,part.isValidInnerValues(""));
    
    part = new RulePart("type,name>1,0",null);
    Assert.assertEquals(false,part.isValidInnerValues(""));
    Assert.assertEquals(false,part.isValidInnerValues(null));
    Assert.assertEquals(true,part.isValidInnerValues("abc"));
    Assert.assertEquals(true,part.isValidInnerValues("Type def"));
    Assert.assertEquals(false,part.isValidInnerValues("abc def hij"));
  }
  
  
  @Test
  public void hasInnerNames()
  {
    RulePart part = new RulePart(null,null);
    Assert.assertEquals(false,part.hasInnerNames());
    
    part = new RulePart("simple",null);
    Assert.assertEquals(false,part.hasInnerNames());

    part = new RulePart("type,name",null);
    Assert.assertEquals(true,part.hasInnerNames());

    part = new RulePart("type,name>,1,0",null);
    Assert.assertEquals(true,part.hasInnerNames());
    
  }
  
  @Test
  public void getInnerNames()
  {
    RulePart part = new RulePart(null,null);
    Assert.assertEquals(0,part.getInnerNames().length);
    
    part = new RulePart("simple",null);
    Assert.assertEquals(0,part.getInnerNames().length);

    part = new RulePart("type,name",null);
    String[] innerNames = part.getInnerNames();
    Assert.assertEquals(2,innerNames.length);
    Assert.assertEquals("type",innerNames[0]);
    Assert.assertEquals("name",innerNames[1]);

    part = new RulePart("type,modifier,name,>1,0",null);
    innerNames = part.getInnerNames();
    Assert.assertEquals(3,innerNames.length);
    Assert.assertEquals("type",innerNames[0]);
    Assert.assertEquals("modifier",innerNames[1]);
    Assert.assertEquals("name",innerNames[2]);
    
  }  

  @Test
  public void getInnerValues_invalid()
  {
    RulePart part = new RulePart(null,null);
    Assert.assertEquals(0,part.getInnerValues(null).length);
    
    part = new RulePart("simple",null);
    Assert.assertEquals(0,part.getInnerValues("blah").length);
  }
  
  
  @Test
  public void getInnerValues_none()
  {
    RulePart part = new RulePart("type,name",null);
    RulePartValue[] innerValues = part.getInnerValues(null);
    Assert.assertEquals(2,innerValues.length);
    Assert.assertEquals("type",innerValues[0].getName());
    Assert.assertEquals("name",innerValues[1].getName());
    Assert.assertEquals(null,innerValues[0].getPosition());
    Assert.assertEquals(null,innerValues[1].getPosition());
    Assert.assertEquals(null,innerValues[0].getValue());
    Assert.assertEquals(null,innerValues[1].getValue());
  }  

  @Test
  public void getInnerValues_simpleOrder()
  {
    RulePart part = new RulePart("type,name",null);
    RulePartValue[] innerValues = part.getInnerValues("x");
    Assert.assertEquals(2,innerValues.length);

    Assert.assertEquals("x",innerValues[0].getValue());
    Assert.assertEquals(null,innerValues[1].getValue());
    
    Assert.assertEquals(new Position(1,0,0),innerValues[0].getPosition());
    Assert.assertEquals(null,innerValues[1].getPosition());
    
    part = new RulePart("type,name",null);
    innerValues = part.getInnerValues("x y");
    Assert.assertEquals(2,innerValues.length);

    Assert.assertEquals("x",innerValues[0].getValue());
    Assert.assertEquals("y",innerValues[1].getValue());
    
    Assert.assertEquals(new Position(1,0,0),innerValues[0].getPosition());
    Assert.assertEquals(new Position(1,2,2),innerValues[1].getPosition());
  }
  
  @Test
  public void Types()
  {
    RulePart part = new RulePart("aName",null);
    
    part.setType(RulePart.Type.Static);
    Assert.assertEquals(true,part.isStatic());
    Assert.assertEquals(false,part.isVariable());
    Assert.assertEquals(false,part.isRule());
    Assert.assertEquals(false,part.isEnum());

    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isStatic());
    Assert.assertEquals(true,part.isVariable());
    Assert.assertEquals(false,part.isRule());
    Assert.assertEquals(false,part.isEnum());
    
    part.setType(RulePart.Type.Rule);
    Assert.assertEquals(false,part.isStatic());
    Assert.assertEquals(false,part.isVariable());
    Assert.assertEquals(true,part.isRule());
    Assert.assertEquals(false,part.isEnum());
    
    part.setName("=option:one|two");
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isStatic());
    Assert.assertEquals(true,part.isVariable());
    Assert.assertEquals(false,part.isRule());
    Assert.assertEquals(true,part.isEnum());
    
    part.setName("!option:[a-z]{3}");
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isStatic());
    Assert.assertEquals(true,part.isVariable());
    Assert.assertEquals(false,part.isRule());
    Assert.assertEquals(false,part.isEnum());
    Assert.assertEquals(true,part.isRegex());
    
    
  }
  
  @Test
  public void isEnumValue_notEnum()
  {
    RulePart part = new RulePart(null,null);

    Assert.assertEquals(false, part.isEnumValue(null));
    Assert.assertEquals(false, part.isEnumValue(""));
    Assert.assertEquals(false, part.isEnumValue("x"));
  }

  @Test
  public void isRegex_notRegex()
  {
    RulePart part = new RulePart(null,null);

    Assert.assertEquals(false, part.regexMatches(null));
    Assert.assertEquals(false, part.regexMatches(""));
    Assert.assertEquals(false, part.regexMatches("x"));
  }

  @Test
  public void getEnums()
  {
    RulePart part = new RulePart(null,null);

    Assert.assertEquals(0, part.getEnums().length);
    
    part.setName("=blah:one|two");
    
    Assert.assertEquals(2, part.getEnums().length);
    Assert.assertEquals("one", part.getEnums()[0]);
    Assert.assertEquals("two", part.getEnums()[1]);
  }

  @Test
  public void getRegex()
  {
    RulePart part = new RulePart(null,null);
    Assert.assertEquals(null, part.getRegex());

    part.setName("!option:[a-z]{3}");
    Assert.assertEquals("[a-z]{3}", part.getRegex());
  }

  @Test
  public void isEnumValue_enum()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    
    Assert.assertEquals(false, part.isEnumValue(null));
    Assert.assertEquals(false, part.isEnumValue(""));
    Assert.assertEquals(false, part.isEnumValue("x"));
    Assert.assertEquals(true, part.isEnumValue("on"));
    Assert.assertEquals(true, part.isEnumValue("off"));
  }

  @Test
  public void regexMatches()
  {
    RulePart part = new RulePart("!url:(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",null);
    part.setType(RulePart.Type.Variable);
    
    Assert.assertEquals(false, part.regexMatches(null));
    Assert.assertEquals(false, part.regexMatches(""));
    Assert.assertEquals(true, part.regexMatches("https://www.google.com"));
    Assert.assertEquals(true, part.regexMatches("file://home/root/file"));
    Assert.assertEquals(false, part.regexMatches("www.google.com"));
    Assert.assertEquals(false, part.regexMatches("http://www.google.com."));
    Assert.assertEquals(false, part.regexMatches("http://"));
  }

  
  @Test
  public void isEnumValue_simple()
  {
    RulePart part = new RulePart("=unique",null);
    part.setType(RulePart.Type.Variable);
    
    Assert.assertEquals(true, part.isEnum());
    Assert.assertEquals("unique", part.getDisplayName());
    Assert.assertEquals(false, part.isEnumValue(null));
    Assert.assertEquals(false, part.isEnumValue(""));
    Assert.assertEquals(false, part.isEnumValue("x"));
    Assert.assertEquals(true, part.isEnumValue("unique"));
  }

  
  @Test
  public void getInnerValues_complexOrder()
  {
    RulePart part = new RulePart("type,name,modifier>1,0,2",null);
    RulePartValue[] innerValues = part.getInnerValues("x");

    Assert.assertEquals(3,innerValues.length);
    Assert.assertEquals(null,innerValues[0].getValue());
    Assert.assertEquals("x",innerValues[1].getValue());
    Assert.assertEquals(null,innerValues[2].getValue());

    Assert.assertEquals(null,innerValues[0].getPosition());
    Assert.assertEquals(new Position(1,0,0),innerValues[1].getPosition());
    Assert.assertEquals(null,innerValues[2].getPosition());
    
    
    part = new RulePart("type,name,modifier>1,0,2",null);
    innerValues = part.getInnerValues("x y");
    Assert.assertEquals(3,innerValues.length);

    Assert.assertEquals("x",innerValues[0].getValue());
    Assert.assertEquals("y",innerValues[1].getValue());
    Assert.assertEquals(null,innerValues[2].getValue());

    Assert.assertEquals(new Position(1,0,0),innerValues[0].getPosition());
    Assert.assertEquals(new Position(1,2,2),innerValues[1].getPosition());
    Assert.assertEquals(null,innerValues[2].getPosition());
    
    part = new RulePart("type,name,modifier>2,0,1",null);
    innerValues = part.getInnerValues("x y");
    Assert.assertEquals(3,innerValues.length);

    Assert.assertEquals(null,innerValues[0].getValue());
    Assert.assertEquals("x",innerValues[1].getValue());
    Assert.assertEquals("y",innerValues[2].getValue());

    Assert.assertEquals(null,innerValues[0].getPosition());
    Assert.assertEquals(new Position(1,0,0),innerValues[1].getPosition());
    Assert.assertEquals(new Position(1,2,2),innerValues[2].getPosition());
    
    part = new RulePart("type,name,modifier>2,0,1",null);
    innerValues = part.getInnerValues("x y z");
    Assert.assertEquals(3,innerValues.length);
    Assert.assertEquals("x",innerValues[0].getValue());
    Assert.assertEquals("y",innerValues[1].getValue());
    Assert.assertEquals("z",innerValues[2].getValue());

    Assert.assertEquals(new Position(1,0,0),innerValues[0].getPosition());
    Assert.assertEquals(new Position(1,2,2),innerValues[1].getPosition());
    Assert.assertEquals(new Position(1,4,4),innerValues[2].getPosition());
  }
  
  @Test
  public void setNameFiltersEnum()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals("=facade:on|off",part.getName());
    Assert.assertEquals("facade",part.getDisplayName());
    Assert.assertEquals(true,part.isEnum());
  }

  @Test
  public void getNextIdentifiers_none()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(0, part.getNextIdentifiers().length);
  }
  
  @Test
  public void getNextIdentifier_simple()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    part.addNextIdentifier(";");
    Assert.assertEquals(";", part.getNextIdentifiers()[0]);
  }
  
  @Test
  public void addNextIdentifier()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    part.addNextIdentifier(";");
    part.addNextIdentifier(":");
    Assert.assertEquals(";", part.getNextIdentifiers()[0]);
    Assert.assertEquals(":", part.getNextIdentifiers()[1]);
  }  
  
  @Test
  public void addNextIdentifier_null()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    part.addNextIdentifier(null);
    part.addNextIdentifier(null);
    Assert.assertEquals(0, part.getNextIdentifiers().length);
  }  
  
  @Test
  public void removeNextIdentifiers()
  {
    RulePart part = new RulePart("=facade:on|off",null);
    part.setType(RulePart.Type.Variable);
    part.addNextIdentifier(";");
    part.addNextIdentifier(":");
    part.removeNextIdentifiers();
    
    Assert.assertEquals(0, part.getNextIdentifiers().length);
  }
  
  @Test
  public void isMultiWord()
  {
    RulePart part = new RulePart("blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isMultiWord());
    
    part = new RulePart("**blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(true,part.isMultiWord());
    Assert.assertEquals("blah",part.getDisplayName());
  }
  
  @Test
  public void isToEndOfLine()
  {
    RulePart part = new RulePart("blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isToEndOfLine());
    
    part = new RulePart("**blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isToEndOfLine());
    
    part = new RulePart("*blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(true,part.isToEndOfLine());
    Assert.assertEquals("blah",part.getDisplayName());
  }
  
  @Test
  public void isAlphanumeric()
  {
    RulePart part = new RulePart("blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(false,part.isAlphanumeric());
    
    part = new RulePart("~blah",null);
    part.setType(RulePart.Type.Variable);
    Assert.assertEquals(true,part.isAlphanumeric());
    Assert.assertEquals("blah",part.getDisplayName());
  }
  
  
  @Test
  public void eachInnerPartHasAPosition()
  {
    RulePart part = new RulePart("type,name",null);
    
    RulePartValue[] allValues = part.getInnerValues("x \n y");
    Assert.assertEquals(2,allValues.length);
    Assert.assertEquals(new Position(1,0,0),allValues[0].getPosition());
    Assert.assertEquals(new Position(2,1,4),allValues[1].getPosition());
  }
  
  @Test
  public void isWithinLimits()
  {
    RulePart part = new RulePart("type,name",null);
    Assert.assertEquals(true,part.isWithinLimits(0));
    Assert.assertEquals(true,part.isWithinLimits(1));
    Assert.assertEquals(true,part.isWithinLimits(2));
    Assert.assertEquals(true,part.isWithinLimits(3));
    Assert.assertEquals(true,part.isWithinLimits(-1));
    
    part.setMaximumPartsFound(3);
    Assert.assertEquals(true,part.isWithinLimits(0));
    Assert.assertEquals(true,part.isWithinLimits(1));
    Assert.assertEquals(true,part.isWithinLimits(2));
    Assert.assertEquals(false,part.isWithinLimits(3));
    Assert.assertEquals(false,part.isWithinLimits(4));
  }

}
