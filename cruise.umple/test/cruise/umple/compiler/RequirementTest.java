/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

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

  @Test
  public void structuredFieldsStored()
  {
    Requirement req = new Requirement("US1", "As a customer...", "userStory");
    req.setWho("customer");
    req.setWhen("password is forgotten");
    req.setWhat("reset my password");
    req.setWhy("regain access to my account");

    Assert.assertEquals("customer", req.getWho());
    Assert.assertEquals("password is forgotten", req.getWhen());
    Assert.assertEquals("reset my password", req.getWhat());
    Assert.assertEquals("regain access to my account", req.getWhy());
  }

  @Test
  public void deepCopyConstructorCopiesStructuredFields()
  {
    Requirement original = new Requirement("US2", "As an administrator...", "userStory");
    original.setWho("administrator");
    original.setWhen("account review");
    original.setWhat("manage users");
    original.setWhy("maintain the system");

    Requirement copy = new Requirement(original);

    Assert.assertEquals("administrator", copy.getWho());
    Assert.assertEquals("account review", copy.getWhen());
    Assert.assertEquals("manage users", copy.getWhat());
    Assert.assertEquals("maintain the system", copy.getWhy());
    Assert.assertEquals(original.getStatement(), copy.getStatement());
    Assert.assertEquals(original.getLanguage(), copy.getLanguage());
  }

}
