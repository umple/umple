/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ProgramC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramC Associations
  private MentorC mentor;
  private StudentC student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramC()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorC getMentor()
  {
    return mentor;
  }

  public StudentC getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorC newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorC existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorC currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramC existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentC newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentC existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentC currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramC existingProgram = newStudent.getProgram();

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