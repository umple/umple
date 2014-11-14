/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 141 "DMMModelElementHierarchy.ump"
// line 160 "DMMModelElementHierarchy.ump"
public class Method extends BehaviouralElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Method Attributes
  private boolean isConstructor;
  private boolean isDestructor;
  private boolean isAbstract;
  private boolean isDynamicallyBound;
  private boolean isOverideable;

  //Method Associations
  private IsMethodOf isMethodOf;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Method(String aVisibility, boolean aIsConstructor, boolean aIsDestructor, boolean aIsAbstract, boolean aIsDynamicallyBound, boolean aIsOverideable)
  {
    super(aVisibility);
    isConstructor = aIsConstructor;
    isDestructor = aIsDestructor;
    isAbstract = aIsAbstract;
    isDynamicallyBound = aIsDynamicallyBound;
    isOverideable = aIsOverideable;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsConstructor(boolean aIsConstructor)
  {
    boolean wasSet = false;
    isConstructor = aIsConstructor;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDestructor(boolean aIsDestructor)
  {
    boolean wasSet = false;
    isDestructor = aIsDestructor;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsAbstract(boolean aIsAbstract)
  {
    boolean wasSet = false;
    isAbstract = aIsAbstract;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDynamicallyBound(boolean aIsDynamicallyBound)
  {
    boolean wasSet = false;
    isDynamicallyBound = aIsDynamicallyBound;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsOverideable(boolean aIsOverideable)
  {
    boolean wasSet = false;
    isOverideable = aIsOverideable;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsConstructor()
  {
    return isConstructor;
  }

  public boolean getIsDestructor()
  {
    return isDestructor;
  }

  public boolean getIsAbstract()
  {
    return isAbstract;
  }

  public boolean getIsDynamicallyBound()
  {
    return isDynamicallyBound;
  }

  public boolean getIsOverideable()
  {
    return isOverideable;
  }

  public boolean isIsConstructor()
  {
    return isConstructor;
  }

  public boolean isIsDestructor()
  {
    return isDestructor;
  }

  public boolean isIsAbstract()
  {
    return isAbstract;
  }

  public boolean isIsDynamicallyBound()
  {
    return isDynamicallyBound;
  }

  public boolean isIsOverideable()
  {
    return isOverideable;
  }

  public IsMethodOf getIsMethodOf()
  {
    return isMethodOf;
  }

  public boolean hasIsMethodOf()
  {
    boolean has = isMethodOf != null;
    return has;
  }

  public boolean setIsMethodOf(IsMethodOf aNewIsMethodOf)
  {
    boolean wasSet = false;
    if (isMethodOf != null && !isMethodOf.equals(aNewIsMethodOf) && equals(isMethodOf.getHasMethod()))
    {
      //Unable to setIsMethodOf, as existing isMethodOf would become an orphan
      return wasSet;
    }

    isMethodOf = aNewIsMethodOf;
    Method anOldHasMethod = aNewIsMethodOf != null ? aNewIsMethodOf.getHasMethod() : null;

    if (!this.equals(anOldHasMethod))
    {
      if (anOldHasMethod != null)
      {
        anOldHasMethod.isMethodOf = null;
      }
      if (isMethodOf != null)
      {
        isMethodOf.setHasMethod(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IsMethodOf existingIsMethodOf = isMethodOf;
    isMethodOf = null;
    if (existingIsMethodOf != null)
    {
      existingIsMethodOf.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isConstructor" + ":" + getIsConstructor()+ "," +
            "isDestructor" + ":" + getIsDestructor()+ "," +
            "isAbstract" + ":" + getIsAbstract()+ "," +
            "isDynamicallyBound" + ":" + getIsDynamicallyBound()+ "," +
            "isOverideable" + ":" + getIsOverideable()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "isMethodOf = "+(getIsMethodOf()!=null?Integer.toHexString(System.identityHashCode(getIsMethodOf())):"null")
     + outputString;
  }
}