/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Specialized doctor who performs advanced procedures on patients.
 */
// line 50 "Hospital.ump"
// line 87 "Hospital.ump"
public class Surgeon extends Doctor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Surgeon(String aName, int aId, int aSalary, Hospital aHospital, Ward... allWards)
  {
    super(aName, aId, aSalary, aHospital, allWards);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}