/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

package routesAndLocations;
import java.util.*;

// line 68 "../../RoutesAndLocations.ump"
// line 137 "../../RoutesAndLocations.ump"
public class Intersection extends RoadNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Intersection Associations
  private List<Turn> illegalTurns;
  private List<Turn> impossibleTurns;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Intersection(int aId, Location aNodeLocation)
  {
    super(aId, aNodeLocation);
    illegalTurns = new ArrayList<Turn>();
    impossibleTurns = new ArrayList<Turn>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Turn getIllegalTurn(int index)
  {
    Turn aIllegalTurn = illegalTurns.get(index);
    return aIllegalTurn;
  }

  /**
   * illegal, but possible turns for police and fire
   */
  public List<Turn> getIllegalTurns()
  {
    List<Turn> newIllegalTurns = Collections.unmodifiableList(illegalTurns);
    return newIllegalTurns;
  }

  public int numberOfIllegalTurns()
  {
    int number = illegalTurns.size();
    return number;
  }

  public boolean hasIllegalTurns()
  {
    boolean has = illegalTurns.size() > 0;
    return has;
  }

  public int indexOfIllegalTurn(Turn aIllegalTurn)
  {
    int index = illegalTurns.indexOf(aIllegalTurn);
    return index;
  }

  public Turn getImpossibleTurn(int index)
  {
    Turn aImpossibleTurn = impossibleTurns.get(index);
    return aImpossibleTurn;
  }

  /**
   * Impossible turns , e.g. because of barriers, turning radius
   */
  public List<Turn> getImpossibleTurns()
  {
    List<Turn> newImpossibleTurns = Collections.unmodifiableList(impossibleTurns);
    return newImpossibleTurns;
  }

  public int numberOfImpossibleTurns()
  {
    int number = impossibleTurns.size();
    return number;
  }

  public boolean hasImpossibleTurns()
  {
    boolean has = impossibleTurns.size() > 0;
    return has;
  }

  public int indexOfImpossibleTurn(Turn aImpossibleTurn)
  {
    int index = impossibleTurns.indexOf(aImpossibleTurn);
    return index;
  }

  public static int minimumNumberOfIllegalTurns()
  {
    return 0;
  }

  public boolean addIllegalTurn(Turn aIllegalTurn)
  {
    boolean wasAdded = false;
    if (illegalTurns.contains(aIllegalTurn)) { return false; }
    illegalTurns.add(aIllegalTurn);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIllegalTurn(Turn aIllegalTurn)
  {
    boolean wasRemoved = false;
    if (illegalTurns.contains(aIllegalTurn))
    {
      illegalTurns.remove(aIllegalTurn);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIllegalTurnAt(Turn aIllegalTurn, int index)
  {  
    boolean wasAdded = false;
    if(addIllegalTurn(aIllegalTurn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIllegalTurns()) { index = numberOfIllegalTurns() - 1; }
      illegalTurns.remove(aIllegalTurn);
      illegalTurns.add(index, aIllegalTurn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIllegalTurnAt(Turn aIllegalTurn, int index)
  {
    boolean wasAdded = false;
    if(illegalTurns.contains(aIllegalTurn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIllegalTurns()) { index = numberOfIllegalTurns() - 1; }
      illegalTurns.remove(aIllegalTurn);
      illegalTurns.add(index, aIllegalTurn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIllegalTurnAt(aIllegalTurn, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfImpossibleTurns()
  {
    return 0;
  }

  public boolean addImpossibleTurn(Turn aImpossibleTurn)
  {
    boolean wasAdded = false;
    if (impossibleTurns.contains(aImpossibleTurn)) { return false; }
    impossibleTurns.add(aImpossibleTurn);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeImpossibleTurn(Turn aImpossibleTurn)
  {
    boolean wasRemoved = false;
    if (impossibleTurns.contains(aImpossibleTurn))
    {
      impossibleTurns.remove(aImpossibleTurn);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addImpossibleTurnAt(Turn aImpossibleTurn, int index)
  {  
    boolean wasAdded = false;
    if(addImpossibleTurn(aImpossibleTurn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImpossibleTurns()) { index = numberOfImpossibleTurns() - 1; }
      impossibleTurns.remove(aImpossibleTurn);
      impossibleTurns.add(index, aImpossibleTurn);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveImpossibleTurnAt(Turn aImpossibleTurn, int index)
  {
    boolean wasAdded = false;
    if(impossibleTurns.contains(aImpossibleTurn))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImpossibleTurns()) { index = numberOfImpossibleTurns() - 1; }
      impossibleTurns.remove(aImpossibleTurn);
      impossibleTurns.add(index, aImpossibleTurn);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addImpossibleTurnAt(aImpossibleTurn, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    illegalTurns.clear();
    impossibleTurns.clear();
    super.delete();
  }

}