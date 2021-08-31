/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.util.*;
import org.junit.*;

public class RequirementTest
{
  
  ArrayList<Requirement> allTestRequirements;
  
  @Before
  public void setUp()
  {
    allTestRequirements = new ArrayList<Requirement>();
  }
  
  @Test
  public void constructor()
  {
    Requirement c = new Requirement("R01","blah2","");
    Assert.assertEquals("blah2",c.getStatement());
  }
  
  @Test
  public void format_null()
  {
    String output = Requirement.format("Slashes",allTestRequirements);
    Assert.assertEquals(null,output);
  }
  
  @Test
  public void format_oneRequirement()
  {
    allTestRequirements.add(new Requirement("R01","a",""));
    String output = Requirement.format("Slashes",allTestRequirements);
    Assert.assertEquals("// R01: a",output);
  }
  

  @Test
  public void format_multipleRequirements()
  {
    allTestRequirements.add(new Requirement("R01","a",""));
    allTestRequirements.add(new Requirement("R02","a2",""));
    String output = Requirement.format("Slashes",allTestRequirements);
    Assert.assertEquals("// R01: a\n// R02: a2",output);
  }

}
