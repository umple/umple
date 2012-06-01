/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package usecase.startup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import usecase.openPoll.OpenPollController;
import usecase.addElection.AddElectionController;

public class Controller
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Controller Attributes
  private Connection theConnection;
  private String server;
  private String username;
  private String password;
  private boolean isConnected;
  private int option;
  private Object mainMenuOption;

  //Controller State Machines
  enum Status { Connecting, Connected, Failed, PollOpening, ElectionAdding }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Controller(String aServer, String aUsername, String aPassword)
  {
    theConnection = null;
    server = aServer;
    username = aUsername;
    password = aPassword;
    isConnected = false;
    option = JOptionPane.NO_OPTION;
    mainMenuOption = "Quit";
    setStatus(Status.Connecting);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTheConnection(Connection aTheConnection)
  {
    boolean wasSet = false;
    theConnection = aTheConnection;
    wasSet = true;
    return wasSet;
  }

  public boolean setServer(String aServer)
  {
    boolean wasSet = false;
    server = aServer;
    wasSet = true;
    return wasSet;
  }

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsConnected(boolean aIsConnected)
  {
    boolean wasSet = false;
    isConnected = aIsConnected;
    wasSet = true;
    return wasSet;
  }

  public boolean setOption(int aOption)
  {
    boolean wasSet = false;
    option = aOption;
    wasSet = true;
    return wasSet;
  }

  public boolean setMainMenuOption(Object aMainMenuOption)
  {
    boolean wasSet = false;
    mainMenuOption = aMainMenuOption;
    wasSet = true;
    return wasSet;
  }

  public Connection getTheConnection()
  {
    return theConnection;
  }

  public String getServer()
  {
    return server;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public boolean getIsConnected()
  {
    return isConnected;
  }

  public int getOption()
  {
    return option;
  }

  public Object getMainMenuOption()
  {
    return mainMenuOption;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  private boolean __autotransition211__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Connecting:
        if (isConnected)
        {
          setStatus(Status.Connected);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition212__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Connecting:
        if (!isConnected)
        {
          setStatus(Status.Failed);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition213__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Connected:
        if (mainMenuOption.equals("Open Poll"))
        {
          setStatus(Status.PollOpening);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition214__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Connected:
        if (mainMenuOption.equals("Add Election"))
        {
          setStatus(Status.ElectionAdding);
          wasEventProcessed = true;
          break;
        }
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition215__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Failed:
        if (option==JOptionPane.YES_OPTION)
        {
          setStatus(Status.Connecting);
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
      case Connecting:
        tryToConnect();
        __autotransition211__();
        __autotransition212__();
        break;
      case Connected:
        showMainMenu();
        __autotransition213__();
        __autotransition214__();
        break;
      case Failed:
        option=JOptionPane.showConfirmDialog(null, "Connection Failed! Retry?", "Error!", JOptionPane.YES_NO_OPTION);
        __autotransition215__();
        break;
      case PollOpening:
        OpenPollController.getInstance().setTheConnection(theConnection);OpenPollController.getInstance().openPoll();
        break;
      case ElectionAdding:
        /*AddElectionController.getInstance().setTheConnection(theConnection);*/AddElectionController.getInstance().addElection();
        break;
    }
  }

  public void delete()
  {}


  public void tryToConnect(){
      try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			theConnection = DriverManager.getConnection(server, username, password);
			
			isConnected=true;;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			isConnected=false;
		}
  }


  public void showMainMenu(){
      String[] selectionValues={"Open Poll", "Add Election", "Quit"};
		String defaultSelection = "Open Poll";
		mainMenuOption = JOptionPane.showInputDialog(null, "Select a task", "Main Menu", JOptionPane.QUESTION_MESSAGE, null, selectionValues, defaultSelection);
  }

}