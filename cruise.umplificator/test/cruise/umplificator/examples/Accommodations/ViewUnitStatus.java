/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 53 "Accommodations.ump"
// line 137 "Accommodations.ump"
public class ViewUnitStatus
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ViewUnitStatus Attributes
  private Date status_date;
  private String available_yn;

  //ViewUnitStatus Associations
  private Unit unit;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetStatus_date;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ViewUnitStatus(Date aStatus_date, String aAvailable_yn)
  {
    cachedHashCode = -1;
    canSetStatus_date = true;
    status_date = aStatus_date;
    available_yn = aAvailable_yn;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStatus_date(Date aStatus_date)
  {
    boolean wasSet = false;
    if (!canSetStatus_date) { return false; }
    status_date = aStatus_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailable_yn(String aAvailable_yn)
  {
    boolean wasSet = false;
    available_yn = aAvailable_yn;
    wasSet = true;
    return wasSet;
  }

  public Date getStatus_date()
  {
    return status_date;
  }

  public String getAvailable_yn()
  {
    return available_yn;
  }

  public Unit getUnit()
  {
    return unit;
  }

  public boolean hasUnit()
  {
    boolean has = unit != null;
    return has;
  }

  public boolean setUnit(Unit aUnit)
  {
    boolean wasSet = false;
    Unit existingUnit = unit;
    unit = aUnit;
    if (existingUnit != null && !existingUnit.equals(aUnit))
    {
      existingUnit.removeViewUnitStatus(this);
    }
    if (aUnit != null)
    {
      aUnit.addViewUnitStatus(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    ViewUnitStatus compareTo = (ViewUnitStatus)obj;
  
    if (status_date == null && compareTo.status_date != null)
    {
      return false;
    }
    else if (status_date != null && !status_date.equals(compareTo.status_date))
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
    if (status_date != null)
    {
      cachedHashCode = cachedHashCode * 23 + status_date.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetStatus_date = false;
    return cachedHashCode;
  }

  public void delete()
  {
    if (unit != null)
    {
      Unit placeholderUnit = unit;
      this.unit = null;
      placeholderUnit.removeViewUnitStatus(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "available_yn" + ":" + getAvailable_yn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "status_date" + "=" + (getStatus_date() != null ? !getStatus_date().equals(this)  ? getStatus_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "unit = "+(getUnit()!=null?Integer.toHexString(System.identityHashCode(getUnit())):"null")
     + outputString;
  }
}