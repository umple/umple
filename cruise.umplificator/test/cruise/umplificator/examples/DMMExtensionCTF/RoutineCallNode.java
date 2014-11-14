/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 56 "DMMExtensionCTF.ump"
// line 145 "DMMExtensionCTF.ump"
public class RoutineCallNode extends ComprehensionUnitInitiator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoutineCallNode Associations
  private BehaviouralElement behaviouralElement;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoutineCallNode(TraceEdge aTraceEdge)
  {
    super(aTraceEdge);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BehaviouralElement getBehaviouralElement()
  {
    return behaviouralElement;
  }

  public boolean hasBehaviouralElement()
  {
    boolean has = behaviouralElement != null;
    return has;
  }

  public boolean setBehaviouralElement(BehaviouralElement aBehaviouralElement)
  {
    boolean wasSet = false;
    BehaviouralElement existingBehaviouralElement = behaviouralElement;
    behaviouralElement = aBehaviouralElement;
    if (existingBehaviouralElement != null && !existingBehaviouralElement.equals(aBehaviouralElement))
    {
      existingBehaviouralElement.removeRoutineCallNode(this);
    }
    if (aBehaviouralElement != null)
    {
      aBehaviouralElement.addRoutineCallNode(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (behaviouralElement != null)
    {
      BehaviouralElement placeholderBehaviouralElement = behaviouralElement;
      this.behaviouralElement = null;
      placeholderBehaviouralElement.removeRoutineCallNode(this);
    }
    super.delete();
  }

}