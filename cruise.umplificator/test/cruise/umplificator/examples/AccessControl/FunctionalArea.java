/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Functional_Area
 * Positioning
 */
// line 15 "AccessControl.ump"
// line 70 "AccessControl.ump"
public class FunctionalArea
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FunctionalArea Attributes
  private String code;

  //FunctionalArea State Machines
  enum Description { Hr, Finance }
  private Description description;

  //FunctionalArea Associations
  private List<FunctionalArea> child;
  private FunctionalArea parent;
  private List<Facility> facilities;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FunctionalArea(String aCode)
  {
    cachedHashCode = -1;
    canSetCode = true;
    code = aCode;
    child = new ArrayList<FunctionalArea>();
    facilities = new ArrayList<Facility>();
    setDescription(Description.Hr);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    if (!canSetCode) { return false; }
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getCode()
  {
    return code;
  }

  public String getDescriptionFullName()
  {
    String answer = description.toString();
    return answer;
  }

  public Description getDescription()
  {
    return description;
  }

  public boolean setDescription(Description aDescription)
  {
    description = aDescription;
    return true;
  }

  public FunctionalArea getChild(int index)
  {
    FunctionalArea aChild = child.get(index);
    return aChild;
  }

  public List<FunctionalArea> getChild()
  {
    List<FunctionalArea> newChild = Collections.unmodifiableList(child);
    return newChild;
  }

  public int numberOfChild()
  {
    int number = child.size();
    return number;
  }

  public boolean hasChild()
  {
    boolean has = child.size() > 0;
    return has;
  }

  public int indexOfChild(FunctionalArea aChild)
  {
    int index = child.indexOf(aChild);
    return index;
  }

  public FunctionalArea getParent()
  {
    return parent;
  }

  public boolean hasParent()
  {
    boolean has = parent != null;
    return has;
  }

  public Facility getFacility(int index)
  {
    Facility aFacility = facilities.get(index);
    return aFacility;
  }

  public List<Facility> getFacilities()
  {
    List<Facility> newFacilities = Collections.unmodifiableList(facilities);
    return newFacilities;
  }

  public int numberOfFacilities()
  {
    int number = facilities.size();
    return number;
  }

  public boolean hasFacilities()
  {
    boolean has = facilities.size() > 0;
    return has;
  }

  public int indexOfFacility(Facility aFacility)
  {
    int index = facilities.indexOf(aFacility);
    return index;
  }

  public static int minimumNumberOfChild()
  {
    return 0;
  }

  public boolean addChild(FunctionalArea aChild)
  {
    boolean wasAdded = false;
    if (child.contains(aChild)) { return false; }
    FunctionalArea existingParent = aChild.getParent();
    if (existingParent == null)
    {
      aChild.setParent(this);
    }
    else if (!this.equals(existingParent))
    {
      existingParent.removeChild(aChild);
      addChild(aChild);
    }
    else
    {
      child.add(aChild);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeChild(FunctionalArea aChild)
  {
    boolean wasRemoved = false;
    if (child.contains(aChild))
    {
      child.remove(aChild);
      aChild.setParent(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addChildAt(FunctionalArea aChild, int index)
  {  
    boolean wasAdded = false;
    if(addChild(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChild()) { index = numberOfChild() - 1; }
      child.remove(aChild);
      child.add(index, aChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChildAt(FunctionalArea aChild, int index)
  {
    boolean wasAdded = false;
    if(child.contains(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChild()) { index = numberOfChild() - 1; }
      child.remove(aChild);
      child.add(index, aChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChildAt(aChild, index);
    }
    return wasAdded;
  }

  public boolean setParent(FunctionalArea aParent)
  {
    boolean wasSet = false;
    FunctionalArea existingParent = parent;
    parent = aParent;
    if (existingParent != null && !existingParent.equals(aParent))
    {
      existingParent.removeChild(this);
    }
    if (aParent != null)
    {
      aParent.addChild(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfFacilities()
  {
    return 0;
  }

  public boolean addFacility(Facility aFacility)
  {
    boolean wasAdded = false;
    if (facilities.contains(aFacility)) { return false; }
    facilities.add(aFacility);
    if (aFacility.indexOfFunctionalArea(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFacility.addFunctionalArea(this);
      if (!wasAdded)
      {
        facilities.remove(aFacility);
      }
    }
    return wasAdded;
  }

  public boolean removeFacility(Facility aFacility)
  {
    boolean wasRemoved = false;
    if (!facilities.contains(aFacility))
    {
      return wasRemoved;
    }

    int oldIndex = facilities.indexOf(aFacility);
    facilities.remove(oldIndex);
    if (aFacility.indexOfFunctionalArea(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFacility.removeFunctionalArea(this);
      if (!wasRemoved)
      {
        facilities.add(oldIndex,aFacility);
      }
    }
    return wasRemoved;
  }

  public boolean addFacilityAt(Facility aFacility, int index)
  {  
    boolean wasAdded = false;
    if(addFacility(aFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFacilities()) { index = numberOfFacilities() - 1; }
      facilities.remove(aFacility);
      facilities.add(index, aFacility);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFacilityAt(Facility aFacility, int index)
  {
    boolean wasAdded = false;
    if(facilities.contains(aFacility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFacilities()) { index = numberOfFacilities() - 1; }
      facilities.remove(aFacility);
      facilities.add(index, aFacility);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFacilityAt(aFacility, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    FunctionalArea compareTo = (FunctionalArea)obj;
  
    if (code == null && compareTo.code != null)
    {
      return false;
    }
    else if (code != null && !code.equals(compareTo.code))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (code != null)
    {
      cachedHashCode = cachedHashCode * 23 + code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCode = false;
    return cachedHashCode;
  }

  public void delete()
  {
    while( !child.isEmpty() )
    {
      child.get(0).setParent(null);
    }
    if (parent != null)
    {
      FunctionalArea placeholderParent = parent;
      this.parent = null;
      placeholderParent.removeChild(this);
    }
    ArrayList<Facility> copyOfFacilities = new ArrayList<Facility>(facilities);
    facilities.clear();
    for(Facility aFacility : copyOfFacilities)
    {
      aFacility.removeFunctionalArea(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "code" + ":" + getCode()+ "]"
     + outputString;
  }
}