/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Voter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

public class VoterService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static VoterService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoterService Attributes
  private Voter newVoter;
  private List<Voter> voters;
  private Connection theConnection;
  private boolean voterAdded;
  private String voterNameToSearch;
  private boolean voterFound;

  //VoterService State Machines
  enum VoterServiceCycle { Idle, LoadingAllVoters, CreatingVoter, FindingVoterByName }
  private VoterServiceCycle VoterServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private VoterService()
  {
    voterAdded = false;
    voterNameToSearch = null;
    voterFound = false;
    setVoterServiceCycle(VoterServiceCycle.Idle);
  }

  public static VoterService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new VoterService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNewVoter(Voter aNewVoter)
  {
    boolean wasSet = false;
    newVoter = aNewVoter;
    wasSet = true;
    createVoter();
    return wasSet;
  }

  public boolean setVoters(List<Voter> aVoters)
  {
    boolean wasSet = false;
    voters = aVoters;
    wasSet = true;
    return wasSet;
  }

  public boolean setVoterAdded(boolean aVoterAdded)
  {
    boolean wasSet = false;
    voterAdded = aVoterAdded;
    wasSet = true;
    return wasSet;
  }

  public boolean setVoterNameToSearch(String aVoterNameToSearch)
  {
    boolean wasSet = false;
    voterNameToSearch = aVoterNameToSearch;
    wasSet = true;
    findVoterByName();
    return wasSet;
  }

  public boolean setVoterFound(boolean aVoterFound)
  {
    boolean wasSet = false;
    voterFound = aVoterFound;
    wasSet = true;
    return wasSet;
  }

  public Voter getNewVoter()
  {
    return newVoter;
  }

  public List<Voter> getVoters()
  {
    return voters;
  }

  public boolean getVoterAdded()
  {
    return voterAdded;
  }

  public String getVoterNameToSearch()
  {
    return voterNameToSearch;
  }

  public boolean getVoterFound()
  {
    return voterFound;
  }

  public boolean isVoterAdded()
  {
    return voterAdded;
  }

  public boolean isVoterFound()
  {
    return voterFound;
  }

  public String getVoterServiceCycleFullName()
  {
    String answer = VoterServiceCycle.toString();
    return answer;
  }

  public VoterServiceCycle getVoterServiceCycle()
  {
    return VoterServiceCycle;
  }

  public boolean getAllVoters()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case Idle:
        setVoterServiceCycle(VoterServiceCycle.LoadingAllVoters);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean createVoter()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case Idle:
        setVoterServiceCycle(VoterServiceCycle.CreatingVoter);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean findVoterByName()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case Idle:
        setVoterServiceCycle(VoterServiceCycle.FindingVoterByName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition114__()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case LoadingAllVoters:
        setVoterServiceCycle(VoterServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition115__()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case CreatingVoter:
        setVoterServiceCycle(VoterServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition116__()
  {
    boolean wasEventProcessed = false;
    
    VoterServiceCycle aVoterServiceCycle = VoterServiceCycle;
    switch (aVoterServiceCycle)
    {
      case FindingVoterByName:
        setVoterServiceCycle(VoterServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setVoterServiceCycle(VoterServiceCycle aVoterServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.db_hostname+"/elections", Credentials.db_username, Credentials.db_password);
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    VoterServiceCycle = aVoterServiceCycle;

    // entry actions and do activities
    switch(VoterServiceCycle)
    {
      case LoadingAllVoters:
        loadAllVoters();
        __autotransition114__();
        break;
      case CreatingVoter:
        addVoter();
        __autotransition115__();
        break;
      case FindingVoterByName:
        tryFindingVoterByName();
        __autotransition116__();
        break;
    }
  }

  public void delete()
  {}


  public void loadAllVoters(){
      voters=new ArrayList<Voter>();
    
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM elections.voter");
      while (rs.next()) {
        String name = rs.getString("name");
        String address = rs.getString("address");
        String telephone = rs.getString("telephone");
        int id=Integer.parseInt(rs.getString("id_voter"));
        Voter voter=new Voter(id, name, address, telephone);
        voters.add(voter);
      }
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }


  public void addVoter(){
      try {
      Statement stmt = theConnection.createStatement();
      stmt.executeUpdate("insert into elections.voter (name, address, telephone) values ('"+newVoter.getName()+"', '"+newVoter.getAddress()+"', '"+newVoter.getTelephone()+"')");
      voterAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      voterAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void tryFindingVoterByName() {
    voterFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM voter where name='"+voterNameToSearch+"'");
      if (!rs.next())
        voterFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      voterFound=false;
    }
  }
}