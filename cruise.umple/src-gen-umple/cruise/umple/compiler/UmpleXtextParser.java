/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource UmpleXtextParser.ump 16
 * @umplesource UmpleXtextParser_Code.ump 13
 */
// line 16 "../../../../src/UmpleXtextParser.ump"
// line 13 "../../../../src/UmpleXtextParser_Code.ump"
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

  @umplesourcefile(line={18},file={"UmpleXtextParser_Code.ump"},javaline={62},length={3})
   public String toGrammar(){
    return temp.toGrammar();
  }

  @umplesourcefile(line={23},file={"UmpleXtextParser_Code.ump"},javaline={67},length={19})
   public ParseResult parse(String ruleName, String codeToParse){
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

  @umplesourcefile(line={45},file={"UmpleXtextParser_Code.ump"},javaline={88},length={3})
   public ParseResult analyze(boolean shouldGenerateCode){
    return temp.analyze(shouldGenerateCode);
  }

  @umplesourcefile(line={50},file={"UmpleXtextParser_Code.ump"},javaline={93},length={3})
   public Token getRootToken(){
    return temp.getRootToken();
  }

  @umplesourcefile(line={55},file={"UmpleXtextParser_Code.ump"},javaline={98},length={3})
   public UmpleModel getModel(){
    return temp.getModel();
  }

  @umplesourcefile(line={60},file={"UmpleXtextParser_Code.ump"},javaline={103},length={3})
   public boolean setModel(UmpleModel model){
    return temp.setModel(model);
  }

  @umplesourcefile(line={65},file={"UmpleXtextParser_Code.ump"},javaline={108},length={3})
   public ParseResult getParseResult(){
    return temp.getParseResult();
  }

  @umplesourcefile(line={70},file={"UmpleXtextParser_Code.ump"},javaline={113},length={3})
   public boolean setFilename(String filename){
    return temp.setFilename(filename);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "temp" + "=" + (getTemp() != null ? !getTemp().equals(this)  ? getTemp().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}