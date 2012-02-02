/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

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
  private List<TraceRecord> traceRecords;
  private List<Attribute_TraceItem> attributeTraceItems;

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
    traceRecords = new ArrayList<TraceRecord>();
    attributeTraceItems = new ArrayList<Attribute_TraceItem>();
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

  public TraceRecord getTraceRecord(int index)
  {
    TraceRecord aTraceRecord = traceRecords.get(index);
    return aTraceRecord;
  }

  public List<TraceRecord> getTraceRecords()
  {
    List<TraceRecord> newTraceRecords = Collections.unmodifiableList(traceRecords);
    return newTraceRecords;
  }

  public int numberOfTraceRecords()
  {
    int number = traceRecords.size();
    return number;
  }

  public boolean hasTraceRecords()
  {
    boolean has = traceRecords.size() > 0;
    return has;
  }

  public int indexOfTraceRecord(TraceRecord aTraceRecord)
  {
    int index = traceRecords.indexOf(aTraceRecord);
    return index;
  }

  public Attribute_TraceItem getAttributeTraceItem(int index)
  {
    Attribute_TraceItem aAttributeTraceItem = attributeTraceItems.get(index);
    return aAttributeTraceItem;
  }

  public List<Attribute_TraceItem> getAttributeTraceItems()
  {
    List<Attribute_TraceItem> newAttributeTraceItems = Collections.unmodifiableList(attributeTraceItems);
    return newAttributeTraceItems;
  }

  public int numberOfAttributeTraceItems()
  {
    int number = attributeTraceItems.size();
    return number;
  }

  public boolean hasAttributeTraceItems()
  {
    boolean has = attributeTraceItems.size() > 0;
    return has;
  }

  public int indexOfAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    int index = attributeTraceItems.indexOf(aAttributeTraceItem);
    return index;
  }

  public static int minimumNumberOfTraceRecords()
  {
    return 0;
  }

  public boolean addTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasAdded = false;
    if (traceRecords.contains(aTraceRecord)) { return false; }
    traceRecords.add(aTraceRecord);
    if (aTraceRecord.indexOfAttribute(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceRecord.addAttribute(this);
      if (!wasAdded)
      {
        traceRecords.remove(aTraceRecord);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasRemoved = false;
    if (!traceRecords.contains(aTraceRecord))
    {
      return wasRemoved;
    }

    int oldIndex = traceRecords.indexOf(aTraceRecord);
    traceRecords.remove(oldIndex);
    if (aTraceRecord.indexOfAttribute(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceRecord.removeAttribute(this);
      if (!wasRemoved)
      {
        traceRecords.add(oldIndex,aTraceRecord);
      }
    }
    return wasRemoved;
  }

  public static int minimumNumberOfAttributeTraceItems()
  {
    return 0;
  }

  public boolean addAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    boolean wasAdded = false;
    if (attributeTraceItems.contains(aAttributeTraceItem)) { return false; }
    attributeTraceItems.add(aAttributeTraceItem);
    if (aAttributeTraceItem.indexOfAttribute(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttributeTraceItem.addAttribute(this);
      if (!wasAdded)
      {
        attributeTraceItems.remove(aAttributeTraceItem);
      }
    }
    return wasAdded;
  }

  public boolean removeAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    boolean wasRemoved = false;
    if (!attributeTraceItems.contains(aAttributeTraceItem))
    {
      return wasRemoved;
    }

    int oldIndex = attributeTraceItems.indexOf(aAttributeTraceItem);
    attributeTraceItems.remove(oldIndex);
    if (aAttributeTraceItem.indexOfAttribute(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttributeTraceItem.removeAttribute(this);
      if (!wasRemoved)
      {
        attributeTraceItems.add(oldIndex,aAttributeTraceItem);
      }
    }
    return wasRemoved;
  }

  public void delete()
  {
    ArrayList<TraceRecord> copyOfTraceRecords = new ArrayList<TraceRecord>(traceRecords);
    traceRecords.clear();
    for(TraceRecord aTraceRecord : copyOfTraceRecords)
    {
      aTraceRecord.removeAttribute(this);
    }
    ArrayList<Attribute_TraceItem> copyOfAttributeTraceItems = new ArrayList<Attribute_TraceItem>(attributeTraceItems);
    attributeTraceItems.clear();
    for(Attribute_TraceItem aAttributeTraceItem : copyOfAttributeTraceItems)
    {
      aAttributeTraceItem.removeAttribute(this);
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