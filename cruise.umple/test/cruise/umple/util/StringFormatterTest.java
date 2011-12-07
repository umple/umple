/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.util;

import java.io.File;

import org.junit.*;

import cruise.umple.util.StringFormatter;

public class StringFormatterTest
{

  @Test
  public void noTranslation()
  {
    String answer = StringFormatter.format("What is up","nothing");
    Assert.assertEquals("What is up",answer);

    answer = StringFormatter.format("What is up");
    Assert.assertEquals("What is up",answer);

    answer = StringFormatter.format("What is up","a","b");
    Assert.assertEquals("What is up",answer);
    
  }
  
  @Test
  public void oneTranslation()
  {
    String answer = StringFormatter.format("What is up? {0}","nothing");
    Assert.assertEquals("What is up? nothing",answer);
  }  
  
  @Test
  public void nullOneTranslation()
  {
    String answer = StringFormatter.format("What is up? {0}",(Object)null);
    Assert.assertEquals("What is up? ",answer);

  }    
  
  @Test
  public void multipleTranslations()
  {
    String answer = StringFormatter.format("What {1} up? {0}","nothings","are");
    Assert.assertEquals("What are up? nothings",answer);
  }  
  
  @Test
  public void nullMultipleTranslations()
  {
    String answer = StringFormatter.format("What {1} up? {0}","nothings",null);
    Assert.assertEquals("What  up? nothings",answer);
  }  
  
  @Test
  public void dealingWithObjects()
  {
    String aha = "one";
    String answer = StringFormatter.format("What {1} up? {0}",aha,null);
    Assert.assertEquals("What  up? one",answer);
  }    
  
  @Test
  public void replaceParameter_EmptyString()
  {
    String answer = StringFormatter.replaceParameter("","aMentor","this");
    Assert.assertEquals("",answer);
    
    answer = StringFormatter.replaceParameter(null,"aMentor","this");
    Assert.assertEquals("",answer);
  }
  
  @Test
  public void replaceParameter_First()
  {
    String answer = StringFormatter.replaceParameter("aMentor","aMentor","this");
    Assert.assertEquals("this",answer);

    answer = StringFormatter.replaceParameter("aMentor, aStudent","aMentor","this");
    Assert.assertEquals("this, aStudent",answer);

    answer = StringFormatter.replaceParameter("aMentor, aStudent, aSupervisor","aMentor","this");
    Assert.assertEquals("this, aStudent, aSupervisor",answer);
    
    
    answer = StringFormatter.replaceParameter("aMentor, aMentor2, aStudent, aMentor3","aMentor","this");
    Assert.assertEquals("this, aMentor2, aStudent, aMentor3",answer);
    
  }  
  
  @Test
  public void replaceParameter_Last()
  {
    String answer = StringFormatter.replaceParameter("aStudent, aMentor","aMentor","this");
    Assert.assertEquals("aStudent, this",answer);

    answer = StringFormatter.replaceParameter("aStudent, aSupervisor, aMentor","aMentor","this");
    Assert.assertEquals("aStudent, aSupervisor, this",answer);
    
    
    answer = StringFormatter.replaceParameter("aMentor2, aStudent, aMentor3, aMentor,","aMentor","this");
    Assert.assertEquals("aMentor2, aStudent, aMentor3, this",answer);
    
  }    
  
  @Test
  public void replaceParameter_Middle()
  {
    String answer = StringFormatter.replaceParameter("aStudent, aMentor, aSupervisor","aMentor","this");
    Assert.assertEquals("aStudent, this, aSupervisor",answer);

    answer = StringFormatter.replaceParameter("aMentor2, aMentor, aStudent, aMentor3","aMentor","this");
    Assert.assertEquals("aMentor2, this, aStudent, aMentor3",answer);
  }   
  
  
  @Test
  public void replaceParameter_Multiple()
  {
    String answer = StringFormatter.replaceParameter("aMentor, aStudent, aMentor, aSupervisor, aMentor, aMentor2 , aMentor","aMentor","this");
    Assert.assertEquals("this, aStudent, this, aSupervisor, this, aMentor2, this",answer);
  }   
  
