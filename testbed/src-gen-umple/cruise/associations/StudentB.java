/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 18 "../../../src/TestHarnessAssociations.ump"
public class StudentB
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextX = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int x;

  //StudentB Associations
  private ProgramB program;
  private MentorB mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentB()
  {
    x = nextX++;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getX()
  {
    return x;
  }

  public ProgramB getProgram()
  {
    return program;
  }

  public MentorB getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramB newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramB existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramB currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentB existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorB newMentor)
  {
    boolean wasSet = false;
    if (mentor != null && !mentor.equals(newMentor) && equals(mentor.getStudent()))
    {
      //Unable to setMentor, as existing mentor would become an orphan
      return wasSet;
    }

    mentor = newMentor;
    StudentB oldStudent = newMentor != null ? newMentor.getStudent() : null;

    if (!this.equals(oldStudent))
    {
      if (oldStudent != null)
      {
        oldStudent.mentor = null;
      }
      if (mentor != null)
      {
        mentor.setStudent(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    MentorB existingMentor = mentor;
    mentor = null;
    if (existingMentor != null)
    {
      existingMentor.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "x" + ":" + getX()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor" + "=" + getProgram() != null ? !getProgram() .equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + getMentor() != null ? !getMentor() .equals(this)  ? getMentor().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}