/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

package cruise.associations;

// line 53 "../../../src/LocalHarness.ump"
public class GradStudentAO
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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