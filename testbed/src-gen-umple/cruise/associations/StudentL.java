/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;

// line 177 "../../../src/TestHarnessAssociations.ump"
public class StudentL
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentL Attributes
  private int number;

  //StudentL Associations
  private ProgramL program;
  private MentorL mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentL(int aNumber, MentorL aMentor)
  {
    number = aNumber;
    boolean didAddMentor = setMentor(aMentor);
    if (!didAddMentor)
    {
      throw new RuntimeException("Unable to create student due to mentor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public ProgramL getProgram()
  {
    return program;
  }

  public MentorL getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramL aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramL existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramL currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentL existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorL aMentor)
  {
    boolean wasSet = false;
    //Must provide mentor to student
    if (aMentor == null)
    {
      return wasSet;
    }

    //mentor already at maximum (2)
    if (aMentor.numberOfStudents() >= MentorL.maximumNumberOfStudents())
    {
      return wasSet;
    }
    
    MentorL existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      boolean didRemove = existingMentor.removeStudent(this);
      if (!didRemove)
      {
        mentor = existingMentor;
        return wasSet;
      }
    }
    mentor.addStudent(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudent(null);
    }
    MentorL placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "mentor = "+(getMentor()!=null?Integer.toHexString(System.identityHashCode(getMentor())):"null")
     + outputString;
  }
}