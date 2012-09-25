/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class MentorAI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAI Attributes
  private String name;

  //MentorAI Associations
  private StudentAI student;
  private ProgramAI program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAI(String aName)
  {
    name = aName;
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

  public StudentAI getStudent()
  {
    return student;
  }

  public ProgramAI getProgram()
  {
    return program;
  }

  public boolean setStudent(StudentAI newStudent)
  {
    boolean wasSet = false;
    student = newStudent;
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAI newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAI existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAI currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorAI existingMentor = newProgram.getMentor();

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