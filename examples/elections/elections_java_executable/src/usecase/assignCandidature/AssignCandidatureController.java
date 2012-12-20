/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.assignCandidature;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Candidate;
import shared.domain.Candidature;
import shared.domain.Position;
import shared.domain.ElectionForPosition;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import shared.Result;
import service.ElectionService;
import service.PositionService;
import service.CandidateService;
import service.CandidatureService;
import service.ElectionForPositionService;
import usecase.startup.Controller;
import view.assignPositionCandidate.AssignPositionCandidateView;

public class AssignCandidatureController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static AssignCandidatureController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssignCandidatureController Attributes
  private Connection theConnection;
  private Election selectedElection;
  private int option;
  private List<Election> elections;
  private List<Candidate> candidates;
  private List<ElectionForPosition> electionForPositions;
  private AssignPositionCandidateView assignPositionCandidateView;
  private boolean updated;

  //AssignCandidatureController State Machines
  enum CandidateAssignationSteps { Initial, ProvidingElectionsList, ElectionsListProvided, ProvidingElectionForPositionsList, ProvidingPositionsList, ProvidingCandidatesList, CandidatesListProvided, UpdatingCandidature, NoElectionsFound, NoCandidatesFound, NoElectionForPositionsFound, Updated, NotUpdated, Done }
  private CandidateAssignationSteps CandidateAssignationSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AssignCandidatureController()
  {
    option = JOptionPane.NO_OPTION;
    setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
  }

  public static AssignCandidatureController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new AssignCandidatureController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTheConnection(Connection aTheConnection)
  {
    boolean wasSet = false;
    theConnection = aTheConnection;
    wasSet = true;
    return wasSet;
  }

  public boolean setSelectedElection(Election aSelectedElection)
  {
    boolean wasSet = false;
    selectedElection = aSelectedElection;
    wasSet = true;
    return wasSet;
  }

  public boolean setOption(int aOption)
  {
    boolean wasSet = false;
    option = aOption;
    wasSet = true;
    return wasSet;
  }

  public boolean setUpdated(boolean aUpdated)
  {
    boolean wasSet = false;
    updated = aUpdated;
    wasSet = true;
    return wasSet;
  }

  public Connection getTheConnection()
  {
    return theConnection;
  }

  public Election getSelectedElection()
  {
    return selectedElection;
  }

  public int getOption()
  {
    return option;
  }

  public boolean getUpdated()
  {
    return updated;
  }

  public String getCandidateAssignationStepsFullName()
  {
    String answer = CandidateAssignationSteps.toString();
    return answer;
  }

  public CandidateAssignationSteps getCandidateAssignationSteps()
  {
    return CandidateAssignationSteps;
  }

  public boolean assignCandidate()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case Initial:
        setCandidateAssignationSteps(CandidateAssignationSteps.ProvidingElectionsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition70__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingElectionsList:
        if (!elections.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.ElectionsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition71__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingElectionsList:
        if (elections.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.NoElectionsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition72__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ElectionsListProvided:
        setCandidateAssignationSteps(CandidateAssignationSteps.ProvidingElectionForPositionsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition73__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingElectionForPositionsList:
        if (!electionForPositions.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.ProvidingPositionsList);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition74__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingElectionForPositionsList:
        if (electionForPositions.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.NoElectionForPositionsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition75__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingPositionsList:
        setCandidateAssignationSteps(CandidateAssignationSteps.ProvidingCandidatesList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition76__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingCandidatesList:
        if (!candidates.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.CandidatesListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition77__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ProvidingCandidatesList:
        if (candidates.isEmpty())
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.NoCandidatesFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  public boolean updateButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case CandidatesListProvided:
        setCandidateAssignationSteps(CandidateAssignationSteps.UpdatingCandidature);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition78__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case UpdatingCandidature:
        if (updated)
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.Updated);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition79__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case UpdatingCandidature:
        if (!updated)
        {
          setCandidateAssignationSteps(CandidateAssignationSteps.NotUpdated);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition80__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case NoElectionsFound:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition81__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case NoCandidatesFound:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition82__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case NoElectionForPositionsFound:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition83__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case Updated:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition84__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case NotUpdated:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition85__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case Done:
        setCandidateAssignationSteps(CandidateAssignationSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setCandidateAssignationSteps(CandidateAssignationSteps aCandidateAssignationSteps)
  {
    CandidateAssignationSteps = aCandidateAssignationSteps;

    // entry actions and do activities
    switch(CandidateAssignationSteps)
    {
      case ProvidingElectionsList:
        ElectionService.getInstance().getAllElections();
          elections=ElectionService.getInstance().getElections();
        __autotransition70__();
        __autotransition71__();
        break;
      case ElectionsListProvided:
        selectAnElection();
        __autotransition72__();
        break;
      case ProvidingElectionForPositionsList:
        tryLoadingElectionForPositions();
        __autotransition73__();
        __autotransition74__();
        break;
      case ProvidingPositionsList:
        tryLoadingPositions();
        __autotransition75__();
        break;
      case ProvidingCandidatesList:
        CandidateService.getInstance().getAllCandidates();
          candidates=CandidateService.getInstance().getCandidates();
        __autotransition76__();
        __autotransition77__();
        break;
      case CandidatesListProvided:
        showAssignCandidatureView();
        break;
      case UpdatingCandidature:
        updated=tryToUpdateCandidature();
        __autotransition78__();
        __autotransition79__();
        break;
      case NoElectionsFound:
        Result.getInstance().setMessage("No elections found, add an election first!");
          Controller.getInstance().start();
        __autotransition80__();
        break;
      case NoCandidatesFound:
        Result.getInstance().setMessage("No candidates found, add some candidates first!");
          Controller.getInstance().start();
        __autotransition81__();
        break;
      case NoElectionForPositionsFound:
        Result.getInstance().setMessage("No election for positions found, assign some positions to election first!");
          Controller.getInstance().start();
        __autotransition82__();
        break;
      case Updated:
        Result.getInstance().setMessage("Candidature Added Successfully!");
          Controller.getInstance().start();
        __autotransition83__();
        break;
      case NotUpdated:
        Result.getInstance().setMessage("Adding Candidature Failed!");
          Controller.getInstance().start();
        __autotransition84__();
        break;
      case Done:
        Controller.getInstance().start();
        __autotransition85__();
        break;
    }
  }

  public void delete()
  {}


  public void showAssignCandidatureView(){
      assignPositionCandidateView=new AssignPositionCandidateView(candidates, electionForPositions);
     assignPositionCandidateView.setVisible(true);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void selectAnElection() {
    String[] electionNames=new String[elections.size()];
    int i=0;
    for (Election election:elections)
      electionNames[i++]=election.getName();
    Object selectedElectionName = JOptionPane.showInputDialog(null, "Select an Election", "List of Elections", JOptionPane.QUESTION_MESSAGE, null, electionNames, electionNames[0]);
    i=0;
    selectedElection=null;
    Iterator<Election> iterator=elections.iterator();
    while (iterator.hasNext() && selectedElection==null) {
      Election election=iterator.next();
      if (election.getName().equals(selectedElectionName))
        selectedElection=election;
    }
  }
  
  private void tryLoadingElectionForPositions() {
    ElectionForPositionService.getInstance().setSelectedElection(selectedElection);
    electionForPositions=ElectionForPositionService.getInstance().getFoundEFPs();
  }
  
  private void tryLoadingPositions() {
    for (ElectionForPosition efp:electionForPositions) {
      Position p=new Position(efp.getPosition().getIdPosition(), "", "");
      PositionService.getInstance().setPositionById(p);
      p=PositionService.getInstance().getPositionById();
      efp.setPosition(p);
    }
  }

  boolean tryToUpdateCandidature() {
    List<Candidature> candidatures=assignPositionCandidateView.getCandidatures();
    for (Candidature candidature:candidatures) {
      CandidatureService.getInstance().setNewCandidature(candidature);
    }
    assignPositionCandidateView.dispose();
    return CandidatureService.getInstance().getCandidatureAdded();
  }
}