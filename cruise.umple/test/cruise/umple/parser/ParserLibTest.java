/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.parser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.tools.ToolProvider;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.util.SampleFileWriter;

// Builds the example of UmpleParser/README.md the way its users do: Umple puts the parser into
// the program for 'use lib:UmpleParser.ump;', javac compiles it, and it runs with nothing else
// on its classpath, not even Umple's en.error. The parser comes from the .ump files of this
// build, so these tests see a parser change at once; the parser inside Umple only gets it from
// the next umple.jar.
public class ParserLibTest
{
  private static String pathToInput;
  private static File programDirectory;
  private static File classes;

  @BeforeClass
  public static void buildProgram() throws Exception
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/parser");
    programDirectory = Files.createTempDirectory("ParserLibTest").toFile();
    File program = new File(programDirectory, "Greetings.ump");
    Files.copy(new File(pathToInput, "Greetings.ump").toPath(), program.toPath());

    UmpleModel model = new UmpleModel(new UmpleFile(program));
    model.setShouldGenerate(true);
    try
    {
      model.run();
    }
    catch (UmpleCompilerException e)
    {
      // The parser's own Java code draws warnings; an error fails here
      Assert.assertTrue(e.getMessage(), model.getLastResult().getWasSuccess());
    }

    classes = new File(programDirectory, "classes");
    List<String> javacArguments = new ArrayList<String>(Arrays.asList("-nowarn", "-d", classes.getPath()));
    try (Stream<Path> files = Files.walk(programDirectory.toPath()))
    {
      javacArguments.addAll(files.map(Path::toString).filter(name -> name.endsWith(".java")).collect(Collectors.toList()));
    }
    ByteArrayOutputStream javacErrors = new ByteArrayOutputStream();
    int status = ToolProvider.getSystemJavaCompiler().run(null, null, javacErrors, javacArguments.toArray(new String[0]));
    Assert.assertEquals(javacErrors.toString(), 0, status);
  }

  @AfterClass
  public static void removeProgram()
  {
    SampleFileWriter.destroy(programDirectory.getPath());
  }

  @Test
  public void keepsTheProgramInItsOwnNamespace()
  {
    Assert.assertTrue(new File(programDirectory, "Greetings.java").isFile());
    Assert.assertTrue(new File(programDirectory, "cruise/umple/parser/analysis/RuleBasedParser.java").isFile());
  }

  @Test
  public void printsTheTokens() throws Exception
  {
    Assert.assertEquals("[ROOT:][greetings][greeting][name:Alice][greeting][name:Bob]\n",
      run(fixture("greetings.grammar"), fixture("greetings.txt")));
  }

  @Test
  public void parsesBlankTextAsEmptyText() throws Exception
  {
    File blank = new File(programDirectory, "blank.txt");
    Files.write(blank.toPath(), "\n  \n\t\n".getBytes());
    Assert.assertEquals("[ROOT:][greetings]\n", run(fixture("greetings.grammar"), blank.getPath()));
  }

  @Test
  public void reportsTextTheGrammarCannotParse() throws Exception
  {
    Assert.assertEquals("Error 1500 on line 2 of file 'badGreetings.txt':\nParsing error: 'bye Bob;' not understood\n",
      run(fixture("greetings.grammar"), fixture("badGreetings.txt")));
  }

  @Test
  public void reportsAMissingTextFile() throws Exception
  {
    // As for a use statement in Umple, a missing file is a warning, and the parse goes on without it
    Assert.assertEquals("Warning 1510 on line 1 of file 'missing.txt':\nFile 'missing.txt' referred to in use statement was not found\n"
      + "[ROOT:][greetings]\n",
      run(fixture("greetings.grammar"), fixture("missing.txt")));
  }

  @Test
  public void reportsAMissingGrammarFile() throws Exception
  {
    Assert.assertEquals("Warning 1510 on line 1 of file 'missing.grammar':\nFile 'missing.grammar' referred to in use statement was not found\n"
      + "Error 1500 on line 1 of file 'greetings.txt':\nParsing error: 'hello Alice;' not understood\n",
      run(fixture("missing.grammar"), fixture("greetings.txt")));
  }

  @Test
  public void definesTheParserMessagesAsEnErrorDoes() throws Exception
  {
    ErrorTypeSingleton.getInstance().reset();
    try (URLClassLoader loader = programLoader())
    {
      Class<?> programTypes = loader.loadClass("cruise.umple.parser.ErrorTypeSingleton");
      Object programSingleton = programTypes.getMethod("getInstance").invoke(null);
      for (int code : new int[] { 1500, 1510 })
      {
        ErrorType expected = ErrorTypeSingleton.getInstance().getErrorTypeForCode(code);
        Object actual = programTypes.getMethod("getErrorTypeForCode", int.class).invoke(programSingleton, code);
        Assert.assertEquals(describe(expected), describe(actual));
      }
    }
  }

  // Runs the program in its own class loader with no parent, so that it finds nothing of Umple's
  // and starts with fresh static state in the parser
  private static String run(String grammarFile, String textFile) throws Exception
  {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream console = System.out;
    try (URLClassLoader loader = programLoader())
    {
      System.setOut(new PrintStream(output, true));
      loader.loadClass("Greetings").getMethod("main", String[].class)
        .invoke(null, (Object) new String[] { grammarFile, textFile });
    }
    finally
    {
      System.setOut(console);
    }
    return output.toString().replace(System.lineSeparator(), "\n");
  }

  // With the platform's separators, which the parser expects when it names a file in a message
  private static String fixture(String name)
  {
    return new File(pathToInput, name).getPath();
  }

  private static URLClassLoader programLoader() throws Exception
  {
    return new URLClassLoader(new URL[] { classes.toURI().toURL() }, null);
  }

  private static String describe(Object errorType) throws Exception
  {
    String description = "";
    for (String property : new String[] { "getErrorCode", "getSeverity", "getErrorUrl", "getErrorFormat" })
    {
      description += errorType.getClass().getMethod(property).invoke(errorType) + "|";
    }
    return description;
  }
}
