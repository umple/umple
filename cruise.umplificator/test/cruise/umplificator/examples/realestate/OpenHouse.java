/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 49 "realestate.ump"
// line 109 "realestate.ump"
public class OpenHouse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenHouse Attributes
  private Date date;
  private Time startTime;
  private Time endTime;

  //OpenHouse Associations
  private PropertyForSale propertyForSale;
  private Agent agentInCharge;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OpenHouse(Date aDate, Time aStartTime, Time aEndTime, PropertyForSale aPropertyForSale)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddPropertyForSale = setPropertyForSale(aPropertyForSale);
    if (!didAddPropertyForSale)
    {
      throw new RuntimeException("Unable to create openHous due to propertyForSale");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public PropertyForSale getPropertyForSale()
  {
    return propertyForSale;
  }

  public Agent getAgentInCharge()
  {
    return agentInCharge;
  }

  public boolean hasAgentInCharge()
  {
    boolean has = agentInCharge != null;
    return has;
  }

  public boolean setPropertyForSale(PropertyForSale aPropertyForSale)
  {
    boolean wasSet = false;
    if (aPropertyForSale == null)
    {
      return wasSet;
    }

    PropertyForSale existingPropertyForSale = propertyForSale;
    propertyForSale = aPropertyForSale;
    if (existingPropertyForSale != null && !existingPropertyForSale.equals(aPropertyForSale))
    {
      existingPropertyForSale.removeOpenHous(this);
    }
    propertyForSale.addOpenHous(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setAgentInCharge(Agent aAgentInCharge)
  {
    boolean wasSet = false;
    Agent existingAgentInCharge = agentInCharge;
    agentInCharge = aAgentInCharge;
    if (existingAgentInCharge != null && !existingAgentInCharge.equals(aAgentInCharge))
    {
      existingAgentInCharge.removeOpenHous(this);
    }
    if (aAgentInCharge != null)
    {
      aAgentInCharge.addOpenHous(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PropertyForSale placeholderPropertyForSale = propertyForSale;
    this.propertyForSale = null;
    placeholderPropertyForSale.removeOpenHous(this);
    if (agentInCharge != null)
    {
      Agent placeholderAgentInCharge = agentInCharge;
      this.agentInCharge = null;
      placeholderAgentInCharge.removeOpenHous(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "propertyForSale = "+(getPropertyForSale()!=null?Integer.toHexString(System.identityHashCode(getPropertyForSale())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "agentInCharge = "+(getAgentInCharge()!=null?Integer.toHexString(System.identityHashCode(getAgentInCharge())):"null")
     + outputString;
  }
}