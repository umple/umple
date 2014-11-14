/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 22 "GenealogyC.ump"
// line 46 "GenealogyC.ump"
public class Union
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Union Attributes
  private String placeOfMarriage;
  private String dateOfMarriage;
  private String dateOfDivorce;

  //Union Associations
  private List<Person> parent;
  private List<Adoption> adoptions;
  private List<Person> child;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Union(String aPlaceOfMarriage, String aDateOfMarriage, String aDateOfDivorce)
  {
    placeOfMarriage = aPlaceOfMarriage;
    dateOfMarriage = aDateOfMarriage;
    dateOfDivorce = aDateOfDivorce;
    parent = new ArrayList<Person>();
    adoptions = new ArrayList<Adoption>();
    child = new ArrayList<Person>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlaceOfMarriage(String aPlaceOfMarriage)
  {
    boolean wasSet = false;
    placeOfMarriage = aPlaceOfMarriage;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfMarriage(String aDateOfMarriage)
  {
    boolean wasSet = false;
    dateOfMarriage = aDateOfMarriage;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfDivorce(String aDateOfDivorce)
  {
    boolean wasSet = false;
    dateOfDivorce = aDateOfDivorce;
    wasSet = true;
    return wasSet;
  }

  public String getPlaceOfMarriage()
  {
    return placeOfMarriage;
  }

  public String getDateOfMarriage()
  {
    return dateOfMarriage;
  }

  public String getDateOfDivorce()
  {
    return dateOfDivorce;
  }

  public Person getParent(int index)
  {
    Person aParent = parent.get(index);
    return aParent;
  }

  public List<Person> getParent()
  {
    List<Person> newParent = Collections.unmodifiableList(parent);
    return newParent;
  }

  public int numberOfParent()
  {
    int number = parent.size();
    return number;
  }

  public boolean hasParent()
  {
    boolean has = parent.size() > 0;
    return has;
  }

  public int indexOfParent(Person aParent)
  {
    int index = parent.indexOf(aParent);
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

  public Person getChild(int index)
  {
    Person aChild = child.get(index);
    return aChild;
  }

  public List<Person> getChild()
  {
    List<Person> newChild = Collections.unmodifiableList(child);
    return newChild;
  }

  public int numberOfChild()
  {
    int number = child.size();
    return number;
  }

  public boolean hasChild()
  {
    boolean has = child.size() > 0;
    return has;
  }

  public int indexOfChild(Person aChild)
  {
    int index = child.indexOf(aChild);
    return index;
  }

  public static int minimumNumberOfParent()
  {
    return 0;
  }

  public static int maximumNumberOfParent()
  {
    return 2;
  }

  public boolean addParent(Person aParent)
  {
    boolean wasAdded = false;
    if (parent.contains(aParent)) { return false; }
    if (numberOfParent() >= maximumNumberOfParent())
    {
      return wasAdded;
    }

    parent.add(aParent);
    if (aParent.indexOfUnion(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aParent.addUnion(this);
      if (!wasAdded)
      {
        parent.remove(aParent);
      }
    }
    return wasAdded;
  }

  public boolean removeParent(Person aParent)
  {
    boolean wasRemoved = false;
    if (!parent.contains(aParent))
    {
      return wasRemoved;
    }

    int oldIndex = parent.indexOf(aParent);
    parent.remove(oldIndex);
    if (aParent.indexOfUnion(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aParent.removeUnion(this);
      if (!wasRemoved)
      {
        parent.add(oldIndex,aParent);
      }
    }
    return wasRemoved;
  }

  public boolean setParent(Person... newParent)
  {
    boolean wasSet = false;
    ArrayList<Person> verifiedParent = new ArrayList<Person>();
    for (Person aParent : newParent)
    {
      if (verifiedParent.contains(aParent))
      {
        continue;
      }
      verifiedParent.add(aParent);
    }

    if (verifiedParent.size() != newParent.length || verifiedParent.size() > maximumNumberOfParent())
    {
      return wasSet;
    }

    ArrayList<Person> oldParent = new ArrayList<Person>(parent);
    parent.clear();
    for (Person aNewParent : verifiedParent)
    {
      parent.add(aNewParent);
      if (oldParent.contains(aNewParent))
      {
        oldParent.remove(aNewParent);
      }
      else
      {
        aNewParent.addUnion(this);
      }
    }

    for (Person anOldParent : oldParent)
    {
      anOldParent.removeUnion(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addParentAt(Person aParent, int index)
  {  
    boolean wasAdded = false;
    if(addParent(aParent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParent()) { index = numberOfParent() - 1; }
      parent.remove(aParent);
      parent.add(index, aParent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParentAt(Person aParent, int index)
  {
    boolean wasAdded = false;
    if(parent.contains(aParent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParent()) { index = numberOfParent() - 1; }
      parent.remove(aParent);
      parent.add(index, aParent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParentAt(aParent, index);
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
    Union existingAdoptiveParents = aAdoption.getAdoptiveParents();
    if (existingAdoptiveParents == null)
    {
      aAdoption.setAdoptiveParents(this);
    }
    else if (!this.equals(existingAdoptiveParents))
    {
      existingAdoptiveParents.removeAdoption(aAdoption);
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
      aAdoption.setAdoptiveParents(null);
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

  public static int minimumNumberOfChild()
  {
    return 0;
  }

  public boolean addChild(Person aChild)
  {
    boolean wasAdded = false;
    if (child.contains(aChild)) { return false; }
    Union existingParents = aChild.getParents();
    if (existingParents == null)
    {
      aChild.setParents(this);
    }
    else if (!this.equals(existingParents))
    {
      existingParents.removeChild(aChild);
      addChild(aChild);
    }
    else
    {
      child.add(aChild);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeChild(Person aChild)
  {
    boolean wasRemoved = false;
    if (child.contains(aChild))
    {
      child.remove(aChild);
      aChild.setParents(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addChildAt(Person aChild, int index)
  {  
    boolean wasAdded = false;
    if(addChild(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChild()) { index = numberOfChild() - 1; }
      child.remove(aChild);
      child.add(index, aChild);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveChildAt(Person aChild, int index)
  {
    boolean wasAdded = false;
    if(child.contains(aChild))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfChild()) { index = numberOfChild() - 1; }
      child.remove(aChild);
      child.add(index, aChild);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addChildAt(aChild, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Person> copyOfParent = new ArrayList<Person>(parent);
    parent.clear();
    for(Person aParent : copyOfParent)
    {
      aParent.removeUnion(this);
    }
    while( !adoptions.isEmpty() )
    {
      adoptions.get(0).setAdoptiveParents(null);
    }
    while( !child.isEmpty() )
    {
      child.get(0).setParents(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "placeOfMarriage" + ":" + getPlaceOfMarriage()+ "," +
            "dateOfMarriage" + ":" + getDateOfMarriage()+ "," +
            "dateOfDivorce" + ":" + getDateOfDivorce()+ "]"
     + outputString;
  }
}