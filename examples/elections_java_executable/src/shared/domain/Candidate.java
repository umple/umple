/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package shared.domain;
import java.util.*;

public class Candidate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidate Attributes
  private int idCandidate;
  private String name;
  private String address;
  private String telephone;

  //Candidate Associations
  private List<Candidature> candidatures;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetIdCandidate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Candidate(int aIdCandidate, String aName, String aAddress, String aTelephone)
  {
    cachedHashCode = -1;
    canSetIdCandidate = true;
    idCandidate = aIdCandidate;
    name = aName;
    address = aAddress;
    telephone = aTelephone;
    candidatures = new ArrayList<Candidature>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIdCandidate(int aIdCandidate)
  {
    boolean wasSet = false;
    if (!canSetIdCandidate) { return false; }
    idCandidate = aIdCandidate;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setTelephone(String aTelephone)
  {
    boolean wasSet = false;
    telephone = aTelephone;
    wasSet = true;
    return wasSet;
  }

  public int getIdCandidate()
  {
    return idCandidate;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public String getTelephone()
  {
    return telephone;
  }

  public Candidature getCandidature(int index)
  {
    Candidature aCandidature = candidatures.get(index);
    return aCandidature;
  }

  public List<Candidature> getCandidatures()
  {
    List<Candidature> newCandidatures = Collections.unmodifiableList(candidatures);
    return newCandidatures;
  }

  public int numberOfCandidatures()
  {
    int number = candidatures.size();
    return number;
  }

  public boolean hasCandidatures()
  {
    boolean has = candidatures.size() > 0;
    return has;
  }

  public int indexOfCandidature(Candidature aCandidature)
  {
    int index = candidatures.indexOf(aCandidature);
    return index;
  }

  public static int minimumNumberOfCandidatures()
  {
    return 0;
  }

  public Candidature addCandidature(int aIdCandidature, ElectionForPosition aElectionForPosition)
  {
    return new Candidature(aIdCandidature, this, aElectionForPosition);
  }

  public boolean addCandidature(Candidature aCandidature)
  {
    boolean wasAdded = false;
    if (candidatures.contains(aCandidature)) { return false; }
    Candidate existingCandidate = aCandidature.getCandidate();
    boolean isNewCandidate = existingCandidate != null && !this.equals(existingCandidate);
    if (isNewCandidate)
    {
      aCandidature.setCandidate(this);
    }
    else
    {
      candidatures.add(aCandidature);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCandidature(Candidature aCandidature)
  {
    boolean wasRemoved = false;
    //Unable to remove aCandidature, as it must always have a candidate
    if (!this.equals(aCandidature.getCandidate()))
    {
      candidatures.remove(aCandidature);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Candidate compareTo = (Candidate)obj;
  
    if (idCandidate != compareTo.idCandidate)
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
    cachedHashCode = cachedHashCode * 23 + idCandidate;

    canSetIdCandidate = false;
    return cachedHashCode;
  }

  public void delete()
  {
    for(int i=candidatures.size(); i > 0; i--)
    {
      Candidature aCandidature = candidatures.get(i - 1);
      aCandidature.delete();
    }
  }

}