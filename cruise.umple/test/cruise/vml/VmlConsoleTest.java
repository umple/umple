/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

package cruise.vml;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class VmlConsoleTest
{

  String pathToInput;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/vml");
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("input.vml");
    SampleFileWriter.destroy("output.ump");
  }

  @Test
  public void MissingArgs()
  {
    SampleFileWriter.createFile("input.vml", "//stuff");
    String[] args = new String[] {"output.ump"};
    
    VmlConsole.main(args);
    Assert.assertEquals("Usage: java -jar vml.jar <output_file> <input_files>\nExample: java -jar vml.jar myProgram.ump myBase.vml myInvoke.vml\n", VmlConsole.console);
  }

  @Test
  public void SuccessOutpu()
  {
    SampleFileWriter.createFile("input.vml", "//stuff");
    String[] args = new String[] {"output.ump","input.vml"};
    
    VmlConsole.main(args);
    Assert.assertEquals("Successfully created [output.ump]\n", VmlConsole.console);
  }
  
  @Test
  public void WriteFile()
  {
    String[] args = new String[] {"output.ump",pathToInput + "/003_invoke_RequiresAlready.vml"};
    VmlConsole.main(args);
    
    String actual = SampleFileWriter.readContent(new File("output.ump"));
    String expected = SampleFileWriter.readContent(new File(pathToInput,"003_invoke_RequiresAlready.ump"));
    Assert.assertEquals(expected,actual);
  }

  @Test
  public void MultipleFiles()
  {
    String[] args = new String[] {"output.ump",pathToInput + "/004_program.vml",pathToInput + "/004_invoke.vml"};
    VmlConsole.main(args);
    
    String actual = SampleFileWriter.readContent(new File("output.ump"));
    String expected = SampleFileWriter.readContent(new File(pathToInput,"004_invoke.ump"));
    Assert.assertEquals(expected,actual);
  }

}
