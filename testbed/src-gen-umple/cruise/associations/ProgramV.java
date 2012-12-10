/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 342 "../../../src/TestHarnessAssociations.ump"
public class ProgramV
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramV Associations
  private MentorV mentor;
  private StudentV student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramV()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorV getMentor()
  {
    return mentor;
  }

  public StudentV getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorV newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorV existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorV currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramV existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentV newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentV existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentV currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramV existingProgram = newStudent.getProgram();

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