package cruise.umple.implementation.ecore;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class EcoreGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ecore";
    languagePath = "ecore";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/ecore/Ecore.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/Associations.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/NoNamespace.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/Namespace.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/MultipleInterfaces.ecore");
    SampleFileWriter.destroy(pathToInput + "/ecore/AssociationsUnidirection.ecore");
  }

  @Test
  public void Ecore()
  {
    language = null;
    assertUmpleTemplateFor("ecore/Ecore.ump","ecore/Ecore.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/Ecore.ecore")).exists());
  }  

  @Test
  public void Associations()
  {
    language = null;
    assertUmpleTemplateFor("ecore/Associations.ump","ecore/Associations.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/Associations.ecore")).exists());
  }
  
  @Test
  public void UnidirectionalAssocaitions()
  {
    language = null;
    assertUmpleTemplateFor("ecore/AssociationsUnidirection.ump","ecore/AssociationsUnidirection.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/AssociationsUnidirection.ecore")).exists());
  }  
  
  @Test
  public void Namespaces()
  {
    language = null;
    assertUmpleTemplateFor("ecore/Namespace.ump","ecore/Namespace.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/Namespace.ecore")).exists());
  }  
  
  @Test
  public void No_Namespaces()
  {
    language = null;
    assertUmpleTemplateFor("ecore/NoNamespace.ump","ecore/NoNamespace.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/NoNamespace.ecore")).exists());
  }  
  
  @Test
  public void Multiple_Interfaces()
  {
    language = null;
    assertUmpleTemplateFor("ecore/MultipleInterfaces.ump","ecore/MultipleInterfaces.ecore.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/ecore/MultipleInterfaces.ecore")).exists());
  }
}
