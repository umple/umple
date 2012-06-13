/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

public class ElectionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ElectionService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ElectionService Attributes
  private Election newElection;
  private List<Election> elections;
  private Connection theConnection;
  private boolean electionAdded;
  private String electionNameToSearch;
  private boolean electionFound;

  //ElectionService State Machines
  enum ElectionServiceCycle { Idle, LoadingAllElections, CreatingElection, FindingElectionByName }
  private ElectionServiceCycle ElectionServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ElectionService()
  {
    electionAdded = false;
    electionNameToSearch = null;
    electionFound = false;
    setElectionServiceCycle(ElectionServiceCycle.Idle);
  }

  public static ElectionService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ElectionService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNewElection(Election aNewElection)
  {
    boolean wasSet = false;
    newElection = aNewElection;
    wasSet = true;
    createElection();
    return wasSet;
  }

  public boolean setElections(List<Election> aElections)
  {
    boolean wasSet = false;
    elections = aElections;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionAdded(boolean aElectionAdded)
  {
    boolean wasSet = false;
    electionAdded = aElectionAdded;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionNameToSearch(String aElectionNameToSearch)
  {
    boolean wasSet = false;
    electionNameToSearch = aElectionNameToSearch;
    wasSet = true;
    findElectionByName();
    return wasSet;
  }

  public boolean setElectionFound(boolean aElectionFound)
  {
    boolean wasSet = false;
    electionFound = aElectionFound;
    wasSet = true;
    return wasSet;
  }

  public Election getNewElection()
  {
    return newElection;
  }

  public List<Election> getElections()
  {
    return elections;
  }

  public boolean getElectionAdded()
  {
    return electionAdded;
  }

  public String getElectionNameToSearch()
  {
    return electionNameToSearch;
  }

  public boolean getElectionFound()
  {
    return electionFound;
  }

  public boolean isElectionAdded()
  {
    return electionAdded;
  }

  public boolean isElectionFound()
  {
    return electionFound;
  }

  public String getElectionServiceCycleFullName()
  {
    String answer = ElectionServiceCycle.toString();
    return answer;
  }

  public ElectionServiceCycle getElectionServiceCycle()
  {
    return ElectionServiceCycle;
  }

  public boolean getAllElections()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case Idle:
        setElectionServiceCycle(ElectionServiceCycle.LoadingAllElections);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean createElection()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case Idle:
        setElectionServiceCycle(ElectionServiceCycle.CreatingElection);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean findElectionByName()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case Idle:
        setElectionServiceCycle(ElectionServiceCycle.FindingElectionByName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition281__()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case LoadingAllElections:
        setElectionServiceCycle(ElectionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition282__()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case CreatingElection:
        setElectionServiceCycle(ElectionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition283__()
  {
    boolean wasEventProcessed = false;
    
    ElectionServiceCycle aElectionServiceCycle = ElectionServiceCycle;
    switch (aElectionServiceCycle)
    {
      case FindingElectionByName:
        setElectionServiceCycle(ElectionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setElectionServiceCycle(ElectionServiceCycle aElectionServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.getInstance().getDb_hostname()+"/elections", Credentials.getInstance().getDb_username(), Credentials.getInstance().getDb_password());
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    ElectionServiceCycle = aElectionServiceCycle;

    // entry actions and do activities
    switch(ElectionServiceCycle)
    {
      case LoadingAllElections:
        loadAllElections();
        __autotransition281__();
        break;
      case CreatingElection:
        addElection();
        __autotransition282__();
        break;
      case FindingElectionByName:
        tryFindingElectionByName();
        __autotransition283__();
        break;
    }
  }

  public void delete()
  {}


  public void loadAllElections(){
      elections=new ArrayList<Election>();
    
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM election");
      while (rs.next()) {
        String name = rs.getString("name");
        String description = rs.getString("description");
        int id=Integer.parseInt(rs.getString("id_election"));
        Election election=new Election(id, name, description, null);
        elections.add(election);
      }
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }


  public void addElection(){
      try {
      Statement stmt = theConnection.createStatement();
      stmt.executeUpdate("insert into elections.election (name, description) values ('"+newElection.getName()+"', '"+newElection.getDescription()+"')");
      electionAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      electionAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void tryFindingElectionByName() {
    electionFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM election where name='"+electionNameToSearch+"'");
      if (!rs.next())
        electionFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      electionFound=false;
    }
  }
}