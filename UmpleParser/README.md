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

How To Use
----------

Using the RuleBasedParser is simple:

1. Import the package for the RuleBasedParser
In Umple this is `depend cruise.umple.parser.analysis.RuleBasedParser`. In Java, just `import cruise.umple.parser.analysis.RuleBasedParser`

2. Construct a parser with `RuleBasedParser rbp = new RuleBasedParser()`
3. Read in any necessary grammar files for the parser with `rbp.addGrammarFile("<filepath>");`
The grammar file filepath is relative to the root java package. 
4. *[Optional]* Assign a handler for linking files. To do this, call `rbp.setLikedFileHandler(...)` and pass a class that implements `LinkedFileHandler`
5. *[Optional]* Assign a handler for generating analyzers. To do this, call `rbp.setAnalyzerGenerator(...)` and pass a class that implements `AnalyzerGeneratorHandler`
6. *[Optional]* Create parser actions for specific tokens with `rbp.addParserAction(...)`, passing it the string action name and a class that implements `ParserAction`
7. Create a `File` object of the file to parse (e.g. `File file = new File("somefile");`
8. Parse the file with `rbp.parse( file )`. To retrieve the tokens from the parse, use `rbp.getRootToken()`