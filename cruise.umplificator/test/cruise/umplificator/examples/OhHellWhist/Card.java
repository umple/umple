/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "OhHellWhist.ump"
// line 87 "OhHellWhist.ump"
public class Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Card Attributes
  private String suit;
  private String rank;
  private boolean isJoker;

  //Card Associations
  private CardSet cardSet;
  private Player player;
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Card(String aSuit, String aRank, boolean aIsJoker, CardSet aCardSet)
  {
    suit = aSuit;
    rank = aRank;
    isJoker = aIsJoker;
    boolean didAddCardSet = setCardSet(aCardSet);
    if (!didAddCardSet)
    {
      throw new RuntimeException("Unable to create card due to cardSet");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSuit(String aSuit)
  {
    boolean wasSet = false;
    suit = aSuit;
    wasSet = true;
    return wasSet;
  }

  public boolean setRank(String aRank)
  {
    boolean wasSet = false;
    rank = aRank;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsJoker(boolean aIsJoker)
  {
    boolean wasSet = false;
    isJoker = aIsJoker;
    wasSet = true;
    return wasSet;
  }

  /**
   * "hearts", "clubs", "diamonds", "spades"
   */
  public String getSuit()
  {
    return suit;
  }

  /**
   * A23456789JQK
   */
  public String getRank()
  {
    return rank;
  }

  /**
   * suit and rank are null for a Joker
   */
  public boolean getIsJoker()
  {
    return isJoker;
  }

  public boolean isIsJoker()
  {
    return isJoker;
  }

  public CardSet getCardSet()
  {
    return cardSet;
  }

  public Player getPlayer()
  {
    return player;
  }

  public boolean hasPlayer()
  {
    boolean has = player != null;
    return has;
  }

  public Game getGame()
  {
    return game;
  }

  public boolean hasGame()
  {
    boolean has = game != null;
    return has;
  }

  public boolean setCardSet(CardSet aCardSet)
  {
    boolean wasSet = false;
    if (aCardSet == null)
    {
      return wasSet;
    }

    CardSet existingCardSet = cardSet;
    cardSet = aCardSet;
    if (existingCardSet != null && !existingCardSet.equals(aCardSet))
    {
      existingCardSet.removeCard(this);
    }
    cardSet.addCard(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removeHand(this);
    }
    if (aPlayer != null)
    {
      aPlayer.addHand(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      existingGame.removeCurrentTrickBeingBuilt(this);
    }
    if (aGame != null)
    {
      aGame.addCurrentTrickBeingBuilt(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CardSet placeholderCardSet = cardSet;
    this.cardSet = null;
    placeholderCardSet.removeCard(this);
    if (player != null)
    {
      Player placeholderPlayer = player;
      this.player = null;
      placeholderPlayer.removeHand(this);
    }
    if (game != null)
    {
      Game placeholderGame = game;
      this.game = null;
      placeholderGame.removeCurrentTrickBeingBuilt(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "suit" + ":" + getSuit()+ "," +
            "rank" + ":" + getRank()+ "," +
            "isJoker" + ":" + getIsJoker()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cardSet = "+(getCardSet()!=null?Integer.toHexString(System.identityHashCode(getCardSet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null")
     + outputString;
  }
}