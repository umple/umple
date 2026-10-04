UmpleParser
===========

Description
-----------

The `RuleBasedParser` is a fast and sophisticated parser that is at the core of Umple. 

It reads in grammar files written in a modified/extended [EBNF](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_Form) syntax and produces rules that can be used to parse files written in the corresponding language. 

Compilation
-----------

Currently, this can only be compiled as part of the main Umple build. This will be changed in the future to be an entirely independently compilable project with a separate ant build target.

The umple source is available in `src/`, and -- once compiled -- the java source is available in `src-gen-umple/`

`umple.jar` carries the Umple source of the parser, so that any Umple program can include it (see below). The build also packages the compiled parser on its own as `umpleparser.jar` (`dist/umpleparser.jar` with Ant, `dist/gradle/libs/umpleparser-<version>.jar` with Gradle), which can be downloaded from https://try.umple.org/scripts/umpleparser.jar. It needs nothing else on the classpath.

Using the parser in an Umple program
------------------------------------

Three lines do the work: `use lib:UmpleParser.ump;` brings the whole parser into the program, `addGrammarFile` reads a grammar, and `parse` parses a file into a tree of tokens. The parser's files declare their own namespaces, so a program that has a namespace declares it after the use statement.

With the grammar `greetings.grammar`

```
greetings : [[greeting]]*
greeting : hello [name] ;
```

this program, `Greetings.ump`,

```
use lib:UmpleParser.ump;

// Prints the tokens of a text file parsed with a grammar: java Greetings <grammar> <text>
class Greetings
{
  depend java.io.File;
  depend cruise.umple.parser.ParseResult;
  depend cruise.umple.parser.analysis.RuleBasedParser;

  public static void main(String[] args)
  {
    RuleBasedParser parser = new RuleBasedParser();
    parser.addGrammarFile(args[0]);
    ParseResult result = parser.parse(new File(args[1]));
    System.out.print(result);
    if (result.getWasSuccess())
    {
      System.out.println(parser.getRootToken());
    }
  }
}
```

built and run with

```
java -jar umple.jar Greetings.ump
javac Greetings.java
java Greetings greetings.grammar greetings.txt
```

prints `[ROOT:][greetings][greeting][name:Alice][greeting][name:Bob]` for a `greetings.txt` with the lines `hello Alice;` and `hello Bob;`. When the second line is `bye Bob;` instead, it prints

```
Error 1500 on line 2 of file 'greetings.txt':
Parsing error: 'bye Bob;' not understood
```

Umple reports warning 1007 about Java code in the parser's own source when it compiles the program; the program is not affected.

What the parse result reports:

* `getWasSuccess()` is false when the grammar cannot parse the text, with error 1500 at the line where parsing stopped (`RuleBasedParser.getAnalyzer().getFailedPosition()` gives the same position).
* A grammar or text file that is not found gives warning 1510, as a missing file in an Umple use statement does, and parsing goes on without it: a missing text file parses as empty text, and without a grammar no text parses.
* `toString()` lists the errors and warnings.

The parser reads its grammar files on the first parse and keeps the rules for the rest of the run, for every `RuleBasedParser`.

Using the parser from Java
--------------------------

The same program in Java,

```java
import java.io.File;
import cruise.umple.parser.ParseResult;
import cruise.umple.parser.analysis.RuleBasedParser;

public class Greetings
{
  public static void main(String[] args)
  {
    RuleBasedParser parser = new RuleBasedParser();
    parser.addGrammarFile(args[0]);
    ParseResult result = parser.parse(new File(args[1]));
    System.out.print(result);
    if (result.getWasSuccess())
    {
      System.out.println(parser.getRootToken());
    }
  }
}
```

compiled and run with

```
javac -cp umpleparser.jar Greetings.java
java -cp umpleparser.jar:. Greetings greetings.grammar greetings.txt
```

prints the same.

Before parsing, a program can also:

* assign a handler for linked files with `parser.setLinkedFileHandler(...)`, passing a class that implements `LinkedFileHandler`;
* assign a handler that generates analyzers with `parser.setAnalyzerGenerator(...)`, passing a class that implements `AnalyzerGeneratorHandler`;
* act on specific tokens with `parser.addParserAction(...)`, passing the token name and a class that implements `ParserAction`.
