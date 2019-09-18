package cruise.umple.implementation.java.innerClass;

import org.junit.*;
import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class InnerClassTest extends TemplateTest {

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation/java/innerClass");
    pathToRoot = SampleFileWriter.rationalize("../cruise.umple");
    language = null;
    suboptions = null;
    languagePath = "java";
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
    aTracer = null;
    tracerPath = null;
  }
	
  @Test
  public void TestInnerStaticClass()
  {
    assertUmpleTemplateFor("/innerStatic.ump", "/innerStatic.java.txt", "OuterClass_1");
  }

  @Test
  public void TestInnerNonStaticClass()
  {
    assertUmpleTemplateFor("/innerNonStatic.ump", "/InnerNotStatic.java.txt", "OuterClass_2");
  }
  @Test
  public void TestInnerStaticAndNonStaticClass()
  {
    assertUmpleTemplateFor("/innerClasses.ump",  "/innerClasses.java.txt", "OuterClass_3");
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(pathToInput + "/OuterClass_1.java");
    SampleFileWriter.destroy(pathToInput + "/OuterClass_2.java");
    SampleFileWriter.destroy(pathToInput + "/OuterClass_3.java");
  }

}



