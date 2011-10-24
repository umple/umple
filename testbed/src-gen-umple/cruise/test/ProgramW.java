/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;

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

  public boolean setMentor(MentorW newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
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
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramW existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentW newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
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
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramW existingProgram = newStudent.getProgram();

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