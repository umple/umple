/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.test;

public class ProgramAA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAA Associations
  private MentorAA mentor;
  private StudentAA student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAA()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAA getMentor()
  {
    return mentor;
  }

  public StudentAA getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAA newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAA existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAA currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAA existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAA newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAA existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAA currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAA existingProgram = newStudent.getProgram();

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