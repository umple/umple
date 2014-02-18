package cruise.umple.validator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.UmpleFile;
import cruise.umple.util.SampleFileWriter;

public class CPPCodeGenValidatorTest {
	 CPPCodeGenValidator validator;
	  String pathToInput;
	  String pathToRoot;

	  @Before
	  public void setUp()
	  {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umple/validator");
		pathToRoot = SampleFileWriter.rationalize("../cruise.umple.validator");
	    validator = new CPPCodeGenValidator();  
	  }
	  
	  @After
	  public void tearDown()
	  {
	    SampleFileWriter.destroy(pathToInput + "/A.java");
	    SampleFileWriter.destroy(pathToInput + "/C.java");
	  }
	  
	@Test
	public void UmpleFileWithMultipleClasses() {
		UmpleFile umpleFile =  new UmpleFile(pathToInput + "/Valid_UmpleFileWithMultipleClasses.cpp.ump");
	    boolean result = validator.validateGeneratedCode(umpleFile);
	    Assert.assertTrue(result);
	}
	@Test
	public void UmpleFileWithMultipleClasses_OneInvalidUmpleClass() {
		UmpleFile umpleFile =  new UmpleFile(pathToInput + "/Invalid_UmpleFileWithMultipleClasses_OneInvalidUmpleClass.cpp.ump");
	    boolean result = validator.validateGeneratedCode(umpleFile);
	    Assert.assertFalse(result);
	}
	
	@Test
	public void UmpleFileWithOneClass_OneValidUmpleClass() {
		UmpleFile umpleFile =  new UmpleFile(pathToInput + "/Valid_UmpleFileWithOneClass_OneValidUmpleClass.cpp.ump");
	    boolean result = validator.validateGeneratedCode(umpleFile);
	    Assert.assertTrue(result);
	}
	
	@Test
	public void UmpleFileWithOneClass_OneInvalidUmpleClass() {
		UmpleFile umpleFile =  new UmpleFile(pathToInput + "/Invalid_UmpleFileWithOneClass_OneInvalidUmpleClass.cpp.ump");
	    boolean result = validator.validateGeneratedCode(umpleFile);
	    Assert.assertFalse(result);
	}
	
	
}
