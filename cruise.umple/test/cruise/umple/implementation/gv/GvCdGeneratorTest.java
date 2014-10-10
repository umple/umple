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
    SampleFileWriter.destroy(pathToInput + "/gv/Abstractcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Associationscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Interfacecd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ManyClasscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ManyClassAbstractcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/EmptyClasscd.gv");
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

  @Test
  public void display_empty_class()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/EmptyClass.ump","gv/EmptyClass.gv.txt");
  } 
  
  @Test
  public void display_abstract()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Abstract.ump","gv/Abstract.gv.txt");
  } 

  @Test
  public void display_associations()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Associations.ump","gv/Associations.gv.txt");
  }

  @Test
  public void display_interface()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Interface.ump","gv/Interface.gv.txt");
  }
  @Test
  public void display_many_classes()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ManyClass.ump","gv/ManyClass.gv.txt");
  } 
  
  @Test
  public void display_many_class_abstract()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ManyClassAbstract.ump","gv/ManyClassAbstract.gv.txt");
  } 
}
