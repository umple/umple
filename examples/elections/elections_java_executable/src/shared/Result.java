/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared;

public class Result
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Result theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Result Attributes
  private String message;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Result()
  {
    message = null;
  }

  public static Result getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Result();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMessage(String aMessage)
  {
    boolean wasSet = false;
    message = aMessage;
    wasSet = true;
    return wasSet;
  }

  public String getMessage()
  {
    return message;
  }

  public void delete()
  {}

}