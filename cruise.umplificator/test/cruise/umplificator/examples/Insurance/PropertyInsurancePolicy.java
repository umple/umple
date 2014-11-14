/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 44 "Insurance.ump"
// line 101 "Insurance.ump"
public class PropertyInsurancePolicy extends InsurancePolicy
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PropertyInsurancePolicy Associations
  private InsuredProperty insuredProperty;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PropertyInsurancePolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue, Person aHolder, InsuredProperty aInsuredProperty)
  {
    super(aPolicyNumber, aMonthlyPremium, aStarDate, aEndDate, aInsuradValue, aHolder);
    if (aInsuredProperty == null || aInsuredProperty.getPropertyInsurancePolicy() != null)
    {
      throw new RuntimeException("Unable to create PropertyInsurancePolicy due to aInsuredProperty");
    }
    insuredProperty = aInsuredProperty;
  }

  public PropertyInsurancePolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue, Person aHolder, String aYearBuiltForInsuredProperty)
  {
    super(aPolicyNumber, aMonthlyPremium, aStarDate, aEndDate, aInsuradValue, aHolder);
    insuredProperty = new InsuredProperty(aYearBuiltForInsuredProperty, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public InsuredProperty getInsuredProperty()
  {
    return insuredProperty;
  }

  public void delete()
  {
    InsuredProperty existingInsuredProperty = insuredProperty;
    insuredProperty = null;
    if (existingInsuredProperty != null)
    {
      existingInsuredProperty.delete();
    }
    super.delete();
  }

}