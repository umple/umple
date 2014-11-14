/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 13 "GenealogyC.ump"
// line 41 "GenealogyC.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String sex;
  private String placeOfBirth;
  private String dateOfBirth;
  private String placeOfDeath;
  private String dateOfDeath;

  //Person Associations
  private List<Union> unions;
  private List<Adoption> adoptions;
  private Union parents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, String aSex, String aPlaceOfBirth, String aDateOfBirth, String aPlaceOfDeath, String aDateOfDeath)
  {
    name = aName;
    sex = aSex;
    placeOfBirth = aPlaceOfBirth;
    dateOfBirth = aDateOfBirth;
    placeOfDeath = aPlaceOfDeath;
    dateOfDeath = aDateOfDeath;
    unions = new ArrayList<Union>();
    adoptions = new ArrayList<Adoption>();
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

  public boolean setSex(String aSex)
  {
    boolean wasSet = false;
    sex = aSex;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlaceOfBirth(String aPlaceOfBirth)
  {
    boolean wasSet = false;
    placeOfBirth = aPlaceOfBirth;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfBirth(String aDateOfBirth)
  {
    boolean wasSet = false;
    dateOfBirth = aDateOfBirth;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlaceOfDeath(String aPlaceOfDeath)
  {
    boolean wasSet = false;
    placeOfDeath = aPlaceOfDeath;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfDeath(String aDateOfDeath)
  {
    boolean wasSet = false;
    dateOfDeath = aDateOfDeath;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getSex()
  {
    return sex;
  }

  public String getPlaceOfBirth()
  {
    return placeOfBirth;
  }

  public String getDateOfBirth()
  {
    return dateOfBirth;
  }

  public String getPlaceOfDeath()
  {
    return placeOfDeath;
  }

  public String getDateOfDeath()
  {
    return dateOfDeath;
  }

  public Union getUnion(int index)
  {
    Union aUnion = unions.get(index);
    return aUnion;
  }

  public List<Union> getUnions()
  {
    List<Union> newUnions = Collections.unmodifiableList(unions);
    return newUnions;
  }

  public int numberOfUnions()
  {
    int number = unions.size();
    return number;
  }

  public boolean hasUnions()
  {
    boolean has = unions.size() > 0;
    return has;
  }

  public int indexOfUnion(Union aUnion)
  {
    int index = unions.indexOf(aUnion);
    return index;
  }

  public Adoption getAdoption(int index)
  {
    Adoption aAdoption = adoptions.get(index);
    return aAdoption;
  }

  public List<Adoption> getAdoptions()
  {
    List<Adoption> newAdoptions = Collections.unmodifiableList(adoptions);
    return newAdoptions;
  }

  public int numberOfAdoptions()
  {
    int number = adoptions.size();
    return number;
  }

  public boolean hasAdoptions()
  {
    boolean has = adoptions.size() > 0;
    return has;
  }

  public int indexOfAdoption(Adoption aAdoption)
  {
    int index = adoptions.indexOf(aAdoption);
    return index;
  }

  public Union getParents()
  {
    return parents;
  }

  public boolean hasParents()
  {
    boolean has = parents != null;
    return has;
  }

  public static int minimumNumberOfUnions()
  {
    return 0;
  }

  public boolean addUnion(Union aUnion)
  {
    boolean wasAdded = false;
    if (unions.contains(aUnion)) { return false; }
    unions.add(aUnion);
    if (aUnion.indexOfParent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUnion.addParent(this);
      if (!wasAdded)
      {
        unions.remove(aUnion);
      }
    }
    return wasAdded;
  }

  public boolean removeUnion(Union aUnion)
  {
    boolean wasRemoved = false;
    if (!unions.contains(aUnion))
    {
      return wasRemoved;
    }

    int oldIndex = unions.indexOf(aUnion);
    unions.remove(oldIndex);
    if (aUnion.indexOfParent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUnion.removeParent(this);
      if (!wasRemoved)
      {
        unions.add(oldIndex,aUnion);
      }
    }
    return wasRemoved;
  }

  public boolean addUnionAt(Union aUnion, int index)
  {  
    boolean wasAdded = false;
    if(addUnion(aUnion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnions()) { index = numberOfUnions() - 1; }
      unions.remove(aUnion);
      unions.add(index, aUnion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUnionAt(Union aUnion, int index)
  {
    boolean wasAdded = false;
    if(unions.contains(aUnion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUnions()) { index = numberOfUnions() - 1; }
      unions.remove(aUnion);
      unions.add(index, aUnion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUnionAt(aUnion, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAdoptions()
  {
    return 0;
  }

  public boolean addAdoption(Adoption aAdoption)
  {
    boolean wasAdded = false;
    if (adoptions.contains(aAdoption)) { return false; }
    Person existingAdoptedChild = aAdoption.getAdoptedChild();
    if (existingAdoptedChild == null)
    {
      aAdoption.setAdoptedChild(this);
    }
    else if (!this.equals(existingAdoptedChild))
    {
      existingAdoptedChild.removeAdoption(aAdoption);
      addAdoption(aAdoption);
    }
    else
    {
      adoptions.add(aAdoption);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAdoption(Adoption aAdoption)
  {
    boolean wasRemoved = false;
    if (adoptions.contains(aAdoption))
    {
      adoptions.remove(aAdoption);
      aAdoption.setAdoptedChild(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAdoptionAt(Adoption aAdoption, int index)
  {  
    boolean wasAdded = false;
    if(addAdoption(aAdoption))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptions()) { index = numberOfAdoptions() - 1; }
      adoptions.remove(aAdoption);
      adoptions.add(index, aAdoption);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdoptionAt(Adoption aAdoption, int index)
  {
    boolean wasAdded = false;
    if(adoptions.contains(aAdoption))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptions()) { index = numberOfAdoptions() - 1; }
      adoptions.remove(aAdoption);
      adoptions.add(index, aAdoption);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdoptionAt(aAdoption, index);
    }
    return wasAdded;
  }

  public boolean setParents(Union aParents)
  {
    boolean wasSet = false;
    Union existingParents = parents;
    parents = aParents;
    if (existingParents != null && !existingParents.equals(aParents))
    {
      existingParents.removeChild(this);
    }
    if (aParents != null)
    {
      aParents.addChild(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Union> copyOfUnions = new ArrayList<Union>(unions);
    unions.clear();
    for(Union aUnion : copyOfUnions)
    {
      aUnion.removeParent(this);
    }
    while( !adoptions.isEmpty() )
    {
      adoptions.get(0).setAdoptedChild(null);
    }
    if (parents != null)
    {
      Union placeholderParents = parents;
      this.parents = null;
      placeholderParents.removeChild(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "sex" + ":" + getSex()+ "," +
            "placeOfBirth" + ":" + getPlaceOfBirth()+ "," +
            "dateOfBirth" + ":" + getDateOfBirth()+ "," +
            "placeOfDeath" + ":" + getPlaceOfDeath()+ "," +
            "dateOfDeath" + ":" + getDateOfDeath()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "parents = "+(getParents()!=null?Integer.toHexString(System.identityHashCode(getParents())):"null")
     + outputString;
  }
}