package cruise.umple.implementation.py.innerClassPy;

import org.junit.*;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

import java.util.Map;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import java.util.Map;


public class PythonInnerClassTest extends TemplateTest {

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation/py/innerClassPy");
    pathToRoot = SampleFileWriter.rationalize("../cruise.umple");
    language = null;
    suboptions = null;
    languagePath = "py";
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    aTracer = null;
    tracerPath = null;
  }
	
  @Test @Ignore
  public void TestInnerStaticClass()
  {
    assertUmpleTemplateFor("/innerStatic.ump", "/innerStatic.py.txt", "OuterClass_1");
  }

  @Test
  public void TestInnerNonStaticClass()
  {
    assertUmpleTemplateFor("/innerNonStatic.ump", "/InnerNotStatic.py.txt", "OuterClass_2");
  }
  @Test
  public void TestInnerStaticAndNonStaticClass()
  {
    assertUmpleTemplateFor("/innerClasses.ump",  "/innerClasses.py.txt", "OuterClass_3");
  }

  @Test @Ignore
  public void TestNoPackageNameForInnerElement()
  {
    UmpleFile uFile = new UmpleFile(pathToInput+"/OuterClassWithNameSpace.ump");
    UmpleModel umpleModel = new UmpleModel(uFile);
    umpleModel.run();
    umpleModel.generate();
    Map<String, String> map= umpleModel.getGeneratedCode();
    String generatedCodeforClass = map.get("OuterClassWithNameSpace");
    //if there is only one import-statement, its split should generate 2 strings:
    Assert.assertEquals(generatedCodeforClass.split("package com.umple.innerClasses").length , 2);
    // assertUmpleTemplateFor("/innerClasses.ump",  "/innerClasses.py.txt", "OuterClass_3");
  }
 
  @Test 
  public void TestNoPackageNameForInnerElementInDifferentPackages() {
   
    UmpleFile umpleFile = new UmpleFile(pathToInput+"/diffPackages_master.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();

    Map<String, String> map = umodel.getGeneratedCode();
    String generatedCodeforClass = map.get("AClassAtHome");
    Assert.assertFalse(generatedCodeforClass.contains("import"));  // import statment should not be added before the inner static class.
    System.out.println(generatedCodeforClass);

  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(pathToInput + "/OuterClass_1.py");
    SampleFileWriter.destroy(pathToInput + "/OuterClass_2.py");
    SampleFileWriter.destroy(pathToInput + "/OuterClass_3.py");
    SampleFileWriter.destroy(pathToInput + "/com");
  }

}



