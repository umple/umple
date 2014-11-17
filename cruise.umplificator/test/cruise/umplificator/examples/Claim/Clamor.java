/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 14 "Claim.ump"
// line 28 "Claim.ump"
public class Clamor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Clamor Attributes
  private String sequencia;
  private String description;
  private String plata;

  //Clamor Associations
  private Claim claim;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetSequencia;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Clamor(String aSequencia, String aPlata, Claim aClaim)
  {
    cachedHashCode = -1;
    canSetSequencia = true;
    sequencia = aSequencia;
    description = "2";
    plata = aPlata;
    boolean didAddClaim = setClaim(aClaim);
    if (!didAddClaim)
    {
      throw new RuntimeException("Unable to create clamor due to claim");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSequencia(String aSequencia)
  {
    boolean wasSet = false;
    if (!canSetSequencia) { return false; }
    sequencia = aSequencia;
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

  public boolean setPlata(String aPlata)
  {
    boolean wasSet = false;
    plata = aPlata;
    wasSet = true;
    return wasSet;
  }

  public String getSequencia()
  {
    return sequencia;
  }

  public String getDescription()
  {
    return description;
  }

  public String getPlata()
  {
    return plata;
  }

  public Claim getClaim()
  {
    return claim;
  }

  public boolean setClaim(Claim aNewClaim)
  {
    boolean wasSet = false;
    if (aNewClaim == null)
    {
      //Unable to setClaim to null, as clamor must always be associated to a claim
      return wasSet;
    }
    
    Clamor existingClamor = aNewClaim.getClamor();
    if (existingClamor != null && !equals(existingClamor))
    {
      //Unable to setClaim, the current claim already has a clamor, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Claim anOldClaim = claim;
    claim = aNewClaim;
    claim.setClamor(this);

    if (anOldClaim != null)
    {
      anOldClaim.setClamor(null);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Clamor compareTo = (Clamor)obj;
  
    if (sequencia == null && compareTo.sequencia != null)
    {
      return false;
    }
    else if (sequencia != null && !sequencia.equals(compareTo.sequencia))
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
    if (sequencia != null)
    {
      cachedHashCode = cachedHashCode * 23 + sequencia.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetSequencia = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Claim existingClaim = claim;
    claim = null;
    if (existingClaim != null)
    {
      existingClaim.setClamor(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "sequencia" + ":" + getSequencia()+ "," +
            "description" + ":" + getDescription()+ "," +
            "plata" + ":" + getPlata()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "claim = "+(getClaim()!=null?Integer.toHexString(System.identityHashCode(getClaim())):"null")
     + outputString;
  }
}