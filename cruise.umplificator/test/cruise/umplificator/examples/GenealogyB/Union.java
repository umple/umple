/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 21 "GenealogyB.ump"
// line 41 "GenealogyB.ump"
public class Union
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Union Attributes
  private String placeOfMarriage;
  private String dateOfMarriage;

  //Union Associations
  private List<Person> partner;
  private List<Person> child;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Union(String aPlaceOfMarriage, String aDateOfMarriage)
  {
    placeOfMarriage = aPlaceOfMarriage;
    dateOfMarriage = aDateOfMarriage;
    partner = new ArrayList<Person>();
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

  public String getPlaceOfMarriage()
  {
    return placeOfMarriage;
  }

  public String getDateOfMarriage()
  {
    return dateOfMarriage;
  }

  public Person getPartner(int index)
  {
    Person aPartner = partner.get(index);
    return aPartner;
  }

  public List<Person> getPartner()
  {
    List<Person> newPartner = Collections.unmodifiableList(partner);
    return newPartner;
  }

  public int numberOfPartner()
  {
    int number = partner.size();
    return number;
  }

  public boolean hasPartner()
  {
    boolean has = partner.size() > 0;
    return has;
  }

  public int indexOfPartner(Person aPartner)
  {
    int index = partner.indexOf(aPartner);
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

  public static int minimumNumberOfPartner()
  {
    return 0;
  }

  public static int maximumNumberOfPartner()
  {
    return 2;
  }

  public boolean addPartner(Person aPartner)
  {
    boolean wasAdded = false;
    if (partner.contains(aPartner)) { return false; }
    if (numberOfPartner() >= maximumNumberOfPartner())
    {
      return wasAdded;
    }

    partner.add(aPartner);
    if (aPartner.indexOfUnion(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPartner.addUnion(this);
      if (!wasAdded)
      {
        partner.remove(aPartner);
      }
    }
    return wasAdded;
  }

  public boolean removePartner(Person aPartner)
  {
    boolean wasRemoved = false;
    if (!partner.contains(aPartner))
    {
      return wasRemoved;
    }

    int oldIndex = partner.indexOf(aPartner);
    partner.remove(oldIndex);
    if (aPartner.indexOfUnion(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPartner.removeUnion(this);
      if (!wasRemoved)
      {
        partner.add(oldIndex,aPartner);
      }
    }
    return wasRemoved;
  }

  public boolean setPartner(Person... newPartner)
  {
    boolean wasSet = false;
    ArrayList<Person> verifiedPartner = new ArrayList<Person>();
    for (Person aPartner : newPartner)
    {
      if (verifiedPartner.contains(aPartner))
      {
        continue;
      }
      verifiedPartner.add(aPartner);
    }

    if (verifiedPartner.size() != newPartner.length || verifiedPartner.size() > maximumNumberOfPartner())
    {
      return wasSet;
    }

    ArrayList<Person> oldPartner = new ArrayList<Person>(partner);
    partner.clear();
    for (Person aNewPartner : verifiedPartner)
    {
      partner.add(aNewPartner);
      if (oldPartner.contains(aNewPartner))
      {
        oldPartner.remove(aNewPartner);
      }
      else
      {
        aNewPartner.addUnion(this);
      }
    }

    for (Person anOldPartner : oldPartner)
    {
      anOldPartner.removeUnion(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addPartnerAt(Person aPartner, int index)
  {  
    boolean wasAdded = false;
    if(addPartner(aPartner))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPartner()) { index = numberOfPartner() - 1; }
      partner.remove(aPartner);
      partner.add(index, aPartner);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePartnerAt(Person aPartner, int index)
  {
    boolean wasAdded = false;
    if(partner.contains(aPartner))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPartner()) { index = numberOfPartner() - 1; }
      partner.remove(aPartner);
      partner.add(index, aPartner);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPartnerAt(aPartner, index);
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
    ArrayList<Person> copyOfPartner = new ArrayList<Person>(partner);
    partner.clear();
    for(Person aPartner : copyOfPartner)
    {
      aPartner.removeUnion(this);
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
            "dateOfMarriage" + ":" + getDateOfMarriage()+ "]"
     + outputString;
  }
}