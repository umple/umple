/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple;

import org.junit.*;
import java.io.*;

import cruise.umple.util.SampleFileWriter;

public class UmpleRunMainTest
{
  private PrintStream out_backup;
  private PrintStream err_backup;
  private ByteArrayOutputStream outErrIntercept;
  private String pathToInput;
  
  @Before
  public void setUp()
  {
    out_backup = System.out;
    err_backup = System.err;
    outErrIntercept = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outErrIntercept));
    System.setErr(new PrintStream(outErrIntercept));
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sequence");
  }
  
  @After
  public void tearDown()
  {
    System.setOut(out_backup);
    System.setErr(err_backup);
    SampleFileWriter.destroy("myfile.ump");
    SampleFileWriter.destroy("myfile.cmd");
    SampleFileWriter.destroy("test_package");
  }
  
  @Test
  public void Usage()
  {
   String[] args = new String[0];
   
   UmpleRunMain.main(args);
   Assert.assertEquals("Usage: java -jar umplerun.jar <umple_file> <cmd_file>\nExample: java -jar umple.jar airline.ump airline.cmd"+System.getProperty("line.separator"),outErrIntercept.toString() );
  }
  
 @Test @Ignore
 public void RunTheCommands()
 {
   SampleFileWriter.createFile("myfile.ump", "namespace test_package; class One{  }");
   SampleFileWriter.createFile("myfile.cmd", "new test_package.One");
   String[] args = new String[] {"myfile.ump","myfile.cmd"};
   
   UmpleRunMain.main(args);
   
   String expected = String.format("Compiling myfile.ump... success.%n" +
                     "Building model... success.%n" +
                     "Loading model into memory... success.%n" +
                     "Running commands:%n" +
                     "  >>> new test_package.One%n" +
                     "Done.%n");
   
   Assert.assertEquals(expected, outErrIntercept.toString());
 }
  
}
