/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

public class ErrorType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ErrorType Attributes
  private String errorFormat;
  private int errorCode;
  private int severtiy;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetErrorCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ErrorType(String aErrorFormat, int aErrorCode, int aSevertiy)
  {
    errorFormat = aErrorFormat;
    errorCode = aErrorCode;
    severtiy = aSevertiy;
    cachedHashCode = -1;
    canSetErrorCode = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setErrorFormat(String aErrorFormat)
  {
    boolean wasSet = false;
    errorFormat = aErrorFormat;
    wasSet = true;
    return wasSet;
  }

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

  public String getErrorFormat()
  {
    return errorFormat;
  }

  public int getErrorCode()
  {
    return errorCode;
  }

  public int getSevertiy()
  {
    return severtiy;
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

}