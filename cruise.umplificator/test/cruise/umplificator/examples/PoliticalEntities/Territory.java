/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 11 "PoliticalEntities.ump"
// line 52 "PoliticalEntities.ump"
public class Territory extends PoliticalEntity
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Territory Associations
  private List<Territory> borders;
  private List<Territory> territories;
  private List<InterGovernmentalOrganization> interGovernmentalOrganizations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Territory(String aName)
  {
    super(aName);
    borders = new ArrayList<Territory>();
    territories = new ArrayList<Territory>();
    interGovernmentalOrganizations = new ArrayList<InterGovernmentalOrganization>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Territory getBorder(int index)
  {
    Territory aBorder = borders.get(index);
    return aBorder;
  }

  public List<Territory> getBorders()
  {
    List<Territory> newBorders = Collections.unmodifiableList(borders);
    return newBorders;
  }

  public int numberOfBorders()
  {
    int number = borders.size();
    return number;
  }

  public boolean hasBorders()
  {
    boolean has = borders.size() > 0;
    return has;
  }

  public int indexOfBorder(Territory aBorder)
  {
    int index = borders.indexOf(aBorder);
    return index;
  }

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

  public InterGovernmentalOrganization getInterGovernmentalOrganization(int index)
  {
    InterGovernmentalOrganization aInterGovernmentalOrganization = interGovernmentalOrganizations.get(index);
    return aInterGovernmentalOrganization;
  }

  public List<InterGovernmentalOrganization> getInterGovernmentalOrganizations()
  {
    List<InterGovernmentalOrganization> newInterGovernmentalOrganizations = Collections.unmodifiableList(interGovernmentalOrganizations);
    return newInterGovernmentalOrganizations;
  }

  public int numberOfInterGovernmentalOrganizations()
  {
    int number = interGovernmentalOrganizations.size();
    return number;
  }

  public boolean hasInterGovernmentalOrganizations()
  {
    boolean has = interGovernmentalOrganizations.size() > 0;
    return has;
  }

  public int indexOfInterGovernmentalOrganization(InterGovernmentalOrganization aInterGovernmentalOrganization)
  {
    int index = interGovernmentalOrganizations.indexOf(aInterGovernmentalOrganization);
    return index;
  }

  public static int minimumNumberOfBorders()
  {
    return 0;
  }

  public boolean addBorder(Territory aBorder)
  {
    boolean wasAdded = false;
    if (borders.contains(aBorder)) { return false; }
    if (borders.contains(aBorder)) { return false; }
    if (borders.contains(aBorder)) { return false; }
    borders.add(aBorder);
    if (aBorder.indexOfTerritory(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBorder.addTerritory(this);
      if (!wasAdded)
      {
        borders.remove(aBorder);
      }
    }
    return wasAdded;
  }

  public boolean removeBorder(Territory aBorder)
  {
    boolean wasRemoved = false;
    if (!borders.contains(aBorder))
    {
      return wasRemoved;
    }

    int oldIndex = borders.indexOf(aBorder);
    borders.remove(oldIndex);
    if (aBorder.indexOfTerritory(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBorder.removeTerritory(this);
      if (!wasRemoved)
      {
        borders.add(oldIndex,aBorder);
      }
    }
    return wasRemoved;
  }

  public boolean addBorderAt(Territory aBorder, int index)
  {  
    boolean wasAdded = false;
    if(addBorder(aBorder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBorders()) { index = numberOfBorders() - 1; }
      borders.remove(aBorder);
      borders.add(index, aBorder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBorderAt(Territory aBorder, int index)
  {
    boolean wasAdded = false;
    if(borders.contains(aBorder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBorders()) { index = numberOfBorders() - 1; }
      borders.remove(aBorder);
      borders.add(index, aBorder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBorderAt(aBorder, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTerritories()
  {
    return 0;
  }

  public boolean addTerritory(Territory aTerritory)
  {
    boolean wasAdded = false;
    if (territories.contains(aTerritory)) { return false; }
    if (territories.contains(aTerritory)) { return false; }
    if (territories.contains(aTerritory)) { return false; }
    territories.add(aTerritory);
    if (aTerritory.indexOfBorder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTerritory.addBorder(this);
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
    if (aTerritory.indexOfBorder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTerritory.removeBorder(this);
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

  public static int minimumNumberOfInterGovernmentalOrganizations()
  {
    return 0;
  }

  public boolean addInterGovernmentalOrganization(InterGovernmentalOrganization aInterGovernmentalOrganization)
  {
    boolean wasAdded = false;
    if (interGovernmentalOrganizations.contains(aInterGovernmentalOrganization)) { return false; }
    if (interGovernmentalOrganizations.contains(aInterGovernmentalOrganization)) { return false; }
    if (interGovernmentalOrganizations.contains(aInterGovernmentalOrganization)) { return false; }
    interGovernmentalOrganizations.add(aInterGovernmentalOrganization);
    if (aInterGovernmentalOrganization.indexOfTerritory(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aInterGovernmentalOrganization.addTerritory(this);
      if (!wasAdded)
      {
        interGovernmentalOrganizations.remove(aInterGovernmentalOrganization);
      }
    }
    return wasAdded;
  }

  public boolean removeInterGovernmentalOrganization(InterGovernmentalOrganization aInterGovernmentalOrganization)
  {
    boolean wasRemoved = false;
    if (!interGovernmentalOrganizations.contains(aInterGovernmentalOrganization))
    {
      return wasRemoved;
    }

    int oldIndex = interGovernmentalOrganizations.indexOf(aInterGovernmentalOrganization);
    interGovernmentalOrganizations.remove(oldIndex);
    if (aInterGovernmentalOrganization.indexOfTerritory(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aInterGovernmentalOrganization.removeTerritory(this);
      if (!wasRemoved)
      {
        interGovernmentalOrganizations.add(oldIndex,aInterGovernmentalOrganization);
      }
    }
    return wasRemoved;
  }

  public boolean addInterGovernmentalOrganizationAt(InterGovernmentalOrganization aInterGovernmentalOrganization, int index)
  {  
    boolean wasAdded = false;
    if(addInterGovernmentalOrganization(aInterGovernmentalOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInterGovernmentalOrganizations()) { index = numberOfInterGovernmentalOrganizations() - 1; }
      interGovernmentalOrganizations.remove(aInterGovernmentalOrganization);
      interGovernmentalOrganizations.add(index, aInterGovernmentalOrganization);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInterGovernmentalOrganizationAt(InterGovernmentalOrganization aInterGovernmentalOrganization, int index)
  {
    boolean wasAdded = false;
    if(interGovernmentalOrganizations.contains(aInterGovernmentalOrganization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInterGovernmentalOrganizations()) { index = numberOfInterGovernmentalOrganizations() - 1; }
      interGovernmentalOrganizations.remove(aInterGovernmentalOrganization);
      interGovernmentalOrganizations.add(index, aInterGovernmentalOrganization);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInterGovernmentalOrganizationAt(aInterGovernmentalOrganization, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Territory> copyOfBorders = new ArrayList<Territory>(borders);
    borders.clear();
    for(Territory aBorder : copyOfBorders)
    {
      aBorder.removeTerritory(this);
    }
    ArrayList<Territory> copyOfTerritories = new ArrayList<Territory>(territories);
    territories.clear();
    for(Territory aTerritory : copyOfTerritories)
    {
      aTerritory.removeBorder(this);
    }
    ArrayList<InterGovernmentalOrganization> copyOfInterGovernmentalOrganizations = new ArrayList<InterGovernmentalOrganization>(interGovernmentalOrganizations);
    interGovernmentalOrganizations.clear();
    for(InterGovernmentalOrganization aInterGovernmentalOrganization : copyOfInterGovernmentalOrganizations)
    {
      aInterGovernmentalOrganization.removeTerritory(this);
    }
    super.delete();
  }

}