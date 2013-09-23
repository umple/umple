/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;

// line 71 "../../../src/TestHarnessAssociations.ump"
public class StudentE
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextX = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int x;

  //StudentE Associations
  private ProgramE program;
  private MentorE mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentE()
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

  public ProgramE getProgram()
  {
    return program;
  }

  public MentorE getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramE aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramE existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramE currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentE existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
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
    if (mentor != null)
    {
      if (mentor.numberOfStudents() <= 2)
      {
        mentor.delete();
      }
      else
      {
        MentorE placeholderMentor = mentor;
        this.mentor = null;
        placeholderMentor.removeStudent(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "x" + ":" + getX()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "mentor = "+(getMentor()!=null?Integer.toHexString(System.identityHashCode(getMentor())):"null")
     + outputString;
  }
}