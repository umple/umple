/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;

/**
 * Queue_1 class that have acquire and release methods used to send signals between the threads
 */
// line 125 "TcpIpSimulation.ump"
public class Queue_1
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Queue_1 Attributes
  private Semaphore semC;
  private Semaphore semS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Queue_1()
  {
    semC = new Semaphore(0);
    semS = new Semaphore(1);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSemC(Semaphore aSemC)
  {
    boolean wasSet = false;
    semC = aSemC;
    wasSet = true;
    return wasSet;
  }

  public boolean setSemS(Semaphore aSemS)
  {
    boolean wasSet = false;
    semS = aSemS;
    wasSet = true;
    return wasSet;
  }

  public Semaphore getSemC()
  {
    return semC;
  }

  public Semaphore getSemS()
  {
    return semS;
  }

  public void delete()
  {}

  // line 133 "TcpIpSimulation.ump"
   public void acquire_semC(){
    try {
      semC.acquire();
    } catch (InterruptedException e) {
      System.out.println("InterruptedException caught");
    }
  }

  // line 141 "TcpIpSimulation.ump"
   public void release_semC(){
    semC.release();
  }

  // line 145 "TcpIpSimulation.ump"
   public void acquire_semS(){
    try {
      semS.acquire();
    } catch (InterruptedException e) {
      System.out.println("InterruptedException caught");
    }
  }

  // line 153 "TcpIpSimulation.ump"
   public void release_semS(){
    semS.release();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "semC" + "=" + (getSemC() != null ? !getSemC().equals(this)  ? getSemC().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "semS" + "=" + (getSemS() != null ? !getSemS().equals(this)  ? getSemS().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}