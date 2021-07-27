/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

 */

package cruise.umple.implementation;

import java.io.File;

import org.apache.tools.ant.util.FileUtils;
import org.junit.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import cruise.umple.parser.ParseResult;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.compiler.*;
import cruise.umple.util.SampleFileWriter;

public class TemplateTest
{

  public String pathToInput;
  public String pathToRoot;
  public String language;
  public String[] suboptions;
  public String languagePath;
  public String umpleParserName;
  
  public String aTracer;
  public String tracerPath;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
    pathToRoot = SampleFileWriter.rationalize("../cruise.umple");
    language = null;
    suboptions = null;
    languagePath = "java";
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    aTracer = null;
    tracerPath = null;
  }

  @After
  public void tearDown()
  {

    SampleFileWriter.destroy(pathToInput + "/example");
    SampleFileWriter.destroy(pathToInput + "/java/example");
    SampleFileWriter.destroy(pathToInput + "/java/enumerations");
    SampleFileWriter.destroy(pathToInput + "/IX.php");
    SampleFileWriter.destroy(pathToInput + "/ISomething.java");
    SampleFileWriter.destroy(pathToInput + "/Token.java");
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
    SampleFileWriter.destroy(pathToInput + "/Window.php");
    SampleFileWriter.destroy(pathToInput + "/Window.java");    
    SampleFileWriter.destroy(pathToInput + "/A_Guard.php");
    SampleFileWriter.destroy(pathToInput + "/B.php");
    
    SampleFileWriter.destroy(pathToInput + "/Tracer.java");
    SampleFileWriter.destroy(pathToInput + "/ConsoleTracer.php");
    SampleFileWriter.destroy(pathToInput + "/Company.php");
    SampleFileWriter.destroy(pathToInput + "/PhoneLine.php");
    SampleFileWriter.destroy(pathToInput + "/Manager.php");
    SampleFileWriter.destroy(pathToInput + "/PhoneSystemSimulation.php");
    SampleFileWriter.destroy(pathToInput + "/X.java");
    SampleFileWriter.destroy(pathToInput + "/X.php");
    SampleFileWriter.destroy(pathToInput + "/x.ruby");

    SampleFileWriter.destroy(pathToInput + "/StrobeLight.php");
    SampleFileWriter.destroy(pathToInput + "/Lamp.php");
    SampleFileWriter.destroy(pathToInput + "/Switch.php");
    SampleFileWriter.destroy(pathToInput + "/StateMachineTest.php");

    SampleFileWriter.destroy(pathToInput + "/Example.php");
    SampleFileWriter.destroy(pathToInput + "/example.rb");
    SampleFileWriter.destroy(pathToInput + "/Example.java");
    SampleFileWriter.destroy(pathToInput + "/GarageDoor.php");

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
    SampleFileWriter.destroy(pathToInput + "/x.rb");
    SampleFileWriter.destroy(pathToInput + "/one.rb");
    SampleFileWriter.destroy(pathToInput + "/two.rb");

    SampleFileWriter.destroy(pathToInput + "/i_code_translator.rb");
    SampleFileWriter.destroy(pathToInput + "/i_first_child.rb");
    SampleFileWriter.destroy(pathToInput + "/code_translator.rb");
    SampleFileWriter.destroy(pathToInput + "/i_second_child.rb");

    SampleFileWriter.destroy(pathToInput + "/NToNTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToNTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToOneTest.sql");
    SampleFileWriter.destroy(pathToInput + "/OneToOptionalOneTest.sql");
    SampleFileWriter.destroy(pathToInput + "/UnidirectionalOneTest.sql");
    SampleFileWriter.destroy(pathToInput + "/CompositePKGenTest.sql");
    SampleFileWriter.destroy(pathToInput + "/DoubleGenTest.sql");
    SampleFileWriter.destroy(pathToInput + "/DoubleChainGenTest.sql");
    SampleFileWriter.destroy(pathToInput + "/SingleGenTest.sql");

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
    SampleFileWriter.destroy(pathToInput + "/QSMwithUnspecifiedRecep.php");
    SampleFileWriter.destroy(pathToInput + "/Course.java");
    SampleFileWriter.destroy(pathToInput + "/QSMwithUnspecifiedRecep.java");
    SampleFileWriter.destroy(pathToInput + "/PooledSMwithUnspecifiedReception.java");    
    SampleFileWriter.destroy(pathToInput + "/PooledSMwithUnspecifiedReception.php"); 
    
    SampleFileWriter.destroy(pathToInput + "/Animal.java");
    SampleFileWriter.destroy(pathToInput + "/Bear.java");
    SampleFileWriter.destroy(pathToInput + "/Cat.java");
    SampleFileWriter.destroy(pathToInput + "/Cow.java");
    SampleFileWriter.destroy(pathToInput + "/Dog.java");
    SampleFileWriter.destroy(pathToInput + "/Moose.java");
    SampleFileWriter.destroy(pathToInput + "/Sheep.java");
    SampleFileWriter.destroy(pathToInput + "/ThingInWorld.java");
    SampleFileWriter.destroy(pathToInput + "/World.java");
    SampleFileWriter.destroy(pathToInput + "/Player.java");
    SampleFileWriter.destroy(pathToInput + "/Session.java");
    SampleFileWriter.destroy(pathToInput + "/Game.java");
    
    SampleFileWriter.destroy(pathToInput + "/Animal.php");
    SampleFileWriter.destroy(pathToInput + "/Bear.php");
    SampleFileWriter.destroy(pathToInput + "/Cat.php");
    SampleFileWriter.destroy(pathToInput + "/Cow.php");
    SampleFileWriter.destroy(pathToInput + "/Dog.php");
    SampleFileWriter.destroy(pathToInput + "/Moose.php");
    SampleFileWriter.destroy(pathToInput + "/Sheep.php");
    SampleFileWriter.destroy(pathToInput + "/ThingInWorld.php");
    SampleFileWriter.destroy(pathToInput + "/World.php");
    SampleFileWriter.destroy(pathToInput + "/Player.php");
    SampleFileWriter.destroy(pathToInput + "/Session.php");
    SampleFileWriter.destroy(pathToInput + "/Game.php");
    
    SampleFileWriter.destroy(pathToInput + "/A.java");
    SampleFileWriter.destroy(pathToInput + "/A.php");
    SampleFileWriter.destroy(pathToInput + "/a.rb");
    
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard.java");
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard.php");
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard2.java");
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithNegativeNumberGuard2.php");
    
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithStringComparisonGuard.java");
    SampleFileWriter.destroy(pathToInput + "/stateMachineWithStringComparisonGuard.php");
    
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
   
    SampleFileWriter.destroy(pathToInput + "/java/IClient.java");
    
    SampleFileWriter.destroy(pathToInput + "/java/IClientImpl.java");
    SampleFileWriter.destroy(pathToInput + "/java/Client.java");
    SampleFileWriter.destroy(pathToInput + "/java/ClientImpl.java");
    SampleFileWriter.destroy(pathToInput + "/java/ClientRemote.java");
    SampleFileWriter.destroy(pathToInput + "/java/UmpleRuntime.java");
    SampleFileWriter.destroy(pathToInput + "/java/IUmpleRuntime.java");
    SampleFileWriter.destroy(pathToInput + "/java/IUmpleObjectFactory.java");
    
    SampleFileWriter.destroy(pathToInput + "/java/distributed/");
    SampleFileWriter.destroy(pathToInput + "/java/ecommerceWS/");
    SampleFileWriter.destroy(pathToInput + "/java/ecommerceRMI0/");
    SampleFileWriter.destroy(pathToInput + "/java/ecommerceRMI1/");
    SampleFileWriter.destroy(pathToInput + "/java/proxyPattern/");

    
    SampleFileWriter.destroy(pathToInput + "/client.rb");
    SampleFileWriter.destroy(pathToInput + "/Client.php");
    
    // Tear down issue 923 tests
    SampleFileWriter.destroy(pathToInput + "/java/FileLogger.java");
    SampleFileWriter.destroy(pathToInput + "/java/Logger.java");
    SampleFileWriter.destroy(pathToInput + "/php/NetworkNode.php");
    SampleFileWriter.destroy(pathToInput + "/php/Router.php");
    
    // Tear down issue 1164 tests
    SampleFileWriter.destroy(pathToInput + "/MultipleConstraints.java");
    SampleFileWriter.destroy(pathToInput + "/MultipleConstraints.php");
    SampleFileWriter.destroy(pathToInput + "/multiple_constraints.rb");
    
    // Tear down issue 1444 tests
    SampleFileWriter.destroy(pathToInput + "/Academy.java");
    SampleFileWriter.destroy(pathToInput + "/Registration.java");
    
    // Tear down issue 1464 tests
    SampleFileWriter.destroy(pathToInput + "/JavaPhpRubyNoNullMethodInjection.java");
    SampleFileWriter.destroy(pathToInput + "/JavaPhpRubyNoNullMethodInjection.php");
    SampleFileWriter.destroy(pathToInput + "/java_php_ruby_no_null_method_injection.rb");
    
    // Tear down issue 1315 tests
    SampleFileWriter.destroy(pathToInput + "/B.java");
    SampleFileWriter.destroy(pathToInput + "/C.java");
    SampleFileWriter.destroy(pathToInput + "/I.java");
    SampleFileWriter.destroy(pathToInput + "/J.java");
    SampleFileWriter.destroy(pathToInput + "/Y.java");
    SampleFileWriter.destroy(pathToInput + "/b.rb");
    SampleFileWriter.destroy(pathToInput + "/c.rb");
    SampleFileWriter.destroy(pathToInput + "/i.rb");
    SampleFileWriter.destroy(pathToInput + "/j.rb");
    SampleFileWriter.destroy(pathToInput + "/y.rb");
    SampleFileWriter.destroy(pathToInput + "/z.rb");
    SampleFileWriter.destroy(pathToInput + "/m/");
    SampleFileWriter.destroy(pathToInput + "/n/");
    
    // Tear down issue 834 tests
    SampleFileWriter.destroy(pathToInput + "/First.java");
    SampleFileWriter.destroy(pathToInput + "/Second.java");
    SampleFileWriter.destroy(pathToInput + "/I.java");
    SampleFileWriter.destroy(pathToInput + "/first.rb");
    SampleFileWriter.destroy(pathToInput + "/second.rb");
    SampleFileWriter.destroy(pathToInput + "/i.rb");
    SampleFileWriter.destroy(pathToInput + "/First.php");
    SampleFileWriter.destroy(pathToInput + "/Second.php");
    SampleFileWriter.destroy(pathToInput + "/I.php");


    // Tear down issue 1521 tests
    SampleFileWriter.destroy(pathToInput + "/Student10.java");
    SampleFileWriter.destroy(pathToInput + "/Student11.java");
    SampleFileWriter.destroy(pathToInput + "/Student12.java");
    SampleFileWriter.destroy(pathToInput + "/toplevelAfterOnTraitClass.java");
    SampleFileWriter.destroy(pathToInput + "/Employer.java");
    SampleFileWriter.destroy(pathToInput + "/Student10.php");
    SampleFileWriter.destroy(pathToInput + "/Student11.php");
    SampleFileWriter.destroy(pathToInput + "/Student12.php");
    SampleFileWriter.destroy(pathToInput + "/toplevelAfterOnTraitClass.php");
    SampleFileWriter.destroy(pathToInput + "/Employer.php");
    SampleFileWriter.destroy(pathToInput + "/student_10.rb");
    SampleFileWriter.destroy(pathToInput + "/student_11.rb");
    SampleFileWriter.destroy(pathToInput + "/student_12.rb");
    SampleFileWriter.destroy(pathToInput + "/toplevel_after_on_trait_class.rb");
    SampleFileWriter.destroy(pathToInput + "/employer.rb");

   // destroying the object factory
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

  public void assertUmplePartialTemplateFor(String umpleFile, String codeFile)
  {
    assertUmplePartialTemplateFor(umpleFile, codeFile, null);   
  }
  
  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className, boolean isFullMatch)
  {
    assertUmpleTemplateFor(umpleFile, codeFile, className, isFullMatch, true);
  }
  

  public void assertGeneratedCodeEquals(String pathToInput, String actualFilename)
  {
    String expectedFilename = actualFilename + ".txt";
    SampleFileWriter.assertFileContent(new File(pathToInput + expectedFilename), new File(pathToInput + actualFilename), false);
  }

  public void assertUmpleTemplateFor(String umpleFile, String codeFile, String className, boolean isFullMatch, boolean ignoreLineComments)
  {
    
    String checkFile = pathToInput + "/" + umpleFile;
    if (!(new File(checkFile).exists()))
    {
      Assert.fail("Unable to locate umple file: " + checkFile);
    }

    checkFile = pathToInput + "/" + codeFile;
    if (!(new File(pathToInput + "/" + codeFile).exists()))
    {
      Assert.fail("Unable to locate code file: " + checkFile);
    }
        
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
    File file = new File(pathToInput, filename);
    UmpleModel model = new UmpleModel(new UmpleFile(pathToInput, filename));
    model.setShouldGenerate(false);
    if( aTracer != null )
    	model.setTracer(new TracerDirective(aTracer));
    RuleBasedParser rbp = new RuleBasedParser();
    UmpleParser parser = new UmpleInternalParser(umpleParserName, model, rbp);
    ParseResult result = rbp.parse(file);
    model.extractAnalyzersFromParser(rbp);
    model.setLastResult(result);

    if (!result.getWasSuccess())
    {
      Assert.fail("Syntax Failed at:" + result.getPosition());
    }

    model.setUmpleFile(new UmpleFile(new File(path, filename)));

    if (language != null)
    {
      if(suboptions != null)
      {
        GenerateTarget target = new GenerateTarget(language, null);
        for(int i = 0; i < suboptions.length; i++) {
          target.addSuboption(suboptions[i]);
        }
        model.addGenerate(target);
      }
      else
      {
        model.addGenerate(language);
      }
    }

    result = parser.analyze(true);
    if (!result.getWasSuccess())
    {
      Assert.fail("Semantics Failed at:" + result.getPosition());
    }
    else
    {
      //Issue 962 - Until all autogenerated methods are added to the model
      //there will be a need to disable partially or all tests relating to
      //autogen methods
      //if (language == "Java") autogeneratedMethodsCheck(model);
    }

    return model;
  }
  
  private void autogeneratedMethodsCheck(UmpleModel genModel)
  {
    try
    {
      ArrayList<Method> allGeneratedMethods = getAllGeneratedMethods(genModel);
      
	  String errorMessage = new String();
	  boolean hasAllGeneratedMethods = true;
	  boolean hasNoExtraMethod = true;
	
	  for(UmpleClass uClass : genModel.getUmpleClasses())
	  {
		for(Method method : allGeneratedMethods)
		{
		  if(uClass.hasMethod(method)) //Verifying if the model does have the method
		  {
			method.setWasGenerated(true);
		  }
		}
	  
		for(Method method : uClass.getMethods())
		{
		  //Verifying if there are extra methods
		  if (method.getSource() == Method.Source.fAutoAPI && !allGeneratedMethods.contains(method) && !method.isIsConstructor())
		  {
			
			errorMessage += "Extra method in class " + uClass.getName() + " : ";
			String methodStr = method.toString();
			int bodyIndex = methodStr.indexOf("{");
			errorMessage += method.getModifier() + methodStr.substring(0, bodyIndex) + "\n";
		  
			hasNoExtraMethod = false;
			
		  }
		}
	  }
	
	  for(Method method : allGeneratedMethods)
	  {
		if(!method.getWasGenerated())
		{
		
		  errorMessage += "Missing method : ";
		  String methodStr = method.toString();
		  int bodyIndex = methodStr.indexOf("{");
		  errorMessage += method.getModifier() + methodStr.substring(0, bodyIndex) + "\n";
		
		  hasAllGeneratedMethods = false;
		
		}
	  }
	
	  if (!hasNoExtraMethod || !hasAllGeneratedMethods)
	  {
		Assert.fail(errorMessage);
	  }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private ArrayList<Method> getAllGeneratedMethods(UmpleModel genModel) throws Exception
  {
    String codeToParse = new String();
    Collection<String> allClasses = genModel.getGeneratedCode().values();
    for (String code : allClasses)
    {
      codeToParse += code;
    }
    
    List<String> generatedMethods = new ArrayList<String>();
    ArrayList<Method> allGeneratedMethods = new ArrayList<Method>();
    Matcher m = Pattern.compile("public( static)? [a-zA-Z0-9_<>]* [a-zA-Z0-9_]*\\((.*)\\)").matcher(codeToParse);
    while (m.find()) {
      generatedMethods.add(m.group());
    }
    
    for(String methodString : generatedMethods)
    {
      if(isUserAddedMethod(methodString))  continue;
      
      String[] parts;
      String name = new String();
      String type = new String();
      int parameterPosition = 0;
      
      if (methodString.contains("static"))
      {
        parts = methodString.split(" ", 4);
        name = parts[3].split("\\(")[0];
        type = getUmpleType(parts[2]);
        parameterPosition = 3;
      }
      else
      {
        parts = methodString.split(" ", 3);
        name = parts[2].split("\\(")[0];
        type = getUmpleType(parts[1]);
        parameterPosition = 2;
      }
      
      Method method = new Method("public", name, type, false);
      method.setMethodBody(new MethodBody(""));
      
      if( !method.getName().equals("delete") && !method.getName().equals("toString") )
      {
		for (String parameter : parts[parameterPosition].split("\\(")[1].replace(")", "").split(","))
		{
		  if(!parameter.equals(""))
		  {
			parameter = parameter.trim();
			String paramName = parameter.split(" ")[1];
			String paramType = parameter.split(" ")[0];
			
			if(paramType.contains("."))
			{
			  paramType = getUmpleType(paramType.split(".")[1]);
			}
			else
			{
			  paramType = getUmpleType(paramType);
			}
			
			MethodParameter mp = new MethodParameter(paramName, paramType, "", "", false);
			method.addMethodParameter(mp);
		  }
		}
		allGeneratedMethods.add(method);
      }
    }
    
    return allGeneratedMethods;
  }
  
  private String getUmpleType(String javaType)
  {
    switch (javaType)
    {
      case "int":      return "Integer";
      case "boolean" : return "Boolean";
      case "float" :   return "Float";
      case "double" :  return "Double";
      default:         return javaType;
    }
  }
  
  private boolean isUserAddedMethod(String m)
  {
    //needs to be improved
    return !(m.contains("get") || m.contains("set") || m.contains("add") || m.contains("is") || m.contains("minimum")
    || m.contains("numberOf") || m.contains("indexOf") ||  m.contains("has") || m.contains("remove"));
  }
  
}
