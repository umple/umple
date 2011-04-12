/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class ProgramP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramP Associations
  private MentorP mentor;
  private StudentP student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramP()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorP getMentor()
  {
    return mentor;
  }

  public StudentP getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorP newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorP existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorP currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramP existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentP newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentP existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentP currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramP existingProgram = newStudent.getProgram();

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