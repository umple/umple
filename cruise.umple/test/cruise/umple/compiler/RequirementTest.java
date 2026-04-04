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
    Requirement c = new Requirement("R01","blah2", null, null, null, null, "");
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
    Requirement newReq = new Requirement("R01", "a", null, null, null, null, "");
    model.getAllRequirements().put("R01",newReq);
    allTestRequirementsImpl.add(new ReqImplementation("R01",reqTok));
    String output = Requirement.format("Slashes",allTestRequirementsImpl,model);
    Assert.assertEquals("// R01: a",output);
  }
  

  @Test
  public void format_multipleRequirements()
  {
    Requirement newReq1 = new Requirement("R01", "a", null, null, null, null, "");
    Requirement newReq2 = new Requirement("R02", "a2", null, null, null, null, "");
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
    Requirement req = new Requirement("US1", "As a customer...", null, null, null, null, "userStory");
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
    Requirement original = new Requirement("US2", "As an administrator...", null, null, null, null, "userStory");
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

  @Test
  public void useCaseStepsStoredInOrder()
  {
    Requirement req = new Requirement("UC1", "checkout flow", null, null, null, null, "useCase");

    req.addUseCaseStep(new UseCaseStep("1", "userStep", "select product"));
    req.addUseCaseStep(new UseCaseStep("1", "systemResponse", "display price"));
    req.addUseCaseStep(new UseCaseStep("2", "userStep", "enter quantity"));

    Assert.assertEquals(3, req.numberOfUseCaseStep());

    Assert.assertEquals("1", req.getUseCaseStep(0).getId());
    Assert.assertEquals("userStep", req.getUseCaseStep(0).getStepType());
    Assert.assertEquals("select product", req.getUseCaseStep(0).getContent());

    Assert.assertEquals("1", req.getUseCaseStep(1).getId());
    Assert.assertEquals("systemResponse", req.getUseCaseStep(1).getStepType());
    Assert.assertEquals("display price", req.getUseCaseStep(1).getContent());

    Assert.assertEquals("2", req.getUseCaseStep(2).getId());
    Assert.assertEquals("userStep", req.getUseCaseStep(2).getStepType());
    Assert.assertEquals("enter quantity", req.getUseCaseStep(2).getContent());
  }
  @Test
  public void deepCopyConstructorCopiesUseCaseSteps()
  {
    Requirement original = new Requirement("UC2", "checkout flow", null, null, null, null, "useCase");
    original.addUseCaseStep(new UseCaseStep("1", "userStep", "select product"));
    original.addUseCaseStep(new UseCaseStep("1", "systemResponse", "display price"));

    Requirement copy = new Requirement(original);

    Assert.assertEquals(2, copy.numberOfUseCaseStep());

    Assert.assertEquals("1", copy.getUseCaseStep(0).getId());
    Assert.assertEquals("userStep", copy.getUseCaseStep(0).getStepType());
    Assert.assertEquals("select product", copy.getUseCaseStep(0).getContent());

    Assert.assertEquals("1", copy.getUseCaseStep(1).getId());
    Assert.assertEquals("systemResponse", copy.getUseCaseStep(1).getStepType());
    Assert.assertEquals("display price", copy.getUseCaseStep(1).getContent());
  }
}
