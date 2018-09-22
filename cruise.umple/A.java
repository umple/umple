/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/


import java.util.*;

// line 1 "umpleClassTest.ump"
public class A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //A Associations
  private B b;
  private List<C> children;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public A(B aB)
  {
    if (!setB(aB))
    {
      throw new RuntimeException("Unable to create A due to aB");
    }
    children = new ArrayList<C>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public B getB()
  {
    return b;
  }
  /* Code from template association_GetMany */
  public C getChild(int index)
  {
    C aChild = children.get(index);
    return aChild;
  }

  public List<C> getChildren()
  {
    List<C> newChildren = Collections.unmodifiableList(children);
    return newChildren;
  }

  public int numberOfChildren()
  {
    int number = children.size();
    return number;
  }

  public boolean hasChildren()
  {
    boolean has = children.size() > 0;
    return has;
  }

  public int indexOfChild(C aChild)
  {
    int index = children.indexOf(aChild);
    return index;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setB(B aNewB)
  {
    boolean wasSet = false;
    if (aNewB != null)
    {
      b = aNewB;
      wasSet = true;
    }
    // line 1 "umpleClassTest.ump"
    foo();
    // END OF UMPLE AFTER INJECTION
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfChildren()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addChild(C aChild)
  {
    boolean wasAdded = false;
    if (children.contains(aChild)) { return false; }
    children.add(aChild);
    wasAdded = true;
    // line 1 "umpleClassTest.ump"
    foo();
    // END OF UMPLE AFTER INJECTION
    return wasAdded;
  }

  public boolean removeChild(C aChild)
  {
    boolean wasRemoved = false;
    if (children.contains(aChild))
    {
      children.remove(aChild);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addChildAt(C aChild, int index)
  {  
    boolean wasAdded = false;
    if(addChild(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChildAt(C aChild, int index)
  {
    boolean wasAdded = false;
    if(children.contains(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChildren()) { index = numberOfChildren() - 1; }
      children.remove(aChild);
      children.add(index, aChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChildAt(aChild, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    b = null;
    children.clear();
  }

}