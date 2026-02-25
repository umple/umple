package cruise.umple.implementation.mermaid;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class MermaidTemplateTest extends TemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Mermaid";
    suboptions = new String[] {"class"};
    languagePath = "mermaid";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/mermaid/umple_classDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/ClassTemplateTest_Mermaid_classDiagram.mermaid");
  }
  
  @Test
  public void ClassTemplate()
  {
    language = null;
    assertUmpleTemplateFor("mermaid/ClassTemplateTest_Mermaid.ump","mermaid/ClassTemplateTest_Mermaid.mermaid.txt");
  }
}
