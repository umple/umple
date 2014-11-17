/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.io.IOException;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.LinkedList;

/**
 * Creat Server class to implement the MyServerSocket class
 */
// line 347 "TcpIpSimulation.ump"
public class Tcp_Server extends Thread
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tcp_Server Attributes
  private MyServerSocket serverSocket;
  private MySocket clientSocket;
  private boolean isListening;
  private Queue_Tcp q;
  private Receiver receive;
  private int port;
  private boolean readyToStop;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tcp_Server()
  {
    super();
    serverSocket = null;
    clientSocket = null;
    isListening = false;
    q = new Queue_Tcp();
    receive = new Receiver(q);
    port = 999;
    readyToStop = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServerSocket(MyServerSocket aServerSocket)
  {
    boolean wasSet = false;
    serverSocket = aServerSocket;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientSocket(MySocket aClientSocket)
  {
    boolean wasSet = false;
    clientSocket = aClientSocket;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsListening(boolean aIsListening)
  {
    boolean wasSet = false;
    isListening = aIsListening;
    wasSet = true;
    return wasSet;
  }

  public boolean setQ(Queue_Tcp aQ)
  {
    boolean wasSet = false;
    q = aQ;
    wasSet = true;
    return wasSet;
  }

  public boolean setReceive(Receiver aReceive)
  {
    boolean wasSet = false;
    receive = aReceive;
    wasSet = true;
    return wasSet;
  }

  public boolean setPort(int aPort)
  {
    boolean wasSet = false;
    port = aPort;
    wasSet = true;
    return wasSet;
  }

  public boolean setReadyToStop(boolean aReadyToStop)
  {
    boolean wasSet = false;
    readyToStop = aReadyToStop;
    wasSet = true;
    return wasSet;
  }

  public MyServerSocket getServerSocket()
  {
    return serverSocket;
  }

  public MySocket getClientSocket()
  {
    return clientSocket;
  }

  public boolean getIsListening()
  {
    return isListening;
  }

  public Queue_Tcp getQ()
  {
    return q;
  }

  public Receiver getReceive()
  {
    return receive;
  }

  public int getPort()
  {
    return port;
  }

  public boolean getReadyToStop()
  {
    return readyToStop;
  }

  public boolean isIsListening()
  {
    return isListening;
  }

  public boolean isReadyToStop()
  {
    return readyToStop;
  }

  public void delete()
  {}

  // line 364 "TcpIpSimulation.ump"
   public void run(){
    //LinkedList messages= new LinkedList();
    //q=new Queue_Tcp();
    //receive=new Receiver(q);
    //Begins waiting for a new client.
    if (!getIsListening())
    {
      if (serverSocket == null)
      {
        serverSocket = new MyServerSocket(getPort());
      }
    }
    
    //listens to the client and accept the connection
    setReadyToStop(false); 
    serverStarted();
    try
    {
      // waits for a new client connection, accepts it
      while(!getReadyToStop())
      {
        try
        {
          receive=new Receiver(new Queue_Tcp());
          if(serverSocket != null){
            serverSocket.accept();}
          while(!q.isEmptyMessage()){
            receive.start();
          }
          
          //Sends a message to client connected to the server
          if (clientSocket == null)
            System.out.println("socket does not exist");
           try
           {
             
            clientSocket.send();
           } catch (Exception ex) {}
        }catch (Exception ex){}
      } 
    } catch (Exception ex){}
    finally
    {
      setReadyToStop(true);
      serverStopped();
      //Closes all connection to the server 
      try
      {
        // Close the sSocket and the connection with client
        if (serverSocket == null)
        {
          stopListening();
        }else if (serverSocket != null || clientSocket != null)
          try
          {
            clientSocket.close();
          } catch(Exception ex) {}
      } catch(Exception ex) {}
      finally
      {
        clientSocket = null;
        serverSocket = null;
      }
    }
  }

  // line 431 "TcpIpSimulation.ump"
   protected void serverStarted(){
    System.out.println("Server: Started");
  }

  // line 435 "TcpIpSimulation.ump"
   protected void serverStopped(){
    System.out.println("Server: Stopped");
  }


  /**
   * Causes the server to stop accepting new connections
   */
  // line 440 "TcpIpSimulation.ump"
   public void stopListening(){
    setReadyToStop(true);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isListening" + ":" + getIsListening()+ "," +
            "port" + ":" + getPort()+ "," +
            "readyToStop" + ":" + getReadyToStop()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "serverSocket" + "=" + (getServerSocket() != null ? !getServerSocket().equals(this)  ? getServerSocket().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clientSocket" + "=" + (getClientSocket() != null ? !getClientSocket().equals(this)  ? getClientSocket().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "receive" + "=" + (getReceive() != null ? !getReceive().equals(this)  ? getReceive().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}