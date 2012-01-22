/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramL
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramL Associations
  private MentorL mentor;
  private StudentL student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramL()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorL getMentor()
  {
    return mentor;
  }

  public StudentL getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorL newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorL existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorL currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramL existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentL newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentL existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentL currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramL existingProgram = newStudent.getProgram();

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