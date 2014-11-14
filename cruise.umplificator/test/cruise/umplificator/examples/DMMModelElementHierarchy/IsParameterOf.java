/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 117 "DMMModelElementHierarchy.ump"
// line 296 "DMMModelElementHierarchy.ump"
public class IsParameterOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsParameterOf Associations
  private FormalParameter formalParameter;
  private BehaviouralElement behaviouralElement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsParameterOf(FormalParameter aFormalParameter, BehaviouralElement aBehaviouralElement)
  {
    if (aFormalParameter == null || aFormalParameter.getIsParameterOf() != null)
    {
      throw new RuntimeException("Unable to create IsParameterOf due to aFormalParameter");
    }
    formalParameter = aFormalParameter;
    boolean didAddBehaviouralElement = setBehaviouralElement(aBehaviouralElement);
    if (!didAddBehaviouralElement)
    {
      throw new RuntimeException("Unable to create isParameterOf due to behaviouralElement");
    }
  }

  public IsParameterOf(String aVisibilityForFormalParameter, String aPosForFormalParameter, BehaviouralElement aBehaviouralElement)
  {
    formalParameter = new FormalParameter(aVisibilityForFormalParameter, aPosForFormalParameter, this);
    boolean didAddBehaviouralElement = setBehaviouralElement(aBehaviouralElement);
    if (!didAddBehaviouralElement)
    {
      throw new RuntimeException("Unable to create isParameterOf due to behaviouralElement");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public FormalParameter getFormalParameter()
  {
    return formalParameter;
  }

  public BehaviouralElement getBehaviouralElement()
  {
    return behaviouralElement;
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
      existingBehaviouralElement.removeIsParameterOf(this);
    }
    behaviouralElement.addIsParameterOf(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    FormalParameter existingFormalParameter = formalParameter;
    formalParameter = null;
    if (existingFormalParameter != null)
    {
      existingFormalParameter.delete();
    }
    BehaviouralElement placeholderBehaviouralElement = behaviouralElement;
    this.behaviouralElement = null;
    placeholderBehaviouralElement.removeIsParameterOf(this);
  }

}