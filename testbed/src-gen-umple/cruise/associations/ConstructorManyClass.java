/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class ConstructorManyClass
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConstructorManyClass Associations
  private List<Otherclass> othersOne;
  private List<Otherclass> othersTwo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConstructorManyClass(Otherclass[] allOthersOne, Otherclass[] allOthersTwo)
  {
    othersOne = new ArrayList<Otherclass>();
    boolean didAddOthersOne = setOthersOne(allOthersOne);
    if (!didAddOthersOne)
    {
      throw new RuntimeException("Unable to create ConstructorManyClass, must have 3 to 5 othersOne");
    }
    othersTwo = new ArrayList<Otherclass>();
    boolean didAddOthersTwo = setOthersTwo(allOthersTwo);
    if (!didAddOthersTwo)
    {
      throw new RuntimeException("Unable to create ConstructorManyClass, must have 1 to 3 othersTwo");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Otherclass getOthersOne(int index)
  {
    Otherclass aOthersOne = othersOne.get(index);
    return aOthersOne;
  }

  public List<Otherclass> getOthersOne()
  {
    List<Otherclass> newOthersOne = Collections.unmodifiableList(othersOne);
    return newOthersOne;
  }

  public int numberOfOthersOne()
  {
    int number = othersOne.size();
    return number;
  }

  public boolean hasOthersOne()
  {
    boolean has = othersOne.size() > 0;
    return has;
  }

  public int indexOfOthersOne(Otherclass aOthersOne)
  {
    int index = othersOne.indexOf(aOthersOne);
    return index;
  }

  public Otherclass getOthersTwo(int index)
  {
    Otherclass aOthersTwo = othersTwo.get(index);
    return aOthersTwo;
  }

  public List<Otherclass> getOthersTwo()
  {
    List<Otherclass> newOthersTwo = Collections.unmodifiableList(othersTwo);
    return newOthersTwo;
  }

  public int numberOfOthersTwo()
  {
    int number = othersTwo.size();
    return number;
  }

  public boolean hasOthersTwo()
  {
    boolean has = othersTwo.size() > 0;
    return has;
  }

  public int indexOfOthersTwo(Otherclass aOthersTwo)
  {
    int index = othersTwo.indexOf(aOthersTwo);
    return index;
  }

  public static int minimumNumberOfOthersOne()
  {
    return 3;
  }

  public static int maximumNumberOfOthersOne()
  {
    return 5;
  }

  public boolean addOthersOne(Otherclass aOthersOne)
  {
    boolean wasAdded = false;
    if (othersOne.contains(aOthersOne)) { return false; }
    if (numberOfOthersOne() < maximumNumberOfOthersOne())
    {
      othersOne.add(aOthersOne);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeOthersOne(Otherclass aOthersOne)
  {
    boolean wasRemoved = false;
    if (!othersOne.contains(aOthersOne))
    {
      return wasRemoved;
    }

    if (numberOfOthersOne() <= minimumNumberOfOthersOne())
    {
      return wasRemoved;
    }

    othersOne.remove(aOthersOne);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean setOthersOne(Otherclass... newOthersOne)
  {
    boolean wasSet = false;
    ArrayList<Otherclass> verifiedOthersOne = new ArrayList<Otherclass>();
    for (Otherclass aOthersOne : newOthersOne)
    {
      if (verifiedOthersOne.contains(aOthersOne))
      {
        continue;
      }
      verifiedOthersOne.add(aOthersOne);
    }

    if (verifiedOthersOne.size() != newOthersOne.length || verifiedOthersOne.size() < minimumNumberOfOthersOne() || verifiedOthersOne.size() > maximumNumberOfOthersOne())
    {
      return wasSet;
    }

    othersOne.clear();
    othersOne.addAll(verifiedOthersOne);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfOthersTwo()
  {
    return 1;
  }

  public static int maximumNumberOfOthersTwo()
  {
    return 3;
  }

  public boolean addOthersTwo(Otherclass aOthersTwo)
  {
    boolean wasAdded = false;
    if (othersTwo.contains(aOthersTwo)) { return false; }
    if (numberOfOthersTwo() < maximumNumberOfOthersTwo())
    {
      othersTwo.add(aOthersTwo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeOthersTwo(Otherclass aOthersTwo)
  {
    boolean wasRemoved = false;
    if (!othersTwo.contains(aOthersTwo))
    {
      return wasRemoved;
    }

    if (numberOfOthersTwo() <= minimumNumberOfOthersTwo())
    {
      return wasRemoved;
    }

    othersTwo.remove(aOthersTwo);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean setOthersTwo(Otherclass... newOthersTwo)
  {
    boolean wasSet = false;
    ArrayList<Otherclass> verifiedOthersTwo = new ArrayList<Otherclass>();
    for (Otherclass aOthersTwo : newOthersTwo)
    {
      if (verifiedOthersTwo.contains(aOthersTwo))
      {
        continue;
      }
      verifiedOthersTwo.add(aOthersTwo);
    }

    if (verifiedOthersTwo.size() != newOthersTwo.length || verifiedOthersTwo.size() < minimumNumberOfOthersTwo() || verifiedOthersTwo.size() > maximumNumberOfOthersTwo())
    {
      return wasSet;
    }

    othersTwo.clear();
    othersTwo.addAll(verifiedOthersTwo);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    othersOne.clear();
    othersTwo.clear();
  }

}