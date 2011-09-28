/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.test;

public class StudentK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentK Attributes
  private int number;

  //StudentK Associations
  private ProgramK program;
  private MentorK mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentK(int aNumber, MentorK aMentor)
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

  public ProgramK getProgram()
  {
    return program;
  }

  public MentorK getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramK newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramK existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramK currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentK existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorK aMentor)
  {
    boolean wasSet = false;
    //Must provide mentor to student
    if (aMentor == null)
    {
      return wasSet;
    }

    //mentor already at maximum (3)
    if (aMentor.numberOfStudents() >= MentorK.maximumNumberOfStudents())
    {
      return wasSet;
    }
    
    MentorK existingMentor = mentor;
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
    MentorK placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }

}