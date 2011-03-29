package cruise.umple.implementation.xmi;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class XmiGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Xmi";
    languagePath = "xmi";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/xmi/Xmi.uml");
    SampleFileWriter.destroy(pathToInput + "/xmi/Associations.uml");
  }

  @Test
  public void Xmi()
  {
    language = null;
    assertUmpleTemplateFor("xmi/Xmi.ump","xmi/Xmi.uml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/xmi/Xmi.uml")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("xmi/Associations.ump","xmi/Associations.uml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/xmi/Associations.uml")).exists());
  }  
  
}
