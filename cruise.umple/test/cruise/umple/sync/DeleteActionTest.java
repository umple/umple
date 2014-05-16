/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class DeleteActionTest extends ActionTest
{
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(pathToInput + "/myfile.ump");
  }

  @Test
  public void Go_NothingToDelete()
  {
    String umple = "class One { position 1 2 3 4; } class Two { position 10 20 30 40; }";
    String json = "{\"id\":\"umpleClass_X\",\"name\":\"Unknown\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals(umple, action.getUmpleCode());
  }

  @Test
  public void Go_First()
  {
    String umple = "class One { position 1 2 3 4; } class Two { position 10 20 30 40; }";
    String json = "{\"id\":\"umpleClass_1\",\"name\":\"One\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    String expected = "class Two { position 10 20 30 40; }";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_Last()
  {
    String umple = "class One { position 1 2 3 4; } class Two { position 10 20 30 40; }";
    String json = "{\"id\":\"umpleClass_2\",\"name\":\"Two\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    String expected = "class One { position 1 2 3 4; } ";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_Middle()
  {
    String umple = "class One { position 1 2 3 4; } class Two { position 10 20 30 40; } class Three { position 100 200 300 400; }";
    String json = "{\"id\":\"Two\",\"name\":\"Two\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    String expected = "class One { position 1 2 3 4; } class Three { position 100 200 300 400; }";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_MultipleValid()
  {
    String umple = "class Two { position 10 20 30 40; } class One { position 1 2 3 4; } class Two { position 10 20 30 40; } class Three { position 100 200 300 400; } class Two { position 10 20 30 40; }";
    String json = "{\"id\":\"umpleClass_2\",\"name\":\"Two\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    String expected = "class One { position 1 2 3 4; } class Three { position 100 200 300 400; } ";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_NoId()
  {
    String umple = "class Two {} class One { position 1 2 3 4; } class Two { position 10 20 30 40; } class Two {}  class Three { position 100 200 300 400; } class Two {} ";
    String json = "{\"id\":\"Two\",\"name\":\"Two\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    DeleteAction action = new DeleteAction(json,umple,filename);
    action.go();
    
    String expected = "class One { position 1 2 3 4; } class Three { position 100 200 300 400; } ";
    Assert.assertEquals(expected, action.getUmpleCode());
  } 
}
