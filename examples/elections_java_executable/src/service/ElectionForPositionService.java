/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.ElectionForPosition;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

/**
 * handles all database-related tasks regarding ElectionForPosition objects
 */
public class ElectionForPositionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ElectionForPositionService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionForPositionService Attributes
  private ElectionForPosition electionForPositionToSearch;
  private ElectionForPosition newElectionForPosition;
  private boolean electionForPositionFound;
  private boolean electionForPositionAdded;
  private Connection theConnection;
  private boolean efpFound;

  //ElectionForPositionService State Machines
  enum ElectionForPositionServiceCycle { Idle, CreatingElectionForPosition, FindingElectionForPosition }
  private ElectionForPositionServiceCycle ElectionForPositionServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ElectionForPositionService()
  {
    electionForPositionFound = false;
    electionForPositionAdded = false;
    efpFound = false;
    setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.Idle);
  }

  public static ElectionForPositionService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ElectionForPositionService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setElectionForPositionToSearch(ElectionForPosition aElectionForPositionToSearch)
  {
    boolean wasSet = false;
    electionForPositionToSearch = aElectionForPositionToSearch;
    wasSet = true;
    return wasSet;
  }

  public boolean setNewElectionForPosition(ElectionForPosition aNewElectionForPosition)
  {
    boolean wasSet = false;
    newElectionForPosition = aNewElectionForPosition;
    wasSet = true;
    createElectionForPosition();
    return wasSet;
  }

  public boolean setElectionForPositionFound(boolean aElectionForPositionFound)
  {
    boolean wasSet = false;
    electionForPositionFound = aElectionForPositionFound;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionForPositionAdded(boolean aElectionForPositionAdded)
  {
    boolean wasSet = false;
    electionForPositionAdded = aElectionForPositionAdded;
    wasSet = true;
    return wasSet;
  }

  public boolean setEfpFound(boolean aEfpFound)
  {
    boolean wasSet = false;
    efpFound = aEfpFound;
    wasSet = true;
    return wasSet;
  }

  /**
   * Returns the ElectionForPosition object that was set to search in the database.
   * The electionForPositionToSearch attribute, once set, triggers a search in the database.
   */
  public ElectionForPosition getElectionForPositionToSearch()
  {
    return electionForPositionToSearch;
  }

  /**
   * Returns the new ElectionForPosition object to be inserted in the database.
   * The newElectionForPosition attribute, once set, triggers an insertion search in the database.
   */
  public ElectionForPosition getNewElectionForPosition()
  {
    return newElectionForPosition;
  }

  /**
   * Returns the result of the latest search for an ElectionForPosition Object.
   */
  public boolean getElectionForPositionFound()
  {
    return electionForPositionFound;
  }

  /**
   * Returns the ElectionForPosition object that was set to search in the database.
   * The electionForPositionToSearch attribute, once set, triggers a search in the database.
   */
  public boolean getElectionForPositionAdded()
  {
    return electionForPositionAdded;
  }

  public boolean getEfpFound()
  {
    return efpFound;
  }

  public boolean isElectionForPositionFound()
  {
    return electionForPositionFound;
  }

  public boolean isElectionForPositionAdded()
  {
    return electionForPositionAdded;
  }

  public boolean isEfpFound()
  {
    return efpFound;
  }

  public String getElectionForPositionServiceCycleFullName()
  {
    String answer = ElectionForPositionServiceCycle.toString();
    return answer;
  }

  public ElectionForPositionServiceCycle getElectionForPositionServiceCycle()
  {
    return ElectionForPositionServiceCycle;
  }

  public boolean createElectionForPosition()
  {
    boolean wasEventProcessed = false;
    
    ElectionForPositionServiceCycle aElectionForPositionServiceCycle = ElectionForPositionServiceCycle;
    switch (aElectionForPositionServiceCycle)
    {
      case Idle:
        setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.FindingElectionForPosition);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition353__()
  {
    boolean wasEventProcessed = false;
    
    ElectionForPositionServiceCycle aElectionForPositionServiceCycle = ElectionForPositionServiceCycle;
    switch (aElectionForPositionServiceCycle)
    {
      case CreatingElectionForPosition:
        setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition354__()
  {
    boolean wasEventProcessed = false;
    
    ElectionForPositionServiceCycle aElectionForPositionServiceCycle = ElectionForPositionServiceCycle;
    switch (aElectionForPositionServiceCycle)
    {
      case FindingElectionForPosition:
        if (efpFound)
        {
          setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.Idle);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition355__()
  {
    boolean wasEventProcessed = false;
    
    ElectionForPositionServiceCycle aElectionForPositionServiceCycle = ElectionForPositionServiceCycle;
    switch (aElectionForPositionServiceCycle)
    {
      case FindingElectionForPosition:
        if (!efpFound)
        {
          setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.CreatingElectionForPosition);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private void setElectionForPositionServiceCycle(ElectionForPositionServiceCycle aElectionForPositionServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.getInstance().getDb_hostname()+"/elections", Credentials.getInstance().getDb_username(), Credentials.getInstance().getDb_password());
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    ElectionForPositionServiceCycle = aElectionForPositionServiceCycle;

    // entry actions and do activities
    switch(ElectionForPositionServiceCycle)
    {
      case CreatingElectionForPosition:
        addElectionForPosition();
        __autotransition353__();
        break;
      case FindingElectionForPosition:
        tryFindingElectionForPosition();
        __autotransition354__();
        __autotransition355__();
        break;
    }
  }

  public void delete()
  {}


  public void addElectionForPosition(){
      try {
      Statement stmt = theConnection.createStatement();
      stmt.executeUpdate("insert into elections.election_for_position (election_id_election, position_id_position) values ('"+newElectionForPosition.getElection().getIdElection()+"', '"+newElectionForPosition.getPosition().getIdPosition()+"')");
      electionForPositionAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      electionForPositionAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void tryFindingElectionForPosition() {
    efpFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM election_for_position where election_id_election='"+newElectionForPosition.getElection().getIdElection()+"' and position_id_position='"+newElectionForPosition.getPosition().getIdPosition()+"'");
      if (!rs.next())
        efpFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      efpFound=false;
    }
  }
}