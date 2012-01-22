/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class StudentA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentA Associations
  private MentorA mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentA()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorA getMentor()
  {
    return mentor;
  }

  public boolean setMentor(MentorA newMentor)
  {
    boolean wasSet = false;
    if (newMentor == null)
    {
      MentorA existingMentor = mentor;
      mentor = null;
      
      if (existingMentor != null && existingMentor.getStudent() != null)
      {
        existingMentor.setStudent(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorA currentMentor = getMentor();
    if (currentMentor != null && !currentMentor.equals(newMentor))
    {
      currentMentor.setStudent(null);
    }

    mentor = newMentor;
    StudentA existingStudent = newMentor.getStudent();

    if (!equals(existingStudent))
    {
      newMentor.setStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentor != null)
    {
      mentor.setStudent(null);
    }
  }

}