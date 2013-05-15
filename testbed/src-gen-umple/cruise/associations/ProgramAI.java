/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 530 "../../../src/TestHarnessAssociations.ump"
public class ProgramAI
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramAI Associations
  private MentorAI mentor;
  private StudentAI student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgramAI()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAI getMentor()
  {
    return mentor;
  }

  public StudentAI getStudent()
  {
    return student;
  }

  public boolean setMentor(MentorAI aNewMentor)
  {
    boolean wasSet = false;
    if (aNewMentor == null)
    {
      MentorAI existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getProgram() != null)
      {
        existingMentor.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorAI currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(aNewMentor))
    {
      currentMentor.setProgram(null);
    }

    mentor = aNewMentor;
    ProgramAI existingProgram = aNewMentor.getProgram();

    if (!equals(existingProgram))
    {
      aNewMentor.setProgram(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStudent(StudentAI aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentAI existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getProgram() != null)
      {
        existingStudent.setProgram(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentAI currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setProgram(null);
    }

    student = aNewStudent;
    ProgramAI existingProgram = aNewStudent.getProgram();

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