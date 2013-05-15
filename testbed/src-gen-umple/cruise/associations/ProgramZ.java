/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 406 "../../../src/TestHarnessAssociations.ump"
public class ProgramZ
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramZ Associations
  private MentorZ mentor;
  private StudentZ student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramZ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorZ getMentor()
  {
    return mentor;
  }

  public StudentZ getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorZ aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorZ existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorZ currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramZ existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentZ aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentZ existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentZ currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramZ existingProgram = aNewStudent.getProgram();

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