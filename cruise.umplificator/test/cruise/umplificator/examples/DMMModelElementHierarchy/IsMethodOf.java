/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 150 "DMMModelElementHierarchy.ump"
// line 317 "DMMModelElementHierarchy.ump"
public class IsMethodOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsMethodOf Associations
  private DMMClass methodOf;
  private Method hasMethod;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsMethodOf(DMMClass aMethodOf, Method aHasMethod)
  {
    boolean didAddMethodOf = setMethodOf(aMethodOf);
    if (!didAddMethodOf)
    {
      throw new RuntimeException("Unable to create isMethodOf due to methodOf");
    }
    boolean didAddHasMethod = setHasMethod(aHasMethod);
    if (!didAddHasMethod)
    {
      throw new RuntimeException("Unable to create isMethodOf due to hasMethod");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DMMClass getMethodOf()
  {
    return methodOf;
  }

  public Method getHasMethod()
  {
    return hasMethod;
  }

  public boolean setMethodOf(DMMClass aMethodOf)
  {
    boolean wasSet = false;
    if (aMethodOf == null)
    {
      return wasSet;
    }

    DMMClass existingMethodOf = methodOf;
    methodOf = aMethodOf;
    if (existingMethodOf != null && !existingMethodOf.equals(aMethodOf))
    {
      existingMethodOf.removeIsMethodOf(this);
    }
    methodOf.addIsMethodOf(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setHasMethod(Method aNewHasMethod)
  {
    boolean wasSet = false;
    if (aNewHasMethod == null)
    {
      //Unable to setHasMethod to null, as isMethodOf must always be associated to a hasMethod
      return wasSet;
    }
    
    IsMethodOf existingIsMethodOf = aNewHasMethod.getIsMethodOf();
    if (existingIsMethodOf != null && !equals(existingIsMethodOf))
    {
      //Unable to setHasMethod, the current hasMethod already has a isMethodOf, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Method anOldHasMethod = hasMethod;
    hasMethod = aNewHasMethod;
    hasMethod.setIsMethodOf(this);

    if (anOldHasMethod != null)
    {
      anOldHasMethod.setIsMethodOf(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DMMClass placeholderMethodOf = methodOf;
    this.methodOf = null;
    placeholderMethodOf.removeIsMethodOf(this);
    Method existingHasMethod = hasMethod;
    hasMethod = null;
    if (existingHasMethod != null)
    {
      existingHasMethod.setIsMethodOf(null);
    }
  }

}