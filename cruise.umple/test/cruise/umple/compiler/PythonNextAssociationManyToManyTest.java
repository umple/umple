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

import cruise.umple.util.SampleFileWriter;

// Generator decisions for associations whose two ends are many; their runtime behaviour is tested in
// testbed_pythonnext/test/associations_python.
public class PythonNextAssociationManyToManyTest
{
  private File dir;

  @Before
  public void setUp() throws Exception
  {
    dir = Files.createTempDirectory("umple-python-manymany").toFile();
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy(dir.getPath());
  }

  @Test
  public void deleteImportsTheOtherClassInsideTheMethodButNeverItsOwnClass() throws Exception
  {
    UmpleModel model = generate("namespace jury;\nclass Panel { name; }\nclass Judge { name; }\n" +
      "association { 2..3 Panel panels -- 1..* Judge judges; }\nclass Ring { 2..4 self neighbours; }\n");
    String errors = cruise.umple.implementation.TemplateTest.pythonSyntaxErrors(generatedFiles());
    Assert.assertNull(errors, errors);
    String panel = model.getGeneratedCode().get("Panel");
    Assert.assertTrue(panel, panel.contains("    def delete(self):\n        from jury.Judge import Judge\n"));
    Assert.assertTrue(panel, panel.contains("if aJudge.numberOfPanels() <= Judge.minimumNumberOfPanels():"));
    Assert.assertFalse("no module-level import, so the two modules can import each other", panel.contains("\nfrom "));
    String ring = model.getGeneratedCode().get("Ring");
    Assert.assertTrue(ring, ring.contains("if aNeighbour.numberOfNeighbours() <= __class__.minimumNumberOfNeighbours():"));
    Assert.assertFalse(ring, ring.contains("import"));
  }

  private UmpleModel generate(String code) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), ("generate PythonNext;\n" + code).getBytes("UTF-8"));
    UmpleModel model = new UmpleModel(new UmpleFile(file));
    model.setShouldGenerate(true);
    model.run();
    return model;
  }

  private List<File> generatedFiles() throws Exception
  {
    List<File> files = new ArrayList<File>();
    Files.walk(dir.toPath()).filter(p -> p.toString().endsWith(".py")).forEach(p -> files.add(p.toFile()));
    return files;
  }
}
