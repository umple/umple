/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 44 "ElevatorSystemB.ump"
// line 87 "ElevatorSystemB.ump"
public class UpCallButton extends Button
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UpCallButton Associations
  private List<Elevator> elevators;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UpCallButton(boolean aLightOn, Elevator... allElevators)
  {
    super(aLightOn);
    elevators = new ArrayList<Elevator>();
    boolean didAddElevators = setElevators(allElevators);
    if (!didAddElevators)
    {
      throw new RuntimeException("Unable to create UpCallButton, must have at least 1 elevators");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Elevator getElevator(int index)
  {
    Elevator aElevator = elevators.get(index);
    return aElevator;
  }

  public List<Elevator> getElevators()
  {
    List<Elevator> newElevators = Collections.unmodifiableList(elevators);
    return newElevators;
  }

  public int numberOfElevators()
  {
    int number = elevators.size();
    return number;
  }

  public boolean hasElevators()
  {
    boolean has = elevators.size() > 0;
    return has;
  }

  public int indexOfElevator(Elevator aElevator)
  {
    int index = elevators.indexOf(aElevator);
    return index;
  }

  public boolean isNumberOfElevatorsValid()
  {
    boolean isValid = numberOfElevators() >= minimumNumberOfElevators();
    return isValid;
  }

  public static int minimumNumberOfElevators()
  {
    return 1;
  }

  public boolean addElevator(Elevator aElevator)
  {
    boolean wasAdded = false;
    if (elevators.contains(aElevator)) { return false; }
    elevators.add(aElevator);
    if (aElevator.indexOfUpCallButton(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aElevator.addUpCallButton(this);
      if (!wasAdded)
      {
        elevators.remove(aElevator);
      }
    }
    return wasAdded;
  }

  public boolean removeElevator(Elevator aElevator)
  {
    boolean wasRemoved = false;
    if (!elevators.contains(aElevator))
    {
      return wasRemoved;
    }

    if (numberOfElevators() <= minimumNumberOfElevators())
    {
      return wasRemoved;
    }

    int oldIndex = elevators.indexOf(aElevator);
    elevators.remove(oldIndex);
    if (aElevator.indexOfUpCallButton(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aElevator.removeUpCallButton(this);
      if (!wasRemoved)
      {
        elevators.add(oldIndex,aElevator);
      }
    }
    return wasRemoved;
  }

  public boolean setElevators(Elevator... newElevators)
  {
    boolean wasSet = false;
    ArrayList<Elevator> verifiedElevators = new ArrayList<Elevator>();
    for (Elevator aElevator : newElevators)
    {
      if (verifiedElevators.contains(aElevator))
      {
        continue;
      }
      verifiedElevators.add(aElevator);
    }

    if (verifiedElevators.size() != newElevators.length || verifiedElevators.size() < minimumNumberOfElevators())
    {
      return wasSet;
    }

    ArrayList<Elevator> oldElevators = new ArrayList<Elevator>(elevators);
    elevators.clear();
    for (Elevator aNewElevator : verifiedElevators)
    {
      elevators.add(aNewElevator);
      if (oldElevators.contains(aNewElevator))
      {
        oldElevators.remove(aNewElevator);
      }
      else
      {
        aNewElevator.addUpCallButton(this);
      }
    }

    for (Elevator anOldElevator : oldElevators)
    {
      anOldElevator.removeUpCallButton(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addElevatorAt(Elevator aElevator, int index)
  {  
    boolean wasAdded = false;
    if(addElevator(aElevator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElevators()) { index = numberOfElevators() - 1; }
      elevators.remove(aElevator);
      elevators.add(index, aElevator);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveElevatorAt(Elevator aElevator, int index)
  {
    boolean wasAdded = false;
    if(elevators.contains(aElevator))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfElevators()) { index = numberOfElevators() - 1; }
      elevators.remove(aElevator);
      elevators.add(index, aElevator);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addElevatorAt(aElevator, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Elevator> copyOfElevators = new ArrayList<Elevator>(elevators);
    elevators.clear();
    for(Elevator aElevator : copyOfElevators)
    {
      aElevator.removeUpCallButton(this);
    }
    super.delete();
  }

}