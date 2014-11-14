/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package MFP.core.red;

// line 36 "../../../../ManufactoringPlantController.ump"
// line 112 "../../../../ManufactoringPlantController.ump"
public class RobotAllocation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RobotAllocation Attributes
  private String timePeriod;

  //RobotAllocation Associations
  private AssemblyStep assemblyStep;
  private Robot robot;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RobotAllocation(String aTimePeriod, AssemblyStep aAssemblyStep, Robot aRobot)
  {
    timePeriod = aTimePeriod;
    boolean didAddAssemblyStep = setAssemblyStep(aAssemblyStep);
    if (!didAddAssemblyStep)
    {
      throw new RuntimeException("Unable to create robotAllocation due to assemblyStep");
    }
    boolean didAddRobot = setRobot(aRobot);
    if (!didAddRobot)
    {
      throw new RuntimeException("Unable to create robotAllocation due to robot");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimePeriod(String aTimePeriod)
  {
    boolean wasSet = false;
    timePeriod = aTimePeriod;
    wasSet = true;
    return wasSet;
  }

  public String getTimePeriod()
  {
    return timePeriod;
  }

  public AssemblyStep getAssemblyStep()
  {
    return assemblyStep;
  }

  public Robot getRobot()
  {
    return robot;
  }

  public boolean setAssemblyStep(AssemblyStep aAssemblyStep)
  {
    boolean wasSet = false;
    if (aAssemblyStep == null)
    {
      return wasSet;
    }

    AssemblyStep existingAssemblyStep = assemblyStep;
    assemblyStep = aAssemblyStep;
    if (existingAssemblyStep != null && !existingAssemblyStep.equals(aAssemblyStep))
    {
      existingAssemblyStep.removeRobotAllocation(this);
    }
    assemblyStep.addRobotAllocation(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setRobot(Robot aRobot)
  {
    boolean wasSet = false;
    if (aRobot == null)
    {
      return wasSet;
    }

    Robot existingRobot = robot;
    robot = aRobot;
    if (existingRobot != null && !existingRobot.equals(aRobot))
    {
      existingRobot.removeRobotAllocation(this);
    }
    robot.addRobotAllocation(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    AssemblyStep placeholderAssemblyStep = assemblyStep;
    this.assemblyStep = null;
    placeholderAssemblyStep.removeRobotAllocation(this);
    Robot placeholderRobot = robot;
    this.robot = null;
    placeholderRobot.removeRobotAllocation(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "timePeriod" + ":" + getTimePeriod()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "assemblyStep = "+(getAssemblyStep()!=null?Integer.toHexString(System.identityHashCode(getAssemblyStep())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "robot = "+(getRobot()!=null?Integer.toHexString(System.identityHashCode(getRobot())):"null")
     + outputString;
  }
}