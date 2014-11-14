/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package electorial;
import java.util.*;

// line 75 "../../ElectionSystem.ump"
// line 102 "../../ElectionSystem.ump"
public class Voter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Voter Attributes
  private String name;
  private String address;

  //Voter Associations
  private List<Candidature> candidatures;
  private PollInElection pollInElection;
  private ElectoralDistrict electoralDistrict;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Voter(String aName, String aAddress, PollInElection aPollInElection, ElectoralDistrict aElectoralDistrict)
  {
    name = aName;
    address = aAddress;
    candidatures = new ArrayList<Candidature>();
    boolean didAddPollInElection = setPollInElection(aPollInElection);
    if (!didAddPollInElection)
    {
      throw new RuntimeException("Unable to create voter due to pollInElection");
    }
    boolean didAddElectoralDistrict = setElectoralDistrict(aElectoralDistrict);
    if (!didAddElectoralDistrict)
    {
      throw new RuntimeException("Unable to create voter due to electoralDistrict");
    }
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

  public PollInElection getPollInElection()
  {
    return pollInElection;
  }

  public ElectoralDistrict getElectoralDistrict()
  {
    return electoralDistrict;
  }

  public static int minimumNumberOfCandidatures()
  {
    return 0;
  }

  public boolean addCandidature(Candidature aCandidature)
  {
    boolean wasAdded = false;
    if (candidatures.contains(aCandidature)) { return false; }
    candidatures.add(aCandidature);
    if (aCandidature.indexOfVoter(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCandidature.addVoter(this);
      if (!wasAdded)
      {
        candidatures.remove(aCandidature);
      }
    }
    return wasAdded;
  }

  public boolean removeCandidature(Candidature aCandidature)
  {
    boolean wasRemoved = false;
    if (!candidatures.contains(aCandidature))
    {
      return wasRemoved;
    }

    int oldIndex = candidatures.indexOf(aCandidature);
    candidatures.remove(oldIndex);
    if (aCandidature.indexOfVoter(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCandidature.removeVoter(this);
      if (!wasRemoved)
      {
        candidatures.add(oldIndex,aCandidature);
      }
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

  public boolean setPollInElection(PollInElection aPollInElection)
  {
    boolean wasSet = false;
    if (aPollInElection == null)
    {
      return wasSet;
    }

    PollInElection existingPollInElection = pollInElection;
    pollInElection = aPollInElection;
    if (existingPollInElection != null && !existingPollInElection.equals(aPollInElection))
    {
      existingPollInElection.removeVoter(this);
    }
    pollInElection.addVoter(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setElectoralDistrict(ElectoralDistrict aElectoralDistrict)
  {
    boolean wasSet = false;
    if (aElectoralDistrict == null)
    {
      return wasSet;
    }

    ElectoralDistrict existingElectoralDistrict = electoralDistrict;
    electoralDistrict = aElectoralDistrict;
    if (existingElectoralDistrict != null && !existingElectoralDistrict.equals(aElectoralDistrict))
    {
      existingElectoralDistrict.removeVoter(this);
    }
    electoralDistrict.addVoter(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Candidature> copyOfCandidatures = new ArrayList<Candidature>(candidatures);
    candidatures.clear();
    for(Candidature aCandidature : copyOfCandidatures)
    {
      aCandidature.removeVoter(this);
    }
    PollInElection placeholderPollInElection = pollInElection;
    this.pollInElection = null;
    placeholderPollInElection.removeVoter(this);
    ElectoralDistrict placeholderElectoralDistrict = electoralDistrict;
    this.electoralDistrict = null;
    placeholderElectoralDistrict.removeVoter(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pollInElection = "+(getPollInElection()!=null?Integer.toHexString(System.identityHashCode(getPollInElection())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "electoralDistrict = "+(getElectoralDistrict()!=null?Integer.toHexString(System.identityHashCode(getElectoralDistrict())):"null")
     + outputString;
  }
}