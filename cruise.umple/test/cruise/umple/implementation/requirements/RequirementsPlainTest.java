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
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUseCasePlain.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUseCaseStructured.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUseCaseStructuredPartial.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqUseCaseMultipleSteps.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqHideImpl.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqHideStatements.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqHideStatementsQuality.test.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqSortStat.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqSortStatVisibleText.test.html");
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
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqQualityOnly.test.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqQualityWithUserStory.test.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqQualityWithImplements.test.html");
    SampleFileWriter.destroy(pathToInput + "/requirements/ReqQualityCompare.test.html");
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
  public void useCasePlain()
  {
    assertUmpleTemplateFor("requirements/ReqUseCasePlain.ump","requirements/ReqUseCasePlain.html.txt");
  }
  @Test
  public void useCaseStructured()
  {
    assertUmpleTemplateFor("requirements/ReqUseCaseStructured.ump","requirements/ReqUseCaseStructured.html.txt");
  }
  @Test
  public void useCaseStructuredPartial()
  {
    assertUmpleTemplateFor("requirements/ReqUseCaseStructuredPartial.ump","requirements/ReqUseCaseStructuredPartial.html.txt");
  }
  @Test
  public void useCaseMultipleSteps()
  {
    assertUmpleTemplateFor("requirements/ReqUseCaseMultipleSteps.ump","requirements/ReqUseCaseMultipleSteps.html.txt");
  }

  @Test
  public void ReqHideImpl()
  {
    assertUmpleTemplateFor("requirements/ReqHideImpl.ump","requirements/ReqHideImpl.html.txt");
  }

  @Test
  public void ReqHideStatements()
  {
    assertUmpleTemplateFor("requirements/ReqHideStatements.ump","requirements/ReqHideStatements.html.txt");
  }

  @Test
  public void ReqHideStatementsQuality()
  {
    assertUmpleTemplateFor("requirements/ReqHideStatementsQuality.test.ump","requirements/ReqHideStatementsQuality.test.expectedresult.html");
  }

  @Test
  public void ReqSortStat()
  {
    assertUmpleTemplateFor("requirements/ReqSortStat.ump","requirements/ReqSortStat.html.txt");
  }

  @Test
  public void ReqSortStatVisibleText()
  {
    assertUmpleTemplateFor("requirements/ReqSortStatVisibleText.test.ump","requirements/ReqSortStatVisibleText.test.expectedresult.html");
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

  @Test
  public void ReqQualityOnly()
  {
    assertUmpleTemplateFor("requirements/ReqQualityOnly.test.ump","requirements/ReqQualityOnly.test.expectedresult.html");
  }

  @Test
  public void ReqQualityWithUserStory()
  {
    assertUmpleTemplateFor("requirements/ReqQualityWithUserStory.test.ump","requirements/ReqQualityWithUserStory.test.expectedresult.html");
  }

  @Test
  public void ReqQualityWithImplements()
  {
    assertUmpleTemplateFor("requirements/ReqQualityWithImplements.test.ump","requirements/ReqQualityWithImplements.test.expectedresult.html");
  }

  @Test
  public void ReqQualityCompare()
  {
    assertUmpleTemplateFor("requirements/ReqQualityCompare.test.ump","requirements/ReqQualityCompare.test.expectedresult.html");
  }
}
