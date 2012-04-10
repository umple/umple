/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class StudentAO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAO Attributes
  private int number;

  //StudentAO Associations
  private MentorAO mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAO(int aNumber, MentorAO aMentor)
  {
    number = aNumber;
    boolean didAddMentor = setMentor(aMentor);
    if (!didAddMentor)
    {
      throw new RuntimeException("Unable to create student due to mentor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(int aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public int getNumber()
  {
    return number;
  }

  public MentorAO getMentor()
  {
    return mentor;
  }

  public boolean setMentor(MentorAO aMentor)
  {
    boolean wasSet = false;
    //Must provide mentor to student
    if (aMentor == null)
    {
      return wasSet;
    }

    //mentor already at maximum (2)
    if (aMentor.numberOfStudents() >= MentorAO.maximumNumberOfStudents())
    {
      return wasSet;
    }
    
    MentorAO existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      boolean didRemove = existingMentor.removeStudent(this);
      if (!didRemove)
      {
        mentor = existingMentor;
        return wasSet;
      }
    }
    mentor.addStudent(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    MentorAO placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }

}