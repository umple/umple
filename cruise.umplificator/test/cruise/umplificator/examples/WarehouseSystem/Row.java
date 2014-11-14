/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 45 "WarehouseSystem.ump"
// line 121 "WarehouseSystem.ump"
public class Row
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Row Attributes
  private int depth;
  private int number;

  //Row Associations
  private List<Level> levels;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Row(int aDepth, int aNumber)
  {
    depth = aDepth;
    number = aNumber;
    levels = new ArrayList<Level>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDepth(int aDepth)
  {
    boolean wasSet = false;
    depth = aDepth;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getDepth()
  {
    return depth;
  }

  public int getNumber()
  {
    return number;
  }

  public Level getLevel(int index)
  {
    Level aLevel = levels.get(index);
    return aLevel;
  }

  public List<Level> getLevels()
  {
    List<Level> newLevels = Collections.unmodifiableList(levels);
    return newLevels;
  }

  public int numberOfLevels()
  {
    int number = levels.size();
    return number;
  }

  public boolean hasLevels()
  {
    boolean has = levels.size() > 0;
    return has;
  }

  public int indexOfLevel(Level aLevel)
  {
    int index = levels.indexOf(aLevel);
    return index;
  }

  public static int minimumNumberOfLevels()
  {
    return 0;
  }

  public Level addLevel(int aHeight, int aNumber)
  {
    return new Level(aHeight, aNumber, this);
  }

  public boolean addLevel(Level aLevel)
  {
    boolean wasAdded = false;
    if (levels.contains(aLevel)) { return false; }
    Row existingRow = aLevel.getRow();
    boolean isNewRow = existingRow != null && !this.equals(existingRow);
    if (isNewRow)
    {
      aLevel.setRow(this);
    }
    else
    {
      levels.add(aLevel);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLevel(Level aLevel)
  {
    boolean wasRemoved = false;
    //Unable to remove aLevel, as it must always have a row
    if (!this.equals(aLevel.getRow()))
    {
      levels.remove(aLevel);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLevelAt(Level aLevel, int index)
  {  
    boolean wasAdded = false;
    if(addLevel(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevels()) { index = numberOfLevels() - 1; }
      levels.remove(aLevel);
      levels.add(index, aLevel);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLevelAt(Level aLevel, int index)
  {
    boolean wasAdded = false;
    if(levels.contains(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevels()) { index = numberOfLevels() - 1; }
      levels.remove(aLevel);
      levels.add(index, aLevel);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLevelAt(aLevel, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=levels.size(); i > 0; i--)
    {
      Level aLevel = levels.get(i - 1);
      aLevel.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "depth" + ":" + getDepth()+ "," +
            "number" + ":" + getNumber()+ "]"
     + outputString;
  }
}