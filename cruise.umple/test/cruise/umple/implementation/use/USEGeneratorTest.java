package cruise.umple.implementation.use;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class USEGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = null;
    languagePath = "use";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/use/Attributes.use");
    SampleFileWriter.destroy(pathToInput + "/use/Associations.use");
    SampleFileWriter.destroy(pathToInput + "/use/StateMachines.use");
  }

   @Test
   public void Attributes()
   {
     assertUmpleTemplateFor("use/Attributes.ump","use/Attributes.use.txt");
     Assert.assertEquals(true, (new File(pathToInput + "/use/Attributes.use")).exists());
   }  

}
