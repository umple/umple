/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;
import java.util.List;

public class ErrorType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorType Attributes
  private int errorCode;
  private int severtiy;
  private String errorFormat;
  private String errorType;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetErrorCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorType(int aErrorCode, int aSevertiy, String aErrorFormat, String aErrorType)
  {
    errorCode = aErrorCode;
    severtiy = aSevertiy;
    errorFormat = aErrorFormat;
    errorType = aErrorType;
    cachedHashCode = -1;
    canSetErrorCode = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setErrorCode(int aErrorCode)
  {
    boolean wasSet = false;
    if (!canSetErrorCode) { return false; }
    errorCode = aErrorCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setSevertiy(int aSevertiy)
  {
    boolean wasSet = false;
    severtiy = aSevertiy;
    wasSet = true;
    return wasSet;
  }

  public boolean setErrorFormat(String aErrorFormat)
  {
    boolean wasSet = false;
    errorFormat = aErrorFormat;
    wasSet = true;
    return wasSet;
  }

  public boolean setErrorType(String aErrorType)
  {
    boolean wasSet = false;
    errorType = aErrorType;
    wasSet = true;
    return wasSet;
  }

  public int getErrorCode()
  {
    return errorCode;
  }

  public int getSevertiy()
  {
    return severtiy;
  }

  public String getErrorFormat()
  {
    return errorFormat;
  }

  public String getErrorType()
  {
    return errorType;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    ErrorType compareTo = (ErrorType)obj;
  
    if (errorCode != compareTo.errorCode)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + errorCode;

    canSetErrorCode = false;
    return cachedHashCode;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String format(List<String> arguments)
   {
      return StringFormatter.format(errorFormat, arguments.toArray());
   }
}