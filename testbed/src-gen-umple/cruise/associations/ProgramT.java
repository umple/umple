/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramT
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramT Associations
  private MentorT mentor;
  private StudentT student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramT()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorT getMentor()
  {
    return mentor;
  }

  public StudentT getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorT newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorT existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorT currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramT existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentT newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentT existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentT currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramT existingProgram = newStudent.getProgram();

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