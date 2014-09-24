package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvCdGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "GvClassDiagram";
    languagePath = "gv";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/gv/Attributescd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Methodscd.gv");
  }

  @Test
  public void tooltips_for_attributes()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Attributes.ump","gv/Attributes.gv.txt");
  }  
  
  @Test
  public void tooltips_for_methods()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Methods.ump","gv/Methods.gv.txt");
  } 
}
