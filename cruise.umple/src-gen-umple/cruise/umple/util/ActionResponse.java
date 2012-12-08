/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.util;
import java.util.*;

// line 206 "../../../../src/Util_Code.ump"
public class ActionResponse
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String default_success_message_id = "Success!";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ActionResponse Attributes
  private String successMessage;
  private List<ErrorItem> errors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ActionResponse()
  {
    successMessage = default_success_message_id;
    errors = new ArrayList<ErrorItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSuccessMessage(String aSuccessMessage)
  {
    boolean wasSet = false;
    successMessage = aSuccessMessage;
    wasSet = true;
    return wasSet;
  }

  public boolean addError(ErrorItem aError)
  {
    boolean wasAdded = false;
    wasAdded = errors.add(aError);
    return wasAdded;
  }

  public boolean removeError(ErrorItem aError)
  {
    boolean wasRemoved = false;
    wasRemoved = errors.remove(aError);
    return wasRemoved;
  }

  public String getSuccessMessage()
  {
    return successMessage;
  }

  public ErrorItem getError(int index)
  {
    ErrorItem aError = errors.get(index);
    return aError;
  }

  public ErrorItem[] getErrors()
  {
    ErrorItem[] newErrors = errors.toArray(new ErrorItem[errors.size()]);
    return newErrors;
  }

  public int numberOfErrors()
  {
    int number = errors.size();
    return number;
  }

  public boolean hasErrors()
  {
    boolean has = errors.size() > 0;
    return has;
  }

  public int indexOfError(ErrorItem aError)
  {
    int index = errors.indexOf(aError);
    return index;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 213 ../../../../src/Util_Code.ump
  public void merge(ActionResponse other)
  {
    errors.addAll(other.errors);
  }  

  public boolean isError(String errorId)
  {
    for (ErrorItem error : errors)
    {
      if (error.getId().equals(errorId))
      {
        return true;
      }
    }
    return false;
  }
  
  public boolean isError(String errorId, String[] allErrorData)
  {
    for (ErrorItem error : errors)
    {
      if (!error.getId().equals(errorId))
      {
        continue;
      }

      if (error.numberOfParts() != allErrorData.length)
      {
        return false;
      }
    
      for (int i=0; i<error.numberOfParts(); i++)
      {
        if (!error.getPart(i).equals(allErrorData[i]))
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  
  public boolean isValid()
  {
    return numberOfErrors() == 0;
  }
  
  public String getMessage()
  {
    
    if (isValid())
    {
      String messageId = getSuccessMessage();
      return Language.getInstance().lookup(messageId);
    }
    else
    {
      StringBuilder builder = new StringBuilder();
      for (int i=0; i<numberOfErrors(); i++)
      {
        ErrorItem item = getError(i);
        String errorId = item.getId();
        String[] allErrorData = item.getParts();
        if (i > 0)
        {
          builder.append(",\n");
        }
        builder.append(Language.getInstance().lookup(errorId,false,allErrorData));
      }
      return builder.toString();
    }
  }
}