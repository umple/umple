/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class ProgramE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramE Associations
  private MentorE mentor;
  private StudentE student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramE()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorE getMentor()
  {
    return mentor;
  }

  public StudentE getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorE newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorE existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorE currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramE existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentE newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentE existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentE currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramE existingProgram = newStudent.getProgram();

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