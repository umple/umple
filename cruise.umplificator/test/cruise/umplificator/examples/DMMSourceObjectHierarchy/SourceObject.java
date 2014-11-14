/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 17 "DMMSourceObjectHierarchy.ump"
// line 150 "DMMSourceObjectHierarchy.ump"
public class SourceObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SourceObject Associations
  private List<Contains> contains;
  private List<Describes> describes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SourceObject()
  {
    contains = new ArrayList<Contains>();
    describes = new ArrayList<Describes>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Contains getContain(int index)
  {
    Contains aContain = contains.get(index);
    return aContain;
  }

  public List<Contains> getContains()
  {
    List<Contains> newContains = Collections.unmodifiableList(contains);
    return newContains;
  }

  public int numberOfContains()
  {
    int number = contains.size();
    return number;
  }

  public boolean hasContains()
  {
    boolean has = contains.size() > 0;
    return has;
  }

  public int indexOfContain(Contains aContain)
  {
    int index = contains.indexOf(aContain);
    return index;
  }

  public Describes getDescribe(int index)
  {
    Describes aDescribe = describes.get(index);
    return aDescribe;
  }

  public List<Describes> getDescribes()
  {
    List<Describes> newDescribes = Collections.unmodifiableList(describes);
    return newDescribes;
  }

  public int numberOfDescribes()
  {
    int number = describes.size();
    return number;
  }

  public boolean hasDescribes()
  {
    boolean has = describes.size() > 0;
    return has;
  }

  public int indexOfDescribe(Describes aDescribe)
  {
    int index = describes.indexOf(aDescribe);
    return index;
  }

  public static int minimumNumberOfContains()
  {
    return 0;
  }

  public Contains addContain()
  {
    return new Contains(this);
  }

  public boolean addContain(Contains aContain)
  {
    boolean wasAdded = false;
    if (contains.contains(aContain)) { return false; }
    if (contains.contains(aContain)) { return false; }
    if (contains.contains(aContain)) { return false; }
    SourceObject existingSourceObject = aContain.getSourceObject();
    boolean isNewSourceObject = existingSourceObject != null && !this.equals(existingSourceObject);
    if (isNewSourceObject)
    {
      aContain.setSourceObject(this);
    }
    else
    {
      contains.add(aContain);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeContain(Contains aContain)
  {
    boolean wasRemoved = false;
    //Unable to remove aContain, as it must always have a sourceObject
    if (!this.equals(aContain.getSourceObject()))
    {
      contains.remove(aContain);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addContainAt(Contains aContain, int index)
  {  
    boolean wasAdded = false;
    if(addContain(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContains()) { index = numberOfContains() - 1; }
      contains.remove(aContain);
      contains.add(index, aContain);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveContainAt(Contains aContain, int index)
  {
    boolean wasAdded = false;
    if(contains.contains(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContains()) { index = numberOfContains() - 1; }
      contains.remove(aContain);
      contains.add(index, aContain);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addContainAt(aContain, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDescribes()
  {
    return 0;
  }

  public Describes addDescribe()
  {
    return new Describes(this);
  }

  public boolean addDescribe(Describes aDescribe)
  {
    boolean wasAdded = false;
    if (describes.contains(aDescribe)) { return false; }
    if (describes.contains(aDescribe)) { return false; }
    if (describes.contains(aDescribe)) { return false; }
    SourceObject existingSourceObject = aDescribe.getSourceObject();
    boolean isNewSourceObject = existingSourceObject != null && !this.equals(existingSourceObject);
    if (isNewSourceObject)
    {
      aDescribe.setSourceObject(this);
    }
    else
    {
      describes.add(aDescribe);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDescribe(Describes aDescribe)
  {
    boolean wasRemoved = false;
    //Unable to remove aDescribe, as it must always have a sourceObject
    if (!this.equals(aDescribe.getSourceObject()))
    {
      describes.remove(aDescribe);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDescribeAt(Describes aDescribe, int index)
  {  
    boolean wasAdded = false;
    if(addDescribe(aDescribe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDescribes()) { index = numberOfDescribes() - 1; }
      describes.remove(aDescribe);
      describes.add(index, aDescribe);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDescribeAt(Describes aDescribe, int index)
  {
    boolean wasAdded = false;
    if(describes.contains(aDescribe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDescribes()) { index = numberOfDescribes() - 1; }
      describes.remove(aDescribe);
      describes.add(index, aDescribe);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDescribeAt(aDescribe, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=contains.size(); i > 0; i--)
    {
      Contains aContain = contains.get(i - 1);
      aContain.delete();
    }
    for(int i=describes.size(); i > 0; i--)
    {
      Describes aDescribe = describes.get(i - 1);
      aDescribe.delete();
    }
  }

}