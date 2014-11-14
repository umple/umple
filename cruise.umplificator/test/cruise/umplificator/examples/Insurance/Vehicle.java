/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 59 "Insurance.ump"
// line 75 "Insurance.ump"
public class Vehicle extends InsuredProperty
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vehicle Attributes
  private String identificationNumber;
  private String manufacturer;
  private String model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vehicle(String aYearBuilt, PropertyInsurancePolicy aPropertyInsurancePolicy, String aIdentificationNumber, String aManufacturer, String aModel)
  {
    super(aYearBuilt, aPropertyInsurancePolicy);
    identificationNumber = aIdentificationNumber;
    manufacturer = aManufacturer;
    model = aModel;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdentificationNumber(String aIdentificationNumber)
  {
    boolean wasSet = false;
    identificationNumber = aIdentificationNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setManufacturer(String aManufacturer)
  {
    boolean wasSet = false;
    manufacturer = aManufacturer;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(String aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public String getIdentificationNumber()
  {
    return identificationNumber;
  }

  public String getManufacturer()
  {
    return manufacturer;
  }

  public String getModel()
  {
    return model;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "identificationNumber" + ":" + getIdentificationNumber()+ "," +
            "manufacturer" + ":" + getManufacturer()+ "," +
            "model" + ":" + getModel()+ "]"
     + outputString;
  }
}