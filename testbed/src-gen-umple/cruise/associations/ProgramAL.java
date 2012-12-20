/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 578 "../../../src/TestHarnessAssociations.ump"
public class ProgramAL
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAL Associations
  private MentorAL mentor;
  private StudentAL student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAL()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAL getMentor()
  {
    return mentor;
  }

  public StudentAL getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAL newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorAL existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAL currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramAL existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAL newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentAL existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAL currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramAL existingProgram = newStudent.getProgram();

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