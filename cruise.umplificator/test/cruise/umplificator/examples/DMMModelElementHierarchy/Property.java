/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 81 "DMMModelElementHierarchy.ump"
// line 246 "DMMModelElementHierarchy.ump"
public class Property extends Variable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Property Associations
  private MethodInProperty methodInProperty;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Property(String aVisibility, MethodInProperty aMethodInProperty)
  {
    super(aVisibility);
    if (aMethodInProperty == null || aMethodInProperty.getProperty() != null)
    {
      throw new RuntimeException("Unable to create Property due to aMethodInProperty");
    }
    methodInProperty = aMethodInProperty;
  }

  public Property(String aVisibility, String aVisibilityForMethodInProperty, boolean aIsConstructorForMethodInProperty, boolean aIsDestructorForMethodInProperty, boolean aIsAbstractForMethodInProperty, boolean aIsDynamicallyBoundForMethodInProperty, boolean aIsOverideableForMethodInProperty)
  {
    super(aVisibility);
    methodInProperty = new MethodInProperty(aVisibilityForMethodInProperty, aIsConstructorForMethodInProperty, aIsDestructorForMethodInProperty, aIsAbstractForMethodInProperty, aIsDynamicallyBoundForMethodInProperty, aIsOverideableForMethodInProperty, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public MethodInProperty getMethodInProperty()
  {
    return methodInProperty;
  }

  public void delete()
  {
    MethodInProperty existingMethodInProperty = methodInProperty;
    methodInProperty = null;
    if (existingMethodInProperty != null)
    {
      existingMethodInProperty.delete();
    }
    super.delete();
  }

}