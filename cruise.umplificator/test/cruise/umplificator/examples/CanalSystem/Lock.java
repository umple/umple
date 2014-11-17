/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 23 "CanalSystem.ump"
// line 92 "CanalSystem.ump"
public class Lock extends Segment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Lock Attributes
  private float maxLevel;
  private float minLevel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Lock(float aWaterLevel, float aMaxLevel, float aMinLevel)
  {
    super(aWaterLevel);
    maxLevel = aMaxLevel;
    minLevel = aMinLevel;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMaxLevel(float aMaxLevel)
  {
    boolean wasSet = false;
    maxLevel = aMaxLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinLevel(float aMinLevel)
  {
    boolean wasSet = false;
    minLevel = aMinLevel;
    wasSet = true;
    return wasSet;
  }

  public float getMaxLevel()
  {
    return maxLevel;
  }

  public float getMinLevel()
  {
    return minLevel;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "maxLevel" + ":" + getMaxLevel()+ "," +
            "minLevel" + ":" + getMinLevel()+ "]"
     + outputString;
  }
}