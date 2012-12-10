package cruise.umple.implementation.papyrus;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class PapyrusGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Papyrus";
    languagePath = "papyrus";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    
    SampleFileWriter.destroy(pathToInput + "/papyrus/papyrus/model.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/papyrus/model.di");
    SampleFileWriter.destroy(pathToInput + "/papyrus/papyrus/model.notation");
    SampleFileWriter.destroy(pathToInput + "/papyrus/papyrus/.project");
    File destroyDirPap = new File(pathToInput + "/papyrus/papyrus");
    destroyDirPap.delete();
    
    SampleFileWriter.destroy(pathToInput + "/papyrus/associations/model.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/associations/model.di");
    SampleFileWriter.destroy(pathToInput + "/papyrus/associations/model.notation");
    SampleFileWriter.destroy(pathToInput + "/papyrus/associations/.project");
    File destroyDirAss = new File(pathToInput + "/papyrus/associations");
    destroyDirAss.delete();
    
  }

  @Test
  public void Papyrus()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Papyrus.ump","papyrus/Papyrus.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/papyrus/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/papyrus/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/papyrus/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/papyrus/.project")).exists());
    
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Associations.ump","papyrus/Associations.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/associations/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/associations/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/associations/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/associations/.project")).exists());
  }  
  
}
