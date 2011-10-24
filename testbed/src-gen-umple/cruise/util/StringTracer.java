/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.util;
import java.util.*;

public class StringTracer
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static StringTracer theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StringTracer Attributes
  private List<String> traces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private StringTracer()
  {
    traces = new ArrayList<String>();
  }

  public static StringTracer getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new StringTracer();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addTrace(String aTrace)
  {
    boolean wasAdded = false;
    wasAdded = traces.add(aTrace);
    return wasAdded;
  }

  public boolean removeTrace(String aTrace)
  {
    boolean wasRemoved = false;
    wasRemoved = traces.remove(aTrace);
    return wasRemoved;
  }

  public String getTrace(int index)
  {
    String aTrace = traces.get(index);
    return aTrace;
  }

  public String[] getTraces()
  {
    String[] newTraces = traces.toArray(new String[traces.size()]);
    return newTraces;
  }

  public int numberOfTraces()
  {
    int number = traces.size();
    return number;
  }

  public boolean hasTraces()
  {
    boolean has = traces.size() > 0;
    return has;
  }

  public int indexOfTrace(String aTrace)
  {
    int index = traces.indexOf(aTrace);
    return index;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static void execute(String message) { getInstance().addTrace(message); }
public void reset() { getInstance().traces.clear(); }
}