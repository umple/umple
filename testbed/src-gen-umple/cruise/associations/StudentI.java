/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;

// line 129 "../../../src/TestHarnessAssociations.ump"
public class StudentI
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setProgram(ProgramI aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setStudentI(null);
    }

    program = aNewProgram;
    StudentI existingStudentI = aNewProgram.getStudentI();

    if (!equals(existingStudentI))
    {
      aNewProgram.setStudentI(this);
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program = "+(getProgram()!=null?Integer.toHexString(System.identityHashCode(getProgram())):"null")
     + outputString;
  }
}