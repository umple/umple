/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 91 "AfghanRainDesign.ump"
// line 141 "AfghanRainDesign.ump"
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
    cachedHashCode = -1;
    canSetId = true;
    id = aId;
    next_bulletin_due_date = aNext_bulletin_due_date;
    issued_date = aIssued_date;
    comments = aComments;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    if (!canSetId) { return false; }
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setNext_bulletin_due_date(Date aNext_bulletin_due_date)
  {
    boolean wasSet = false;
    next_bulletin_due_date = aNext_bulletin_due_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setIssued_date(Date aIssued_date)
  {
    boolean wasSet = false;
    issued_date = aIssued_date;
    wasSet = true;
    return wasSet;
  }

  public boolean setComments(String aComments)
  {
    boolean wasSet = false;
    comments = aComments;
    wasSet = true;
    return wasSet;
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

  public boolean hasAgriculturalResearchStation()
  {
    boolean has = agriculturalResearchStation != null;
    return has;
  }

  public boolean setAgriculturalResearchStation(AgriculturalResearchStation aNewAgriculturalResearchStation)
  {
    boolean wasSet = false;
    agriculturalResearchStation = aNewAgriculturalResearchStation;
    wasSet = true;
    return wasSet;
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "comments" + ":" + getComments()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "next_bulletin_due_date" + "=" + (getNext_bulletin_due_date() != null ? !getNext_bulletin_due_date().equals(this)  ? getNext_bulletin_due_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "issued_date" + "=" + (getIssued_date() != null ? !getIssued_date().equals(this)  ? getIssued_date().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "agriculturalResearchStation = "+(getAgriculturalResearchStation()!=null?Integer.toHexString(System.identityHashCode(getAgriculturalResearchStation())):"null")
     + outputString;
  }
}