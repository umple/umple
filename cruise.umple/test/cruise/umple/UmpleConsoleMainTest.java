/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple;

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
  
  @Test
  public void Usage()
  {
   String[] args = new String[0];
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Usage: java -jar umple.jar <umple_file>\nExample: java -jar umple.jar airline.ump\n", UmpleConsoleMain.console);
  }
  

  @Test
  public void Version()
  {
   String[] args = new String[] { "--version"  };
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: @UMPLE_VERSION@\n", UmpleConsoleMain.console);

   args = new String[] { "-v"  };
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Version: @UMPLE_VERSION@\n", UmpleConsoleMain.console);
  }

  @Test
  public void badArgument()
  {
   String[] args = new String[] { "--IDONTEXIST"  };
   
   UmpleConsoleMain.main(args);
   Assert.assertEquals("Option:\'IDONTEXIST\' is not a recognized option\n", UmpleConsoleMain.console);
  }

}
