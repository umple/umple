/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addPoll;
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

  private boolean __autotransition319__()
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

  private boolean __autotransition320__()
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

  private boolean __autotransition321__()
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

  private boolean __autotransition322__()
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

  private boolean __autotransition323__()
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

  private boolean __autotransition324__()
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

  private boolean __autotransition325__()
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

  private boolean __autotransition326__()
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

  private boolean __autotransition327__()
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

  private boolean __autotransition328__()
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

  private boolean __autotransition329__()
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

  private boolean __autotransition330__()
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

  private boolean __autotransition331__()
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
        __autotransition319__();
        __autotransition320__();
        break;
      case ElectionsListProvided:
        showAddPollView();
        break;
      case CheckingPollName:
        pollName=addPollView.getPollName();
        __autotransition321__();
        __autotransition322__();
        break;
      case CheckingExistingPoll:
        selectedElection=addPollView.getSelectedElection();
          newPoll=new Poll(-1, -1, pollName, "", selectedElection);
          PollService.getInstance().setPollToSearch(newPoll);
          pollFound=PollService.getInstance().getPollFound();
        __autotransition323__();
        __autotransition324__();
        break;
      case PollNameEmpty:
        JOptionPane.showMessageDialog(null, "Poll name cannot be empty!");
        break;
      case PollExists:
        JOptionPane.showMessageDialog(null, "Poll Exists!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
          addPollView.dispose();
        __autotransition325__();
        break;
      case AddingPoll:
        tryToAddPoll();pollAdded=PollService.getInstance().getPollAdded();
        __autotransition326__();
        __autotransition327__();
        break;
      case PollAdded:
        JOptionPane.showMessageDialog(null, "Poll Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
          Controller.getInstance().start();
        __autotransition328__();
        break;
      case PollNotAdded:
        JOptionPane.showMessageDialog(null, "Adding Poll Failed!");
          Controller.getInstance().start();
        __autotransition329__();
        break;
      case ClosingView:
        addPollView.dispose();
        __autotransition330__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition331__();
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