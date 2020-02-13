package cruise.umple.implementation.java.strictness;

import org.junit.*;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

import java.util.Map;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;

public class StrictnessTest extends TemplateTest {

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation/java/strictness");
    pathToRoot = SampleFileWriter.rationalize("../cruise.umple");
    language = null;
    suboptions = null;
    languagePath = "java";
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    aTracer = null;
    tracerPath = null;
  }

  @Test
  public void testNoDefaultConstructor()
  {
    UmpleFile uFile = new UmpleFile(pathToInput+"/strictness_noCons.ump");
    UmpleModel umpleModel = new UmpleModel(uFile);
    umpleModel.run();
    umpleModel.generate();
    Map<String, String> map = umpleModel.getGeneratedCode();
    String generatedCodeforClass = map.get("StrictnessClassNoConstructor");
    Assert.assertFalse(generatedCodeforClass.contains("StrictnessClassNoConstructor(int aX, String aStringField1)"));
  }

  @Test
  public void testNoAutoDelete()
  {
    UmpleFile uFile = new UmpleFile(pathToInput+"/strictness_noDelete.ump");
    UmpleModel umpleModel = new UmpleModel(uFile);
    umpleModel.run();
    umpleModel.generate();
    Map<String, String> map = umpleModel.getGeneratedCode();
    String generatedCodeforClass = map.get("StrictnessClassNoDelete");
    Assert.assertFalse(generatedCodeforClass.contains("public void delete()"));
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(pathToInput + "/generatedCode/SupertSrictnessClass.java"); 
    SampleFileWriter.destroy(pathToInput + "/generatedCode/StrictnessClassNoConstructor.java"); 
    SampleFileWriter.destroy(pathToInput + "/generatedCode/StrictnessClassNoDelete.java");
    SampleFileWriter.destroy(pathToInput + "/generatedCode");
  }

}



