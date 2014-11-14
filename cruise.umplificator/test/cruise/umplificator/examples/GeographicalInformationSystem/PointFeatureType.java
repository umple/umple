/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 38 "GeographicalInformationSystem.ump"
// line 89 "GeographicalInformationSystem.ump"
public class PointFeatureType extends FeatureType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PointFeatureType Associations
  private Bitmap symbol;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PointFeatureType(String aDescription, Bitmap aSymbol)
  {
    super(aDescription);
    if (!setSymbol(aSymbol))
    {
      throw new RuntimeException("Unable to create PointFeatureType due to aSymbol");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Bitmap getSymbol()
  {
    return symbol;
  }

  public boolean setSymbol(Bitmap aNewSymbol)
  {
    boolean wasSet = false;
    if (aNewSymbol != null)
    {
      symbol = aNewSymbol;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    symbol = null;
    super.delete();
  }

}