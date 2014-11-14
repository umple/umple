/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 87 "DMMExtensionCTF.ump"
// line 177 "DMMExtensionCTF.ump"
public class CTFClass
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CTFClass Associations
  private List<CTFObject> instancedBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CTFClass()
  {
    instancedBy = new ArrayList<CTFObject>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public CTFObject getInstancedBy(int index)
  {
    CTFObject aInstancedBy = instancedBy.get(index);
    return aInstancedBy;
  }

  public List<CTFObject> getInstancedBy()
  {
    List<CTFObject> newInstancedBy = Collections.unmodifiableList(instancedBy);
    return newInstancedBy;
  }

  public int numberOfInstancedBy()
  {
    int number = instancedBy.size();
    return number;
  }

  public boolean hasInstancedBy()
  {
    boolean has = instancedBy.size() > 0;
    return has;
  }

  public int indexOfInstancedBy(CTFObject aInstancedBy)
  {
    int index = instancedBy.indexOf(aInstancedBy);
    return index;
  }

  public static int minimumNumberOfInstancedBy()
  {
    return 0;
  }

  public boolean addInstancedBy(CTFObject aInstancedBy)
  {
    boolean wasAdded = false;
    if (instancedBy.contains(aInstancedBy)) { return false; }
    CTFClass existingInstanceOf = aInstancedBy.getInstanceOf();
    if (existingInstanceOf == null)
    {
      aInstancedBy.setInstanceOf(this);
    }
    else if (!this.equals(existingInstanceOf))
    {
      existingInstanceOf.removeInstancedBy(aInstancedBy);
      addInstancedBy(aInstancedBy);
    }
    else
    {
      instancedBy.add(aInstancedBy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInstancedBy(CTFObject aInstancedBy)
  {
    boolean wasRemoved = false;
    if (instancedBy.contains(aInstancedBy))
    {
      instancedBy.remove(aInstancedBy);
      aInstancedBy.setInstanceOf(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInstancedByAt(CTFObject aInstancedBy, int index)
  {  
    boolean wasAdded = false;
    if(addInstancedBy(aInstancedBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInstancedBy()) { index = numberOfInstancedBy() - 1; }
      instancedBy.remove(aInstancedBy);
      instancedBy.add(index, aInstancedBy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInstancedByAt(CTFObject aInstancedBy, int index)
  {
    boolean wasAdded = false;
    if(instancedBy.contains(aInstancedBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInstancedBy()) { index = numberOfInstancedBy() - 1; }
      instancedBy.remove(aInstancedBy);
      instancedBy.add(index, aInstancedBy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInstancedByAt(aInstancedBy, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !instancedBy.isEmpty() )
    {
      instancedBy.get(0).setInstanceOf(null);
    }
  }

}