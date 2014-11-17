/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Positioning
 */
// line 5 "Claim.ump"
// line 22 "Claim.ump"
public class Claim
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Claim Attributes
  private String sequenceNumber;
  private String sequenceNumber2;
  private String description;
  private String amountClaimed;

  //Claim Associations
  private Clamor clamor;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetSequenceNumber;
  private boolean canSetSequenceNumber2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Claim(String aSequenceNumber, String aSequenceNumber2, String aDescription, String aAmountClaimed)
  {
    cachedHashCode = -1;
    canSetSequenceNumber = true;
    canSetSequenceNumber2 = true;
    sequenceNumber = aSequenceNumber;
    sequenceNumber2 = aSequenceNumber2;
    description = aDescription;
    amountClaimed = aAmountClaimed;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSequenceNumber(String aSequenceNumber)
  {
    boolean wasSet = false;
    if (!canSetSequenceNumber) { return false; }
    sequenceNumber = aSequenceNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setSequenceNumber2(String aSequenceNumber2)
  {
    boolean wasSet = false;
    if (!canSetSequenceNumber2) { return false; }
    sequenceNumber2 = aSequenceNumber2;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountClaimed(String aAmountClaimed)
  {
    boolean wasSet = false;
    amountClaimed = aAmountClaimed;
    wasSet = true;
    return wasSet;
  }

  public String getSequenceNumber()
  {
    return sequenceNumber;
  }

  public String getSequenceNumber2()
  {
    return sequenceNumber2;
  }

  public String getDescription()
  {
    return description;
  }

  public String getAmountClaimed()
  {
    return amountClaimed;
  }

  public Clamor getClamor()
  {
    return clamor;
  }

  public boolean hasClamor()
  {
    boolean has = clamor != null;
    return has;
  }

  public boolean setClamor(Clamor aNewClamor)
  {
    boolean wasSet = false;
    if (clamor != null && !clamor.equals(aNewClamor) && equals(clamor.getClaim()))
    {
      //Unable to setClamor, as existing clamor would become an orphan
      return wasSet;
    }

    clamor = aNewClamor;
    Claim anOldClaim = aNewClamor != null ? aNewClamor.getClaim() : null;

    if (!this.equals(anOldClaim))
    {
      if (anOldClaim != null)
      {
        anOldClaim.clamor = null;
      }
      if (clamor != null)
      {
        clamor.setClaim(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Claim compareTo = (Claim)obj;
  
    if (sequenceNumber == null && compareTo.sequenceNumber != null)
    {
      return false;
    }
    else if (sequenceNumber != null && !sequenceNumber.equals(compareTo.sequenceNumber))
    {
      return false;
    }

    if (sequenceNumber2 == null && compareTo.sequenceNumber2 != null)
    {
      return false;
    }
    else if (sequenceNumber2 != null && !sequenceNumber2.equals(compareTo.sequenceNumber2))
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
    if (sequenceNumber != null)
    {
      cachedHashCode = cachedHashCode * 23 + sequenceNumber.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    if (sequenceNumber2 != null)
    {
      cachedHashCode = cachedHashCode * 23 + sequenceNumber2.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetSequenceNumber = false;
    canSetSequenceNumber2 = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Clamor existingClamor = clamor;
    clamor = null;
    if (existingClamor != null)
    {
      existingClamor.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "sequenceNumber2" + ":" + getSequenceNumber2()+ "," +
            "sequenceNumber" + ":" + getSequenceNumber()+ "," +
            "description" + ":" + getDescription()+ "," +
            "amountClaimed" + ":" + getAmountClaimed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "clamor = "+(getClamor()!=null?Integer.toHexString(System.identityHashCode(getClamor())):"null")
     + outputString;
  }
}