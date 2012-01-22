/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramJ Associations
  private MentorJ mentor;
  private StudentJ student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramJ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorJ getMentor()
  {
    return mentor;
  }

  public StudentJ getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorJ newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorJ existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorJ currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramJ existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentJ newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentJ existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentJ currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramJ existingProgram = newStudent.getProgram();

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