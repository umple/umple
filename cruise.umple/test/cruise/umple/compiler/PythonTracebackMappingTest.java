/*

Copyright: All contributers to the Umple Project

This file is made available subject to the open source license found at:
https://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

// The compiler (CodeCompiler.mapPythonTraceback) and UmpleOnline (python_traceback.php) map Python
// errors back to the model with the same rule; both are checked against one fixture so they cannot drift.
// Python/Quoted.py is generated from a model whose method bodies have string literals holding lines
// that look like markers, which must not be taken for markers.
public class PythonTracebackMappingTest
{
  private File fixture;

  @Before
  public void setUp()
  {
    fixture = new File(SampleFileWriter.rationalize("test/cruise/umple/compiler/pythonTraceback"));
  }

  @Test
  public void mapsOnlyFramesInsideModelCode() throws Exception
  {
    Assert.assertEquals(read("expected.txt"), mapWithCompiler(read("traceback.txt")));
  }

  @Test
  public void keepsWindowsLineEndings() throws Exception
  {
    Assert.assertEquals(crlf(read("expected.txt")), mapWithCompiler(crlf(read("traceback.txt"))));
  }

  @Test
  public void onlineMapperAgreesWithCompiler() throws Exception
  {
    String online = mapOnline(read("traceback.txt"));
    Assume.assumeTrue("php not found", online != null);
    Assert.assertEquals(read("expected.txt"), online);
    Assert.assertEquals(crlf(read("expected.txt")), mapOnline(crlf(read("traceback.txt"))));
  }

  private String mapWithCompiler(String traceback) throws Exception
  {
    return CodeCompiler.mapPythonTraceback(traceback, new String[] { "/input/", fixture.getCanonicalPath() + File.separator });
  }

  // Runs UmpleOnline's PHP mapper on the traceback, or returns null when php is not installed.
  private String mapOnline(String traceback) throws Exception
  {
    File script = new File(SampleFileWriter.rationalize("../umpleonline/scripts/python_traceback.php"));
    File input = File.createTempFile("python-traceback-in", ".txt");
    File output = File.createTempFile("python-traceback-out", ".txt");
    Process php = null;
    try
    {
      Files.write(input.toPath(), traceback.getBytes("UTF-8"));
      String code = "require '" + script.getCanonicalPath() + "';"
        + " echo mapPythonTraceback(file_get_contents('" + input.getCanonicalPath() + "'), getcwd());";
      try
      {
        php = new ProcessBuilder("php", "-r", code).directory(fixture).redirectErrorStream(true)
          .redirectOutput(output).start();
      }
      catch (java.io.IOException e)
      {
        return null;
      }
      Assert.assertTrue("php did not finish", php.waitFor(60, TimeUnit.SECONDS));
      Assert.assertEquals(0, php.exitValue());
      return new String(Files.readAllBytes(output.toPath()), "UTF-8");
    }
    finally
    {
      if (php != null && php.isAlive())
      {
        php.destroyForcibly();
      }
      input.delete();
      output.delete();
    }
  }

  private static String crlf(String text)
  {
    return text.replace("\n", "\r\n");
  }

  private String read(String name) throws Exception
  {
    String text = new String(Files.readAllBytes(new File(fixture, name).toPath()), "UTF-8").replace("\r\n", "\n");
    return text.endsWith("\n") ? text.substring(0, text.length() - 1) : text;
  }
}
