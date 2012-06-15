/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class StudentL
{

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

  public boolean setProgram(ProgramL newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentL existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
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

}