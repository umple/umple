/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;
import java.sql.Date;

public class Bulletin
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bulletin Attributes
  private int id;
  private Date next_bulletin_due_date;
  private Date issued_date;
  private String comments;

  //Bulletin Associations
  private AgriculturalResearchStation agriculturalResearchStation;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bulletin(int aId, Date aNext_bulletin_due_date, Date aIssued_date, String aComments)
  {
    id = aId;
    next_bulletin_due_date = aNext_bulletin_due_date;
    issued_date = aIssued_date;
    comments = aComments;
    cachedHashCode = -1;
    canSetId = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    if (!canSetId)
    {
      return false;
    }
    id = aId;
    return true;
  }

  public boolean setNext_bulletin_due_date(Date aNext_bulletin_due_date)
  {
    next_bulletin_due_date = aNext_bulletin_due_date;
    return true;
  }

  public boolean setIssued_date(Date aIssued_date)
  {
    issued_date = aIssued_date;
    return true;
  }

  public boolean setComments(String aComments)
  {
    comments = aComments;
    return true;
  }

  public int getId()
  {
    return id;
  }

  public Date getNext_bulletin_due_date()
  {
    return next_bulletin_due_date;
  }

  public Date getIssued_date()
  {
    return issued_date;
  }

  public String getComments()
  {
    return comments;
  }

  public AgriculturalResearchStation getAgriculturalResearchStation()
  {
    return agriculturalResearchStation;
  }

  public boolean setAgriculturalResearchStation(AgriculturalResearchStation newAgriculturalResearchStation)
  {
    agriculturalResearchStation = newAgriculturalResearchStation;
    return true;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Bulletin compareTo = (Bulletin)obj;
  
    if (id != compareTo.id)
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
    cachedHashCode = cachedHashCode * 23 + id;

    canSetId = false;
    return cachedHashCode;
  }

  public void delete()
  {
    agriculturalResearchStation = null;
  }

}