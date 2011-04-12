/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.test;

public class ProgramQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramQ Associations
  private MentorQ mentor;
  private StudentQ student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramQ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorQ getMentor()
  {
    return mentor;
  }

  public StudentQ getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorQ newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorQ existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorQ currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramQ existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentQ newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentQ existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentQ currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramQ existingProgram = newStudent.getProgram();

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