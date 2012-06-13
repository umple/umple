/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.assignCandidature;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Candidate;
import shared.domain.Position;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import service.ElectionService;
import service.PositionService;
import service.CandidateService;
import service.ElectionForPositionService;
import usecase.startup.Controller;

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

  //AssignCandidatureController State Machines
  enum CandidateAssignationSteps { Initial, ProvidingElectionsList, ElectionsListProvided, NoElectionsFound, Done }
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

  private boolean __autotransition1917__()
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

  private boolean __autotransition1918__()
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

  private boolean __autotransition1919__()
  {
    boolean wasEventProcessed = false;
    
    CandidateAssignationSteps aCandidateAssignationSteps = CandidateAssignationSteps;
    switch (aCandidateAssignationSteps)
    {
      case ElectionsListProvided:
        setCandidateAssignationSteps(CandidateAssignationSteps.Done);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1920__()
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

  private boolean __autotransition1921__()
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
        __autotransition1917__();
        __autotransition1918__();
        break;
      case ElectionsListProvided:
        selectAnElection();
        __autotransition1919__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition1920__();
        break;
      case Done:
        Controller.getInstance().start();
        __autotransition1921__();
        break;
    }
  }

  public void delete()
  {}


  public void selectAnElection(){
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

}