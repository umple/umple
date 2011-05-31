/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;

public class UmpleXtextParser implements UmpleParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleXtextParser Attributes
  private UmpleInternalParser temp;
  private cruise.umple.parser.antlr.UmpleParser antlr;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleXtextParser()
  {
    temp = new UmpleInternalParser();
    antlr = new cruise.umple.parser.antlr.UmpleParser();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTemp(UmpleInternalParser aTemp)
  {
    boolean wasSet = false;
    temp = aTemp;
    wasSet = true;
    return wasSet;
  }

  public boolean setAntlr(cruise.umple.parser.antlr.UmpleParser aAntlr)
  {
    boolean wasSet = false;
    antlr = aAntlr;
    wasSet = true;
    return wasSet;
  }

  public UmpleInternalParser getTemp()
  {
    return temp;
  }

  public cruise.umple.parser.antlr.UmpleParser getAntlr()
  {
    return antlr;
  }

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String toGrammar()
  {
    return temp.toGrammar();
  }
  
  public ParseResult parse(String ruleName, String codeToParse)
  {
    ParseResult tempResult = temp.parse(ruleName,codeToParse);
    return tempResult;
//    Reader codeToParseReader = new StringReader(codeToParse);
//    UmpleAntlrTokenFileProvider antlrTokenFileProvider = new UmpleAntlrTokenFileProvider();
//    AntlrTokenDefProvider tokenDefProvider = new AntlrTokenDefProvider();
//    tokenDefProvider.setAntlrTokenFileProvider(antlrTokenFileProvider);
//    Provider<Lexer> provider = (Provider)LexerProvider.create(InternalUmpleLexer.class);
//    Provider<XtextResourceSet> grammarResourceSet = null;
//    GrammarProvider grammarProvider = new GrammarProvider("cruise.umple.Umple",grammarResourceSet);
//    TerminalsGrammarAccess terminalsGrammarAccess = new TerminalsGrammarAccess(grammarProvider);
//    
//    antlr.setElementFactory(new DefaultEcoreElementFactory());
//    antlr.setGrammarAccess(new UmpleGrammarAccess(grammarProvider, terminalsGrammarAccess));
//    antlr.setLexerProvider(provider);
//    antlr.setTokenDefProvider(tokenDefProvider);
//
//    IParseResult iResult = antlr.parse(ruleName, codeToParseReader);
//    boolean wasSuccess = iResult.getParseErrors().size() == 0;
//    ParseResult result = new ParseResult(wasSuccess);
//    return result;   
  }
  
  public ParseResult analyze(boolean shouldGenerateCode)
  {
    return temp.analyze(shouldGenerateCode);  
  }

  public Token getRootToken()
  {
    return temp.getRootToken();
  }
  
  public UmpleModel getModel()
  {
    return temp.getModel();
  }
  
  public boolean setModel(UmpleModel model)
  {
    return temp.setModel(model);
  }
  
  public ParseResult getParseResult()
  {
    return temp.getParseResult();
  }
}