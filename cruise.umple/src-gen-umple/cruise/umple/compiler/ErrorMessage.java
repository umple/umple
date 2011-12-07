/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;
import java.util.*;

public class ErrorMessage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorMessage Attributes
  private List<String> parameters;

  //ErrorMessage Associations
  private ErrorType errorType;
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorMessage(ErrorType aErrorType, Position aPosition)
  {
    parameters = new ArrayList<String>();
    if (!setErrorType(aErrorType))
    {
      throw new RuntimeException("Unable to create ErrorMessage due to aErrorType");
    }
    if (!setPosition(aPosition))
    {
      throw new RuntimeException("Unable to create ErrorMessage due to aPosition");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addParameter(String aParameter)
  {
    boolean wasAdded = false;
    wasAdded = parameters.add(aParameter);
    return wasAdded;
  }

  public boolean removeParameter(String aParameter)
  {
    boolean wasRemoved = false;
    wasRemoved = parameters.remove(aParameter);
    return wasRemoved;
  }

  public String getParameter(int index)
  {
    String aParameter = parameters.get(index);
    return aParameter;
  }

  public String[] getParameters()
  {
    String[] newParameters = parameters.toArray(new String[parameters.size()]);
    return newParameters;
  }

  public int numberOfParameters()
  {
    int number = parameters.size();
    return number;
  }

  public boolean hasParameters()
  {
    boolean has = parameters.size() > 0;
    return has;
  }

  public int indexOfParameter(String aParameter)
  {
    int index = parameters.indexOf(aParameter);
    return index;
  }

  public ErrorType getErrorType()
  {
    return errorType;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean setErrorType(ErrorType newErrorType)
  {
    boolean wasSet = false;
    if (newErrorType != null)
    {
      errorType = newErrorType;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setPosition(Position newPosition)
  {
    boolean wasSet = false;
    if (newPosition != null)
    {
      position = newPosition;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    errorType = null;
    position = null;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public ErrorMessage(int errorCode,Position pos,String... parameters)  {
this(ErrorTypeSingleton.getInstance().getErrorTypeForCode(errorCode), pos);
	  this.parameters = Arrays.asList(parameters);
  }
public String getFormattedMessage()
   {
   	   return errorType.format(this.parameters);
   }
   public String toString()
   {
   	   String sev = errorType.getSeverity() <= 2 ? "error" : "warning";
	   String err = errorType.getErrorType() + " " + sev + " on line: " + this.position.getLineNumber();
	   err += " of file \"" + StringFormatter.stripLeadingPath(this.position.getFilename()) + "\":\n";
   	   return  err + errorType.format(this.parameters);
   }
}