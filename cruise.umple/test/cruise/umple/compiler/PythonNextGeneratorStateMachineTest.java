/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;

// State machines in the native Python generator. Their runtime behaviour
// is tested in testbed_pythonnext/test/sm.
public class PythonNextGeneratorStateMachineTest
{
  private File dir;

  // Every state machine feature Python supports, with Python-tagged actions
  private static final String MACHINES =
    "class Machine {\n" +
    "  Integer count = 0;\n" +
    "  state {\n" +
    "    Off { on -> On; rest -> Resting; }\n" +
    "    On {\n" +
    "      entry / Python { self.setCount(self.getCount() + 1) }\n" +
    "      exit / Python { self.setCount(0) }\n" +
    "      off -> Off;\n" +
    "      Idle { after(0.5) -> Busy; }\n" +
    "      Busy { do Python { thread.cancelled.wait(1) } -> Done; do Python { pass } }\n" +
    "      Done { go(Integer n) [n > 5] / Python { self.setCount(n) } -> Final; go(Integer n) [n > 0] -> Idle; go(Integer n) -> Done; }\n" +
    "    }\n" +
    "    Resting { -> Off; }\n" +
    "  }\n" +
    "  regions {\n" +
    "    Both { left { L { first -> LeftDone; } final LeftDone {} } || right { R { second -> RightDone; } final RightDone {} } }\n" +
    "  }\n" +
    "  history { A { next -> B; } B { X { next -> Y; } Y {} leave -> C; } C { resume -> B.H; } }\n" +
    "}\n";

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-sm").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  @Test
  public void queuedAndPooledMachinesAreReportedAsUnsupported() throws Exception
  {
    UmpleModel model = generate(
      "class Waiter { queued sm { A { go -> B; } B {} } }\n" +
      "class Pool { pooled sm { A { go -> B; } B {} } }\n" +
      "class Plain { sm { A { go -> B; } B {} } }\n");
    Assert.assertEquals(Arrays.asList(9210, 9210), errorCodes(model));
    Assert.assertEquals(Arrays.asList("Plain"), new ArrayList<String>(model.getGeneratedCode().keySet()));
    String messages = model.getLastResult().toString();
    Assert.assertTrue(messages, messages.contains("Queued state machines") && messages.contains("Pooled state machines"));
  }

  // Python reserves self for the object
  @Test
  public void eventParameterNamedSelfIsReported() throws Exception
  {
    UmpleModel model = generate("class Clash { sm { A { go(Integer self) -> B; } B {} } }\nclass Plain { }\n");
    Assert.assertEquals(Arrays.asList(9214), errorCodes(model));
    Assert.assertEquals(Arrays.asList("Plain"), new ArrayList<String>(model.getGeneratedCode().keySet()));
  }

