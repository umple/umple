/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Position;
import shared.domain.Candidature;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

/**
 * handles all database-related tasks regarding Candidature objects
 */
public class CandidatureService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static CandidatureService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CandidatureService Attributes
  private Candidature newCandidature;
  private boolean candidatureAdded;
  private boolean candidatureFound;
  private Connection theConnection;

  //CandidatureService State Machines
  enum CandidatureServiceCycle { Idle, CreatingCandidature, FindingCandidature }
  private CandidatureServiceCycle CandidatureServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private CandidatureService()
  {
    candidatureAdded = false;
    candidatureFound = false;
    setCandidatureServiceCycle(CandidatureServiceCycle.Idle);
  }

  public static CandidatureService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new CandidatureService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNewCandidature(Candidature aNewCandidature)
  {
    boolean wasSet = false;
    newCandidature = aNewCandidature;
    wasSet = true;
    createCandidature();
    return wasSet;
  }

  public boolean setCandidatureAdded(boolean aCandidatureAdded)
  {
    boolean wasSet = false;
    candidatureAdded = aCandidatureAdded;
    wasSet = true;
    return wasSet;
  }

  /**
   * Returns the new Candidature object to be inserted in the database.
   * The newCandidature attribute, once set, triggers an insertion search in the database.
   */
  public Candidature getNewCandidature()
  {
    return newCandidature;
  }

  public boolean getCandidatureAdded()
  {
    return candidatureAdded;
  }

  public boolean isCandidatureAdded()
  {
    return candidatureAdded;
  }

  public String getCandidatureServiceCycleFullName()
  {
    String answer = CandidatureServiceCycle.toString();
    return answer;
  }

  public CandidatureServiceCycle getCandidatureServiceCycle()
  {
    return CandidatureServiceCycle;
  }

  public boolean createCandidature()
  {
    boolean wasEventProcessed = false;
    
    CandidatureServiceCycle aCandidatureServiceCycle = CandidatureServiceCycle;
    switch (aCandidatureServiceCycle)
    {
      case Idle:
        setCandidatureServiceCycle(CandidatureServiceCycle.FindingCandidature);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition117__()
  {
    boolean wasEventProcessed = false;
    
    CandidatureServiceCycle aCandidatureServiceCycle = CandidatureServiceCycle;
    switch (aCandidatureServiceCycle)
    {
      case CreatingCandidature:
        setCandidatureServiceCycle(CandidatureServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition118__()
  {
    boolean wasEventProcessed = false;
    
    CandidatureServiceCycle aCandidatureServiceCycle = CandidatureServiceCycle;
    switch (aCandidatureServiceCycle)
    {
      case FindingCandidature:
        if (candidatureFound)
        {
          setCandidatureServiceCycle(CandidatureServiceCycle.Idle);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition119__()
  {
    boolean wasEventProcessed = false;
    
    CandidatureServiceCycle aCandidatureServiceCycle = CandidatureServiceCycle;
    switch (aCandidatureServiceCycle)
    {
      case FindingCandidature:
        if (!candidatureFound)
        {
          setCandidatureServiceCycle(CandidatureServiceCycle.CreatingCandidature);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private void setCandidatureServiceCycle(CandidatureServiceCycle aCandidatureServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.db_hostname+"/elections", Credentials.db_username, Credentials.db_password);
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    CandidatureServiceCycle = aCandidatureServiceCycle;

    // entry actions and do activities
    switch(CandidatureServiceCycle)
    {
      case CreatingCandidature:
        addCandidature();
        __autotransition117__();
        break;
      case FindingCandidature:
        tryFindingCandidature();
        __autotransition118__();
        __autotransition119__();
        break;
    }
  }

  public void delete()
  {}


  public void addCandidature(){
      try {
      Statement stmt = theConnection.createStatement();
      int idCandidate=newCandidature.getCandidate().getIdCandidate();
      int idEFP=newCandidature.getElectionForPosition().getIdElectionForPosition();
      stmt.executeUpdate("insert into elections.candidature (candidate_id_candidate, election_for_position_id_election_for_position) values ('"+idCandidate+"', '"+idEFP+"')");
      candidatureAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      candidatureAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void tryFindingCandidature() {
    candidatureFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      int idCandidate=newCandidature.getCandidate().getIdCandidate();
      int idEFP=newCandidature.getElectionForPosition().getIdElectionForPosition();
      ResultSet rs = stmt.executeQuery("SELECT * FROM elections.candidature where candidate_id_candidate='"+idCandidate+"' and election_for_position_id_election_for_position='"+idEFP+"'");
      if (!rs.next())
        candidatureFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      candidatureFound=false;
    }
  }
}