/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;
import java.util.List;

/**
 * Represents an error type, which contains an error code, the severity of the error, etc.
 */
public class ErrorType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorType Attributes
  private int errorCode;
  private int severity;
  private String errorFormat;
  private String errorUrl;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetErrorCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorType(int aErrorCode, int aSeverity, String aErrorFormat, String aErrorUrl)
  {
    cachedHashCode = -1;
    canSetErrorCode = true;
    errorCode = aErrorCode;
    severity = aSeverity;
    errorFormat = aErrorFormat;
    errorUrl = aErrorUrl;
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

  public boolean setErrorUrl(String aErrorUrl)
  {
    boolean wasSet = false;
    errorUrl = aErrorUrl;
    wasSet = true;
    return wasSet;
  }

  /**
   * The error code.
   */
  public int getErrorCode()
  {
    return errorCode;
  }

  /**
   * The severity of the error.
   */
  public int getSeverity()
  {
    return severity;
  }

  public String getErrorFormat()
  {
    return errorFormat;
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