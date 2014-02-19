package cruise.umple.validator;

import org.junit.*;

import cruise.umple.CodeGenValidatorMainConsole;
import cruise.umple.util.SampleFileWriter;

public class CodeGenMainConsoleTest {

	  String pathToInput;
	  
	  @Before
	  public void setUp()
	  {
	    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/validator");
	  }
	  
	  @Test 
	  public void Usage()
	  {
	   String[] args = new String [0];
	   
	   CodeGenValidatorMainConsole.main(args);
	   Assert.assertEquals("Usage: java -jar umplevalidator.jar [-java |-cpp] <umple_file>\nExample: java -jar umplevalidator.jar -j test.ump", CodeGenValidatorMainConsole.console);
	  }
	  
	  

}
