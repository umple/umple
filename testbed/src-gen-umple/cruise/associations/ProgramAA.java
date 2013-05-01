/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.associations;

// line 422 "../../../src/TestHarnessAssociations.ump"
public class ProgramAA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAA Associations
  private MentorAA mentor;
  private StudentAA student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAA()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAA getMentor()
  {
    return mentor;
  }

  public StudentAA getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAA aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorAA existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAA currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramAA existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAA aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentAA existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAA currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramAA existingProgram = aNewStudent.getProgram();

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