package cruise.umple.validator;

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.util.SampleFileWriter;

public class JavaCodeGenValidatorTest {
	  JavaCodeGenValidator validator ;
	  UmpleModel model;
	  String pathToInput;
	  String pathToRoot ;

	  @Before
	  public void setUp()
	  {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umple/validator");
		pathToRoot = SampleFileWriter.rationalize("../cruise.umple.validator");
	    model = new UmpleModel(null);
	    validator = new JavaCodeGenValidator();
	    
	  }
	  
	@Test
	public void UmpleFileWithMultipleClasses() {
	    boolean result = validator.validateGeneratedCode(pathToInput + "/Valid_UmpleFileWithMultipleClasses.ump");
	    Assert.assertTrue(result);
	}
}
