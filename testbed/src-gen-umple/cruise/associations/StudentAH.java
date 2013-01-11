/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 508 "../../../src/TestHarnessAssociations.ump"
public class StudentAH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAH Attributes
  private int number;

  //StudentAH Associations
  private ProgramAH program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAH(int aNumber)
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

  public ProgramAH getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramAH newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAH existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAH currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentAH existingStudent = newProgram.getStudent();

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