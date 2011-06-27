/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;

public class StudentG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentG Attributes
  private int number;

  //StudentG Associations
  private ProgramG program;
  private MentorG mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentG(int aNumber, MentorG aMentor)
  {
    number = aNumber;
    if (aMentor == null || aMentor.getStudent() != null)
    {
      throw new RuntimeException("Unable to create StudentG due to aMentor");
    }
    mentor = aMentor;
  }

  public StudentG(int aNumber, String aNameForMentor)
  {
    number = aNumber;
    mentor = new MentorG(aNameForMentor, this);
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

  public ProgramG getProgram()
  {
    return program;
  }

  public MentorG getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramG newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramG existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramG currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentG existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
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
    MentorG existingMentor = mentor;
    mentor = null;
    if (existingMentor != null)
    {
      existingMentor.delete();
    }
  }

}