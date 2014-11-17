/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 49 "CommunityAssociation.ump"
// line 101 "CommunityAssociation.ump"
public class Under18Event extends Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Under18Event(Date aDate, Time aTime, float aFee, String aName, CommunityAssociation aCommunityAssociation)
  {
    super(aDate, aTime, aFee, aName, aCommunityAssociation);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}