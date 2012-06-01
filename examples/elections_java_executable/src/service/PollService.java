/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Poll;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

public class PollService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static PollService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PollService Attributes
  private Poll selectedPoll;
  private Election selectedElection;
  private List<Poll> polls;
  private Connection theConnection;
  private boolean pollOpenned;

  //PollService State Machines
  enum PollServiceCycle { Idle, LoadingElectionPolls, OpenningPoll }
  private PollServiceCycle PollServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private PollService()
  {
    pollOpenned = false;
    setPollServiceCycle(PollServiceCycle.Idle);
  }

  public static PollService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new PollService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSelectedPoll(Poll aSelectedPoll)
  {
    boolean wasSet = false;
    selectedPoll = aSelectedPoll;
    wasSet = true;
    openPoll();
    return wasSet;
  }

  public boolean setSelectedElection(Election aSelectedElection)
  {
    boolean wasSet = false;
    selectedElection = aSelectedElection;
    wasSet = true;
    getElectionPolls();
    return wasSet;
  }

  public boolean setPolls(List<Poll> aPolls)
  {
    boolean wasSet = false;
    polls = aPolls;
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

  public boolean setPollOpenned(boolean aPollOpenned)
  {
    boolean wasSet = false;
    pollOpenned = aPollOpenned;
    wasSet = true;
    return wasSet;
  }

  public Poll getSelectedPoll()
  {
    return selectedPoll;
  }

  public Election getSelectedElection()
  {
    return selectedElection;
  }

  public List<Poll> getPolls()
  {
    return polls;
  }

  public Connection getTheConnection()
  {
    return theConnection;
  }

  public boolean getPollOpenned()
  {
    return pollOpenned;
  }

  public boolean isPollOpenned()
  {
    return pollOpenned;
  }

  public String getPollServiceCycleFullName()
  {
    String answer = PollServiceCycle.toString();
    return answer;
  }

  public PollServiceCycle getPollServiceCycle()
  {
    return PollServiceCycle;
  }

  public boolean getElectionPolls()
  {
    boolean wasEventProcessed = false;
    
    PollServiceCycle aPollServiceCycle = PollServiceCycle;
    switch (aPollServiceCycle)
    {
      case Idle:
        setPollServiceCycle(PollServiceCycle.LoadingElectionPolls);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean openPoll()
  {
    boolean wasEventProcessed = false;
    
    PollServiceCycle aPollServiceCycle = PollServiceCycle;
    switch (aPollServiceCycle)
    {
      case LoadingElectionPolls:
        setPollServiceCycle(PollServiceCycle.OpenningPoll);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setPollServiceCycle(PollServiceCycle aPollServiceCycle)
  {
    try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.getInstance().getDb_hostname()+"/elections", Credentials.getInstance().getDb_username(), Credentials.getInstance().getDb_password());
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
    PollServiceCycle = aPollServiceCycle;

    // entry actions and do activities
    switch(PollServiceCycle)
    {
      case LoadingElectionPolls:
        loadElectionPolls();
        break;
      case OpenningPoll:
        tryToOpenPoll();
        break;
    }
  }

  public void delete()
  {}


  public void loadElectionPolls(){
      polls=new ArrayList<Poll>();
		try {
			Statement stmt = theConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM poll where election_id_election="+selectedElection.getIdElection());
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int id=Integer.parseInt(rs.getString("id_poll"));
				Poll poll=new Poll(id, name, description, selectedElection);
				polls.add(poll);
			}
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
  }


  public void tryToOpenPoll(){
      try {
			Statement stmt = theConnection.createStatement();
			stmt.executeUpdate("update elections.poll set status='open' where id_poll="+selectedPoll.getIdPoll());
			pollOpenned=true;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			pollOpenned=false;
		}
  }

}