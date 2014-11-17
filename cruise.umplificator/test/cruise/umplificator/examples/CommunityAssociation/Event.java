/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 31 "CommunityAssociation.ump"
// line 89 "CommunityAssociation.ump"
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private Date date;
  private Time time;
  private float fee;
  private String name;

  //Event Associations
  private CommunityAssociation communityAssociation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(Date aDate, Time aTime, float aFee, String aName, CommunityAssociation aCommunityAssociation)
  {
    date = aDate;
    time = aTime;
    fee = aFee;
    name = aName;
    boolean didAddCommunityAssociation = setCommunityAssociation(aCommunityAssociation);
    if (!didAddCommunityAssociation)
    {
      throw new RuntimeException("Unable to create event due to communityAssociation");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setFee(float aFee)
  {
    boolean wasSet = false;
    fee = aFee;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getTime()
  {
    return time;
  }

  public float getFee()
  {
    return fee;
  }

  public String getName()
  {
    return name;
  }

  public CommunityAssociation getCommunityAssociation()
  {
    return communityAssociation;
  }

  public boolean setCommunityAssociation(CommunityAssociation aCommunityAssociation)
  {
    boolean wasSet = false;
    if (aCommunityAssociation == null)
    {
      return wasSet;
    }

    CommunityAssociation existingCommunityAssociation = communityAssociation;
    communityAssociation = aCommunityAssociation;
    if (existingCommunityAssociation != null && !existingCommunityAssociation.equals(aCommunityAssociation))
    {
      existingCommunityAssociation.removeEvent(this);
    }
    communityAssociation.addEvent(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CommunityAssociation placeholderCommunityAssociation = communityAssociation;
    this.communityAssociation = null;
    placeholderCommunityAssociation.removeEvent(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "fee" + ":" + getFee()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "communityAssociation = "+(getCommunityAssociation()!=null?Integer.toHexString(System.identityHashCode(getCommunityAssociation())):"null")
     + outputString;
  }
}