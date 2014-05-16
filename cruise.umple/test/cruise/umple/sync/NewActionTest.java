/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class NewActionTest
{
  
  String pathToInput;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
  }
  
  @After
  public void tearDown() {
    SampleFileWriter.destroy(pathToInput + "/myfile.ump");
  }
  
  @Test
  public void Go_SameIdAsName()
  {
    String umple = "";
    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"Student\",\"name\":\"Student\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    String expected = "class Student\n{\n}\n\nclass Student\n{\n  position 1 2 3 4;\n}\n";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_AddAfterLastClassInModel()
  {
    String umple = 
        "class NewClass" +
        "\n{" +
        "\n}" +
        "\n" +
        "\nclass NewClass" +
        "\n{" +
        "\n  position 124 88 109 42;" +
        "\n}" +
        "\n";
    String json = "{\"position\" : {\"x\" : \"130\",\"y\" : \"199\",\"width\" : \"109\",\"height\" : \"42\"},\"attributes\" : [],\"id\" : \"NewClass1\",\"name\" : \"NewClass1\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    String expected = 
        "class NewClass" +
        "\n{" +
        "\n}" +
        "\n" +
        "\nclass NewClass1" +
        "\n{" +
        "\n}" +
        "\n" +
        "\nclass NewClass" +
        "\n{" +
        "\n  position 124 88 109 42;" +
        "\n}" +
        "\n" +
        "\nclass NewClass1" +
        "\n{" +
        "\n  position 130 199 109 42;" +
        "\n}" +
        "\n";
    Assert.assertEquals(expected, action.getUmpleCode());
  }  
  
  @Test
  public void Go_NothingToEdit()
  {
    String umple = "";
    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleClass_1\",\"name\":\"Student\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    String expected = "class Student\n{\n}\n\nclass Student\n{\n  position 1 2 3 4;\n}\n";
    Assert.assertEquals(expected, action.getUmpleCode());
  }
  
  @Test
  public void Go_ExistingCode()
  {
    String umple = "blah";
    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleClass_1\",\"name\":\"Student\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals("class Student\n{\n}\n\nblah\nclass Student\n{\n  position 1 2 3 4;\n}\n",action.getUmpleCode());
  }   
  
  @Test
  public void Go_NoCodeButDelimiter()
  {
    String umple = "//$?[End_of_model]$?";
    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleClass_1\",\"name\":\"Student\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals("class Student\n{\n}\n\n//$?[End_of_model]$?\nclass Student\n{\n  position 1 2 3 4;\n}\n",action.getUmpleCode());
  }   
  
  @Test
  public void Go_AddAfterComment()
  {
    String umple = "//This is a comment in the code\n//$?[End_of_model]$?";
    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleClass_1\",\"name\":\"Student\"}";
    String filename = pathToInput + "/myfile.ump";
    SampleFileWriter.createFile(filename, umple);
    
    NewAction action = new NewAction(json,umple,filename);
    action.go();
    
    Assert.assertEquals("//This is a comment in the code\nclass Student\n{\n}\n\n//$?[End_of_model]$?\nclass Student\n{\n  position 1 2 3 4;\n}\n",action.getUmpleCode());
  }   
}
