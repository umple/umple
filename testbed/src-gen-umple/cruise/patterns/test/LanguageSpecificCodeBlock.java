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

  //LanguageSpecificCodeBlock State Machines
  enum State { allLanguages, to }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LanguageSpecificCodeBlock(String aName)
  {
    name = aName;
    setState(State.allLanguages);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 70 "../../../../src/TestHarnessPatterns.ump"
    String lang = "My lang is ";
    name = aName;
    wasSet = true;
    // line 71 "../../../../src/TestHarnessPatterns.ump"
    name = lang + "java";
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getLanguageImplementedIn()
  {
    return "Java";
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean applySpecificAction()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case allLanguages:
        if (isJava())
        {
        // line 78 "../../../../src/TestHarnessPatterns.ump"
          name = "action=java";
          setState(State.to);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;
  }

  public void delete()
  {}

  // line 72 "../../../../src/TestHarnessPatterns.ump"
  public boolean isJava(){
    return true;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "languageImplementedIn" + ":" + getLanguageImplementedIn()+ "]"
     + outputString;
  }
}