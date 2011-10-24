/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;

public class ProgramN
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramN Associations
  private MentorN mentor;
  private StudentN student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramN()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorN getMentor()
  {
    return mentor;
  }

  public StudentN getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorN newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorN existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorN currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramN existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentN newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentN existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentN currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramN existingProgram = newStudent.getProgram();

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