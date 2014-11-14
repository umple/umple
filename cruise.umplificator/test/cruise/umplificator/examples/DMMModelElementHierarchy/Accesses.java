/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Association classes
 */
// line 34 "DMMModelElementHierarchy.ump"
// line 253 "DMMModelElementHierarchy.ump"
public class Accesses
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accesses Associations
  private BehaviouralElement behaviouralElement;
  private StructuralElement structuralElement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accesses(BehaviouralElement aBehaviouralElement, StructuralElement aStructuralElement)
  {
    boolean didAddBehaviouralElement = setBehaviouralElement(aBehaviouralElement);
    if (!didAddBehaviouralElement)
    {
      throw new RuntimeException("Unable to create access due to behaviouralElement");
    }
    boolean didAddStructuralElement = setStructuralElement(aStructuralElement);
    if (!didAddStructuralElement)
    {
      throw new RuntimeException("Unable to create access due to structuralElement");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BehaviouralElement getBehaviouralElement()
  {
    return behaviouralElement;
  }

  public StructuralElement getStructuralElement()
  {
    return structuralElement;
  }

  public boolean setBehaviouralElement(BehaviouralElement aBehaviouralElement)
  {
    boolean wasSet = false;
    if (aBehaviouralElement == null)
    {
      return wasSet;
    }

    BehaviouralElement existingBehaviouralElement = behaviouralElement;
    behaviouralElement = aBehaviouralElement;
    if (existingBehaviouralElement != null && !existingBehaviouralElement.equals(aBehaviouralElement))
    {
      existingBehaviouralElement.removeAccess(this);
    }
    behaviouralElement.addAccess(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setStructuralElement(StructuralElement aStructuralElement)
  {
    boolean wasSet = false;
    if (aStructuralElement == null)
    {
      return wasSet;
    }

    StructuralElement existingStructuralElement = structuralElement;
    structuralElement = aStructuralElement;
    if (existingStructuralElement != null && !existingStructuralElement.equals(aStructuralElement))
    {
      existingStructuralElement.removeAccess(this);
    }
    structuralElement.addAccess(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BehaviouralElement placeholderBehaviouralElement = behaviouralElement;
    this.behaviouralElement = null;
    placeholderBehaviouralElement.removeAccess(this);
    StructuralElement placeholderStructuralElement = structuralElement;
    this.structuralElement = null;
    placeholderStructuralElement.removeAccess(this);
  }

}