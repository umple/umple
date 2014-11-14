/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

/**
 * Abstract
 */
// line 33 "DMMOverview.ump"
// line 94 "DMMOverview.ump"
public class ModelObject
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ModelObject Attributes
  private String name;

  //ModelObject Associations
  private Defines defines;
  private List<Declares> declares;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ModelObject(String aName)
  {
    name = aName;
    declares = new ArrayList<Declares>();
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

  public String getName()
  {
    return name;
  }

  public Defines getDefines()
  {
    return defines;
  }

  public boolean hasDefines()
  {
    boolean has = defines != null;
    return has;
  }

  public Declares getDeclare(int index)
  {
    Declares aDeclare = declares.get(index);
    return aDeclare;
  }

  public List<Declares> getDeclares()
  {
    List<Declares> newDeclares = Collections.unmodifiableList(declares);
    return newDeclares;
  }

  public int numberOfDeclares()
  {
    int number = declares.size();
    return number;
  }

  public boolean hasDeclares()
  {
    boolean has = declares.size() > 0;
    return has;
  }

  public int indexOfDeclare(Declares aDeclare)
  {
    int index = declares.indexOf(aDeclare);
    return index;
  }

  public boolean setDefines(Defines aNewDefines)
  {
    boolean wasSet = false;
    if (defines != null && !defines.equals(aNewDefines) && equals(defines.getModelObject()))
    {
      //Unable to setDefines, as existing defines would become an orphan
      return wasSet;
    }

    defines = aNewDefines;
    ModelObject anOldModelObject = aNewDefines != null ? aNewDefines.getModelObject() : null;

    if (!this.equals(anOldModelObject))
    {
      if (anOldModelObject != null)
      {
        anOldModelObject.defines = null;
      }
      if (defines != null)
      {
        defines.setModelObject(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDeclares()
  {
    return 0;
  }

  public Declares addDeclare(SourceObject aSourceObject)
  {
    return new Declares(aSourceObject, this);
  }

  public boolean addDeclare(Declares aDeclare)
  {
    boolean wasAdded = false;
    if (declares.contains(aDeclare)) { return false; }
    if (declares.contains(aDeclare)) { return false; }
    if (declares.contains(aDeclare)) { return false; }
    ModelObject existingModelObject = aDeclare.getModelObject();
    boolean isNewModelObject = existingModelObject != null && !this.equals(existingModelObject);
    if (isNewModelObject)
    {
      aDeclare.setModelObject(this);
    }
    else
    {
      declares.add(aDeclare);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDeclare(Declares aDeclare)
  {
    boolean wasRemoved = false;
    //Unable to remove aDeclare, as it must always have a modelObject
    if (!this.equals(aDeclare.getModelObject()))
    {
      declares.remove(aDeclare);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDeclareAt(Declares aDeclare, int index)
  {  
    boolean wasAdded = false;
    if(addDeclare(aDeclare))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeclares()) { index = numberOfDeclares() - 1; }
      declares.remove(aDeclare);
      declares.add(index, aDeclare);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDeclareAt(Declares aDeclare, int index)
  {
    boolean wasAdded = false;
    if(declares.contains(aDeclare))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDeclares()) { index = numberOfDeclares() - 1; }
      declares.remove(aDeclare);
      declares.add(index, aDeclare);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDeclareAt(aDeclare, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Defines existingDefines = defines;
    defines = null;
    if (existingDefines != null)
    {
      existingDefines.delete();
    }
    for(int i=declares.size(); i > 0; i--)
    {
      Declares aDeclare = declares.get(i - 1);
      aDeclare.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "defines = "+(getDefines()!=null?Integer.toHexString(System.identityHashCode(getDefines())):"null")
     + outputString;
  }
}