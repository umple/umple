/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class DeleteTransitionActionTest
{
  
  String pathToInput;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
  }
  
  @Test
  public void Go_NothingToDelete()
  {
    String umple = "class CarTransmission { state { reverse { selectDrive -> drive; } drive {  } } }";
    String json = "{\"fromStateId\": \"drive\", \"toStateId\" : \"reverse\", \"event\" : \"selectReverse\", \"name\" : \"drive_selectReverse_reverse\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals(umple, action.getUmpleCode());
    SampleFileWriter.destroy(pathToInput + "/myfile.ump");
  }

  @Test
  public void Go_LastTransition()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go.before.json"));
    String filename = pathToInput + "/DeleteTransitionTest_Go.before.ump";
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteTransitionTest_Go.after.ump"), action.getUmpleCode());
  } 
  
  @Test
  public void Go_WrongDirectionTransition()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go2.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go2.before.json"));
    String filename = pathToInput + "/DeleteTransitionTest_Go2.before.ump";
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteTransitionTest_Go2.after.ump"),
    action.getUmpleCode());
  } 
  
  @Test
  public void Go_LastStateTransition()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go3.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go3.before.json"));
    String filename = pathToInput + "/DeleteTransitionTest_Go3.before.ump";
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteTransitionTest_Go3.after.ump"), action.getUmpleCode());
  } 
  
  @Test
  public void Go_ReflecsiveTransition()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go4.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go4.before.json"));
    String filename = pathToInput + "/DeleteTransitionTest_Go4.before.ump";
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteTransitionTest_Go4.after.ump"), action.getUmpleCode());
  } 
  
  @Test
  public void Go_NestedStateTransition()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go5.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteTransitionTest_Go5.before.json"));
    String filename = pathToInput + "/DeleteTransitionTest_Go5.before.ump";
    
    DeleteTransitionAction action = new DeleteTransitionAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteTransitionTest_Go5.after.ump"), action.getUmpleCode());
  } 
  
}