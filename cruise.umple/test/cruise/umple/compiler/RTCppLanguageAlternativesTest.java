/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import org.junit.*;

import cruise.umple.cpp.generator.UmpleModelGenerationPolicy;
import cruise.umple.util.SampleFileWriter;

// RTCpp takes a method's preconditions from the body it emits, and guards tagged entry actions
public class RTCppLanguageAlternativesTest
{
  private static final String MODEL =
    "class X {\n" +
    "  Integer n = 0;\n" +
    "  int f(int a) Cpp { [pre: a > 1] return 1; } { [pre: a > 2] return 2; }\n" +
    "  int g(int a) Java { [pre: a > 3] return 3; } { [pre: a > 4] return 4; }\n" +
    "  int h(int a) Cpp {} { [pre: a > 5] return 5; }\n" +
    "  sm {\n" +
    "    s1 {\n" +
    "      entry [n > 1] / { n = 1; } RTCpp { n = 7; }\n" +
    "      e -> s2;\n" +
    "    }\n" +
    "    s2 {}\n" +
    "  }\n" +
    "}\n";

  private File dir;
  private UmpleModel model;
  private String languageUsed;

  @Before
  public void setUp() throws Exception
  {
    languageUsed = CodeBlock.languageUsed;
    dir = Files.createTempDirectory("umpleRTCpp").toFile();
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), MODEL.getBytes(StandardCharsets.UTF_8));
    model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(false);
    model.run();
  }

  @After
  public void tearDown()
  {
    CodeBlock.languageUsed = languageUsed;
    SampleFileWriter.destroy(dir.getAbsolutePath());
  }

  @Test
  public void preconditionsFollowTheEmittedBody()
  {
    CodeBlock.languageUsed = "RTCpp";
    UmpleClass x = model.getUmpleClass("X");
    assertBodyAndPrecondition(x, "f", "return 1;", "a>1");
    assertBodyAndPrecondition(x, "g", "return 4;", "a>4");
    // An empty Cpp body makes RTCpp emit the untagged one, so its condition comes with it
    assertBodyAndPrecondition(x, "h", "return 5;", "a>5");
  }

  @Test
  public void guardKeptOnTaggedEntryAction()
  {
    model.clearGenerates();
    model.addGenerate("RTCpp");
    Assert.assertNull(model.generate());
    String code = "";
    for (String generated : model.getGeneratedCode().values())
    {
      code += generated;
    }
    int guard = code.indexOf("if (n > 1)");
    Assert.assertTrue(guard != -1);
    Assert.assertTrue(code.indexOf("n = 7;", guard) != -1);
    Assert.assertFalse(java.util.regex.Pattern.compile("\\bn = 1;").matcher(code).find());
  }

  private void assertBodyAndPrecondition(UmpleClass x, String name, String body, String condition)
  {
    Method method = null;
    for (Method m : x.getMethods())
    {
      if (name.equals(m.getName())) method = m;
    }
    Assert.assertEquals(body, UmpleModelGenerationPolicy.getBody(method, "Cpp"));
    List<Precondition> conditions = UmpleModelGenerationPolicy.constraints(method, x);
    Assert.assertEquals(1, conditions.size());
    Assert.assertSame(method, conditions.get(0).getMethod());
    Assert.assertEquals(condition, new JavaGenerator().translate("Plain", conditions.get(0)));
  }
}
