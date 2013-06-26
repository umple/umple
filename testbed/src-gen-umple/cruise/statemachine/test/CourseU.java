/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.statemachine.test;

// line 179 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseU
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseU Attributes
  private int count;

  //CourseU State Machines
  enum Status { Off, On }
  private Status status;

  //CourseU Do Activity Threads
  Thread doActivityStatusOffThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseU(int aCount)
  {
    count = aCount;
    setStatus(Status.Off);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCount(int aCount)
  {
    boolean wasSet = false;
    count = aCount;
    wasSet = true;
    return wasSet;
  }

  public int getCount()
  {
    return count;
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

  public boolean flip()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Off:
        exitStatus();
        setStatus(Status.On);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case Off:
        if (doActivityStatusOffThread != null) { doActivityStatusOffThread.interrupt(); }
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Off:
        doActivityStatusOffThread = new DoActivityThread(this,"doActivityStatusOff");
        break;
    }
  }

  @umplesourcefile(line={186},file={"TestHarnessStateMachineJava.ump"},javaline={111},length={1})
  private void doActivityStatusOff()
  {
    try
    {
      incr();
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    CourseU controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseU aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityStatusOff".equals(doActivityMethodName))
      {
        controller.doActivityStatusOff();
      }
    }
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "count" + ":" + getCount()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={190},file={"TestHarnessStateMachineJava.ump"},javaline={157},length={5})
  @umplesourcefile(line={191},file={"TestHarnessStateMachineJava.ump"},javaline={158},length={4})
  public void incr() 
  { 
    count += 1;
  }

}