/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 134 "AgentsCommunication.ump"
public class Message
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextSeqNum = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Message Attributes
  private String val;

  //Autounique Attributes
  private int seqNum;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetSeqNum;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Message(String aVal)
  {
    cachedHashCode = -1;
    canSetSeqNum = true;
    val = aVal;
    seqNum = nextSeqNum++;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVal(String aVal)
  {
    boolean wasSet = false;
    val = aVal;
    wasSet = true;
    return wasSet;
  }

  public String getVal()
  {
    return val;
  }

  public int getSeqNum()
  {
    return seqNum;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Message compareTo = (Message)obj;
  
    if (seqNum != compareTo.seqNum)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + seqNum;

    canSetSeqNum = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "seqNum" + ":" + getSeqNum()+ "," +
            "val" + ":" + getVal()+ "]"
     + outputString;
  }
}