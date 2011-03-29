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
    SampleFileWriter.destroy(pathToInput + "/papyrus/Papyrus.uml");
    SampleFileWriter.destroy(pathToInput + "/papyrus/Associations.uml");
  }

  @Test
  public void Papyrus()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Papyrus.ump","papyrus/Papyrus.uml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Papyrus.uml")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("papyrus/Associations.ump","papyrus/Associations.uml.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/papyrus/Associations.uml")).exists());
  }  
  
}
