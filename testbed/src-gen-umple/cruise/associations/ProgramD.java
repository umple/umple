/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramD Associations
  private MentorD mentor;
  private StudentD student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramD()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorD getMentor()
  {
    return mentor;
  }

  public StudentD getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorD newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorD existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorD currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramD existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentD newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentD existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentD currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramD existingProgram = newStudent.getProgram();

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