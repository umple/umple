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

  String pathToInput;
  
  @Before
  public void setUp()
  {
//    UmpleConsoleMain.displayOutput = false;
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sequence");
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("myfile.ump");
    SampleFileWriter.destroy("myfile.cmd");
    SampleFileWriter.destroy("test_package");
    SampleFileWriter.destroy("testclass.ecore");
  }
  
  @Test @Ignore
  public void Usage()
  {
   String[] args = new String[0];
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Usage: java -jar umple.jar [options] <umple_file>\nExample: java -jar umple.jar airline.ump\n", UmpleConsoleMain.console);
  }
  

  @Test
  public void Version()
  {
    String[] args = new String[] { "--version"};

   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: "+ cruise.umple.compiler.UmpleModel.versionNumber +"\n",UmpleConsoleMain.console);

   args = new String[] { "-v"};

   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: "+ cruise.umple.compiler.UmpleModel.versionNumber +"\n", UmpleConsoleMain.console);
  }


  @Test
  public void badArgument()
  {
   String[] args = new String[] { "--IDONTEXIST"  };
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Option:\'IDONTEXIST\' is not a recognized option\nUsage: java -jar umple.jar [options] <umple_file>\nExample: java -jar umple.jar airline.ump\n", UmpleConsoleMain.console);
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
  // @Test  @Ignore
  // public void generatePath() {
		// String[] cppargs = new String[] {"-g", "Cpp", "--path", "/tmp", "testclass.ump"};
		
		// try {
		// 	BufferedWriter out = new BufferedWriter(new FileWriter("testclass.ump"));
		//     out.write("class testclass {}");
		//     out.close();
		    
		//     UmpleConsoleMain.main(cppargs);
		//     File cppout = new File("/tmp/testclass.cpp");
		//     File chout = new File("/tmp/testclass.h");
		//     Assert.assertEquals(true, cppout.exists());
		//     Assert.assertEquals(true, chout.exists()); 
		//     cppout.delete();
		//     chout.delete();
		    
		//     new File("testclass.ump").delete();
		// } catch (IOException e) {
		// 	Assert.fail();
		// }
  // }
  
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
	   String[] args = new String[] { "testclass1.ump", "testclass2.ump"};
	   try {
			BufferedWriter out1 = new BufferedWriter(new FileWriter("testclass1.ump"));
			BufferedWriter out2 = new BufferedWriter(new FileWriter("testclass2.ump"));
		    out1.write("class Testclass1 {}");
		    out1.close();
		    out2.write("class Testclass1 {}");	    
		    out2.close();
		    UmpleConsoleMain.main(args);
		    File fileOut = new File("Testclass1.java");
		    Assert.assertEquals(true, fileOut.exists());
			fileOut.delete();
		    Assert.assertEquals("testclass1.ump\ntestclass2.ump\nSuccess! Processed testclass1.ump.\nSuccess! Processed testclass2.ump.\n", UmpleConsoleMain.console);
		    new File("testclass1.ump").delete();
		    new File("testclass2.ump").delete();
		} catch (IOException e) {
			Assert.fail();
		}   
   }
   @Test 
   public void UmpleImportTest() {
	   
	   String[] args = new String[] {"-import", "testclass.ecore"};
	   try {
		BufferedWriter in = new BufferedWriter(new FileWriter("testclass.ecore"));
		//load simple ECore
		in.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		in.write("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"base\" nsURI=\"cruise.example.base\" nsPrefix=\"base\">\n");
		in.write("<eClassifiers xsi:type=\"ecore:EDataType\" name=\"Time\" instanceClassName=\"java.sql.Time\"/>\n");
		in.write("<eClassifiers xsi:type=\"ecore:EClass\" name=\"ICart\" interface=\"true\" abstract=\"true\">\n");
		in.write("</eClassifiers>\n");
		in.write("<eClassifiers xsi:type=\"ecore:EClass\" name=\"Cart\" eSuperTypes=\"#//ICart\">\n");
		in.write("</eClassifiers>\n");
		in.write("</ecore:EPackage>\n");
		in.close();
		
		UmpleConsoleMain.main(args);
		Assert.assertEquals("Success! Processed testclass.ecore.\n", UmpleConsoleMain.console);
		
		File fileOut = new File("testclass.ecore.ump");
	    Assert.assertEquals(true, fileOut.exists());
		fileOut.delete();
		
	} catch (IOException e) {
		Assert.fail();
	}
   }
   
}
