/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 5 "realestate.ump"
// line 95 "realestate.ump"
public class Address
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Address Attributes
  private int numberOnStreet;
  private int apartmentOrUnit;
  private String street;
  private String city;
  private String postalCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Address(int aNumberOnStreet, int aApartmentOrUnit, String aStreet, String aCity, String aPostalCode)
  {
    numberOnStreet = aNumberOnStreet;
    apartmentOrUnit = aApartmentOrUnit;
    street = aStreet;
    city = aCity;
    postalCode = aPostalCode;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOnStreet(int aNumberOnStreet)
  {
    boolean wasSet = false;
    numberOnStreet = aNumberOnStreet;
    wasSet = true;
    return wasSet;
  }

  public boolean setApartmentOrUnit(int aApartmentOrUnit)
  {
    boolean wasSet = false;
    apartmentOrUnit = aApartmentOrUnit;
    wasSet = true;
    return wasSet;
  }

  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }

  public int getNumberOnStreet()
  {
    return numberOnStreet;
  }

  public int getApartmentOrUnit()
  {
    return apartmentOrUnit;
  }

  public String getStreet()
  {
    return street;
  }

  public String getCity()
  {
    return city;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "numberOnStreet" + ":" + getNumberOnStreet()+ "," +
            "apartmentOrUnit" + ":" + getApartmentOrUnit()+ "," +
            "street" + ":" + getStreet()+ "," +
            "city" + ":" + getCity()+ "," +
            "postalCode" + ":" + getPostalCode()+ "]"
     + outputString;
  }
}