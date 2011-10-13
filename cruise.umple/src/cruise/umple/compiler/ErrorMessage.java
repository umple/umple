/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorMessage(ErrorType aErrorType)
  {
    parameters = new ArrayList<String>();
    if (!setErrorType(aErrorType))
    {
      throw new RuntimeException("Unable to create ErrorMessage due to aErrorType");
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

  public void delete()
  {
    errorType = null;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public ErrorMessage(int errorCode,String... parameters)  {
this(ErrorTypeSingleton.getInstance().getErrorTypeForCode(errorCode));
	   this.parameters = Arrays.asList(parameters);
  }
public String toString()
   {
   	   return errorType.format(this.parameters);
   }
}