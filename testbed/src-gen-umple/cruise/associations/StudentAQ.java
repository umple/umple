/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

public class StudentAQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentAQ Associations
  private MentorAQ mentorAQ;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StudentAQ()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public MentorAQ getMentorAQ()
  {
    return mentorAQ;
  }

  public void delete()
  {
    if (mentorAQ != null)
    {
      mentorAQ.delete();
    }
  }

}