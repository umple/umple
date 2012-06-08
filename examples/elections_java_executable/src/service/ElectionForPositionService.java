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

  //ElectionForPositionService State Machines
  enum ElectionForPositionServiceCycle { Idle, CreatingElectionForPosition }
  private ElectionForPositionServiceCycle ElectionForPositionServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ElectionForPositionService()
  {
    electionForPositionFound = false;
    electionForPositionAdded = false;
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

  public boolean setTheConnection(Connection aTheConnection)
  {
    boolean wasSet = false;
    theConnection = aTheConnection;
    wasSet = true;
    return wasSet;
  }

  public ElectionForPosition getElectionForPositionToSearch()
  {
    return electionForPositionToSearch;
  }

  public ElectionForPosition getNewElectionForPosition()
  {
    return newElectionForPosition;
  }

  public boolean getElectionForPositionFound()
  {
    return electionForPositionFound;
  }

  public boolean getElectionForPositionAdded()
  {
    return electionForPositionAdded;
  }

  public Connection getTheConnection()
  {
    return theConnection;
  }

  public boolean isElectionForPositionFound()
  {
    return electionForPositionFound;
  }

  public boolean isElectionForPositionAdded()
  {
    return electionForPositionAdded;
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
        setElectionForPositionServiceCycle(ElectionForPositionServiceCycle.CreatingElectionForPosition);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1402__()
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

  private void setElectionForPositionServiceCycle(ElectionForPositionServiceCycle aElectionForPositionServiceCycle)
  {
    ElectionForPositionServiceCycle = aElectionForPositionServiceCycle;

    // entry actions and do activities
    switch(ElectionForPositionServiceCycle)
    {
      case CreatingElectionForPosition:
        addElectionForPosition();
        __autotransition1402__();
        break;
    }
  }

  public void delete()
  {}


  /**
   * void loadElectionPolls() {
   * polls=new ArrayList<Poll>();
   * try {
   * Statement stmt = theConnection.createStatement();
   * ResultSet rs = stmt.executeQuery("SELECT * FROM poll where election_id_election="+selectedElection.getIdElection());
   * while (rs.next()) {
   * String name = rs.getString("name");
   * String description = rs.getString("description");
   * int id=Integer.parseInt(rs.getString("id_poll"));
   * Poll poll=new Poll(id, name, description, selectedElection);
   * polls.add(poll);
   * }
   * } catch(Exception e) {
   * System.err.println("Exception: " + e.getMessage());
   * }
   * 
   * 
   * void tryToOpenPoll() {
   * try {
   * Statement stmt = theConnection.createStatement();
   * stmt.executeUpdate("update elections.poll set status='open' where id_poll="+selectedPoll.getIdPoll());
   * pollOpenned=true;
   * } catch(Exception e) {
   * System.err.println("Exception: " + e.getMessage());
   * pollOpenned=false;
   * }
   * 
   */
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

}