/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.parser;

import java.io.File;
import java.lang.reflect.Method;
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
    Parse parse = new Parse("greetings.grammar", "greetings.txt");
    Assert.assertTrue(parse.wasSuccess);
    Assert.assertNull(parse.failedPosition);
    Assert.assertEquals("[ROOT:][greetings][greeting][name:Alice][greeting][name:Bob]", parse.rootToken);
  }

  @Test
  public void reportsWhereInvalidTextFails() throws Exception
  {
    Parse parse = new Parse("greetings.grammar", "badGreetings.txt");
    Assert.assertEquals("[2,0]", parse.failedPosition);
    Assert.assertEquals("[ROOT:]", parse.rootToken);
  }

  @Test
  public void reportsInvalidTextInTheResult() throws Exception
  {
    skipPreviousParserOfOneStageBuild();
    Parse parse = new Parse("greetings.grammar", "badGreetings.txt");
    Assert.assertFalse(parse.wasSuccess);
    Assert.assertEquals("Error 1500 on line 2 of file 'badGreetings.txt':\nParsing error: 'bye Bob;' not understood\n", parse.errors);
  }

  @Test
  public void reportsAMissingGrammarFile() throws Exception
  {
    skipPreviousParserOfOneStageBuild();
    Parse parse = new Parse("missing.grammar", "greetings.txt");
    Assert.assertFalse(parse.wasSuccess);
    Assert.assertEquals("Warning 1510 on line 1 of file 'missing.grammar':\nFile 'missing.grammar' referred to in use statement was not found\n"
      + "Error 1500 on line 1 of file 'greetings.txt':\nParsing error: 'hello Alice;' not understood\n", parse.errors);
  }

  @Test
  public void explainsAMissingFile() throws Exception
  {
    Parse parse = new Parse("greetings.grammar", "missing.txt");
    Assert.assertTrue(parse.errors, parse.errors.contains("Warning 1510"));
  }

  // A one-stage build, such as Gradle's, generates the parser from the parser source inside its
  // bootstrap umple.jar, so the jar it packages lacks the failure reporting, and the unparsedText
  // method that came with it, until that umple.jar has them. Only a build that says it is one-stage
  // may skip these checks; the two-stage Ant build packages the parser of this source and must pass.
  private static void skipPreviousParserOfOneStageBuild() throws Exception
  {
    if (!Boolean.getBoolean("umpleparser.oneStageBuild"))
    {
      return;
    }
    boolean fromThisSource = false;
    try (URLClassLoader loader = jarLoader())
    {
      for (Method method : loader.loadClass("cruise.umple.parser.analysis.RuleBasedParser").getDeclaredMethods())
      {
        fromThisSource |= method.getName().equals("unparsedText");
      }
    }
    Assume.assumeTrue("the packaged parser was generated from the older parser source in the bootstrap umple.jar;"
      + " a second build, with the umple.jar the first one made, packages the current parser", fromThisSource);
  }

  private static URLClassLoader jarLoader() throws Exception
  {
    return new URLClassLoader(new URL[] { jar.toURI().toURL() }, null);
  }

  // One parse in its own class loader, with no parent: the parser keeps static state, and
  // everything it needs must come from the jar
  private static class Parse
  {
    boolean wasSuccess;
    String rootToken;
    String failedPosition;
    String errors;

    Parse(String grammarFile, String inputFile) throws Exception
    {
      try (URLClassLoader loader = jarLoader())
      {
        Class<?> parserClass = loader.loadClass("cruise.umple.parser.analysis.RuleBasedParser");
        Object parser = parserClass.getConstructor().newInstance();
        // Platform separators, which the parser expects when it names a file in a message
        parserClass.getMethod("addGrammarFile", String.class).invoke(parser, new File(pathToInput, grammarFile).getPath());
        Object result = parserClass.getMethod("parse", File.class).invoke(parser, new File(pathToInput, inputFile));
        wasSuccess = (Boolean) result.getClass().getMethod("getWasSuccess").invoke(result);
        errors = result.toString();
        rootToken = String.valueOf(parserClass.getMethod("getRootToken").invoke(parser));
        Object analyzer = parserClass.getMethod("getAnalyzer").invoke(null);
        Object position = analyzer.getClass().getMethod("getFailedPosition").invoke(analyzer);
        failedPosition = position == null ? null : position.toString();
      }
    }
  }
}
