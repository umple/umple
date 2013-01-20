/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.patterns.test;

// line 66 "../../../../src/TestHarnessPatterns.ump"
public class LanguageSpecificCodeBlock
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LanguageSpecificCodeBlock Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LanguageSpecificCodeBlock(String aName)
  {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    // line 69 "../../../../src/TestHarnessPatterns.ump"
    name = "java";
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}

}