/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 400 "../../../src/TestHarnessAssociations.ump"
public class StudentZ
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentZ Attributes
  private int number;

  //StudentZ Associations
  private ProgramZ program;
  private MentorZ mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentZ(int aNumber, MentorZ aMentor)
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

  public ProgramZ getProgram()
  {
    return program;
  }

  public MentorZ getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramZ aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
    {
      ProgramZ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramZ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudent(null);
    }

    program = aNewProgram;
    StudentZ existingStudent = aNewProgram.getStudent();

    if (!equals(existingStudent))
    {
      aNewProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorZ aMentor)
  {
    boolean wasSet = false;
    //Must provide mentor to student
    if (aMentor == null)
    {
      return wasSet;
    }

    //mentor already at maximum (3)
    if (aMentor.numberOfStudents() >= MentorZ.maximumNumberOfStudents())
    {
      return wasSet;
    }
    
    MentorZ existingMentor = mentor;
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
    MentorZ placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor" + "=" + (getProgram() != null ? !getProgram().equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + (getMentor() != null ? !getMentor().equals(this)  ? getMentor().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}