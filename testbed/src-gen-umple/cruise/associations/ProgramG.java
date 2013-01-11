/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 110 "../../../src/TestHarnessAssociations.ump"
public class ProgramG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramG Associations
  private MentorG mentor;
  private StudentG student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramG()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorG getMentor()
  {
    return mentor;
  }

  public StudentG getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorG newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorG existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorG currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramG existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentG newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentG existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentG currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramG existingProgram = newStudent.getProgram();

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