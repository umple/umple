/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramX
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramX Associations
  private MentorX mentor;
  private StudentX student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramX()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorX getMentor()
  {
    return mentor;
  }

  public StudentX getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorX newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorX existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorX currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramX existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentX newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentX existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentX currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramX existingProgram = newStudent.getProgram();

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