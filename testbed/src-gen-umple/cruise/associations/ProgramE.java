/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 77 "../../../src/TestHarnessAssociations.ump"
public class ProgramE
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramE Associations
  private MentorE mentor;
  private StudentE student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramE()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorE getMentor()
  {
    return mentor;
  }

  public StudentE getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorE aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorE existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorE currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramE existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentE aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentE existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentE currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramE existingProgram = aNewStudent.getProgram();

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