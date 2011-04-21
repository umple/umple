/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.test;

public class ProgramAD
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAD Associations
  private MentorAD mentor;
  private StudentAD student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAD()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAD getMentor()
  {
    return mentor;
  }

  public StudentAD getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAD newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAD existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAD currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAD existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAD newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAD existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAD currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAD existingProgram = newStudent.getProgram();

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