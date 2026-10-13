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

  @Test
  public void TestNoPackageNameForInnerElement()
  {
    UmpleFile uFile = new UmpleFile(pathToInput+"/OuterClassWithNameSpace.ump");
    UmpleModel umpleModel = new UmpleModel(uFile);
    umpleModel.run();
    umpleModel.generate();
    Map<String, String> map= umpleModel.getGeneratedCode();
    String generatedCodeforClass = map.get("OuterClassWithNameSpace");
    // Python nests an inner class in its outer class's module: no module of its own, no import
    Assert.assertFalse(map.containsKey("InnerStatic"));
    Assert.assertTrue(generatedCodeforClass, generatedCodeforClass.contains("    class InnerStatic:"));
    Assert.assertFalse(generatedCodeforClass, generatedCodeforClass.contains("import"));
  }
 
  @Test
  public void TestNoPackageNameForInnerElementInDifferentPackages() {
   
    UmpleFile umpleFile = new UmpleFile(pathToInput+"/diffPackages_master.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();

    Map<String, String> map = umodel.getGeneratedCode();
    String generatedCodeforClass = map.get("AClassAtHome");
    // the nested class's interface comes from its own package; nothing is imported for the nested class itself
    Assert.assertTrue(generatedCodeforClass, generatedCodeforClass.contains("from com.me.at.uottawa.RootDoWork import RootDoWork"));
    Assert.assertFalse(generatedCodeforClass, generatedCodeforClass.contains("from com.me.at.home"));

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


