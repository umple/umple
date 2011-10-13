/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class ParseResult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParseResult Attributes
  private boolean wasSuccess;
  private boolean hasWarnings;

  //ParseResult Associations
  private Position position;
  private List<ErrorMessage> errorMessages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParseResult(boolean aWasSuccess)
  {
    wasSuccess = aWasSuccess;
    hasWarnings = false;
    errorMessages = new ArrayList<ErrorMessage>();
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

  public boolean setHasWarnings(boolean aHasWarnings)
  {
    boolean wasSet = false;
    hasWarnings = aHasWarnings;
    wasSet = true;
    return wasSet;
  }

  public boolean getWasSuccess()
  {
    return wasSuccess;
  }

  public boolean getHasWarnings()
  {
    return hasWarnings;
  }

  public boolean isWasSuccess()
  {
    return wasSuccess;
  }

  public boolean isHasWarnings()
  {
    return hasWarnings;
  }

  public Position getPosition()
  {
    return position;
  }

  public ErrorMessage getErrorMessage(int index)
  {
    ErrorMessage aErrorMessage = errorMessages.get(index);
    return aErrorMessage;
  }

  public List<ErrorMessage> getErrorMessages()
  {
    List<ErrorMessage> newErrorMessages = Collections.unmodifiableList(errorMessages);
    return newErrorMessages;
  }

  public int numberOfErrorMessages()
  {
    int number = errorMessages.size();
    return number;
  }

  public boolean hasErrorMessages()
  {
    boolean has = errorMessages.size() > 0;
    return has;
  }

  public int indexOfErrorMessage(ErrorMessage aErrorMessage)
  {
    int index = errorMessages.indexOf(aErrorMessage);
    return index;
  }

  public boolean setPosition(Position newPosition)
  {
    boolean wasSet = false;
    position = newPosition;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfErrorMessages()
  {
    return 0;
  }

  public boolean addErrorMessage(ErrorMessage aErrorMessage)
  {
    boolean wasAdded = false;
    if (errorMessages.contains(aErrorMessage)) { return false; }
    errorMessages.add(aErrorMessage);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeErrorMessage(ErrorMessage aErrorMessage)
  {
    boolean wasRemoved = false;
    if (errorMessages.contains(aErrorMessage))
    {
      errorMessages.remove(aErrorMessage);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    position = null;
    errorMessages.clear();
  }

}