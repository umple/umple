/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addElection;
import view.addElection.AddElectionView;
import shared.Result;
import service.ElectionService;
import shared.domain.Election;
import usecase.startup.Controller;

public class AddElectionController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static AddElectionController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddElectionController Attributes
  private AddElectionView addElectionView;
  private String electionName;
  private boolean electionFound;

  //AddElectionController State Machines
  enum ElectionAddingSteps { Initial, AddElectionViewShown, CheckingElectionName, CheckingExistingElection, AddingElection, ElectionAdded, ElectionNotAdded, ElectionExists, ElectionNameEmpty, ClosingView }
  private ElectionAddingSteps ElectionAddingSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AddElectionController()
  {
    electionName = null;
    electionFound = false;
    setElectionAddingSteps(ElectionAddingSteps.Initial);
  }

  public static AddElectionController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new AddElectionController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getElectionAddingStepsFullName()
  {
    String answer = ElectionAddingSteps.toString();
    return answer;
  }

  public ElectionAddingSteps getElectionAddingSteps()
  {
    return ElectionAddingSteps;
  }

  public boolean addElection()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case Initial:
        setElectionAddingSteps(ElectionAddingSteps.AddElectionViewShown);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case AddElectionViewShown:
        setElectionAddingSteps(ElectionAddingSteps.CheckingElectionName);
        wasEventProcessed = true;
        break;
      case ElectionNameEmpty:
        setElectionAddingSteps(ElectionAddingSteps.CheckingElectionName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case AddElectionViewShown:
        setElectionAddingSteps(ElectionAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case ElectionNameEmpty:
        setElectionAddingSteps(ElectionAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition14__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case CheckingElectionName:
        if (electionName.trim().isEmpty())
        {
          setElectionAddingSteps(ElectionAddingSteps.ElectionNameEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition15__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case CheckingElectionName:
        if (!electionName.trim().isEmpty())
        {
          setElectionAddingSteps(ElectionAddingSteps.CheckingExistingElection);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition16__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case CheckingExistingElection:
        if (!electionFound)
        {
          setElectionAddingSteps(ElectionAddingSteps.AddingElection);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition17__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case CheckingExistingElection:
        if (electionFound)
        {
          setElectionAddingSteps(ElectionAddingSteps.ElectionExists);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition18__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case AddingElection:
        if (ElectionService.getInstance().getElectionAdded())
        {
          setElectionAddingSteps(ElectionAddingSteps.ElectionAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition19__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case AddingElection:
        if (ElectionService.getInstance().getElectionAdded())
        {
          setElectionAddingSteps(ElectionAddingSteps.ElectionNotAdded);
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
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case ElectionAdded:
        setElectionAddingSteps(ElectionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition21__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case ElectionNotAdded:
        setElectionAddingSteps(ElectionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition22__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case ElectionExists:
        setElectionAddingSteps(ElectionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition23__()
  {
    boolean wasEventProcessed = false;
    
    ElectionAddingSteps aElectionAddingSteps = ElectionAddingSteps;
    switch (aElectionAddingSteps)
    {
      case ClosingView:
        setElectionAddingSteps(ElectionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setElectionAddingSteps(ElectionAddingSteps aElectionAddingSteps)
  {
    ElectionAddingSteps = aElectionAddingSteps;

    // entry actions and do activities
    switch(ElectionAddingSteps)
    {
      case AddElectionViewShown:
        showAddElectionView();
        break;
      case CheckingElectionName:
        electionName=addElectionView.getElectionName();
        __autotransition14__();
        __autotransition15__();
        break;
      case CheckingExistingElection:
        ElectionService.getInstance().setElectionNameToSearch(electionName);
          electionFound=ElectionService.getInstance().getElectionFound();
        __autotransition16__();
        __autotransition17__();
        break;
      case AddingElection:
        tryToAddElection();
        __autotransition18__();
        __autotransition19__();
        break;
      case ElectionAdded:
        Result.getInstance().setMessage("Election Added Successfully!");
          Controller.getInstance().start();
        __autotransition20__();
        break;
      case ElectionNotAdded:
        Result.getInstance().setMessage("Adding Election Failed!"); Controller.getInstance().start();
        __autotransition21__();
        break;
      case ElectionExists:
        Result.getInstance().setMessage("Election Exists!");
          Controller.getInstance().start();
          addElectionView.dispose();
        __autotransition22__();
        break;
      case ElectionNameEmpty:
        Result.getInstance().setMessage("Election name cannot be empty!");
        break;
      case ClosingView:
        addElectionView.dispose();
        __autotransition23__();
        break;
    }
  }

  public void delete()
  {}


  public void showAddElectionView(){
      addElectionView=new AddElectionView();
     addElectionView.setVisible(true);
  }


  public void tryToAddElection(){
      electionName=addElectionView.getElectionName();
    String electionDescription=addElectionView.getElectionDescription();
    Election election=new Election(-1, electionName, electionDescription, null);
    ElectionService.getInstance().setNewElection(election);
    addElectionView.dispose();
  }

}