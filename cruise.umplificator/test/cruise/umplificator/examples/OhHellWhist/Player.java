/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 29 "OhHellWhist.ump"
// line 108 "OhHellWhist.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private String name;
  private int currentTricksBid;

  //Player Associations
  private List<Card> hand;
  private List<Trick> tricks;
  private ScoringTeam scoringTeam;
  private List<Game> games;
  private List<Game> gameLed;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aName, int aCurrentTricksBid, ScoringTeam aScoringTeam)
  {
    name = aName;
    currentTricksBid = aCurrentTricksBid;
    hand = new ArrayList<Card>();
    tricks = new ArrayList<Trick>();
    boolean didAddScoringTeam = setScoringTeam(aScoringTeam);
    if (!didAddScoringTeam)
    {
      throw new RuntimeException("Unable to create player due to scoringTeam");
    }
    games = new ArrayList<Game>();
    gameLed = new ArrayList<Game>();
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

  public boolean setCurrentTricksBid(int aCurrentTricksBid)
  {
    boolean wasSet = false;
    currentTricksBid = aCurrentTricksBid;
    wasSet = true;
    return wasSet;
  }

  /**
   * These are the people playing.
   */
  public String getName()
  {
    return name;
  }

  /**
   * All hands and tricks are cleared at the end of each game
   * ready for dealing again
   * The following is used only in Oh Hell
   */
  public int getCurrentTricksBid()
  {
    return currentTricksBid;
  }

  public Card getHand(int index)
  {
    Card aHand = hand.get(index);
    return aHand;
  }

  /**
   * A hand is dealt at the start of a game
   * The cards a player has in his or her hand
   */
  public List<Card> getHand()
  {
    List<Card> newHand = Collections.unmodifiableList(hand);
    return newHand;
  }

  public int numberOfHand()
  {
    int number = hand.size();
    return number;
  }

  public boolean hasHand()
  {
    boolean has = hand.size() > 0;
    return has;
  }

  public int indexOfHand(Card aHand)
  {
    int index = hand.indexOf(aHand);
    return index;
  }

  public Trick getTrick(int index)
  {
    Trick aTrick = tricks.get(index);
    return aTrick;
  }

  /**
   * The tricks won by a player this game
   */
  public List<Trick> getTricks()
  {
    List<Trick> newTricks = Collections.unmodifiableList(tricks);
    return newTricks;
  }

  public int numberOfTricks()
  {
    int number = tricks.size();
    return number;
  }

  public boolean hasTricks()
  {
    boolean has = tricks.size() > 0;
    return has;
  }

  public int indexOfTrick(Trick aTrick)
  {
    int index = tricks.indexOf(aTrick);
    return index;
  }

  public ScoringTeam getScoringTeam()
  {
    return scoringTeam;
  }

  public Game getGame(int index)
  {
    Game aGame = games.get(index);
    return aGame;
  }

  public List<Game> getGames()
  {
    List<Game> newGames = Collections.unmodifiableList(games);
    return newGames;
  }

  public int numberOfGames()
  {
    int number = games.size();
    return number;
  }

  public boolean hasGames()
  {
    boolean has = games.size() > 0;
    return has;
  }

  public int indexOfGame(Game aGame)
  {
    int index = games.indexOf(aGame);
    return index;
  }

  public Game getGameLed(int index)
  {
    Game aGameLed = gameLed.get(index);
    return aGameLed;
  }

  public List<Game> getGameLed()
  {
    List<Game> newGameLed = Collections.unmodifiableList(gameLed);
    return newGameLed;
  }

  public int numberOfGameLed()
  {
    int number = gameLed.size();
    return number;
  }

  public boolean hasGameLed()
  {
    boolean has = gameLed.size() > 0;
    return has;
  }

  public int indexOfGameLed(Game aGameLed)
  {
    int index = gameLed.indexOf(aGameLed);
    return index;
  }

  public static int minimumNumberOfHand()
  {
    return 0;
  }

  public boolean addHand(Card aHand)
  {
    boolean wasAdded = false;
    if (hand.contains(aHand)) { return false; }
    Player existingPlayer = aHand.getPlayer();
    if (existingPlayer == null)
    {
      aHand.setPlayer(this);
    }
    else if (!this.equals(existingPlayer))
    {
      existingPlayer.removeHand(aHand);
      addHand(aHand);
    }
    else
    {
      hand.add(aHand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHand(Card aHand)
  {
    boolean wasRemoved = false;
    if (hand.contains(aHand))
    {
      hand.remove(aHand);
      aHand.setPlayer(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addHandAt(Card aHand, int index)
  {  
    boolean wasAdded = false;
    if(addHand(aHand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHand()) { index = numberOfHand() - 1; }
      hand.remove(aHand);
      hand.add(index, aHand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHandAt(Card aHand, int index)
  {
    boolean wasAdded = false;
    if(hand.contains(aHand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHand()) { index = numberOfHand() - 1; }
      hand.remove(aHand);
      hand.add(index, aHand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHandAt(aHand, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTricks()
  {
    return 0;
  }

  public Trick addTrick()
  {
    return new Trick(this);
  }

  public boolean addTrick(Trick aTrick)
  {
    boolean wasAdded = false;
    if (tricks.contains(aTrick)) { return false; }
    Player existingPlayer = aTrick.getPlayer();
    boolean isNewPlayer = existingPlayer != null && !this.equals(existingPlayer);
    if (isNewPlayer)
    {
      aTrick.setPlayer(this);
    }
    else
    {
      tricks.add(aTrick);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTrick(Trick aTrick)
  {
    boolean wasRemoved = false;
    //Unable to remove aTrick, as it must always have a player
    if (!this.equals(aTrick.getPlayer()))
    {
      tricks.remove(aTrick);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTrickAt(Trick aTrick, int index)
  {  
    boolean wasAdded = false;
    if(addTrick(aTrick))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTricks()) { index = numberOfTricks() - 1; }
      tricks.remove(aTrick);
      tricks.add(index, aTrick);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTrickAt(Trick aTrick, int index)
  {
    boolean wasAdded = false;
    if(tricks.contains(aTrick))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTricks()) { index = numberOfTricks() - 1; }
      tricks.remove(aTrick);
      tricks.add(index, aTrick);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTrickAt(aTrick, index);
    }
    return wasAdded;
  }

  public boolean setScoringTeam(ScoringTeam aScoringTeam)
  {
    boolean wasSet = false;
    //Must provide scoringTeam to player
    if (aScoringTeam == null)
    {
      return wasSet;
    }

    //scoringTeam already at maximum (2)
    if (aScoringTeam.numberOfPlayers() >= ScoringTeam.maximumNumberOfPlayers())
    {
      return wasSet;
    }
    
    ScoringTeam existingScoringTeam = scoringTeam;
    scoringTeam = aScoringTeam;
    if (existingScoringTeam != null && !existingScoringTeam.equals(aScoringTeam))
    {
      boolean didRemove = existingScoringTeam.removePlayer(this);
      if (!didRemove)
      {
        scoringTeam = existingScoringTeam;
        return wasSet;
      }
    }
    scoringTeam.addPlayer(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfGames()
  {
    return 0;
  }

  public Game addGame(String aTrumps, Match aMatch)
  {
    return new Game(aTrumps, this, aMatch);
  }

  public boolean addGame(Game aGame)
  {
    boolean wasAdded = false;
    if (games.contains(aGame)) { return false; }
    Player existingDealer = aGame.getDealer();
    boolean isNewDealer = existingDealer != null && !this.equals(existingDealer);
    if (isNewDealer)
    {
      aGame.setDealer(this);
    }
    else
    {
      games.add(aGame);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGame(Game aGame)
  {
    boolean wasRemoved = false;
    //Unable to remove aGame, as it must always have a dealer
    if (!this.equals(aGame.getDealer()))
    {
      games.remove(aGame);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addGameAt(Game aGame, int index)
  {  
    boolean wasAdded = false;
    if(addGame(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGames()) { index = numberOfGames() - 1; }
      games.remove(aGame);
      games.add(index, aGame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameAt(Game aGame, int index)
  {
    boolean wasAdded = false;
    if(games.contains(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGames()) { index = numberOfGames() - 1; }
      games.remove(aGame);
      games.add(index, aGame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameAt(aGame, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfGameLed()
  {
    return 0;
  }

  public boolean addGameLed(Game aGameLed)
  {
    boolean wasAdded = false;
    if (gameLed.contains(aGameLed)) { return false; }
    Player existingCurrentLead = aGameLed.getCurrentLead();
    if (existingCurrentLead == null)
    {
      aGameLed.setCurrentLead(this);
    }
    else if (!this.equals(existingCurrentLead))
    {
      existingCurrentLead.removeGameLed(aGameLed);
      addGameLed(aGameLed);
    }
    else
    {
      gameLed.add(aGameLed);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGameLed(Game aGameLed)
  {
    boolean wasRemoved = false;
    if (gameLed.contains(aGameLed))
    {
      gameLed.remove(aGameLed);
      aGameLed.setCurrentLead(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addGameLedAt(Game aGameLed, int index)
  {  
    boolean wasAdded = false;
    if(addGameLed(aGameLed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGameLed()) { index = numberOfGameLed() - 1; }
      gameLed.remove(aGameLed);
      gameLed.add(index, aGameLed);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameLedAt(Game aGameLed, int index)
  {
    boolean wasAdded = false;
    if(gameLed.contains(aGameLed))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGameLed()) { index = numberOfGameLed() - 1; }
      gameLed.remove(aGameLed);
      gameLed.add(index, aGameLed);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameLedAt(aGameLed, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !hand.isEmpty() )
    {
      hand.get(0).setPlayer(null);
    }
    for(int i=tricks.size(); i > 0; i--)
    {
      Trick aTrick = tricks.get(i - 1);
      aTrick.delete();
    }
    ScoringTeam placeholderScoringTeam = scoringTeam;
    this.scoringTeam = null;
    placeholderScoringTeam.removePlayer(this);
    for(int i=games.size(); i > 0; i--)
    {
      Game aGame = games.get(i - 1);
      aGame.delete();
    }
    while( !gameLed.isEmpty() )
    {
      gameLed.get(0).setCurrentLead(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "currentTricksBid" + ":" + getCurrentTricksBid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "scoringTeam = "+(getScoringTeam()!=null?Integer.toHexString(System.identityHashCode(getScoringTeam())):"null")
     + outputString;
  }
}