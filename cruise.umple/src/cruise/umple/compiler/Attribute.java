/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Attribute extends UmpleVariable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attribute Attributes
  private boolean isAutounique;
  private boolean isList;
  private boolean isDerived;
  private boolean isLazy;

  //Attribute Associations
  private List<TraceDirective> traceDirectives;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Attribute(String aName, String aType, String aModifier, String aValue, boolean aIsAutounique)
  {
    super(aName, aType, aModifier, aValue);
    isAutounique = aIsAutounique;
    isList = false;
    isDerived = false;
    isLazy = false;
    traceDirectives = new ArrayList<TraceDirective>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsAutounique(boolean aIsAutounique)
  {
    boolean wasSet = false;
    isAutounique = aIsAutounique;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsList(boolean aIsList)
  {
    boolean wasSet = false;
    isList = aIsList;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDerived(boolean aIsDerived)
  {
    boolean wasSet = false;
    isDerived = aIsDerived;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsLazy(boolean aIsLazy)
  {
    boolean wasSet = false;
    isLazy = aIsLazy;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsAutounique()
  {
    return isAutounique;
  }

  public boolean getIsList()
  {
    return isList;
  }

  public boolean getIsDerived()
  {
    return isDerived;
  }

  public boolean getIsLazy()
  {
    return isLazy;
  }

  public boolean isIsAutounique()
  {
    return isAutounique;
  }

  public boolean isIsList()
  {
    return isList;
  }

  public boolean isIsDerived()
  {
    return isDerived;
  }

  public boolean isIsLazy()
  {
    return isLazy;
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
    if (aTraceDirective.indexOfAttribute(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceDirective.addAttribute(this);
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
    if (aTraceDirective.indexOfAttribute(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceDirective.removeAttribute(this);
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
      aTraceDirective.removeAttribute(this);
    }
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public boolean isConstant()
  {
    return "const".equals(getModifier());
  }  
  
  public boolean isPrimitive()
  {
    return getType() == null || "String".equals(getType()) || "Integer".equals(getType()) || "Double".equals(getType()) || "Boolean".equals(getType()) || "Date".equals(getType()) || "Time".equals(getType());
  }
}