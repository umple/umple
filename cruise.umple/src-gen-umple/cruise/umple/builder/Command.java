/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.builder;
import java.util.regex.*;
import java.lang.reflect.*;
import java.util.*;

public class Command
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Command Attributes
  private List<String> history;
  private List<String> messages;
  private Object currentObject;
  private ClassLoader loader;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Command(ClassLoader aLoader)
  {
    history = new ArrayList<String>();
    messages = new ArrayList<String>();
    currentObject = null;
    loader = aLoader;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addHistory(String aHistory)
  {
    boolean wasAdded = false;
    wasAdded = history.add(aHistory);
    return wasAdded;
  }

  public boolean removeHistory(String aHistory)
  {
    boolean wasRemoved = false;
    wasRemoved = history.remove(aHistory);
    return wasRemoved;
  }

  public boolean addMessage(String aMessage)
  {
    boolean wasAdded = false;
    wasAdded = messages.add(aMessage);
    return wasAdded;
  }

  public boolean removeMessage(String aMessage)
  {
    boolean wasRemoved = false;
    wasRemoved = messages.remove(aMessage);
    return wasRemoved;
  }

  public boolean setCurrentObject(Object aCurrentObject)
  {
    boolean wasSet = false;
    currentObject = aCurrentObject;
    wasSet = true;
    return wasSet;
  }

  public boolean setLoader(ClassLoader aLoader)
  {
    boolean wasSet = false;
    loader = aLoader;
    wasSet = true;
    return wasSet;
  }

  public String getHistory(int index)
  {
    String aHistory = history.get(index);
    return aHistory;
  }

  public String[] getHistory()
  {
    String[] newHistory = history.toArray(new String[history.size()]);
    return newHistory;
  }

  public int numberOfHistory()
  {
    int number = history.size();
    return number;
  }

  public boolean hasHistory()
  {
    boolean has = history.size() > 0;
    return has;
  }

  public int indexOfHistory(String aHistory)
  {
    int index = history.indexOf(aHistory);
    return index;
  }

  public String getMessage(int index)
  {
    String aMessage = messages.get(index);
    return aMessage;
  }

  public String[] getMessages()
  {
    String[] newMessages = messages.toArray(new String[messages.size()]);
    return newMessages;
  }

  public int numberOfMessages()
  {
    int number = messages.size();
    return number;
  }

  public boolean hasMessages()
  {
    boolean has = messages.size() > 0;
    return has;
  }

  public int indexOfMessage(String aMessage)
  {
    int index = messages.indexOf(aMessage);
    return index;
  }

  public Object getCurrentObject()
  {
    return currentObject;
  }

  public ClassLoader getLoader()
  {
    return loader;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String[] popMessages()
  {
    String[] local = getMessages();
    messages = new ArrayList<String>();
    return local;
  }

  public Object exec(String input)
  {
    addHistory(input);
    
    Matcher newObjectMatch = Pattern.compile("new ([^\\s]*)").matcher(input);
    Matcher showMatch = Pattern.compile("show ([^\\s]*)").matcher(input);
    if (newObjectMatch.matches())
    {
      return newObject(newObjectMatch.group(1));
    }
    else if (showMatch.matches())
    {
      return showResults(showMatch.group(1));
    }
    else
    {
      runMethod(input);
      return null;
    }
    
  }

  public Object newObject(String className)
  {
    currentObject = null;
    try 
    {
      Class classDefinition = Class.forName(className,true,loader);
      currentObject = classDefinition.newInstance();
    }
    catch (Throwable e) {
    }
    
    if (currentObject != null)
    {
      addMessage("Created " + className);
    }
    else
    {
      addMessage("Unable to create " + className);
    }
    
    return currentObject;
  }
  
  public void runMethod(String methodName)
  {
    callMethod(methodName,false);
  }
  
  public Object showResults(String methodName)
  {
    return callMethod(methodName,true);
  }
  
  private Object callMethod(String methodName, boolean showValue)
  {
    try 
    {
      Class c = currentObject.getClass();
      Method m = c.getMethod(methodName);
      Object answer = m.invoke(currentObject);
      
      if (showValue && answer == null)
      {
        addMessage(methodName + " = [NULL]");
      }
      else if (showValue)
      {
        addMessage(methodName + " = " + answer.toString());  
      }
      else
      {
        addMessage("Executed #" + methodName);  
      }
      return answer;
    }
    catch (Throwable e) {
      addMessage("Unable to execute #" + methodName);  
      return null;
    }
  }
}