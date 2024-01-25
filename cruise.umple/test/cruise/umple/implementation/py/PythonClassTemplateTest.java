package cruise.umple.implementation.py;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class PythonClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/py/Mentor.py");
    SampleFileWriter.destroy(pathToInput + "/Lamp.py");
    SampleFileWriter.destroy(pathToInput + "/Switch.py");
    SampleFileWriter.destroy(pathToInput + "/py/Student.py");
    SampleFileWriter.destroy(pathToInput + "/py/Object.py");
    //SampleFileWriter.destroy(pathToInput + "/py/python_code/example/Mentor.py");
    //SampleFileWriter.destroy(pathToInput + "/py/python_code/example/Student.py");
  }
  
  
  @Test
  public void Python()
  {
    language = null;
    assertUmpleTemplateFor("py/ClassTemplateTest_Python.ump","py/ClassTemplateTest_Python.py.txt","Mentor");
  }
  
  @Test
  public void fixmlAttribute2()
  {
    language = "Python";
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes2.ump","py/ClassTemplateTest_FixmlAttributes2.py.txt","Mentor");
  }

  @Test
  public void ExtraCode()
  {
    language = null;
    assertUmpleTemplateFor("py/ClassTemplateTest_ExtraCode.ump","py/ClassTemplateTest_ExtraCode.py.txt","Mentor");
  }
  
  @Test
  public void abstractClass()
  {
	language = "Python";
	assertUmpleTemplateFor("py/ClassTemplateTest_AbstractClass.ump","py/ClassTemplateTest_AbstractClass.py.txt", "Student");
  }

   @Test
  public void MethodParameterTypes(){
	  assertUmpleTemplateFor("py/MethodParameterTypes.ump", "py/MethodParameterTypes.py.txt", "Object");
  } 

  @Test
  public void GeneratePathTest()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/ClassTemplateTest_BuildOutputPath.ump");
	  model.generate();

	  String actual = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/python_code/example/Student.py"));
	  System.out.print(actual);
	  
    SampleFileWriter.assertFileContent(new File(pathToInput, languagePath + "/ClassTemplateTest_BuildOutputPath.ump.txt"), actual);
  }


  @Test
  public void immutableNotLazyAttributeConstructor(){
	  assertUmpleTemplateFor("py/ImmutableNotLazyAttributeConstructor.ump","py/StudentImmutableNotLazyTest.py.txt","Student");
  }

  @Test
  public void StateMachineImplementsInterface(){
    assertUmpleTemplateFor("py/ClassTemplateTest_StateMachineImplementsInterface.ump", 
                           "py/ClassTemplateTest_StateMachineImplementsInterface.py.txt",
                           "Router");
  }

  @Test
  public void StateMachineImplementsPartialInterface(){
    assertUmpleTemplateFor("py/ClassTemplateTest_StateMachineImplementsPartialInterface.ump", 
                           "py/ClassTemplateTest_StateMachineImplementsPartialInterface.py.txt",
                           "Router");
  }

  @Test
  public void StateMachineDoesNotImplementInterface(){
    assertUmpleTemplateFor("py/ClassTemplateTest_StateMachineDoesNotImplementInterface.ump", 
                           "py/ClassTemplateTest_StateMachineDoesNotImplementInterface.py.txt",
                           "Router");
  }

  @Test @Ignore
  public void ClassCodeInjections_ParametersUnspecified(){
    super.ClassCodeInjections_ParametersUnspecified();
  }

  @Test @Ignore
  public void ClassCodeInjections_Comments(){
    super.ClassCodeInjections_Comments();
  }

  @Test @Ignore
  public void ClassCodeInjections_Basic(){
    super.ClassCodeInjections_Basic();
  }

  @Test @Ignore
  public void ClassCodeInjections_ParametersMulti(){
    super.ClassCodeInjections_ParametersMulti();
  }

  @Test @Ignore
  public void ClassCodeInjections_NoBraces(){
    super.ClassCodeInjections_NoBraces();
  }

  @Test @Ignore
  public void ClassCodeInjections_SingleLine(){
    super.ClassCodeInjections_SingleLine();
  }
}
