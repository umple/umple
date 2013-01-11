/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.associations;

// line 80 "../../../src/LocalHarness.ump"
public class StudentAP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAP Attributes
  private int number;

  //StudentAP Associations
  private MentorAP mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAP(int aNumber, MentorAP aMentor)
  {
    number = aNumber;
    if (aMentor == null || aMentor.getStudent() != null)
    {
      throw new RuntimeException("Unable to create StudentAP due to aMentor");
    }
    mentor = aMentor;
  }

  public StudentAP(int aNumber, String aNameForMentor, GradStudentAP aGradStudentForMentor)
  {
    number = aNumber;
    mentor = new MentorAP(aNameForMentor, aGradStudentForMentor, this);
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

  public MentorAP getMentor()
  {
    return mentor;
  }

  public void delete()
  {
    MentorAP existingMentor = mentor;
    mentor = null;
    if (existingMentor != null)
    {
      existingMentor.delete();
    }
  }

}