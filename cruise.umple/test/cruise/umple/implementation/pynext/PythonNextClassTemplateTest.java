package cruise.umple.implementation.pynext;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class PythonNextClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "PythonNext";
    languagePath = "pynext";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/pynext/Mentor.py");
    SampleFileWriter.destroy(pathToInput + "/Lamp.py");
    SampleFileWriter.destroy(pathToInput + "/Switch.py");
    SampleFileWriter.destroy(pathToInput + "/pynext/Student.py");
    SampleFileWriter.destroy(pathToInput + "/pynext/Object.py");
    //SampleFileWriter.destroy(pathToInput + "/pynext/python_code/example/Mentor.py");
    //SampleFileWriter.destroy(pathToInput + "/pynext/python_code/example/Student.py");
  }
  
  
  // Source markers are ignored only outside strings: text inside a string that looks like a marker
  // is data, and a change to it fails the comparison
  @Test
  public void markerTextInsideAStringIsCompared() throws Exception
  {
    File expected = File.createTempFile("marker", ".pynext.txt");
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
    assertUmpleTemplateFor("pynext/ClassTemplateTest_Python.ump","pynext/ClassTemplateTest_Python.pynext.txt","Mentor");
  }
  
  @Test
  public void fixmlAttribute2()
  {
    language = "PythonNext";
    assertUmpleTemplateFor("ClassTemplateTest_FixmlAttributes2.ump","pynext/ClassTemplateTest_FixmlAttributes2.pynext.txt","Mentor");
  }

  @Test
  public void ExtraCode()
  {
    language = null;
    assertUmpleTemplateFor("pynext/ClassTemplateTest_ExtraCode.ump","pynext/ClassTemplateTest_ExtraCode.pynext.txt","Mentor");
  }

   @Test
  public void MethodParameterTypes(){
	  assertUmpleTemplateFor("pynext/MethodParameterTypes.ump", "pynext/MethodParameterTypes.pynext.txt", "Object");
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
    assertUmpleTemplateFor("pynext/ClassTemplateTest_StateMachineImplementsInterface.ump", 
                           "pynext/ClassTemplateTest_StateMachineImplementsInterface.pynext.txt",
                           "Router");
  }

  @Test
  public void StateMachineImplementsPartialInterface(){
    assertUmpleTemplateFor("pynext/ClassTemplateTest_StateMachineImplementsPartialInterface.ump", 
                           "pynext/ClassTemplateTest_StateMachineImplementsPartialInterface.pynext.txt",
                           "Router");
  }

  @Test
  public void StateMachineDoesNotImplementInterface(){
    assertUmpleTemplateFor("pynext/ClassTemplateTest_StateMachineDoesNotImplementInterface.ump", 
                           "pynext/ClassTemplateTest_StateMachineDoesNotImplementInterface.pynext.txt",
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
    assertUmpleTemplateFor("pynext/ClassTemplateTest_AttributesPython.ump", "pynext/ClassTemplateTest_AttributesPython.pynext.txt", "Mentor");
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
