/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;

// line 489 "../../../src/TestHarnessAssociations.ump"
public class MentorAF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAF Attributes
  private String name;

  //MentorAF Associations
  private MentorAF friend;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAF(String aName, MentorAF aFriend)
  {
    name = aName;
    if (aFriend == null || aFriend.getFriend() != null)
    {
      throw new RuntimeException("Unable to create MentorAF due to aFriend");
    }
    friend = aFriend;
  }

  public MentorAF(String aName, String aNameForFriend)
  {
    name = aName;
    friend = new MentorAF(aNameForFriend, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public MentorAF getFriend()
  {
    return friend;
  }

  public void delete()
  {
    MentorAF existingFriend = friend;
    friend = null;
    if (existingFriend != null)
    {
      existingFriend.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "friend" + "=" + getFriend() != null ? !getFriend() .equals(this)  ? getFriend().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}