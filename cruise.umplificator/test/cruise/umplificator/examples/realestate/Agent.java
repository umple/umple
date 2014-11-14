/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 59 "realestate.ump"
// line 83 "realestate.ump"
public class Agent
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Agent Attributes
  private String name;
  private String licenseNumber;
  private String emailAddress;
  private String officePhoneNumber;
  private String cellPhoneNumber;
  private Address officeAddress;

  //Agent Associations
  private List<Neighbourhood> specializingNeighbourhoods;
  private List<OpenHouse> openHouses;
  private List<PropertyForSale> propertyForSales;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Agent(String aName, String aLicenseNumber, String aEmailAddress, String aOfficePhoneNumber, String aCellPhoneNumber, Address aOfficeAddress)
  {
    name = aName;
    licenseNumber = aLicenseNumber;
    emailAddress = aEmailAddress;
    officePhoneNumber = aOfficePhoneNumber;
    cellPhoneNumber = aCellPhoneNumber;
    officeAddress = aOfficeAddress;
    specializingNeighbourhoods = new ArrayList<Neighbourhood>();
    openHouses = new ArrayList<OpenHouse>();
    propertyForSales = new ArrayList<PropertyForSale>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLicenseNumber(String aLicenseNumber)
  {
    boolean wasSet = false;
    licenseNumber = aLicenseNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmailAddress(String aEmailAddress)
  {
    boolean wasSet = false;
    emailAddress = aEmailAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setOfficePhoneNumber(String aOfficePhoneNumber)
  {
    boolean wasSet = false;
    officePhoneNumber = aOfficePhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setCellPhoneNumber(String aCellPhoneNumber)
  {
    boolean wasSet = false;
    cellPhoneNumber = aCellPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setOfficeAddress(Address aOfficeAddress)
  {
    boolean wasSet = false;
    officeAddress = aOfficeAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getLicenseNumber()
  {
    return licenseNumber;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public String getOfficePhoneNumber()
  {
    return officePhoneNumber;
  }

  public String getCellPhoneNumber()
  {
    return cellPhoneNumber;
  }

  public Address getOfficeAddress()
  {
    return officeAddress;
  }

  public Neighbourhood getSpecializingNeighbourhood(int index)
  {
    Neighbourhood aSpecializingNeighbourhood = specializingNeighbourhoods.get(index);
    return aSpecializingNeighbourhood;
  }

  public List<Neighbourhood> getSpecializingNeighbourhoods()
  {
    List<Neighbourhood> newSpecializingNeighbourhoods = Collections.unmodifiableList(specializingNeighbourhoods);
    return newSpecializingNeighbourhoods;
  }

  public int numberOfSpecializingNeighbourhoods()
  {
    int number = specializingNeighbourhoods.size();
    return number;
  }

  public boolean hasSpecializingNeighbourhoods()
  {
    boolean has = specializingNeighbourhoods.size() > 0;
    return has;
  }

  public int indexOfSpecializingNeighbourhood(Neighbourhood aSpecializingNeighbourhood)
  {
    int index = specializingNeighbourhoods.indexOf(aSpecializingNeighbourhood);
    return index;
  }

  public OpenHouse getOpenHous(int index)
  {
    OpenHouse aOpenHous = openHouses.get(index);
    return aOpenHous;
  }

  public List<OpenHouse> getOpenHouses()
  {
    List<OpenHouse> newOpenHouses = Collections.unmodifiableList(openHouses);
    return newOpenHouses;
  }

  public int numberOfOpenHouses()
  {
    int number = openHouses.size();
    return number;
  }

  public boolean hasOpenHouses()
  {
    boolean has = openHouses.size() > 0;
    return has;
  }

  public int indexOfOpenHous(OpenHouse aOpenHous)
  {
    int index = openHouses.indexOf(aOpenHous);
    return index;
  }

  public PropertyForSale getPropertyForSale(int index)
  {
    PropertyForSale aPropertyForSale = propertyForSales.get(index);
    return aPropertyForSale;
  }

  public List<PropertyForSale> getPropertyForSales()
  {
    List<PropertyForSale> newPropertyForSales = Collections.unmodifiableList(propertyForSales);
    return newPropertyForSales;
  }

  public int numberOfPropertyForSales()
  {
    int number = propertyForSales.size();
    return number;
  }

  public boolean hasPropertyForSales()
  {
    boolean has = propertyForSales.size() > 0;
    return has;
  }

  public int indexOfPropertyForSale(PropertyForSale aPropertyForSale)
  {
    int index = propertyForSales.indexOf(aPropertyForSale);
    return index;
  }

  public static int minimumNumberOfSpecializingNeighbourhoods()
  {
    return 0;
  }

  public boolean addSpecializingNeighbourhood(Neighbourhood aSpecializingNeighbourhood)
  {
    boolean wasAdded = false;
    if (specializingNeighbourhoods.contains(aSpecializingNeighbourhood)) { return false; }
    specializingNeighbourhoods.add(aSpecializingNeighbourhood);
    if (aSpecializingNeighbourhood.indexOfAgent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSpecializingNeighbourhood.addAgent(this);
      if (!wasAdded)
      {
        specializingNeighbourhoods.remove(aSpecializingNeighbourhood);
      }
    }
    return wasAdded;
  }

  public boolean removeSpecializingNeighbourhood(Neighbourhood aSpecializingNeighbourhood)
  {
    boolean wasRemoved = false;
    if (!specializingNeighbourhoods.contains(aSpecializingNeighbourhood))
    {
      return wasRemoved;
    }

    int oldIndex = specializingNeighbourhoods.indexOf(aSpecializingNeighbourhood);
    specializingNeighbourhoods.remove(oldIndex);
    if (aSpecializingNeighbourhood.indexOfAgent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSpecializingNeighbourhood.removeAgent(this);
      if (!wasRemoved)
      {
        specializingNeighbourhoods.add(oldIndex,aSpecializingNeighbourhood);
      }
    }
    return wasRemoved;
  }

  public boolean addSpecializingNeighbourhoodAt(Neighbourhood aSpecializingNeighbourhood, int index)
  {  
    boolean wasAdded = false;
    if(addSpecializingNeighbourhood(aSpecializingNeighbourhood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecializingNeighbourhoods()) { index = numberOfSpecializingNeighbourhoods() - 1; }
      specializingNeighbourhoods.remove(aSpecializingNeighbourhood);
      specializingNeighbourhoods.add(index, aSpecializingNeighbourhood);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpecializingNeighbourhoodAt(Neighbourhood aSpecializingNeighbourhood, int index)
  {
    boolean wasAdded = false;
    if(specializingNeighbourhoods.contains(aSpecializingNeighbourhood))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecializingNeighbourhoods()) { index = numberOfSpecializingNeighbourhoods() - 1; }
      specializingNeighbourhoods.remove(aSpecializingNeighbourhood);
      specializingNeighbourhoods.add(index, aSpecializingNeighbourhood);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpecializingNeighbourhoodAt(aSpecializingNeighbourhood, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfOpenHouses()
  {
    return 0;
  }

  public boolean addOpenHous(OpenHouse aOpenHous)
  {
    boolean wasAdded = false;
    if (openHouses.contains(aOpenHous)) { return false; }
    Agent existingAgentInCharge = aOpenHous.getAgentInCharge();
    if (existingAgentInCharge == null)
    {
      aOpenHous.setAgentInCharge(this);
    }
    else if (!this.equals(existingAgentInCharge))
    {
      existingAgentInCharge.removeOpenHous(aOpenHous);
      addOpenHous(aOpenHous);
    }
    else
    {
      openHouses.add(aOpenHous);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOpenHous(OpenHouse aOpenHous)
  {
    boolean wasRemoved = false;
    if (openHouses.contains(aOpenHous))
    {
      openHouses.remove(aOpenHous);
      aOpenHous.setAgentInCharge(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOpenHousAt(OpenHouse aOpenHous, int index)
  {  
    boolean wasAdded = false;
    if(addOpenHous(aOpenHous))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOpenHouses()) { index = numberOfOpenHouses() - 1; }
      openHouses.remove(aOpenHous);
      openHouses.add(index, aOpenHous);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOpenHousAt(OpenHouse aOpenHous, int index)
  {
    boolean wasAdded = false;
    if(openHouses.contains(aOpenHous))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOpenHouses()) { index = numberOfOpenHouses() - 1; }
      openHouses.remove(aOpenHous);
      openHouses.add(index, aOpenHous);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOpenHousAt(aOpenHous, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPropertyForSales()
  {
    return 0;
  }

  public boolean addPropertyForSale(PropertyForSale aPropertyForSale)
  {
    boolean wasAdded = false;
    if (propertyForSales.contains(aPropertyForSale)) { return false; }
    Agent existingListingAgent = aPropertyForSale.getListingAgent();
    if (existingListingAgent == null)
    {
      aPropertyForSale.setListingAgent(this);
    }
    else if (!this.equals(existingListingAgent))
    {
      existingListingAgent.removePropertyForSale(aPropertyForSale);
      addPropertyForSale(aPropertyForSale);
    }
    else
    {
      propertyForSales.add(aPropertyForSale);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePropertyForSale(PropertyForSale aPropertyForSale)
  {
    boolean wasRemoved = false;
    if (propertyForSales.contains(aPropertyForSale))
    {
      propertyForSales.remove(aPropertyForSale);
      aPropertyForSale.setListingAgent(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPropertyForSaleAt(PropertyForSale aPropertyForSale, int index)
  {  
    boolean wasAdded = false;
    if(addPropertyForSale(aPropertyForSale))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPropertyForSales()) { index = numberOfPropertyForSales() - 1; }
      propertyForSales.remove(aPropertyForSale);
      propertyForSales.add(index, aPropertyForSale);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePropertyForSaleAt(PropertyForSale aPropertyForSale, int index)
  {
    boolean wasAdded = false;
    if(propertyForSales.contains(aPropertyForSale))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPropertyForSales()) { index = numberOfPropertyForSales() - 1; }
      propertyForSales.remove(aPropertyForSale);
      propertyForSales.add(index, aPropertyForSale);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPropertyForSaleAt(aPropertyForSale, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Neighbourhood> copyOfSpecializingNeighbourhoods = new ArrayList<Neighbourhood>(specializingNeighbourhoods);
    specializingNeighbourhoods.clear();
    for(Neighbourhood aSpecializingNeighbourhood : copyOfSpecializingNeighbourhoods)
    {
      aSpecializingNeighbourhood.removeAgent(this);
    }
    while( !openHouses.isEmpty() )
    {
      openHouses.get(0).setAgentInCharge(null);
    }
    while( !propertyForSales.isEmpty() )
    {
      propertyForSales.get(0).setListingAgent(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "licenseNumber" + ":" + getLicenseNumber()+ "," +
            "emailAddress" + ":" + getEmailAddress()+ "," +
            "officePhoneNumber" + ":" + getOfficePhoneNumber()+ "," +
            "cellPhoneNumber" + ":" + getCellPhoneNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "officeAddress" + "=" + (getOfficeAddress() != null ? !getOfficeAddress().equals(this)  ? getOfficeAddress().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}