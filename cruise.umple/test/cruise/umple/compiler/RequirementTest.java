/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.util.*;
import org.junit.*;
import cruise.umple.parser.Token;

public class RequirementTest
{
  ArrayList<ReqImplementation> allTestRequirementsImpl;
  UmpleModel model = new UmpleModel(null); 
  Token reqTok = new Token("",""); 
  Token reqTok1 = new Token("",""); 
  
  @Before
  public void setUp()
  {
    allTestRequirementsImpl = new ArrayList<ReqImplementation>();
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
    String output = Requirement.format("Slashes",allTestRequirementsImpl,model);
    Assert.assertEquals(null,output);
  }
  
  @Test
  public void format_oneRequirement()
  {
    Requirement newReq = new Requirement("R01", "a", "");
    model.getAllRequirements().put("R01",newReq);
    allTestRequirementsImpl.add(new ReqImplementation("R01",reqTok));
    String output = Requirement.format("Slashes",allTestRequirementsImpl,model);
    Assert.assertEquals("// R01: a",output);
  }
  

  @Test
  public void format_multipleRequirements()
  {
    Requirement newReq1 = new Requirement("R01", "a", "");
    Requirement newReq2 = new Requirement("R02", "a2", "");
    model.getAllRequirements().put("R01",newReq1);
    model.getAllRequirements().put("R02",newReq2);
    allTestRequirementsImpl.add(new ReqImplementation("R01",reqTok));
    allTestRequirementsImpl.add(new ReqImplementation("R02",reqTok1));
    String output = Requirement.format("Slashes",allTestRequirementsImpl,model);
    Assert.assertEquals("// R01: a\n// R02: a2",output);
  }

}
