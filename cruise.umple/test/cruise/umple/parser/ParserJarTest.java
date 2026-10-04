/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.parser;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

// Uses the packaged umpleparser jar the way a program outside Umple would, so a class or
// resource missing from the jar fails here instead of in users' hands
public class ParserJarTest
{
  private static File jar;
  private static String pathToInput;

  @BeforeClass
  public static void findJar()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/parser");
    // The Ant and Gradle builds name the jar they packaged; a test run without a packaged jar skips
    String path = System.getProperty("umpleparser.jar");
    Assume.assumeTrue("umpleparser jar has not been built", path != null && new File(path).isFile());
    jar = new File(path);
  }

  @Test
  public void containsOnlyTheParser() throws Exception
  {
    try (JarFile jarFile = new JarFile(jar))
    {
      Assert.assertNull(jarFile.getManifest().getMainAttributes().getValue("Class-Path"));
      for (JarEntry entry : Collections.list(jarFile.entries()))
      {
        Assert.assertFalse(entry.getName(), entry.getName().contains("Test"));
      }
    }
  }

  @Test
  public void parsesValidText() throws Exception
  {
    Parse parse = new Parse("greetings.txt");
    Assert.assertNull(parse.failedPosition);
    Assert.assertEquals("[ROOT:][greetings][greeting][name:Alice][greeting][name:Bob]", parse.rootToken);
  }

  @Test
  public void reportsWhereInvalidTextFails() throws Exception
  {
    Parse parse = new Parse("badGreetings.txt");
    Assert.assertEquals("[2,0]", parse.failedPosition);
    Assert.assertEquals("[ROOT:]", parse.rootToken);
  }

  @Test
  public void explainsAMissingFile() throws Exception
  {
    Parse parse = new Parse("missing.txt");
    Assert.assertTrue(parse.errors, parse.errors.contains("Warning 1510"));
  }

  // One parse in its own class loader, with no parent: the parser keeps static state, and
  // everything it needs must come from the jar
  private static class Parse
  {
    String rootToken;
    String failedPosition;
    String errors;

    Parse(String inputFile) throws Exception
    {
      try (URLClassLoader loader = new URLClassLoader(new URL[] { jar.toURI().toURL() }, null))
      {
        Class<?> parserClass = loader.loadClass("cruise.umple.parser.analysis.RuleBasedParser");
        Object parser = parserClass.getConstructor().newInstance();
        parserClass.getMethod("addGrammarFile", String.class).invoke(parser, pathToInput + "/greetings.grammar");
        Object result = parserClass.getMethod("parse", File.class).invoke(parser, new File(pathToInput + "/" + inputFile));
        errors = String.valueOf(result.getClass().getMethod("getErrorMessages").invoke(result));
        rootToken = String.valueOf(parserClass.getMethod("getRootToken").invoke(parser));
        Object analyzer = parserClass.getMethod("getAnalyzer").invoke(null);
        Object position = analyzer.getClass().getMethod("getFailedPosition").invoke(analyzer);
        failedPosition = position == null ? null : position.toString();
      }
    }
  }
}
