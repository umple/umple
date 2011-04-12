/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class StudentZ
{

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

  public boolean setProgram(ProgramZ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentZ existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
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
    mentor.removeStudent(this);
  }

}