/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 211 "TcpIpSimulation.ump"
public class MySocket
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MySocket Attributes
  private String host;
  private int port;
  private Tcp tcp;
  private Queue_1 q;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MySocket(String aHost, int aPort)
  {
    host = aHost;
    port = aPort;
    tcp = new Tcp();
    q = new Queue_1();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean setTcp(Tcp aTcp)
  {
    boolean wasSet = false;
    tcp = aTcp;
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

  public String getHost()
  {
    return host;
  }

  public int getPort()
  {
    return port;
  }

  /**
   * MySocket needs a constructor to create the tcp
   */
  public Tcp getTcp()
  {
    return tcp;
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

  // line 222 "TcpIpSimulation.ump"
   public void connect(){
    //Connects client to the server
    try{
      tcp.activeOpen();
      q.acquire_semS(); 
    }catch(Exception e){}
    q.release_semS(); 
    tcp.synAck();
  }


  /**
   * void receive(){
   * //receive data from the server
   * tcp.Data_R();
   * }
   */
  // line 237 "TcpIpSimulation.ump"
   public void send(){
    //send data to client
     tcp.data();
  }

  // line 242 "TcpIpSimulation.ump"
   public void close(){
    //Closes the socket 
    tcp.activeClose();
    //Closes the serverSocket
    tcp.passiveClose();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "host" + ":" + getHost()+ "," +
            "port" + ":" + getPort()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tcp" + "=" + (getTcp() != null ? !getTcp().equals(this)  ? getTcp().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}