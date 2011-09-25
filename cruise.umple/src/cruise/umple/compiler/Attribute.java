/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;

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
  private TraceItem traceItem;

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

  public TraceItem getTraceItem()
  {
    return traceItem;
  }

  public boolean setTraceItem(TraceItem newTraceItem)
  {
    boolean wasSet = false;
    if (newTraceItem == null)
    {
      TraceItem existingTraceItem = traceItem;
      traceItem = null;
      
      if (existingTraceItem != null && existingTraceItem.getAttribute() != null)
      {
        existingTraceItem.setAttribute(null);
      }
      wasSet = true;
      return wasSet;
    }

    TraceItem currentTraceItem = getTraceItem();
    if (currentTraceItem != null && !currentTraceItem.equals(newTraceItem))
    {
      currentTraceItem.setAttribute(null);
    }

    traceItem = newTraceItem;
    Attribute existingAttribute = newTraceItem.getAttribute();

    if (!equals(existingAttribute))
    {
      newTraceItem.setAttribute(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (traceItem != null)
    {
      traceItem.setAttribute(null);
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