/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

/**
 * Positioning
 * Positioning
 */
// line 55 "../../ElectionSystem.ump"
// line 90 "../../ElectionSystem.ump"
public class Candidate
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Candidate Attributes
  private String name;
  private int phoneNumber;
  private String address;

  //Candidate Associations
  private List<Candidature> candidatures;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Candidate(String aName, int aPhoneNumber, String aAddress)
  {
    name = aName;
    phoneNumber = aPhoneNumber;
    address = aAddress;
    candidatures = new ArrayList<Candidature>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(int aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
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

  public String getName()
  {
    return name;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getAddress()
  {
    return address;
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

  public Candidature addCandidature(ElectionForPosition aElectionForPosition)
  {
    return new Candidature(aElectionForPosition, this);
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

  public boolean addCandidatureAt(Candidature aCandidature, int index)
  {  
    boolean wasAdded = false;
    if(addCandidature(aCandidature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidatures()) { index = numberOfCandidatures() - 1; }
      candidatures.remove(aCandidature);
      candidatures.add(index, aCandidature);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCandidatureAt(Candidature aCandidature, int index)
  {
    boolean wasAdded = false;
    if(candidatures.contains(aCandidature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCandidatures()) { index = numberOfCandidatures() - 1; }
      candidatures.remove(aCandidature);
      candidatures.add(index, aCandidature);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCandidatureAt(aCandidature, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=candidatures.size(); i > 0; i--)
    {
      Candidature aCandidature = candidatures.get(i - 1);
      aCandidature.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "address" + ":" + getAddress()+ "]"
     + outputString;
  }
}