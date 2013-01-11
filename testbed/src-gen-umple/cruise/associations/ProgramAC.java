/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 454 "../../../src/TestHarnessAssociations.ump"
public class ProgramAC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAC Associations
  private MentorAC mentor;
  private StudentAC student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAC()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAC getMentor()
  {
    return mentor;
  }

  public StudentAC getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAC newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAC existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAC currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAC existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAC newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAC existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAC currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAC existingProgram = newStudent.getProgram();

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