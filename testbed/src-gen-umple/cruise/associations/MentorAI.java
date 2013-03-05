/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 517 "../../../src/TestHarnessAssociations.ump"
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