  @Test
  public void replaceParameter_RemoveIfNull()
  {
    String answer = StringFormatter.replaceParameter("aMentor, aStudent","aMentor",null);
    Assert.assertEquals("aStudent",answer);
  }  
  
  @Test
  public void replaceParameter_RemoveIfEmpty_First()
  {
    String answer = StringFormatter.replaceParameter("aMentor","aMentor","");
    Assert.assertEquals("",answer);

    answer = StringFormatter.replaceParameter("aMentor, aStudent","aMentor","");
    Assert.assertEquals("aStudent",answer);

    answer = StringFormatter.replaceParameter("aMentor, aStudent, aSupervisor","aMentor","");
    Assert.assertEquals("aStudent, aSupervisor",answer);

    answer = StringFormatter.replaceParameter("aMentor, aMentor2, aStudent, aMentor3","aMentor","");
    Assert.assertEquals("aMentor2, aStudent, aMentor3",answer);
    
  }  
  
  @Test
  public void replaceParameter_RemoveIfEmpty_Last()
  {
    String answer = StringFormatter.replaceParameter("aStudent, aMentor","aMentor","");
    Assert.assertEquals("aStudent",answer);

    answer = StringFormatter.replaceParameter("aStudent, aSupervisor, aMentor","aMentor","");
    Assert.assertEquals("aStudent, aSupervisor",answer);
    
    
    answer = StringFormatter.replaceParameter("aMentor2, aStudent, aMentor3, aMentor,","aMentor","");
    Assert.assertEquals("aMentor2, aStudent, aMentor3",answer);
    
  }    
  
  @Test
  public void replaceParameter_RemoveIfEmpty_Middle()
  {
    String answer = StringFormatter.replaceParameter("aStudent, aMentor, aSupervisor","aMentor","");
    Assert.assertEquals("aStudent, aSupervisor",answer);

    answer = StringFormatter.replaceParameter("aMentor2, aMentor, aStudent, aMentor3","aMentor","");
    Assert.assertEquals("aMentor2, aStudent, aMentor3",answer);
  }   
  
  
  @Test
  public void replaceParameter_RemoveIfEmpty_Multiple()
  {
    String answer = StringFormatter.replaceParameter("aMentor, aStudent, aMentor, aSupervisor, aMentor, aMentor2 , aMentor","aMentor","");
    Assert.assertEquals("aStudent, aSupervisor, aMentor2",answer);
  }   

  @Test
  public void appendParameter_Empty()
  {
    String answer = StringFormatter.appendParameter("","TheEnd");
    Assert.assertEquals("",answer);
    
    answer = StringFormatter.appendParameter(null,"TheEnd");
    Assert.assertEquals("",answer);
  }  
  
  @Test
  public void appendParameter_One()
  {
    String answer = StringFormatter.appendParameter("aNumber","TheEnd");
    Assert.assertEquals("aNumberTheEnd",answer);
  }   

  @Test
  public void appendParameter_Multiple()
  {
    String answer = StringFormatter.appendParameter("aNumber, aName","TheEnd");
    Assert.assertEquals("aNumberTheEnd, aNameTheEnd",answer);
  }   
  
  @Test
  public void joinParameters_Empty()
  {
    String answer = StringFormatter.joinParameters("","");
    Assert.assertEquals("",answer);
    
    answer = StringFormatter.joinParameters(null,"");
    Assert.assertEquals("",answer);

    answer = StringFormatter.joinParameters("",null);
    Assert.assertEquals("",answer);
    
    answer = StringFormatter.joinParameters(null,null);
    Assert.assertEquals("",answer);
    
  }   
  
