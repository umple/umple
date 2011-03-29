package cruise.umple.sync;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class ActionTest
{
  
  String pathToInput;
  
  public String umple;
  public String json;
  public SynchronizationAction action;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
    umple = null;
    json = null;
    action = null;
  }  
  
  @Test
  public void ignoreForAnt()
  {}

  public void assertEditAssociationAction(String id)
  {
    configureAction(id);
    EditAssociationAction action = new EditAssociationAction(json,umple);
    executeAction(id,action);
  }  
  
  public void assertNewAssociationAction(String id)
  {
    configureAction(id);
    NewAssociationAction action = new NewAssociationAction(json,umple);
    executeAction(id,action);
  }   
  
  public void assertNewGeneralizationAction(String id)
  {
    configureAction(id);
    NewGeneralizationAction action = new NewGeneralizationAction(json,umple);
    executeAction(id,action);
  }   
  
  public void assertUpdatePositioningAction(String id)
  {
    configureAction(id);
    UpdatePositioningAction action = new UpdatePositioningAction(json,umple);
    executeAction(id,action);
  }    
  
  public void assertDeleteGeneralizationAction(String id)
  {
    configureAction(id);
    DeleteGeneralizationAction action = new DeleteGeneralizationAction(json,umple);
    executeAction(id,action);
  }  
  
  public void assertEditAction(String id)
  {
    configureAction(id);
    EditAction action = new EditAction(json,umple);
    executeAction(id,action);
  }

  public void assertDeleteAction(String id)
  {
    configureAction(id);
    DeleteAction action = new DeleteAction(json,umple);
    executeAction(id,action);
  }

  private void configureAction(String id)
  {
    umple =  SampleFileWriter.readContent(new File(pathToInput,id + ".before.ump"));
    json = SampleFileWriter.readContent(new File(pathToInput,id + ".before.json"));
  }

  private void executeAction(String id, SynchronizationAction action)
  {
    action.go();
    System.out.println(action.getUmpleCode());
    SampleFileWriter.assertFileContent(new File(pathToInput,id + ".after.ump"), action.getUmpleCode());
  }
  
}
