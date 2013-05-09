/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

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
  private int startTime;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private StringTracer()
  {
    traces = new ArrayList<String>();
    startTime = (int)System.currentTimeMillis();
    handle("Time,Thread,UmpleFile,LineNumber,Class,Object,Operation,Name,Value");
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

  public boolean setStartTime(int aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
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

  public int getStartTime()
  {
    return startTime;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "startTime" + ":" + getStartTime()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static void handle(String message) { getInstance().addTrace(message); }
public void reset() { getInstance().traces.clear(); }
static{getInstance();}
}