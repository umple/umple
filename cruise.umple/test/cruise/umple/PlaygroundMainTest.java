/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.*;

import cruise.umple.util.AssertHelper;
import cruise.umple.util.SampleFileWriter;

public class PlaygroundMainTest
{

  String pathToInput;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("myfile.ump");
    SampleFileWriter.destroy("myfile.uml");
    SampleFileWriter.destroy("myfile.ecore");
    SampleFileWriter.destroy("myfile.tuml");
    SampleFileWriter.destroy("myfile.zip");
    SampleFileWriter.destroy("One.java");
    SampleFileWriter.destroy("Two.java");
  }
  
  @Test
  public void ClassList()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{} class Two{}");
    String[] args = new String[] {"-classList","myfile.ump"};
    
    PlaygroundMain.main(args);
    AssertHelper.assertEitherEquals("One,Two", "Two,One", PlaygroundMain.console);
  }
  
  @Test
  public void InterfaceList()
  {
    SampleFileWriter.createFile("myfile.ump", "interface One{} interface Two{}");
    String[] args = new String[] {"-interfaceList","myfile.ump"};
    
    PlaygroundMain.main(args);
    AssertHelper.assertEitherEquals("One,Two", "Two,One", PlaygroundMain.console);
  }


  @Test
  public void Source()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{} class Two{}");
    String[] args = new String[] {"-source","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("/*PLEASE DO NOT EDIT THIS CODE*/"));
  }

  
  @Test
  public void Json()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{} class Two{}");
    String[] args = new String[] {"-generate","Json","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("{\"umpleClasses\":"));
  }

  @Test
  public void Yuml()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{}");
    String[] args = new String[] {"-generate","Yuml","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("[One],",PlaygroundMain.console);
  }

  @Test
  public void Xmi()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{}");
    String[] args = new String[] {"-generate","Xmi","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("<?xml"));
  }
  
  @Test
  public void Papyrus()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{}");
    String[] args = new String[] {"-generate","Papyrus","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("<?xml"));
  }  
  
  @Test
  public void Ecore()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{}");
    String[] args = new String[] {"-generate","Ecore","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("<?xml"));
  }  
  
  @Test
  public void TextUml()
  {
    SampleFileWriter.createFile("myfile.ump", "class One{}");
    String[] args = new String[] {"-generate","TextUml","myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals(true,PlaygroundMain.console.startsWith("package"));
  }   
  
  @Test
  public void AddClass()
  {
    String umple = "";
    SampleFileWriter.createFile("myfile.ump", umple);

    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleClass_1\",\"name\":\"Student\"}";
    String[] args = new String[] {"-addClass",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("class Student\n{\n}\n\nclass Student\n{\n  position 1 2 3 4;\n}\n",PlaygroundMain.console);
  }    
  
  //@Test - To be added when interfaces for umpleonline will be completed
  public void AddInterface()
  {
    String umple = "";
    SampleFileWriter.createFile("myfile.ump", umple);

    String json = "{\"position\":{\"x\":1,\"y\":2,\"width\":3,\"height\":4},\"id\":\"umpleInterface_1\",\"name\":\"IStudent\"}";
    String[] args = new String[] {"-addInterface",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("interface IStudent\n{\n}\n\ninterface IStudent\n{\n  position 1 2 3 4;\n}\n",PlaygroundMain.console);
  }  
  
  //@Test - To be added when interfaces for umpleonline will be completed
  public void RemoveInterface()
  {
    String umple = "interface IBlah { }";
    SampleFileWriter.createFile("myfile.ump", umple);
    String json = "{\"id\":\"\",\"name\":\"IBlah\"}";
    
    String[] args = new String[] {"-removeInterface",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("",PlaygroundMain.console);
  }
  
  @Test
  public void RemoveClass()
  {
    String umple = "class Blah { }";
    SampleFileWriter.createFile("myfile.ump", umple);
    String json = "{\"id\":\"\",\"name\":\"Blah\"}";
    
    String[] args = new String[] {"-removeClass",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("",PlaygroundMain.console);
  }
  
  @Test
  public void EditClass()
  {
    String umple = "class NewClass { position 1 2 3 4; }";
    SampleFileWriter.createFile("myfile.ump", umple);
    String json = "{\"position\":{\"x\":10,\"y\":20,\"width\":30,\"height\":40},\"id\":\"umpleClass_0\",\"name\":\"Student\",\"oldname\":\"NewClass\"}";
    
    String[] args = new String[] {"-editClass",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("class Student { position 10 20 30 40; }\n",PlaygroundMain.console);
  }

  //@Test - To be added when interfaces for umpleonline will be completed
  public void EditInterface()
  {
    String umple = "interface INewInterface { position 1 2 3 4; }";
    SampleFileWriter.createFile("myfile.ump", umple);
    String json = "{\"position\":{\"x\":10,\"y\":20,\"width\":30,\"height\":40},\"id\":\"umpleInterface_0\",\"name\":\"IStudent\",\"oldname\":\"INewInterface\"}";
    
    String[] args = new String[] {"-editInterface",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("interface IStudent { position 10 20 30 40; }\n",PlaygroundMain.console);
  }
  
  @Test
  public void AddAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewAssociationTest_Go.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"NewAssociationTest_Go.before.json"));
    SampleFileWriter.createFile("myfile.ump", umple);
    String[] args = new String[] {"-addAssociation",json,"myfile.ump"};
    PlaygroundMain.main(args);
    SampleFileWriter.assertFileContent(new File(pathToInput,"NewAssociationTest_Go.after.ump"), PlaygroundMain.console);
  }
  
  @Test
  public void EditAssociation()
  {
    String umple = "class Student { * -- * Course;\n\n  position 68 52 109 42;   position.association Course__Student 30,35 40,45;\n} class Course { position 176 199 109 42; }\n";
    SampleFileWriter.createFile("myfile.ump", umple);
    String json = "{\"classOnePosition\" : {\"x\" : \"125\",\"y\" : \"17\",\"width\" : \"0\",\"height\" : \"0\"},\"classTwoPosition\" : {\"x\" : \"258\",\"y\" : \"19\",\"width\" : \"0\",\"height\" : \"0\"},\"offsetOnePosition\" : {\"x\" : \"1\",\"y\" : \"2\",\"width\" : \"-109\",\"height\" : \"-42\"},\"offsetTwoPosition\" : {\"x\" : \"3\",\"y\" : \"4\",\"width\" : \"-109\",\"height\" : \"-42\"},\"id\" : \"umpleElement_2\",\"classOneId\" : \"Student\",\"classTwoId\" : \"Course\", \"name\" : \"Course__Student\"}";
    
    String[] args = new String[] {"-editAssociation",json,"myfile.ump"};
    
    PlaygroundMain.main(args);
    Assert.assertEquals("class Student { * -- * Course;\n\n  position 68 52 109 42;   position.association Course__Student 1,2 3,4;\n} class Course { position 176 199 109 42; }\n",PlaygroundMain.console);
  }   
  
  @Test
  public void DeleteAssociation()
  {
    String umple =  SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.ump"));
    String json = SampleFileWriter.readContent(new File(pathToInput,"DeleteAssociationTest_Go.before.json"));
    SampleFileWriter.createFile("myfile.ump", umple);
    
    String[] args = new String[] {"-removeAssociation",json,"myfile.ump"};
    PlaygroundMain.main(args);
    
    SampleFileWriter.assertFileContent(new File(pathToInput,"DeleteAssociationTest_Go.after.ump"), PlaygroundMain.console);
  }

  
  @Test
  public void ZipFiles()
  {
    SampleFileWriter.createFile("myfile.ump", "findme");
    String[] filesToZip = new String[1];
    filesToZip[0] = "myfile.ump"; 
    
    byte[] buffer = new byte[18024];

    String zipFileName = "myfile.zip";

    try {

      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
      out.setLevel(Deflater.DEFAULT_COMPRESSION);

      for (int i = 0; i < filesToZip.length; i++) {
        FileInputStream in = new FileInputStream(filesToZip[i]);
        out.putNextEntry(new ZipEntry(filesToZip[i]));
        // Transfer bytes from the current file to the ZIP file
        //out.write(buffer, 0, in.read(buffer));

        int len;
        while ((len = in.read(buffer)) > 0)
        {
          out.write(buffer, 0, len);
        }
        out.closeEntry();
        in.close();
      }
      out.close();
    }
    catch (Exception e) {
      throw new RuntimeException("Unable to create zip file",e);
    }
    
    
  }  
}
