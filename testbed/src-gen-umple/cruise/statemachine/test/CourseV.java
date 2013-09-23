/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.statemachine.test;

// line 198 "../../../../src/TestHarnessStateMachineJava.ump"
public class CourseV
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CourseV Attributes
  private int count;

  //CourseV State Machines
  enum Status { Off, On }
  private Status status;

  //CourseV Do Activity Threads
  Thread doActivityStatusOffThread = null;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CourseV()
  {
    count = 0;
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

  private boolean __autotransition5__()
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

  @umplesourcefile(line={204},file={"TestHarnessStateMachineJava.ump"},javaline={111},length={1})
  private void doActivityStatusOff()
  {
    try
    {
      doX();
      Thread.sleep(1);
      __autotransition5__();
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    CourseV controller;
    String doActivityMethodName;
    
    public DoActivityThread(CourseV aController,String aDoActivityMethodName)
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

  @umplesourcefile(line={209},file={"TestHarnessStateMachineJava.ump"},javaline={146},length={3})
   public void doX(){
    count += 1;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "count" + ":" + getCount()+ "]"
     + outputString;
  }
}