/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

 */

package cruise.umple;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

public class UmpleConsoleMainTest {
  private PrintStream out_backup;
  private PrintStream err_backup;
  private ByteArrayOutputStream outErrIntercept;
  String pathToInput;
  
  @Before
  public void setUp() {
    out_backup = System.out;
    err_backup = System.err;
    outErrIntercept = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outErrIntercept));
    System.setErr(new PrintStream(outErrIntercept));
    // UmpleConsoleMain.displayOutput = false;
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sequence");
  }
  
  @After
  public void tearDown() {
    System.setOut(out_backup);
    System.setErr(err_backup);
    SampleFileWriter.destroy("myfile.ump");
    SampleFileWriter.destroy("myfile.cmd");
    SampleFileWriter.destroy("testclass1.ump");
    SampleFileWriter.destroy("testclass2.ump");
    SampleFileWriter.destroy("test_package");
    SampleFileWriter.destroy("testclass.ecore");
  }
  
  @Test
  @Ignore
  public void Usage() {
   String[] args = new String[0];
   
    UmpleConsoleMain.main(args);
    Assert.assertEquals("For more detailed information go to http://manual.umple.org"+System.lineSeparator()
        +"Usage: java -jar umple.jar [options] <umple_file>"+System.lineSeparator()
        + "Example: java -jar umple.jar airline.ump"+System.lineSeparator(), outErrIntercept.toString());
  }
  
  @Test
  public void Version() {
    String[] args = new String[] { "--version" };

    UmpleConsoleMain.main(args);
    Assert.assertEquals(
        "Version: " + cruise.umple.compiler.UmpleModel.VERSION_NUMBER
            + System.getProperty("line.separator"), outErrIntercept.toString());

    outErrIntercept.reset();
    args = new String[] { "-v" };

    UmpleConsoleMain.main(args);
    Assert.assertEquals("Version: " + cruise.umple.compiler.UmpleModel.VERSION_NUMBER + System.lineSeparator(), 
        outErrIntercept.toString());
  }

  @Test
  public void badArgument() {
   String[] args = new String[] { "--IDONTEXIST"  };
   
     try {
   UmpleConsoleMain.main(args);
     } catch (IllegalStateException ise) {
      Assert.assertTrue(outErrIntercept.toString()
          .startsWith("Option:\'IDONTEXIST\' is not a recognized option"+System.lineSeparator()
           +"For more detailed information go to http://manual.umple.org"+System.lineSeparator()
           + "Usage: java -jar umple.jar [options] <umple_file>"+System.lineSeparator()+"Example: java -jar umple.jar airline.ump"+System.lineSeparator()));
     }
  }
  
  
   // Ignore the following - currently does exit - Probably needs adapting for RTCPP
  @Test
  @Ignore
  public void outputLang() {
    String[] javaargs = new String[] { "-g", "Java", "testclass.ump" };
    String[] phpargs = new String[] { "-g", "Php", "testclass.ump" };
	
	try {
      SampleFileWriter.createFile("testclass.ump", "class testclass {}");
	
	    UmpleConsoleMain.main(javaargs);
      SampleFileWriter.assertFileExists("testclass.java");
	    
	    UmpleConsoleMain.main(phpargs);
      SampleFileWriter.assertFileExists("testclass.php");
    } finally {
      SampleFileWriter.destroy("testclass.ump", 
          "testclass.java",
          "testclass.php");
	}
  }

   @Test 
   public void MultiUmpleFile() {
    String[] args = new String[] { "testclass1.ump", "testclass2.ump" };

    try {
      SampleFileWriter.createFile("testclass1.ump", "class Testclass1 {}");
      SampleFileWriter.createFile("testclass2.ump", "class Testclass1 {}");
		    UmpleConsoleMain.main(args);

      Assert.assertEquals("Processing -> testclass1.ump"+System.lineSeparator()
              + "Success! Processed testclass1.ump."+System.lineSeparator()
              + "Success! Processed testclass2.ump."+System.lineSeparator(),
          outErrIntercept.toString());

      SampleFileWriter.assertFileExists("Testclass1.java");
    } finally {
      for (String file : args)
        SampleFileWriter.destroy(file);

      SampleFileWriter.destroy("Testclass1.java");
		}   
   }

   @Test 
   public void UmpleImportTest() {
    String[] args = new String[] { "-import", "testclass.ecore" };
	   
	   try {
      // load simple ECore
      SampleFileWriter.createFile("testclass.ecore", String.join(System.lineSeparator(),
          "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
          "<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"base\" nsURI=\"cruise.example.base\" nsPrefix=\"base\">",
          "<eClassifiers xsi:type=\"ecore:EDataType\" name=\"Time\" instanceClassName=\"java.sql.Time\"/>",
          "<eClassifiers xsi:type=\"ecore:EClass\" name=\"ICart\" interface=\"true\" abstract=\"true\">",
          "</eClassifiers>",
          "<eClassifiers xsi:type=\"ecore:EClass\" name=\"Cart\" eSuperTypes=\"#//ICart\">",
          "</eClassifiers>", 
          "</ecore:EPackage>"));
		
		UmpleConsoleMain.main(args);
      Assert.assertEquals("Success! Processed testclass.ecore."+System.lineSeparator(),
          outErrIntercept.toString());
		
      SampleFileWriter.assertFileExists("testclass.ecore.ump");
    } finally {
      SampleFileWriter.destroy("testclass.ecore", "testclass.ecore.ump");
	}
   }
}
