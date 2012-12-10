/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 54 "../../../src/LocalHarness.ump"
public class GradStudentAO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GradStudentAO Associations
  private MentorAO mentorAO;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GradStudentAO(MentorAO aMentorAO)
  {
    if (aMentorAO == null || aMentorAO.getGradStudent() != null)
    {
      throw new RuntimeException("Unable to create GradStudentAO due to aMentorAO");
    }
    mentorAO = aMentorAO;
  }

  public GradStudentAO(String aNameForMentorAO)
  {
    mentorAO = new MentorAO(aNameForMentorAO, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAO getMentorAO()
  {
    return mentorAO;
  }

  public void delete()
  {
    MentorAO existingMentorAO = mentorAO;
    mentorAO = null;
    if (existingMentorAO != null)
    {
      existingMentorAO.delete();
    }
  }

}