/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 21 "DMMModelElementHierarchy.ump"
// line 241 "DMMModelElementHierarchy.ump"
public class StructuralElement extends ModelElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StructuralElement Associations
  private List<Accesses> accesses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StructuralElement(String aVisibility)
  {
    super(aVisibility);
    accesses = new ArrayList<Accesses>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Accesses getAccess(int index)
  {
    Accesses aAccess = accesses.get(index);
    return aAccess;
  }

  public List<Accesses> getAccesses()
  {
    List<Accesses> newAccesses = Collections.unmodifiableList(accesses);
    return newAccesses;
  }

  public int numberOfAccesses()
  {
    int number = accesses.size();
    return number;
  }

  public boolean hasAccesses()
  {
    boolean has = accesses.size() > 0;
    return has;
  }

  public int indexOfAccess(Accesses aAccess)
  {
    int index = accesses.indexOf(aAccess);
    return index;
  }

  public static int minimumNumberOfAccesses()
  {
    return 0;
  }

  public Accesses addAccess(BehaviouralElement aBehaviouralElement)
  {
    return new Accesses(aBehaviouralElement, this);
  }

  public boolean addAccess(Accesses aAccess)
  {
    boolean wasAdded = false;
    if (accesses.contains(aAccess)) { return false; }
    if (accesses.contains(aAccess)) { return false; }
    if (accesses.contains(aAccess)) { return false; }
    StructuralElement existingStructuralElement = aAccess.getStructuralElement();
    boolean isNewStructuralElement = existingStructuralElement != null && !this.equals(existingStructuralElement);
    if (isNewStructuralElement)
    {
      aAccess.setStructuralElement(this);
    }
    else
    {
      accesses.add(aAccess);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccess(Accesses aAccess)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccess, as it must always have a structuralElement
    if (!this.equals(aAccess.getStructuralElement()))
    {
      accesses.remove(aAccess);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccessAt(Accesses aAccess, int index)
  {  
    boolean wasAdded = false;
    if(addAccess(aAccess))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccesses()) { index = numberOfAccesses() - 1; }
      accesses.remove(aAccess);
      accesses.add(index, aAccess);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccessAt(Accesses aAccess, int index)
  {
    boolean wasAdded = false;
    if(accesses.contains(aAccess))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccesses()) { index = numberOfAccesses() - 1; }
      accesses.remove(aAccess);
      accesses.add(index, aAccess);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccessAt(aAccess, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accesses.size(); i > 0; i--)
    {
      Accesses aAccess = accesses.get(i - 1);
      aAccess.delete();
    }
    super.delete();
  }

}