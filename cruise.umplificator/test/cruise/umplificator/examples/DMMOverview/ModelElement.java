/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 44 "DMMOverview.ump"
// line 84 "DMMOverview.ump"
public class ModelElement extends ModelObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ModelElement Associations
  private List<ModelRelationship> toModelRel1;
  private List<ModelRelationship> toModelRel2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ModelElement(String aName)
  {
    super(aName);
    toModelRel1 = new ArrayList<ModelRelationship>();
    toModelRel2 = new ArrayList<ModelRelationship>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ModelRelationship getToModelRel1(int index)
  {
    ModelRelationship aToModelRel1 = toModelRel1.get(index);
    return aToModelRel1;
  }

  public List<ModelRelationship> getToModelRel1()
  {
    List<ModelRelationship> newToModelRel1 = Collections.unmodifiableList(toModelRel1);
    return newToModelRel1;
  }

  public int numberOfToModelRel1()
  {
    int number = toModelRel1.size();
    return number;
  }

  public boolean hasToModelRel1()
  {
    boolean has = toModelRel1.size() > 0;
    return has;
  }

  public int indexOfToModelRel1(ModelRelationship aToModelRel1)
  {
    int index = toModelRel1.indexOf(aToModelRel1);
    return index;
  }

  public ModelRelationship getToModelRel2(int index)
  {
    ModelRelationship aToModelRel2 = toModelRel2.get(index);
    return aToModelRel2;
  }

  public List<ModelRelationship> getToModelRel2()
  {
    List<ModelRelationship> newToModelRel2 = Collections.unmodifiableList(toModelRel2);
    return newToModelRel2;
  }

  public int numberOfToModelRel2()
  {
    int number = toModelRel2.size();
    return number;
  }

  public boolean hasToModelRel2()
  {
    boolean has = toModelRel2.size() > 0;
    return has;
  }

  public int indexOfToModelRel2(ModelRelationship aToModelRel2)
  {
    int index = toModelRel2.indexOf(aToModelRel2);
    return index;
  }

  public static int minimumNumberOfToModelRel1()
  {
    return 0;
  }

  public ModelRelationship addToModelRel1(String aName, ModelElement aToModelElem2, RelationshipInModel aRelationshipInModel)
  {
    return new ModelRelationship(aName, this, aToModelElem2, aRelationshipInModel);
  }

  public boolean addToModelRel1(ModelRelationship aToModelRel1)
  {
    boolean wasAdded = false;
    if (toModelRel1.contains(aToModelRel1)) { return false; }
    ModelElement existingToModelElem1 = aToModelRel1.getToModelElem1();
    boolean isNewToModelElem1 = existingToModelElem1 != null && !this.equals(existingToModelElem1);
    if (isNewToModelElem1)
    {
      aToModelRel1.setToModelElem1(this);
    }
    else
    {
      toModelRel1.add(aToModelRel1);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeToModelRel1(ModelRelationship aToModelRel1)
  {
    boolean wasRemoved = false;
    //Unable to remove aToModelRel1, as it must always have a toModelElem1
    if (!this.equals(aToModelRel1.getToModelElem1()))
    {
      toModelRel1.remove(aToModelRel1);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addToModelRel1At(ModelRelationship aToModelRel1, int index)
  {  
    boolean wasAdded = false;
    if(addToModelRel1(aToModelRel1))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToModelRel1()) { index = numberOfToModelRel1() - 1; }
      toModelRel1.remove(aToModelRel1);
      toModelRel1.add(index, aToModelRel1);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToModelRel1At(ModelRelationship aToModelRel1, int index)
  {
    boolean wasAdded = false;
    if(toModelRel1.contains(aToModelRel1))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToModelRel1()) { index = numberOfToModelRel1() - 1; }
      toModelRel1.remove(aToModelRel1);
      toModelRel1.add(index, aToModelRel1);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToModelRel1At(aToModelRel1, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfToModelRel2()
  {
    return 0;
  }

  public ModelRelationship addToModelRel2(String aName, ModelElement aToModelElem1, RelationshipInModel aRelationshipInModel)
  {
    return new ModelRelationship(aName, aToModelElem1, this, aRelationshipInModel);
  }

  public boolean addToModelRel2(ModelRelationship aToModelRel2)
  {
    boolean wasAdded = false;
    if (toModelRel2.contains(aToModelRel2)) { return false; }
    ModelElement existingToModelElem2 = aToModelRel2.getToModelElem2();
    boolean isNewToModelElem2 = existingToModelElem2 != null && !this.equals(existingToModelElem2);
    if (isNewToModelElem2)
    {
      aToModelRel2.setToModelElem2(this);
    }
    else
    {
      toModelRel2.add(aToModelRel2);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeToModelRel2(ModelRelationship aToModelRel2)
  {
    boolean wasRemoved = false;
    //Unable to remove aToModelRel2, as it must always have a toModelElem2
    if (!this.equals(aToModelRel2.getToModelElem2()))
    {
      toModelRel2.remove(aToModelRel2);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addToModelRel2At(ModelRelationship aToModelRel2, int index)
  {  
    boolean wasAdded = false;
    if(addToModelRel2(aToModelRel2))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToModelRel2()) { index = numberOfToModelRel2() - 1; }
      toModelRel2.remove(aToModelRel2);
      toModelRel2.add(index, aToModelRel2);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToModelRel2At(ModelRelationship aToModelRel2, int index)
  {
    boolean wasAdded = false;
    if(toModelRel2.contains(aToModelRel2))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToModelRel2()) { index = numberOfToModelRel2() - 1; }
      toModelRel2.remove(aToModelRel2);
      toModelRel2.add(index, aToModelRel2);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToModelRel2At(aToModelRel2, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=toModelRel1.size(); i > 0; i--)
    {
      ModelRelationship aToModelRel1 = toModelRel1.get(i - 1);
      aToModelRel1.delete();
    }
    for(int i=toModelRel2.size(); i > 0; i--)
    {
      ModelRelationship aToModelRel2 = toModelRel2.get(i - 1);
      aToModelRel2.delete();
    }
    super.delete();
  }

}