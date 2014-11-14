/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 48 "Insurance.ump"
// line 95 "Insurance.ump"
public class InsuredProperty
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InsuredProperty Attributes
  private String yearBuilt;

  //InsuredProperty Associations
  private PropertyInsurancePolicy propertyInsurancePolicy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InsuredProperty(String aYearBuilt, PropertyInsurancePolicy aPropertyInsurancePolicy)
  {
    yearBuilt = aYearBuilt;
    if (aPropertyInsurancePolicy == null || aPropertyInsurancePolicy.getInsuredProperty() != null)
    {
      throw new RuntimeException("Unable to create InsuredProperty due to aPropertyInsurancePolicy");
    }
    propertyInsurancePolicy = aPropertyInsurancePolicy;
  }

  public InsuredProperty(String aYearBuilt, String aPolicyNumberForPropertyInsurancePolicy, String aMonthlyPremiumForPropertyInsurancePolicy, String aStarDateForPropertyInsurancePolicy, String aEndDateForPropertyInsurancePolicy, String aInsuradValueForPropertyInsurancePolicy, Person aHolderForPropertyInsurancePolicy)
  {
    yearBuilt = aYearBuilt;
    propertyInsurancePolicy = new PropertyInsurancePolicy(aPolicyNumberForPropertyInsurancePolicy, aMonthlyPremiumForPropertyInsurancePolicy, aStarDateForPropertyInsurancePolicy, aEndDateForPropertyInsurancePolicy, aInsuradValueForPropertyInsurancePolicy, aHolderForPropertyInsurancePolicy, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setYearBuilt(String aYearBuilt)
  {
    boolean wasSet = false;
    yearBuilt = aYearBuilt;
    wasSet = true;
    return wasSet;
  }

  public String getYearBuilt()
  {
    return yearBuilt;
  }

  public PropertyInsurancePolicy getPropertyInsurancePolicy()
  {
    return propertyInsurancePolicy;
  }

  public void delete()
  {
    PropertyInsurancePolicy existingPropertyInsurancePolicy = propertyInsurancePolicy;
    propertyInsurancePolicy = null;
    if (existingPropertyInsurancePolicy != null)
    {
      existingPropertyInsurancePolicy.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "yearBuilt" + ":" + getYearBuilt()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "propertyInsurancePolicy = "+(getPropertyInsurancePolicy()!=null?Integer.toHexString(System.identityHashCode(getPropertyInsurancePolicy())):"null")
     + outputString;
  }
}