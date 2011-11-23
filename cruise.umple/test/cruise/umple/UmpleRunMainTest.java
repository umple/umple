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
  
 @Test
 public void CompileTheProject()
 {
   SampleFileWriter.createFile("myfile.ump", "namespace test_package; class One{  }");
   SampleFileWriter.createFile("myfile.cmd", "");
   String[] args = new String[] {"myfile.ump",""};
   
   UmpleRunMain.main(args);
   Assert.assertEquals("Compiling myfile.ump... success.\n", UmpleRunMain.console);
 }
  
}
