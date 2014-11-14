/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 68 "DMMExtensionCTF.ump"
// line 92 "DMMExtensionCTF.ump"
public class RecursionOccurrence extends ComprehensionUnitInitiator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RecursionOccurrence Attributes
  private int repetitionsDueToRecursion;

  //RecursionOccurrence Associations
  private ComprehensionUnitInitiator comprehensionUnitInitiator;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RecursionOccurrence(TraceEdge aTraceEdge, int aRepetitionsDueToRecursion, ComprehensionUnitInitiator aComprehensionUnitInitiator)
  {
    super(aTraceEdge);
    repetitionsDueToRecursion = aRepetitionsDueToRecursion;
    if (!setComprehensionUnitInitiator(aComprehensionUnitInitiator))
    {
      throw new RuntimeException("Unable to create RecursionOccurrence due to aComprehensionUnitInitiator");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRepetitionsDueToRecursion(int aRepetitionsDueToRecursion)
  {
    boolean wasSet = false;
    repetitionsDueToRecursion = aRepetitionsDueToRecursion;
    wasSet = true;
    return wasSet;
  }

  public int getRepetitionsDueToRecursion()
  {
    return repetitionsDueToRecursion;
  }

  public ComprehensionUnitInitiator getComprehensionUnitInitiator()
  {
    return comprehensionUnitInitiator;
  }

  public boolean setComprehensionUnitInitiator(ComprehensionUnitInitiator aNewComprehensionUnitInitiator)
  {
    boolean wasSet = false;
    if (aNewComprehensionUnitInitiator != null)
    {
      comprehensionUnitInitiator = aNewComprehensionUnitInitiator;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    comprehensionUnitInitiator = null;
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "repetitionsDueToRecursion" + ":" + getRepetitionsDueToRecursion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "comprehensionUnitInitiator = "+(getComprehensionUnitInitiator()!=null?Integer.toHexString(System.identityHashCode(getComprehensionUnitInitiator())):"null")
     + outputString;
  }
}