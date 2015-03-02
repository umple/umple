/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple;

import java.io.*;

import org.junit.*;
import cruise.umple.util.SampleFileWriter;

public class UmpleConsoleMainTest
{
  private PrintStream out_backup;
  private PrintStream err_backup;
  private ByteArrayOutputStream outErrIntercept;
  String pathToInput;
  
  @Before
  public void setUp()
  {
    out_backup = System.out;
    err_backup = System.err;
    outErrIntercept = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outErrIntercept));
    System.setErr(new PrintStream(outErrIntercept));
//    UmpleConsoleMain.displayOutput = false;
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sequence");
  }
  
  @After
  public void tearDown()
  {
    System.setOut(out_backup);
    System.setErr(err_backup);
    SampleFileWriter.destroy("myfile.ump");
    SampleFileWriter.destroy("myfile.cmd");
    SampleFileWriter.destroy("testclass1.ump");
    SampleFileWriter.destroy("testclass2.ump");
    SampleFileWriter.destroy("test_package");
    SampleFileWriter.destroy("testclass.ecore");
  }
  
  @Test @Ignore
  public void Usage()
  {
   String[] args = new String[0];
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals(String.format("Usage: java -jar umple.jar [options] <umple_file>%nExample: java -jar umple.jar airline.ump%n"), outErrIntercept.toString());
  }
  

  @Test
  public void Version()
  {
    String[] args = new String[] { "--version"};

    UmpleConsoleMain.main(args);
    Assert.assertEquals("Version: "+ cruise.umple.compiler.UmpleModel.VERSION_NUMBER +System.getProperty("line.separator"), outErrIntercept.toString());

    outErrIntercept.reset();
    args = new String[] { "-v"};

    UmpleConsoleMain.main(args);
    Assert.assertEquals("Version: "+ cruise.umple.compiler.UmpleModel.VERSION_NUMBER +System.getProperty("line.separator"), outErrIntercept.toString());
  }


  @Test
  public void badArgument()
  {
   String[] args = new String[] { "--IDONTEXIST"  };
   
     try {
   UmpleConsoleMain.main(args);
     } catch (IllegalStateException ise) {
       Assert.assertTrue(outErrIntercept.toString().startsWith("Option:\'IDONTEXIST\' is not a recognized option\n" 
           + "Usage: java -jar umple.jar [options] <umple_file>\nExample: java -jar umple.jar airline.ump\n"));
     } catch (Exception e) {
       Assert.fail("Invalid exception thrown: " + e);
     }
  }
  
   // Ignore the following - currently does exit
  @Test  @Ignore
  public void generateOverride() {
		String[] cppargs = new String[] {"-g", "Cpp", "--override", "testclass.ump"};
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
		    out.write("generate Java; class testclass {}");
		    out.close();
		    
		    UmpleConsoleMain.main(cppargs);
		    File javaout = new File("testclass.java");
		    File cppout = new File("testclass.cpp");
		    File chout = new File("testclass.h");
		    Assert.assertEquals(false, javaout.exists());
		    Assert.assertEquals(true, cppout.exists());
		    Assert.assertEquals(true, chout.exists()); 
		    javaout.delete();
		    cppout.delete();
		    chout.delete();
		    
		    new File("testclass.ump").delete();
		} catch (IOException e) {
			Assert.fail();
		}
  }
  
  // Ignore the following - currently does exit
  @Test  @Ignore
  public void generatePath() {
		String[] cppargs = new String[] {"-g", "Cpp", "--path", "/tmp", "testclass.ump"};
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
		    out.write("class testclass {}");
		    out.close();
		    
		    UmpleConsoleMain.main(cppargs);
		    File cppout = new File("/tmp/testclass.cpp");
		    File chout = new File("/tmp/testclass.h");
		    Assert.assertEquals(true, cppout.exists());
		    Assert.assertEquals(true, chout.exists()); 
		    cppout.delete();
		    chout.delete();
		    
		    new File("testclass.ump").delete();
		} catch (IOException e) {
			Assert.fail();
		}
  }
  
   // Ignore the following - currently does exit
   @Test  @Ignore
  public void outputLang() {
	String[] javaargs = new String[] {"-g", "Java", "testclass.ump"};
	String[] cppargs = new String[] {"-g", "Cpp", "testclass.ump"};
	String[] phpargs = new String[] {"-g", "Php", "testclass.ump"};
	
	try {
		BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
	
	    out.write("class testclass {}");
	    out.close();
	    UmpleConsoleMain.main(javaargs);
	    File javaout = new File("testclass.java");
	    Assert.assertEquals(true, javaout.exists());
	    javaout.delete();
	    
	    UmpleConsoleMain.main(cppargs);
	    File cppout = new File("testclass.cpp");
	    File chout = new File("testclass.h");
	    Assert.assertEquals(true, cppout.exists());
	    Assert.assertEquals(true, chout.exists());
	    cppout.delete();
	    chout.delete();
	    
	    UmpleConsoleMain.main(phpargs);
	    File phpout = new File("testclass.php");
	    Assert.assertEquals(true, phpout.exists());
	    phpout.delete();
	    
	    new File("testclass.ump").delete();
	} catch (IOException e) {
		Assert.fail();
	}
  }
   @Test 
   public void MultiUmpleFile() {
    String[] args = new String[] { "testclass1.ump", "testclass2.ump" };
	   try {

      try (BufferedWriter out1 = new BufferedWriter(new FileWriter(
          "testclass1.ump"));
          BufferedWriter out2 = new BufferedWriter(new FileWriter(
              "testclass2.ump"));) {
		    out1.write("class Testclass1 {}");
		    out2.write("class Testclass1 {}");	    
      }

		    UmpleConsoleMain.main(args);
      Assert.assertEquals(String .format("Compiling -> testclass1.ump%n"
          + "Success! Processed testclass1.ump.%n" 
          + "Success! Processed testclass2.ump.%n"),
          outErrIntercept.toString());
		    File fileOut = new File("Testclass1.java");
      Assert.assertTrue("Testclass1.java does not exist", fileOut.exists());
		} catch (IOException e) {
			Assert.fail();
    } finally {
      new File("Testclass1.java").delete();
      new File("testclass1.ump").delete();
      new File("testclass2.ump").delete();
		}   
   }
   @Test 
   public void UmpleImportTest() {
	   
	   String[] args = new String[] {"-import", "testclass.ecore"};
	   try {
		BufferedWriter in = new BufferedWriter(new FileWriter("testclass.ecore"));
		//load simple ECore
		String cr = System.getProperty("line.separator");
		in.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+cr);
		in.write("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"base\" nsURI=\"cruise.example.base\" nsPrefix=\"base\">"+cr);
		in.write("<eClassifiers xsi:type=\"ecore:EDataType\" name=\"Time\" instanceClassName=\"java.sql.Time\"/>"+cr);
		in.write("<eClassifiers xsi:type=\"ecore:EClass\" name=\"ICart\" interface=\"true\" abstract=\"true\">"+cr);
		in.write("</eClassifiers>"+cr);
		in.write("<eClassifiers xsi:type=\"ecore:EClass\" name=\"Cart\" eSuperTypes=\"#//ICart\">"+cr);
		in.write("</eClassifiers>"+cr);
		in.write("</ecore:EPackage>"+cr);
		in.close();
		
		UmpleConsoleMain.main(args);
    Assert.assertEquals("Success! Processed testclass.ecore."+cr, outErrIntercept.toString());
		
		File fileOut = new File("testclass.ecore.ump");
	    Assert.assertEquals(true, fileOut.exists());
		fileOut.delete();
		
	} catch (IOException e) {
		Assert.fail();
	}
   }
   
}
