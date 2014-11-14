/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 44 "DMMModelElementHierarchy.ump"
// line 267 "DMMModelElementHierarchy.ump"
public class Contains
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Contains Associations
  private DMMPackage partOf;
  private ModelElement modelElement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Contains(DMMPackage aPartOf, ModelElement aModelElement)
  {
    boolean didAddPartOf = setPartOf(aPartOf);
    if (!didAddPartOf)
    {
      throw new RuntimeException("Unable to create contain due to partOf");
    }
    boolean didAddModelElement = setModelElement(aModelElement);
    if (!didAddModelElement)
    {
      throw new RuntimeException("Unable to create contains due to modelElement");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DMMPackage getPartOf()
  {
    return partOf;
  }

  public ModelElement getModelElement()
  {
    return modelElement;
  }

  public boolean setPartOf(DMMPackage aPartOf)
  {
    boolean wasSet = false;
    if (aPartOf == null)
    {
      return wasSet;
    }

    DMMPackage existingPartOf = partOf;
    partOf = aPartOf;
    if (existingPartOf != null && !existingPartOf.equals(aPartOf))
    {
      existingPartOf.removeContain(this);
    }
    partOf.addContain(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setModelElement(ModelElement aNewModelElement)
  {
    boolean wasSet = false;
    if (aNewModelElement == null)
    {
      //Unable to setModelElement to null, as contains must always be associated to a modelElement
      return wasSet;
    }
    
    Contains existingContains = aNewModelElement.getContains();
    if (existingContains != null && !equals(existingContains))
    {
      //Unable to setModelElement, the current modelElement already has a contains, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    ModelElement anOldModelElement = modelElement;
    modelElement = aNewModelElement;
    modelElement.setContains(this);

    if (anOldModelElement != null)
    {
      anOldModelElement.setContains(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DMMPackage placeholderPartOf = partOf;
    this.partOf = null;
    placeholderPartOf.removeContain(this);
    ModelElement existingModelElement = modelElement;
    modelElement = null;
    if (existingModelElement != null)
    {
      existingModelElement.setContains(null);
    }
  }

}