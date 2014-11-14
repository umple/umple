/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 50 "DMMExtensionCTF.ump"
// line 98 "DMMExtensionCTF.ump"
public class TraceEdge
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceEdge Attributes
  private int repetitionsDueToLoops;

  //TraceEdge Associations
  private ComprehensionUnitInitiator parent;
  private ComprehensionUnitInitiator child;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceEdge(int aRepetitionsDueToLoops, ComprehensionUnitInitiator aParent, ComprehensionUnitInitiator aChild)
  {
    repetitionsDueToLoops = aRepetitionsDueToLoops;
    boolean didAddParent = setParent(aParent);
    if (!didAddParent)
    {
      throw new RuntimeException("Unable to create trace due to parent");
    }
    if (aChild == null || aChild.getTraceEdge() != null)
    {
      throw new RuntimeException("Unable to create TraceEdge due to aChild");
    }
    child = aChild;
  }

  public TraceEdge(int aRepetitionsDueToLoops, ComprehensionUnitInitiator aParent)
  {
    repetitionsDueToLoops = aRepetitionsDueToLoops;
    boolean didAddParent = setParent(aParent);
    if (!didAddParent)
    {
      throw new RuntimeException("Unable to create trace due to parent");
    }
    child = new ComprehensionUnitInitiator(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRepetitionsDueToLoops(int aRepetitionsDueToLoops)
  {
    boolean wasSet = false;
    repetitionsDueToLoops = aRepetitionsDueToLoops;
    wasSet = true;
    return wasSet;
  }

  public int getRepetitionsDueToLoops()
  {
    return repetitionsDueToLoops;
  }

  public ComprehensionUnitInitiator getParent()
  {
    return parent;
  }

  public ComprehensionUnitInitiator getChild()
  {
    return child;
  }

  public boolean setParent(ComprehensionUnitInitiator aParent)
  {
    boolean wasSet = false;
    if (aParent == null)
    {
      return wasSet;
    }

    ComprehensionUnitInitiator existingParent = parent;
    parent = aParent;
    if (existingParent != null && !existingParent.equals(aParent))
    {
      existingParent.removeTrace(this);
    }
    parent.addTrace(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ComprehensionUnitInitiator placeholderParent = parent;
    this.parent = null;
    placeholderParent.removeTrace(this);
    ComprehensionUnitInitiator existingChild = child;
    child = null;
    if (existingChild != null)
    {
      existingChild.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "repetitionsDueToLoops" + ":" + getRepetitionsDueToLoops()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parent = "+(getParent()!=null?Integer.toHexString(System.identityHashCode(getParent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "child = "+(getChild()!=null?Integer.toHexString(System.identityHashCode(getChild())):"null")
     + outputString;
  }
}