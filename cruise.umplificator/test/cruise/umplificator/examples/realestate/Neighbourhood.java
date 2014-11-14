/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 32 "realestate.ump"
// line 122 "realestate.ump"
public class Neighbourhood
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Neighbourhood Attributes
  private String description;
  private List<GPSCoord> gpsCoordsOfBoundary;

  //Neighbourhood Associations
  private List<Property> properties;
  private List<Agent> agents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Neighbourhood(String aDescription)
  {
    description = aDescription;
    gpsCoordsOfBoundary = new ArrayList<GPSCoord>();
    properties = new ArrayList<Property>();
    agents = new ArrayList<Agent>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean addGpsCoordsOfBoundary(GPSCoord aGpsCoordsOfBoundary)
  {
    boolean wasAdded = false;
    wasAdded = gpsCoordsOfBoundary.add(aGpsCoordsOfBoundary);
    return wasAdded;
  }

  public boolean removeGpsCoordsOfBoundary(GPSCoord aGpsCoordsOfBoundary)
  {
    boolean wasRemoved = false;
    wasRemoved = gpsCoordsOfBoundary.remove(aGpsCoordsOfBoundary);
    return wasRemoved;
  }

  public String getDescription()
  {
    return description;
  }

  public GPSCoord getGpsCoordsOfBoundary(int index)
  {
    GPSCoord aGpsCoordsOfBoundary = gpsCoordsOfBoundary.get(index);
    return aGpsCoordsOfBoundary;
  }

  public GPSCoord[] getGpsCoordsOfBoundary()
  {
    GPSCoord[] newGpsCoordsOfBoundary = gpsCoordsOfBoundary.toArray(new GPSCoord[gpsCoordsOfBoundary.size()]);
    return newGpsCoordsOfBoundary;
  }

  public int numberOfGpsCoordsOfBoundary()
  {
    int number = gpsCoordsOfBoundary.size();
    return number;
  }

  public boolean hasGpsCoordsOfBoundary()
  {
    boolean has = gpsCoordsOfBoundary.size() > 0;
    return has;
  }

  public int indexOfGpsCoordsOfBoundary(GPSCoord aGpsCoordsOfBoundary)
  {
    int index = gpsCoordsOfBoundary.indexOf(aGpsCoordsOfBoundary);
    return index;
  }

  public Property getProperty(int index)
  {
    Property aProperty = properties.get(index);
    return aProperty;
  }

  public List<Property> getProperties()
  {
    List<Property> newProperties = Collections.unmodifiableList(properties);
    return newProperties;
  }

  public int numberOfProperties()
  {
    int number = properties.size();
    return number;
  }

  public boolean hasProperties()
  {
    boolean has = properties.size() > 0;
    return has;
  }

  public int indexOfProperty(Property aProperty)
  {
    int index = properties.indexOf(aProperty);
    return index;
  }

  public Agent getAgent(int index)
  {
    Agent aAgent = agents.get(index);
    return aAgent;
  }

  public List<Agent> getAgents()
  {
    List<Agent> newAgents = Collections.unmodifiableList(agents);
    return newAgents;
  }

  public int numberOfAgents()
  {
    int number = agents.size();
    return number;
  }

  public boolean hasAgents()
  {
    boolean has = agents.size() > 0;
    return has;
  }

  public int indexOfAgent(Agent aAgent)
  {
    int index = agents.indexOf(aAgent);
    return index;
  }

  public static int minimumNumberOfProperties()
  {
    return 0;
  }

  public Property addProperty(Address aPropertyAddress, int aNumberBedrooms, int aNumberBathrooms, int aSquareFeet, int aNumFloors, GPSCoord aGpsCoord)
  {
    return new Property(aPropertyAddress, aNumberBedrooms, aNumberBathrooms, aSquareFeet, aNumFloors, aGpsCoord, this);
  }

  public boolean addProperty(Property aProperty)
  {
    boolean wasAdded = false;
    if (properties.contains(aProperty)) { return false; }
    Neighbourhood existingNeighbourhood = aProperty.getNeighbourhood();
    boolean isNewNeighbourhood = existingNeighbourhood != null && !this.equals(existingNeighbourhood);
    if (isNewNeighbourhood)
    {
      aProperty.setNeighbourhood(this);
    }
    else
    {
      properties.add(aProperty);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProperty(Property aProperty)
  {
    boolean wasRemoved = false;
    //Unable to remove aProperty, as it must always have a neighbourhood
    if (!this.equals(aProperty.getNeighbourhood()))
    {
      properties.remove(aProperty);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPropertyAt(Property aProperty, int index)
  {  
    boolean wasAdded = false;
    if(addProperty(aProperty))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProperties()) { index = numberOfProperties() - 1; }
      properties.remove(aProperty);
      properties.add(index, aProperty);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePropertyAt(Property aProperty, int index)
  {
    boolean wasAdded = false;
    if(properties.contains(aProperty))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProperties()) { index = numberOfProperties() - 1; }
      properties.remove(aProperty);
      properties.add(index, aProperty);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPropertyAt(aProperty, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAgents()
  {
    return 0;
  }

  public boolean addAgent(Agent aAgent)
  {
    boolean wasAdded = false;
    if (agents.contains(aAgent)) { return false; }
    agents.add(aAgent);
    if (aAgent.indexOfSpecializingNeighbourhood(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAgent.addSpecializingNeighbourhood(this);
      if (!wasAdded)
      {
        agents.remove(aAgent);
      }
    }
    return wasAdded;
  }

  public boolean removeAgent(Agent aAgent)
  {
    boolean wasRemoved = false;
    if (!agents.contains(aAgent))
    {
      return wasRemoved;
    }

    int oldIndex = agents.indexOf(aAgent);
    agents.remove(oldIndex);
    if (aAgent.indexOfSpecializingNeighbourhood(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAgent.removeSpecializingNeighbourhood(this);
      if (!wasRemoved)
      {
        agents.add(oldIndex,aAgent);
      }
    }
    return wasRemoved;
  }

  public boolean addAgentAt(Agent aAgent, int index)
  {  
    boolean wasAdded = false;
    if(addAgent(aAgent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgents()) { index = numberOfAgents() - 1; }
      agents.remove(aAgent);
      agents.add(index, aAgent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAgentAt(Agent aAgent, int index)
  {
    boolean wasAdded = false;
    if(agents.contains(aAgent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgents()) { index = numberOfAgents() - 1; }
      agents.remove(aAgent);
      agents.add(index, aAgent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAgentAt(aAgent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=properties.size(); i > 0; i--)
    {
      Property aProperty = properties.get(i - 1);
      aProperty.delete();
    }
    ArrayList<Agent> copyOfAgents = new ArrayList<Agent>(agents);
    agents.clear();
    for(Agent aAgent : copyOfAgents)
    {
      aAgent.removeSpecializingNeighbourhood(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}