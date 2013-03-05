/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 143 "../../../src/TestHarnessAssociations.ump"
public class StudentJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentJ Attributes
  private int number;

  //StudentJ Associations
  private ProgramJ program;
  private MentorJ mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentJ(int aNumber, MentorJ aMentor)
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

  public ProgramJ getProgram()
  {
    return program;
  }

  public MentorJ getMentor()
  {
    return mentor;
  }

  public boolean setProgram(ProgramJ newProgram)
  {
    boolean wasSet = false;
    if (newProgram == null)
    {
      ProgramJ existingProgram = program;
      program = null;
      
      if (existingProgram != null && existingProgram.getStudent() != null)
      {
        existingProgram.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    ProgramJ currentProgram = getProgram();
    if (currentProgram != null && !currentProgram.equals(newProgram))
    {
      currentProgram.setStudent(null);
    }

    program = newProgram;
    StudentJ existingStudent = newProgram.getStudent();

    if (!equals(existingStudent))
    {
      newProgram.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMentor(MentorJ aMentor)
  {
    boolean wasSet = false;
    if (aMentor == null)
    {
      return wasSet;
    }

    MentorJ existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
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
    MentorJ placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mentor" + "=" + getProgram() != null ? !getProgram() .equals(this)  ? getProgram().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "program" + "=" + getMentor() != null ? !getMentor() .equals(this)  ? getMentor().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}