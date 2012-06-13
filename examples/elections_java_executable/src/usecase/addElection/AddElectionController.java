/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addElection;
import view.addElection.AddElectionView;
import javax.swing.JOptionPane;
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

  private boolean __autotransition309__()
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

  private boolean __autotransition310__()
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

  private boolean __autotransition311__()
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

  private boolean __autotransition312__()
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

  private boolean __autotransition313__()
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

  private boolean __autotransition314__()
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

  private boolean __autotransition315__()
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

  private boolean __autotransition316__()
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

  private boolean __autotransition317__()
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

  private boolean __autotransition318__()
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
        __autotransition309__();
        __autotransition310__();
        break;
      case CheckingExistingElection:
        ElectionService.getInstance().setElectionNameToSearch(electionName);
          electionFound=ElectionService.getInstance().getElectionFound();
        __autotransition311__();
        __autotransition312__();
        break;
      case AddingElection:
        tryToAddElection();
        __autotransition313__();
        __autotransition314__();
        break;
      case ElectionAdded:
        JOptionPane.showMessageDialog(null, "Election Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
          Controller.getInstance().start();
        __autotransition315__();
        break;
      case ElectionNotAdded:
        JOptionPane.showMessageDialog(null, "Adding Election Failed!", "Error!", JOptionPane.ERROR_MESSAGE); Controller.getInstance().start();
        __autotransition316__();
        break;
      case ElectionExists:
        JOptionPane.showMessageDialog(null, "Election Exists!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
          addElectionView.dispose();
        __autotransition317__();
        break;
      case ElectionNameEmpty:
        JOptionPane.showMessageDialog(null, "Election name cannot be empty!", "Error!", JOptionPane.ERROR_MESSAGE);
        break;
      case ClosingView:
        addElectionView.dispose();
        __autotransition318__();
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