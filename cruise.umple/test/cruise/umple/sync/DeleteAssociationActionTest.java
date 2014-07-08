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
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals(umple, action.getUmpleCode());
    SampleFileWriter.destroy(pathToInput + "/myfile.ump");
  }

  @Test
  public void Go_LastAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go.after.ump"), action.getUmpleCode());
  } 
  
  @Test
  public void Go_FirstAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go3.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go3.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go3.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go3.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_SeparateAssociationFromPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go2.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go2.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go2.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go2.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_SecondAssociationInClassWithPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go4.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go4.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go4.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go4.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_AssociationDefinitionsAndPositionsInDifferentOrder()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go5.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go5.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go5.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go5.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_FirstAssociationNoPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go6.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go6.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go6.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go6.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_lastAssociationNoPositioning()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go7.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go7.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go7.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go7.after.ump"), action.getUmpleCode());
  } 

  @Test
  public void Go_deleteReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go8.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go8.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go8.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go8.after.ump"), action.getUmpleCode());
  }

  @Test
  public void Go_deleteSymmetricReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go9.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go9.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go9.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go9.after.ump"), action.getUmpleCode());
  }

  @Test
  public void Go_deleteOnlyOneReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go10.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go10.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go10.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go10.after.ump"), action.getUmpleCode());
  }
  
  @Test
  public void Go_deleteOnlyOneSymmetricReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go11.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go11.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go11.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go11.after.ump"), action.getUmpleCode());
  }

  @Test
  public void Go_deleteOnlySymmetricReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go12.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go12.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go12.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go12.after.ump"), action.getUmpleCode());
  }
  
  @Test
  public void Go_deleteOnlyReflexiveAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go13.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go13.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go13.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go13.after.ump"), action.getUmpleCode());
  }
  
  @Test
  public void Go_deleteOnlyNormalAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go14.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go14.before.json"));
    String filename = pathToInput + "/DeleteAssociationTest_Go14.before.ump";
    
    DeleteAssociationAction action = new DeleteAssociationAction(json,umple,filename);
    action.go();
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go14.after.ump"), action.getUmpleCode());
  }
}
