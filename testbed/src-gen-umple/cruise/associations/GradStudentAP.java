/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.associations;

public class GradStudentAP
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GradStudentAP Associations
  private MentorAP mentorAP;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GradStudentAP(MentorAP aMentorAP)
  {
    if (aMentorAP == null || aMentorAP.getGradStudent() != null)
    {
      throw new RuntimeException("Unable to create GradStudentAP due to aMentorAP");
    }
    mentorAP = aMentorAP;
  }

  public GradStudentAP(String aNameForMentorAP, StudentAP aStudentForMentorAP)
  {
    mentorAP = new MentorAP(aNameForMentorAP, this, aStudentForMentorAP);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAP getMentorAP()
  {
    return mentorAP;
  }

  public void delete()
  {
    MentorAP existingMentorAP = mentorAP;
    mentorAP = null;
    if (existingMentorAP != null)
    {
      existingMentorAP.delete();
    }
  }

}