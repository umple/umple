/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 358 "../../../src/TestHarnessAssociations.ump"
public class ProgramW
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramW Associations
  private MentorW mentor;
  private StudentW student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramW()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorW getMentor()
  {
    return mentor;
  }

  public StudentW getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorW aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorW existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorW currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramW existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentW aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentW existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentW currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramW existingProgram = aNewStudent.getProgram();

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