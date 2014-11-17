/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 67 "CoOpSystem.ump"
// line 132 "CoOpSystem.ump"
public class Offer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Offer Attributes
  private String ranking;
  private boolean accepted;

  //Offer Associations
  private Application application;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Offer(String aRanking, boolean aAccepted, Application aApplication)
  {
    ranking = aRanking;
    accepted = aAccepted;
    boolean didAddApplication = setApplication(aApplication);
    if (!didAddApplication)
    {
      throw new RuntimeException("Unable to create offer due to application");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRanking(String aRanking)
  {
    boolean wasSet = false;
    ranking = aRanking;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccepted(boolean aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }

  public String getRanking()
  {
    return ranking;
  }

  public boolean getAccepted()
  {
    return accepted;
  }

  public boolean isAccepted()
  {
    return accepted;
  }

  public Application getApplication()
  {
    return application;
  }

  public boolean setApplication(Application aNewApplication)
  {
    boolean wasSet = false;
    if (aNewApplication == null)
    {
      //Unable to setApplication to null, as offer must always be associated to a application
      return wasSet;
    }
    
    Offer existingOffer = aNewApplication.getOffer();
    if (existingOffer != null && !equals(existingOffer))
    {
      //Unable to setApplication, the current application already has a offer, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Application anOldApplication = application;
    application = aNewApplication;
    application.setOffer(this);

    if (anOldApplication != null)
    {
      anOldApplication.setOffer(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Application existingApplication = application;
    application = null;
    if (existingApplication != null)
    {
      existingApplication.setOffer(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "ranking" + ":" + getRanking()+ "," +
            "accepted" + ":" + getAccepted()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "application = "+(getApplication()!=null?Integer.toHexString(System.identityHashCode(getApplication())):"null")
     + outputString;
  }
}