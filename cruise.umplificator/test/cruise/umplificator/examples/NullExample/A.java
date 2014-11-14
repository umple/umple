/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 15 "NullExample.ump"
// line 114 "NullExample.ump"
public class A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //A Attributes
  private String name;
  private int i;

  //A Associations
  private D theD;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public A(String aName)
  {
    name = aName;
    i = 1;
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

  public boolean setI(int aI)
  {
    boolean wasSet = false;
    i = aI;
    wasSet = true;
    return wasSet;
  }

  /**
   * The class has an attribute called 'name' that is a string by default
   */
  public String getName()
  {
    return name;
  }

  /**
   * The class also has an integer attribute, initialized to 1
   */
  public int getI()
  {
    return i;
  }

  public D getTheD()
  {
    return theD;
  }

  public boolean hasTheD()
  {
    boolean has = theD != null;
    return has;
  }

  public boolean setTheD(D aTheD)
  {
    //
    // This source of this source generation is association_SetOptionalOneToMandatoryMany.jet
    // This set file assumes the generation of a maximumNumberOfXXX method does not exist because 
    // it's not required (No upper bound)
    //   
    boolean wasSet = false;
    D existingTheD = theD;

    if (existingTheD == null)
    {
      if (aTheD != null)
      {
        if (aTheD.addTheA(this))
        {
          existingTheD = aTheD;
          wasSet = true;
        }
      }
    } 
    else if (existingTheD != null)
    {
      if (aTheD == null)
      {
        if (existingTheD.minimumNumberOfTheA() < existingTheD.numberOfTheA())
        {
          existingTheD.removeTheA(this);
          existingTheD = aTheD;  // aTheD == null
          wasSet = true;
        }
      } 
      else
      {
        if (existingTheD.minimumNumberOfTheA() < existingTheD.numberOfTheA())
        {
          existingTheD.removeTheA(this);
          aTheD.addTheA(this);
          existingTheD = aTheD;
          wasSet = true;
        }
      }
    }
    if (wasSet)
    {
      theD = existingTheD;
    }
    return wasSet;
  }
  
  public void delete()
  {
    if (theD != null)
    {
      if (theD.numberOfTheA() <= 1)
      {
        theD.delete();
      }
      else
      {
        D placeholderTheD = theD;
        this.theD = null;
        placeholderTheD.removeTheA(this);
      }
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "i" + ":" + getI()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "theD = "+(getTheD()!=null?Integer.toHexString(System.identityHashCode(getTheD())):"null")
     + outputString;
  }
}