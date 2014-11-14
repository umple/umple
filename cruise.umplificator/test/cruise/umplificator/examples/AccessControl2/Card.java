/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Magnetic stripe card holding a card code and a secrete personal identification number PIN entered by users
 */
// line 161 "AccessControl2.ump"
// line 182 "AccessControl2.ump"
public class Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Card Attributes
  private List<Integer> pin;

  //Card Associations
  private Code cardId;
  private User owns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Card(Code aCardId, User aOwns)
  {
    pin = new ArrayList<Integer>();
    if (aCardId == null || aCardId.getCard() != null)
    {
      throw new RuntimeException("Unable to create Card due to aCardId");
    }
    cardId = aCardId;
    boolean didAddOwns = setOwns(aOwns);
    if (!didAddOwns)
    {
      throw new RuntimeException("Unable to create card due to owns");
    }
  }

  public Card(String aUserIDForCardId, User aOwns)
  {
    pin = new ArrayList<Integer>();
    cardId = new Code(aUserIDForCardId, this);
    boolean didAddOwns = setOwns(aOwns);
    if (!didAddOwns)
    {
      throw new RuntimeException("Unable to create card due to owns");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addPin(Integer aPin)
  {
    boolean wasAdded = false;
    wasAdded = pin.add(aPin);
    return wasAdded;
  }

  public boolean removePin(Integer aPin)
  {
    boolean wasRemoved = false;
    wasRemoved = pin.remove(aPin);
    return wasRemoved;
  }

  public Integer getPin(int index)
  {
    Integer aPin = pin.get(index);
    return aPin;
  }

  public Integer[] getPin()
  {
    Integer[] newPin = pin.toArray(new Integer[pin.size()]);
    return newPin;
  }

  public int numberOfPin()
  {
    int number = pin.size();
    return number;
  }

  public boolean hasPin()
  {
    boolean has = pin.size() > 0;
    return has;
  }

  public int indexOfPin(Integer aPin)
  {
    int index = pin.indexOf(aPin);
    return index;
  }

  public Code getCardId()
  {
    return cardId;
  }

  public User getOwns()
  {
    return owns;
  }

  public boolean setOwns(User aNewOwns)
  {
    boolean wasSet = false;
    if (aNewOwns == null)
    {
      //Unable to setOwns to null, as card must always be associated to a owns
      return wasSet;
    }
    
    Card existingCard = aNewOwns.getCard();
    if (existingCard != null && !equals(existingCard))
    {
      //Unable to setOwns, the current owns already has a card, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    User anOldOwns = owns;
    owns = aNewOwns;
    owns.setCard(this);

    if (anOldOwns != null)
    {
      anOldOwns.setCard(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Code existingCardId = cardId;
    cardId = null;
    if (existingCardId != null)
    {
      existingCardId.delete();
    }
    User existingOwns = owns;
    owns = null;
    if (existingOwns != null)
    {
      existingOwns.setCard(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cardId = "+(getCardId()!=null?Integer.toHexString(System.identityHashCode(getCardId())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "owns = "+(getOwns()!=null?Integer.toHexString(System.identityHashCode(getOwns())):"null")
     + outputString;
  }
}