  @Test
  public void everyFeatureCompiles() throws Exception
  {
    UmpleModel model = generate(MACHINES);
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(model));
    assertCompiles(model);
  }

  // Prepared actions carry Python code in the Python slot only, so the snippet translator
  // never sees them, and are internal, so postpare removes them with the Null states
  @Test
  public void preparedActionsArePythonAndRemovedAfterGeneration() throws Exception
  {
    UmpleModel model = parse(MACHINES);
    UmpleClass uClass = model.getUmpleClass("Machine");
    Set<Action> written = Collections.newSetFromMap(new IdentityHashMap<Action, Boolean>());
    for (StateMachine sm : uClass.getAllStateMachines())
    {
      for (State s : sm.getStates())
      {
        written.addAll(s.getActions());
      }
    }
    PythonNextGenerator gen = new PythonNextGenerator();
    gen.setModel(model);
    gen.prepareStateMachines(uClass);
    int prepared = 0;
    for (StateMachine sm : uClass.getAllStateMachines())
    {
      for (State s : sm.getStates())
      {
        for (Action a : s.getActions())
        {
          if (!written.contains(a))
          {
            prepared++;
            Assert.assertTrue(a.getIsInternal());
            Assert.assertTrue(a.getCodeblock().hasCode("Python"));
            Assert.assertFalse(a.getCodeblock().getCode("Python"), a.getCodeblock().hasCode(""));
          }
        }
      }
    }
    Assert.assertTrue(prepared > 10);

    gen.postpareStateMachines();
    gen.postpare();
    for (StateMachine sm : uClass.getAllStateMachines())
    {
      for (State s : sm.getStates())
      {
        Assert.assertFalse(s.getName(), s.getIsInternal());
        for (Action a : s.getActions())
        {
          Assert.assertTrue(written.contains(a));
        }
      }
    }
  }

  // A final state in a concurrent region deletes only when the other regions are final
  @Test
  public void regionFinalStatesCheckTheOtherRegions() throws Exception
  {
    String code = generate(MACHINES).getGeneratedCode().get("Machine");
    assertContains(code, "        if self._regionsBothLeftLeft is __class__.RegionsBothLeftLeft.LeftDone:\n"
      + "            if self._regionsBothRightRight is __class__.RegionsBothRightRight.RightDone:\n"
      + "                self.delete()");
    assertContains(code, "        if self._regionsBothRightRight is __class__.RegionsBothRightRight.RightDone:\n"
      + "            if self._regionsBothLeftLeft is __class__.RegionsBothLeftLeft.LeftDone:\n"
      + "                self.delete()");
    assertContains(code, "        elif self._state is __class__.State.Final:\n            self.delete()");
  }

  // The transitions of a state are tried in model order and the first enabled one is taken
  @Test
  public void transitionsAreFirstMatch() throws Exception
  {
    String code = generate(MACHINES).getGeneratedCode().get("Machine");
    assertContains(code, "        if aStateOn is __class__.StateOn.Done:\n"
      + "            if n > 5:\n"
      + "                self.exitState()\n"
      + "                if self._deleted:\n"
      + "                    return True\n"
      + "                self.setCount(n)\n"
      + "                if self._deleted:\n"
      + "                    return True\n"
      + "                self.setState(__class__.State.Final)\n"
      + "                wasEventProcessed = True\n"
      + "            elif n > 0:\n"
      + "                self.exitStateOn()\n"
      + "                if self._deleted:\n"
      + "                    return True\n"
      + "                self.setStateOn(__class__.StateOn.Idle)\n"
      + "                wasEventProcessed = True\n"
      + "            else:\n");
  }

  @Test
  public void effectFreeGuardsKeepPlainBranches() throws Exception
  {
    for (String guard : Arrays.asList("brightness < 1", "getBrightness() < 1", "n < LIMIT",
      "enabled", "isEnabled()", "peer != null", "getPeer() != null", "peer.getBrightness() < 1",
      "getPeer().getBrightness() < 1", "numberOfFriends() > 0", "hasFriends()", "indexOfFriend(null) >= 0",
      "minimumNumberOfFriends() == 0", "maximumNumberOfFriends() > 0", "isNumberOfFriendsValid()"))
    {
      UmpleModel model = generate("class Peer { Integer brightness = 0; }\nclass Friend {}\n"
        + "class Lamp { Integer brightness = 0; Boolean enabled = true; const Integer LIMIT = 1;\n"
        + "  0..1 -> 0..1 Peer peer; 0..1 -> 0..3 Friend friends;\n"
        + "  sm { A { go(Integer n) [" + guard + "] -> B; go(Integer n) [n > 0] -> C; go(Integer n) -> D; } B {} C {} D {} } }\n");
      Assert.assertEquals(guard + model.getLastResult(), Collections.emptyList(), errorCodes(model));
      String code = model.getGeneratedCode().get("Lamp");
      assertContains(code, "            elif n > 0:\n");
      assertContains(code, "            else:\n");
      // no check inside the transitions; the event's own check that the object is not deleted stays
      Assert.assertFalse(code, code.contains("guard =") || code.contains("visit =")
        || code.contains("_smVisit") || code.contains("            if self._deleted:"));
      assertCompiles(model);
    }
  }

  @Test
  public void accessorGuardBodiesKeepChecks() throws Exception
  {
    for (String[] example : Arrays.asList(
      new String[] {"Boolean enabled = true; before getEnabled Python { self.delete() }", "enabled"},
      new String[] {"Boolean enabled = true; after getEnabled Python { self.delete() }", "getEnabled()"},
      new String[] {"Boolean enabled = true; before isEnabled Python { self.delete() }", "isEnabled()"},
      new String[] {"Boolean enabled = { ready() } Boolean ready() Python { self.delete(); return True }", "enabled"},
      new String[] {"Boolean enabled = { ready() } Boolean ready() Python { self.delete(); return True }", "getEnabled()"},
      new String[] {"Boolean enabled = { ready() } Boolean ready() Python { self.delete(); return True }", "isEnabled()"},
      new String[] {"Integer[] values; before getValues Python { self.delete() }", "values != null"},
      new String[] {"Integer[] values; after numberOfValues { delete(); }", "numberOfValues() == 0"},
      new String[] {"0..1 -> 0..1 Peer peer; after getPeer Python { self.delete() }", "peer == null"},
      new String[] {"0..1 -> * Peer peers; before getPeers Python { self.delete() }", "peers != null"},
      new String[] {"0..1 -> * Peer peers; before numberOfPeers Python { self.delete() }", "numberOfPeers() == 0"},
      new String[] {"* -- 1..3 Peer peers; after numberOfPeers Python { self.delete() }", "isNumberOfPeersValid()"},
      new String[] {"isA Base;", "enabled"},
      new String[] {"isA PlainBase; after getEnabled Python { self.delete() }", "enabled"},
      new String[] {"0..1 -> 0..1 Base peer;", "peer.getEnabled()"},
      new String[] {"0..1 -> 0..1 Base peer;", "getPeer().getEnabled()"},
      new String[] {"", "candidate.getEnabled()"},
      new String[] {"Boolean enabled = true; before get* Python { self.delete() }", "getEnabled()"}))
    {
      UmpleModel model = generate("class Peer {} class PlainBase { Boolean enabled = true; }\n"
        + "class Base { Boolean enabled = true; before getEnabled Python { self.delete() } }\n"
        + "class Lamp { " + example[0] + "\n"
        + "sm { A { go(Base candidate) [" + example[1] + "] -> B; } B {} } }\n");
      Assert.assertEquals(Arrays.toString(example), Collections.emptyList(), errorCodes(model));
      String code = model.getGeneratedCode().get("Lamp");
      assertContains(code, "            guard = ");
      assertContains(code, "            if self._deleted:\n");
      assertContains(code, "            if self._smVisit != visit:\n");
      assertCompiles(model);
    }
  }

  @Test
  public void injectionsOutsideTheEmittedQueryKeepPlainBranches() throws Exception
  {
    for (String[] example : Arrays.asList(
      new String[] {"Boolean enabled = true; before getEnabled Java { delete(); }", "enabled"},
      new String[] {"Boolean enabled = true; before setEnabled Python { self.delete() }", "enabled"},
      new String[] {"Boolean enabled = true; before getEnabled Python { self.delete() }", "isEnabled()"},
      new String[] {"Boolean enabled = { true }", "enabled"}))
    {
      String parameters = example[0].contains("{ true }") ? "Boolean enabled" : "Integer n";
      UmpleModel model = generate("class Peer {} class Lamp { " + example[0]
        + "\n sm { A { go(" + parameters + ") [" + example[1] + "] -> B; go(" + parameters + ") [false] -> C; go(" + parameters + ") -> D; } B {} C {} D {} } }\n");
      Assert.assertEquals(Arrays.toString(example), Collections.emptyList(), errorCodes(model));
      String code = model.getGeneratedCode().get("Lamp");
      assertContains(code, "            elif False:\n");
      Assert.assertFalse(code, code.contains("guard =") || code.contains("_smVisit") || code.contains("            if self._deleted:"));
      assertCompiles(model);
    }
  }

  @Test
  public void eventGuardCallsKeepVisitChecks() throws Exception
  {
    for (String guard : Arrays.asList("leave()", "!leave()", "this.leave()"))
    {
      UmpleModel model = generate("class Lamp { sm { A { go [" + guard + "] -> B; go -> B; leave -> C; } B {} C {} } }\n");
      Assert.assertEquals(guard, Collections.emptyList(), errorCodes(model));
      String code = model.getGeneratedCode().get("Lamp");
      assertContains(code, "        visit = self._smVisit\n");
      assertContains(code, "                if self._smVisit != visit:\n");
      assertCompiles(model);
    }
  }

  @Test
  public void hundredCheckedAlternativesCompileAtFixedDepth() throws Exception
  {
    StringBuilder source = new StringBuilder("class ManyGuards { Boolean ready(Integer n) Python { return n == 99 }\n sm { A {\n");
    for (int i = 0; i < 100; i++)
    {
      source.append("go [ready(" + i + ")] -> B;\n");
    }
    source.append("go -> C; } B {} C {} } }\n");
    UmpleModel model = generate(source.toString());
    Assert.assertEquals(Collections.emptyList(), errorCodes(model));
    assertCompiles(model);
    String code = model.getGeneratedCode().get("ManyGuards");
    for (String line : code.split("\n"))
    {
      Assert.assertTrue(line, line.length() - line.replaceFirst("^ +", "").length() <= 20);
    }
  }

  @Test
  public void authoredGuardCallsKeepChecksThroughReceivers() throws Exception
  {
    for (String guard : Arrays.asList("ready()", "getBrightness() < 1", "peer.ready()", "getPeer().ready()",
      "candidate.ready()", "getPeer().getBrightness() < 1", "!candidate.ready()", "hasPeer(candidate.ready())"))
    {
      UmpleModel model = generate("class Base { Boolean ready() { return true; } Integer getBrightness() { return 0; } }\n"
        + "class Peer { isA Base; }\n"
        + "class Lamp { isA Base; 0..1 -> 0..1 Peer peer; Boolean hasPeer(Boolean value) { return value; }\n"
        + "  sm { A { go(Peer candidate) [" + guard + "] -> B; } B {} } }\n");
      Assert.assertEquals(guard, Collections.emptyList(), errorCodes(model));
      String code = model.getGeneratedCode().get("Lamp");
      assertContains(code, "        visit = self._smVisit\n");
      assertContains(code, "            if self._deleted:\n                return True\n"
        + "            if self._smVisit != visit:\n                return wasEventProcessed\n"
        + "            if guard:\n");
      assertContains(code, "    def setSm(self, aSm):\n        self._sm = aSm\n        self._smVisit += 1\n\n");
      assertCompiles(model);
    }
  }

  @Test
  public void stateDependentGuardCallsKeepChecks() throws Exception
  {
    UmpleModel model = generate("class Lamp { sm { A { Boolean ready() { return true; } go [ready()] -> B; } B {} } }\n");
    Assert.assertEquals(Collections.emptyList(), errorCodes(model));
    String code = model.getGeneratedCode().get("Lamp");
    assertContains(code, "            guard = self.ready()\n");
    assertContains(code, "            if self._smVisit != visit:\n");
    assertCompiles(model);
  }

  // Generator-owned fields and locals avoid the model's names
  @Test
  public void helperNamesAvoidModelNames() throws Exception
  {
    String code = generate(
      "class Clash { Integer deleted; Integer timeoutAToBHandler;\n" +
      "  sm { A { after(1) -> B; go(Integer wasEventProcessed, Integer aSm) / Python { pass } -> B; } B {} } }\n")
      .getGeneratedCode().get("Clash");
    assertContains(code, "        self._deleted2 = False\n");
    assertContains(code, "        self._timeoutAToBHandler2 = None\n");
    assertContains(code, "    def go(self, wasEventProcessed, aSm):\n        if self._deleted2:\n            return False\n"
      + "        wasEventProcessed2 = False\n        aSm2 = self._sm\n");
  }

  // Issue 923: an event that implements an interface method is that method; no stub replaces it
  @Test
  public void eventsImplementInterfaceMethods() throws Exception
  {
    UmpleModel model = generate("interface Switch { boolean flip(); }\nclass Lamp { isA Switch; sm { On { flip -> Off; } Off { flip -> On; } } }\n");
    String code = model.getGeneratedCode().get("Lamp");
    Assert.assertEquals(code, code.indexOf("    def flip("), code.lastIndexOf("    def flip("));
    assertCompiles(model);
  }

  // The model changes preparation makes for Java's names and for Issue 923 are undone afterwards, so
  // generators that run later see the model as parsed
  @Test
  public void preparationChangesAreUndone() throws Exception
  {
    UmpleModel model = parse("interface Switch { boolean flip(); }\nclass Lamp { isA Switch; Power { On { flip -> Off; } Off { flip -> On; } } }\n");
    UmpleClass lamp = model.getUmpleClass("Lamp");
    List<Method> methods = new ArrayList<Method>(lamp.getMethods());
    PythonNextGenerator gen = new PythonNextGenerator();
    gen.setModel(model);
    gen.prepareStateMachines(lamp);
    Assert.assertEquals("power", lamp.getStateMachine(0).getName());
    Assert.assertEquals(methods.size() - 1, lamp.numberOfMethods());
    gen.postpareStateMachines();
    Assert.assertEquals("Power", lamp.getStateMachine(0).getName());
    Assert.assertEquals(methods, lamp.getMethods());
  }

  // Events become methods and states enum members, and their parameters are checked like method ones
  @Test
  public void stateMachineNamesPythonCannotRepresentAreReported() throws Exception
  {
    Assert.assertEquals(Arrays.asList(9215, 9215), errorCodes(generate("class Car { sm { Idle { break -> Stopped; } Stopped { return -> Idle; } } }\n")));
    Assert.assertEquals(Arrays.asList(9215, 9215), errorCodes(generate("class Flag { sm { None { go -> True; } True { go -> None; } } }\n")));
    Assert.assertEquals(Arrays.asList(9216), errorCodes(generate("class Names { sm { A { go(Integer in, Integer input) -> B; } B {} } }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Cell { sm { A { go(Integer __class__) -> B; } B {} } }\n")));
    Assert.assertEquals(Arrays.asList(9216), errorCodes(generate(
      "class Dependent { sm { A { Integer value(Integer in, Integer input) Python { return 1 } } } }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate("class Keyword { sm { A { Integer async() Python { return 1 } } } }\n")));
    Assert.assertEquals(Arrays.asList(9215), errorCodes(generate(
      "class Outer { inner class Keyword { sm { A { Integer break() Python { return 1 } } } } }\n")));
  }

  // Java's timer actions are internal like every other prepared action, so a Python run after Java
  // in the same model does not see them as untagged user code
  @Test
  public void javaTimerActionsDoNotReachALaterPythonRun() throws Exception
  {
    UmpleModel model = run("generate Java;\ngenerate PythonNext;\n" +
      "class Lamp { status { On { after(2) -> Off; flip -> Off; } Off { flip -> On; } } }\n");
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(model));
    Assert.assertTrue(new File(dir, "Lamp.java").exists());
    Assert.assertEquals(Arrays.asList("Lamp"), new ArrayList<String>(model.getGeneratedCode().keySet()));
    assertCompiles(model);
  }

  // Each run prepares the model again, since postpare undid the previous run's preparation
  @Test
  public void aSecondPythonRunInOneModelGeneratesTheSameCode() throws Exception
  {
    UmpleModel model = run("generate PythonNext \"first\";\ngenerate PythonNext \"second\";\n" + MACHINES);
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(model));
    String first = new String(Files.readAllBytes(new File(dir, "first/Machine.py").toPath()), "UTF-8");
    String second = new String(Files.readAllBytes(new File(dir, "second/Machine.py").toPath()), "UTF-8");
    assertContains(first, "Null = \"Null\"");
    Assert.assertEquals(first, second);
  }

  private void assertContains(String code, String part)
  {
    Assert.assertTrue(code, code.contains(part));
  }

  private UmpleModel parse(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), code.getBytes("UTF-8"));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(false);
    model.run();
    return model;
  }

  private UmpleModel generate(String code) throws Exception
  {
    return run("generate PythonNext;\n" + code);
  }

  private UmpleModel run(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), code.getBytes("UTF-8"));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(true);
    try
    {
      model.run();
    }
    catch (UmpleCompilerException e)
    {
      // errors are in the model's last result, which the tests check
    }
    return model;
  }

  private static List<Integer> errorCodes(UmpleModel model)
  {
    List<Integer> codes = new ArrayList<Integer>();
    for (cruise.umple.parser.ErrorMessage message : model.getLastResult().getErrorMessages())
    {
      if (message.getErrorType().getSeverity() <= 2)
      {
        codes.add(message.getErrorType().getErrorCode());
      }
    }
    return codes;
  }

  private void assertCompiles(UmpleModel model) throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    List<File> files = new ArrayList<File>();
    for (String name : model.getGeneratedCode().keySet())
    {
      files.add(new File(dir, name + ".py"));
    }
    String errors = CodeCompiler.checkPythonSyntax(files);
    Assert.assertNull(errors, errors);
  }
}
