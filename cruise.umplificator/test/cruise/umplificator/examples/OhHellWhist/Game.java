/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 71 "OhHellWhist.ump"
// line 127 "OhHellWhist.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private String trumps;

  //Game Associations
  private Player dealer;
  private List<Card> currentTrickBeingBuilt;
  private Player currentLead;
  private Match match;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(String aTrumps, Player aDealer, Match aMatch)
  {
    trumps = aTrumps;
    boolean didAddDealer = setDealer(aDealer);
    if (!didAddDealer)
    {
      throw new RuntimeException("Unable to create game due to dealer");
    }
    currentTrickBeingBuilt = new ArrayList<Card>();
    boolean didAddMatch = setMatch(aMatch);
    if (!didAddMatch)
    {
      throw new RuntimeException("Unable to create game due to match");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTrumps(String aTrumps)
  {
    boolean wasSet = false;
    trumps = aTrumps;
    wasSet = true;
    return wasSet;
  }

  /**
   * a suit (if any) that is the trumps for this game
   */
  public String getTrumps()
  {
    return trumps;
  }

  public Player getDealer()
  {
    return dealer;
  }

  public Card getCurrentTrickBeingBuilt(int index)
  {
    Card aCurrentTrickBeingBuilt = currentTrickBeingBuilt.get(index);
    return aCurrentTrickBeingBuilt;
  }

  /**
   * As the cards are laid down the following set is created.
   * After all players have contributed a new trick is created from the
   * following and awarded to a player
   */
  public List<Card> getCurrentTrickBeingBuilt()
  {
    List<Card> newCurrentTrickBeingBuilt = Collections.unmodifiableList(currentTrickBeingBuilt);
    return newCurrentTrickBeingBuilt;
  }

  public int numberOfCurrentTrickBeingBuilt()
  {
    int number = currentTrickBeingBuilt.size();
    return number;
  }

  public boolean hasCurrentTrickBeingBuilt()
  {
    boolean has = currentTrickBeingBuilt.size() > 0;
    return has;
  }

  public int indexOfCurrentTrickBeingBuilt(Card aCurrentTrickBeingBuilt)
  {
    int index = currentTrickBeingBuilt.indexOf(aCurrentTrickBeingBuilt);
    return index;
  }

  public Player getCurrentLead()
  {
    return currentLead;
  }

  public boolean hasCurrentLead()
  {
    boolean has = currentLead != null;
    return has;
  }

  public Match getMatch()
  {
    return match;
  }

  public boolean setDealer(Player aDealer)
  {
    boolean wasSet = false;
    if (aDealer == null)
    {
      return wasSet;
    }

    Player existingDealer = dealer;
    dealer = aDealer;
    if (existingDealer != null && !existingDealer.equals(aDealer))
    {
      existingDealer.removeGame(this);
    }
    dealer.addGame(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfCurrentTrickBeingBuilt()
  {
    return 0;
  }

  public boolean addCurrentTrickBeingBuilt(Card aCurrentTrickBeingBuilt)
  {
    boolean wasAdded = false;
    if (currentTrickBeingBuilt.contains(aCurrentTrickBeingBuilt)) { return false; }
    Game existingGame = aCurrentTrickBeingBuilt.getGame();
    if (existingGame == null)
    {
      aCurrentTrickBeingBuilt.setGame(this);
    }
    else if (!this.equals(existingGame))
    {
      existingGame.removeCurrentTrickBeingBuilt(aCurrentTrickBeingBuilt);
      addCurrentTrickBeingBuilt(aCurrentTrickBeingBuilt);
    }
    else
    {
      currentTrickBeingBuilt.add(aCurrentTrickBeingBuilt);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCurrentTrickBeingBuilt(Card aCurrentTrickBeingBuilt)
  {
    boolean wasRemoved = false;
    if (currentTrickBeingBuilt.contains(aCurrentTrickBeingBuilt))
    {
      currentTrickBeingBuilt.remove(aCurrentTrickBeingBuilt);
      aCurrentTrickBeingBuilt.setGame(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCurrentTrickBeingBuiltAt(Card aCurrentTrickBeingBuilt, int index)
  {  
    boolean wasAdded = false;
    if(addCurrentTrickBeingBuilt(aCurrentTrickBeingBuilt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentTrickBeingBuilt()) { index = numberOfCurrentTrickBeingBuilt() - 1; }
      currentTrickBeingBuilt.remove(aCurrentTrickBeingBuilt);
      currentTrickBeingBuilt.add(index, aCurrentTrickBeingBuilt);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCurrentTrickBeingBuiltAt(Card aCurrentTrickBeingBuilt, int index)
  {
    boolean wasAdded = false;
    if(currentTrickBeingBuilt.contains(aCurrentTrickBeingBuilt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentTrickBeingBuilt()) { index = numberOfCurrentTrickBeingBuilt() - 1; }
      currentTrickBeingBuilt.remove(aCurrentTrickBeingBuilt);
      currentTrickBeingBuilt.add(index, aCurrentTrickBeingBuilt);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCurrentTrickBeingBuiltAt(aCurrentTrickBeingBuilt, index);
    }
    return wasAdded;
  }

  public boolean setCurrentLead(Player aCurrentLead)
  {
    boolean wasSet = false;
    Player existingCurrentLead = currentLead;
    currentLead = aCurrentLead;
    if (existingCurrentLead != null && !existingCurrentLead.equals(aCurrentLead))
    {
      existingCurrentLead.removeGameLed(this);
    }
    if (aCurrentLead != null)
    {
      aCurrentLead.addGameLed(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setMatch(Match aMatch)
  {
    boolean wasSet = false;
    if (aMatch == null)
    {
      return wasSet;
    }

    Match existingMatch = match;
    match = aMatch;
    if (existingMatch != null && !existingMatch.equals(aMatch))
    {
      existingMatch.removeGame(this);
    }
    match.addGame(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Player placeholderDealer = dealer;
    this.dealer = null;
    placeholderDealer.removeGame(this);
    while( !currentTrickBeingBuilt.isEmpty() )
    {
      currentTrickBeingBuilt.get(0).setGame(null);
    }
    if (currentLead != null)
    {
      Player placeholderCurrentLead = currentLead;
      this.currentLead = null;
      placeholderCurrentLead.removeGameLed(this);
    }
    Match placeholderMatch = match;
    this.match = null;
    placeholderMatch.removeGame(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "trumps" + ":" + getTrumps()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dealer = "+(getDealer()!=null?Integer.toHexString(System.identityHashCode(getDealer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentLead = "+(getCurrentLead()!=null?Integer.toHexString(System.identityHashCode(getCurrentLead())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "match = "+(getMatch()!=null?Integer.toHexString(System.identityHashCode(getMatch())):"null")
     + outputString;
  }
}