/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 97 "../../../src/TestHarnessAssociations.ump"
public class MentorG
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  public boolean setProgram(ProgramG aNewProgram)
  {
    boolean wasSet = false;
    if (aNewProgram == null)
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
    if (currentProgram != null && !currentProgram.equals(aNewProgram))
    {
      currentProgram.setMentor(null);
    }

    program = aNewProgram;
    MentorG existingMentor = aNewProgram.getMentor();

    if (!equals(existingMentor))
    {
      aNewProgram.setMentor(this);
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + (getStudent() != null ? !getStudent().equals(this)  ? getStudent().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "student" + "=" + (getProgram() != null ? !getProgram().equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}