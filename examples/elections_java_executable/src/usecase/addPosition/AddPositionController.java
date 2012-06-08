/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.addPosition;
import view.addPosition.AddPositionView;
import javax.swing.JOptionPane;
import service.ElectionService;
import service.PositionService;
import service.ElectionForPositionService;
import shared.domain.Election;
import shared.domain.Position;
import shared.domain.ElectionForPosition;
import java.util.List;
import usecase.startup.Controller;

public class AddPositionController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static AddPositionController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddPositionController Attributes
  private AddPositionView addPositionView;
  private boolean positionAdded;
  private boolean efpAdded;
  private String positionName;
  private Position newPosition;
  private boolean positionFound;
  private ElectionForPosition efp;

  //AddPositionController State Machines
  enum PositionAddingSteps { Initial, PreparingView, CheckingPositionName, CheckingExistingPosition, PositionNameEmpty, PositionExists, AddingPosition, PositionAdded, PositionNotAdded, ClosingView, NoElectionsFound, CheckingpositionName }
  private PositionAddingSteps PositionAddingSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private AddPositionController()
  {
    positionAdded = false;
    efpAdded = false;
    positionName = null;
    positionFound = false;
    setPositionAddingSteps(PositionAddingSteps.Initial);
  }

  public static AddPositionController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new AddPositionController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getPositionAddingStepsFullName()
  {
    String answer = PositionAddingSteps.toString();
    return answer;
  }

  public PositionAddingSteps getPositionAddingSteps()
  {
    return PositionAddingSteps;
  }

  public boolean addPosition()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case Initial:
        setPositionAddingSteps(PositionAddingSteps.PreparingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addButtonClicked()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case PreparingView:
        setPositionAddingSteps(PositionAddingSteps.CheckingPositionName);
        wasEventProcessed = true;
        break;
      case PositionNameEmpty:
        setPositionAddingSteps(PositionAddingSteps.CheckingpositionName);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean closeView()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case PreparingView:
        setPositionAddingSteps(PositionAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
      case PositionNameEmpty:
        setPositionAddingSteps(PositionAddingSteps.ClosingView);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1721__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case CheckingPositionName:
        if (positionName.trim().isEmpty())
        {
          setPositionAddingSteps(PositionAddingSteps.PositionNameEmpty);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1722__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case CheckingPositionName:
        if (!positionName.trim().isEmpty())
        {
          setPositionAddingSteps(PositionAddingSteps.CheckingExistingPosition);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1723__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case CheckingExistingPosition:
        if (!positionFound)
        {
          setPositionAddingSteps(PositionAddingSteps.AddingPosition);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1724__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case CheckingExistingPosition:
        if (positionFound)
        {
          setPositionAddingSteps(PositionAddingSteps.PositionExists);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1725__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case PositionExists:
        setPositionAddingSteps(PositionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1726__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case AddingPosition:
        if (positionAdded)
        {
          setPositionAddingSteps(PositionAddingSteps.PositionAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1727__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case AddingPosition:
        if (!positionAdded)
        {
          setPositionAddingSteps(PositionAddingSteps.PositionNotAdded);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1728__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case PositionAdded:
        setPositionAddingSteps(PositionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1729__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case PositionNotAdded:
        setPositionAddingSteps(PositionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1730__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case ClosingView:
        setPositionAddingSteps(PositionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition1731__()
  {
    boolean wasEventProcessed = false;
    
    PositionAddingSteps aPositionAddingSteps = PositionAddingSteps;
    switch (aPositionAddingSteps)
    {
      case NoElectionsFound:
        setPositionAddingSteps(PositionAddingSteps.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setPositionAddingSteps(PositionAddingSteps aPositionAddingSteps)
  {
    PositionAddingSteps = aPositionAddingSteps;

    // entry actions and do activities
    switch(PositionAddingSteps)
    {
      case PreparingView:
        showAddPositionView();
        break;
      case CheckingPositionName:
        positionName=addPositionView.getPositionName();
        __autotransition1721__();
        __autotransition1722__();
        break;
      case CheckingExistingPosition:
        positionFound=positionExists();
        __autotransition1723__();
        __autotransition1724__();
        break;
      case PositionNameEmpty:
        JOptionPane.showMessageDialog(null, "position name cannot be empty!");
        break;
      case PositionExists:
        JOptionPane.showMessageDialog(null, "position Exists!", "Error!", JOptionPane.ERROR_MESSAGE);
					Controller.getInstance().start();
					addPositionView.dispose();
        __autotransition1725__();
        break;
      case AddingPosition:
        tryToAddPosition();
					positionAdded=PositionService.getInstance().getPositionAdded();
					//efpAdded=ElectionForPositionService.getInstance().getElectionForPositionAdded();
        __autotransition1726__();
        __autotransition1727__();
        break;
      case PositionAdded:
        JOptionPane.showMessageDialog(null, "Position Added Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					Controller.getInstance().start();
        __autotransition1728__();
        break;
      case PositionNotAdded:
        JOptionPane.showMessageDialog(null, "Adding Position Failed!");
					Controller.getInstance().start();
        __autotransition1729__();
        break;
      case ClosingView:
        addPositionView.dispose();
        __autotransition1730__();
        break;
      case NoElectionsFound:
        JOptionPane.showMessageDialog(null, "No elections found, add an election first!", "Error!", JOptionPane.ERROR_MESSAGE);
					Controller.getInstance().start();
        __autotransition1731__();
        break;
    }
  }

  public void delete()
  {}


  public void showAddPositionView(){
      addPositionView=new AddPositionView();
 		addPositionView.setVisible(true);
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private boolean positionExists() {
    //selectedElection=addPositionView.getSelectedElection();
    newPosition=new Position(-1, positionName, "");
  	//efp=new ElectionForPosition(-1, selectedElection, newPosition);
    PositionService.getInstance().setPositionToSearch(newPosition);
    return PositionService.getInstance().getPositionFound();
  }
	
  void tryToAddPosition() {
    String positionDescription=addPositionView.getPositionDescription();
    newPosition.setDescription(positionDescription);
    PositionService.getInstance().setNewPosition(newPosition);
    //ElectionForPositionService.getInstance().setNewElectionForPosition(efp);
    addPositionView.dispose();
  }
  
  	
  void tryToAddElectionForPosition() {
   /* String positionDescription=addPositionView.getpositionDescription();
    newPosition.setDescription(positionDescription);
    PositionService.getInstance().setNewPosition(newPosition);
    ElectionForPositionService.getInstance().setNewElectionForPosition(efp);
    addPositionView.dispose();*/
  }
}