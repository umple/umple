/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;

// Generation of associations whose one end is at most one and whose other end is many; their
// runtime behaviour is tested in testbed_pythonnext/test/associations.
public class PythonNextOneManyAssociationsTest
{
  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-onemany").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  @Test
  public void everyMultiplicityCompiles() throws Exception
  {
    UmpleModel model = generate(
      "namespace om;\n" +
      "class Hub {\n" +
      "  1 h1 -- * P1 p1s;\n  1 h2 -- 1..* P2 p2s;\n  1 h3 -- 2..3 P3 p3s;\n  1 h4 -- 0..3 P4 p4s;\n" +
      "  0..1 h5 -- * P5 p5s;\n  0..1 h6 -- 0..3 P6 p6s;\n  0..1 h7 -- 2..5 P7 p7s;\n  0..1 h8 -- 2..* P8 p8s;\n" +
      "  0..1 h9 -- 3 P9 p9s;\n}\n" +
      "class P1 { }\nclass P2 { }\nclass P3 { }\nclass P4 { }\nclass P5 { }\nclass P6 { }\nclass P7 { }\nclass P8 { }\nclass P9 { }\n" +
      "class W1 { 1 w1 <@>- * Q1 q1s; }\nclass Q1 { }\n" +
      "class W2 { * w2s <@>- 0..1 Q2 q2; }\nclass Q2 { }\n" +
      "class W3 { 0..1 w3 <@>- 2..4 Q3 q3s; }\nclass Q3 { }\n" +
      "class Show { }\nclass Viewer { }\nassociationClass Ticket { * Show; * Viewer; }\n" +
      "class Academy { 1 academy -- * Pupil pupils sorted {id}; }\nclass Pupil { Integer id; }\n");
    Assert.assertEquals(new ArrayList<Integer>(), errorCodes(model));
    String errors = cruise.umple.implementation.TemplateTest.pythonSyntaxErrors(generatedFiles());
    Assert.assertNull(errors, errors);

    String hub = model.getGeneratedCode().get("Hub");
    Assert.assertTrue(hub, hub.contains("    def setP9s(self, *newP9s):"));
    Assert.assertTrue(hub, hub.contains("            aP9._h9 = self\n"));
    Assert.assertTrue(hub, hub.contains("                del existingH7._p7s[index]\n"));
    Assert.assertTrue(model.getGeneratedCode().get("P2"), model.getGeneratedCode().get("P2").contains("    def setH2(self, aH2):"));

    String show = model.getGeneratedCode().get("Show");
    Assert.assertTrue(show, show.contains("        if any(x == aTicket for x in self._tickets):\n            return False\n"));
    Assert.assertTrue(hub, hub.contains("        if any(x is aP1 for x in self._p1s):\n            return False\n"));

    String academy = model.getGeneratedCode().get("Academy");
    Assert.assertTrue(academy, academy.contains("        self._pupils.sort(key=lambda x: x.getId())\n        return True"));
  }

  @Test
  public void factoryTakesTheOtherConstructorParameters() throws Exception
  {
    UmpleModel model = generate(
      "class Tutor { }\nclass Lesson { }\n" +
      "class Pupil { name; * pupils -- 1 Tutor tutor; * -> 1..* Lesson lessons; }\n");
    String tutor = model.getGeneratedCode().get("Tutor");
    Assert.assertTrue(tutor, tutor.contains("    def addPupil1(self, aName, *allLessons):\n        from Pupil import Pupil\n" +
      "        return Pupil(aName, self, *allLessons)\n"));
    Assert.assertTrue(tutor, tutor.contains("    def addPupil2(self, aPupil):"));
    Assert.assertTrue(tutor, tutor.contains("    def addPupil(self, *args, **kwargs):"));
    Assert.assertTrue(tutor, tutor.contains("            return __class__.addPupil1(self, *bound[:-1], *bound[-1])\n"));
    Assert.assertTrue(tutor, tutor.contains("            return __class__.addPupil2(self, *bound)\n"));
  }

