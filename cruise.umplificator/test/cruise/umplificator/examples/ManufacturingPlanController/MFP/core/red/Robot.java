/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.red;
import java.util.*;

// line 34 "../../../../ManufacturingPlantController.ump"
// line 149 "../../../../ManufacturingPlantController.ump"
public class Robot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Robot Attributes
  private String number;

  //Robot Associations
  private List<RobotAllocation> robotAllocations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Robot(String aNumber)
  {
    number = aNumber;
    robotAllocations = new ArrayList<RobotAllocation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public String getNumber()
  {
    return number;
  }

  public RobotAllocation getRobotAllocation(int index)
  {
    RobotAllocation aRobotAllocation = robotAllocations.get(index);
    return aRobotAllocation;
  }

  public List<RobotAllocation> getRobotAllocations()
  {
    List<RobotAllocation> newRobotAllocations = Collections.unmodifiableList(robotAllocations);
    return newRobotAllocations;
  }

  public int numberOfRobotAllocations()
  {
    int number = robotAllocations.size();
    return number;
  }

  public boolean hasRobotAllocations()
  {
    boolean has = robotAllocations.size() > 0;
    return has;
  }

  public int indexOfRobotAllocation(RobotAllocation aRobotAllocation)
  {
    int index = robotAllocations.indexOf(aRobotAllocation);
    return index;
  }

  public static int minimumNumberOfRobotAllocations()
  {
    return 0;
  }

  public RobotAllocation addRobotAllocation(String aTimePeriod, AssemblyStep aAssemblyStep)
  {
    return new RobotAllocation(aTimePeriod, aAssemblyStep, this);
  }

  public boolean addRobotAllocation(RobotAllocation aRobotAllocation)
  {
    boolean wasAdded = false;
    if (robotAllocations.contains(aRobotAllocation)) { return false; }
    Robot existingRobot = aRobotAllocation.getRobot();
    boolean isNewRobot = existingRobot != null && !this.equals(existingRobot);
    if (isNewRobot)
    {
      aRobotAllocation.setRobot(this);
    }
    else
    {
      robotAllocations.add(aRobotAllocation);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRobotAllocation(RobotAllocation aRobotAllocation)
  {
    boolean wasRemoved = false;
    //Unable to remove aRobotAllocation, as it must always have a robot
    if (!this.equals(aRobotAllocation.getRobot()))
    {
      robotAllocations.remove(aRobotAllocation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRobotAllocationAt(RobotAllocation aRobotAllocation, int index)
  {  
    boolean wasAdded = false;
    if(addRobotAllocation(aRobotAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRobotAllocations()) { index = numberOfRobotAllocations() - 1; }
      robotAllocations.remove(aRobotAllocation);
      robotAllocations.add(index, aRobotAllocation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRobotAllocationAt(RobotAllocation aRobotAllocation, int index)
  {
    boolean wasAdded = false;
    if(robotAllocations.contains(aRobotAllocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRobotAllocations()) { index = numberOfRobotAllocations() - 1; }
      robotAllocations.remove(aRobotAllocation);
      robotAllocations.add(index, aRobotAllocation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRobotAllocationAt(aRobotAllocation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=robotAllocations.size(); i > 0; i--)
    {
      RobotAllocation aRobotAllocation = robotAllocations.get(i - 1);
      aRobotAllocation.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]"
     + outputString;
  }
}