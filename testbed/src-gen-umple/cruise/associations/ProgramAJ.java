/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramAJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAJ Associations
  private MentorAJ mentor;
  private StudentAJ student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAJ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAJ getMentor()
  {
    return mentor;
  }

  public StudentAJ getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAJ newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAJ existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAJ currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAJ existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAJ newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAJ existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAJ currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAJ existingProgram = newStudent.getProgram();

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