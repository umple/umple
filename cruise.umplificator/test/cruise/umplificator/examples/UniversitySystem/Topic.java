/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 12 "UniversitySystem.ump"
// line 53 "UniversitySystem.ump"
public class Topic
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Topic Associations
  private List<PrerequisiteReason> prerequisiteReasons;
  private List<MutualExclusionReason> mutualExclusionReasons;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Topic()
  {
    prerequisiteReasons = new ArrayList<PrerequisiteReason>();
    mutualExclusionReasons = new ArrayList<MutualExclusionReason>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public PrerequisiteReason getPrerequisiteReason(int index)
  {
    PrerequisiteReason aPrerequisiteReason = prerequisiteReasons.get(index);
    return aPrerequisiteReason;
  }

  public List<PrerequisiteReason> getPrerequisiteReasons()
  {
    List<PrerequisiteReason> newPrerequisiteReasons = Collections.unmodifiableList(prerequisiteReasons);
    return newPrerequisiteReasons;
  }

  public int numberOfPrerequisiteReasons()
  {
    int number = prerequisiteReasons.size();
    return number;
  }

  public boolean hasPrerequisiteReasons()
  {
    boolean has = prerequisiteReasons.size() > 0;
    return has;
  }

  public int indexOfPrerequisiteReason(PrerequisiteReason aPrerequisiteReason)
  {
    int index = prerequisiteReasons.indexOf(aPrerequisiteReason);
    return index;
  }

  public MutualExclusionReason getMutualExclusionReason(int index)
  {
    MutualExclusionReason aMutualExclusionReason = mutualExclusionReasons.get(index);
    return aMutualExclusionReason;
  }

  public List<MutualExclusionReason> getMutualExclusionReasons()
  {
    List<MutualExclusionReason> newMutualExclusionReasons = Collections.unmodifiableList(mutualExclusionReasons);
    return newMutualExclusionReasons;
  }

  public int numberOfMutualExclusionReasons()
  {
    int number = mutualExclusionReasons.size();
    return number;
  }

  public boolean hasMutualExclusionReasons()
  {
    boolean has = mutualExclusionReasons.size() > 0;
    return has;
  }

  public int indexOfMutualExclusionReason(MutualExclusionReason aMutualExclusionReason)
  {
    int index = mutualExclusionReasons.indexOf(aMutualExclusionReason);
    return index;
  }

  public static int minimumNumberOfPrerequisiteReasons()
  {
    return 0;
  }

  public boolean addPrerequisiteReason(PrerequisiteReason aPrerequisiteReason)
  {
    boolean wasAdded = false;
    if (prerequisiteReasons.contains(aPrerequisiteReason)) { return false; }
    prerequisiteReasons.add(aPrerequisiteReason);
    if (aPrerequisiteReason.indexOfMaterialNeededBySuccessor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPrerequisiteReason.addMaterialNeededBySuccessor(this);
      if (!wasAdded)
      {
        prerequisiteReasons.remove(aPrerequisiteReason);
      }
    }
    return wasAdded;
  }

  public boolean removePrerequisiteReason(PrerequisiteReason aPrerequisiteReason)
  {
    boolean wasRemoved = false;
    if (!prerequisiteReasons.contains(aPrerequisiteReason))
    {
      return wasRemoved;
    }

    int oldIndex = prerequisiteReasons.indexOf(aPrerequisiteReason);
    prerequisiteReasons.remove(oldIndex);
    if (aPrerequisiteReason.indexOfMaterialNeededBySuccessor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPrerequisiteReason.removeMaterialNeededBySuccessor(this);
      if (!wasRemoved)
      {
        prerequisiteReasons.add(oldIndex,aPrerequisiteReason);
      }
    }
    return wasRemoved;
  }

  public boolean addPrerequisiteReasonAt(PrerequisiteReason aPrerequisiteReason, int index)
  {  
    boolean wasAdded = false;
    if(addPrerequisiteReason(aPrerequisiteReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrerequisiteReasons()) { index = numberOfPrerequisiteReasons() - 1; }
      prerequisiteReasons.remove(aPrerequisiteReason);
      prerequisiteReasons.add(index, aPrerequisiteReason);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePrerequisiteReasonAt(PrerequisiteReason aPrerequisiteReason, int index)
  {
    boolean wasAdded = false;
    if(prerequisiteReasons.contains(aPrerequisiteReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrerequisiteReasons()) { index = numberOfPrerequisiteReasons() - 1; }
      prerequisiteReasons.remove(aPrerequisiteReason);
      prerequisiteReasons.add(index, aPrerequisiteReason);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPrerequisiteReasonAt(aPrerequisiteReason, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMutualExclusionReasons()
  {
    return 0;
  }

  public boolean addMutualExclusionReason(MutualExclusionReason aMutualExclusionReason)
  {
    boolean wasAdded = false;
    if (mutualExclusionReasons.contains(aMutualExclusionReason)) { return false; }
    mutualExclusionReasons.add(aMutualExclusionReason);
    if (aMutualExclusionReason.indexOfOverlappingMaterial(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMutualExclusionReason.addOverlappingMaterial(this);
      if (!wasAdded)
      {
        mutualExclusionReasons.remove(aMutualExclusionReason);
      }
    }
    return wasAdded;
  }

  public boolean removeMutualExclusionReason(MutualExclusionReason aMutualExclusionReason)
  {
    boolean wasRemoved = false;
    if (!mutualExclusionReasons.contains(aMutualExclusionReason))
    {
      return wasRemoved;
    }

    int oldIndex = mutualExclusionReasons.indexOf(aMutualExclusionReason);
    mutualExclusionReasons.remove(oldIndex);
    if (aMutualExclusionReason.indexOfOverlappingMaterial(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMutualExclusionReason.removeOverlappingMaterial(this);
      if (!wasRemoved)
      {
        mutualExclusionReasons.add(oldIndex,aMutualExclusionReason);
      }
    }
    return wasRemoved;
  }

  public boolean addMutualExclusionReasonAt(MutualExclusionReason aMutualExclusionReason, int index)
  {  
    boolean wasAdded = false;
    if(addMutualExclusionReason(aMutualExclusionReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMutualExclusionReasons()) { index = numberOfMutualExclusionReasons() - 1; }
      mutualExclusionReasons.remove(aMutualExclusionReason);
      mutualExclusionReasons.add(index, aMutualExclusionReason);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMutualExclusionReasonAt(MutualExclusionReason aMutualExclusionReason, int index)
  {
    boolean wasAdded = false;
    if(mutualExclusionReasons.contains(aMutualExclusionReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMutualExclusionReasons()) { index = numberOfMutualExclusionReasons() - 1; }
      mutualExclusionReasons.remove(aMutualExclusionReason);
      mutualExclusionReasons.add(index, aMutualExclusionReason);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMutualExclusionReasonAt(aMutualExclusionReason, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<PrerequisiteReason> copyOfPrerequisiteReasons = new ArrayList<PrerequisiteReason>(prerequisiteReasons);
    prerequisiteReasons.clear();
    for(PrerequisiteReason aPrerequisiteReason : copyOfPrerequisiteReasons)
    {
      aPrerequisiteReason.removeMaterialNeededBySuccessor(this);
    }
    ArrayList<MutualExclusionReason> copyOfMutualExclusionReasons = new ArrayList<MutualExclusionReason>(mutualExclusionReasons);
    mutualExclusionReasons.clear();
    for(MutualExclusionReason aMutualExclusionReason : copyOfMutualExclusionReasons)
    {
      aMutualExclusionReason.removeOverlappingMaterial(this);
    }
  }

}