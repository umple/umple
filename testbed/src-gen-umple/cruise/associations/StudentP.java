/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 240 "../../../src/TestHarnessAssociations.ump"
public class StudentP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentP Attributes
  private int number;

  //StudentP Associations
  private ProgramP program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentP(int aNumber)
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

  public ProgramP getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramP newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramP existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramP currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentP existingStudent = newProgram.getStudent();

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