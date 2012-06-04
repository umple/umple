/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.startup;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import usecase.addPoll.AddPollController;
import usecase.openPoll.OpenPollController;
import usecase.addElection.AddElectionController;

public class Controller
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Controller theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Controller Attributes
  private int option;
  private Object mainMenuOption;

  //Controller State Machines
  enum Status { Initial, ProvidingMainMenu, PollOpening, ElectionAdding, PollAdding }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Controller()
  {
    option = JOptionPane.NO_OPTION;
    mainMenuOption = "Quit";
    setStatus(Status.Initial);
  }

  public static Controller getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Controller();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean start()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Initial:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case PollOpening:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case ElectionAdding:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case PollAdding:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition277__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        if (mainMenuOption!=null && mainMenuOption.equals("Open Poll"))
        {
          setStatus(Status.PollOpening);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition278__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        if (mainMenuOption!=null && mainMenuOption.equals("Add Election"))
        {
          setStatus(Status.ElectionAdding);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition279__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        if (mainMenuOption!=null && mainMenuOption.equals("Add Poll"))
        {
          setStatus(Status.PollAdding);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case ProvidingMainMenu:
        showMainMenu();
        __autotransition277__();
        __autotransition278__();
        __autotransition279__();
        break;
      case PollOpening:
        OpenPollController.getInstance().openPoll();
        break;
      case ElectionAdding:
        AddElectionController.getInstance().addElection();
        break;
      case PollAdding:
        AddPollController.getInstance().addPoll();
        break;
    }
  }

  public void delete()
  {}


  public void showMainMenu(){
      String[] selectionValues={"Open Poll", "Add Election", "Add Poll", "Quit"};
		String defaultSelection = "Open Poll";
		mainMenuOption = JOptionPane.showInputDialog(null, "Select a task", "Main Menu", JOptionPane.QUESTION_MESSAGE, null, selectionValues, defaultSelection);
  }

}