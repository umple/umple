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

import cruise.umple.util.SampleFileWriter;

// Generating several targets from one model gives each target the code it gets when generated
// alone: preparation (such as a target's unique-attribute and sorting code, or the constructor of a
// subclass declared before its parent) leaves nothing behind, and rendering a contract does not change it
public class MultipleTargetsFromOneModelTest
{
  private static final String MODEL =
    "class Machine {\n" +
    "  Integer n = 0;\n" +
    "  Boolean flag = false;\n" +
    "  unique Integer serial;\n" +
    "  0..1 -- * Part parts sorted {rank};\n" +
    "  int work(int a) Java { [pre: a > 1] [post: a < 9] return a; } Php { [pre: a > 2] return $a; } { [pre: a > 3] return a; }\n" +
    "  int both(int a) { [pre: a > 1 && flag] [pre: !(a > 2) || a == 5] return a; }\n" +
    "  sm {\n" +
    "    On {\n" +
    "      entry [n > 1] / { n = 1; } Java { n = 2; }\n" +
    "      Inner { go -> Other; }\n" +
    "      Other {}\n" +
    "      off -> Off;\n" +
    "    }\n" +
    "    Off { on -> On; }\n" +
    "  }\n" +
    "}\n" +
    "class Spare { isA Part; Integer grade; }\n" +
    "class Part { Integer rank; }\n";

  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umpleTargets").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getAbsolutePath());
  }

  @Test
  public void eachTargetGetsItsOwnCode() throws Exception
  {
    String[] targets = {"Java", "Php", "Ruby", "RTCpp", "PythonNext", "Java", "PythonNext", "Php"};
    UmpleModel shared = parse();
    for (String target : targets)
    {
      Assert.assertEquals(target, generate(parse(), target), generate(shared, target));
    }

    // Only the authored actions are left once generation is over
    int actions = 0;
    for (StateMachine sm : shared.getUmpleClass("Machine").getAllStateMachines())
    {
      for (State state : sm.getStates())
      {
        actions += state.numberOfActions();
      }
    }
    Assert.assertEquals(1, actions);
  }

  @Test
  public void contractsFollowTheSelectedBody() throws Exception
  {
    UmpleModel model = parse();
    String java = generate(model, "Java").get("Machine");
    Assert.assertTrue(java.contains("if (a<=1)"));
    Assert.assertTrue(java.contains("if (a>=9)"));
    Assert.assertFalse(java.contains("a<=2"));
    Assert.assertFalse(java.contains("a<=3"));

    String php = generate(model, "Php").get("Machine");
    Assert.assertTrue(php.contains("a<=2"));
    Assert.assertFalse(php.contains("a<=1"));
    Assert.assertFalse(php.contains("a>=9"));

    // Ruby has no body of its own and takes the untagged one, with its condition
    String ruby = generate(model, "Ruby").get("Machine");
    Assert.assertTrue(ruby.contains("a<=3"));
    Assert.assertFalse(ruby.contains("a<=1"));
  }

  // A redeclaration keeps the bodies it adds, whichever of its blocks holds only conditions, and
  // conditions declared first go with the bodies a redeclaration adds, while their empty untagged
  // body is none
  @Test
  public void redeclarationsKeepTheirBodiesAndConditions() throws Exception
  {
    String model = "class A {\n"
      + "  Integer m(Integer a) Java { return a; } Python { return a }\n"
      + "  Integer m(Integer a) Java { [pre: a > 0] } Php { return $a; }\n"
      + "  Integer k(Integer a) { [pre: a > 0] }\n"
      + "  Integer k(Integer a) Java { return a; }\n"
      + "  Integer p(Integer a) { [pre: a > 0] }\n"
      + "  Integer p(Integer a) Python { return a }\n"
      + "}\n";
    String php = generate(parse(model), "Php").get("A");
    Assert.assertTrue(php, php.contains("return $a;"));
    String java = generate(parse(model), "Java").get("A");
    String k = java.substring(java.indexOf("public Integer k("));
    Assert.assertTrue(java, k.substring(0, k.indexOf("return a;")).contains("a<=0"));
    // The first declaration's empty untagged body is no body: Java, which has none, leaves p out
    Assert.assertFalse(java, java.contains("public Integer p("));
    // Conditions of an untagged block with no code go with bodies declared before and after them;
    // those of a tagged block with no code stay with that language
    String orders = "class B {\n"
      + "  Integer n(Integer a) Python { return a }\n"
      + "  Integer n(Integer a) { [pre: a > 0] }\n"
      + "  Integer n(Integer a) Java { return a; }\n"
      + "  Integer q(Integer a) Java { [pre: a > 0] } Php { return $a; }\n"
      + "  Integer q(Integer a) Python { return a }\n"
      + "}\n";
    String javaB = generate(parse(orders), "Java").get("B");
    String n = javaB.substring(javaB.indexOf("public Integer n("));
    Assert.assertTrue(javaB, n.substring(0, n.indexOf("return a;")).contains("a<=0"));
    String pythonB = generate(parse(orders), "PythonNext").get("B");
    String q = pythonB.substring(pythonB.indexOf("def q("));
    Assert.assertFalse(pythonB, q.substring(0, q.indexOf("return a")).contains("a > 0"));
    // One declaration can hold both kinds: the untagged block's conditions reach every body, the
    // Python block's only Python's, before or after the bodies
    for (String mixed : new String[] {
      "  Integer m(Integer a) Java { return a; } Python { return a }\n  Integer m(Integer a) { [pre: a > 0] } Python { [pre: a < 10] }\n",
      "  Integer m(Integer a) { [pre: a > 0] } Python { [pre: a < 10] }\n  Integer m(Integer a) Java { return a; } Python { return a }\n",
      "  Integer m(Integer a) Java { return a; }\n  Integer m(Integer a) { [pre: a > 0] } Python { [pre: a < 10] return a }\n" })
    {
      String javaC = generate(parse("class C {\n" + mixed + "}\n"), "Java").get("C");
      String javaM = javaC.substring(javaC.indexOf("public Integer m("));
      javaM = javaM.substring(0, javaM.indexOf("return a;"));
      Assert.assertTrue(mixed, javaM.contains("a<=0") && !javaM.contains("a>=10"));
      String pythonC = generate(parse("class C {\n" + mixed + "}\n"), "PythonNext").get("C");
      Assert.assertTrue(mixed + pythonC, pythonC.contains("a > 0") && pythonC.contains("a < 10"));
    }
    // The untagged body a tagged block with conditions only takes is replaced by a body of that
    // language declared later, in either order of the conditions and the untagged body
    String replaced = "class D {\n"
      + "  Integer m(Integer a) { return a + 100; }\n  Integer m(Integer a) Java { [pre: a > 0] }\n  Integer m(Integer a) Java { return a; }\n"
      + "  Integer k(Integer a) Java { [pre: a > 0] }\n  Integer k(Integer a) { return a + 100; }\n  Integer k(Integer a) Java { return a; }\n"
      + "}\n";
    String javaD = generate(parse(replaced), "Java").get("D");
    for (String method : new String[] { "public Integer m(", "public Integer k(" })
    {
      String body = javaD.substring(javaD.indexOf(method));
      body = body.substring(0, body.indexOf("\n  }"));
      Assert.assertTrue(javaD, body.contains("a<=0") && body.contains("return a;") && !body.contains("a + 100"));
    }
  }

  // Declarations of one method in every order of one to three of these blocks, each with its own
  // condition and body, so the body and conditions each language takes show which blocks it kept
  private static final String[][] BLOCKS = {
    { "U", "{ [pre: a > 1] return a + 1; }" }, { "U2", "{ [pre: a > 2] return a + 2; }" }, { "UC", "{ [pre: a > 3] }" },
    { "J", "Java { [pre: a > 4] return a + 4; }" }, { "JC", "Java { [pre: a > 5] }" },
    { "P", "Python { [pre: a > 6] return a + 6 }" }, { "PC", "Python { [pre: a > 7] }" } };

  // Each language takes its own first body, else the first untagged body, with that body's condition,
  // the conditions of its blocks without code and those of untagged blocks without code; a language
  // with neither body has no method
  @Test
  public void redeclarationsInEveryOrder() throws Exception
  {
    List<List<Integer>> orders = new ArrayList<List<Integer>>();
    for (int i = 0; i < BLOCKS.length; i++)
    {
      orders.add(Arrays.asList(i));
      for (int j = 0; j < BLOCKS.length; j++)
      {
        if (j == i) continue;
        orders.add(Arrays.asList(i, j));
        for (int k = 0; k < BLOCKS.length; k++)
        {
          if (k != i && k != j) orders.add(Arrays.asList(i, j, k));
        }
      }
    }
    JavaGenerator renderer = new JavaGenerator();
    for (List<Integer> order : orders)
    {
      StringBuilder text = new StringBuilder("class R {\n");
      List<String> names = new ArrayList<String>();
      for (int block : order)
      {
        text.append("  Integer m(Integer a) ").append(BLOCKS[block][1]).append("\n");
        names.add(BLOCKS[block][0]);
      }
      UmpleModel model = parse(text.append("}\n").toString());
      renderer.setModel(model);
      UmpleClass r = model.getUmpleClass("R");
      Method m = r.getMethods().get(0);
      Assert.assertEquals(names + " warnings", names.contains("U") && names.contains("U2") ? 1 : 0, warnings49(model));
      String untagged = first(names, "U", "U2");
      // Conditions alone make a method only when no language has a body
      boolean anyBody = untagged != null || names.contains("J") || names.contains("P");
      for (String[] language : new String[][] { { "Java", "J", "JC" }, { "Python", "P", "PC" }, { "Php", null, null } })
      {
        String own = names.contains(language[1]) ? language[1] : null;
        boolean exists = own != null || untagged != null || !anyBody && (names.contains("UC") || names.contains(language[2]));
        boolean actual = "Python".equals(language[0]) ? PythonNextGenerator.pythonLanguage(m) != null : m.getExistsInLanguage(language[0]);
        Assert.assertEquals(names + " " + language[0], exists, actual);
        if (!exists) continue;
        String body = own != null ? own : untagged;
        Set<String> expected = new TreeSet<String>();
        for (String name : new String[] { body, "UC", language[2] })
        {
          if (name != null && names.contains(name)) expected.add(number(name));
        }
        Set<String> conditions = new TreeSet<String>();
        for (Precondition condition : r.getMethodPreconditions(m, language[0]))
        {
          conditions.add(renderer.translate("Plain", condition).replaceAll("[^0-9]", ""));
        }
        String code = m.getMethodBody().getCodeblock().getCode(m.getBodyLanguageFor(language[0]));
        Assert.assertEquals(names + " " + language[0] + " body", body == null ? "" : "a + " + number(body), code.trim().replaceAll("^return |;$", ""));
        Assert.assertEquals(names + " " + language[0] + " conditions", expected, conditions);
      }
    }
  }

  // Each disregarded body is reported once with warning 49, and a block of conditions only never is
  @Test
  public void eachDisregardedBodyIsReportedOnce() throws Exception
  {
    Assert.assertEquals(2, warnings49(parse("class A {\n  Integer m(Integer a) Java { return 1; }\n  Integer m(Integer a) Java { return 2; } Java { return 3; }\n}\n")));
    Assert.assertEquals(2, warnings49(parse("class A {\n  Integer m(Integer a) { return 1; }\n  Integer m(Integer a) { return 2; } { return 3; }\n}\n")));
    Assert.assertEquals(1, warnings49(parse("class A {\n  Integer m(Integer a) { return 1; }\n  Integer m(Integer a) { [pre: a != 2] } { return 3; }\n}\n")));
    Assert.assertEquals(0, warnings49(parse("class A {\n  Integer m(Integer a) Python { return 1 }\n  Integer m(Integer a) Java { [pre: a != 2] } Java { return 3; }\n}\n")));
  }

  private static int warnings49(UmpleModel model)
  {
    int count = 0;
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      count += message.getErrorType().getErrorCode() == 49 ? 1 : 0;
    }
    return count;
  }

  private static String first(List<String> names, String... candidates)
  {
    for (String name : names)
    {
      if (Arrays.asList(candidates).contains(name)) return name;
    }
    return null;
  }

  private static String number(String name)
  {
    for (String[] block : BLOCKS)
    {
      if (block[0].equals(name)) return block[1].replaceAll("^[^0-9]*([0-9]).*$", "$1");
    }
    return null;
  }

  // Rendering a condition for one target must not change the condition the next target reads
  @Test
  public void generationLeavesConditionsAsWritten() throws Exception
  {
    UmpleModel model = parse();
    List<String> before = conditions(model);
    for (String target : new String[] {"Java", "Php", "Ruby", "PythonNext", "Java"})
    {
      generate(model, target);
      Assert.assertEquals(target, before, conditions(model));
    }
  }

  private List<String> conditions(UmpleModel model)
  {
    JavaGenerator renderer = new JavaGenerator();
    renderer.setModel(model);
    List<String> conditions = new ArrayList<String>();
    for (Precondition condition : model.getUmpleClass("Machine").getPreConds())
    {
      conditions.add((condition.getDisplayNegation() ? "!" : "") + renderer.translate("Plain", condition));
    }
    return conditions;
  }

  private UmpleModel parse() throws Exception
  {
    return parse(MODEL);
  }

  private UmpleModel parse(String text) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), text.getBytes(StandardCharsets.UTF_8));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(false);
    try
    {
      model.run();
    }
    catch (cruise.umple.compiler.exceptions.UmpleCompilerException e)
    {
      // a warning such as 49 for a disregarded body; the model is still complete
    }
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      Assert.assertTrue(message.getFormattedMessage(), message.getErrorType().getSeverity() > 2);
    }
    return model;
  }

  private Map<String,String> generate(UmpleModel model, String target)
  {
    model.clearGenerates();
    model.addGenerate(target);
    model.getGeneratedCode().clear();
    Assert.assertNull(model.generate());
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      Assert.assertTrue(target + ": " + message.getFormattedMessage(), message.getErrorType().getSeverity() > 2);
    }
    return new TreeMap<String,String>(model.getGeneratedCode());
  }
}
