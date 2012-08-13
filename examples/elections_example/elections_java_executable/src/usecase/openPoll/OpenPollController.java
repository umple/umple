/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.openPoll;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Poll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import service.ElectionService;
import service.PollService;
import usecase.startup.Controller;

public class OpenPollController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static OpenPollController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenPollController Attributes
  private Connection theConnection;
  private Election selectedElection;
  private Poll selectedPoll;
  private boolean pollOpened;
  private int option;
  private List<Election> elections;
  private List<Poll> polls;

  //OpenPollController State Machines
  enum PollOpeningSteps { Initial, ProvidingElectionsList, ElectionsListProvided, ProvidingPollsList, PollsListProvided, OpeningPoll, PollOpened, Failed, Done, NoPollsFound, NoElectionsFound }
  private PollOpeningSteps PollOpeningSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private OpenPollController()
  {
    pollOpened = false;
    option = JOptionPane.NO_OPTION;
    setPollOpeningSteps(PollOpeningSteps.Initial);
  }

  public static OpenPollController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new OpenPollController();
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

  public boolean setSelectedPoll(Poll aSelectedPoll)
  {
    boolean wasSet = false;
    selectedPoll = aSelectedPoll;
    wasSet = true;
    return wasSet;
  }

  public boolean setPollOpened(boolean aPollOpened)
  {
    boolean wasSet = false;
    pollOpened = aPollOpened;
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

  public Poll getSelectedPoll()
  {
    return selectedPoll;
  }

  public boolean getPollOpened()
  {
    return pollOpened;
  }

  public int getOption()
  {
    return option;
  }

  public String getPollOpeningStepsFullName()
  {
    String answer = PollOpeningSteps.toString();
    return answer;
  }

  public PollOpeningSteps getPollOpeningSteps()
  {
    return PollOpeningSteps;
  }

  public boolean openPoll()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case Initial:
        setPollOpeningSteps(PollOpeningSteps.ProvidingElectionsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ProvidingElectionsList:
        if (!elections.isEmpty())
        {
          setPollOpeningSteps(PollOpeningSteps.ElectionsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition2__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ProvidingElectionsList:
        if (elections.isEmpty())
        {
          setPollOpeningSteps(PollOpeningSteps.NoElectionsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition3__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ElectionsListProvided:
        setPollOpeningSteps(PollOpeningSteps.ProvidingPollsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition4__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ProvidingPollsList:
        if (!polls.isEmpty())
        {
          setPollOpeningSteps(PollOpeningSteps.PollsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition5__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ProvidingPollsList:
        if (polls.isEmpty())
        {
          setPollOpeningSteps(PollOpeningSteps.NoPollsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition6__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case PollsListProvided:
        setPollOpeningSteps(PollOpeningSteps.OpeningPoll);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition7__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case OpeningPoll:
        if (pollOpened)
        {
          setPollOpeningSteps(PollOpeningSteps.PollOpened);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition8__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case OpeningPoll:
        if (!pollOpened)
        {
          setPollOpeningSteps(PollOpeningSteps.Failed);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition9__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case Failed:
        if (option==JOptionPane.YES_OPTION)
        {
          setPollOpeningSteps(PollOpeningSteps.ElectionsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition10__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case Failed:
        if (option==JOptionPane.NO_OPTION)
        {
          setPollOpeningSteps(PollOpeningSteps.Done);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition11__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case Done:
        setPollOpeningSteps(PollOpeningSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition12__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case NoPollsFound:
        setPollOpeningSteps(PollOpeningSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition13__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case NoElectionsFound:
        setPollOpeningSteps(PollOpeningSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setPollOpeningSteps(PollOpeningSteps aPollOpeningSteps)
  {
    PollOpeningSteps = aPollOpeningSteps;

    // entry actions and do activities
    switch(PollOpeningSteps)
    {
      case ProvidingElectionsList:
        ElectionService.getInstance().getAllElections();
          elections=ElectionService.getInstance().getElections();
        __autotransition1__();
        __autotransition2__();
        break;
      case ElectionsListProvided:
        selectAnElection();
        __autotransition3__();
        break;
      case ProvidingPollsList:
        PollService.getInstance().setSelectedElection(selectedElection);
               polls=PollService.getInstance().getPolls();
        __autotransition4__();
        __autotransition5__();
        break;
      case PollsListProvided:
        selectAPoll();
               PollService.getInstance().setSelectedPoll(selectedPoll);
        __autotransition6__();
        break;
      case OpeningPoll:
        PollService.getInstance().openPoll();pollOpened=PollService.getInstance().getPollOpenned();
        __autotransition7__();
        __autotransition8__();
        break;
      case PollOpened:
        JOptionPane.showMessageDialog(null, "Poll is now open");
                   Controller.getInstance().start();
        break;
      case Failed:
        option=JOptionPane.showConfirmDialog(null, "Poll Opening Failed! Retry?", "Error!", JOptionPane.YES_NO_OPTION);
        __autotransition9__();
        __autotransition10__();
        break;
      case Done:
        Controller.getInstance().start();
        __autotransition11__();
        break;
      case NoPollsFound:
        JOptionPane.showMessageDialog(null, "No polls found, add a poll first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition12__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition13__();
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


  public void selectAPoll(){
      String[] pollNames=new String[polls.size()];
    int i=0;
    for (Poll poll:polls)
      pollNames[i++]=poll.getName();
    Object selectedPollName = JOptionPane.showInputDialog(null, "Select a poll", "List of Polls", JOptionPane.QUESTION_MESSAGE, null, pollNames, pollNames[0]);
    
    selectedPoll=null;
    Iterator<Poll> iterator=polls.iterator();
    while (iterator.hasNext() && selectedPoll==null) {
      Poll poll=iterator.next();
      if (poll.getName().equals(selectedPollName))
        selectedPoll=poll;
    }
  }

}