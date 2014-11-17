/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 16 "PoliticalEntities.ump"
// line 29 "PoliticalEntities.ump"
public class InterGovernmentalOrganization extends PoliticalEntity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InterGovernmentalOrganization Associations
  private List<Territory> territories;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InterGovernmentalOrganization(String aName)
  {
    super(aName);
    territories = new ArrayList<Territory>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Territory getTerritory(int index)
  {
    Territory aTerritory = territories.get(index);
    return aTerritory;
  }

  public List<Territory> getTerritories()
  {
    List<Territory> newTerritories = Collections.unmodifiableList(territories);
    return newTerritories;
  }

  public int numberOfTerritories()
  {
    int number = territories.size();
    return number;
  }

  public boolean hasTerritories()
  {
    boolean has = territories.size() > 0;
    return has;
  }

  public int indexOfTerritory(Territory aTerritory)
  {
    int index = territories.indexOf(aTerritory);
    return index;
  }

  public static int minimumNumberOfTerritories()
  {
    return 0;
  }

  public boolean addTerritory(Territory aTerritory)
  {
    boolean wasAdded = false;
    if (territories.contains(aTerritory)) { return false; }
    territories.add(aTerritory);
    if (aTerritory.indexOfInterGovernmentalOrganization(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTerritory.addInterGovernmentalOrganization(this);
      if (!wasAdded)
      {
        territories.remove(aTerritory);
      }
    }
    return wasAdded;
  }

  public boolean removeTerritory(Territory aTerritory)
  {
    boolean wasRemoved = false;
    if (!territories.contains(aTerritory))
    {
      return wasRemoved;
    }

    int oldIndex = territories.indexOf(aTerritory);
    territories.remove(oldIndex);
    if (aTerritory.indexOfInterGovernmentalOrganization(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTerritory.removeInterGovernmentalOrganization(this);
      if (!wasRemoved)
      {
        territories.add(oldIndex,aTerritory);
      }
    }
    return wasRemoved;
  }

  public boolean addTerritoryAt(Territory aTerritory, int index)
  {  
    boolean wasAdded = false;
    if(addTerritory(aTerritory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTerritories()) { index = numberOfTerritories() - 1; }
      territories.remove(aTerritory);
      territories.add(index, aTerritory);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTerritoryAt(Territory aTerritory, int index)
  {
    boolean wasAdded = false;
    if(territories.contains(aTerritory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTerritories()) { index = numberOfTerritories() - 1; }
      territories.remove(aTerritory);
      territories.add(index, aTerritory);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTerritoryAt(aTerritory, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Territory> copyOfTerritories = new ArrayList<Territory>(territories);
    territories.clear();
    for(Territory aTerritory : copyOfTerritories)
    {
      aTerritory.removeInterGovernmentalOrganization(this);
    }
    super.delete();
  }

}