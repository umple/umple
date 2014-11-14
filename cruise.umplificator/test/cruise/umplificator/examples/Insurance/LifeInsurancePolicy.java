/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 38 "Insurance.ump"
// line 106 "Insurance.ump"
public class LifeInsurancePolicy extends InsurancePolicy
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LifeInsurancePolicy Associations
  private Person insuredLife;
  private List<Person> beneficiary;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LifeInsurancePolicy(String aPolicyNumber, String aMonthlyPremium, String aStarDate, String aEndDate, String aInsuradValue, Person aHolder, Person aInsuredLife)
  {
    super(aPolicyNumber, aMonthlyPremium, aStarDate, aEndDate, aInsuradValue, aHolder);
    boolean didAddInsuredLife = setInsuredLife(aInsuredLife);
    if (!didAddInsuredLife)
    {
      throw new RuntimeException("Unable to create policy due to insuredLife");
    }
    beneficiary = new ArrayList<Person>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Person getInsuredLife()
  {
    return insuredLife;
  }

  public Person getBeneficiary(int index)
  {
    Person aBeneficiary = beneficiary.get(index);
    return aBeneficiary;
  }

  public List<Person> getBeneficiary()
  {
    List<Person> newBeneficiary = Collections.unmodifiableList(beneficiary);
    return newBeneficiary;
  }

  public int numberOfBeneficiary()
  {
    int number = beneficiary.size();
    return number;
  }

  public boolean hasBeneficiary()
  {
    boolean has = beneficiary.size() > 0;
    return has;
  }

  public int indexOfBeneficiary(Person aBeneficiary)
  {
    int index = beneficiary.indexOf(aBeneficiary);
    return index;
  }

  public boolean setInsuredLife(Person aInsuredLife)
  {
    boolean wasSet = false;
    if (aInsuredLife == null)
    {
      return wasSet;
    }

    Person existingInsuredLife = insuredLife;
    insuredLife = aInsuredLife;
    if (existingInsuredLife != null && !existingInsuredLife.equals(aInsuredLife))
    {
      existingInsuredLife.removePolicy(this);
    }
    insuredLife.addPolicy(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfBeneficiary()
  {
    return 0;
  }

  public boolean addBeneficiary(Person aBeneficiary)
  {
    boolean wasAdded = false;
    if (beneficiary.contains(aBeneficiary)) { return false; }
    beneficiary.add(aBeneficiary);
    if (aBeneficiary.indexOfLifeInsurancePolicy(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBeneficiary.addLifeInsurancePolicy(this);
      if (!wasAdded)
      {
        beneficiary.remove(aBeneficiary);
      }
    }
    return wasAdded;
  }

  public boolean removeBeneficiary(Person aBeneficiary)
  {
    boolean wasRemoved = false;
    if (!beneficiary.contains(aBeneficiary))
    {
      return wasRemoved;
    }

    int oldIndex = beneficiary.indexOf(aBeneficiary);
    beneficiary.remove(oldIndex);
    if (aBeneficiary.indexOfLifeInsurancePolicy(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBeneficiary.removeLifeInsurancePolicy(this);
      if (!wasRemoved)
      {
        beneficiary.add(oldIndex,aBeneficiary);
      }
    }
    return wasRemoved;
  }

  public boolean addBeneficiaryAt(Person aBeneficiary, int index)
  {  
    boolean wasAdded = false;
    if(addBeneficiary(aBeneficiary))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBeneficiary()) { index = numberOfBeneficiary() - 1; }
      beneficiary.remove(aBeneficiary);
      beneficiary.add(index, aBeneficiary);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBeneficiaryAt(Person aBeneficiary, int index)
  {
    boolean wasAdded = false;
    if(beneficiary.contains(aBeneficiary))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBeneficiary()) { index = numberOfBeneficiary() - 1; }
      beneficiary.remove(aBeneficiary);
      beneficiary.add(index, aBeneficiary);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBeneficiaryAt(aBeneficiary, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Person placeholderInsuredLife = insuredLife;
    this.insuredLife = null;
    placeholderInsuredLife.removePolicy(this);
    ArrayList<Person> copyOfBeneficiary = new ArrayList<Person>(beneficiary);
    beneficiary.clear();
    for(Person aBeneficiary : copyOfBeneficiary)
    {
      aBeneficiary.removeLifeInsurancePolicy(this);
    }
    super.delete();
  }

}