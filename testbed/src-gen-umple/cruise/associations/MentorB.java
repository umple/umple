/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

package cruise.associations;

// line 13 "../../../src/TestHarnessAssociations.ump"
public class MentorB
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextY = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int y;

  //MentorB Associations
  private StudentB student;
  private ProgramB program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorB(StudentB aStudent)
  {
    y = nextY++;
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create mentor due to student");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getY()
  {
    return y;
  }

  public StudentB getStudent()
  {
    return student;
  }

  public ProgramB getProgram()
  {
    return program;
  }

  public boolean setStudent(StudentB aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      //Unable to setStudent to null, as mentor must always be associated to a student
      return wasSet;
    }
    
    MentorB existingMentor = aNewStudent.getMentor();
    if (existingMentor != null && !equals(existingMentor))
    {
      //Unable to setStudent, the current student already has a mentor, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    StudentB anOldStudent = student;
    student = aNewStudent;
    student.setMentor(this);

    if (anOldStudent != null)
    {
      anOldStudent.setMentor(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(ProgramB aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramB existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramB currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentor(null);
    }

    program = aNewProgram;
    MentorB existingMentor = aNewProgram.getMentor();

    if (!equals(existingMentor))
    {
      aNewProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    StudentB existingStudent = student;
    student = null;
    if (existingStudent != null)
    {
      existingStudent.setMentor(null);
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "y" + ":" + getY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "student = "+(getStudent()!=null?Integer.toHexString(System.identityHashCode(getStudent())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null")
     + outputString;
  }
}