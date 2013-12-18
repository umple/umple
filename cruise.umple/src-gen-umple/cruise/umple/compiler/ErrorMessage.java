/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;
import java.util.*;

/**
 * Represents an error message, typically used with parsing.
 * @umplesource Parser.ump 50
 * @umplesource Parser_Code.ump 1759
 */
// line 50 "../../../../src/Parser.ump"
// line 1759 "../../../../src/Parser_Code.ump"
public class ErrorMessage
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setErrorType(ErrorType aNewErrorType)
  {
    boolean wasSet = false;
    if (aNewErrorType != null)
    {
      errorType = aNewErrorType;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    if (aNewPosition != null)
    {
      position = aNewPosition;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    errorType = null;
    position = null;
  }

  @umplesourcefile(line={1764},file={"Parser_Code.ump"},javaline={136},length={4})
   public  ErrorMessage(int errorCode, Position pos, String... parameters){
    this(ErrorTypeSingleton.getInstance().getErrorTypeForCode(errorCode), pos);
    this.parameters = Arrays.asList(parameters);
  }

  @umplesourcefile(line={1769},file={"Parser_Code.ump"},javaline={142},length={3})
   public String getFormattedMessage(){
    return errorType.format(this.parameters);
  }

  @umplesourcefile(line={1773},file={"Parser_Code.ump"},javaline={147},length={6})
   public String toString(){
    String sev = errorType.getSeverity() <= 2 ? "Error" : "Warning";
    String err = sev + " " + errorType.getErrorCode() + " on line " + this.position.getLineNumber();
    err += " of file \"" + StringFormatter.stripLeadingPath(this.position.getFilename()) + "\":\n";
    return  err + errorType.format(this.parameters);
  }

}