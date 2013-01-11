/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 48 "../../../src/LocalHarness.ump"
public class StudentAN
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAN Attributes
  private int number;

  //StudentAN Associations
  private MentorAN mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAN(int aNumber, MentorAN aMentor)
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

  public MentorAN getMentor()
  {
    return mentor;
  }

  public boolean setMentor(MentorAN aMentor)
  {
    boolean wasSet = false;
    if (aMentor == null)
    {
      return wasSet;
    }

    MentorAN existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
    }
    mentor.addStudent(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    MentorAN placeholderMentor = mentor;
    this.mentor = null;
    placeholderMentor.removeStudent(this);
  }

}