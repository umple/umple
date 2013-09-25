/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;
import java.util.*;

/**
 * Represents the results of parsing, such as if it was successful,
 * whether it had warnings, etc.
 * @umplesource Parser.ump 29
 * @umplesource Parser_Code.ump 1688
 */
// line 29 "../../../../src/Parser.ump"
// line 1688 "../../../../src/Parser_Code.ump"
public class ParseResult
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParseResult Attributes
  private boolean wasSuccess;
  private boolean hasWarnings;
  private boolean _acceptsErrors;

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
    _acceptsErrors = true;
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

  /**
   * Specifies whether or not the parsing was successful.
   */
  public boolean getWasSuccess()
  {
    return wasSuccess;
  }

  /**
   * Specifies whether or not the parsing has warnings.
   */
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

  /**
   * The error messages related to parsing.
   */
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

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    position = aNewPosition;
    wasSet = true;
    return wasSet;
  }

  @umplesourcefile(line={1690, 1696},file={"Parser_Code.ump", "Parser_Code.ump"},javaline={150, 156},length={3, 16})
  public static int minimumNumberOfErrorMessages()
  {
    return 0;
  }

  public boolean addErrorMessage(ErrorMessage aErrorMessage)
  {
    boolean wasAdded = false;
    // line 1690 "../../../../src/Parser_Code.ump"
    if(!_acceptsErrors)
          return true; // This should technically return false
    if (errorMessages.contains(aErrorMessage)) { return false; }
    errorMessages.add(aErrorMessage);
    wasAdded = true;
    // line 1696 "../../../../src/Parser_Code.ump"
    // If the severity level is 1 then it's the most severe error
        // And we stop accepting errors (The parser may continue to parse,
        // as but we won't report any further errors, as they may be non-sensical)
        if(aErrorMessage.getErrorType().getSeverity() == 1){
          _acceptsErrors = false;
          wasSuccess = false;
        }
    
        // Otherwise, if the severity is 2, we may have an error, 
        // but we'll continue to compile and generate additional errors/warnings 
        else if(aErrorMessage.getErrorType().getSeverity() == 2)  
          wasSuccess = false;
    
        // Everything else must be a warning.
        else
          hasWarnings = true;
    return wasAdded;
  }

  @umplesourcefile(line={1690, 1696},file={"Parser_Code.ump", "Parser_Code.ump"},javaline={150, 156},length={3, 16})
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

  public boolean addErrorMessageAt(ErrorMessage aErrorMessage, int index)
  {  
    boolean wasAdded = false;
    if(addErrorMessage(aErrorMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfErrorMessages()) { index = numberOfErrorMessages() - 1; }
      errorMessages.remove(aErrorMessage);
      errorMessages.add(index, aErrorMessage);
      wasAdded = true;
    }
    return wasAdded;
  }

  @umplesourcefile(line={1690, 1696},file={"Parser_Code.ump", "Parser_Code.ump"},javaline={150, 156},length={3, 16})
  public boolean addOrMoveErrorMessageAt(ErrorMessage aErrorMessage, int index)
  {
    boolean wasAdded = false;
    if(errorMessages.contains(aErrorMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfErrorMessages()) { index = numberOfErrorMessages() - 1; }
      errorMessages.remove(aErrorMessage);
      errorMessages.add(index, aErrorMessage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addErrorMessageAt(aErrorMessage, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    position = null;
    errorMessages.clear();
  }

  @umplesourcefile(line={1716},file={"Parser_Code.ump"},javaline={225},length={6})
   public String toString(){
    String ret = "";
    for(ErrorMessage em : errorMessages)
      ret += em.toString() + "\n";
    return ret;
  }

  @umplesourcefile(line={1724},file={"Parser_Code.ump"},javaline={233},length={28})
   public String toJSON(){
    String ret = "{ \"results\" : [ ";
    boolean hasOne = false;
    for(ErrorMessage em : errorMessages)
    {
      ErrorType et = em.getErrorType();

      String line     = String.valueOf(em.getPosition().getLineNumber());
      String file     = StringFormatter.sanitizeForJson(em.getPosition().getFilename());
      String message  = StringFormatter.sanitizeForJson(em.getFormattedMessage());
      String severity = String.valueOf(et.getSeverity());
      String code     = String.valueOf(et.getErrorCode());
      String url    = StringFormatter.sanitizeForJson(et.getErrorUrl());

      ret += "{ \"errorCode\" : \"" + code + "\",";
      ret += " \"severity\" : \"" +severity + "\", ";
      ret += "\"url\" : \"" + url + "\", ";
      ret += "\"line\" : \"" + line + "\", ";
      ret += "\"filename\" : \"" + file + "\", ";
      ret += "\"message\" : \"" + message + "\"},";
      hasOne = true;
    }

    if(hasOne)
      ret = ret.substring(0, ret.length()-1);
    ret += "]}";
    return ret;
  }

}