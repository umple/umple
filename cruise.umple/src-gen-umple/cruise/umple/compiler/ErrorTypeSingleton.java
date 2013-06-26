/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;
import java.io.*;
import java.util.*;

/**
 * Lists all the errors in the system
 * @umplesource Parser.ump 84
 * @umplesource Parser_Code.ump 1725
 */
// line 84 "../../../../src/Parser.ump"
// line 1725 "../../../../src/Parser_Code.ump"
public class ErrorTypeSingleton
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={1727},file={"Parser_Code.ump"},javaline={44},length={1})
  private ErrorTypeSingleton()
  {
    errorTypes = new ArrayList<ErrorType>();
    // line 1727 "../../../../src/Parser_Code.ump"
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

  public boolean addErrorTypeAt(ErrorType aErrorType, int index)
  {  
    boolean wasAdded = false;
    if(addErrorType(aErrorType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfErrorTypes()) { index = numberOfErrorTypes() - 1; }
      errorTypes.remove(aErrorType);
      errorTypes.add(index, aErrorType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveErrorTypeAt(ErrorType aErrorType, int index)
  {
    boolean wasAdded = false;
    if(errorTypes.contains(aErrorType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfErrorTypes()) { index = numberOfErrorTypes() - 1; }
      errorTypes.remove(aErrorType);
      errorTypes.add(index, aErrorType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addErrorTypeAt(aErrorType, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    errorTypes.clear();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={1728},file={"Parser_Code.ump"},javaline={156},length={110})
  @umplesourcefile(line={1729},file={"Parser_Code.ump"},javaline={157},length={6})
  private void init()
  {
    String filename = "/en.error";
    String input = readFile(filename);
    parse(new TextParser(filename, input));
  }

  @umplesourcefile(line={1736},file={"Parser_Code.ump"},javaline={165},length={31})
  public String readFile(String filenameOrResourcePath)
  {
    InputStream resourceStream = null;
    BufferedReader reader = null;
    String str = "";
    try
    {
      if ((new File(filenameOrResourcePath)).exists())
      {
        reader = new BufferedReader(new FileReader(filenameOrResourcePath));
      }
      else
      {
        resourceStream = getClass().getResourceAsStream(filenameOrResourcePath);
        reader = new BufferedReader(new InputStreamReader(resourceStream));
      }
      String line;
      while((line=reader.readLine())!=null)
        if(!line.startsWith("#")) str += line;
    }
    catch (Exception e)
    {
      str = null;
    }
    finally
    {
      SampleFileWriter.closeAsRequired(reader);
      SampleFileWriter.closeAsRequired(resourceStream);
    }    
    return str;
  }

  // Parse the error messages file (en.error etc.)
  @umplesourcefile(line={1769},file={"Parser_Code.ump"},javaline={199},length={49})
  private boolean parse(TextParser textParser)
  { 
    while(textParser.peek() != null)
    {
      Position p = textParser.currentPosition();

      String code = textParser.nextUntil(false,":");
      textParser.nextAfter(false,":");

      String severity = textParser.nextUntil(false, ",");
      textParser.nextAfter(false,",");

      String url = textParser.nextUntil(false, ",");
      textParser.nextAfter(false,",");

      String formatString = textParser.nextUntil(false, ";");
      textParser.nextAfter(false,";");

      int codeInt;
      int severityInt;

      if(code == null || severity == null || url == null || formatString == null)
        throw new UmpleCompilerException("Error parsing error definitions (line " + p.getLineNumber()+")",null);

      try
      {
        codeInt = Integer.parseInt(code);
      }
      catch(NumberFormatException e)
      {
        throw new UmpleCompilerException("Error code must be an integer (line " + p.getLineNumber()+")",null);
      }

      try
      {
        severityInt = Integer.parseInt(severity);
      }
      catch(NumberFormatException e)
      {
        throw new UmpleCompilerException("Severity must be an integer between [1,5] (line " + p.getLineNumber()+")",null);
      }

      if(severityInt < 1 || severityInt > 5)
        throw new UmpleCompilerException("Severity must be an integer between [1,5] (line " + p.getLineNumber()+")",null);

      this.errorTypes.add(new ErrorType(codeInt, severityInt, formatString, url));
    }
    return true;
  }

  @umplesourcefile(line={1819},file={"Parser_Code.ump"},javaline={250},length={4})
  public void clear()
  {
    this.errorTypes = new ArrayList<ErrorType>();
  }

  @umplesourcefile(line={1824},file={"Parser_Code.ump"},javaline={256},length={5})
  public void reset()
  {
    clear();
    init();
  }

  @umplesourcefile(line={1830},file={"Parser_Code.ump"},javaline={263},length={8})
  public ErrorType getErrorTypeForCode(int code)
  {
    for(ErrorType et : this.errorTypes)
      if(et.getErrorCode() == code)
        return et;

    return new ErrorType(-1, 0, "Unknown Umple Error #" + code + " : {0}", "");
  }

}