/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package usecase.startup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

  //Controller State Machines
  enum Status { Initial, Connecting, Connected, Failed, Closed }
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
    setStatus(Status.Initial);
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

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean connect()
  {
    boolean wasEventProcessed = false;

    switch (status)
    {
      case Initial:
        setStatus(Status.Connecting);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean connected()
  {
    boolean wasEventProcessed = false;

    switch (status)
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

  public boolean notConnected()
  {
    boolean wasEventProcessed = false;

    switch (status)
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

  public boolean retry()
  {
    boolean wasEventProcessed = false;

    switch (status)
    {
      case Failed:
        setStatus(Status.Initial);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean cancel()
  {
    boolean wasEventProcessed = false;

    switch (status)
    {
      case Failed:
        setStatus(Status.Closed);
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
      case Initial:
        new DoActivityThread(this,"doActivityStatusInitial");
        break;
      case Connecting:
        isConnected=tryToConnect();
        new DoActivityThread(this,"doActivityStatusConnecting");
        break;
      case Connected:
        System.out.println("Connected");
        break;
      case Failed:
        System.out.println("Failed");
        break;
    }
  }

  private void doActivityStatusInitial() throws InterruptedException
  {
    connect();
  }

  private void doActivityStatusConnecting() throws InterruptedException
  {
    connected();
      	  	notConnected();
  }

  private static class DoActivityThread extends Thread
  {
    Controller controller;
    String doActivityMethodName;
    
    public DoActivityThread(Controller aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      try
      {
        if ("doActivityStatusInitial".equals(doActivityMethodName))
        {
          controller.doActivityStatusInitial();
        }
        else if ("doActivityStatusConnecting".equals(doActivityMethodName))
        {
          controller.doActivityStatusConnecting();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void delete()
  {}


  public boolean tryToConnect(){
      try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			theConnection = DriverManager.getConnection(server, username, password);
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			return false;
		} finally {
			try {
				if(theConnection != null)
					theConnection.close();
			} catch(SQLException e) {
				System.err.println("Exception: " + e.getMessage());
				return false;
			}
		}
		
		return true;
  }

}