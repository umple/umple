/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 4 "DVD_Player.ump"
public class DVD_Player_UI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DVD_Player_UI State Machines
  enum DVD_Panel { Stopped, Running, Paused }
  private DVD_Panel dVD_Panel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DVD_Player_UI()
  {
    setDVD_Panel(DVD_Panel.Stopped);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getDVD_PanelFullName()
  {
    String answer = dVD_Panel.toString();
    return answer;
  }

  public DVD_Panel getDVD_Panel()
  {
    return dVD_Panel;
  }

  public boolean workOutTimer1()
  {
    boolean wasEventProcessed = false;
    
    DVD_Panel aDVD_Panel = dVD_Panel;
    switch (aDVD_Panel)
    {
      case Stopped:
        setDVD_Panel(DVD_Panel.Running);
        wasEventProcessed = true;
        break;
      case Running:
        setDVD_Panel(DVD_Panel.Paused);
        wasEventProcessed = true;
        break;
      case Paused:
        setDVD_Panel(DVD_Panel.Running);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean workOutTimer2()
  {
    boolean wasEventProcessed = false;
    
    DVD_Panel aDVD_Panel = dVD_Panel;
    switch (aDVD_Panel)
    {
      case Running:
        setDVD_Panel(DVD_Panel.Running);
        wasEventProcessed = true;
        break;
      case Paused:
        setDVD_Panel(DVD_Panel.Stopped);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean workOutTick()
  {
    boolean wasEventProcessed = false;
    
    DVD_Panel aDVD_Panel = dVD_Panel;
    switch (aDVD_Panel)
    {
      case Running:
        setDVD_Panel(DVD_Panel.Running);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setDVD_Panel(DVD_Panel aDVD_Panel)
  {
    dVD_Panel = aDVD_Panel;
  }

  public void delete()
  {}

}