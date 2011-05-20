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
    return temp.parse(ruleName,codeToParse);
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