/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.*;

// line 158 "TcpIpSimulation.ump"
public class Queue_Tcp
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Queue_Tcp Attributes
  private LinkedList<String> messages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Queue_Tcp()
  {
    messages = new LinkedList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMessages(LinkedList<String> aMessages)
  {
    boolean wasSet = false;
    messages = aMessages;
    wasSet = true;
    return wasSet;
  }

  /**
   * LinkedList messages;
   */
  public LinkedList<String> getMessages()
  {
    return messages;
  }

  public void delete()
  {}

  // line 183 "TcpIpSimulation.ump"
   public Boolean isEmptyMessage(){
    if(messages.size() == 0)
      return true;
    return false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "messages" + "=" + (getMessages() != null ? !getMessages().equals(this)  ? getMessages().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 166 TcpIpSimulation.ump
  public synchronized void putMessage (String var) throws InterruptedException 
  {
    messages.add(var);
   notify();
   //String msg = (String)messages.getFirst();
   String msg = messages.element();
   System.out.println("send message: " +msg);
  }

// line 175 TcpIpSimulation.ump
  public synchronized String getMessage () throws InterruptedException 
  {
    while ( messages.size() == 0 ) 
      wait();
    String message =messages.remove();
    return (message);
  }

  
}