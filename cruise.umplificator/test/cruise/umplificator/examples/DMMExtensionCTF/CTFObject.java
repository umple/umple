/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 82 "DMMExtensionCTF.ump"
// line 171 "DMMExtensionCTF.ump"
public class CTFObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CTFObject Attributes
  private String objectID;

  //CTFObject Associations
  private List<MethodInvocationNode> invokes;
  private CTFClass instanceOf;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CTFObject(String aObjectID)
  {
    objectID = aObjectID;
    invokes = new ArrayList<MethodInvocationNode>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setObjectID(String aObjectID)
  {
    boolean wasSet = false;
    objectID = aObjectID;
    wasSet = true;
    return wasSet;
  }

  public String getObjectID()
  {
    return objectID;
  }

  public MethodInvocationNode getInvoke(int index)
  {
    MethodInvocationNode aInvoke = invokes.get(index);
    return aInvoke;
  }

  public List<MethodInvocationNode> getInvokes()
  {
    List<MethodInvocationNode> newInvokes = Collections.unmodifiableList(invokes);
    return newInvokes;
  }

  public int numberOfInvokes()
  {
    int number = invokes.size();
    return number;
  }

  public boolean hasInvokes()
  {
    boolean has = invokes.size() > 0;
    return has;
  }

  public int indexOfInvoke(MethodInvocationNode aInvoke)
  {
    int index = invokes.indexOf(aInvoke);
    return index;
  }

  public CTFClass getInstanceOf()
  {
    return instanceOf;
  }

  public boolean hasInstanceOf()
  {
    boolean has = instanceOf != null;
    return has;
  }

  public static int minimumNumberOfInvokes()
  {
    return 0;
  }

  public boolean addInvoke(MethodInvocationNode aInvoke)
  {
    boolean wasAdded = false;
    if (invokes.contains(aInvoke)) { return false; }
    CTFObject existingCTFObject = aInvoke.getCTFObject();
    if (existingCTFObject == null)
    {
      aInvoke.setCTFObject(this);
    }
    else if (!this.equals(existingCTFObject))
    {
      existingCTFObject.removeInvoke(aInvoke);
      addInvoke(aInvoke);
    }
    else
    {
      invokes.add(aInvoke);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInvoke(MethodInvocationNode aInvoke)
  {
    boolean wasRemoved = false;
    if (invokes.contains(aInvoke))
    {
      invokes.remove(aInvoke);
      aInvoke.setCTFObject(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInvokeAt(MethodInvocationNode aInvoke, int index)
  {  
    boolean wasAdded = false;
    if(addInvoke(aInvoke))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvokes()) { index = numberOfInvokes() - 1; }
      invokes.remove(aInvoke);
      invokes.add(index, aInvoke);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInvokeAt(MethodInvocationNode aInvoke, int index)
  {
    boolean wasAdded = false;
    if(invokes.contains(aInvoke))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInvokes()) { index = numberOfInvokes() - 1; }
      invokes.remove(aInvoke);
      invokes.add(index, aInvoke);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInvokeAt(aInvoke, index);
    }
    return wasAdded;
  }

  public boolean setInstanceOf(CTFClass aInstanceOf)
  {
    boolean wasSet = false;
    CTFClass existingInstanceOf = instanceOf;
    instanceOf = aInstanceOf;
    if (existingInstanceOf != null && !existingInstanceOf.equals(aInstanceOf))
    {
      existingInstanceOf.removeInstancedBy(this);
    }
    if (aInstanceOf != null)
    {
      aInstanceOf.addInstancedBy(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !invokes.isEmpty() )
    {
      invokes.get(0).setCTFObject(null);
    }
    if (instanceOf != null)
    {
      CTFClass placeholderInstanceOf = instanceOf;
      this.instanceOf = null;
      placeholderInstanceOf.removeInstancedBy(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "objectID" + ":" + getObjectID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "instanceOf = "+(getInstanceOf()!=null?Integer.toHexString(System.identityHashCode(getInstanceOf())):"null")
     + outputString;
  }
}