package cruise.umple.implementation.mermaid;

import org.junit.*;

import cruise.umple.compiler.Event;
import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class MermaidStateDiagramTemplateTest extends TemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Mermaid";
    suboptions = new String[] {"state"};
    languagePath = "mermaid";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/mermaid/StateBasic_stateDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/StateNested_stateDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/StateMachineScopeCollision_stateDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/StateAutoTransition_stateDiagram.mermaid");
    SampleFileWriter.destroy(pathToInput + "/mermaid/StateUnspecifiedEvent_stateDiagram.mermaid");
  }
  
  @Test
  public void StateBasic()
  {
    assertUmpleTemplateFor("mermaid/StateBasic.ump", "mermaid/StateBasic.mermaid.txt");
  }

  @Test
  public void StateNested()
  {
    assertUmpleTemplateFor("mermaid/StateNested.ump", "mermaid/StateNested.mermaid.txt");
  }

  @Test
  public void StateMachineScopeCollision()
  {
    assertUmpleTemplateFor("mermaid/StateMachineScopeCollision.ump", "mermaid/StateMachineScopeCollision.mermaid.txt");
  }

  @Test
  public void StateAutoTransition()
  {
    Event.setNextAutoTransitionId(1);
    try
    {
      assertUmpleTemplateFor("mermaid/StateAutoTransition.ump", "mermaid/StateAutoTransition.mermaid.txt");
    }
    finally
    {
      Event.setNextAutoTransitionId(1);
    }
  }

  @Test
  public void StateUnspecifiedEvent()
  {
    assertUmpleTemplateFor("mermaid/StateUnspecifiedEvent.ump", "mermaid/StateUnspecifiedEvent.mermaid.txt");
  }
}
