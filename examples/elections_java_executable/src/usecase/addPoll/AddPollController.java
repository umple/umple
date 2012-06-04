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

  //AddPollController State Machines
  enum PollAddingSteps { Initial, ProvidingElectionsList, ElectionsListProvided, AddingPoll, PollAdded, PollNotAdded, ClosingView }
  private PollAddingSteps PollAddingSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AddPollController()
  {
    pollAdded = false;
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

  private boolean __autotransition426__()
  {
    boolean wasEventProcessed = false;
    
    PollAddingSteps aPollAddingSteps = PollAddingSteps;
    switch (aPollAddingSteps)
    {
      case ProvidingElectionsList:
        setPollAddingSteps(PollAddingSteps.ElectionsListProvided);
        wasEventProcessed = true;
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
        setPollAddingSteps(PollAddingSteps.AddingPoll);
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
    }

    return wasEventProcessed;
  }

  private boolean __autotransition427__()
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

  private boolean __autotransition428__()
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

  private boolean __autotransition429__()
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

  private boolean __autotransition430__()
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

  private boolean __autotransition431__()
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

  private void setPollAddingSteps(PollAddingSteps aPollAddingSteps)
  {
    PollAddingSteps = aPollAddingSteps;

    // entry actions and do activities
    switch(PollAddingSteps)
    {
      case ProvidingElectionsList:
        ElectionService.getInstance().getAllElections();elections=ElectionService.getInstance().getElections();
        __autotransition426__();
        break;
      case ElectionsListProvided:
        showAddPollView();
        break;
      case AddingPoll:
        tryToAddPoll();pollAdded=PollService.getInstance().getPollAdded();
        __autotransition427__();
        __autotransition428__();
        break;
      case PollAdded:
        JOptionPane.showMessageDialog(null, "Poll Added Successfully!"); Controller.getInstance().start();
        __autotransition429__();
        break;
      case PollNotAdded:
        JOptionPane.showMessageDialog(null, "Adding Poll Failed!"); Controller.getInstance().start();
        __autotransition430__();
        break;
      case ClosingView:
        addPollView.dispose();
        __autotransition431__();
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
      String pollName=addPollView.getPollName();
		String pollDescription=addPollView.getPollDescription();
		Election selectedElection=addPollView.getSelectedElection();
		Poll poll=new Poll(-1, pollName, pollDescription, selectedElection);
		PollService.getInstance().setNewPoll(poll);
		addPollView.dispose();
  }

}