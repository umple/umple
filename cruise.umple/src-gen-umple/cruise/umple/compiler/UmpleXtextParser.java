/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;

public class UmpleXtextParser implements UmpleParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleXtextParser Attributes
  private UmpleInternalParser temp;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleXtextParser()
  {
    temp = new UmpleInternalParser();
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

  /**
   * depend  java.io.*;
   * depend  org.eclipse.xtext.parser.*;
   * depend  org.eclipse.xtext.parser.antlr.*;
   * depend  com.google.inject.*;
   * depend cruise.umple.UmpleStandaloneSetup;
   */
  public UmpleInternalParser getTemp()
  {
    return temp;
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
    	  	  
	  /*Injector injector = new
      UmpleStandaloneSetup().createInjectorAndDoEMFRegistration() ;
	  Reader inputStream = new StringReader(codeToParse);
	  IAntlrParser parser = injector.getInstance(IAntlrParser.class);
      IParseResult parseResult = parser.parse(inputStream);
      if (!parseResult.getParseErrors().isEmpty()) {
          // syntax errors occured - handle them properly
    	  return null;
      }
      else{
    	  boolean wasSuccess = parseResult.getParseErrors().size() == 0;
          ParseResult result = new ParseResult(wasSuccess);
          return result;   
      }*/
      
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