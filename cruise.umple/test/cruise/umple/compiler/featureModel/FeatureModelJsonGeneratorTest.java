package cruise.umple.compiler.featureModel;

import org.junit.*;
import cruise.umple.UmpleConsoleMain;
import cruise.umple.util.SampleFileWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FeatureModelJsonGeneratorTest
{
  @Test
  public void generateWithRequireStatement()
  {
    String[] args = {"-generate", "FeatureModelJson", "FmJsonGenTest.ump"};
    SampleFileWriter.createFile("FmJsonGenTest.ump", "require [A and B or C];");
    try
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("FmJsonGenTest_FeatureModelJson.json");
      String content = new String(Files.readAllBytes(Paths.get("FmJsonGenTest_FeatureModelJson.json")));
      Assert.assertTrue("JSON must contain featureModel key", content.contains("\"featureModel\""));
      Assert.assertTrue("JSON must contain nodes array", content.contains("\"nodes\""));
      Assert.assertTrue("JSON must contain links array", content.contains("\"links\""));
    }
    catch (Exception e)
    {
      Assert.fail("Generator threw exception: " + e.getMessage());
    }
    finally
    {
      SampleFileWriter.destroy("FmJsonGenTest_FeatureModelJson.json");
      SampleFileWriter.destroy("FmJsonGenTest.ump");
    }
  }

  @Test
  public void generateWithNoFeatureModel()
  {
    String[] args = {"-generate", "FeatureModelJson", "FmJsonGenEmptyTest.ump"};
    SampleFileWriter.createFile("FmJsonGenEmptyTest.ump", "class Foo { name; }");
    try
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("FmJsonGenEmptyTest_FeatureModelJson.json");
      String content = new String(Files.readAllBytes(Paths.get("FmJsonGenEmptyTest_FeatureModelJson.json")));
      Assert.assertTrue("Null model must output featureModel:null", content.contains("\"featureModel\":null"));
    }
    catch (Exception e)
    {
      Assert.fail("Generator threw exception: " + e.getMessage());
    }
    finally
    {
      SampleFileWriter.destroy("FmJsonGenEmptyTest_FeatureModelJson.json");
      SampleFileWriter.destroy("FmJsonGenEmptyTest.ump");
    }
  }

  @Test
  public void generateWithMixsetFeature()
  {
    String[] args = {"-generate", "FeatureModelJson", "FmJsonGenMixsetTest.ump"};
    SampleFileWriter.createFile("FmJsonGenMixsetTest.ump",
      "mixset Security {\n  isFeature;\n  require subfeature [Encryption and Auth];\n}\nuse Security;\nuse Encryption;\nuse Auth;\n");
    try
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("FmJsonGenMixsetTest_FeatureModelJson.json");
      String content = new String(Files.readAllBytes(Paths.get("FmJsonGenMixsetTest_FeatureModelJson.json")));
      Assert.assertTrue("JSON must contain Security node", content.contains("\"Security\""));
      Assert.assertTrue("JSON must contain Encryption node", content.contains("\"Encryption\""));
      Assert.assertTrue("JSON must contain Auth node", content.contains("\"Auth\""));
      Assert.assertTrue("JSON must contain Conjunctive op", content.contains("\"Conjunctive\""));
    }
    catch (Exception e)
    {
      Assert.fail("Generator threw exception: " + e.getMessage());
    }
    finally
    {
      SampleFileWriter.destroy("FmJsonGenMixsetTest_FeatureModelJson.json");
      SampleFileWriter.destroy("FmJsonGenMixsetTest.ump");
    }
  }
}
