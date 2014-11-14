/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;
import java.util.*;

/**
 * A fourth class that will be a singleton (only one instance allowed)
 */
// line 40 "NullExample.ump"
// line 97 "NullExample.ump"
public class D
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static D theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //D Attributes
  private String id;
  private Date someDate;
  private boolean whetherTrueOrFalse;

  //D Associations
  private B b;
  private List<A> theA;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private D(A... allTheA)
  {
    id = null;
    someDate = null;
    whetherTrueOrFalse = false;
    theA = new ArrayList<A>();
    boolean didAddTheA = setTheA(allTheA);
    if (!didAddTheA)
    {
      throw new RuntimeException("Unable to create D, must have at least 1 theA");
    }
  }

  public static D getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new D();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setSomeDate(Date aSomeDate)
  {
    boolean wasSet = false;
    someDate = aSomeDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setWhetherTrueOrFalse(boolean aWhetherTrueOrFalse)
  {
    boolean wasSet = false;
    whetherTrueOrFalse = aWhetherTrueOrFalse;
    wasSet = true;
    return wasSet;
  }

  /**
   * The following demonstrates some datatypes
   */
  public String getId()
  {
    return id;
  }

  public Date getSomeDate()
  {
    return someDate;
  }

  public boolean getWhetherTrueOrFalse()
  {
    return whetherTrueOrFalse;
  }

  public boolean isWhetherTrueOrFalse()
  {
    return whetherTrueOrFalse;
  }

  public B getB()
  {
    return b;
  }

  public boolean hasB()
  {
    boolean has = b != null;
    return has;
  }

  public A getTheA(int index)
  {
    A aTheA = theA.get(index);
    return aTheA;
  }

  public List<A> getTheA()
  {
    List<A> newTheA = Collections.unmodifiableList(theA);
    return newTheA;
  }

  public int numberOfTheA()
  {
    int number = theA.size();
    return number;
  }

  public boolean hasTheA()
  {
    boolean has = theA.size() > 0;
    return has;
  }

  public int indexOfTheA(A aTheA)
  {
    int index = theA.indexOf(aTheA);
    return index;
  }

  public boolean setB(B aNewB)
  {
    boolean wasSet = false;
    if (aNewB == null)
    {
      B existingB = b;
      b = null;
      
      if (existingB != null && existingB.getD() != null)
      {
        existingB.setD(null);
      }
      wasSet = true;
      return wasSet;
    }

    B currentB = getB();
    if (currentB != null && !currentB.equals(aNewB))
    {
      currentB.setD(null);
    }

    b = aNewB;
    D existingD = aNewB.getD();

    if (!equals(existingD))
    {
      aNewB.setD(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfTheA()
  {
    return 1;
  }

  public boolean addTheA(A aTheA)
  {
    boolean wasAdded = false;
    if (theA.contains(aTheA)) { return false; }
    D existingTheD = aTheA.getTheD();
    if (existingTheD != null && existingTheD.numberOfTheA() <= minimumNumberOfTheA())
    {
      return wasAdded;
    }
    else if (existingTheD != null)
    {
      existingTheD.theA.remove(aTheA);
    }
    theA.add(aTheA);
    setTheD(aTheA,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTheA(A aTheA)
  {
    boolean wasRemoved = false;
    if (theA.contains(aTheA) && numberOfTheA() > minimumNumberOfTheA())
    {
      theA.remove(aTheA);
      setTheD(aTheA,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setTheA(A... newTheA)
  {
    boolean wasSet = false;
    if (newTheA.length < minimumNumberOfTheA())
    {
      return wasSet;
    }

    ArrayList<A> checkNewTheA = new ArrayList<A>();
    HashMap<D,Integer> theDToNewTheA = new HashMap<D,Integer>();
    for (A aTheA : newTheA)
    {
      if (checkNewTheA.contains(aTheA))
      {
        return wasSet;
      }
      else if (aTheA.getTheD() != null && !this.equals(aTheA.getTheD()))
      {
        D existingTheD = aTheA.getTheD();
        if (!theDToNewTheA.containsKey(existingTheD))
        {
          theDToNewTheA.put(existingTheD, new Integer(existingTheD.numberOfTheA()));
        }
        Integer currentCount = theDToNewTheA.get(existingTheD);
        int nextCount = currentCount - 1;
        if (nextCount < 1)
        {
          return wasSet;
        }
        theDToNewTheA.put(existingTheD, new Integer(nextCount));
      }
      checkNewTheA.add(aTheA);
    }

    theA.removeAll(checkNewTheA);

    for (A orphan : theA)
    {
      setTheD(orphan, null);
    }
    theA.clear();
    for (A aTheA : newTheA)
    {
      if (aTheA.getTheD() != null)
      {
        aTheA.getTheD().theA.remove(aTheA);
      }
      setTheD(aTheA, this);
      theA.add(aTheA);
    }
    wasSet = true;
    return wasSet;
  }

  private void setTheD(A aTheA, D aTheD)
  {
    try
    {
      java.lang.reflect.Field mentorField = aTheA.getClass().getDeclaredField("theD");
      mentorField.setAccessible(true);
      mentorField.set(aTheA, aTheD);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aTheD to aTheA", e);
    }
  }

  public boolean addTheAAt(A aTheA, int index)
  {  
    boolean wasAdded = false;
    if(addTheA(aTheA))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTheA()) { index = numberOfTheA() - 1; }
      theA.remove(aTheA);
      theA.add(index, aTheA);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTheAAt(A aTheA, int index)
  {
    boolean wasAdded = false;
    if(theA.contains(aTheA))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTheA()) { index = numberOfTheA() - 1; }
      theA.remove(aTheA);
      theA.add(index, aTheA);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTheAAt(aTheA, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    if (b != null)
    {
      b.setD(null);
    }
    for(A aTheA : theA)
    {
      setTheD(aTheA,null);
    }
    theA.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "whetherTrueOrFalse" + ":" + getWhetherTrueOrFalse()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "someDate" + "=" + (getSomeDate() != null ? !getSomeDate().equals(this)  ? getSomeDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "b = "+(getB()!=null?Integer.toHexString(System.identityHashCode(getB())):"null")
     + outputString;
  }
}