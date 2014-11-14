/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * User: a person with known identity and authorization "correct access right" to enter specific access zone
 * User Name: a user name
 */
// line 13 "AccessControl2.ump"
// line 188 "AccessControl2.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String name;

  //User Associations
  private List<AccessPoint> accessPoints;
  private List<AccessZone> mayAccept;
  private Card card;
  private ACSystem mayAcceptAndValidate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aName)
  {
    name = aName;
    accessPoints = new ArrayList<AccessPoint>();
    mayAccept = new ArrayList<AccessZone>();
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

  public AccessPoint getAccessPoint(int index)
  {
    AccessPoint aAccessPoint = accessPoints.get(index);
    return aAccessPoint;
  }

  public List<AccessPoint> getAccessPoints()
  {
    List<AccessPoint> newAccessPoints = Collections.unmodifiableList(accessPoints);
    return newAccessPoints;
  }

  public int numberOfAccessPoints()
  {
    int number = accessPoints.size();
    return number;
  }

  public boolean hasAccessPoints()
  {
    boolean has = accessPoints.size() > 0;
    return has;
  }

  public int indexOfAccessPoint(AccessPoint aAccessPoint)
  {
    int index = accessPoints.indexOf(aAccessPoint);
    return index;
  }

  public AccessZone getMayAccept(int index)
  {
    AccessZone aMayAccept = mayAccept.get(index);
    return aMayAccept;
  }

  public List<AccessZone> getMayAccept()
  {
    List<AccessZone> newMayAccept = Collections.unmodifiableList(mayAccept);
    return newMayAccept;
  }

  public int numberOfMayAccept()
  {
    int number = mayAccept.size();
    return number;
  }

  public boolean hasMayAccept()
  {
    boolean has = mayAccept.size() > 0;
    return has;
  }

  public int indexOfMayAccept(AccessZone aMayAccept)
  {
    int index = mayAccept.indexOf(aMayAccept);
    return index;
  }

  public Card getCard()
  {
    return card;
  }

  public boolean hasCard()
  {
    boolean has = card != null;
    return has;
  }

  public ACSystem getMayAcceptAndValidate()
  {
    return mayAcceptAndValidate;
  }

  public boolean hasMayAcceptAndValidate()
  {
    boolean has = mayAcceptAndValidate != null;
    return has;
  }

  public static int minimumNumberOfAccessPoints()
  {
    return 0;
  }

  public boolean addAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasAdded = false;
    if (accessPoints.contains(aAccessPoint)) { return false; }
    accessPoints.add(aAccessPoint);
    if (aAccessPoint.indexOfMayEnterThrough(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAccessPoint.addMayEnterThrough(this);
      if (!wasAdded)
      {
        accessPoints.remove(aAccessPoint);
      }
    }
    return wasAdded;
  }

  public boolean removeAccessPoint(AccessPoint aAccessPoint)
  {
    boolean wasRemoved = false;
    if (!accessPoints.contains(aAccessPoint))
    {
      return wasRemoved;
    }

    int oldIndex = accessPoints.indexOf(aAccessPoint);
    accessPoints.remove(oldIndex);
    if (aAccessPoint.indexOfMayEnterThrough(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAccessPoint.removeMayEnterThrough(this);
      if (!wasRemoved)
      {
        accessPoints.add(oldIndex,aAccessPoint);
      }
    }
    return wasRemoved;
  }

  public boolean addAccessPointAt(AccessPoint aAccessPoint, int index)
  {  
    boolean wasAdded = false;
    if(addAccessPoint(aAccessPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessPoints()) { index = numberOfAccessPoints() - 1; }
      accessPoints.remove(aAccessPoint);
      accessPoints.add(index, aAccessPoint);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccessPointAt(AccessPoint aAccessPoint, int index)
  {
    boolean wasAdded = false;
    if(accessPoints.contains(aAccessPoint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccessPoints()) { index = numberOfAccessPoints() - 1; }
      accessPoints.remove(aAccessPoint);
      accessPoints.add(index, aAccessPoint);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccessPointAt(aAccessPoint, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMayAccept()
  {
    return 0;
  }

  public boolean addMayAccept(AccessZone aMayAccept)
  {
    boolean wasAdded = false;
    if (mayAccept.contains(aMayAccept)) { return false; }
    mayAccept.add(aMayAccept);
    if (aMayAccept.indexOfMayEnter(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMayAccept.addMayEnter(this);
      if (!wasAdded)
      {
        mayAccept.remove(aMayAccept);
      }
    }
    return wasAdded;
  }

  public boolean removeMayAccept(AccessZone aMayAccept)
  {
    boolean wasRemoved = false;
    if (!mayAccept.contains(aMayAccept))
    {
      return wasRemoved;
    }

    int oldIndex = mayAccept.indexOf(aMayAccept);
    mayAccept.remove(oldIndex);
    if (aMayAccept.indexOfMayEnter(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMayAccept.removeMayEnter(this);
      if (!wasRemoved)
      {
        mayAccept.add(oldIndex,aMayAccept);
      }
    }
    return wasRemoved;
  }

  public boolean addMayAcceptAt(AccessZone aMayAccept, int index)
  {  
    boolean wasAdded = false;
    if(addMayAccept(aMayAccept))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayAccept()) { index = numberOfMayAccept() - 1; }
      mayAccept.remove(aMayAccept);
      mayAccept.add(index, aMayAccept);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMayAcceptAt(AccessZone aMayAccept, int index)
  {
    boolean wasAdded = false;
    if(mayAccept.contains(aMayAccept))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMayAccept()) { index = numberOfMayAccept() - 1; }
      mayAccept.remove(aMayAccept);
      mayAccept.add(index, aMayAccept);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMayAcceptAt(aMayAccept, index);
    }
    return wasAdded;
  }

  public boolean setCard(Card aNewCard)
  {
    boolean wasSet = false;
    if (card != null && !card.equals(aNewCard) && equals(card.getOwns()))
    {
      //Unable to setCard, as existing card would become an orphan
      return wasSet;
    }

    card = aNewCard;
    User anOldOwns = aNewCard != null ? aNewCard.getOwns() : null;

    if (!this.equals(anOldOwns))
    {
      if (anOldOwns != null)
      {
        anOldOwns.card = null;
      }
      if (card != null)
      {
        card.setOwns(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMayAcceptAndValidate(ACSystem aMayAcceptAndValidate)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    ACSystem existingMayAcceptAndValidate = mayAcceptAndValidate;

    if (existingMayAcceptAndValidate == null)
    {
      if (aMayAcceptAndValidate != null)
      {
        if (aMayAcceptAndValidate.addMayUse(this))
        {
          existingMayAcceptAndValidate = aMayAcceptAndValidate;
          wasSet = true;
        }
      }
    } 
    else if (existingMayAcceptAndValidate != null)
    {
      if (aMayAcceptAndValidate == null)
      {
        if (existingMayAcceptAndValidate.minimumNumberOfMayUse() < existingMayAcceptAndValidate.numberOfMayUse())
        {
          existingMayAcceptAndValidate.removeMayUse(this);
          existingMayAcceptAndValidate = aMayAcceptAndValidate;  // aMayAcceptAndValidate == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingMayAcceptAndValidate.minimumNumberOfMayUse() < existingMayAcceptAndValidate.numberOfMayUse())
        {
          existingMayAcceptAndValidate.removeMayUse(this);
          aMayAcceptAndValidate.addMayUse(this);
          existingMayAcceptAndValidate = aMayAcceptAndValidate;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      mayAcceptAndValidate = existingMayAcceptAndValidate;
    }
    return wasSet;
  }
  
  public void delete()
  {
    ArrayList<AccessPoint> copyOfAccessPoints = new ArrayList<AccessPoint>(accessPoints);
    accessPoints.clear();
    for(AccessPoint aAccessPoint : copyOfAccessPoints)
    {
      aAccessPoint.removeMayEnterThrough(this);
    }
    ArrayList<AccessZone> copyOfMayAccept = new ArrayList<AccessZone>(mayAccept);
    mayAccept.clear();
    for(AccessZone aMayAccept : copyOfMayAccept)
    {
      aMayAccept.removeMayEnter(this);
    }
    Card existingCard = card;
    card = null;
    if (existingCard != null)
    {
      existingCard.delete();
    }
    if (mayAcceptAndValidate != null)
    {
      if (mayAcceptAndValidate.numberOfMayUse() <= 1)
      {
        mayAcceptAndValidate.delete();
      }
      else
      {
        ACSystem placeholderMayAcceptAndValidate = mayAcceptAndValidate;
        this.mayAcceptAndValidate = null;
        placeholderMayAcceptAndValidate.removeMayUse(this);
      }
    }
  }

  // line 21 "AccessControl2.ump"
   public void insertCard(String cardId){
    System.out.println("User [" + getName() + "] is inserting his/her card" +getCard().getCardId());
  }

  // line 25 "AccessControl2.ump"
   public List enterPIN(int no1, int no2, int no3, int no4){
    getCard().addPin(no1);
    getCard().addPin(no2);
    getCard().addPin(no3);
    getCard().addPin(no4);
    
    return Arrays.asList(getCard().getPin());
  }

  // line 34 "AccessControl2.ump"
   public void cardOut(){
    System.out.println("User ["+getName()+"] is taking his/her card out" + getCard());
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "card = "+(getCard()!=null?Integer.toHexString(System.identityHashCode(getCard())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "mayAcceptAndValidate = "+(getMayAcceptAndValidate()!=null?Integer.toHexString(System.identityHashCode(getMayAcceptAndValidate())):"null")
     + outputString;
  }
}