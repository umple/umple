/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ProgramF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramF Associations
  private MentorF mentor;
  private StudentF student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramF()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorF getMentor()
  {
    return mentor;
  }

  public StudentF getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorF newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorF existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorF currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramF existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentF newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentF existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentF currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramF existingProgram = newStudent.getProgram();

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