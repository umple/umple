/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 97 "../../../src/TestHarnessAssociations.ump"
public class MentorG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorG Attributes
  private String name;

  //MentorG Associations
  private StudentG student;
  private ProgramG program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorG(String aName, StudentG aStudent)
  {
    name = aName;
    if (aStudent == null || aStudent.getMentor() != null)
    {
      throw new RuntimeException("Unable to create MentorG due to aStudent");
    }
    student = aStudent;
  }

  public MentorG(String aName, int aNumberForStudent)
  {
    name = aName;
    student = new StudentG(aNumberForStudent, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public StudentG getStudent()
  {
    return student;
  }

  public ProgramG getProgram()
  {
    return program;
  }

  public boolean setProgram(ProgramG newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramG existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getMentor() != null)
      {
        existingProgram.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramG currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setMentor(null);
    }

    program = newProgram;
    MentorG existingMentor = newProgram.getMentor();

    if (!equals(existingMentor))
    {
      newProgram.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    StudentG existingStudent = student;
    student = null;
    if (existingStudent != null)
    {
      existingStudent.delete();
    }
    if (program != null)
    {
      program.setMentor(null);
    }
  }

}