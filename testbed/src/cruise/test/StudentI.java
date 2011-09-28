/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.test;

public class StudentI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentI Attributes
  private int number;

  //StudentI Associations
  private ProgramI program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentI(int aNumber)
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

  public ProgramI getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramI newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramI existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudentI() != null)
      {
        existingProgram.setStudentI(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramI currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudentI(null);
    }

    program = newProgram;
    StudentI existingStudentI = newProgram.getStudentI();

    if (!equals(existingStudentI))
    {
      newProgram.setStudentI(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (program != null)
    {
      program.setStudentI(null);
    }
  }

}