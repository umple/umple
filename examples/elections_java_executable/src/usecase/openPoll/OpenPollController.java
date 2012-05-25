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

  //OpenPollController State Machines
  enum PollOpeningSteps { Initial, ElectionsListProvided, PollsListProvided, OpeningPoll, PollOpened, Failed }
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
        setPollOpeningSteps(PollOpeningSteps.ElectionsListProvided);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition17__()
  {
    boolean wasEventProcessed = false;
    
    PollOpeningSteps aPollOpeningSteps = PollOpeningSteps;
    switch (aPollOpeningSteps)
    {
      case ElectionsListProvided:
        setPollOpeningSteps(PollOpeningSteps.PollsListProvided);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition18__()
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

  private boolean __autotransition19__()
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

  private boolean __autotransition20__()
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

  private boolean __autotransition21__()
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

  private void setPollOpeningSteps(PollOpeningSteps aPollOpeningSteps)
  {
    PollOpeningSteps = aPollOpeningSteps;

    // entry actions and do activities
    switch(PollOpeningSteps)
    {
      case ElectionsListProvided:
        selectAnElection();
        __autotransition17__();
        break;
      case PollsListProvided:
        selectAPoll();
        __autotransition18__();
        break;
      case OpeningPoll:
        pollOpened=PollService.getInstance().openPoll(theConnection, selectedPoll);
        __autotransition19__();
        __autotransition20__();
        break;
      case PollOpened:
        JOptionPane.showMessageDialog(null, "Poll is now open");
        break;
      case Failed:
        option=JOptionPane.showConfirmDialog(null, "Poll Opening Failed! Retry?", "Error!", JOptionPane.YES_NO_OPTION);
        __autotransition21__();
        break;
    }
  }

  public void delete()
  {}


  public void selectAnElection(){
      List<Election> elections=ElectionService.getInstance().getAllElections(theConnection);
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
		
		//electionSelected();
  }


  public void selectAPoll(){
      List<Poll> polls=PollService.getInstance().getElectionPolls(theConnection, selectedElection);
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
		
		//pollSelected();
  }

}