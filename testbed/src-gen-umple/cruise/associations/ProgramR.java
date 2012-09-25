/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class ProgramR
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramR Associations
  private MentorR mentor;
  private StudentR student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramR()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorR getMentor()
  {
    return mentor;
  }

  public StudentR getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorR newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorR existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorR currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramR existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentR newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentR existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentR currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramR existingProgram = newStudent.getProgram();

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