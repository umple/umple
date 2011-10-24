/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;

public class StudentM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentM Attributes
  private int number;

  //StudentM Associations
  private ProgramM program;
  private MentorM mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentM(int aNumber, MentorM aMentor)
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

  public ProgramM getProgram()
  {
    return program;
  }

  public MentorM getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramM newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramM existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramM currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentM existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorM aMentor)
  {
    boolean wasSet = false;
    //Must provide mentor to student
    if (aMentor == null)
    {
      return wasSet;
    }

    if (mentor != null && mentor.numberOfStudents() <= MentorM.minimumNumberOfStudents())
    {
      return wasSet;
    }

    MentorM existingMentor = mentor;
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
    MentorM placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }

}