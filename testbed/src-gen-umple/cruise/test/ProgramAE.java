/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;

public class ProgramAE
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAE Associations
  private MentorAE mentor;
  private StudentAE student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAE()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAE getMentor()
  {
    return mentor;
  }

  public StudentAE getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAE newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAE existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAE currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAE existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAE newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAE existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAE currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAE existingProgram = newStudent.getProgram();

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