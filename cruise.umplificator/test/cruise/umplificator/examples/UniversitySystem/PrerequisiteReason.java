/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * association PrerequisiteReason { 
 * Course successor;
 * Course prerequisite;
 * }
 */
// line 19 "UniversitySystem.ump"
// line 45 "UniversitySystem.ump"
public class PrerequisiteReason
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PrerequisiteReason Associations
  private Course successor;
  private Course prerequisite;
  private List<Topic> materialNeededBySuccessor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PrerequisiteReason(Course aSuccessor, Course aPrerequisite)
  {
    boolean didAddSuccessor = setSuccessor(aSuccessor);
    if (!didAddSuccessor)
    {
      throw new RuntimeException("Unable to create sucReason due to successor");
    }
    boolean didAddPrerequisite = setPrerequisite(aPrerequisite);
    if (!didAddPrerequisite)
    {
      throw new RuntimeException("Unable to create preReason due to prerequisite");
    }
    materialNeededBySuccessor = new ArrayList<Topic>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Course getSuccessor()
  {
    return successor;
  }

  public Course getPrerequisite()
  {
    return prerequisite;
  }

  public Topic getMaterialNeededBySuccessor(int index)
  {
    Topic aMaterialNeededBySuccessor = materialNeededBySuccessor.get(index);
    return aMaterialNeededBySuccessor;
  }

  public List<Topic> getMaterialNeededBySuccessor()
  {
    List<Topic> newMaterialNeededBySuccessor = Collections.unmodifiableList(materialNeededBySuccessor);
    return newMaterialNeededBySuccessor;
  }

  public int numberOfMaterialNeededBySuccessor()
  {
    int number = materialNeededBySuccessor.size();
    return number;
  }

  public boolean hasMaterialNeededBySuccessor()
  {
    boolean has = materialNeededBySuccessor.size() > 0;
    return has;
  }

  public int indexOfMaterialNeededBySuccessor(Topic aMaterialNeededBySuccessor)
  {
    int index = materialNeededBySuccessor.indexOf(aMaterialNeededBySuccessor);
    return index;
  }

  public boolean setSuccessor(Course aSuccessor)
  {
    boolean wasSet = false;
    if (aSuccessor == null)
    {
      return wasSet;
    }

    Course existingSuccessor = successor;
    successor = aSuccessor;
    if (existingSuccessor != null && !existingSuccessor.equals(aSuccessor))
    {
      existingSuccessor.removeSucReason(this);
    }
    successor.addSucReason(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPrerequisite(Course aPrerequisite)
  {
    boolean wasSet = false;
    if (aPrerequisite == null)
    {
      return wasSet;
    }

    Course existingPrerequisite = prerequisite;
    prerequisite = aPrerequisite;
    if (existingPrerequisite != null && !existingPrerequisite.equals(aPrerequisite))
    {
      existingPrerequisite.removePreReason(this);
    }
    prerequisite.addPreReason(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfMaterialNeededBySuccessor()
  {
    return 0;
  }

  public boolean addMaterialNeededBySuccessor(Topic aMaterialNeededBySuccessor)
  {
    boolean wasAdded = false;
    if (materialNeededBySuccessor.contains(aMaterialNeededBySuccessor)) { return false; }
    materialNeededBySuccessor.add(aMaterialNeededBySuccessor);
    if (aMaterialNeededBySuccessor.indexOfPrerequisiteReason(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMaterialNeededBySuccessor.addPrerequisiteReason(this);
      if (!wasAdded)
      {
        materialNeededBySuccessor.remove(aMaterialNeededBySuccessor);
      }
    }
    return wasAdded;
  }

  public boolean removeMaterialNeededBySuccessor(Topic aMaterialNeededBySuccessor)
  {
    boolean wasRemoved = false;
    if (!materialNeededBySuccessor.contains(aMaterialNeededBySuccessor))
    {
      return wasRemoved;
    }

    int oldIndex = materialNeededBySuccessor.indexOf(aMaterialNeededBySuccessor);
    materialNeededBySuccessor.remove(oldIndex);
    if (aMaterialNeededBySuccessor.indexOfPrerequisiteReason(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMaterialNeededBySuccessor.removePrerequisiteReason(this);
      if (!wasRemoved)
      {
        materialNeededBySuccessor.add(oldIndex,aMaterialNeededBySuccessor);
      }
    }
    return wasRemoved;
  }

  public boolean addMaterialNeededBySuccessorAt(Topic aMaterialNeededBySuccessor, int index)
  {  
    boolean wasAdded = false;
    if(addMaterialNeededBySuccessor(aMaterialNeededBySuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMaterialNeededBySuccessor()) { index = numberOfMaterialNeededBySuccessor() - 1; }
      materialNeededBySuccessor.remove(aMaterialNeededBySuccessor);
      materialNeededBySuccessor.add(index, aMaterialNeededBySuccessor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMaterialNeededBySuccessorAt(Topic aMaterialNeededBySuccessor, int index)
  {
    boolean wasAdded = false;
    if(materialNeededBySuccessor.contains(aMaterialNeededBySuccessor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMaterialNeededBySuccessor()) { index = numberOfMaterialNeededBySuccessor() - 1; }
      materialNeededBySuccessor.remove(aMaterialNeededBySuccessor);
      materialNeededBySuccessor.add(index, aMaterialNeededBySuccessor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMaterialNeededBySuccessorAt(aMaterialNeededBySuccessor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Course placeholderSuccessor = successor;
    this.successor = null;
    placeholderSuccessor.removeSucReason(this);
    Course placeholderPrerequisite = prerequisite;
    this.prerequisite = null;
    placeholderPrerequisite.removePreReason(this);
    ArrayList<Topic> copyOfMaterialNeededBySuccessor = new ArrayList<Topic>(materialNeededBySuccessor);
    materialNeededBySuccessor.clear();
    for(Topic aMaterialNeededBySuccessor : copyOfMaterialNeededBySuccessor)
    {
      aMaterialNeededBySuccessor.removePrerequisiteReason(this);
    }
  }

}