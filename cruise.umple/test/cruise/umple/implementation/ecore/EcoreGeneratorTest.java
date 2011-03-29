package cruise.umple.implementation.ecore;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class EcoreGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ecore";
    languagePath = "ecore";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/ecore/Ecore.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/Associations.ecore");
  }

  @Test
  public void Ecore()
  {
    language = null;
    assertUmpleTemplateFor("ecore/Ecore.ump","ecore/Ecore.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/Ecore.ecore")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("ecore/Associations.ump","ecore/Associations.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/Associations.ecore")).exists());
  }  
  
}
