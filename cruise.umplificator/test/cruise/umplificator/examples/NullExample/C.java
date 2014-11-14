/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * A third class
 */
// line 31 "NullExample.ump"
// line 108 "NullExample.ump"
public class C
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextZ = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes

  /**
   * Integer z will be given a number at construction that cannot change
   */
  private int z;

  //C Associations
  private List<B> bs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public C()
  {
    z = nextZ++;
    bs = new ArrayList<B>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Integer z will be given a number at construction that cannot change
   */
  public int getZ()
  {
    return z;
  }

  public B getB(int index)
  {
    B aB = bs.get(index);
    return aB;
  }

  /**
   * The following indicates that a C has some associated B's
   */
  public List<B> getBs()
  {
    List<B> newBs = Collections.unmodifiableList(bs);
    return newBs;
  }

  public int numberOfBs()
  {
    int number = bs.size();
    return number;
  }

  public boolean hasBs()
  {
    boolean has = bs.size() > 0;
    return has;
  }

  public int indexOfB(B aB)
  {
    int index = bs.indexOf(aB);
    return index;
  }

  public static int minimumNumberOfBs()
  {
    return 0;
  }

  public B addB(String aName, int aAnotherAttribute)
  {
    return new B(aName, aAnotherAttribute, this);
  }

  public boolean addB(B aB)
  {
    boolean wasAdded = false;
    if (bs.contains(aB)) { return false; }
    C existingC = aB.getC();
    boolean isNewC = existingC != null && !this.equals(existingC);
    if (isNewC)
    {
      aB.setC(this);
    }
    else
    {
      bs.add(aB);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeB(B aB)
  {
    boolean wasRemoved = false;
    //Unable to remove aB, as it must always have a c
    if (!this.equals(aB.getC()))
    {
      bs.remove(aB);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBAt(B aB, int index)
  {  
    boolean wasAdded = false;
    if(addB(aB))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBs()) { index = numberOfBs() - 1; }
      bs.remove(aB);
      bs.add(index, aB);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBAt(B aB, int index)
  {
    boolean wasAdded = false;
    if(bs.contains(aB))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBs()) { index = numberOfBs() - 1; }
      bs.remove(aB);
      bs.add(index, aB);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBAt(aB, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=bs.size(); i > 0; i--)
    {
      B aB = bs.get(i - 1);
      aB.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "z" + ":" + getZ()+ "]"
     + outputString;
  }
}