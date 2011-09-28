/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class MethodTraceEntity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodTraceEntity Attributes
  private String name;
  private boolean entry;
  private boolean exit;

  //MethodTraceEntity Associations
  private List<TraceDirective> traceDirectives;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodTraceEntity()
  {
    name = null;
    entry = false;
    exit = false;
    traceDirectives = new ArrayList<TraceDirective>();
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

  public boolean setEntry(boolean aEntry)
  {
    boolean wasSet = false;
    entry = aEntry;
    wasSet = true;
    return wasSet;
  }

  public boolean setExit(boolean aExit)
  {
    boolean wasSet = false;
    exit = aExit;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public boolean getEntry()
  {
    return entry;
  }

  public boolean getExit()
  {
    return exit;
  }

  public TraceDirective getTraceDirective(int index)
  {
    TraceDirective aTraceDirective = traceDirectives.get(index);
    return aTraceDirective;
  }

  public List<TraceDirective> getTraceDirectives()
  {
    List<TraceDirective> newTraceDirectives = Collections.unmodifiableList(traceDirectives);
    return newTraceDirectives;
  }

  public int numberOfTraceDirectives()
  {
    int number = traceDirectives.size();
    return number;
  }

  public boolean hasTraceDirectives()
  {
    boolean has = traceDirectives.size() > 0;
    return has;
  }

  public int indexOfTraceDirective(TraceDirective aTraceDirective)
  {
    int index = traceDirectives.indexOf(aTraceDirective);
    return index;
  }

  public static int minimumNumberOfTraceDirectives()
  {
    return 0;
  }

  public boolean addTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasAdded = false;
    if (traceDirectives.contains(aTraceDirective)) { return false; }
    traceDirectives.add(aTraceDirective);
    if (aTraceDirective.indexOfMethodTraceEntity(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceDirective.addMethodTraceEntity(this);
      if (!wasAdded)
      {
        traceDirectives.remove(aTraceDirective);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasRemoved = false;
    if (!traceDirectives.contains(aTraceDirective))
    {
      return wasRemoved;
    }

    int oldIndex = traceDirectives.indexOf(aTraceDirective);
    traceDirectives.remove(oldIndex);
    if (aTraceDirective.indexOfMethodTraceEntity(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceDirective.removeMethodTraceEntity(this);
      if (!wasRemoved)
      {
        traceDirectives.add(oldIndex,aTraceDirective);
      }
    }
    return wasRemoved;
  }

  public void delete()
  {
    ArrayList<TraceDirective> copyOfTraceDirectives = new ArrayList<TraceDirective>(traceDirectives);
    traceDirectives.clear();
    for(TraceDirective aTraceDirective : copyOfTraceDirectives)
    {
      aTraceDirective.removeMethodTraceEntity(this);
    }
  }

}