/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.*;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.SampleFileWriter;

public class TemplateTest
{

  public String pathToInput;
  public String pathToRoot;
  public String language;
  public String languagePath;
  public String umpleParserName;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
    pathToRoot = SampleFileWriter.rationalize("../cruise.umple");
    language = null;
    languagePath = "java";
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }

  @After
  public void tearDown()
  {

    SampleFileWriter.destroy(pathToInput + "/example");

    SampleFileWriter.destroy(pathToInput + "/ISomething.java");
    SampleFileWriter.destroy(pathToInput + "/Token.java");
    SampleFileWriter.destroy(pathToInput + "/Token.h");
    SampleFileWriter.destroy(pathToInput + "/Token.cpp");
    SampleFileWriter.destroy(pathToInput + "/Garbage.php");
    SampleFileWriter.destroy(pathToInput + "/IGarbage.php");
    SampleFileWriter.destroy(pathToInput + "/Mentor.php");
    SampleFileWriter.destroy(pathToInput + "/Pupil.php");
    SampleFileWriter.destroy(pathToInput + "/IMentor.php");
    SampleFileWriter.destroy(pathToInput + "/Position.php");
    SampleFileWriter.destroy(pathToInput + "/Something.php");
    SampleFileWriter.destroy(pathToInput + "/Student.php");
    SampleFileWriter.destroy(pathToInput + "/student.php");
    SampleFileWriter.destroy(pathToInput + "/Person.php");
    SampleFileWriter.destroy(pathToInput + "/php/Student.php");
    SampleFileWriter.destroy(pathToInput + "/Garage.php");
    SampleFileWriter.destroy(pathToInput + "/SubMentor.php");
    SampleFileWriter.destroy(pathToInput + "/SubMentor2.php");
    SampleFileWriter.destroy(pathToInput + "/Token.php");
    SampleFileWriter.destroy(pathToInput + "/ISomething.php");
    SampleFileWriter.destroy(pathToInput + "/Bank.php");
    SampleFileWriter.destroy(pathToInput + "/BankOfStuff.php");
    SampleFileWriter.destroy(pathToInput + "/MyDriver.php");
    SampleFileWriter.destroy(pathToInput + "/MySubordinate.php");
    SampleFileWriter.destroy(pathToInput + "/OneSymmetric.php");
    SampleFileWriter.destroy(pathToInput + "/OneSymmetricNoParam.php");
    SampleFileWriter.destroy(pathToInput + "/OneToMany.php");
    SampleFileWriter.destroy(pathToInput + "/Application.java");
    SampleFileWriter.destroy(pathToInput + "/Application.php");
    SampleFileWriter.destroy(pathToInput + "/MyException.php");
    SampleFileWriter.destroy(pathToInput + "/Exception.php");
    SampleFileWriter.destroy(pathToInput + "/Course.php");
    SampleFileWriter.destroy(pathToInput + "/Light.php");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.php");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.java");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.cpp");
    SampleFileWriter.destroy(pathToInput + "/LightFixture.h");
    
    SampleFileWriter.destroy(pathToInput + "/X.java");
    SampleFileWriter.destroy(pathToInput + "/X.php");
    SampleFileWriter.destroy(pathToInput + "/x.ruby");
    SampleFileWriter.destroy(pathToInput + "/X.h");
    SampleFileWriter.destroy(pathToInput + "/X.cpp");
    
    SampleFileWriter.destroy(pathToInput + "/StrobeLight.php");
    SampleFileWriter.destroy(pathToInput + "/Lamp.php");
    SampleFileWriter.destroy(pathToInput + "/Switch.php");
    SampleFileWriter.destroy(pathToInput + "/StateMachineTest.php");

    SampleFileWriter.destroy(pathToInput + "/Example.php");
    SampleFileWriter.destroy(pathToInput + "/example.rb");
    SampleFileWriter.destroy(pathToInput + "/Example.java");
    SampleFileWriter.destroy(pathToInput + "/GarageDoor.php");
    
    SampleFileWriter.destroy(pathToInput + "/student.cpp");
    SampleFileWriter.destroy(pathToInput + "/student.h");   

    SampleFileWriter.destroy(pathToInput + "/ICodeTranslator.php");
    SampleFileWriter.destroy(pathToInput + "/IFirstChild.php");
    SampleFileWriter.destroy(pathToInput + "/ISecondChild.php");
    SampleFileWriter.destroy(pathToInput + "/CodeTranslator.php");
    SampleFileWriter.destroy(pathToInput + "/ChatIF.java");
    SampleFileWriter.destroy(pathToInput + "/ClientConsole.java");

    SampleFileWriter.destroy(pathToRoot + "/X.java");
    SampleFileWriter.destroy(pathToRoot + "/X.php");
    SampleFileWriter.destroy(pathToRoot + "/One.java");
    SampleFileWriter.destroy(pathToRoot + "/Two.java");
    SampleFileWriter.destroy("One.java");
    SampleFileWriter.destroy("Two.java");

    SampleFileWriter.destroy(pathToInput + "/i_something.rb");
    SampleFileWriter.destroy(pathToInput + "/token.rb");
    SampleFileWriter.destroy(pathToInput + "/garbage.rb");
    SampleFileWriter.destroy(pathToInput + "/i_garbage.rb");
    SampleFileWriter.destroy(pathToInput + "/mentor.rb");
    SampleFileWriter.destroy(pathToInput + "/pupil.rb");
    SampleFileWriter.destroy(pathToInput + "/i_mentor.rb");
    SampleFileWriter.destroy(pathToInput + "/position.rb");
    SampleFileWriter.destroy(pathToInput + "/something.rb");
    SampleFileWriter.destroy(pathToInput + "/student.rb");
    SampleFileWriter.destroy(pathToInput + "/person.rb");
    SampleFileWriter.destroy(pathToInput + "/sub_entor.rb");
    SampleFileWriter.destroy(pathToInput + "/sub_mentor2.rb");
    SampleFileWriter.destroy(pathToInput + "/bank.rb");
    SampleFileWriter.destroy(pathToInput + "/bank_of_stuff.rb");
    SampleFileWriter.destroy(pathToInput + "/my_driver.rb");
    SampleFileWriter.destroy(pathToInput + "/my_subordinate.rb");
    SampleFileWriter.destroy(pathToInput + "/one_symmetric.rb");
    SampleFileWriter.destroy(pathToInput + "/one_symmetric_no_param.rb");
    SampleFileWriter.destroy(pathToInput + "/one_to_many.rb");
    SampleFileWriter.destroy(pathToInput + "/application.rb");
    SampleFileWriter.destroy(pathToInput + "/my_exception.rb");
    SampleFileWriter.destroy(pathToInput + "/exception.rb");
    SampleFileWriter.destroy(pathToInput + "/course.rb");
    SampleFileWriter.destroy(pathToInput + "/light.rb");
    SampleFileWriter.destroy(pathToRoot + "/x.rb");
    SampleFileWriter.destroy(pathToRoot + "/x.rb");
    SampleFileWriter.destroy(pathToRoot + "/one.rb");
    SampleFileWriter.destroy(pathToRoot + "/two.rb");

    SampleFileWriter.destroy(pathToInput + "/i_code_translator.rb");
    SampleFileWriter.destroy(pathToInput + "/i_first_child.rb");
    SampleFileWriter.destroy(pathToInput + "/code_translator.rb");
    SampleFileWriter.destroy(pathToInput + "/i_second_child.rb");
    
    SampleFileWriter.destroy(pathToInput + "/NToNTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToNTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToOneTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToOptionalOneTest.sql");
    SampleFileWriter.destroy(pathToInput + "/UnidirectionalOneTest.sql");

    SampleFileWriter.destroy(pathToInput + "/ruby/ruby_code");
    SampleFileWriter.destroy(pathToInput + "/java/java_code");
    SampleFileWriter.destroy(pathToInput + "/php/php_code");
    
    //
    // Tear down missing comment detection tests.
    //
    
    SampleFileWriter.destroy(pathToInput + "/Foo.java");
    
    SampleFileWriter.destroy(pathToInput + "/Bar.java");
    SampleFileWriter.destroy(pathToInput + "/Bar1.java");
    SampleFileWriter.destroy(pathToInput + "/Bar2.java");
    SampleFileWriter.destroy(pathToInput + "/Bar3.java");
    SampleFileWriter.destroy(pathToInput + "/Bar4.java");
    
    SampleFileWriter.destroy(pathToInput + "/Bar.cpp");
    SampleFileWriter.destroy(pathToInput + "/Bar1.cpp");
    SampleFileWriter.destroy(pathToInput + "/Bar2.cpp");
    SampleFileWriter.destroy(pathToInput + "/Bar3.cpp");
    SampleFileWriter.destroy(pathToInput + "/Bar4.cpp");
    
    SampleFileWriter.destroy(pathToInput + "/Foo.cpp");
    SampleFileWriter.destroy(pathToInput + "/Foo.h");

    SampleFileWriter.destroy(pathToInput + "/Bar.h");
    SampleFileWriter.destroy(pathToInput + "/Bar1.h");
    SampleFileWriter.destroy(pathToInput + "/Bar2.h");
    SampleFileWriter.destroy(pathToInput + "/Bar3.h");
    SampleFileWriter.destroy(pathToInput + "/Bar4.h");
    
    SampleFileWriter.destroy(pathToInput + "/bar_1.rb");
    SampleFileWriter.destroy(pathToInput + "/bar_2.rb");
    SampleFileWriter.destroy(pathToInput + "/bar_3.rb");
    SampleFileWriter.destroy(pathToInput + "/bar_4.rb");
    SampleFileWriter.destroy(pathToInput + "/foo.rb");
    SampleFileWriter.destroy(pathToInput + "/bar.rb");


    SampleFileWriter.destroy(pathToInput + "/Bar.php");
    SampleFileWriter.destroy(pathToInput + "/Bar1.php");
    SampleFileWriter.destroy(pathToInput + "/Bar2.php");
    SampleFileWriter.destroy(pathToInput + "/Bar3.php");
    SampleFileWriter.destroy(pathToInput + "/Bar4.php");
    SampleFileWriter.destroy(pathToInput + "/Foo.php");

    SampleFileWriter.destroy(pathToInput + "/QueuedSMwithConcurrentStates.php");
    SampleFileWriter.destroy(pathToInput + "/NestedStatesWthSameEventNames.php");
    SampleFileWriter.destroy(pathToInput + "/QueuedWithConcurrentStateMachines.php");
    SampleFileWriter.destroy(pathToInput + "/QueuedWithNestedStateMachines.php");
    SampleFileWriter.destroy(pathToInput + "/AutomatedTellerMachine.php");
    SampleFileWriter.destroy(pathToInput + "/QueuedSMwithConcurrentStates_2.php");
    SampleFileWriter.destroy(pathToInput + "/CourseAttempt.php");


    //
    // Tear down abstract class tests.
    //
    
    SampleFileWriter.destroy(pathToInput + "/Person.java");
    SampleFileWriter.destroy(pathToInput + "/Student.java");
    SampleFileWriter.destroy(pathToInput + "/student.java");
    SampleFileWriter.destroy(pathToInput + "/Teacher.java");
    SampleFileWriter.destroy(pathToInput + "/Mentor.java");
    
    // Tear down Client
    SampleFileWriter.destroy(pathToInput + "/Client.java");
    SampleFileWriter.destroy(pathToInput + "/client.rb");
    SampleFileWriter.destroy(pathToInput + "/Client.php");
    SampleFileWriter.destroy(pathToInput + "/Client.h");
    SampleFileWriter.destroy(pathToInput + "/Client.cpp");
  }

  @Test
  public void avoidJunitError()
  {}

  // ```````````````````
  // INTERFACE
  // ```````````````````

  public void assertUmpleTemplateFor(String umpleFile, String codeFile)
  {
    assertUmpleTemplateFor(umpleFile, codeFile, null);
  }

  public void assertEitherUmpleTemplateFor(String umpleFile, String codeFile1, String codeFile2)
  {
    UmpleModel model = createUmpleSystem(pathToInput, umpleFile);
    String actual = model.getCode();
    File expected1 = new File(pathToInput, codeFile1);
    File expected2 = new File(pathToInput, codeFile2);
    // System.out.println(actual);
    SampleFileWriter.assertEitherFileContent(expected1, expected2, actual);
  }

  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className)
  {
    assertUmpleTemplateFor(umpleFile, codeFile, className, true, true);
  }

  public void assertUmplePartialTemplateFor(String umpleFile, String codeFile, String className)
  {
    assertUmpleTemplateFor(umpleFile, codeFile, className, false, true);
  }

  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className, boolean isFullMatch)
  {
	  assertUmpleTemplateFor(umpleFile, codeFile, className, isFullMatch, true);
  }

  public void assertGeneratedCodeEquals(String pathToInput,String actualFilename)
  {
    String expectedFilename = actualFilename + ".txt";
    SampleFileWriter.assertFileContent(new File(pathToInput + expectedFilename), new File(pathToInput + actualFilename), false);
  }
  
  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className, boolean isFullMatch, boolean ignoreLineComments)
  {
    UmpleModel model = createUmpleSystem(pathToInput, umpleFile);

    String actual = null;
    if (className == null)
    {
      actual = model.getCode();
    }
    else
    {
      if (model.getUmpleClass(className) == null && model.getUmpleInterface(className) == null)
      {
        Assert.fail("Unknown class / interface:" + className);
      }

      if (model.getGeneratedCode().get(className) == null)
      {
        Assert.fail("No generated code:" + className);
      }

      actual = model.getGeneratedCode().get(className);
    }

    File expected = new File(pathToInput, codeFile);
    System.out.println(actual);
    
    if (isFullMatch)
    {
      if (ignoreLineComments)
    	  SampleFileWriter.assertFileContent(expected, actual, true); 
      else
    	  SampleFileWriter.assertFileContent(expected, actual, false);
      
    }
    else
    {
      SampleFileWriter.assertPartialFileContent(expected, actual);
    }
    
  }

  public UmpleModel createUmpleSystem(String path, String filename)
  {
	UmpleFile file = new UmpleFile(pathToInput,filename);
	UmpleModel model = new UmpleModel(file);
	model.setShouldGenerate(false);
	RuleBasedParser rbp = new RuleBasedParser();
	UmpleParser parser = new UmpleInternalParser(umpleParserName,model,rbp);
	ParseResult result = rbp.parse(file);
	model.setLastResult(result);

    if (!result.getWasSuccess())
    {
      Assert.fail("Syntax Failed at:" + result.getPosition());
    }
    
    model.setUmpleFile(new UmpleFile(new File(path, filename)));

    if (language != null)
    {
      model.addGenerate(language);
    }

    result = parser.analyze(true);
    if (!result.getWasSuccess())
    {
      Assert.fail("Semantics Failed at:" + result.getPosition());
    }

    return model;
  }
}
