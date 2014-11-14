/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 127 "DMMModelElementHierarchy.ump"
// line 324 "DMMModelElementHierarchy.ump"
public class InheritsFrom
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InheritsFrom Associations
  private List<DMMClass> inherits;
  private List<DMMClass> transmits;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InheritsFrom()
  {
    inherits = new ArrayList<DMMClass>();
    transmits = new ArrayList<DMMClass>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DMMClass getInherit(int index)
  {
    DMMClass aInherit = inherits.get(index);
    return aInherit;
  }

  public List<DMMClass> getInherits()
  {
    List<DMMClass> newInherits = Collections.unmodifiableList(inherits);
    return newInherits;
  }

  public int numberOfInherits()
  {
    int number = inherits.size();
    return number;
  }

  public boolean hasInherits()
  {
    boolean has = inherits.size() > 0;
    return has;
  }

  public int indexOfInherit(DMMClass aInherit)
  {
    int index = inherits.indexOf(aInherit);
    return index;
  }

  public DMMClass getTransmit(int index)
  {
    DMMClass aTransmit = transmits.get(index);
    return aTransmit;
  }

  public List<DMMClass> getTransmits()
  {
    List<DMMClass> newTransmits = Collections.unmodifiableList(transmits);
    return newTransmits;
  }

  public int numberOfTransmits()
  {
    int number = transmits.size();
    return number;
  }

  public boolean hasTransmits()
  {
    boolean has = transmits.size() > 0;
    return has;
  }

  public int indexOfTransmit(DMMClass aTransmit)
  {
    int index = transmits.indexOf(aTransmit);
    return index;
  }

  public static int minimumNumberOfInherits()
  {
    return 0;
  }

  public DMMClass addInherit(String aVisibility, String aIsSubclassable, InheritsFrom aInherits)
  {
    return new DMMClass(aVisibility, aIsSubclassable, this, aInherits);
  }

  public boolean addInherit(DMMClass aInherit)
  {
    boolean wasAdded = false;
    if (inherits.contains(aInherit)) { return false; }
    InheritsFrom existingTransmits = aInherit.getTransmits();
    boolean isNewTransmits = existingTransmits != null && !this.equals(existingTransmits);
    if (isNewTransmits)
    {
      aInherit.setTransmits(this);
    }
    else
    {
      inherits.add(aInherit);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInherit(DMMClass aInherit)
  {
    boolean wasRemoved = false;
    //Unable to remove aInherit, as it must always have a transmits
    if (!this.equals(aInherit.getTransmits()))
    {
      inherits.remove(aInherit);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInheritAt(DMMClass aInherit, int index)
  {  
    boolean wasAdded = false;
    if(addInherit(aInherit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInherits()) { index = numberOfInherits() - 1; }
      inherits.remove(aInherit);
      inherits.add(index, aInherit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInheritAt(DMMClass aInherit, int index)
  {
    boolean wasAdded = false;
    if(inherits.contains(aInherit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInherits()) { index = numberOfInherits() - 1; }
      inherits.remove(aInherit);
      inherits.add(index, aInherit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInheritAt(aInherit, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTransmits()
  {
    return 0;
  }

  public DMMClass addTransmit(String aVisibility, String aIsSubclassable, InheritsFrom aTransmits)
  {
    return new DMMClass(aVisibility, aIsSubclassable, aTransmits, this);
  }

  public boolean addTransmit(DMMClass aTransmit)
  {
    boolean wasAdded = false;
    if (transmits.contains(aTransmit)) { return false; }
    InheritsFrom existingInherits = aTransmit.getInherits();
    boolean isNewInherits = existingInherits != null && !this.equals(existingInherits);
    if (isNewInherits)
    {
      aTransmit.setInherits(this);
    }
    else
    {
      transmits.add(aTransmit);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransmit(DMMClass aTransmit)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransmit, as it must always have a inherits
    if (!this.equals(aTransmit.getInherits()))
    {
      transmits.remove(aTransmit);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTransmitAt(DMMClass aTransmit, int index)
  {  
    boolean wasAdded = false;
    if(addTransmit(aTransmit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransmits()) { index = numberOfTransmits() - 1; }
      transmits.remove(aTransmit);
      transmits.add(index, aTransmit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransmitAt(DMMClass aTransmit, int index)
  {
    boolean wasAdded = false;
    if(transmits.contains(aTransmit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransmits()) { index = numberOfTransmits() - 1; }
      transmits.remove(aTransmit);
      transmits.add(index, aTransmit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransmitAt(aTransmit, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=inherits.size(); i > 0; i--)
    {
      DMMClass aInherit = inherits.get(i - 1);
      aInherit.delete();
    }
    for(int i=transmits.size(); i > 0; i--)
    {
      DMMClass aTransmit = transmits.get(i - 1);
      aTransmit.delete();
    }
  }

}