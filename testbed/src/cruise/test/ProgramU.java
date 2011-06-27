/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;

public class ProgramU
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramU Associations
  private MentorU mentor;
  private StudentU student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramU()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorU getMentor()
  {
    return mentor;
  }

  public StudentU getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorU newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorU existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorU currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramU existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentU newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentU existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentU currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramU existingProgram = newStudent.getProgram();

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