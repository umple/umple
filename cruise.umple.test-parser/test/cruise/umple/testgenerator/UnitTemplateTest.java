/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

 */

package cruise.umple.testgenerator;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cruise.umple.unitGen.jUnit.*;
import cruise.umple.compiler.GenerateTarget;
import cruise.umple.compiler.TracerDirective;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleInternalParser;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleParser;
import cruise.umple.parser.ParseResult;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.testgenerator.TestCaseJUnitGenerator;
import cruise.umple.testgenerator.TestCasePhpUnitGenerator;
import cruise.umple.testgenerator.TestCaseRubyUnitGenerator;
import cruise.umple.testgenerator.TestModel;
import cruise.umple.testparser.TestParser;
import cruise.umple.util.SampleFileWriter;


public class UnitTemplateTest
{

  public String pathToInput;
  public String pathToRoot;
  public String language;
  public String[] suboptions;
  public String languagePath;
  public String umpleParserName;

  @Before
  public void setUp()
  {
    //pathToInput = SampleFileWriter.rationalize("/MBTParser/test/cruise/umple/testgenerator/");
	  pathToInput = "test/cruise/umple/testgenerator/";
   
    //pathToRoot = SampleFileWriter.rationalize("../MBTParser/test/cruise/umple");
	  pathToRoot = "test/cruise/umple";
    language = null;
    suboptions = null;
    languagePath = "JUnit";
    umpleParserName = "umple.testParser.Mbt_parser";
  }

  @After
  public void tearDown()
  {
    // Tear down 
    //SampleFileWriter.destroy(pathToInput + "/MultipleConstraints.java");
    
  }

  @Test
  public void avoidJunitError()
  {}

  // ```````````````````
  // INTERFACE
  // ```````````````````

 
  

  public void assertGeneratedCodeEquals(String pathToInput, String actualFilename)
  {
    String expectedFilename = actualFilename + ".txt";
    SampleFileWriter.assertFileContent(new File(pathToInput + expectedFilename), new File(pathToInput + actualFilename), false);
  }

  public void assertUmpleTestTemplateFor(String umpleFile, String codeFile, String className, boolean isFullMatch, boolean ignoreLineComments)
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
        
    TestModel aTestModel = createUmpleTestSystem(pathToInput, umpleFile);
    

    String actual = aTestModel.getCode();
   

    File expected = new File(pathToInput, codeFile);
    //system.out.println(actual);


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

  public TestModel createUmpleTestSystem(String path, String filename)
  {
	//language ="JUnit";
    //File file = new File(pathToInput+"/" + path, filename);
    File file = new File(pathToInput+path+filename);
    TestModel aTestModel = new TestModel(null, null, null, null, null,null, null, null);
    TestParser parser = new TestParser(null, "", file, 0);
    //ParseResult result = new ParseResult(false);
    parser.setGrammarFile("src/ump/mbt_parsing.grammar");
    parser.setTestModelFile(file);
    parser.setTestModelFile(file);
    ////system.out.println(file.getAbsolutePath());
    ////system.out.println(path);
    parser.prepare();
    aTestModel = parser.getATestModel();
    ////system.out.println(aTestModel.toString());
    String codeLang = "";
    codeLang = aTestModel.getCodeLang();
    /*try {
    	
    }
    
    catch (Exception e) {
    	//system.out.println("Error parsing model: " + e.getMessage());    	
    }*/
    
    if(codeLang == null)
    {
    	//system.out.println("Error parsing model: ");
    }
    
    
    
    switch(codeLang)
    {
    case "JUnit" :
    TestCaseJUnitGenerator junitGenerator = new TestCaseJUnitGenerator(null, null, null, null, null);
    junitGenerator.setTestModel(aTestModel);
    junitGenerator.setPath(pathToInput+path);
    junitGenerator.writeFile();
    break;
    case "PhpUnit" :
    	TestCasePhpUnitGenerator phpGenerator = new TestCasePhpUnitGenerator(null, null, null, null, null); 
        phpGenerator.setTestModel(aTestModel);
        phpGenerator.setPath(pathToInput+path);
        phpGenerator.writeFile();
        break;
    case "RubyUnit" :
    	TestCaseRubyUnitGenerator rubyGenerator = new TestCaseRubyUnitGenerator(null, null, null, null, null); 
        rubyGenerator.setTestModel(aTestModel);
        rubyGenerator.setPath(pathToInput+path);
        rubyGenerator.writeFile();
        break;
    
    }
    
    return aTestModel;
  }
  
  public UmpleModel createUmpleSystem(String path, String filename)
  {	
    File file = new File(pathToInput+path, filename);
    UmpleModel model = new UmpleModel(new UmpleFile(path, filename));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    UmpleParser parser = new UmpleInternalParser("cruise.umple.compiler.UmpleInternalParser", model, rbp);
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

    
    return model;
  }
}
