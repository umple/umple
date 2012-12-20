/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.assignPositionElection;
import view.assignPositionElection.AssignPositionElectionView;
import javax.swing.JOptionPane;
import service.ElectionService;
import service.PositionService;
import service.ElectionForPositionService;
import shared.domain.Election;
import shared.domain.Position;
import shared.domain.ElectionForPosition;
import java.util.List;
import usecase.startup.Controller;

public class AssignPositionElectionController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static AssignPositionElectionController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssignPositionElectionController Attributes
  private AssignPositionElectionView assignPositionElectionView;
  private List<Election> elections;
  private List<Position> positions;
  private boolean updated;

  //AssignPositionElectionController State Machines
  enum AssigningPositionElectionSteps { Initial, ProvidingElectionsList, ProvidingPositionsList, PositionsListProvided, Updating, Updated, NotUpdated, ClosingView, NoElectionsFound, NoPositionsFound }
  private AssigningPositionElectionSteps AssigningPositionElectionSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AssignPositionElectionController()
  {
    updated = false;
    setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
  }

  public static AssignPositionElectionController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new AssignPositionElectionController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getAssigningPositionElectionStepsFullName()
  {
    String answer = AssigningPositionElectionSteps.toString();
    return answer;
  }

  public AssigningPositionElectionSteps getAssigningPositionElectionSteps()
  {
    return AssigningPositionElectionSteps;
  }

  public boolean assignPositionElection()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case Initial:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.ProvidingElectionsList);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition47__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case ProvidingElectionsList:
        if (!elections.isEmpty())
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.ProvidingPositionsList);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition48__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case ProvidingElectionsList:
        if (elections.isEmpty())
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.NoElectionsFound);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition49__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case ProvidingPositionsList:
        if (!positions.isEmpty())
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.PositionsListProvided);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition50__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case ProvidingPositionsList:
        if (positions.isEmpty())
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.NoPositionsFound);
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
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case PositionsListProvided:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Updating);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case PositionsListProvided:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition51__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case Updating:
        if (updated)
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Updated);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition52__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case Updating:
        if (!updated)
        {
          setAssigningPositionElectionSteps(AssigningPositionElectionSteps.NotUpdated);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition53__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case Updated:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition54__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case NotUpdated:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition55__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case ClosingView:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition56__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case NoElectionsFound:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition57__()
  {
    boolean wasEventProcessed = false;
    
    AssigningPositionElectionSteps aAssigningPositionElectionSteps = AssigningPositionElectionSteps;
    switch (aAssigningPositionElectionSteps)
    {
      case NoPositionsFound:
        setAssigningPositionElectionSteps(AssigningPositionElectionSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setAssigningPositionElectionSteps(AssigningPositionElectionSteps aAssigningPositionElectionSteps)
  {
    AssigningPositionElectionSteps = aAssigningPositionElectionSteps;

    // entry actions and do activities
    switch(AssigningPositionElectionSteps)
    {
      case ProvidingElectionsList:
        ElectionService.getInstance().getAllElections();
          elections=ElectionService.getInstance().getElections();
        __autotransition47__();
        __autotransition48__();
        break;
      case ProvidingPositionsList:
        positions=PositionService.getInstance().getPositions();
        __autotransition49__();
        __autotransition50__();
        break;
      case PositionsListProvided:
        showAddElectionForPositionView();
        break;
      case Updating:
        updated=tryToAddElectionForPosition();
        __autotransition51__();
        __autotransition52__();
        break;
      case Updated:
        JOptionPane.showMessageDialog(null, "Election for positions Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
          Controller.getInstance().start();
        __autotransition53__();
        break;
      case NotUpdated:
        JOptionPane.showMessageDialog(null, "Adding election for positions Failed!");
          Controller.getInstance().start();
        __autotransition54__();
        break;
      case ClosingView:
        assignPositionElectionView.dispose();
        __autotransition55__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition56__();
        break;
      case NoPositionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition57__();
        break;
    }
  }

  public void delete()
  {}


  public void showAddElectionForPositionView(){
      assignPositionElectionView=new AssignPositionElectionView(elections, positions);
     assignPositionElectionView.setVisible(true);
  }


  public boolean tryToAddElectionForPosition(){
      List<ElectionForPosition> efps=assignPositionElectionView.getElectionForPositions();
    for (ElectionForPosition efp:efps) {
      ElectionForPositionService.getInstance().setNewElectionForPosition(efp);
    }
    assignPositionElectionView.dispose();
    return ElectionForPositionService.getInstance().getElectionForPositionAdded();
  }

}