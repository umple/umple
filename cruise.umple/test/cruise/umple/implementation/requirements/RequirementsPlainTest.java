package cruise.umple.implementation.requirements;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class RequirementsPlainTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "PlainRequirementsDoc";
    languagePath = "plainRequirementsDoc";
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/requirements/Sort2Reqs.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortReqsImplsInside.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortReqsImplsOutside.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortReqsSameID.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortOneReq.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortMultipleReqs.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/SortReqsStartA.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqHideNotImpl.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqNotImpl.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqMultipleItems.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUserStoryPlain.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUserStoryStructured.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUserStoryStructuredPartial.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUserStoryWhoOnly.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqAssociation.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqAssociationBidir.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqAssociationLeftNav.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqAttribute.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqStateMachine.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqAssociationClass.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqMethod.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqTrait.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqInterface.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqMethodInTrait.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqEnum.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqMixset.html");
  }

  @Test
  public void Sort2Reqs()
  {
    assertUmpleTemplateFor("requirements/Sort2Reqs.ump","requirements/Sort2Reqs.html.txt");
  }
 
  @Test
  public void SortReqsInsideImpl()
  {
    assertUmpleTemplateFor("requirements/SortReqsImplsInside.ump","requirements/SortReqsImplsInside.html.txt");
  }
  
  @Test
  public void SortReqsOutsideImpl()
  {
    assertUmpleTemplateFor("requirements/SortReqsImplsOutside.ump","requirements/SortReqsImplsOutside.html.txt");
  }
  
  @Test
  public void SortReqsSameID()
  {
    assertUmpleTemplateFor("requirements/SortReqsSameID.ump","requirements/SortReqsSameID.html.txt");
  }
  
  @Test
  public void SortOneReq()
  {
    assertUmpleTemplateFor("requirements/SortOneReq.ump","requirements/SortOneReq.html.txt");
  }
  
  @Test
  public void SortMultipleReqs()
  {
    assertUmpleTemplateFor("requirements/SortMultipleReqs.ump","requirements/SortMultipleReqs.html.txt");
  }
  
  @Test
  public void SortReqsStartA()
  {
    assertUmpleTemplateFor("requirements/SortReqsStartA.ump","requirements/SortReqsStartA.html.txt");
  }
  
  @Test
  public void ReqHideNotImpl()
  {
    assertUmpleTemplateFor("requirements/ReqHideNotImpl.ump","requirements/ReqHideNotImpl.html.txt");
  }
  
  @Test
  public void ReqNotImpl()
  {
    assertUmpleTemplateFor("requirements/ReqNotImpl.ump","requirements/ReqNotImpl.html.txt");
  }
   @Test
  public void ReqMultipleItems()
  {
    assertUmpleTemplateFor("requirements/ReqMultipleItems.ump","requirements/ReqMultipleItems.html.txt");
  }

  @Test
  public void userStoryStructured()
  {
    assertUmpleTemplateFor("requirements/ReqUserStoryStructured.ump", "requirements/ReqUserStoryStructured.html.txt");
  }
  @Test
  public void userStoryStructuredPartial()
  {
    assertUmpleTemplateFor("requirements/ReqUserStoryStructuredPartial.ump","requirements/ReqUserStoryStructuredPartial.html.txt");
  }
  @Test
  public void userStoryPlain()
  {
    assertUmpleTemplateFor("requirements/ReqUserStoryPlain.ump","requirements/ReqUserStoryPlain.html.txt");
  }
  @Test
  public void userStoryWhoOnly()
  {
    assertUmpleTemplateFor("requirements/ReqUserStoryWhoOnly.ump","requirements/ReqUserStoryWhoOnly.html.txt");
  }

  @Test
  public void ReqAssociation()
  {
    assertUmpleTemplateFor("requirements/ReqAssociation.ump","requirements/ReqAssociation.html.txt");
  }

  @Test
  public void ReqAssociationBidir()
  {
    assertUmpleTemplateFor("requirements/ReqAssociationBidir.ump","requirements/ReqAssociationBidir.html.txt");
  }

  @Test
  public void ReqAssociationLeftNav()
  {
    assertUmpleTemplateFor("requirements/ReqAssociationLeftNav.ump","requirements/ReqAssociationLeftNav.html.txt");
  }

  @Test
  public void ReqAttribute()
  {
    assertUmpleTemplateFor("requirements/ReqAttribute.ump","requirements/ReqAttribute.html.txt");
  }

  @Test
  public void ReqStateMachine()
  {
    assertUmpleTemplateFor("requirements/ReqStateMachine.ump","requirements/ReqStateMachine.html.txt");
  }

  @Test
  public void ReqAssociationClass()
  {
    assertUmpleTemplateFor("requirements/ReqAssociationClass.ump","requirements/ReqAssociationClass.html.txt");
  }

  @Test
  public void ReqMethod()
  {
    assertUmpleTemplateFor("requirements/ReqMethod.ump","requirements/ReqMethod.html.txt");
  }

  @Test
  public void ReqTrait()
  {
    assertUmpleTemplateFor("requirements/ReqTrait.ump","requirements/ReqTrait.html.txt");
  }

  @Test
  public void ReqInterface()
  {
    assertUmpleTemplateFor("requirements/ReqInterface.ump","requirements/ReqInterface.html.txt");
  }

  @Test
  public void ReqMethodInTrait()
  {
    assertUmpleTemplateFor("requirements/ReqMethodInTrait.ump","requirements/ReqMethodInTrait.html.txt");
  }

  @Test
  public void ReqEnum()
  {
    assertUmpleTemplateFor("requirements/ReqEnum.ump","requirements/ReqEnum.html.txt");
  }

  @Test
  public void ReqMixset()
  {
    assertUmpleTemplateFor("requirements/ReqMixset.ump","requirements/ReqMixset.html.txt");
  }
}
