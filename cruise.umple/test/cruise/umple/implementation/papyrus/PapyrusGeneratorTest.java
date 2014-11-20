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
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Spaceship");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Layout");

    SampleFileWriter.destroy("myfile");
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
    
  //ensure notation files match expected output file with generated UUID's removed
    String outputNotation = SampleFileWriter.readContent(new File(pathToInput + "/papyrus/Papyrus/model.notation"), " xmi:id=\".*?\"");
    SampleFileWriter.assertFileContent(new File(pathToInput + "/papyrus/Papyrus.notation.txt"), outputNotation, false);
    
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
    
    //ensure notation files match expected output file with generated UUID's removed
    String outputNotation = SampleFileWriter.readContent(new File(pathToInput + "/papyrus/Associations/model.notation"), " xmi:id=\".*?\"");
    SampleFileWriter.assertFileContent(new File(pathToInput + "/papyrus/Associations.notation.txt"), outputNotation, false); 
  }  
  
  @Test
  public void Spaceship()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Spaceship.ump","papyrus/Spaceship.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Spaceship/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Spaceship/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Spaceship/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Spaceship/.project")).exists());
    
    //ensure notation files match expected output file with generated UUID's removed
    String outputNotation = SampleFileWriter.readContent(new File(pathToInput + "/papyrus/Spaceship/model.notation"), " xmi:id=\".*?\"");
    SampleFileWriter.assertFileContent(new File(pathToInput + "/papyrus/Spaceship.notation.txt"), outputNotation, false); 
  }  
  
  @Test
  public void Layout()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Layout.ump","papyrus/Layout.uml.txt");
    
    //ensure all required files created appropriately
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Layout/model.uml")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Layout/model.di")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Layout/model.notation")).exists());
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Layout/.project")).exists());
    
    //ensure notation files match expected output file with generated UUID's removed
    String outputNotation = SampleFileWriter.readContent(new File(pathToInput + "/papyrus/Layout/model.notation"), " xmi:id=\".*?\"");
    SampleFileWriter.assertFileContent(new File(pathToInput + "/papyrus/Layout.notation.txt"), outputNotation, false); 
  }  
}
