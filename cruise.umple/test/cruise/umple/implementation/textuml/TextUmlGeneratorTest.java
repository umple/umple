package cruise.umple.implementation.textuml;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class TextUmlGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "TextUml";
    languagePath = "textuml";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/textuml/TextUml.tuml");
    SampleFileWriter.destroy(pathToInput + "/textuml/Associations.tuml");
  }

  @Test
  public void TextUml()
  {
    language = null;
    assertUmpleTemplateFor("textuml/TextUml.ump","textuml/TextUml.tuml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/textuml/TextUml.tuml")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("textuml/Associations.ump","textuml/Associations.tuml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/textuml/Associations.tuml")).exists());
  }  
  
}
