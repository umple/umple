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

    new UseCaseStep("1", UseCaseStep.UseCaseStepType.UserStep, "select product", req);
    new UseCaseStep("1", UseCaseStep.UseCaseStepType.SystemResponse, "display price", req);
    new UseCaseStep("2", UseCaseStep.UseCaseStepType.UserStep, "enter quantity", req);

    Assert.assertEquals(3, req.numberOfUseCaseSteps());

    Assert.assertEquals("1", req.getUseCaseStep(0).getId());
    Assert.assertEquals(UseCaseStep.UseCaseStepType.UserStep, req.getUseCaseStep(0).getStepType());
    Assert.assertEquals("select product", req.getUseCaseStep(0).getContent());

    Assert.assertEquals("1", req.getUseCaseStep(1).getId());
    Assert.assertEquals(UseCaseStep.UseCaseStepType.SystemResponse, req.getUseCaseStep(1).getStepType());
    Assert.assertEquals("display price", req.getUseCaseStep(1).getContent());

    Assert.assertEquals("2", req.getUseCaseStep(2).getId());
    Assert.assertEquals(UseCaseStep.UseCaseStepType.UserStep, req.getUseCaseStep(2).getStepType());
    Assert.assertEquals("enter quantity", req.getUseCaseStep(2).getContent());
  }
  @Test
  public void deepCopyConstructorCopiesUseCaseSteps()
  {
    Requirement original = new Requirement("UC2", "checkout flow", null, null, null, null, "useCase");
    new UseCaseStep("1", UseCaseStep.UseCaseStepType.UserStep, "select product", original);
    new UseCaseStep("1", UseCaseStep.UseCaseStepType.SystemResponse, "display price", original);

    Requirement copy = new Requirement(original);

    Assert.assertEquals(2, copy.numberOfUseCaseSteps());

    Assert.assertEquals("1", copy.getUseCaseStep(0).getId());
    Assert.assertEquals(UseCaseStep.UseCaseStepType.UserStep, copy.getUseCaseStep(0).getStepType());
    Assert.assertEquals("select product", copy.getUseCaseStep(0).getContent());

    Assert.assertEquals("1", copy.getUseCaseStep(1).getId());
    Assert.assertEquals(UseCaseStep.UseCaseStepType.SystemResponse, copy.getUseCaseStep(1).getStepType());
    Assert.assertEquals("display price", copy.getUseCaseStep(1).getContent());
  }

  @Test
  public void qualityClassesStored()
  {
    Requirement req = new Requirement("Q1", "", null, null, null, null, "quality");
    new QualityClass("High", "", req);
    new QualityClass("Medium", "", req);
    new QualityClass("Low", "", req);

    Assert.assertEquals(3, req.numberOfQualityClasses());
    Assert.assertEquals("High", req.getQualityClass(0).getName());
    Assert.assertEquals("Medium", req.getQualityClass(1).getName());
    Assert.assertEquals("Low", req.getQualityClass(2).getName());
    Assert.assertEquals("", req.getQualityClass(0).getContent());
  }

  @Test
  public void deepCopyConstructorCopiesQualityClasses()
  {
    Requirement original = new Requirement("Q2", "", null, null, null, null, "quality");
    new QualityClass("Fast", "", original);
    new QualityClass("Slow", "", original);

    Requirement copy = new Requirement(original);

    Assert.assertEquals(2, copy.numberOfQualityClasses());
    Assert.assertEquals("Fast", copy.getQualityClass(0).getName());
    Assert.assertEquals("Slow", copy.getQualityClass(1).getName());
    Assert.assertEquals("", copy.getQualityClass(0).getContent());
    Assert.assertEquals(original.getLanguage(), copy.getLanguage());
  }

  @Test
  public void qualityClassSingleEntry()
  {
    Requirement req = new Requirement("Q3", "", null, null, null, null, "quality");
    new QualityClass("Reliability", "", req);

    Assert.assertEquals(1, req.numberOfQualityClasses());
    Assert.assertEquals("Reliability", req.getQualityClass(0).getName());
    Assert.assertEquals("", req.getQualityClass(0).getContent());
  }

  @Test
  public void qualityClassNonEmptyContent()
  {
    Requirement req = new Requirement("Q4", "", null, null, null, null, "quality");
    new QualityClass("Performance", "some body", req);

    Assert.assertEquals(1, req.numberOfQualityClasses());
    Assert.assertEquals("Performance", req.getQualityClass(0).getName());
    Assert.assertEquals("some body", req.getQualityClass(0).getContent());
  }

  @Test
  public void deepCopyZeroQualityClasses()
  {
    Requirement original = new Requirement("Q5", "", null, null, null, null, "quality");

    Requirement copy = new Requirement(original);

    Assert.assertEquals(0, copy.numberOfQualityClasses());
    Assert.assertEquals("quality", copy.getLanguage());
  }

  @Test
  public void deepCopyPreservesNonEmptyContent()
  {
    Requirement original = new Requirement("Q6", "", null, null, null, null, "quality");
    new QualityClass("Scalability", "must handle 1000 users", original);

    Requirement copy = new Requirement(original);

    Assert.assertEquals(1, copy.numberOfQualityClasses());
    Assert.assertEquals("Scalability", copy.getQualityClass(0).getName());
    Assert.assertEquals("must handle 1000 users", copy.getQualityClass(0).getContent());
  }

  @Test
  public void deepCopyIndependence()
  {
    Requirement original = new Requirement("Q7", "", null, null, null, null, "quality");
    new QualityClass("Usability", "", original);

    Requirement copy = new Requirement(original);
    new QualityClass("Security", "", copy);

    Assert.assertEquals(1, original.numberOfQualityClasses());
    Assert.assertEquals("Usability", original.getQualityClass(0).getName());
    Assert.assertEquals(2, copy.numberOfQualityClasses());
  }

  @Test
  public void qualityClassRemoval()
  {
    Requirement req = new Requirement("Q8", "", null, null, null, null, "quality");
    new QualityClass("High", "", req);
    QualityClass toRemove = new QualityClass("Medium", "", req);
    new QualityClass("Low", "", req);

    Assert.assertEquals(3, req.numberOfQualityClasses());

    toRemove.delete();

    Assert.assertEquals(2, req.numberOfQualityClasses());
    Assert.assertEquals("High", req.getQualityClass(0).getName());
    Assert.assertEquals("Low", req.getQualityClass(1).getName());
  }

  @Test
  public void qualityClassWithLongName()
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 150; i++)
    {
      sb.append("A");
    }
    String longName = sb.toString();

    Requirement req = new Requirement("Q9", "", null, null, null, null, "quality");
    new QualityClass(longName, "", req);

    Assert.assertEquals(1, req.numberOfQualityClasses());
    Assert.assertEquals(150, req.getQualityClass(0).getName().length());
    Assert.assertEquals(longName, req.getQualityClass(0).getName());
  }

  @Test
  public void getDisplayStatement_noQualityClasses()
  {
    Requirement req = new Requirement("R10", "plain text", null, null, null, null, "");

    Assert.assertEquals("plain text", req.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_qualityOnlyVariants()
  {
    Requirement singleQuality = new Requirement("R11", "", null, null, null, null, "");
    new QualityClass("Reliability", "", singleQuality);

    Requirement multipleQuality = new Requirement("R12", "", null, null, null, null, "");
    new QualityClass("Performance", "", multipleQuality);
    new QualityClass("Security", "", multipleQuality);

    Assert.assertEquals("[Quality: Reliability]", singleQuality.getDisplayStatement());
    Assert.assertEquals("[Quality: Performance, Security]", multipleQuality.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_plainPlusQuality()
  {
    Requirement req = new Requirement("R13", "plain text", null, null, null, null, "");
    new QualityClass("High", "", req);

    Assert.assertEquals("plain text\n[Quality: High]", req.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_noBodyWithoutQualityVariants()
  {
    Requirement emptyStatement = new Requirement("R14", "", null, null, null, null, "");
    Requirement nullStatement = new Requirement("R15", null, null, null, null, null, "");

    Assert.assertEquals("", emptyStatement.getDisplayStatement());
    Assert.assertEquals("", nullStatement.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_preservedByDeepCopy()
  {
    Requirement original = new Requirement("R16", "track items", null, null, null, null, "");
    new QualityClass("Performance", "", original);
    new QualityClass("Security", "", original);

    Requirement copy = new Requirement(original);

    Assert.assertEquals("track items\n[Quality: Performance, Security]", copy.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_nullStatementWithQuality()
  {
    Requirement req = new Requirement("R17", null, null, null, null, null, "");
    new QualityClass("Safety", "", req);

    Assert.assertEquals("[Quality: Safety]", req.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_whitespaceOnlyStatementWithQuality()
  {
    Requirement req = new Requirement("R18", "   ", null, null, null, null, "");
    new QualityClass("Performance", "", req);

    Assert.assertEquals("[Quality: Performance]", req.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_userStoryWithQuality()
  {
    Requirement req = new Requirement("US1", "", null, null, null, null, "userStory");
    req.setWho("developer");
    req.setWhat("track items");
    new QualityClass("Performance", "", req);
    new QualityClass("Security", "", req);

    Assert.assertEquals("As developer\nI want track items\n[Quality: Performance, Security]", req.getDisplayStatement());
  }

  @Test
  public void getDisplayStatement_useCaseWithQuality()
  {
    Requirement req = new Requirement("UC3", "checkout flow", null, null, null, null, "useCase");
    new UseCaseStep("1", UseCaseStep.UseCaseStepType.UserStep, "select product", req);
    new UseCaseStep("1", UseCaseStep.UseCaseStepType.SystemResponse, "display price", req);
    new QualityClass("Performance", "", req);

    Assert.assertEquals(
      "checkout flow\nUser step 1: select product\nSystem response 1: display price\n[Quality: Performance]",
      req.getDisplayStatement()
    );
  }

  @Test
  public void format_requirementWithQualityClasses()
  {
    Requirement req = new Requirement("R01", "a", null, null, null, null, "");
    new QualityClass("Performance", "", req);
    new QualityClass("Security", "", req);
    model.getAllRequirements().put("R01", req);
    allTestRequirementsImpl.add(new ReqImplementation("R01", reqTok));

    String output = Requirement.format("Slashes", allTestRequirementsImpl, model);

    Assert.assertEquals("// R01: a\n// [Quality: Performance, Security]", output);
  }

  @Test
  public void format_structuredRequirementWithQuality()
  {
    Requirement req = new Requirement("US9", "", null, null, null, null, "userStory");
    req.setWho("developer");
    req.setWhat("track items");
    new QualityClass("Performance", "", req);
    model.getAllRequirements().put("US9", req);
    allTestRequirementsImpl.add(new ReqImplementation("US9", reqTok));

    String output = Requirement.format("Slashes", allTestRequirementsImpl, model);

    Assert.assertEquals("// US9: As developer\n// I want track items\n// [Quality: Performance]", output);
  }

  @Test
  public void format_multipleRequirementsWithQuality()
  {
    Requirement reqWithQuality = new Requirement("R01", "a", null, null, null, null, "");
    new QualityClass("High", "", reqWithQuality);
    Requirement reqWithoutQuality = new Requirement("R02", "b", null, null, null, null, "");
    model.getAllRequirements().put("R01", reqWithQuality);
    model.getAllRequirements().put("R02", reqWithoutQuality);
    allTestRequirementsImpl.add(new ReqImplementation("R01", reqTok));
    allTestRequirementsImpl.add(new ReqImplementation("R02", reqTok1));

    String output = Requirement.format("Slashes", allTestRequirementsImpl, model);

    Assert.assertEquals("// R01: a\n// [Quality: High]\n// R02: b", output);
  }
}
