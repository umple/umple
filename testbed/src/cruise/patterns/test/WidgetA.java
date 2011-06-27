/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.patterns.test;
import java.sql.Date;

public class WidgetA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetA Attributes
  private String id;
  private int intId;
  private double doubleId;
  private boolean boolId;
  private Date dateId;
  private WidgetB widgetId;
  private String ignore;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;
  private boolean canSetIntId;
  private boolean canSetDoubleId;
  private boolean canSetBoolId;
  private boolean canSetDateId;
  private boolean canSetWidgetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WidgetA(String aId, int aIntId, double aDoubleId, boolean aBoolId, Date aDateId, WidgetB aWidgetId, String aIgnore)
  {
    id = aId;
    intId = aIntId;
    doubleId = aDoubleId;
    boolId = aBoolId;
    dateId = aDateId;
    widgetId = aWidgetId;
    ignore = aIgnore;
    cachedHashCode = -1;
    canSetId = true;
    canSetIntId = true;
    canSetDoubleId = true;
    canSetBoolId = true;
    canSetDateId = true;
    canSetWidgetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setIntId(int aIntId)
  {
    boolean wasSet = false;
    if (!canSetIntId) { return false; }
    intId = aIntId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDoubleId(double aDoubleId)
  {
    boolean wasSet = false;
    if (!canSetDoubleId) { return false; }
    doubleId = aDoubleId;
    wasSet = true;
    return wasSet;
  }

  public boolean setBoolId(boolean aBoolId)
  {
    boolean wasSet = false;
    if (!canSetBoolId) { return false; }
    boolId = aBoolId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateId(Date aDateId)
  {
    boolean wasSet = false;
    if (!canSetDateId) { return false; }
    dateId = aDateId;
    wasSet = true;
    return wasSet;
  }

  public boolean setWidgetId(WidgetB aWidgetId)
  {
    boolean wasSet = false;
    if (!canSetWidgetId) { return false; }
    widgetId = aWidgetId;
    wasSet = true;
    return wasSet;
  }

  public boolean setIgnore(String aIgnore)
  {
    boolean wasSet = false;
    ignore = aIgnore;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public int getIntId()
  {
    return intId;
  }

  public double getDoubleId()
  {
    return doubleId;
  }

  public boolean getBoolId()
  {
    return boolId;
  }

  public Date getDateId()
  {
    return dateId;
  }

  public WidgetB getWidgetId()
  {
    return widgetId;
  }

  public String getIgnore()
  {
    return ignore;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    WidgetA compareTo = (WidgetA)obj;
  
    if (id == null && compareTo.id != null)
    {
      return false;
    }
    else if (id != null && !id.equals(compareTo.id))
    {
      return false;
    }

    if (intId != compareTo.intId)
    {
      return false;
    }

    if (doubleId != compareTo.doubleId)
    {
      return false;
    }

    if (boolId != compareTo.boolId)
    {
      return false;
    }

    if (dateId == null && compareTo.dateId != null)
    {
      return false;
    }
    else if (dateId != null && !dateId.equals(compareTo.dateId))
    {
      return false;
    }

    if (widgetId == null && compareTo.widgetId != null)
    {
      return false;
    }
    else if (widgetId != null && !widgetId.equals(compareTo.widgetId))
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
    if (id != null)
    {
      cachedHashCode = cachedHashCode * 23 + id.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    cachedHashCode = cachedHashCode * 23 + intId;

    cachedHashCode = cachedHashCode * 23 + (new Double(doubleId)).hashCode();

    cachedHashCode = cachedHashCode * 23 + (boolId ? 1 : 0);

    if (dateId != null)
    {
      cachedHashCode = cachedHashCode * 23 + dateId.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (widgetId != null)
    {
      cachedHashCode = cachedHashCode * 23 + widgetId.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetId = false;
    canSetIntId = false;
    canSetDoubleId = false;
    canSetBoolId = false;
    canSetDateId = false;
    canSetWidgetId = false;
    return cachedHashCode;
  }

  public void delete()
  {}

}