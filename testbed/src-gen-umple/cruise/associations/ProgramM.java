/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ProgramM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramM Associations
  private MentorM mentor;
  private StudentM student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramM()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorM getMentor()
  {
    return mentor;
  }

  public StudentM getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorM newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorM existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorM currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramM existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentM newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentM existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentM currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramM existingProgram = newStudent.getProgram();

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