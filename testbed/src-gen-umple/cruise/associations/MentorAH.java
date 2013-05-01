/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 501 "../../../src/TestHarnessAssociations.ump"
public class MentorAH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAH Attributes
  private String name;

  //MentorAH Associations
  private StudentAH student;
  private ProgramAH program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAH(String aName, StudentAH aStudent)
  {
    name = aName;
    if (!setStudent(aStudent))
    {
      throw new RuntimeException("Unable to create MentorAH due to aStudent");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public StudentAH getStudent()
  {
    return student;
  }

  public ProgramAH getProgram()
  {
    return program;
  }

  public boolean setStudent(StudentAH aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent != null)
    {
      student = aNewStudent;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setProgram(ProgramAH aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramAH existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAH currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentor(null);
    }

    program = aNewProgram;
    MentorAH existingMentor = aNewProgram.getMentor();

    if (!equals(existingMentor))
    {
      aNewProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    student = null;
    if (program != null)
    {
      program.setMentor(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + getStudent() != null ? !getStudent() .equals(this)  ? getStudent().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "student" + "=" + getProgram() != null ? !getProgram() .equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}