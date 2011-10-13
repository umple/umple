/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class ErrorTypeSingleton
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ErrorTypeSingleton theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorTypeSingleton Associations
  private List<ErrorType> errorTypes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ErrorTypeSingleton()
  {
    errorTypes = new ArrayList<ErrorType>();
    init();
  }

  public static ErrorTypeSingleton getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ErrorTypeSingleton();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ErrorType getErrorType(int index)
  {
    ErrorType aErrorType = errorTypes.get(index);
    return aErrorType;
  }

  public List<ErrorType> getErrorTypes()
  {
    List<ErrorType> newErrorTypes = Collections.unmodifiableList(errorTypes);
    return newErrorTypes;
  }

  public int numberOfErrorTypes()
  {
    int number = errorTypes.size();
    return number;
  }

  public boolean hasErrorTypes()
  {
    boolean has = errorTypes.size() > 0;
    return has;
  }

  public int indexOfErrorType(ErrorType aErrorType)
  {
    int index = errorTypes.indexOf(aErrorType);
    return index;
  }

  public static int minimumNumberOfErrorTypes()
  {
    return 0;
  }

  public boolean addErrorType(ErrorType aErrorType)
  {
    boolean wasAdded = false;
    if (errorTypes.contains(aErrorType)) { return false; }
    errorTypes.add(aErrorType);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeErrorType(ErrorType aErrorType)
  {
    boolean wasRemoved = false;
    if (errorTypes.contains(aErrorType))
    {
      errorTypes.remove(aErrorType);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    errorTypes.clear();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void init()
	{
	  // TODO: this function should parse an input file, and populate
	  // errorTypes. BUT, it can't extend the parser class, otherwise
	  // we have a cyclic dependency. (What happens in the case of
	  // a parse error in this class?)
	  this.errorTypes.add(new ErrorType(1003, 0, "test {0} {1}"));
	}
	
	public void clear()
	{
	  this.errorTypes = new ArrayList<ErrorType>();
	}
	
	public ErrorType getErrorTypeForCode(int code)
	{
		for(ErrorType et : this.errorTypes)
			if(et.getErrorCode() == code)
				return et;
		return null;
	}
}