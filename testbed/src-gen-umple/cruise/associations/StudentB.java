/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

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

  public boolean setProgram(ProgramB aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentB existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorB aNewMentor)
  {
    boolean wasSet = false;
    if (mentor != null && !mentor.equals(aNewMentor) && equals(mentor.getStudent()))
    {
      //Unable to setMentor, as existing mentor would become an orphan
      return wasSet;
    }

    mentor = aNewMentor;
    StudentB anOldStudent = aNewMentor != null ? aNewMentor.getStudent() : null;

    if (!this.equals(anOldStudent))
    {
      if (anOldStudent != null)
      {
        anOldStudent.mentor = null;
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