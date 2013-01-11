/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 294 "../../../src/TestHarnessAssociations.ump"
public class ProgramS
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramS Associations
  private MentorS mentor;
  private StudentS student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramS()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorS getMentor()
  {
    return mentor;
  }

  public StudentS getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorS newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorS existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorS currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = newMentor;
    ProgramS existingProgram = newMentor.getProgram();

    if (!equals(existingProgram))
    {
      newMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentS newStudent)
  {
    boolean wasSet = false;
    if (newStudent == null)
    {
      StudentS existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentS currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(newStudent))
    {
      currentStudent.setProgram(null);
    }

    student = newStudent;
    ProgramS existingProgram = newStudent.getProgram();

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