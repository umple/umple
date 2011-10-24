/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.exceptions.UmpleCompilerException;
import cruise.umple.util.SampleFileWriter;
import java.io.*;
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
	  String filename = "/en.error";
      String input = readFile(filename);
      parse(new TextParser(filename, input));
	}
	
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
    	  str += line;
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
    
	private boolean parse(TextParser textParser)
	{ 
		while(textParser.peek() != null)
		{
		   Position p = textParser.currentPosition();
		   
           String code = textParser.nextUntil(false, ":");
           textParser.next();

           String severity = textParser.nextUntil(false, ",");
           textParser.next();

           String type = textParser.nextUntil(false, ",");
           textParser.next();

           String url = textParser.nextUntil(false, ",");
           textParser.next();

           String formatString = textParser.nextUntil(false, ";");
           textParser.next();
           
           int codeInt;
           int severityInt;
           
           if(code == null || severity == null || type == null || url == null || formatString == null)
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
           
           this.errorTypes.add(new ErrorType(codeInt, severityInt, formatString, type));
		}
		return true;
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
				
		return new ErrorType(-1, 1, "Unknown Umple Error #" + code + " : {0}", "UmpleInternal");
	}
}