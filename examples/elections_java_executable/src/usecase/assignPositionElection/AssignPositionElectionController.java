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

  private boolean __autotransition1613__()
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

  private boolean __autotransition1614__()
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

  private boolean __autotransition1615__()
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

  private boolean __autotransition1616__()
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

  private boolean __autotransition1617__()
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

  private boolean __autotransition1618__()
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

  private boolean __autotransition1619__()
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

  private boolean __autotransition1620__()
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

  private boolean __autotransition1621__()
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

  private boolean __autotransition1622__()
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

  private boolean __autotransition1623__()
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
        __autotransition1613__();
        __autotransition1614__();
        break;
      case ProvidingPositionsList:
        positions=PositionService.getInstance().getPositions();
        __autotransition1615__();
        __autotransition1616__();
        break;
      case PositionsListProvided:
        showAddElectionForPositionView();
        break;
      case Updating:
        updated=tryToAddElectionForPosition();
        __autotransition1617__();
        __autotransition1618__();
        break;
      case Updated:
        JOptionPane.showMessageDialog(null, "Election for positions Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
          Controller.getInstance().start();
        __autotransition1619__();
        break;
      case NotUpdated:
        JOptionPane.showMessageDialog(null, "Adding election for positions Failed!");
          Controller.getInstance().start();
        __autotransition1620__();
        break;
      case ClosingView:
        assignPositionElectionView.dispose();
        __autotransition1621__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition1622__();
        break;
      case NoPositionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
          Controller.getInstance().start();
        __autotransition1623__();
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