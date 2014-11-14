/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 61 "DMMExtensionCTF.ump"
// line 135 "DMMExtensionCTF.ump"
public class BehaviouralElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BehaviouralElement Associations
  private List<RoutineCallNode> routineCallNodes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BehaviouralElement()
  {
    routineCallNodes = new ArrayList<RoutineCallNode>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public RoutineCallNode getRoutineCallNode(int index)
  {
    RoutineCallNode aRoutineCallNode = routineCallNodes.get(index);
    return aRoutineCallNode;
  }

  public List<RoutineCallNode> getRoutineCallNodes()
  {
    List<RoutineCallNode> newRoutineCallNodes = Collections.unmodifiableList(routineCallNodes);
    return newRoutineCallNodes;
  }

  public int numberOfRoutineCallNodes()
  {
    int number = routineCallNodes.size();
    return number;
  }

  public boolean hasRoutineCallNodes()
  {
    boolean has = routineCallNodes.size() > 0;
    return has;
  }

  public int indexOfRoutineCallNode(RoutineCallNode aRoutineCallNode)
  {
    int index = routineCallNodes.indexOf(aRoutineCallNode);
    return index;
  }

  public static int minimumNumberOfRoutineCallNodes()
  {
    return 0;
  }

  public boolean addRoutineCallNode(RoutineCallNode aRoutineCallNode)
  {
    boolean wasAdded = false;
    if (routineCallNodes.contains(aRoutineCallNode)) { return false; }
    BehaviouralElement existingBehaviouralElement = aRoutineCallNode.getBehaviouralElement();
    if (existingBehaviouralElement == null)
    {
      aRoutineCallNode.setBehaviouralElement(this);
    }
    else if (!this.equals(existingBehaviouralElement))
    {
      existingBehaviouralElement.removeRoutineCallNode(aRoutineCallNode);
      addRoutineCallNode(aRoutineCallNode);
    }
    else
    {
      routineCallNodes.add(aRoutineCallNode);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoutineCallNode(RoutineCallNode aRoutineCallNode)
  {
    boolean wasRemoved = false;
    if (routineCallNodes.contains(aRoutineCallNode))
    {
      routineCallNodes.remove(aRoutineCallNode);
      aRoutineCallNode.setBehaviouralElement(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRoutineCallNodeAt(RoutineCallNode aRoutineCallNode, int index)
  {  
    boolean wasAdded = false;
    if(addRoutineCallNode(aRoutineCallNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutineCallNodes()) { index = numberOfRoutineCallNodes() - 1; }
      routineCallNodes.remove(aRoutineCallNode);
      routineCallNodes.add(index, aRoutineCallNode);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoutineCallNodeAt(RoutineCallNode aRoutineCallNode, int index)
  {
    boolean wasAdded = false;
    if(routineCallNodes.contains(aRoutineCallNode))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoutineCallNodes()) { index = numberOfRoutineCallNodes() - 1; }
      routineCallNodes.remove(aRoutineCallNode);
      routineCallNodes.add(index, aRoutineCallNode);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoutineCallNodeAt(aRoutineCallNode, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !routineCallNodes.isEmpty() )
    {
      routineCallNodes.get(0).setBehaviouralElement(null);
    }
  }

}