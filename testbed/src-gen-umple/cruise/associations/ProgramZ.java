/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 406 "../../../src/TestHarnessAssociations.ump"
public class ProgramZ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramZ Associations
  private MentorZ mentor;
  private StudentZ student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramZ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorZ getMentor()
  {
    return mentor;
  }

  public StudentZ getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorZ newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorZ existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorZ currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramZ existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentZ newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentZ existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentZ currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramZ existingProgram = newStudent.getProgram();

    if (!equals(existingProgram))
    {
      newStudent.setProgram(this);
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