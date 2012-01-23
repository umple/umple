/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Attribute_TraceItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attribute_TraceItem Attributes
  private boolean traceSet;
  private boolean traceGet;
  private int forClause;
  private String periodClause;
  private String duringClause;
  private String executeClause;

  //Attribute_TraceItem Associations
  private List<Attribute> attributes;
  private TraceDirective traceDirective;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Attribute_TraceItem(TraceDirective aTraceDirective)
  {
    traceSet = true;
    traceGet = false;
    forClause = 0;
    periodClause = null;
    duringClause = null;
    executeClause = null;
    attributes = new ArrayList<Attribute>();
    boolean didAddTraceDirective = setTraceDirective(aTraceDirective);
    if (!didAddTraceDirective)
    {
      throw new RuntimeException("Unable to create attributeTraceItem due to traceDirective");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTraceSet(boolean aTraceSet)
  {
    boolean wasSet = false;
    traceSet = aTraceSet;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceGet(boolean aTraceGet)
  {
    boolean wasSet = false;
    traceGet = aTraceGet;
    wasSet = true;
    return wasSet;
  }

  public boolean setForClause(int aForClause)
  {
    boolean wasSet = false;
    forClause = aForClause;
    wasSet = true;
    return wasSet;
  }

  public boolean setPeriodClause(String aPeriodClause)
  {
    boolean wasSet = false;
    periodClause = aPeriodClause;
    wasSet = true;
    return wasSet;
  }

  public boolean setDuringClause(String aDuringClause)
  {
    boolean wasSet = false;
    duringClause = aDuringClause;
    wasSet = true;
    return wasSet;
  }

  public boolean setExecuteClause(String aExecuteClause)
  {
    boolean wasSet = false;
    executeClause = aExecuteClause;
    wasSet = true;
    return wasSet;
  }

  public boolean getTraceSet()
  {
    return traceSet;
  }

  public boolean getTraceGet()
  {
    return traceGet;
  }

  public int getForClause()
  {
    return forClause;
  }

  public String getPeriodClause()
  {
    return periodClause;
  }

  public String getDuringClause()
  {
    return duringClause;
  }

  public String getExecuteClause()
  {
    return executeClause;
  }

  public Attribute getAttribute(int index)
  {
    Attribute aAttribute = attributes.get(index);
    return aAttribute;
  }

  public List<Attribute> getAttributes()
  {
    List<Attribute> newAttributes = Collections.unmodifiableList(attributes);
    return newAttributes;
  }

  public int numberOfAttributes()
  {
    int number = attributes.size();
    return number;
  }

  public boolean hasAttributes()
  {
    boolean has = attributes.size() > 0;
    return has;
  }

  public int indexOfAttribute(Attribute aAttribute)
  {
    int index = attributes.indexOf(aAttribute);
    return index;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
  }

  public static int minimumNumberOfAttributes()
  {
    return 0;
  }

  public boolean addAttribute(Attribute aAttribute)
  {
    boolean wasAdded = false;
    if (attributes.contains(aAttribute)) { return false; }
    attributes.add(aAttribute);
    if (aAttribute.indexOfAttributeTraceItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttribute.addAttributeTraceItem(this);
      if (!wasAdded)
      {
        attributes.remove(aAttribute);
      }
    }
    return wasAdded;
  }

  public boolean removeAttribute(Attribute aAttribute)
  {
    boolean wasRemoved = false;
    if (!attributes.contains(aAttribute))
    {
      return wasRemoved;
    }

    int oldIndex = attributes.indexOf(aAttribute);
    attributes.remove(oldIndex);
    if (aAttribute.indexOfAttributeTraceItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttribute.removeAttributeTraceItem(this);
      if (!wasRemoved)
      {
        attributes.add(oldIndex,aAttribute);
      }
    }
    return wasRemoved;
  }

  public boolean setTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasSet = false;
    if (aTraceDirective == null)
    {
      return wasSet;
    }

    TraceDirective existingTraceDirective = traceDirective;
    traceDirective = aTraceDirective;
    if (existingTraceDirective != null && !existingTraceDirective.equals(aTraceDirective))
    {
      existingTraceDirective.removeAttributeTraceItem(this);
    }
    traceDirective.addAttributeTraceItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Attribute> copyOfAttributes = new ArrayList<Attribute>(attributes);
    attributes.clear();
    for(Attribute aAttribute : copyOfAttributes)
    {
      aAttribute.removeAttributeTraceItem(this);
    }
    TraceDirective placeholderTraceDirective = traceDirective;
    this.traceDirective = null;
    placeholderTraceDirective.removeAttributeTraceItem(this);
  }

}