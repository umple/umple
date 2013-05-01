/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 181 "../../../src/TestHarnessAssociations.ump"
public class ProgramL
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramL Associations
  private MentorL mentor;
  private StudentL student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramL()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorL getMentor()
  {
    return mentor;
  }

  public StudentL getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorL aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorL existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorL currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramL existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentL aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentL existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentL currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramL existingProgram = aNewStudent.getProgram();

    if (!equals(existingProgram))
    {
      aNewStudent.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentor != null)
    {
      mentor.setProgram(null);
    }
    if (student != null)
    {
      student.setProgram(null);
    }
  }

}