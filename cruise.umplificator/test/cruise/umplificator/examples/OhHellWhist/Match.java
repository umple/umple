/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 57 "OhHellWhist.ump"
// line 120 "OhHellWhist.ump"
public class Match
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Match Attributes
  private boolean isWhist;
  private int scoreToWin;

  //Match Associations
  private List<ScoringTeam> scoringTeams;
  private List<Game> games;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Match(boolean aIsWhist, int aScoreToWin, ScoringTeam... allScoringTeams)
  {
    isWhist = aIsWhist;
    scoreToWin = aScoreToWin;
    scoringTeams = new ArrayList<ScoringTeam>();
    boolean didAddScoringTeams = setScoringTeams(allScoringTeams);
    if (!didAddScoringTeams)
    {
      throw new RuntimeException("Unable to create Match, must have at least 2 scoringTeams");
    }
    games = new ArrayList<Game>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsWhist(boolean aIsWhist)
  {
    boolean wasSet = false;
    isWhist = aIsWhist;
    wasSet = true;
    return wasSet;
  }

  public boolean setScoreToWin(int aScoreToWin)
  {
    boolean wasSet = false;
    scoreToWin = aScoreToWin;
    wasSet = true;
    return wasSet;
  }

  /**
   * A match is played in a number of games
   * True if whist; false if Oh Hell
   */
  public boolean getIsWhist()
  {
    return isWhist;
  }

  /**
   * The score agreed to in order to declare winner
   */
  public int getScoreToWin()
  {
    return scoreToWin;
  }

  public boolean isIsWhist()
  {
    return isWhist;
  }

  public ScoringTeam getScoringTeam(int index)
  {
    ScoringTeam aScoringTeam = scoringTeams.get(index);
    return aScoringTeam;
  }

  /**
   * The following determines the players
   * the first player in the first team deals first
   * Exactly 2 if Whist
   */
  public List<ScoringTeam> getScoringTeams()
  {
    List<ScoringTeam> newScoringTeams = Collections.unmodifiableList(scoringTeams);
    return newScoringTeams;
  }

  public int numberOfScoringTeams()
  {
    int number = scoringTeams.size();
    return number;
  }

  public boolean hasScoringTeams()
  {
    boolean has = scoringTeams.size() > 0;
    return has;
  }

  public int indexOfScoringTeam(ScoringTeam aScoringTeam)
  {
    int index = scoringTeams.indexOf(aScoringTeam);
    return index;
  }

  public Game getGame(int index)
  {
    Game aGame = games.get(index);
    return aGame;
  }

  /**
   * Games continue until a player or team wins
   */
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

  public boolean isNumberOfScoringTeamsValid()
  {
    boolean isValid = numberOfScoringTeams() >= minimumNumberOfScoringTeams();
    return isValid;
  }

  public static int minimumNumberOfScoringTeams()
  {
    return 2;
  }

  public boolean addScoringTeam(ScoringTeam aScoringTeam)
  {
    boolean wasAdded = false;
    if (scoringTeams.contains(aScoringTeam)) { return false; }
    scoringTeams.add(aScoringTeam);
    if (aScoringTeam.indexOfMatch(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aScoringTeam.addMatch(this);
      if (!wasAdded)
      {
        scoringTeams.remove(aScoringTeam);
      }
    }
    return wasAdded;
  }

  public boolean removeScoringTeam(ScoringTeam aScoringTeam)
  {
    boolean wasRemoved = false;
    if (!scoringTeams.contains(aScoringTeam))
    {
      return wasRemoved;
    }

    if (numberOfScoringTeams() <= minimumNumberOfScoringTeams())
    {
      return wasRemoved;
    }

    int oldIndex = scoringTeams.indexOf(aScoringTeam);
    scoringTeams.remove(oldIndex);
    if (aScoringTeam.indexOfMatch(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aScoringTeam.removeMatch(this);
      if (!wasRemoved)
      {
        scoringTeams.add(oldIndex,aScoringTeam);
      }
    }
    return wasRemoved;
  }

  public boolean setScoringTeams(ScoringTeam... newScoringTeams)
  {
    boolean wasSet = false;
    ArrayList<ScoringTeam> verifiedScoringTeams = new ArrayList<ScoringTeam>();
    for (ScoringTeam aScoringTeam : newScoringTeams)
    {
      if (verifiedScoringTeams.contains(aScoringTeam))
      {
        continue;
      }
      verifiedScoringTeams.add(aScoringTeam);
    }

    if (verifiedScoringTeams.size() != newScoringTeams.length || verifiedScoringTeams.size() < minimumNumberOfScoringTeams())
    {
      return wasSet;
    }

    ArrayList<ScoringTeam> oldScoringTeams = new ArrayList<ScoringTeam>(scoringTeams);
    scoringTeams.clear();
    for (ScoringTeam aNewScoringTeam : verifiedScoringTeams)
    {
      scoringTeams.add(aNewScoringTeam);
      if (oldScoringTeams.contains(aNewScoringTeam))
      {
        oldScoringTeams.remove(aNewScoringTeam);
      }
      else
      {
        aNewScoringTeam.addMatch(this);
      }
    }

    for (ScoringTeam anOldScoringTeam : oldScoringTeams)
    {
      anOldScoringTeam.removeMatch(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addScoringTeamAt(ScoringTeam aScoringTeam, int index)
  {  
    boolean wasAdded = false;
    if(addScoringTeam(aScoringTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfScoringTeams()) { index = numberOfScoringTeams() - 1; }
      scoringTeams.remove(aScoringTeam);
      scoringTeams.add(index, aScoringTeam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveScoringTeamAt(ScoringTeam aScoringTeam, int index)
  {
    boolean wasAdded = false;
    if(scoringTeams.contains(aScoringTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfScoringTeams()) { index = numberOfScoringTeams() - 1; }
      scoringTeams.remove(aScoringTeam);
      scoringTeams.add(index, aScoringTeam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addScoringTeamAt(aScoringTeam, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfGames()
  {
    return 0;
  }

  public Game addGame(String aTrumps, Player aDealer)
  {
    return new Game(aTrumps, aDealer, this);
  }

  public boolean addGame(Game aGame)
  {
    boolean wasAdded = false;
    if (games.contains(aGame)) { return false; }
    Match existingMatch = aGame.getMatch();
    boolean isNewMatch = existingMatch != null && !this.equals(existingMatch);
    if (isNewMatch)
    {
      aGame.setMatch(this);
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
    //Unable to remove aGame, as it must always have a match
    if (!this.equals(aGame.getMatch()))
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

  public void delete()
  {
    ArrayList<ScoringTeam> copyOfScoringTeams = new ArrayList<ScoringTeam>(scoringTeams);
    scoringTeams.clear();
    for(ScoringTeam aScoringTeam : copyOfScoringTeams)
    {
      aScoringTeam.removeMatch(this);
    }
    for(int i=games.size(); i > 0; i--)
    {
      Game aGame = games.get(i - 1);
      aGame.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isWhist" + ":" + getIsWhist()+ "," +
            "scoreToWin" + ":" + getScoreToWin()+ "]"
     + outputString;
  }
}