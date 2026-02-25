package cruise.umple.implementation.mermaid;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class MermaidClassDiagramTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Mermaid";
    suboptions = new String[] {"class"};
    languagePath = "mermaid";
  }

  // Mermaid class diagram generation is model-level, so class-level assertions
  // should compare against the full generated diagram.
  @Override
  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className)
  {
    super.assertUmpleTemplateFor(umpleFile, codeFile, null);
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();

    // Inherited ClassTemplateTest cases generate model-level Mermaid files in the
    // implementation root (e.g., ClassTemplateTest_EmptyClass_classDiagram.mermaid).
    // Clean them up after each test run.
    File rootInputDirectory = new File(pathToInput);
    File[] generatedClassDiagrams = rootInputDirectory.listFiles((dir, name) -> name.endsWith("_classDiagram.mermaid"));
    if (generatedClassDiagrams != null)
    {
      for (File generatedClassDiagram : generatedClassDiagrams)
      {
        SampleFileWriter.destroy(generatedClassDiagram.getAbsolutePath());
      }
    }

    SampleFileWriter.destroy(pathToInput + "/mermaid/ClassTemplateTest_Mermaid_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/AttributesAndMethods_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/Inheritance_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/Interfaces_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/InterfacesInheritance_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/Associations_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/AssociationsLeftNavigable_classDiagram.mermaid");
  }
  
  @Test
  public void MermaidClassDiagramLanguage()
  {
    language = null;
    assertUmpleTemplateFor("mermaid/ClassTemplateTest_Mermaid.ump", "mermaid/ClassTemplateTest_Mermaid.mermaid.txt");
  }

  @Test
  public void AttributesAndMethods()
  {
    assertUmpleTemplateFor("mermaid/AttributesAndMethods.ump", "mermaid/AttributesAndMethods.mermaid.txt");
  }

  @Test
  public void Inheritance()
  {
    assertUmpleTemplateFor("mermaid/Inheritance.ump", "mermaid/Inheritance.mermaid.txt");
  }

  @Test
  public void Interfaces()
  {
    assertUmpleTemplateFor("mermaid/Interfaces.ump", "mermaid/Interfaces.mermaid.txt");
  }

  @Test
  public void InterfacesInheritance()
  {
    assertUmpleTemplateFor("mermaid/InterfacesInheritance.ump", "mermaid/InterfacesInheritance.mermaid.txt");
  }

  @Test
  public void Associations()
  {
    assertUmpleTemplateFor("mermaid/Associations.ump", "mermaid/Associations.mermaid.txt");
  }

  @Test
  public void AssociationsLeftNavigable()
  {
    assertUmpleTemplateFor("mermaid/AssociationsLeftNavigable.ump", "mermaid/AssociationsLeftNavigable.mermaid.txt");
  }
}
