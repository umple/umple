/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 5 "Accommodations.ump"
// line 132 "Accommodations.ump"
public class UnitFacility
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UnitFacility Attributes
  private String unit_attribute_code;
  private String unit_attribute_description;

  //UnitFacility Associations
  private List<Unit> units;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetUnit_attribute_code;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UnitFacility(String aUnit_attribute_code, String aUnit_attribute_description)
  {
    cachedHashCode = -1;
    canSetUnit_attribute_code = true;
    unit_attribute_code = aUnit_attribute_code;
    unit_attribute_description = aUnit_attribute_description;
    units = new ArrayList<Unit>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUnit_attribute_code(String aUnit_attribute_code)
  {
    boolean wasSet = false;
    if (!canSetUnit_attribute_code) { return false; }
    unit_attribute_code = aUnit_attribute_code;
    wasSet = true;
    return wasSet;
  }

  public boolean setUnit_attribute_description(String aUnit_attribute_description)
  {
    boolean wasSet = false;
    unit_attribute_description = aUnit_attribute_description;
    wasSet = true;
    return wasSet;
  }

  public String getUnit_attribute_code()
  {
    return unit_attribute_code;
  }

  public String getUnit_attribute_description()
  {
    return unit_attribute_description;
  }

  public Unit getUnit(int index)
  {
    Unit aUnit = units.get(index);
    return aUnit;
  }

  public List<Unit> getUnits()
  {
    List<Unit> newUnits = Collections.unmodifiableList(units);
    return newUnits;
  }

  public int numberOfUnits()
  {
    int number = units.size();
    return number;
  }

  public boolean hasUnits()
  {
    boolean has = units.size() > 0;
    return has;
  }

  public int indexOfUnit(Unit aUnit)
  {
    int index = units.indexOf(aUnit);
    return index;
  }

  public static int minimumNumberOfUnits()
  {
    return 0;
  }

  public boolean addUnit(Unit aUnit)
  {
    boolean wasAdded = false;
    if (units.contains(aUnit)) { return false; }
    units.add(aUnit);
    if (aUnit.indexOfUnitFacility(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUnit.addUnitFacility(this);
      if (!wasAdded)
      {
        units.remove(aUnit);
      }
    }
    return wasAdded;
  }

  public boolean removeUnit(Unit aUnit)
  {
    boolean wasRemoved = false;
    if (!units.contains(aUnit))
    {
      return wasRemoved;
    }

    int oldIndex = units.indexOf(aUnit);
    units.remove(oldIndex);
    if (aUnit.indexOfUnitFacility(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUnit.removeUnitFacility(this);
      if (!wasRemoved)
      {
        units.add(oldIndex,aUnit);
      }
    }
    return wasRemoved;
  }

  public boolean addUnitAt(Unit aUnit, int index)
  {  
    boolean wasAdded = false;
    if(addUnit(aUnit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnits()) { index = numberOfUnits() - 1; }
      units.remove(aUnit);
      units.add(index, aUnit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUnitAt(Unit aUnit, int index)
  {
    boolean wasAdded = false;
    if(units.contains(aUnit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnits()) { index = numberOfUnits() - 1; }
      units.remove(aUnit);
      units.add(index, aUnit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUnitAt(aUnit, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    UnitFacility compareTo = (UnitFacility)obj;
  
    if (unit_attribute_code == null && compareTo.unit_attribute_code != null)
    {
      return false;
    }
    else if (unit_attribute_code != null && !unit_attribute_code.equals(compareTo.unit_attribute_code))
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
    if (unit_attribute_code != null)
    {
      cachedHashCode = cachedHashCode * 23 + unit_attribute_code.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetUnit_attribute_code = false;
    return cachedHashCode;
  }

  public void delete()
  {
    ArrayList<Unit> copyOfUnits = new ArrayList<Unit>(units);
    units.clear();
    for(Unit aUnit : copyOfUnits)
    {
      aUnit.removeUnitFacility(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "unit_attribute_code" + ":" + getUnit_attribute_code()+ "," +
            "unit_attribute_description" + ":" + getUnit_attribute_description()+ "]"
     + outputString;
  }
}