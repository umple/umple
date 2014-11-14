/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 22 "OhHellWhist.ump"
// line 103 "OhHellWhist.ump"
public class Trick extends CardSet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trick Associations
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trick(Player aPlayer)
  {
    super();
    boolean didAddPlayer = setPlayer(aPlayer);
    if (!didAddPlayer)
    {
      throw new RuntimeException("Unable to create trick due to player");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Player getPlayer()
  {
    return player;
  }

  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    if (aPlayer == null)
    {
      return wasSet;
    }

    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removeTrick(this);
    }
    player.addTrick(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Player placeholderPlayer = player;
    this.player = null;
    placeholderPlayer.removeTrick(this);
    super.delete();
  }

}