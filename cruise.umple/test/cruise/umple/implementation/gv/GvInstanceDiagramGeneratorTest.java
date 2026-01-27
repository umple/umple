package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvInstanceDiagramGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "InstanceDiagram";
    languagePath = "gv";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/gv/TooManyAssociationscid.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/InheritanceErrorOnecid.gv");
  }


  @Test
  public void max_Class_Count_Error()
  {
    assertUmplePartialTemplateFor("gv/TooManyAssociations.ump","gv/TooManyAssociations.gv.txt");

  }

  @Test
  public void inheritance_Error_one()
  {
    assertUmplePartialTemplateFor("gv/InheritanceErrorOne.ump","gv/InheritanceErrorOne.gv.txt");

  }

}
