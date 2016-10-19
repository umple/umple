package cruise.umple.implementation.simulate;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class SimulateGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Simulate";
    languagePath = "simulate";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/simulate/model.php");
  }

  @Test
  public void Language_EmptyClass()
  {
    language = null;
    assertUmpleTemplateFor("simulate/Language.ump","simulate/Language.simulate.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/simulate/model.php")).exists());
  }  

  @Test
  public void Attributes()
  {
    language = null;
    assertUmpleTemplateFor("simulate/Attributes.ump","simulate/Attributes.simulate.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/simulate/model.php")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("simulate/Associations.ump","simulate/Associations.simulate.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/simulate/model.php")).exists());
  }  

  @Test
  public void StateMachine()
  {
    assertUmpleTemplateFor("simulate/StateMachine.ump","simulate/StateMachine.simulate.txt");
  }
  
}
