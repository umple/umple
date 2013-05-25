/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 517 "../../../src/TestHarnessAssociations.ump"
public class MentorAI
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setStudent(StudentAI aNewStudent)
  {
    boolean wasSet = false;
    student = aNewStudent;
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramAI aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentor(null);
    }

    program = aNewProgram;
    MentorAI existingMentor = aNewProgram.getMentor();

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
            "  " + "program" + "=" + (getStudent() != null ? !getStudent().equals(this)  ? getStudent().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "student" + "=" + (getProgram() != null ? !getProgram().equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}