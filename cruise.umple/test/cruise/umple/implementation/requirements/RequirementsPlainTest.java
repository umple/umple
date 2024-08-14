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
}
