/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

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
  private int severity;
  private String errorFormat;
  private String errorType;
  private String errorUrl;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetErrorCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorType(int aErrorCode, int aSeverity, String aErrorFormat, String aErrorType, String aErrorUrl)
  {
    errorCode = aErrorCode;
    severity = aSeverity;
    errorFormat = aErrorFormat;
    errorType = aErrorType;
    errorUrl = aErrorUrl;
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

  public boolean setSeverity(int aSeverity)
  {
    boolean wasSet = false;
    severity = aSeverity;
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

  public boolean setErrorUrl(String aErrorUrl)
  {
    boolean wasSet = false;
    errorUrl = aErrorUrl;
    wasSet = true;
    return wasSet;
  }

  public int getErrorCode()
  {
    return errorCode;
  }

  public int getSeverity()
  {
    return severity;
  }

  public String getErrorFormat()
  {
    return errorFormat;
  }

  public String getErrorType()
  {
    return errorType;
  }

  public String getErrorUrl()
  {
    return errorUrl;
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