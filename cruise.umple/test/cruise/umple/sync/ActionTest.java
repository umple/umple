/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class ActionTest
{
  
  String pathToInput;
  
  public String umple;
  public String json;
  public String filename;
  public SynchronizationAction action;
  
  @Before
  public void setUp()
  {
    pathToInput = null;
    umple = null;
    json = null;
    filename = null;
    action = null;
  }  
  
  @Test
  public void ignoreForAnt()
  {}

  public void assertEditAssociationAction(String id)
  {
    configureAction(id);
    EditAssociationAction action = new EditAssociationAction(json,umple,filename);
    executeAction(id,action);
  }  
  
  public void assertNewAssociationAction(String id)
  {
    configureAction(id);
    NewAssociationAction action = new NewAssociationAction(json,umple,filename);
    executeAction(id,action);
  }   
  
  public void assertNewGeneralizationAction(String id)
  {
    configureAction(id);
    NewGeneralizationAction action = new NewGeneralizationAction(json,umple,filename);
    executeAction(id,action);
  }   
  
  public void assertUpdatePositioningAction(String id)
  {
    configureAction(id);
    UpdatePositioningAction action = new UpdatePositioningAction(json,umple,filename);
    executeAction(id,action);
  }    
  
  public void assertDeleteGeneralizationAction(String id)
  {
    configureAction(id);
    DeleteGeneralizationAction action = new DeleteGeneralizationAction(json,umple,filename);
    executeAction(id,action);
  }  
  
  public void assertEditAction(String id)
  {
    configureAction(id);
    EditAction action = new EditAction(json,umple,filename);
    executeAction(id,action);
  }

  public void assertDeleteAction(String id)
  {
    configureAction(id);
    DeleteAction action = new DeleteAction(json,umple,filename);
    executeAction(id,action);
  }

  private void configureAction(String id)
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
    filename = pathToInput + "/" + id + ".before.ump";
    umple =  SampleFileWriter.readContent(new File(filename));
    json = SampleFileWriter.readContent(new File(pathToInput,id + ".before.json"));
  }

  private void executeAction(String id, SynchronizationAction action)
  {
    action.go();
    System.out.println(action.getUmpleCode());
    SampleFileWriter.assertFileContent(new File(pathToInput,id + ".after.ump"), action.getUmpleCode());
  }
  
}
