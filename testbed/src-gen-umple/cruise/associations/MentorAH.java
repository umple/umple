/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

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

  public boolean setStudent(StudentAH newStudent)
  {
    boolean wasSet = false;
    if (newStudent != null)
    {
      student = newStudent;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setProgram(ProgramAH newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAH existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
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

}