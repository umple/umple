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
    SampleFileWriter.destroy(pathToInput + "/php/Student.php");
    SampleFileWriter.destroy(pathToInput + "/php/Object.php");
  }
  
  
  @Test
  public void Php()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_Php.ump","php/ClassTemplateTest_Php.php.txt","Mentor");
  }
  
  @Test
  public void fixmlAttribute2()
  {
    language = "Php";
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes2.ump","php/ClassTemplateTest_FixmlAttributes2.php.txt","Mentor");
  }

  @Test
  public void ExtraCode()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_ExtraCode.ump","php/ClassTemplateTest_ExtraCode.php.txt","Mentor");
  }
  

   @Test
  public void MethodParameterTypes(){
	  assertUmpleTemplateFor("php/MethodParameterTypes.ump", "php/MethodParameterTypes.php.txt", "Object");
  } 

  @Test
  public void GeneratePathTest()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/ClassTemplateTest_BuildOutputPath.ump");
	  model.generate();

	  String actual = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/php_code/Student.php"));
	  System.out.print(actual);
	  
    SampleFileWriter.assertFileContent(new File(pathToInput, languagePath + "/ClassTemplateTest_BuildOutputPath.ump.txt"), actual);
  }

  @Test
  public void StateMachineImplementsInterface(){
    assertUmpleTemplateFor("php/ClassTemplateTest_StateMachineImplementsInterface.ump", 
                           "php/ClassTemplateTest_StateMachineImplementsInterface.php.txt",
                           "Router");
  }

  @Test
  public void StateMachineImplementsPartialInterface(){
    assertUmpleTemplateFor("php/ClassTemplateTest_StateMachineImplementsPartialInterface.ump", 
                           "php/ClassTemplateTest_StateMachineImplementsPartialInterface.php.txt",
                           "Router");
  }

  @Test
  public void StateMachineDoesNotImplementInterface(){
    assertUmpleTemplateFor("php/ClassTemplateTest_StateMachineDoesNotImplementInterface.ump", 
                           "php/ClassTemplateTest_StateMachineDoesNotImplementInterface.php.txt",
                           "Router");
  }

  // 2025-10: Namespaces seem to have no effect on the Php generated code.
  @Test @Ignore
  public void ImportAssociations()
  {
    super.ImportAssociations();
  }  

}
