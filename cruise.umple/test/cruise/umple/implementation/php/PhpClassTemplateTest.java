package cruise.umple.implementation.php;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class PhpClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/php/Mentor.php");
    SampleFileWriter.destroy(pathToInput + "/Lamp.php");
    SampleFileWriter.destroy(pathToInput + "/Switch.php");
  }
  
  
  @Test
  public void Php()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_Php.ump","php/ClassTemplateTest_Php.php.txt","Mentor");
  }

  @Test
  public void ExtraCode()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_ExtraCode.ump","php/ClassTemplateTest_ExtraCode.php.txt","Mentor");
  }
  @Test
  public void GeneratePathTest()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/ClassTemplateTest_BuildOutputPath.ump");
	  model.generate();

	  String actual = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/php_code/student.php"));
	  System.out.print(actual);
	  
	  String expected = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/ClassTemplateTest_BuildOutputPath.ump.txt"));
	  Assert.assertEquals(expected, actual);
  }
}
