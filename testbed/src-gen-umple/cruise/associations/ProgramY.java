/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ProgramY
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramY Associations
  private MentorY mentor;
  private StudentY student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramY()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorY getMentor()
  {
    return mentor;
  }

  public StudentY getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorY newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorY existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorY currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramY existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentY newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentY existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentY currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramY existingProgram = newStudent.getProgram();

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