/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Card code: a unique identification of a card stored in a machine-readable form on the card
 */
// line 168 "AccessControl2.ump"
// line 177 "AccessControl2.ump"
public class Code
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Code Attributes
  private String userID;

  //Code Associations
  private Card card;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Code(String aUserID, Card aCard)
  {
    userID = aUserID;
    if (aCard == null || aCard.getCardId() != null)
    {
      throw new RuntimeException("Unable to create Code due to aCard");
    }
    card = aCard;
  }

  public Code(String aUserID, User aOwnsForCard)
  {
    userID = aUserID;
    card = new Card(this, aOwnsForCard);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserID(String aUserID)
  {
    boolean wasSet = false;
    userID = aUserID;
    wasSet = true;
    return wasSet;
  }

  public String getUserID()
  {
    return userID;
  }

  public Card getCard()
  {
    return card;
  }

  public void delete()
  {
    Card existingCard = card;
    card = null;
    if (existingCard != null)
    {
      existingCard.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "userID" + ":" + getUserID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "card = "+(getCard()!=null?Integer.toHexString(System.identityHashCode(getCard())):"null")
     + outputString;
  }
}