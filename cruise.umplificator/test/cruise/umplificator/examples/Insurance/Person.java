/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 32 "Insurance.ump"
// line 80 "Insurance.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String address;
  private String dateOfBirth;

  //Person Associations
  private List<InsurancePolicy> insurancePolicies;
  private List<LifeInsurancePolicy> policy;
  private List<LifeInsurancePolicy> lifeInsurancePolicies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, String aAddress, String aDateOfBirth)
  {
    name = aName;
    address = aAddress;
    dateOfBirth = aDateOfBirth;
    insurancePolicies = new ArrayList<InsurancePolicy>();
    policy = new ArrayList<LifeInsurancePolicy>();
    lifeInsurancePolicies = new ArrayList<LifeInsurancePolicy>();
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

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfBirth(String aDateOfBirth)
  {
    boolean wasSet = false;
    dateOfBirth = aDateOfBirth;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getDateOfBirth()
  {
    return dateOfBirth;
  }

  public InsurancePolicy getInsurancePolicy(int index)
  {
    InsurancePolicy aInsurancePolicy = insurancePolicies.get(index);
    return aInsurancePolicy;
  }

  public List<InsurancePolicy> getInsurancePolicies()
  {
    List<InsurancePolicy> newInsurancePolicies = Collections.unmodifiableList(insurancePolicies);
    return newInsurancePolicies;
  }

  public int numberOfInsurancePolicies()
  {
    int number = insurancePolicies.size();
    return number;
  }

  public boolean hasInsurancePolicies()
  {
    boolean has = insurancePolicies.size() > 0;
    return has;
  }

  public int indexOfInsurancePolicy(InsurancePolicy aInsurancePolicy)
  {
    int index = insurancePolicies.indexOf(aInsurancePolicy);
    return index;
  }

  public LifeInsurancePolicy getPolicy(int index)
  {
    LifeInsurancePolicy aPolicy = policy.get(index);
    return aPolicy;
  }

  public List<LifeInsurancePolicy> getPolicy()
  {
    List<LifeInsurancePolicy> newPolicy = Collections.unmodifiableList(policy);
    return newPolicy;
  }

  public int numberOfPolicy()
  {
    int number = policy.size();
    return number;
  }

  public boolean hasPolicy()
  {
    boolean has = policy.size() > 0;
    return has;
  }

  public int indexOfPolicy(LifeInsurancePolicy aPolicy)
  {
    int index = policy.indexOf(aPolicy);
    return index;
  }

  public LifeInsurancePolicy getLifeInsurancePolicy(int index)
  {
    LifeInsurancePolicy aLifeInsurancePolicy = lifeInsurancePolicies.get(index);
    return aLifeInsurancePolicy;
  }

  public List<LifeInsurancePolicy> getLifeInsurancePolicies()
  {
    List<LifeInsurancePolicy> newLifeInsurancePolicies = Collections.unmodifiableList(lifeInsurancePolicies);
    return newLifeInsurancePolicies;
  }

  public int numberOfLifeInsurancePolicies()
  {
    int number = lifeInsurancePolicies.size();
    return number;
  }

  public boolean hasLifeInsurancePolicies()
  {
    boolean has = lifeInsurancePolicies.size() > 0;
    return has;
  }

  public int indexOfLifeInsurancePolicy(LifeInsurancePolicy aLifeInsurancePolicy)
  {
    int index = lifeInsurancePolicies.indexOf(aLifeInsurancePolicy);
    return index;
  }

  public static int minimumNumberOfInsurancePolicies()
  {
    return 0;
  }

  public InsurancePolicy addInsurancePolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue)
  {
    return new InsurancePolicy(aPolicyNumber, aMonthlyPremium, aStarDate, aEndDate, aInsuradValue, this);
  }

  public boolean addInsurancePolicy(InsurancePolicy aInsurancePolicy)
  {
    boolean wasAdded = false;
    if (insurancePolicies.contains(aInsurancePolicy)) { return false; }
    Person existingHolder = aInsurancePolicy.getHolder();
    boolean isNewHolder = existingHolder != null && !this.equals(existingHolder);
    if (isNewHolder)
    {
      aInsurancePolicy.setHolder(this);
    }
    else
    {
      insurancePolicies.add(aInsurancePolicy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInsurancePolicy(InsurancePolicy aInsurancePolicy)
  {
    boolean wasRemoved = false;
    //Unable to remove aInsurancePolicy, as it must always have a holder
    if (!this.equals(aInsurancePolicy.getHolder()))
    {
      insurancePolicies.remove(aInsurancePolicy);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInsurancePolicyAt(InsurancePolicy aInsurancePolicy, int index)
  {  
    boolean wasAdded = false;
    if(addInsurancePolicy(aInsurancePolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInsurancePolicies()) { index = numberOfInsurancePolicies() - 1; }
      insurancePolicies.remove(aInsurancePolicy);
      insurancePolicies.add(index, aInsurancePolicy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInsurancePolicyAt(InsurancePolicy aInsurancePolicy, int index)
  {
    boolean wasAdded = false;
    if(insurancePolicies.contains(aInsurancePolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInsurancePolicies()) { index = numberOfInsurancePolicies() - 1; }
      insurancePolicies.remove(aInsurancePolicy);
      insurancePolicies.add(index, aInsurancePolicy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInsurancePolicyAt(aInsurancePolicy, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPolicy()
  {
    return 0;
  }

  public LifeInsurancePolicy addPolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue, Person aHolder)
  {
    return new LifeInsurancePolicy(aPolicyNumber, aMonthlyPremium, aStarDate, aEndDate, aInsuradValue, aHolder, this);
  }

  public boolean addPolicy(LifeInsurancePolicy aPolicy)
  {
    boolean wasAdded = false;
    if (policy.contains(aPolicy)) { return false; }
    Person existingInsuredLife = aPolicy.getInsuredLife();
    boolean isNewInsuredLife = existingInsuredLife != null && !this.equals(existingInsuredLife);
    if (isNewInsuredLife)
    {
      aPolicy.setInsuredLife(this);
    }
    else
    {
      policy.add(aPolicy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePolicy(LifeInsurancePolicy aPolicy)
  {
    boolean wasRemoved = false;
    //Unable to remove aPolicy, as it must always have a insuredLife
    if (!this.equals(aPolicy.getInsuredLife()))
    {
      policy.remove(aPolicy);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPolicyAt(LifeInsurancePolicy aPolicy, int index)
  {  
    boolean wasAdded = false;
    if(addPolicy(aPolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPolicy()) { index = numberOfPolicy() - 1; }
      policy.remove(aPolicy);
      policy.add(index, aPolicy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePolicyAt(LifeInsurancePolicy aPolicy, int index)
  {
    boolean wasAdded = false;
    if(policy.contains(aPolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPolicy()) { index = numberOfPolicy() - 1; }
      policy.remove(aPolicy);
      policy.add(index, aPolicy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPolicyAt(aPolicy, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfLifeInsurancePolicies()
  {
    return 0;
  }

  public boolean addLifeInsurancePolicy(LifeInsurancePolicy aLifeInsurancePolicy)
  {
    boolean wasAdded = false;
    if (lifeInsurancePolicies.contains(aLifeInsurancePolicy)) { return false; }
    lifeInsurancePolicies.add(aLifeInsurancePolicy);
    if (aLifeInsurancePolicy.indexOfBeneficiary(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aLifeInsurancePolicy.addBeneficiary(this);
      if (!wasAdded)
      {
        lifeInsurancePolicies.remove(aLifeInsurancePolicy);
      }
    }
    return wasAdded;
  }

  public boolean removeLifeInsurancePolicy(LifeInsurancePolicy aLifeInsurancePolicy)
  {
    boolean wasRemoved = false;
    if (!lifeInsurancePolicies.contains(aLifeInsurancePolicy))
    {
      return wasRemoved;
    }

    int oldIndex = lifeInsurancePolicies.indexOf(aLifeInsurancePolicy);
    lifeInsurancePolicies.remove(oldIndex);
    if (aLifeInsurancePolicy.indexOfBeneficiary(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aLifeInsurancePolicy.removeBeneficiary(this);
      if (!wasRemoved)
      {
        lifeInsurancePolicies.add(oldIndex,aLifeInsurancePolicy);
      }
    }
    return wasRemoved;
  }

  public boolean addLifeInsurancePolicyAt(LifeInsurancePolicy aLifeInsurancePolicy, int index)
  {  
    boolean wasAdded = false;
    if(addLifeInsurancePolicy(aLifeInsurancePolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLifeInsurancePolicies()) { index = numberOfLifeInsurancePolicies() - 1; }
      lifeInsurancePolicies.remove(aLifeInsurancePolicy);
      lifeInsurancePolicies.add(index, aLifeInsurancePolicy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLifeInsurancePolicyAt(LifeInsurancePolicy aLifeInsurancePolicy, int index)
  {
    boolean wasAdded = false;
    if(lifeInsurancePolicies.contains(aLifeInsurancePolicy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLifeInsurancePolicies()) { index = numberOfLifeInsurancePolicies() - 1; }
      lifeInsurancePolicies.remove(aLifeInsurancePolicy);
      lifeInsurancePolicies.add(index, aLifeInsurancePolicy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLifeInsurancePolicyAt(aLifeInsurancePolicy, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=insurancePolicies.size(); i > 0; i--)
    {
      InsurancePolicy aInsurancePolicy = insurancePolicies.get(i - 1);
      aInsurancePolicy.delete();
    }
    for(int i=policy.size(); i > 0; i--)
    {
      LifeInsurancePolicy aPolicy = policy.get(i - 1);
      aPolicy.delete();
    }
    ArrayList<LifeInsurancePolicy> copyOfLifeInsurancePolicies = new ArrayList<LifeInsurancePolicy>(lifeInsurancePolicies);
    lifeInsurancePolicies.clear();
    for(LifeInsurancePolicy aLifeInsurancePolicy : copyOfLifeInsurancePolicies)
    {
      aLifeInsurancePolicy.removeBeneficiary(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "dateOfBirth" + ":" + getDateOfBirth()+ "]"
     + outputString;
  }
}