/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.startup;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import usecase.addPoll.AddPollController;
import usecase.openPoll.OpenPollController;
import usecase.addElection.AddElectionController;
import usecase.addPosition.AddPositionController;
import usecase.assignPositionElection.AssignPositionElectionController;
import usecase.registerCandidate.RegisterCandidateController;
import usecase.registerVoter.RegisterVoterController;
import usecase.assignCandidature.AssignCandidatureController;
import view.main.MainView;

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
  enum Status { Initial, ProvidingMainMenu, PollOpening, ElectionAdding, PollAdding, PositionAdding, AssigningPositionElection, CandidateRegisteration, VoterRegisteration, CandidatureDeclaration, Closign, Closing }
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
      case PositionAdding:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case AssigningPositionElection:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case CandidateRegisteration:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case VoterRegisteration:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
      case CandidatureDeclaration:
        setStatus(Status.ProvidingMainMenu);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean openPoll()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.PollOpening);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addElection()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.ElectionAdding);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addPoll()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.PollAdding);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean addPosition()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.PositionAdding);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean assignPositionElection()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.AssigningPositionElection);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean registerCandidate()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.CandidateRegisteration);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean registerVoter()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.VoterRegisteration);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean declareCandidature()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.CandidatureDeclaration);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean quit()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case ProvidingMainMenu:
        setStatus(Status.Closing);
        wasEventProcessed = true;
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
        break;
      case PollOpening:
        MainView.getInstance().setVisible(false);
      OpenPollController.getInstance().openPoll();
        break;
      case ElectionAdding:
        MainView.getInstance().setVisible(false);
      AddElectionController.getInstance().addElection();
        break;
      case PollAdding:
        MainView.getInstance().setVisible(false);
    AddPollController.getInstance().addPoll();
        break;
      case PositionAdding:
        MainView.getInstance().setVisible(false);
    AddPositionController.getInstance().addPosition();
        break;
      case AssigningPositionElection:
        MainView.getInstance().setVisible(false);
    AssignPositionElectionController.getInstance().assignPositionElection();
        break;
      case CandidateRegisteration:
        MainView.getInstance().setVisible(false);
    RegisterCandidateController.getInstance().registerCandidate();
        break;
      case VoterRegisteration:
        MainView.getInstance().setVisible(false);
    RegisterVoterController.getInstance().registerVoter();
        break;
      case CandidatureDeclaration:
        MainView.getInstance().setVisible(false);
    AssignCandidatureController.getInstance().assignCandidate();
        break;
      case Closign:
        MainView.getInstance().setVisible(false);
      MainView.getInstance().dispose();
        break;
    }
  }

  public void delete()
  {}


  public void showMainMenu(){
      MainView.getInstance().setVisible(true);
  }

}