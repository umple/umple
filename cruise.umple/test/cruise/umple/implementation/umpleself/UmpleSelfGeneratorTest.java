package cruise.umple.implementation.umpleself;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class UmpleSelfGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = null;
    languagePath = "umpleself";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/umpleself/Attributes.umpself");
    SampleFileWriter.destroy(pathToInput + "/umpleself/Associations.umpself");
    SampleFileWriter.destroy(pathToInput + "/umpleself/StateMachines.umpself");
  }

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("umpleself/Attributes.ump","umpleself/Attributes.ump.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/umpleself/Attributes.umpself")).exists());
  }  

  @Test
  public void Associations()
  {
    assertUmpleTemplateFor("umpleself/Associations.ump","umpleself/Associations.ump.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/umpleself/Associations.umpself")).exists());
  }

  @Test
  public void StateMachines()
  {
    assertUmpleTemplateFor("umpleself/StateMachines.ump","umpleself/StateMachines.ump.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/umpleself/StateMachines.umpself")).exists());
  }

}
