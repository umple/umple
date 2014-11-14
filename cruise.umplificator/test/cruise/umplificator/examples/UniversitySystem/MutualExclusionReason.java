/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * association MutualExclusionReason { 
 * Course;
 * Course isMutualyExclusiveWith;
 * }
 * Positioning
 */
// line 29 "UniversitySystem.ump"
// line 37 "UniversitySystem.ump"
public class MutualExclusionReason
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MutualExclusionReason Associations
  private Course course;
  private Course isMutuallyExclusiveWith;
  private List<Topic> overlappingMaterial;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MutualExclusionReason(Course aCourse, Course aIsMutuallyExclusiveWith)
  {
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create mutex due to course");
    }
    boolean didAddIsMutuallyExclusiveWith = setIsMutuallyExclusiveWith(aIsMutuallyExclusiveWith);
    if (!didAddIsMutuallyExclusiveWith)
    {
      throw new RuntimeException("Unable to create mutualExclusionReason due to isMutuallyExclusiveWith");
    }
    overlappingMaterial = new ArrayList<Topic>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Course getCourse()
  {
    return course;
  }

  public Course getIsMutuallyExclusiveWith()
  {
    return isMutuallyExclusiveWith;
  }

  public Topic getOverlappingMaterial(int index)
  {
    Topic aOverlappingMaterial = overlappingMaterial.get(index);
    return aOverlappingMaterial;
  }

  public List<Topic> getOverlappingMaterial()
  {
    List<Topic> newOverlappingMaterial = Collections.unmodifiableList(overlappingMaterial);
    return newOverlappingMaterial;
  }

  public int numberOfOverlappingMaterial()
  {
    int number = overlappingMaterial.size();
    return number;
  }

  public boolean hasOverlappingMaterial()
  {
    boolean has = overlappingMaterial.size() > 0;
    return has;
  }

  public int indexOfOverlappingMaterial(Topic aOverlappingMaterial)
  {
    int index = overlappingMaterial.indexOf(aOverlappingMaterial);
    return index;
  }

  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    if (aCourse == null)
    {
      return wasSet;
    }

    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeMutex(this);
    }
    course.addMutex(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setIsMutuallyExclusiveWith(Course aIsMutuallyExclusiveWith)
  {
    boolean wasSet = false;
    if (aIsMutuallyExclusiveWith == null)
    {
      return wasSet;
    }

    Course existingIsMutuallyExclusiveWith = isMutuallyExclusiveWith;
    isMutuallyExclusiveWith = aIsMutuallyExclusiveWith;
    if (existingIsMutuallyExclusiveWith != null && !existingIsMutuallyExclusiveWith.equals(aIsMutuallyExclusiveWith))
    {
      existingIsMutuallyExclusiveWith.removeMutualExclusionReason(this);
    }
    isMutuallyExclusiveWith.addMutualExclusionReason(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfOverlappingMaterial()
  {
    return 0;
  }

  public boolean addOverlappingMaterial(Topic aOverlappingMaterial)
  {
    boolean wasAdded = false;
    if (overlappingMaterial.contains(aOverlappingMaterial)) { return false; }
    overlappingMaterial.add(aOverlappingMaterial);
    if (aOverlappingMaterial.indexOfMutualExclusionReason(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOverlappingMaterial.addMutualExclusionReason(this);
      if (!wasAdded)
      {
        overlappingMaterial.remove(aOverlappingMaterial);
      }
    }
    return wasAdded;
  }

  public boolean removeOverlappingMaterial(Topic aOverlappingMaterial)
  {
    boolean wasRemoved = false;
    if (!overlappingMaterial.contains(aOverlappingMaterial))
    {
      return wasRemoved;
    }

    int oldIndex = overlappingMaterial.indexOf(aOverlappingMaterial);
    overlappingMaterial.remove(oldIndex);
    if (aOverlappingMaterial.indexOfMutualExclusionReason(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOverlappingMaterial.removeMutualExclusionReason(this);
      if (!wasRemoved)
      {
        overlappingMaterial.add(oldIndex,aOverlappingMaterial);
      }
    }
    return wasRemoved;
  }

  public boolean addOverlappingMaterialAt(Topic aOverlappingMaterial, int index)
  {  
    boolean wasAdded = false;
    if(addOverlappingMaterial(aOverlappingMaterial))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOverlappingMaterial()) { index = numberOfOverlappingMaterial() - 1; }
      overlappingMaterial.remove(aOverlappingMaterial);
      overlappingMaterial.add(index, aOverlappingMaterial);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOverlappingMaterialAt(Topic aOverlappingMaterial, int index)
  {
    boolean wasAdded = false;
    if(overlappingMaterial.contains(aOverlappingMaterial))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOverlappingMaterial()) { index = numberOfOverlappingMaterial() - 1; }
      overlappingMaterial.remove(aOverlappingMaterial);
      overlappingMaterial.add(index, aOverlappingMaterial);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOverlappingMaterialAt(aOverlappingMaterial, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Course placeholderCourse = course;
    this.course = null;
    placeholderCourse.removeMutex(this);
    Course placeholderIsMutuallyExclusiveWith = isMutuallyExclusiveWith;
    this.isMutuallyExclusiveWith = null;
    placeholderIsMutuallyExclusiveWith.removeMutualExclusionReason(this);
    ArrayList<Topic> copyOfOverlappingMaterial = new ArrayList<Topic>(overlappingMaterial);
    overlappingMaterial.clear();
    for(Topic aOverlappingMaterial : copyOfOverlappingMaterial)
    {
      aOverlappingMaterial.removeMutualExclusionReason(this);
    }
  }

}