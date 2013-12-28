package cruise.umple.implementation.umple;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class UmpleGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Umple";
    languagePath = "umple";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/umple/X.ump");
    SampleFileWriter.destroy(pathToInput + "/umple/X1.ump");
    SampleFileWriter.destroy(pathToInput + "/umple/X2.ump");
  }

  // @Test
  // public void Attributes()
  // {
  //   language = null;
  //   createUmpleSystem(pathToInput, "umple/Attributes.ump");
    
  //   assertGeneratedCodeEquals(pathToInput,"/umple/X.ump");
  //   assertGeneratedCodeEquals(pathToInput,"/umple/X1.ump");
  //   assertGeneratedCodeEquals(pathToInput,"/umple/X2.ump");
  // }  

}
