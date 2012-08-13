/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Candidate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

public class CandidateService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static CandidateService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CandidateService Attributes
  private Candidate newCandidate;
  private List<Candidate> candidates;
  private Connection theConnection;
  private boolean candidateAdded;
  private String candidateNameToSearch;
  private boolean candidateFound;

  //CandidateService State Machines
  enum CandidateServiceCycle { Idle, LoadingAllCandidates, CreatingCandidate, FindingCandidateByName }
  private CandidateServiceCycle CandidateServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private CandidateService()
  {
    candidateAdded = false;
    candidateNameToSearch = null;
    candidateFound = false;
    setCandidateServiceCycle(CandidateServiceCycle.Idle);
  }

  public static CandidateService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new CandidateService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNewCandidate(Candidate aNewCandidate)
  {
    boolean wasSet = false;
    newCandidate = aNewCandidate;
    wasSet = true;
    createCandidate();
    return wasSet;
  }

  public boolean setCandidates(List<Candidate> aCandidates)
  {
    boolean wasSet = false;
    candidates = aCandidates;
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidateAdded(boolean aCandidateAdded)
  {
    boolean wasSet = false;
    candidateAdded = aCandidateAdded;
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidateNameToSearch(String aCandidateNameToSearch)
  {
    boolean wasSet = false;
    candidateNameToSearch = aCandidateNameToSearch;
    wasSet = true;
    findCandidateByName();
    return wasSet;
  }

  public boolean setCandidateFound(boolean aCandidateFound)
  {
    boolean wasSet = false;
    candidateFound = aCandidateFound;
    wasSet = true;
    return wasSet;
  }

  public Candidate getNewCandidate()
  {
    return newCandidate;
  }

  public List<Candidate> getCandidates()
  {
    return candidates;
  }

  public boolean getCandidateAdded()
  {
    return candidateAdded;
  }

  public String getCandidateNameToSearch()
  {
    return candidateNameToSearch;
  }

  public boolean getCandidateFound()
  {
    return candidateFound;
  }

  public boolean isCandidateAdded()
  {
    return candidateAdded;
  }

  public boolean isCandidateFound()
  {
    return candidateFound;
  }

  public String getCandidateServiceCycleFullName()
  {
    String answer = CandidateServiceCycle.toString();
    return answer;
  }

  public CandidateServiceCycle getCandidateServiceCycle()
  {
    return CandidateServiceCycle;
  }

  public boolean getAllCandidates()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case Idle:
        setCandidateServiceCycle(CandidateServiceCycle.LoadingAllCandidates);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean createCandidate()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case Idle:
        setCandidateServiceCycle(CandidateServiceCycle.CreatingCandidate);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean findCandidateByName()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case Idle:
        setCandidateServiceCycle(CandidateServiceCycle.FindingCandidateByName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition111__()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case LoadingAllCandidates:
        setCandidateServiceCycle(CandidateServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition112__()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case CreatingCandidate:
        setCandidateServiceCycle(CandidateServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition113__()
  {
    boolean wasEventProcessed = false;
    
    CandidateServiceCycle aCandidateServiceCycle = CandidateServiceCycle;
    switch (aCandidateServiceCycle)
    {
      case FindingCandidateByName:
        setCandidateServiceCycle(CandidateServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setCandidateServiceCycle(CandidateServiceCycle aCandidateServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.db_hostname+"/elections", Credentials.db_username, Credentials.db_password);
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    CandidateServiceCycle = aCandidateServiceCycle;

    // entry actions and do activities
    switch(CandidateServiceCycle)
    {
      case LoadingAllCandidates:
        loadAllCandidates();
        __autotransition111__();
        break;
      case CreatingCandidate:
        addCandidate();
        __autotransition112__();
        break;
      case FindingCandidateByName:
        tryFindingCandidateByName();
        __autotransition113__();
        break;
    }
  }

  public void delete()
  {}


  public void loadAllCandidates(){
      candidates=new ArrayList<Candidate>();
    
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM elections.candidate");
      while (rs.next()) {
        String name = rs.getString("name");
        String address = rs.getString("address");
        String telephone = rs.getString("telephone");
        int id=Integer.parseInt(rs.getString("id_candidate"));
        Candidate candidate=new Candidate(id, name, address, telephone);
        candidates.add(candidate);
      }
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }


  public void addCandidate(){
      try {
      Statement stmt = theConnection.createStatement();
      stmt.executeUpdate("insert into elections.candidate (name, address, telephone) values ('"+newCandidate.getName()+"', '"+newCandidate.getAddress()+"', '"+newCandidate.getTelephone()+"')");
      candidateAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      candidateAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void tryFindingCandidateByName() {
    candidateFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM candidate where name='"+candidateNameToSearch+"'");
      if (!rs.next())
        candidateFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      candidateFound=false;
    }
  }
}