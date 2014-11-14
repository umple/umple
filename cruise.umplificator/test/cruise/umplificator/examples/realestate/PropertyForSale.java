/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;
import java.sql.Time;

// line 71 "realestate.ump"
// line 100 "realestate.ump"
public class PropertyForSale
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PropertyForSale Attributes
  private int listingNumber;
  private int askingPrice;
  private Date dateListedForSale;

  //PropertyForSale Associations
  private Property listedProperty;
  private Agent listingAgent;
  private PropertySale propertySale;
  private List<OpenHouse> openHouses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PropertyForSale(int aListingNumber, int aAskingPrice, Date aDateListedForSale, Property aListedProperty)
  {
    listingNumber = aListingNumber;
    askingPrice = aAskingPrice;
    dateListedForSale = aDateListedForSale;
    boolean didAddListedProperty = setListedProperty(aListedProperty);
    if (!didAddListedProperty)
    {
      throw new RuntimeException("Unable to create propertyForSale due to listedProperty");
    }
    openHouses = new ArrayList<OpenHouse>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setListingNumber(int aListingNumber)
  {
    boolean wasSet = false;
    listingNumber = aListingNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setAskingPrice(int aAskingPrice)
  {
    boolean wasSet = false;
    askingPrice = aAskingPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateListedForSale(Date aDateListedForSale)
  {
    boolean wasSet = false;
    dateListedForSale = aDateListedForSale;
    wasSet = true;
    return wasSet;
  }

  public int getListingNumber()
  {
    return listingNumber;
  }

  public int getAskingPrice()
  {
    return askingPrice;
  }

  public Date getDateListedForSale()
  {
    return dateListedForSale;
  }

  public Property getListedProperty()
  {
    return listedProperty;
  }

  public Agent getListingAgent()
  {
    return listingAgent;
  }

  public boolean hasListingAgent()
  {
    boolean has = listingAgent != null;
    return has;
  }

  public PropertySale getPropertySale()
  {
    return propertySale;
  }

  public boolean hasPropertySale()
  {
    boolean has = propertySale != null;
    return has;
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

  public boolean setListedProperty(Property aListedProperty)
  {
    boolean wasSet = false;
    if (aListedProperty == null)
    {
      return wasSet;
    }

    Property existingListedProperty = listedProperty;
    listedProperty = aListedProperty;
    if (existingListedProperty != null && !existingListedProperty.equals(aListedProperty))
    {
      existingListedProperty.removePropertyForSale(this);
    }
    listedProperty.addPropertyForSale(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setListingAgent(Agent aListingAgent)
  {
    boolean wasSet = false;
    Agent existingListingAgent = listingAgent;
    listingAgent = aListingAgent;
    if (existingListingAgent != null && !existingListingAgent.equals(aListingAgent))
    {
      existingListingAgent.removePropertyForSale(this);
    }
    if (aListingAgent != null)
    {
      aListingAgent.addPropertyForSale(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setPropertySale(PropertySale aNewPropertySale)
  {
    boolean wasSet = false;
    if (aNewPropertySale == null)
    {
      PropertySale existingPropertySale = propertySale;
      propertySale = null;
      
      if (existingPropertySale != null && existingPropertySale.getPropertyForSale() != null)
      {
        existingPropertySale.setPropertyForSale(null);
      }
      wasSet = true;
      return wasSet;
    }

    PropertySale currentPropertySale = getPropertySale();
    if (currentPropertySale != null && !currentPropertySale.equals(aNewPropertySale))
    {
      currentPropertySale.setPropertyForSale(null);
    }

    propertySale = aNewPropertySale;
    PropertyForSale existingPropertyForSale = aNewPropertySale.getPropertyForSale();

    if (!equals(existingPropertyForSale))
    {
      aNewPropertySale.setPropertyForSale(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfOpenHouses()
  {
    return 0;
  }

  public OpenHouse addOpenHous(Date aDate, Time aStartTime, Time aEndTime)
  {
    return new OpenHouse(aDate, aStartTime, aEndTime, this);
  }

  public boolean addOpenHous(OpenHouse aOpenHous)
  {
    boolean wasAdded = false;
    if (openHouses.contains(aOpenHous)) { return false; }
    PropertyForSale existingPropertyForSale = aOpenHous.getPropertyForSale();
    boolean isNewPropertyForSale = existingPropertyForSale != null && !this.equals(existingPropertyForSale);
    if (isNewPropertyForSale)
    {
      aOpenHous.setPropertyForSale(this);
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
    //Unable to remove aOpenHous, as it must always have a propertyForSale
    if (!this.equals(aOpenHous.getPropertyForSale()))
    {
      openHouses.remove(aOpenHous);
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

  public void delete()
  {
    Property placeholderListedProperty = listedProperty;
    this.listedProperty = null;
    placeholderListedProperty.removePropertyForSale(this);
    if (listingAgent != null)
    {
      Agent placeholderListingAgent = listingAgent;
      this.listingAgent = null;
      placeholderListingAgent.removePropertyForSale(this);
    }
    if (propertySale != null)
    {
      propertySale.setPropertyForSale(null);
    }
    for(int i=openHouses.size(); i > 0; i--)
    {
      OpenHouse aOpenHous = openHouses.get(i - 1);
      aOpenHous.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "listingNumber" + ":" + getListingNumber()+ "," +
            "askingPrice" + ":" + getAskingPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateListedForSale" + "=" + (getDateListedForSale() != null ? !getDateListedForSale().equals(this)  ? getDateListedForSale().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "listedProperty = "+(getListedProperty()!=null?Integer.toHexString(System.identityHashCode(getListedProperty())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "listingAgent = "+(getListingAgent()!=null?Integer.toHexString(System.identityHashCode(getListingAgent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "propertySale = "+(getPropertySale()!=null?Integer.toHexString(System.identityHashCode(getPropertySale())):"null")
     + outputString;
  }
}