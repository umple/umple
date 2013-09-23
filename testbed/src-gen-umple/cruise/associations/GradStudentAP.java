/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.associations;

// line 70 "../../../src/LocalHarness.ump"
public class GradStudentAP
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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