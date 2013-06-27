/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Trace.ump 22
 */
// line 22 "../../../../src/Trace.ump"
public class Tracer
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tracer Attributes
  private String name;
  private List<String> argument;
  private boolean verbosity;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tracer(String aName)
  {
    name = aName;
    argument = new ArrayList<String>();
    verbosity = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean addArgument(String aArgument)
  {
    boolean wasAdded = false;
    wasAdded = argument.add(aArgument);
    return wasAdded;
  }

  public boolean removeArgument(String aArgument)
  {
    boolean wasRemoved = false;
    wasRemoved = argument.remove(aArgument);
    return wasRemoved;
  }

  public boolean setVerbosity(boolean aVerbosity)
  {
    boolean wasSet = false;
    verbosity = aVerbosity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getArgument(int index)
  {
    String aArgument = argument.get(index);
    return aArgument;
  }

  public String[] getArgument()
  {
    String[] newArgument = argument.toArray(new String[argument.size()]);
    return newArgument;
  }

  public int numberOfArgument()
  {
    int number = argument.size();
    return number;
  }

  public boolean hasArgument()
  {
    boolean has = argument.size() > 0;
    return has;
  }

  public int indexOfArgument(String aArgument)
  {
    int index = argument.indexOf(aArgument);
    return index;
  }

  public boolean getVerbosity()
  {
    return verbosity;
  }

  public boolean isVerbosity()
  {
    return verbosity;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "verbosity" + ":" + getVerbosity()+ "]"
     + outputString;
  }
}