/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;

// line 344 "../../../src/TestHarnessAssociations.ump"
public class ProgramV
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramV Associations
  private MentorV mentor;
  private StudentV student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramV()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorV getMentor()
  {
    return mentor;
  }

  public StudentV getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorV aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorV existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorV currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramV existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentV aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentV existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentV currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramV existingProgram = aNewStudent.getProgram();

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