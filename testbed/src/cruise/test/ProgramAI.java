/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.test;

public class ProgramAI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAI Associations
  private MentorAI mentor;
  private StudentAI student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAI()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAI getMentor()
  {
    return mentor;
  }

  public StudentAI getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAI newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAI existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAI currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAI existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAI newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAI existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAI currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAI existingProgram = newStudent.getProgram();

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