/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

// line 93 "Decisions.ump"
// line 174 "Decisions.ump"
public class Annotation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Annotation Attributes
  private String text;
  private Date dateMade;

  //Annotation Associations
  private Person madeByUser;
  private DecisionMakingBody madeByBody;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Annotation(String aText, Date aDateMade)
  {
    text = aText;
    dateMade = aDateMade;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateMade(Date aDateMade)
  {
    boolean wasSet = false;
    dateMade = aDateMade;
    wasSet = true;
    return wasSet;
  }

  public String getText()
  {
    return text;
  }

  public Date getDateMade()
  {
    return dateMade;
  }

  public Person getMadeByUser()
  {
    return madeByUser;
  }

  public boolean hasMadeByUser()
  {
    boolean has = madeByUser != null;
    return has;
  }

  public DecisionMakingBody getMadeByBody()
  {
    return madeByBody;
  }

  public boolean hasMadeByBody()
  {
    boolean has = madeByBody != null;
    return has;
  }

  public boolean setMadeByUser(Person aNewMadeByUser)
  {
    boolean wasSet = false;
    madeByUser = aNewMadeByUser;
    wasSet = true;
    return wasSet;
  }

  public boolean setMadeByBody(DecisionMakingBody aNewMadeByBody)
  {
    boolean wasSet = false;
    madeByBody = aNewMadeByBody;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    madeByUser = null;
    madeByBody = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "text" + ":" + getText()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateMade" + "=" + (getDateMade() != null ? !getDateMade().equals(this)  ? getDateMade().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "madeByUser = "+(getMadeByUser()!=null?Integer.toHexString(System.identityHashCode(getMadeByUser())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "madeByBody = "+(getMadeByBody()!=null?Integer.toHexString(System.identityHashCode(getMadeByBody())):"null")
     + outputString;
  }
}