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
import java.util.List;

import org.junit.*;

// Checking generated Python must never run it.
public class PythonCompileTest
{
  @Test
  public void syntaxCheckDoesNotRunAModuleNamedPyCompile() throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    File sentinel = new File("py_compile_ran.txt").getAbsoluteFile();
    // Python looks for modules in the working directory first, so this file would shadow the
    // standard py_compile if the check did not isolate itself.
    File shadow = new File("py_compile.py").getAbsoluteFile();
    // Checking writes the compiled module into a __pycache__ beside it, so it goes in a directory of its own
    File dir = Files.createTempDirectory("pythonCheck").toFile();
    File checked = new File(dir, "checked.py");
    try
    {
      Files.write(shadow.toPath(), ("open(r'" + sentinel.getPath() + "', 'w').write('ran')\n").getBytes("UTF-8"));
      Files.write(checked.toPath(), "x = 1\n".getBytes("UTF-8"));

      Assert.assertNull(CodeCompiler.checkPythonSyntax(Arrays.asList(checked)));
      Assert.assertFalse("the shadowing module ran", sentinel.exists());
    }
    finally
    {
      shadow.delete();
      sentinel.delete();
      cruise.umple.util.SampleFileWriter.destroy(dir.getAbsolutePath());
    }
  }

  // Compiling a model (-c) checks the generated modules and runs none of them, not even a main
  @Test
  public void compilingAModelRunsNoneOfItsCode() throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    File dir = Files.createTempDirectory("pythonCompile").toFile();
    File sentinel = new File(dir, "main_ran.txt");
    try
    {
      String main = "class Main { public static void main(String[] args) Python { open(r'" + sentinel.getPath() + "', 'w').write('ran') } }\n";
      Assert.assertTrue(compile(dir, "generate Python \"py\";\n" + main));
      Assert.assertFalse(compile(dir, "generate Python \"py\";\n" + main + "class Broken { void f() Python { x = ( } }\n"));
      Assert.assertTrue(new String(Files.readAllBytes(new File(dir, "errors.txt").toPath()), "UTF-8").contains("SyntaxError"));
      Assert.assertFalse("the model's main ran", sentinel.exists());
    }
    finally
    {
      cruise.umple.util.SampleFileWriter.destroy(dir.getAbsolutePath());
    }
  }

  private static boolean compile(File dir, String model) throws Exception
  {
    File file = new File(dir, "model.ump");
    Files.write(file.toPath(), model.getBytes("UTF-8"));
    UmpleModel generated = new UmpleModel(new UmpleFile(file));
    generated.setShouldGenerate(true);
    generated.run();
    return CodeCompiler.compile(generated, "Python", false, true, "-", new File(dir, "errors.txt").getPath());
  }

  // Many modules are checked in batches that stay under Windows' command-line limit, and errors in
  // the first and the last batch are both reported
  @Test
  public void manyModulesAreCheckedInBatches() throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    File dir = Files.createTempDirectory("pythonBatches").toFile();
    try
    {
      File deep = new File(dir, "a_rather_long_package_name/another_rather_long_package_name/and_one_more_segment");
      deep.mkdirs();
      List<File> files = new ArrayList<File>();
      for (int i = 0; i < 300; i++)
      {
        File module = new File(deep, "GeneratedModuleWithAFairlyLongName" + i + ".py");
        Files.write(module.toPath(), (i == 0 || i == 299 ? "def f(:\n" : "x = 1\n").getBytes("UTF-8"));
        files.add(module);
      }
      String errors = CodeCompiler.checkPythonSyntax(files);
      Assert.assertNotNull(errors);
      Assert.assertTrue(errors, errors.contains("GeneratedModuleWithAFairlyLongName0.py"));
      Assert.assertTrue(errors, errors.contains("GeneratedModuleWithAFairlyLongName299"));
    }
    finally
    {
      cruise.umple.util.SampleFileWriter.destroy(dir.getAbsolutePath());
    }
  }

  @Test
  public void syntaxErrorsAreReported() throws Exception
  {
    cruise.umple.implementation.TemplateTest.assumePython();
    File dir = Files.createTempDirectory("pythonCheck").toFile();
    File checked = new File(dir, "broken.py");
    try
    {
      Files.write(checked.toPath(), "def f(:\n".getBytes("UTF-8"));
      String errors = CodeCompiler.checkPythonSyntax(Arrays.asList(checked));
      Assert.assertNotNull(errors);
      Assert.assertTrue(errors, errors.contains("SyntaxError"));
    }
    finally
    {
      cruise.umple.util.SampleFileWriter.destroy(dir.getAbsolutePath());
    }
  }
}
