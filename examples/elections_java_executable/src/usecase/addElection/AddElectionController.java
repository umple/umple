/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addElection;
import view.addElection.AddElectionView;
import javax.swing.JOptionPane;
import service.ElectionService;
import shared.domain.Election;

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

  //AddElectionController State Machines
  enum ElectionAddingSteps { Initial, AddElectionViewShown, AddingElection }
  private ElectionAddingSteps ElectionAddingSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AddElectionController()
  {
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
        setElectionAddingSteps(ElectionAddingSteps.AddingElection);
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
      case AddingElection:
        tryToAddElection();
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
      String electionName=addElectionView.getElectionName();
		String electionDescription=addElectionView.getElectionDescription();
		Election election=new Election(-1, electionName, electionDescription);
		ElectionService.getInstance().setNewElection(election);
		addElectionView.dispose();
  }

}