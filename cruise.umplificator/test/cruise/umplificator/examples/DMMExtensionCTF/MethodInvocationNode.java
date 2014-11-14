/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 74 "DMMExtensionCTF.ump"
// line 125 "DMMExtensionCTF.ump"
public class MethodInvocationNode extends RoutineCallNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodInvocationNode Associations
  private CTFObject cTFObject;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodInvocationNode(TraceEdge aTraceEdge)
  {
    super(aTraceEdge);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public CTFObject getCTFObject()
  {
    return cTFObject;
  }

  public boolean hasCTFObject()
  {
    boolean has = cTFObject != null;
    return has;
  }

  public boolean setCTFObject(CTFObject aCTFObject)
  {
    boolean wasSet = false;
    CTFObject existingCTFObject = cTFObject;
    cTFObject = aCTFObject;
    if (existingCTFObject != null && !existingCTFObject.equals(aCTFObject))
    {
      existingCTFObject.removeInvoke(this);
    }
    if (aCTFObject != null)
    {
      aCTFObject.addInvoke(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (cTFObject != null)
    {
      CTFObject placeholderCTFObject = cTFObject;
      this.cTFObject = null;
      placeholderCTFObject.removeInvoke(this);
    }
    super.delete();
  }

}