/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * To be done. A group of trace directives that can be switched on or off by other
 * trace directives
 * @umplesource Trace.ump 146
 */
// line 146 "../../../../src/Trace.ump"
public class TraceCase
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceCase Attributes
  private String name;

  //TraceCase Associations
  private List<TraceDirective> traceDirectives;
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceCase()
  {
    name = null;
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

  public String getName()
  {
    return name;
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

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
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
    if (aTraceDirective.indexOfTraceCase(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceDirective.addTraceCase(this);
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
    if (aTraceDirective.indexOfTraceCase(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceDirective.removeTraceCase(this);
      if (!wasRemoved)
      {
        traceDirectives.add(oldIndex,aTraceDirective);
      }
    }
    return wasRemoved;
  }

  public boolean addTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {  
    boolean wasAdded = false;
    if(addTraceDirective(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {
    boolean wasAdded = false;
    if(traceDirectives.contains(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceDirectiveAt(aTraceDirective, index);
    }
    return wasAdded;
  }

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeTraceCase(this);
    }
    if (aUmpleClass != null)
    {
      aUmpleClass.addTraceCase(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<TraceDirective> copyOfTraceDirectives = new ArrayList<TraceDirective>(traceDirectives);
    traceDirectives.clear();
    for(TraceDirective aTraceDirective : copyOfTraceDirectives)
    {
      aTraceDirective.removeTraceCase(this);
    }
    if (umpleClass != null)
    {
      UmpleClass placeholderUmpleClass = umpleClass;
      this.umpleClass = null;
      placeholderUmpleClass.removeTraceCase(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass" + "=" + getUmpleClass() != null ? !getUmpleClass() .equals(this)  ? getUmpleClass().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}