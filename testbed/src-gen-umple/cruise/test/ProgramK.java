/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.test;

public class ProgramK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramK Associations
  private MentorK mentor;
  private StudentK student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramK()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorK getMentor()
  {
    return mentor;
  }

  public StudentK getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorK newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorK existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorK currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramK existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentK newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentK existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentK currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramK existingProgram = newStudent.getProgram();

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