/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource UmpleXtextParser.ump 17
 * @umplesource UmpleXtextParser_Code.ump 14
 */
// line 17 "../../../../src/UmpleXtextParser.ump"
// line 14 "../../../../src/UmpleXtextParser_Code.ump"
public class UmpleXtextParser implements UmpleParser
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "temp" + "=" + (getTemp() != null ? !getTemp().equals(this)  ? getTemp().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={15},file={"UmpleXtextParser_Code.ump"},javaline={73},length={57})
  @umplesourcefile(line={16},file={"UmpleXtextParser_Code.ump"},javaline={74},length={4})
  public String toGrammar()
  {
    return temp.toGrammar();
  }
  
  @umplesourcefile(line={21},file={"UmpleXtextParser_Code.ump"},javaline={80},length={19})
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
  
  @umplesourcefile(line={43},file={"UmpleXtextParser_Code.ump"},javaline={103},length={4})
  public ParseResult analyze(boolean shouldGenerateCode)
  {
    return temp.analyze(shouldGenerateCode);  
  }

  @umplesourcefile(line={48},file={"UmpleXtextParser_Code.ump"},javaline={109},length={4})
  public Token getRootToken()
  {
    return temp.getRootToken();
  }
  
  @umplesourcefile(line={53},file={"UmpleXtextParser_Code.ump"},javaline={115},length={4})
  public UmpleModel getModel()
  {
    return temp.getModel();
  }
  
  @umplesourcefile(line={58},file={"UmpleXtextParser_Code.ump"},javaline={121},length={4})
  public boolean setModel(UmpleModel model)
  {
    return temp.setModel(model);
  }
  
  @umplesourcefile(line={63},file={"UmpleXtextParser_Code.ump"},javaline={127},length={4})
  public ParseResult getParseResult()
  {
    return temp.getParseResult();
  }
  
  @umplesourcefile(line={68},file={"UmpleXtextParser_Code.ump"},javaline={133},length={4})
  public boolean setFilename(String filename)
  {
    return temp.setFilename(filename);
  }

}