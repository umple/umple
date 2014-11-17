/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.io.IOException;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.LinkedList;

/**
 * create client class to implement MySocket class
 */
// line 282 "TcpIpSimulation.ump"
public class Tcp_Client extends Thread
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tcp_Client Attributes
  private MySocket clientSocket;
  private boolean readyToStop;
  private Queue_Tcp q;
  private Receiver receive;
  private String host;
  private int port;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tcp_Client()
  {
    super();
    clientSocket = null;
    readyToStop = false;
    q = new Queue_Tcp();
    receive = new Receiver(q);
    host = "localhost";
    port = 999;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setClientSocket(MySocket aClientSocket)
  {
    boolean wasSet = false;
    clientSocket = aClientSocket;
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

  public boolean setHost(String aHost)
  {
    boolean wasSet = false;
    host = aHost;
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

  public MySocket getClientSocket()
  {
    return clientSocket;
  }

  public boolean getReadyToStop()
  {
    return readyToStop;
  }

  public Queue_Tcp getQ()
  {
    return q;
  }

  public Receiver getReceive()
  {
    return receive;
  }

  public String getHost()
  {
    return host;
  }

  public int getPort()
  {
    return port;
  }

  public void delete()
  {}

  // line 300 "TcpIpSimulation.ump"
   public void run(){
    //LinkedList messages= new LinkedList();
    //q=new Queue_Tcp();
    //receive=new Receiver(q);
    try
    {
      // connects client with the server
      clientSocket= new MySocket(getHost(), getPort());
      if(clientSocket != null)
      {clientSocket.connect();}
      while(!q.isEmptyMessage()){
        receive.start();
      }
      System.out.println("Client: Connected");
    } catch (Exception ex){
      try
      {
        //Close the socket
        if (clientSocket != null)
          clientSocket.close();
      }
      finally
      {
        clientSocket = null;
      }
      System.out.println("Client: Closed"); 
    }
    if(clientSocket == null){
      // closes the socket
      setReadyToStop(true);
      try
      {
        //Close the socket
        if (clientSocket != null)
        clientSocket.close();
      }
      finally
      {
        clientSocket = null;
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "readyToStop" + ":" + getReadyToStop()+ "," +
            "host" + ":" + getHost()+ "," +
            "port" + ":" + getPort()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "clientSocket" + "=" + (getClientSocket() != null ? !getClientSocket().equals(this)  ? getClientSocket().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "receive" + "=" + (getReceive() != null ? !getReceive().equals(this)  ? getReceive().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}