  @Test
  public void joinParameters_OneSideOnly()
  {
    String answer = StringFormatter.joinParameters("a","");
    Assert.assertEquals("a",answer);

     answer = StringFormatter.joinParameters("","b");
    Assert.assertEquals("b",answer);
    
  }  
  
  @Test
  public void joinParameters_BothSides()
  {
    String answer = StringFormatter.joinParameters("a","n");
    Assert.assertEquals("a, n",answer);
  } 
  
  @Test
  public void toPascalCase()
  {
    Assert.assertEquals(null,StringFormatter.toPascalCase(null));
    Assert.assertEquals("",StringFormatter.toPascalCase(""));
    Assert.assertEquals("X",StringFormatter.toPascalCase("x"));
    Assert.assertEquals("X",StringFormatter.toPascalCase("X"));
    Assert.assertEquals("Xo",StringFormatter.toPascalCase("Xo"));
    Assert.assertEquals("CruiseUmple",StringFormatter.toPascalCase("cruise.umple"));
  }
  
  @Test
  public void toCamelCase()
  {
    Assert.assertEquals(null,StringFormatter.toCamelCase(null));
    Assert.assertEquals("",StringFormatter.toCamelCase(""));
    Assert.assertEquals("x",StringFormatter.toCamelCase("x"));
    Assert.assertEquals("x",StringFormatter.toCamelCase("X"));
    Assert.assertEquals("xo",StringFormatter.toCamelCase("Xo"));
    Assert.assertEquals("appleTree",StringFormatter.toCamelCase("apple_tree"));
    Assert.assertEquals("appleTreeCare",StringFormatter.toCamelCase("apple_tree_care")); 
    Assert.assertEquals("appleTree",StringFormatter.toCamelCase("AppleTree"));
    Assert.assertEquals("appleTreeCare",StringFormatter.toCamelCase("AppleTreeCare")); 
    Assert.assertEquals("appleTree",StringFormatter.toCamelCase("appleTree"));
    Assert.assertEquals("appleTreeCare",StringFormatter.toCamelCase("appleTreeCare")); 
  }

  @Test
  public void toUnderscore()
  {
    Assert.assertEquals(null,StringFormatter.toUnderscore(null));
    Assert.assertEquals("",StringFormatter.toUnderscore(""));
    Assert.assertEquals("x",StringFormatter.toUnderscore("x"));
    Assert.assertEquals("x",StringFormatter.toUnderscore("X"));
    Assert.assertEquals("xo",StringFormatter.toUnderscore("Xo"));
    Assert.assertEquals("apple_tree",StringFormatter.toUnderscore("AppleTree"));
    Assert.assertEquals("apple_tree_care",StringFormatter.toUnderscore("AppleTreeCare")); 
    Assert.assertEquals("apple_tree",StringFormatter.toUnderscore("apple_tree"));
    Assert.assertEquals("apple_tree_care",StringFormatter.toUnderscore("apple_tree_care"));
  }

  @Test
  public void absolutePathsTest()
  {
    Assert.assertEquals("/abs" + File.separator,StringFormatter.addPathOrAbsolute("somepath", "/abs"));
    Assert.assertEquals("C:\\temp" + File.separator, StringFormatter.addPathOrAbsolute("somepath", "C:\\temp"));
    Assert.assertEquals("somepath" + File.separator + "abs" + File.separator, StringFormatter.addPathOrAbsolute("somepath", "abs"));
    
  }
  
  @Test
  public void StripLeadingPaths()
  {
    Assert.assertEquals("filename.ump",StringFormatter.stripLeadingPath("cdrive" + File.separator + "yo" + File.separator + "filename.ump"));
    Assert.assertEquals("filename.ump",StringFormatter.stripLeadingPath("yo" + File.separator + "filename.ump"));
    Assert.assertEquals("filename.ump",StringFormatter.stripLeadingPath("filename.ump"));
  }
  
}
