/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 10 "UniversitySystem.ump"
// line 58 "UniversitySystem.ump"
public class Course
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Associations
  private List<PrerequisiteReason> sucReason;
  private List<PrerequisiteReason> preReason;
  private List<MutualExclusionReason> mutex;
  private List<MutualExclusionReason> mutualExclusionReasons;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course()
  {
    sucReason = new ArrayList<PrerequisiteReason>();
    preReason = new ArrayList<PrerequisiteReason>();
    mutex = new ArrayList<MutualExclusionReason>();
    mutualExclusionReasons = new ArrayList<MutualExclusionReason>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public PrerequisiteReason getSucReason(int index)
  {
    PrerequisiteReason aSucReason = sucReason.get(index);
    return aSucReason;
  }

  public List<PrerequisiteReason> getSucReason()
  {
    List<PrerequisiteReason> newSucReason = Collections.unmodifiableList(sucReason);
    return newSucReason;
  }

  public int numberOfSucReason()
  {
    int number = sucReason.size();
    return number;
  }

  public boolean hasSucReason()
  {
    boolean has = sucReason.size() > 0;
    return has;
  }

  public int indexOfSucReason(PrerequisiteReason aSucReason)
  {
    int index = sucReason.indexOf(aSucReason);
    return index;
  }

  public PrerequisiteReason getPreReason(int index)
  {
    PrerequisiteReason aPreReason = preReason.get(index);
    return aPreReason;
  }

  public List<PrerequisiteReason> getPreReason()
  {
    List<PrerequisiteReason> newPreReason = Collections.unmodifiableList(preReason);
    return newPreReason;
  }

  public int numberOfPreReason()
  {
    int number = preReason.size();
    return number;
  }

  public boolean hasPreReason()
  {
    boolean has = preReason.size() > 0;
    return has;
  }

  public int indexOfPreReason(PrerequisiteReason aPreReason)
  {
    int index = preReason.indexOf(aPreReason);
    return index;
  }

  public MutualExclusionReason getMutex(int index)
  {
    MutualExclusionReason aMutex = mutex.get(index);
    return aMutex;
  }

  public List<MutualExclusionReason> getMutex()
  {
    List<MutualExclusionReason> newMutex = Collections.unmodifiableList(mutex);
    return newMutex;
  }

  public int numberOfMutex()
  {
    int number = mutex.size();
    return number;
  }

  public boolean hasMutex()
  {
    boolean has = mutex.size() > 0;
    return has;
  }

  public int indexOfMutex(MutualExclusionReason aMutex)
  {
    int index = mutex.indexOf(aMutex);
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

  public static int minimumNumberOfSucReason()
  {
    return 0;
  }

  public PrerequisiteReason addSucReason(Course aPrerequisite)
  {
    return new PrerequisiteReason(this, aPrerequisite);
  }

  public boolean addSucReason(PrerequisiteReason aSucReason)
  {
    boolean wasAdded = false;
    if (sucReason.contains(aSucReason)) { return false; }
    Course existingSuccessor = aSucReason.getSuccessor();
    boolean isNewSuccessor = existingSuccessor != null && !this.equals(existingSuccessor);
    if (isNewSuccessor)
    {
      aSucReason.setSuccessor(this);
    }
    else
    {
      sucReason.add(aSucReason);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSucReason(PrerequisiteReason aSucReason)
  {
    boolean wasRemoved = false;
    //Unable to remove aSucReason, as it must always have a successor
    if (!this.equals(aSucReason.getSuccessor()))
    {
      sucReason.remove(aSucReason);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSucReasonAt(PrerequisiteReason aSucReason, int index)
  {  
    boolean wasAdded = false;
    if(addSucReason(aSucReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSucReason()) { index = numberOfSucReason() - 1; }
      sucReason.remove(aSucReason);
      sucReason.add(index, aSucReason);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSucReasonAt(PrerequisiteReason aSucReason, int index)
  {
    boolean wasAdded = false;
    if(sucReason.contains(aSucReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSucReason()) { index = numberOfSucReason() - 1; }
      sucReason.remove(aSucReason);
      sucReason.add(index, aSucReason);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSucReasonAt(aSucReason, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPreReason()
  {
    return 0;
  }

  public PrerequisiteReason addPreReason(Course aSuccessor)
  {
    return new PrerequisiteReason(aSuccessor, this);
  }

  public boolean addPreReason(PrerequisiteReason aPreReason)
  {
    boolean wasAdded = false;
    if (preReason.contains(aPreReason)) { return false; }
    Course existingPrerequisite = aPreReason.getPrerequisite();
    boolean isNewPrerequisite = existingPrerequisite != null && !this.equals(existingPrerequisite);
    if (isNewPrerequisite)
    {
      aPreReason.setPrerequisite(this);
    }
    else
    {
      preReason.add(aPreReason);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePreReason(PrerequisiteReason aPreReason)
  {
    boolean wasRemoved = false;
    //Unable to remove aPreReason, as it must always have a prerequisite
    if (!this.equals(aPreReason.getPrerequisite()))
    {
      preReason.remove(aPreReason);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPreReasonAt(PrerequisiteReason aPreReason, int index)
  {  
    boolean wasAdded = false;
    if(addPreReason(aPreReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreReason()) { index = numberOfPreReason() - 1; }
      preReason.remove(aPreReason);
      preReason.add(index, aPreReason);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePreReasonAt(PrerequisiteReason aPreReason, int index)
  {
    boolean wasAdded = false;
    if(preReason.contains(aPreReason))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreReason()) { index = numberOfPreReason() - 1; }
      preReason.remove(aPreReason);
      preReason.add(index, aPreReason);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPreReasonAt(aPreReason, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMutex()
  {
    return 0;
  }

  public MutualExclusionReason addMutex(Course aIsMutuallyExclusiveWith)
  {
    return new MutualExclusionReason(this, aIsMutuallyExclusiveWith);
  }

  public boolean addMutex(MutualExclusionReason aMutex)
  {
    boolean wasAdded = false;
    if (mutex.contains(aMutex)) { return false; }
    Course existingCourse = aMutex.getCourse();
    boolean isNewCourse = existingCourse != null && !this.equals(existingCourse);
    if (isNewCourse)
    {
      aMutex.setCourse(this);
    }
    else
    {
      mutex.add(aMutex);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMutex(MutualExclusionReason aMutex)
  {
    boolean wasRemoved = false;
    //Unable to remove aMutex, as it must always have a course
    if (!this.equals(aMutex.getCourse()))
    {
      mutex.remove(aMutex);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMutexAt(MutualExclusionReason aMutex, int index)
  {  
    boolean wasAdded = false;
    if(addMutex(aMutex))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMutex()) { index = numberOfMutex() - 1; }
      mutex.remove(aMutex);
      mutex.add(index, aMutex);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMutexAt(MutualExclusionReason aMutex, int index)
  {
    boolean wasAdded = false;
    if(mutex.contains(aMutex))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMutex()) { index = numberOfMutex() - 1; }
      mutex.remove(aMutex);
      mutex.add(index, aMutex);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMutexAt(aMutex, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMutualExclusionReasons()
  {
    return 0;
  }

  public MutualExclusionReason addMutualExclusionReason(Course aCourse)
  {
    return new MutualExclusionReason(aCourse, this);
  }

  public boolean addMutualExclusionReason(MutualExclusionReason aMutualExclusionReason)
  {
    boolean wasAdded = false;
    if (mutualExclusionReasons.contains(aMutualExclusionReason)) { return false; }
    Course existingIsMutuallyExclusiveWith = aMutualExclusionReason.getIsMutuallyExclusiveWith();
    boolean isNewIsMutuallyExclusiveWith = existingIsMutuallyExclusiveWith != null && !this.equals(existingIsMutuallyExclusiveWith);
    if (isNewIsMutuallyExclusiveWith)
    {
      aMutualExclusionReason.setIsMutuallyExclusiveWith(this);
    }
    else
    {
      mutualExclusionReasons.add(aMutualExclusionReason);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMutualExclusionReason(MutualExclusionReason aMutualExclusionReason)
  {
    boolean wasRemoved = false;
    //Unable to remove aMutualExclusionReason, as it must always have a isMutuallyExclusiveWith
    if (!this.equals(aMutualExclusionReason.getIsMutuallyExclusiveWith()))
    {
      mutualExclusionReasons.remove(aMutualExclusionReason);
      wasRemoved = true;
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
    for(int i=sucReason.size(); i > 0; i--)
    {
      PrerequisiteReason aSucReason = sucReason.get(i - 1);
      aSucReason.delete();
    }
    for(int i=preReason.size(); i > 0; i--)
    {
      PrerequisiteReason aPreReason = preReason.get(i - 1);
      aPreReason.delete();
    }
    for(int i=mutex.size(); i > 0; i--)
    {
      MutualExclusionReason aMutex = mutex.get(i - 1);
      aMutex.delete();
    }
    for(int i=mutualExclusionReasons.size(); i > 0; i--)
    {
      MutualExclusionReason aMutualExclusionReason = mutualExclusionReasons.get(i - 1);
      aMutualExclusionReason.delete();
    }
  }

}