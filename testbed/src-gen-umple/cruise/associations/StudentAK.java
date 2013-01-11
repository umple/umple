/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 556 "../../../src/TestHarnessAssociations.ump"
public class StudentAK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAK Attributes
  private int number;

  //StudentAK Associations
  private ProgramAK program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAK(int aNumber)
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

  public ProgramAK getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramAK newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramAK existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramAK currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentAK existingStudent = newProgram.getStudent();

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