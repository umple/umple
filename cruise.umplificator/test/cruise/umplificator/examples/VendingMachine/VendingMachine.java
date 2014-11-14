/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 5 "VendingMachine.ump"
public class VendingMachine
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VendingMachine State Machines
  enum ControlUnit { ReceivingMoney, DeliveringItem, ReturningMoney, Waiting }
  private ControlUnit controlUnit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VendingMachine()
  {
    setControlUnit(ControlUnit.ReceivingMoney);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getControlUnitFullName()
  {
    String answer = controlUnit.toString();
    return answer;
  }

  public ControlUnit getControlUnit()
  {
    return controlUnit;
  }

  public boolean pressSelection()
  {
    boolean wasEventProcessed = false;
    
    ControlUnit aControlUnit = controlUnit;
    switch (aControlUnit)
    {
      case ReceivingMoney:
        setControlUnit(ControlUnit.ReceivingMoney);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean enterCoin()
  {
    boolean wasEventProcessed = false;
    
    ControlUnit aControlUnit = controlUnit;
    switch (aControlUnit)
    {
      case ReceivingMoney:
        setControlUnit(ControlUnit.ReceivingMoney);
        wasEventProcessed = true;
        break;
      case Waiting:
        setControlUnit(ControlUnit.ReceivingMoney);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean deliveryComplete()
  {
    boolean wasEventProcessed = false;
    
    ControlUnit aControlUnit = controlUnit;
    switch (aControlUnit)
    {
      case DeliveringItem:
        setControlUnit(ControlUnit.Waiting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean retunringComplete()
  {
    boolean wasEventProcessed = false;
    
    ControlUnit aControlUnit = controlUnit;
    switch (aControlUnit)
    {
      case ReturningMoney:
        setControlUnit(ControlUnit.Waiting);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setControlUnit(ControlUnit aControlUnit)
  {
    controlUnit = aControlUnit;
  }

  public void delete()
  {}

}