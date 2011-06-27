/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;

public class ProgramO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramO Associations
  private MentorO mentor;
  private StudentO student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramO()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorO getMentor()
  {
    return mentor;
  }

  public StudentO getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorO newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorO existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorO currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramO existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentO newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentO existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentO currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramO existingProgram = newStudent.getProgram();

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