  // As in Java, an add's before injection comes first, ahead of its duplicate check, and its after
  // injection follows a success
  @Test
  public void addInjectionsPrecedeTheGuardsAndFollowSuccess() throws Exception
  {
    UmpleModel model = generate("class Coach { 0..1 coach -- * Kid kids;\n" +
      "  before addKid Python { print(\"b\") }\n  after addKid Python { print(\"a\") } }\n" +
      "class Kid { before setCoach Python { print(\"s\") } }\n");
    String coach = model.getGeneratedCode().get("Coach");
    Assert.assertTrue(coach, coach.contains("    def addKid(self, aKid):\n        # line 3 \"model.ump\"\n        print(\"b\")\n        # end line\n"
      + "        if any(x is aKid for x in self._kids):\n            return False\n"));
    Assert.assertTrue(coach, coach.contains("            self._kids.append(aKid)\n        # line 4 \"model.ump\"\n        print(\"a\")\n"
      + "        # end line\n        return True\n"));
    Assert.assertTrue(model.getGeneratedCode().get("Kid"), model.getGeneratedCode().get("Kid").contains("    def setCoach(self, aCoach):\n        # line 5 \"model.ump\"\n        print(\"s\")\n"));
  }

  @Test
  public void aFactoryParameterDoesNotHideTheClass() throws Exception
  {
    UmpleModel model = generate("class Owner { 1 owner -- * aId children; }\nclass aId { Integer id; }\n");
    String owner = model.getGeneratedCode().get("Owner");
    Assert.assertTrue(owner, owner.contains("    def addChild1(self, aId):\n        from aId import aId as aId_\n" +
      "        return aId_(aId, self)\n"));
  }

  @Test
  public void aBoundedFactoryReturnsNoneWhenFull() throws Exception
  {
    UmpleModel model = generate("class Tutor { 1 tutor -- 0..2 Pupil pupils; }\nclass Pupil { }\n");
    String tutor = model.getGeneratedCode().get("Tutor");
    Assert.assertTrue(tutor, tutor.contains("    def addPupil1(self):\n" +
      "        if self.numberOfPupils() >= self.maximumNumberOfPupils():\n            return None\n"));
  }

  @Test
  public void anAbstractClassGetsNoFactory() throws Exception
  {
    UmpleModel model = generate("class Board { 1 board -- * Shape shapes; }\nclass Shape { abstract; }\n");
    String board = model.getGeneratedCode().get("Board");
    Assert.assertTrue(board, board.contains("    def addShape(self, aShape):"));
    Assert.assertFalse(board, board.contains("addShape1"));
  }

  @Test
  public void keyMembersAreGuardedFirst() throws Exception
  {
    UmpleModel model = generate("class Bus { }\nclass Seat { Integer n; * seats -- 1 Bus bus; key { bus, n }; }\n" +
      "class Team { Integer id; 0..1 team -- * Player players; key { id, players }; }\nclass Player { }\n");
    String seat = model.getGeneratedCode().get("Seat");
    Assert.assertTrue(seat, seat.contains("    def setBus(self, aBus):\n        if not self._canSetBus:\n            return False\n"));
    String team = model.getGeneratedCode().get("Team");
    Assert.assertTrue(team, team.contains("    def addPlayer(self, aPlayer):\n        if not self._canSetPlayers:\n            return False\n" +
      "        if any(x is aPlayer for x in self._players):\n"));
    Assert.assertTrue(team, team.contains("    def removePlayer(self, aPlayer):\n        if not self._canSetPlayers:\n"));
  }

  private UmpleModel generate(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), ("generate PythonNext;\n" + code).getBytes("UTF-8"));
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

  private List<File> generatedFiles() throws Exception
  {
    List<File> files = new ArrayList<File>();
    Files.walk(dir.toPath()).filter(p -> p.toString().endsWith(".py")).forEach(p -> files.add(p.toFile()));
    return files;
  }
}
