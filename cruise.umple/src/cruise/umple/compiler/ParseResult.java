/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.umple.compiler;

public class ParseResult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParseResult Attributes
  private boolean wasSuccess;

  //ParseResult Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParseResult(boolean aWasSuccess)
  {
    wasSuccess = aWasSuccess;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWasSuccess(boolean aWasSuccess)
  {
    boolean wasSet = false;
    wasSuccess = aWasSuccess;
    wasSet = true;
    return wasSet;
  }

  public boolean getWasSuccess()
  {
    return wasSuccess;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean setPosition(Position newPosition)
  {
    boolean wasSet = false;
    position = newPosition;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    position = null;
  }

}