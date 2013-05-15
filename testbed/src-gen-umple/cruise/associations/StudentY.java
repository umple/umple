/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 384 "../../../src/TestHarnessAssociations.ump"
public class StudentY
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentY Attributes
  private int number;

  //StudentY Associations
  private ProgramY program;
  private MentorY mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentY(int aNumber)
  {
    number = aNumber;
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

  public ProgramY getProgram()
  {
    return program;
  }

  public MentorY getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramY aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramY existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramY currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentY existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorY aMentor)
  {
    boolean wasSet = false;
    if (aMentor != null && aMentor.numberOfStudents() >= MentorY.maximumNumberOfStudents())
    {
      return wasSet;
    }

    MentorY existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
    }
    if (aMentor != null)
    {
      aMentor.addStudent(this);
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
      MentorY placeholderMentor = mentor;
      this.mentor = null;
      placeholderMentor.removeStudent(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor" + "=" + getProgram() != null ? !getProgram() .equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + getMentor() != null ? !getMentor() .equals(this)  ? getMentor().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}