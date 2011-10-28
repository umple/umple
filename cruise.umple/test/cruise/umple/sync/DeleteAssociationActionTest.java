/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class DeleteAssociationActionTest
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
    String umple = "class Mentor { position 1 2 3 4; } class Student { position 10 20 30 40; }";
    String json = "{\"offsetOnePosition\" : {\"x\" : \"1\",\"y\" : \"2\",\"width\" : \"0\",\"height\" : \"0\"},\"offsetTwoPosition\" : {\"x\" : \"3\",\"y\" : \"4\",\"width\" : \"0\",\"height\" : \"0\"},\"classOneId\" : \"Student\",\"classTwoId\" : \"Mentor\"}";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    Assert.assertEquals(umple, action.getUmpleCode());
  }

  @Test
  public void Go_LastAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go.after.ump"), action.getUmpleCode());
  } 
  
  @Test
  public void Go_FirstAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go3.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go3.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go3.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_SeparateAssociationFromPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go2.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go2.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go2.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_SecondAssociationInClassWithPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go4.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go4.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go4.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_AssociationDefinitionsAndPositionsInDifferentOrder()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go5.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go5.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go5.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_FirstAssociationNoPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go6.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go6.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go6.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_lastAssociationNoPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go7.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go7.before.json"));
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go7.after.ump"), action.getUmpleCode());
  } 
}
