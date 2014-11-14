/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 25 "DMMModelElementHierarchy.ump"
// line 185 "DMMModelElementHierarchy.ump"
public class BehaviouralElement extends ModelElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BehaviouralElement Associations
  private List<Invokes> invoked;
  private List<Invokes> invokes;
  private List<Accesses> accesses;
  private List<IsParameterOf> isParameterOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BehaviouralElement(String aVisibility)
  {
    super(aVisibility);
    invoked = new ArrayList<Invokes>();
    invokes = new ArrayList<Invokes>();
    accesses = new ArrayList<Accesses>();
    isParameterOfs = new ArrayList<IsParameterOf>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Invokes getInvoked(int index)
  {
    Invokes aInvoked = invoked.get(index);
    return aInvoked;
  }

  public List<Invokes> getInvoked()
  {
    List<Invokes> newInvoked = Collections.unmodifiableList(invoked);
    return newInvoked;
  }

  public int numberOfInvoked()
  {
    int number = invoked.size();
    return number;
  }

  public boolean hasInvoked()
  {
    boolean has = invoked.size() > 0;
    return has;
  }

  public int indexOfInvoked(Invokes aInvoked)
  {
    int index = invoked.indexOf(aInvoked);
    return index;
  }

  public Invokes getInvoke(int index)
  {
    Invokes aInvoke = invokes.get(index);
    return aInvoke;
  }

  public List<Invokes> getInvokes()
  {
    List<Invokes> newInvokes = Collections.unmodifiableList(invokes);
    return newInvokes;
  }

  public int numberOfInvokes()
  {
    int number = invokes.size();
    return number;
  }

  public boolean hasInvokes()
  {
    boolean has = invokes.size() > 0;
    return has;
  }

  public int indexOfInvoke(Invokes aInvoke)
  {
    int index = invokes.indexOf(aInvoke);
    return index;
  }

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

  public IsParameterOf getIsParameterOf(int index)
  {
    IsParameterOf aIsParameterOf = isParameterOfs.get(index);
    return aIsParameterOf;
  }

  public List<IsParameterOf> getIsParameterOfs()
  {
    List<IsParameterOf> newIsParameterOfs = Collections.unmodifiableList(isParameterOfs);
    return newIsParameterOfs;
  }

  public int numberOfIsParameterOfs()
  {
    int number = isParameterOfs.size();
    return number;
  }

  public boolean hasIsParameterOfs()
  {
    boolean has = isParameterOfs.size() > 0;
    return has;
  }

  public int indexOfIsParameterOf(IsParameterOf aIsParameterOf)
  {
    int index = isParameterOfs.indexOf(aIsParameterOf);
    return index;
  }

  public static int minimumNumberOfInvoked()
  {
    return 0;
  }

  public Invokes addInvoked(BehaviouralElement aInvoked)
  {
    return new Invokes(this, aInvoked);
  }

  public boolean addInvoked(Invokes aInvoked)
  {
    boolean wasAdded = false;
    if (invoked.contains(aInvoked)) { return false; }
    if (invoked.contains(aInvoked)) { return false; }
    if (invoked.contains(aInvoked)) { return false; }
    if (invoked.contains(aInvoked)) { return false; }
    BehaviouralElement existingInvokes = aInvoked.getInvokes();
    boolean isNewInvokes = existingInvokes != null && !this.equals(existingInvokes);
    if (isNewInvokes)
    {
      aInvoked.setInvokes(this);
    }
    else
    {
      invoked.add(aInvoked);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInvoked(Invokes aInvoked)
  {
    boolean wasRemoved = false;
    //Unable to remove aInvoked, as it must always have a invokes
    if (!this.equals(aInvoked.getInvokes()))
    {
      invoked.remove(aInvoked);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInvokedAt(Invokes aInvoked, int index)
  {  
    boolean wasAdded = false;
    if(addInvoked(aInvoked))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvoked()) { index = numberOfInvoked() - 1; }
      invoked.remove(aInvoked);
      invoked.add(index, aInvoked);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInvokedAt(Invokes aInvoked, int index)
  {
    boolean wasAdded = false;
    if(invoked.contains(aInvoked))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvoked()) { index = numberOfInvoked() - 1; }
      invoked.remove(aInvoked);
      invoked.add(index, aInvoked);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInvokedAt(aInvoked, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfInvokes()
  {
    return 0;
  }

  public Invokes addInvoke(BehaviouralElement aInvokes)
  {
    return new Invokes(aInvokes, this);
  }

  public boolean addInvoke(Invokes aInvoke)
  {
    boolean wasAdded = false;
    if (invokes.contains(aInvoke)) { return false; }
    if (invokes.contains(aInvoke)) { return false; }
    if (invokes.contains(aInvoke)) { return false; }
    if (invokes.contains(aInvoke)) { return false; }
    BehaviouralElement existingInvoked = aInvoke.getInvoked();
    boolean isNewInvoked = existingInvoked != null && !this.equals(existingInvoked);
    if (isNewInvoked)
    {
      aInvoke.setInvoked(this);
    }
    else
    {
      invokes.add(aInvoke);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInvoke(Invokes aInvoke)
  {
    boolean wasRemoved = false;
    //Unable to remove aInvoke, as it must always have a invoked
    if (!this.equals(aInvoke.getInvoked()))
    {
      invokes.remove(aInvoke);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInvokeAt(Invokes aInvoke, int index)
  {  
    boolean wasAdded = false;
    if(addInvoke(aInvoke))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvokes()) { index = numberOfInvokes() - 1; }
      invokes.remove(aInvoke);
      invokes.add(index, aInvoke);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInvokeAt(Invokes aInvoke, int index)
  {
    boolean wasAdded = false;
    if(invokes.contains(aInvoke))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvokes()) { index = numberOfInvokes() - 1; }
      invokes.remove(aInvoke);
      invokes.add(index, aInvoke);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInvokeAt(aInvoke, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAccesses()
  {
    return 0;
  }

  public Accesses addAccess(StructuralElement aStructuralElement)
  {
    return new Accesses(this, aStructuralElement);
  }

  public boolean addAccess(Accesses aAccess)
  {
    boolean wasAdded = false;
    if (accesses.contains(aAccess)) { return false; }
    if (accesses.contains(aAccess)) { return false; }
    if (accesses.contains(aAccess)) { return false; }
    if (accesses.contains(aAccess)) { return false; }
    BehaviouralElement existingBehaviouralElement = aAccess.getBehaviouralElement();
    boolean isNewBehaviouralElement = existingBehaviouralElement != null && !this.equals(existingBehaviouralElement);
    if (isNewBehaviouralElement)
    {
      aAccess.setBehaviouralElement(this);
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
    //Unable to remove aAccess, as it must always have a behaviouralElement
    if (!this.equals(aAccess.getBehaviouralElement()))
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

  public static int minimumNumberOfIsParameterOfs()
  {
    return 0;
  }

  public IsParameterOf addIsParameterOf(FormalParameter aFormalParameter)
  {
    return new IsParameterOf(aFormalParameter, this);
  }

  public boolean addIsParameterOf(IsParameterOf aIsParameterOf)
  {
    boolean wasAdded = false;
    if (isParameterOfs.contains(aIsParameterOf)) { return false; }
    if (isParameterOfs.contains(aIsParameterOf)) { return false; }
    if (isParameterOfs.contains(aIsParameterOf)) { return false; }
    if (isParameterOfs.contains(aIsParameterOf)) { return false; }
    BehaviouralElement existingBehaviouralElement = aIsParameterOf.getBehaviouralElement();
    boolean isNewBehaviouralElement = existingBehaviouralElement != null && !this.equals(existingBehaviouralElement);
    if (isNewBehaviouralElement)
    {
      aIsParameterOf.setBehaviouralElement(this);
    }
    else
    {
      isParameterOfs.add(aIsParameterOf);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsParameterOf(IsParameterOf aIsParameterOf)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsParameterOf, as it must always have a behaviouralElement
    if (!this.equals(aIsParameterOf.getBehaviouralElement()))
    {
      isParameterOfs.remove(aIsParameterOf);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsParameterOfAt(IsParameterOf aIsParameterOf, int index)
  {  
    boolean wasAdded = false;
    if(addIsParameterOf(aIsParameterOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsParameterOfs()) { index = numberOfIsParameterOfs() - 1; }
      isParameterOfs.remove(aIsParameterOf);
      isParameterOfs.add(index, aIsParameterOf);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsParameterOfAt(IsParameterOf aIsParameterOf, int index)
  {
    boolean wasAdded = false;
    if(isParameterOfs.contains(aIsParameterOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsParameterOfs()) { index = numberOfIsParameterOfs() - 1; }
      isParameterOfs.remove(aIsParameterOf);
      isParameterOfs.add(index, aIsParameterOf);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsParameterOfAt(aIsParameterOf, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=invoked.size(); i > 0; i--)
    {
      Invokes aInvoked = invoked.get(i - 1);
      aInvoked.delete();
    }
    for(int i=invokes.size(); i > 0; i--)
    {
      Invokes aInvoke = invokes.get(i - 1);
      aInvoke.delete();
    }
    for(int i=accesses.size(); i > 0; i--)
    {
      Accesses aAccess = accesses.get(i - 1);
      aAccess.delete();
    }
    for(int i=isParameterOfs.size(); i > 0; i--)
    {
      IsParameterOf aIsParameterOf = isParameterOfs.get(i - 1);
      aIsParameterOf.delete();
    }
    super.delete();
  }

}