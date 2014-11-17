/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 250 "TcpIpSimulation.ump"
public class MyServerSocket
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MyServerSocket Attributes
  private int port;
  private Tcp tcp;
  private MySocket clientsocket;
  private MyServerSocket serverSocket;
  private Queue_1 q;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MyServerSocket(int aPort)
  {
    port = aPort;
    tcp = new Tcp();
    clientsocket = null;
    serverSocket = null;
    q = new Queue_1();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPort(int aPort)
  {
    boolean wasSet = false;
    port = aPort;
    wasSet = true;
    return wasSet;
  }

  public boolean setTcp(Tcp aTcp)
  {
    boolean wasSet = false;
    tcp = aTcp;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientsocket(MySocket aClientsocket)
  {
    boolean wasSet = false;
    clientsocket = aClientsocket;
    wasSet = true;
    return wasSet;
  }

  public boolean setServerSocket(MyServerSocket aServerSocket)
  {
    boolean wasSet = false;
    serverSocket = aServerSocket;
    wasSet = true;
    return wasSet;
  }

  public boolean setQ(Queue_1 aQ)
  {
    boolean wasSet = false;
    q = aQ;
    wasSet = true;
    return wasSet;
  }

  public int getPort()
  {
    return port;
  }

  public Tcp getTcp()
  {
    return tcp;
  }

  public MySocket getClientsocket()
  {
    return clientsocket;
  }

  public MyServerSocket getServerSocket()
  {
    return serverSocket;
  }

  /**
   * use a semaphore to synchronize sending signals between the threads
   */
  public Queue_1 getQ()
  {
    return q;
  }

  public void delete()
  {}


  /**
   * The MyServerSocket accept method's job is to start a new MySocket 
   * which happens at  L251. However, it seems to me that it should not have 
   * its own Tcp, it should send passiveOpen to the tcp of MySocket.
   */
  // line 265 "TcpIpSimulation.ump"
   public void accept(){
    //Listens for a connection to be made to this socket and accepts it
     tcp.passiveOpen();
     //if(serverSocket!= null){
       clientsocket=new MySocket("localHost",999);
    // }
     try{
       tcp.syn();
       q.acquire_semC();
     }catch(Exception e){}
     q.release_semC();
     tcp.ack();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "port" + ":" + getPort()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tcp" + "=" + (getTcp() != null ? !getTcp().equals(this)  ? getTcp().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "clientsocket" + "=" + (getClientsocket() != null ? !getClientsocket().equals(this)  ? getClientsocket().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "serverSocket" + "=" + (getServerSocket() != null ? !getServerSocket().equals(this)  ? getServerSocket().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}