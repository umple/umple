/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.LinkedList;
import java.util.Queue;
import java.lang.Thread;
import java.io.*;
import java.lang.InterruptedException;
import java.io.IOException;

// line 6 "TcpIpSimulation.ump"
public class Tcp
{

  //------------------------
  // STATIC VARIABLES
  //------------------------


  /**
   * Tcp flags
   */
  public static final String SYN = "SYN";
  public static final String ACK = "ACK";
  public static final String FIN = "FIN";
  public static final String RST = "RST";
  public static final String SYNACK = "SYNAck";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tcp Attributes
  private Queue_Tcp q;
  private BufferedReader in;
  private String sentence;

  //Tcp State Machines
  enum Connection { Closed, Listen, SYN_Received, SYN_Sent, Established, Close_Wait, Last_ACK, FIN_Wait_1, FIN_Wait_2, Closing, Timed_Wait }
  private Connection connection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tcp()
  {
    q = new Queue_Tcp();
    in = null;
    sentence = null;
    setConnection(Connection.Closed);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQ(Queue_Tcp aQ)
  {
    boolean wasSet = false;
    q = aQ;
    wasSet = true;
    return wasSet;
  }

  public boolean setIn(BufferedReader aIn)
  {
    boolean wasSet = false;
    in = aIn;
    wasSet = true;
    return wasSet;
  }

  public boolean setSentence(String aSentence)
  {
    boolean wasSet = false;
    sentence = aSentence;
    wasSet = true;
    return wasSet;
  }

  /**
   * Queues for adding and removing Tcp flags
   * LinkedList messages= new LinkedList();
   */
  public Queue_Tcp getQ()
  {
    return q;
  }

  public BufferedReader getIn()
  {
    return in;
  }

  public String getSentence()
  {
    return sentence;
  }

  public String getConnectionFullName()
  {
    String answer = connection.toString();
    return answer;
  }

  public Connection getConnection()
  {
    return connection;
  }

  public boolean passiveOpen()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Closed:
        setConnection(Connection.Listen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean activeOpen()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Closed:
        // line 33 "TcpIpSimulation.ump"
        sendSyn();
        setConnection(Connection.SYN_Sent);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean syn()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Listen:
        // line 37 "TcpIpSimulation.ump"
        sendSynAck();
        setConnection(Connection.SYN_Received);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean close()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Listen:
        setConnection(Connection.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ack()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case SYN_Received:
        setConnection(Connection.Established);
        wasEventProcessed = true;
        break;
      case Last_ACK:
        setConnection(Connection.Closed);
        wasEventProcessed = true;
        break;
      case FIN_Wait_1:
        setConnection(Connection.FIN_Wait_2);
        wasEventProcessed = true;
        break;
      case Closing:
        setConnection(Connection.Timed_Wait);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean synAck()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case SYN_Sent:
        // line 50 "TcpIpSimulation.ump"
        sendAck();
        setConnection(Connection.Established);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean fin()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Established:
        // line 56 "TcpIpSimulation.ump"
        sendAck();
        setConnection(Connection.Close_Wait);
        wasEventProcessed = true;
        break;
      case FIN_Wait_1:
        // line 70 "TcpIpSimulation.ump"
        sendAck();
        setConnection(Connection.Closing);
        wasEventProcessed = true;
        break;
      case FIN_Wait_2:
        // line 74 "TcpIpSimulation.ump"
        sendAck();
        setConnection(Connection.Timed_Wait);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean activeClose()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Established:
        // line 57 "TcpIpSimulation.ump"
        sendFin();
        setConnection(Connection.FIN_Wait_1);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean data()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Established:
        // line 58 "TcpIpSimulation.ump"
        sendData();
        setConnection(Connection.Established);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean passiveClose()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Close_Wait:
        // line 62 "TcpIpSimulation.ump"
        sendFin();
        setConnection(Connection.Last_ACK);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean finAck()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case FIN_Wait_1:
        // line 71 "TcpIpSimulation.ump"
        sendAck();
        setConnection(Connection.Timed_Wait);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timeOut()
  {
    boolean wasEventProcessed = false;
    
    Connection aConnection = connection;
    switch (aConnection)
    {
      case Timed_Wait:
        setConnection(Connection.Closed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setConnection(Connection aConnection)
  {
    connection = aConnection;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "sentence" + ":" + getSentence()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "in" + "=" + (getIn() != null ? !getIn().equals(this)  ? getIn().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 85 TcpIpSimulation.ump
  public synchronized void sendSyn () 
  {
    try{
      q.putMessage(SYN);
    }catch (InterruptedException e) {}
  }

// line 91 TcpIpSimulation.ump
  public synchronized void sendSynAck () 
  {
    try{
       q.putMessage(SYNACK);
     }catch (InterruptedException e) {}
  }

// line 97 TcpIpSimulation.ump
  public synchronized void sendAck () 
  {
    try{
      q.putMessage(ACK);
    }catch (InterruptedException e) {}
  }

// line 104 TcpIpSimulation.ump
  public synchronized void sendData () 
  {
    in=new BufferedReader(new InputStreamReader(System.in));
     String sn;
     try{
       sn=in.readLine();
       try{
         q.putMessage(sn);
       }catch (InterruptedException e) {}
     } catch (IOException ioe){}
  }

// line 115 TcpIpSimulation.ump
  public synchronized void sendFin () 
  {
    try{
        q.putMessage(FIN);
      }catch (InterruptedException e) {}
  }

  
}