/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.associations;

// line 5 "../../../src/TestHarnessAssociations.ump"
public class MentorA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorA Associations
  private StudentA student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorA()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public StudentA getStudent()
  {
    return student;
  }

  public boolean setStudent(StudentA aNewStudent)
  {
    boolean wasSet = false;
    if (aNewStudent == null)
    {
      StudentA existingStudent = student;
      student = null;
      
      if (existingStudent != null && existingStudent.getMentor() != null)
      {
        existingStudent.setMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    StudentA currentStudent = getStudent();
    if (currentStudent != null && !currentStudent.equals(aNewStudent))
    {
      currentStudent.setMentor(null);
    }

    student = aNewStudent;
    MentorA existingMentor = aNewStudent.getMentor();

    if (!equals(existingMentor))
    {
      aNewStudent.setMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (student != null)
    {
      student.setMentor(null);
    }
  }

}