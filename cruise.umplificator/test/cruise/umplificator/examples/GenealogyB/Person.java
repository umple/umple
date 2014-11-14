/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Positioning
 */
// line 12 "GenealogyB.ump"
// line 36 "GenealogyB.ump"
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
  private Union parents;
  private List<Person> adoptedChild;
  private List<Person> adoptiveParents;

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
    adoptedChild = new ArrayList<Person>();
    adoptiveParents = new ArrayList<Person>();
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

  public Union getParents()
  {
    return parents;
  }

  public boolean hasParents()
  {
    boolean has = parents != null;
    return has;
  }

  public Person getAdoptedChild(int index)
  {
    Person aAdoptedChild = adoptedChild.get(index);
    return aAdoptedChild;
  }

  public List<Person> getAdoptedChild()
  {
    List<Person> newAdoptedChild = Collections.unmodifiableList(adoptedChild);
    return newAdoptedChild;
  }

  public int numberOfAdoptedChild()
  {
    int number = adoptedChild.size();
    return number;
  }

  public boolean hasAdoptedChild()
  {
    boolean has = adoptedChild.size() > 0;
    return has;
  }

  public int indexOfAdoptedChild(Person aAdoptedChild)
  {
    int index = adoptedChild.indexOf(aAdoptedChild);
    return index;
  }

  public Person getAdoptiveParent(int index)
  {
    Person aAdoptiveParent = adoptiveParents.get(index);
    return aAdoptiveParent;
  }

  public List<Person> getAdoptiveParents()
  {
    List<Person> newAdoptiveParents = Collections.unmodifiableList(adoptiveParents);
    return newAdoptiveParents;
  }

  public int numberOfAdoptiveParents()
  {
    int number = adoptiveParents.size();
    return number;
  }

  public boolean hasAdoptiveParents()
  {
    boolean has = adoptiveParents.size() > 0;
    return has;
  }

  public int indexOfAdoptiveParent(Person aAdoptiveParent)
  {
    int index = adoptiveParents.indexOf(aAdoptiveParent);
    return index;
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
    if (aUnion.indexOfPartner(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUnion.addPartner(this);
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
    if (aUnion.indexOfPartner(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUnion.removePartner(this);
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

  public static int minimumNumberOfAdoptedChild()
  {
    return 0;
  }

  public boolean addAdoptedChild(Person aAdoptedChild)
  {
    boolean wasAdded = false;
    if (adoptedChild.contains(aAdoptedChild)) { return false; }
    adoptedChild.add(aAdoptedChild);
    if (aAdoptedChild.indexOfAdoptiveParent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAdoptedChild.addAdoptiveParent(this);
      if (!wasAdded)
      {
        adoptedChild.remove(aAdoptedChild);
      }
    }
    return wasAdded;
  }

  public boolean removeAdoptedChild(Person aAdoptedChild)
  {
    boolean wasRemoved = false;
    if (!adoptedChild.contains(aAdoptedChild))
    {
      return wasRemoved;
    }

    int oldIndex = adoptedChild.indexOf(aAdoptedChild);
    adoptedChild.remove(oldIndex);
    if (aAdoptedChild.indexOfAdoptiveParent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAdoptedChild.removeAdoptiveParent(this);
      if (!wasRemoved)
      {
        adoptedChild.add(oldIndex,aAdoptedChild);
      }
    }
    return wasRemoved;
  }

  public boolean addAdoptedChildAt(Person aAdoptedChild, int index)
  {  
    boolean wasAdded = false;
    if(addAdoptedChild(aAdoptedChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptedChild()) { index = numberOfAdoptedChild() - 1; }
      adoptedChild.remove(aAdoptedChild);
      adoptedChild.add(index, aAdoptedChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdoptedChildAt(Person aAdoptedChild, int index)
  {
    boolean wasAdded = false;
    if(adoptedChild.contains(aAdoptedChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptedChild()) { index = numberOfAdoptedChild() - 1; }
      adoptedChild.remove(aAdoptedChild);
      adoptedChild.add(index, aAdoptedChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdoptedChildAt(aAdoptedChild, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAdoptiveParents()
  {
    return 0;
  }

  public static int maximumNumberOfAdoptiveParents()
  {
    return 2;
  }

  public boolean addAdoptiveParent(Person aAdoptiveParent)
  {
    boolean wasAdded = false;
    if (adoptiveParents.contains(aAdoptiveParent)) { return false; }
    if (numberOfAdoptiveParents() >= maximumNumberOfAdoptiveParents())
    {
      return wasAdded;
    }

    adoptiveParents.add(aAdoptiveParent);
    if (aAdoptiveParent.indexOfAdoptedChild(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAdoptiveParent.addAdoptedChild(this);
      if (!wasAdded)
      {
        adoptiveParents.remove(aAdoptiveParent);
      }
    }
    return wasAdded;
  }

  public boolean removeAdoptiveParent(Person aAdoptiveParent)
  {
    boolean wasRemoved = false;
    if (!adoptiveParents.contains(aAdoptiveParent))
    {
      return wasRemoved;
    }

    int oldIndex = adoptiveParents.indexOf(aAdoptiveParent);
    adoptiveParents.remove(oldIndex);
    if (aAdoptiveParent.indexOfAdoptedChild(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAdoptiveParent.removeAdoptedChild(this);
      if (!wasRemoved)
      {
        adoptiveParents.add(oldIndex,aAdoptiveParent);
      }
    }
    return wasRemoved;
  }

  public boolean setAdoptiveParents(Person... newAdoptiveParents)
  {
    boolean wasSet = false;
    ArrayList<Person> verifiedAdoptiveParents = new ArrayList<Person>();
    for (Person aAdoptiveParent : newAdoptiveParents)
    {
      if (verifiedAdoptiveParents.contains(aAdoptiveParent))
      {
        continue;
      }
      verifiedAdoptiveParents.add(aAdoptiveParent);
    }

    if (verifiedAdoptiveParents.size() != newAdoptiveParents.length || verifiedAdoptiveParents.size() > maximumNumberOfAdoptiveParents())
    {
      return wasSet;
    }

    ArrayList<Person> oldAdoptiveParents = new ArrayList<Person>(adoptiveParents);
    adoptiveParents.clear();
    for (Person aNewAdoptiveParent : verifiedAdoptiveParents)
    {
      adoptiveParents.add(aNewAdoptiveParent);
      if (oldAdoptiveParents.contains(aNewAdoptiveParent))
      {
        oldAdoptiveParents.remove(aNewAdoptiveParent);
      }
      else
      {
        aNewAdoptiveParent.addAdoptedChild(this);
      }
    }

    for (Person anOldAdoptiveParent : oldAdoptiveParents)
    {
      anOldAdoptiveParent.removeAdoptedChild(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addAdoptiveParentAt(Person aAdoptiveParent, int index)
  {  
    boolean wasAdded = false;
    if(addAdoptiveParent(aAdoptiveParent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptiveParents()) { index = numberOfAdoptiveParents() - 1; }
      adoptiveParents.remove(aAdoptiveParent);
      adoptiveParents.add(index, aAdoptiveParent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAdoptiveParentAt(Person aAdoptiveParent, int index)
  {
    boolean wasAdded = false;
    if(adoptiveParents.contains(aAdoptiveParent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAdoptiveParents()) { index = numberOfAdoptiveParents() - 1; }
      adoptiveParents.remove(aAdoptiveParent);
      adoptiveParents.add(index, aAdoptiveParent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAdoptiveParentAt(aAdoptiveParent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Union> copyOfUnions = new ArrayList<Union>(unions);
    unions.clear();
    for(Union aUnion : copyOfUnions)
    {
      aUnion.removePartner(this);
    }
    if (parents != null)
    {
      Union placeholderParents = parents;
      this.parents = null;
      placeholderParents.removeChild(this);
    }
    ArrayList<Person> copyOfAdoptedChild = new ArrayList<Person>(adoptedChild);
    adoptedChild.clear();
    for(Person aAdoptedChild : copyOfAdoptedChild)
    {
      aAdoptedChild.removeAdoptiveParent(this);
    }
    ArrayList<Person> copyOfAdoptiveParents = new ArrayList<Person>(adoptiveParents);
    adoptiveParents.clear();
    for(Person aAdoptiveParent : copyOfAdoptiveParents)
    {
      aAdoptiveParent.removeAdoptedChild(this);
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