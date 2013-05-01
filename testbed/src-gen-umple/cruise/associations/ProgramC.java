/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.associations;

// line 45 "../../../src/TestHarnessAssociations.ump"
public class ProgramC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramC Associations
  private MentorC mentor;
  private StudentC student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramC()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorC getMentor()
  {
    return mentor;
  }

  public StudentC getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorC aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorC existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorC currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramC existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentC aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentC existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentC currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramC existingProgram = aNewStudent.getProgram();

    if (!equals(existingProgram))
    {
      aNewStudent.setProgram(this);
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