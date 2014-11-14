/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 28 "DMMExtensionCTF.ump"
// line 159 "DMMExtensionCTF.ump"
public class RoutineCallTrace extends Trace
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoutineCallTrace Associations
  private ComprehensionUnitInitiator root;
  private List<PatternOccurrence> patternOccurrences;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoutineCallTrace(ComprehensionUnitInitiator aRoot)
  {
    super();
    if (!setRoot(aRoot))
    {
      throw new RuntimeException("Unable to create RoutineCallTrace due to aRoot");
    }
    patternOccurrences = new ArrayList<PatternOccurrence>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ComprehensionUnitInitiator getRoot()
  {
    return root;
  }

  public PatternOccurrence getPatternOccurrence(int index)
  {
    PatternOccurrence aPatternOccurrence = patternOccurrences.get(index);
    return aPatternOccurrence;
  }

  public List<PatternOccurrence> getPatternOccurrences()
  {
    List<PatternOccurrence> newPatternOccurrences = Collections.unmodifiableList(patternOccurrences);
    return newPatternOccurrences;
  }

  public int numberOfPatternOccurrences()
  {
    int number = patternOccurrences.size();
    return number;
  }

  public boolean hasPatternOccurrences()
  {
    boolean has = patternOccurrences.size() > 0;
    return has;
  }

  public int indexOfPatternOccurrence(PatternOccurrence aPatternOccurrence)
  {
    int index = patternOccurrences.indexOf(aPatternOccurrence);
    return index;
  }

  public boolean setRoot(ComprehensionUnitInitiator aNewRoot)
  {
    boolean wasSet = false;
    if (aNewRoot != null)
    {
      root = aNewRoot;
      wasSet = true;
    }
    return wasSet;
  }

  public static int minimumNumberOfPatternOccurrences()
  {
    return 0;
  }

  public PatternOccurrence addPatternOccurrence(TracePattern aTracePattern, ComprehensionUnitInitiator aInitiator)
  {
    return new PatternOccurrence(this, aTracePattern, aInitiator);
  }

  public boolean addPatternOccurrence(PatternOccurrence aPatternOccurrence)
  {
    boolean wasAdded = false;
    if (patternOccurrences.contains(aPatternOccurrence)) { return false; }
    if (patternOccurrences.contains(aPatternOccurrence)) { return false; }
    RoutineCallTrace existingRoutineCallTrace = aPatternOccurrence.getRoutineCallTrace();
    boolean isNewRoutineCallTrace = existingRoutineCallTrace != null && !this.equals(existingRoutineCallTrace);
    if (isNewRoutineCallTrace)
    {
      aPatternOccurrence.setRoutineCallTrace(this);
    }
    else
    {
      patternOccurrences.add(aPatternOccurrence);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatternOccurrence(PatternOccurrence aPatternOccurrence)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatternOccurrence, as it must always have a routineCallTrace
    if (!this.equals(aPatternOccurrence.getRoutineCallTrace()))
    {
      patternOccurrences.remove(aPatternOccurrence);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPatternOccurrenceAt(PatternOccurrence aPatternOccurrence, int index)
  {  
    boolean wasAdded = false;
    if(addPatternOccurrence(aPatternOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatternOccurrences()) { index = numberOfPatternOccurrences() - 1; }
      patternOccurrences.remove(aPatternOccurrence);
      patternOccurrences.add(index, aPatternOccurrence);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatternOccurrenceAt(PatternOccurrence aPatternOccurrence, int index)
  {
    boolean wasAdded = false;
    if(patternOccurrences.contains(aPatternOccurrence))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatternOccurrences()) { index = numberOfPatternOccurrences() - 1; }
      patternOccurrences.remove(aPatternOccurrence);
      patternOccurrences.add(index, aPatternOccurrence);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatternOccurrenceAt(aPatternOccurrence, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    root = null;
    for(int i=patternOccurrences.size(); i > 0; i--)
    {
      PatternOccurrence aPatternOccurrence = patternOccurrences.get(i - 1);
      aPatternOccurrence.delete();
    }
    super.delete();
  }

}