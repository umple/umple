/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 86 "DMMModelElementHierarchy.ump"
// line 331 "DMMModelElementHierarchy.ump"
public class MethodInProperty extends Method
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodInProperty Associations
  private Property property;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodInProperty(String aVisibility, boolean aIsConstructor, boolean aIsDestructor, boolean aIsAbstract, boolean aIsDynamicallyBound, boolean aIsOverideable, Property aProperty)
  {
    super(aVisibility, aIsConstructor, aIsDestructor, aIsAbstract, aIsDynamicallyBound, aIsOverideable);
    if (aProperty == null || aProperty.getMethodInProperty() != null)
    {
      throw new RuntimeException("Unable to create MethodInProperty due to aProperty");
    }
    property = aProperty;
  }

  public MethodInProperty(String aVisibility, boolean aIsConstructor, boolean aIsDestructor, boolean aIsAbstract, boolean aIsDynamicallyBound, boolean aIsOverideable, String aVisibilityForProperty)
  {
    super(aVisibility, aIsConstructor, aIsDestructor, aIsAbstract, aIsDynamicallyBound, aIsOverideable);
    property = new Property(aVisibilityForProperty, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Property getProperty()
  {
    return property;
  }

  public void delete()
  {
    Property existingProperty = property;
    property = null;
    if (existingProperty != null)
    {
      existingProperty.delete();
    }
    super.delete();
  }

}