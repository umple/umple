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
    
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/model.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/model.di");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/model.notation");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.di");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.notation");    
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus/.project");
    File destroyDirPap = new File(pathToInput + "/papyrus/Papyrus");
    destroyDirPap.delete();
    
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations/model.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations/model.di");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations/model.notation");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations/.project");
    File destroyDirAss = new File(pathToInput + "/papyrus/Associations");
    destroyDirAss.delete();
    
    SampleFileWriter.destroy("/myfile/model.di");
    SampleFileWriter.destroy("/myfile/model.notation");
    SampleFileWriter.destroy("/myfile/model.uml");
    SampleFileWriter.destroy("/myfile/model");
    SampleFileWriter.destroy("/myfile");
  }

  @Test
  public void Papyrus()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Papyrus.ump","papyrus/Papyrus.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/Garage_GarageDoor.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus/.project")).exists());
    
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Associations.ump","papyrus/Associations.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Associations/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Associations/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Associations/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Associations/.project")).exists());
  }  
  
  
}
