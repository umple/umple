/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 20 "realestate.ump"
// line 89 "realestate.ump"
public class Property
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Property Attributes
  private Address propertyAddress;
  private int numberBedrooms;
  private int numberBathrooms;
  private int squareFeet;
  private int numFloors;
  private GPSCoord gpsCoord;

  //Property Associations
  private Neighbourhood neighbourhood;
  private List<PropertySale> propertySales;
  private List<PropertyForSale> propertyForSales;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Property(Address aPropertyAddress, int aNumberBedrooms, int aNumberBathrooms, int aSquareFeet, int aNumFloors, GPSCoord aGpsCoord, Neighbourhood aNeighbourhood)
  {
    propertyAddress = aPropertyAddress;
    numberBedrooms = aNumberBedrooms;
    numberBathrooms = aNumberBathrooms;
    squareFeet = aSquareFeet;
    numFloors = aNumFloors;
    gpsCoord = aGpsCoord;
    boolean didAddNeighbourhood = setNeighbourhood(aNeighbourhood);
    if (!didAddNeighbourhood)
    {
      throw new RuntimeException("Unable to create property due to neighbourhood");
    }
    propertySales = new ArrayList<PropertySale>();
    propertyForSales = new ArrayList<PropertyForSale>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPropertyAddress(Address aPropertyAddress)
  {
    boolean wasSet = false;
    propertyAddress = aPropertyAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberBedrooms(int aNumberBedrooms)
  {
    boolean wasSet = false;
    numberBedrooms = aNumberBedrooms;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberBathrooms(int aNumberBathrooms)
  {
    boolean wasSet = false;
    numberBathrooms = aNumberBathrooms;
    wasSet = true;
    return wasSet;
  }

  public boolean setSquareFeet(int aSquareFeet)
  {
    boolean wasSet = false;
    squareFeet = aSquareFeet;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumFloors(int aNumFloors)
  {
    boolean wasSet = false;
    numFloors = aNumFloors;
    wasSet = true;
    return wasSet;
  }

  public boolean setGpsCoord(GPSCoord aGpsCoord)
  {
    boolean wasSet = false;
    gpsCoord = aGpsCoord;
    wasSet = true;
    return wasSet;
  }

  public Address getPropertyAddress()
  {
    return propertyAddress;
  }

  public int getNumberBedrooms()
  {
    return numberBedrooms;
  }

  public int getNumberBathrooms()
  {
    return numberBathrooms;
  }

  public int getSquareFeet()
  {
    return squareFeet;
  }

  public int getNumFloors()
  {
    return numFloors;
  }

  public GPSCoord getGpsCoord()
  {
    return gpsCoord;
  }

  public Neighbourhood getNeighbourhood()
  {
    return neighbourhood;
  }

  public PropertySale getPropertySale(int index)
  {
    PropertySale aPropertySale = propertySales.get(index);
    return aPropertySale;
  }

  public List<PropertySale> getPropertySales()
  {
    List<PropertySale> newPropertySales = Collections.unmodifiableList(propertySales);
    return newPropertySales;
  }

  public int numberOfPropertySales()
  {
    int number = propertySales.size();
    return number;
  }

  public boolean hasPropertySales()
  {
    boolean has = propertySales.size() > 0;
    return has;
  }

  public int indexOfPropertySale(PropertySale aPropertySale)
  {
    int index = propertySales.indexOf(aPropertySale);
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

  public boolean setNeighbourhood(Neighbourhood aNeighbourhood)
  {
    boolean wasSet = false;
    if (aNeighbourhood == null)
    {
      return wasSet;
    }

    Neighbourhood existingNeighbourhood = neighbourhood;
    neighbourhood = aNeighbourhood;
    if (existingNeighbourhood != null && !existingNeighbourhood.equals(aNeighbourhood))
    {
      existingNeighbourhood.removeProperty(this);
    }
    neighbourhood.addProperty(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfPropertySales()
  {
    return 0;
  }

  public PropertySale addPropertySale(int aSalePrice, String aSeller, String aBuyer)
  {
    return new PropertySale(aSalePrice, aSeller, aBuyer, this);
  }

  public boolean addPropertySale(PropertySale aPropertySale)
  {
    boolean wasAdded = false;
    if (propertySales.contains(aPropertySale)) { return false; }
    Property existingProperty = aPropertySale.getProperty();
    boolean isNewProperty = existingProperty != null && !this.equals(existingProperty);
    if (isNewProperty)
    {
      aPropertySale.setProperty(this);
    }
    else
    {
      propertySales.add(aPropertySale);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePropertySale(PropertySale aPropertySale)
  {
    boolean wasRemoved = false;
    //Unable to remove aPropertySale, as it must always have a property
    if (!this.equals(aPropertySale.getProperty()))
    {
      propertySales.remove(aPropertySale);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPropertySaleAt(PropertySale aPropertySale, int index)
  {  
    boolean wasAdded = false;
    if(addPropertySale(aPropertySale))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPropertySales()) { index = numberOfPropertySales() - 1; }
      propertySales.remove(aPropertySale);
      propertySales.add(index, aPropertySale);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePropertySaleAt(PropertySale aPropertySale, int index)
  {
    boolean wasAdded = false;
    if(propertySales.contains(aPropertySale))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPropertySales()) { index = numberOfPropertySales() - 1; }
      propertySales.remove(aPropertySale);
      propertySales.add(index, aPropertySale);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPropertySaleAt(aPropertySale, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPropertyForSales()
  {
    return 0;
  }

  public PropertyForSale addPropertyForSale(int aListingNumber, int aAskingPrice, Date aDateListedForSale)
  {
    return new PropertyForSale(aListingNumber, aAskingPrice, aDateListedForSale, this);
  }

  public boolean addPropertyForSale(PropertyForSale aPropertyForSale)
  {
    boolean wasAdded = false;
    if (propertyForSales.contains(aPropertyForSale)) { return false; }
    Property existingListedProperty = aPropertyForSale.getListedProperty();
    boolean isNewListedProperty = existingListedProperty != null && !this.equals(existingListedProperty);
    if (isNewListedProperty)
    {
      aPropertyForSale.setListedProperty(this);
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
    //Unable to remove aPropertyForSale, as it must always have a listedProperty
    if (!this.equals(aPropertyForSale.getListedProperty()))
    {
      propertyForSales.remove(aPropertyForSale);
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
    Neighbourhood placeholderNeighbourhood = neighbourhood;
    this.neighbourhood = null;
    placeholderNeighbourhood.removeProperty(this);
    for(int i=propertySales.size(); i > 0; i--)
    {
      PropertySale aPropertySale = propertySales.get(i - 1);
      aPropertySale.delete();
    }
    for(int i=propertyForSales.size(); i > 0; i--)
    {
      PropertyForSale aPropertyForSale = propertyForSales.get(i - 1);
      aPropertyForSale.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberBedrooms" + ":" + getNumberBedrooms()+ "," +
            "numberBathrooms" + ":" + getNumberBathrooms()+ "," +
            "squareFeet" + ":" + getSquareFeet()+ "," +
            "numFloors" + ":" + getNumFloors()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "propertyAddress" + "=" + (getPropertyAddress() != null ? !getPropertyAddress().equals(this)  ? getPropertyAddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "gpsCoord" + "=" + (getGpsCoord() != null ? !getGpsCoord().equals(this)  ? getGpsCoord().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "neighbourhood = "+(getNeighbourhood()!=null?Integer.toHexString(System.identityHashCode(getNeighbourhood())):"null")
     + outputString;
  }
}