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
    String[] args = new String[] { "--version"  };

   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: "+ UmpleModel.versionNumber +"\n",
UmpleConsoleMain.console);

   args = new String[] { "-v"  };

   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: "+ UmpleModel.versionNumber +"\n",
UmpleConsoleMain.console);
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
}
