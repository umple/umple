/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class ProgramAH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAH Associations
  private MentorAH mentor;
  private StudentAH student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAH()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAH getMentor()
  {
    return mentor;
  }

  public StudentAH getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAH newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAH existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAH currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAH existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAH newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAH existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAH currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAH existingProgram = newStudent.getProgram();

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