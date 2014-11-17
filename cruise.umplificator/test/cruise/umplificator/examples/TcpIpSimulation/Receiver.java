/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.lang.Thread;
import java.lang.InterruptedException;

// line 192 "TcpIpSimulation.ump"
public class Receiver extends Thread
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Receiver Attributes
  private Queue_Tcp q;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Receiver(Queue_Tcp aQ)
  {
    super();
    q = aQ;
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

  public Queue_Tcp getQ()
  {
    return q;
  }

  public void delete()
  {}

  // line 200 "TcpIpSimulation.ump"
   public void run(){
    try { 
      while ( !q.isEmptyMessage() ) {
        String message = q.getMessage();
        System.out.println("Got message: " + message);
        sleep( 2000 ); 
      }
    }catch( InterruptedException e ) { }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "q" + "=" + (getQ() != null ? !getQ().equals(this)  ? getQ().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}