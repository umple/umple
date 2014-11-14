/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 42 "PoliceSystem.ump"
// line 68 "PoliceSystem.ump"
public class SuspectDescription
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SuspectDescription Attributes
  private String height;
  private String weight;
  private String build;
  private String colour;
  private String hairCharacteristics;
  private String facialCharacteristics;
  private String otherDetails;

  //SuspectDescription Associations
  private List<Suspect> matches;
  private Witness describedBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SuspectDescription(String aHeight, String aWeight, String aBuild, String aColour, String aHairCharacteristics, String aFacialCharacteristics, String aOtherDetails, Witness aDescribedBy)
  {
    height = aHeight;
    weight = aWeight;
    build = aBuild;
    colour = aColour;
    hairCharacteristics = aHairCharacteristics;
    facialCharacteristics = aFacialCharacteristics;
    otherDetails = aOtherDetails;
    matches = new ArrayList<Suspect>();
    boolean didAddDescribedBy = setDescribedBy(aDescribedBy);
    if (!didAddDescribedBy)
    {
      throw new RuntimeException("Unable to create suspectDescription due to describedBy");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHeight(String aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeight(String aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setBuild(String aBuild)
  {
    boolean wasSet = false;
    build = aBuild;
    wasSet = true;
    return wasSet;
  }

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public boolean setHairCharacteristics(String aHairCharacteristics)
  {
    boolean wasSet = false;
    hairCharacteristics = aHairCharacteristics;
    wasSet = true;
    return wasSet;
  }

  public boolean setFacialCharacteristics(String aFacialCharacteristics)
  {
    boolean wasSet = false;
    facialCharacteristics = aFacialCharacteristics;
    wasSet = true;
    return wasSet;
  }

  public boolean setOtherDetails(String aOtherDetails)
  {
    boolean wasSet = false;
    otherDetails = aOtherDetails;
    wasSet = true;
    return wasSet;
  }

  public String getHeight()
  {
    return height;
  }

  public String getWeight()
  {
    return weight;
  }

  public String getBuild()
  {
    return build;
  }

  public String getColour()
  {
    return colour;
  }

  public String getHairCharacteristics()
  {
    return hairCharacteristics;
  }

  public String getFacialCharacteristics()
  {
    return facialCharacteristics;
  }

  public String getOtherDetails()
  {
    return otherDetails;
  }

  public Suspect getMatche(int index)
  {
    Suspect aMatche = matches.get(index);
    return aMatche;
  }

  public List<Suspect> getMatches()
  {
    List<Suspect> newMatches = Collections.unmodifiableList(matches);
    return newMatches;
  }

  public int numberOfMatches()
  {
    int number = matches.size();
    return number;
  }

  public boolean hasMatches()
  {
    boolean has = matches.size() > 0;
    return has;
  }

  public int indexOfMatche(Suspect aMatche)
  {
    int index = matches.indexOf(aMatche);
    return index;
  }

  public Witness getDescribedBy()
  {
    return describedBy;
  }

  public static int minimumNumberOfMatches()
  {
    return 0;
  }

  public boolean addMatche(Suspect aMatche)
  {
    boolean wasAdded = false;
    if (matches.contains(aMatche)) { return false; }
    matches.add(aMatche);
    if (aMatche.indexOfSuspectDescription(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMatche.addSuspectDescription(this);
      if (!wasAdded)
      {
        matches.remove(aMatche);
      }
    }
    return wasAdded;
  }

  public boolean removeMatche(Suspect aMatche)
  {
    boolean wasRemoved = false;
    if (!matches.contains(aMatche))
    {
      return wasRemoved;
    }

    int oldIndex = matches.indexOf(aMatche);
    matches.remove(oldIndex);
    if (aMatche.indexOfSuspectDescription(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMatche.removeSuspectDescription(this);
      if (!wasRemoved)
      {
        matches.add(oldIndex,aMatche);
      }
    }
    return wasRemoved;
  }

  public boolean addMatcheAt(Suspect aMatche, int index)
  {  
    boolean wasAdded = false;
    if(addMatche(aMatche))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMatches()) { index = numberOfMatches() - 1; }
      matches.remove(aMatche);
      matches.add(index, aMatche);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMatcheAt(Suspect aMatche, int index)
  {
    boolean wasAdded = false;
    if(matches.contains(aMatche))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMatches()) { index = numberOfMatches() - 1; }
      matches.remove(aMatche);
      matches.add(index, aMatche);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMatcheAt(aMatche, index);
    }
    return wasAdded;
  }

  public boolean setDescribedBy(Witness aDescribedBy)
  {
    boolean wasSet = false;
    if (aDescribedBy == null)
    {
      return wasSet;
    }

    Witness existingDescribedBy = describedBy;
    describedBy = aDescribedBy;
    if (existingDescribedBy != null && !existingDescribedBy.equals(aDescribedBy))
    {
      existingDescribedBy.removeSuspectDescription(this);
    }
    describedBy.addSuspectDescription(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Suspect> copyOfMatches = new ArrayList<Suspect>(matches);
    matches.clear();
    for(Suspect aMatche : copyOfMatches)
    {
      aMatche.removeSuspectDescription(this);
    }
    Witness placeholderDescribedBy = describedBy;
    this.describedBy = null;
    placeholderDescribedBy.removeSuspectDescription(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "height" + ":" + getHeight()+ "," +
            "weight" + ":" + getWeight()+ "," +
            "build" + ":" + getBuild()+ "," +
            "colour" + ":" + getColour()+ "," +
            "hairCharacteristics" + ":" + getHairCharacteristics()+ "," +
            "facialCharacteristics" + ":" + getFacialCharacteristics()+ "," +
            "otherDetails" + ":" + getOtherDetails()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "describedBy = "+(getDescribedBy()!=null?Integer.toHexString(System.identityHashCode(getDescribedBy())):"null")
     + outputString;
  }
}