/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addPoll;
import shared.Result;
import view.addPoll.AddPollView;
import javax.swing.JOptionPane;
import service.ElectionService;
import service.PollService;
import shared.domain.Election;
import shared.domain.Poll;
import java.util.List;
import usecase.startup.Controller;

public class AddPollController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static AddPollController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddPollController Attributes
  private AddPollView addPollView;
  private List<Election> elections;
  private boolean pollAdded;
  private String pollName;
  private Election selectedElection;
  private Poll newPoll;
  private boolean pollFound;

  //AddPollController State Machines
  enum PollAddingSteps { Initial, ProvidingElectionsList, ElectionsListProvided, CheckingPollName, CheckingExistingPoll, PollNameEmpty, PollExists, AddingPoll, PollAdded, PollNotAdded, ClosingView, NoElectionsFound }
  private PollAddingSteps PollAddingSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AddPollController()
  {
    pollAdded = false;
    pollName = null;
    pollFound = false;
    setPollAddingSteps(PollAddingSteps.Initial);
  }

  public static AddPollController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new AddPollController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getPollAddingStepsFullName()
  {
    String answer = PollAddingSteps.toString();
    return answer;
  }

  public PollAddingSteps getPollAddingSteps()
  {
    return PollAddingSteps;
  }

  public boolean addPoll()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case Initial:
        setPollAddingSteps(PollAddingSteps.ProvidingElectionsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition24__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ProvidingElectionsList:
        if (!elections.isEmpty())
        {
          setPollAddingSteps(PollAddingSteps.ElectionsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition25__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ProvidingElectionsList:
        if (elections.isEmpty())
        {
          setPollAddingSteps(PollAddingSteps.NoElectionsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  public boolean addButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ElectionsListProvided:
        setPollAddingSteps(PollAddingSteps.CheckingPollName);
        wasEventProcessed = true;
        break;
      case PollNameEmpty:
        setPollAddingSteps(PollAddingSteps.CheckingPollName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ElectionsListProvided:
        setPollAddingSteps(PollAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case PollNameEmpty:
        setPollAddingSteps(PollAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition26__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case CheckingPollName:
        if (pollName.trim().isEmpty())
        {
          setPollAddingSteps(PollAddingSteps.PollNameEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition27__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case CheckingPollName:
        if (!pollName.trim().isEmpty())
        {
          setPollAddingSteps(PollAddingSteps.CheckingExistingPoll);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition28__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case CheckingExistingPoll:
        if (!pollFound)
        {
          setPollAddingSteps(PollAddingSteps.AddingPoll);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition29__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case CheckingExistingPoll:
        if (pollFound)
        {
          setPollAddingSteps(PollAddingSteps.PollExists);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition30__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case PollExists:
        setPollAddingSteps(PollAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition31__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case AddingPoll:
        if (pollAdded)
        {
          setPollAddingSteps(PollAddingSteps.PollAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition32__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case AddingPoll:
        if (!pollAdded)
        {
          setPollAddingSteps(PollAddingSteps.PollNotAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition33__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case PollAdded:
        setPollAddingSteps(PollAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition34__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case PollNotAdded:
        setPollAddingSteps(PollAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition35__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ClosingView:
        setPollAddingSteps(PollAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition36__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case NoElectionsFound:
        setPollAddingSteps(PollAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setPollAddingSteps(PollAddingSteps aPollAddingSteps)
  {
    PollAddingSteps = aPollAddingSteps;

    // entry actions and do activities
    switch(PollAddingSteps)
    {
      case ProvidingElectionsList:
        ElectionService.getInstance().getAllElections();
          elections=ElectionService.getInstance().getElections();
        __autotransition24__();
        __autotransition25__();
        break;
      case ElectionsListProvided:
        showAddPollView();
        break;
      case CheckingPollName:
        pollName=addPollView.getPollName();
        __autotransition26__();
        __autotransition27__();
        break;
      case CheckingExistingPoll:
        selectedElection=addPollView.getSelectedElection();
          newPoll=new Poll(-1, -1, pollName, "", selectedElection);
          PollService.getInstance().setPollToSearch(newPoll);
          pollFound=PollService.getInstance().getPollFound();
        __autotransition28__();
        __autotransition29__();
        break;
      case PollNameEmpty:
        Result.getInstance().setMessage("Poll name cannot be empty!");
        break;
      case PollExists:
        Result.getInstance().setMessage("Poll Exists!");
          Controller.getInstance().start();
          addPollView.dispose();
        __autotransition30__();
        break;
      case AddingPoll:
        tryToAddPoll();pollAdded=PollService.getInstance().getPollAdded();
        __autotransition31__();
        __autotransition32__();
        break;
      case PollAdded:
        Result.getInstance().setMessage("Poll Added Successfully!");
          Controller.getInstance().start();
        __autotransition33__();
        break;
      case PollNotAdded:
        Result.getInstance().setMessage("Adding Poll Failed!");
          Controller.getInstance().start();
        __autotransition34__();
        break;
      case ClosingView:
        addPollView.dispose();
        __autotransition35__();
        break;
      case NoElectionsFound:
        Result.getInstance().setMessage("No elections found, add an election first!");
          Controller.getInstance().start();
        __autotransition36__();
        break;
    }
  }

  public void delete()
  {}


  public void showAddPollView(){
      addPollView=new AddPollView(elections);
     addPollView.setVisible(true);
  }


  public void tryToAddPoll(){
      String pollDescription=addPollView.getPollDescription();
    newPoll.setDescription(pollDescription);
    PollService.getInstance().setNewPoll(newPoll);
    addPollView.dispose();
  }

}