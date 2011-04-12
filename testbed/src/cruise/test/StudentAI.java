/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class StudentAI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAI Attributes
  private int number;

  //StudentAI Associations
  private ProgramAI program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAI(int aNumber)
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

  public ProgramAI getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramAI newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAI existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAI currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentAI existingStudent = newProgram.getStudent();

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
  }

}