/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class UmpleRunMainTest
{

  String pathToInput;
  
  @Before
  public void setUp()
  {
    UmpleRunMain.displayOutput = false;
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
   
   UmpleRunMain.main(args);
   Assert.assertEquals("Usage: java -jar umplerun.jar <umple_file> <cmd_file>\nExample: java -jar umple.jar airline.ump airline.cmd\n", UmpleRunMain.console);
  }
  
 @Test @Ignore
 public void RunTheCommands()
 {
   SampleFileWriter.createFile("myfile.ump", "namespace test_package; class One{  }");
   SampleFileWriter.createFile("myfile.cmd", "new test_package.One");
   String[] args = new String[] {"myfile.ump","myfile.cmd"};
   
   UmpleRunMain.main(args);
   
   String expected = "Compiling myfile.ump... success.\n" +
                     "Building model... success.\n" +
                     "Loading model into memory... success.\n" +
                     "Running commands:\n" +
                     "  >>> new test_package.One\n" +
                     "Done.\n";
   
   Assert.assertEquals(expected, UmpleRunMain.console);
 }
  
}
