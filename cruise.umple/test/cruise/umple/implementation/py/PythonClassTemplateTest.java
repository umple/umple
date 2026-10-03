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
  
  
  // Source markers are ignored only outside strings: text inside a string that looks like a marker
  // is data, and a change to it fails the comparison
  @Test
  public void markerTextInsideAStringIsCompared() throws Exception
  {
    File expected = File.createTempFile("marker", ".py.txt");
    try
    {
      java.nio.file.Files.write(expected.toPath(), "x = 1\ntext = \"\"\"\n# line 1 \"payload\"\n\"\"\"\n".getBytes("UTF-8"));
      assertPythonFileContent(expected, "# line 3 \"model.ump\"\nx = 1\ntext = \"\"\"\n# line 1 \"payload\"\n\"\"\"\n", true);
      boolean compared = false;
      try
      {
        assertPythonFileContent(expected, "x = 1\ntext = \"\"\"\n# line 99 \"other\"\n\"\"\"\n", true);
      }
      catch (AssertionError e)
      {
        compared = true;
      }
      Assert.assertTrue("a changed string value must fail the comparison", compared);
    }
    finally
    {
      expected.delete();
    }
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

  @Test
  public void InternalConstant(){
        assertUmpleTemplateFor("ClassTemplateTest_InternalConstant.ump",languagePath+"/ClassTemplateTest_InternalConstant."+ languagePath + ".txt","Student");
  }

  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")

  @Test
  public void ClassCodeInjections_ParametersUnspecified(){
    super.ClassCodeInjections_ParametersUnspecified();
  }

  @Test
  public void ClassCodeInjections_Comments(){
    super.ClassCodeInjections_Comments();
  }

  @Test
  public void ClassCodeInjections_Basic(){
    super.ClassCodeInjections_Basic();
  }

  @Test
  public void ClassCodeInjections_ParametersMulti(){
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("ClassTemplateTest_CodeInjectionsParametersMulti.ump", 9211);
  }

  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")

  @Test
  public void ClassCodeInjections_NoBraces(){
    super.ClassCodeInjections_NoBraces();
  }

  @Test
  public void ClassCodeInjections_SingleLine(){
    super.ClassCodeInjections_SingleLine();
  }

  @Override
  @Test
  public void Attributes()
  {
    // untagged code Python cannot translate is reported
    assertPythonDiagnostic("ClassTemplateTest_Attributes.ump", 9211);
  }

  @Test
  public void AttributesPython()
  {
    assertUmpleTemplateFor("py/ClassTemplateTest_AttributesPython.ump", "py/ClassTemplateTest_AttributesPython.py.txt", "Mentor");
  }

  @Override
  @Test
  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
  public void MethodCommentWithEmptyLines()
  {
  }

  @Override
  @Test
  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
  public void MultipleMethodComments()
  {
  }

  @Override
  @Test
  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
  public void MethodInlineComment()
  {
  }

  @Override
  @Test
  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
  public void MethodMultilineComment()
  {
  }
}
