/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 49 "DMMModelElementHierarchy.ump"
// line 231 "DMMModelElementHierarchy.ump"
public class Type extends StructuralElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Type Associations
  private List<IsDefinedInTermsOf> definesBy;
  private List<IsDefinedInTermsOf> definedBy;
  private List<IsOfType> isOfTypes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Type(String aVisibility)
  {
    super(aVisibility);
    definesBy = new ArrayList<IsDefinedInTermsOf>();
    definedBy = new ArrayList<IsDefinedInTermsOf>();
    isOfTypes = new ArrayList<IsOfType>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public IsDefinedInTermsOf getDefinesBy(int index)
  {
    IsDefinedInTermsOf aDefinesBy = definesBy.get(index);
    return aDefinesBy;
  }

  public List<IsDefinedInTermsOf> getDefinesBy()
  {
    List<IsDefinedInTermsOf> newDefinesBy = Collections.unmodifiableList(definesBy);
    return newDefinesBy;
  }

  public int numberOfDefinesBy()
  {
    int number = definesBy.size();
    return number;
  }

  public boolean hasDefinesBy()
  {
    boolean has = definesBy.size() > 0;
    return has;
  }

  public int indexOfDefinesBy(IsDefinedInTermsOf aDefinesBy)
  {
    int index = definesBy.indexOf(aDefinesBy);
    return index;
  }

  public IsDefinedInTermsOf getDefinedBy(int index)
  {
    IsDefinedInTermsOf aDefinedBy = definedBy.get(index);
    return aDefinedBy;
  }

  public List<IsDefinedInTermsOf> getDefinedBy()
  {
    List<IsDefinedInTermsOf> newDefinedBy = Collections.unmodifiableList(definedBy);
    return newDefinedBy;
  }

  public int numberOfDefinedBy()
  {
    int number = definedBy.size();
    return number;
  }

  public boolean hasDefinedBy()
  {
    boolean has = definedBy.size() > 0;
    return has;
  }

  public int indexOfDefinedBy(IsDefinedInTermsOf aDefinedBy)
  {
    int index = definedBy.indexOf(aDefinedBy);
    return index;
  }

  public IsOfType getIsOfType(int index)
  {
    IsOfType aIsOfType = isOfTypes.get(index);
    return aIsOfType;
  }

  public List<IsOfType> getIsOfTypes()
  {
    List<IsOfType> newIsOfTypes = Collections.unmodifiableList(isOfTypes);
    return newIsOfTypes;
  }

  public int numberOfIsOfTypes()
  {
    int number = isOfTypes.size();
    return number;
  }

  public boolean hasIsOfTypes()
  {
    boolean has = isOfTypes.size() > 0;
    return has;
  }

  public int indexOfIsOfType(IsOfType aIsOfType)
  {
    int index = isOfTypes.indexOf(aIsOfType);
    return index;
  }

  public static int minimumNumberOfDefinesBy()
  {
    return 0;
  }

  public IsDefinedInTermsOf addDefinesBy(Type aDefinesBy)
  {
    return new IsDefinedInTermsOf(this, aDefinesBy);
  }

  public boolean addDefinesBy(IsDefinedInTermsOf aDefinesBy)
  {
    boolean wasAdded = false;
    if (definesBy.contains(aDefinesBy)) { return false; }
    if (definesBy.contains(aDefinesBy)) { return false; }
    if (definesBy.contains(aDefinesBy)) { return false; }
    if (definesBy.contains(aDefinesBy)) { return false; }
    Type existingDefinedBy = aDefinesBy.getDefinedBy();
    boolean isNewDefinedBy = existingDefinedBy != null && !this.equals(existingDefinedBy);
    if (isNewDefinedBy)
    {
      aDefinesBy.setDefinedBy(this);
    }
    else
    {
      definesBy.add(aDefinesBy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDefinesBy(IsDefinedInTermsOf aDefinesBy)
  {
    boolean wasRemoved = false;
    //Unable to remove aDefinesBy, as it must always have a definedBy
    if (!this.equals(aDefinesBy.getDefinedBy()))
    {
      definesBy.remove(aDefinesBy);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDefinesByAt(IsDefinedInTermsOf aDefinesBy, int index)
  {  
    boolean wasAdded = false;
    if(addDefinesBy(aDefinesBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDefinesBy()) { index = numberOfDefinesBy() - 1; }
      definesBy.remove(aDefinesBy);
      definesBy.add(index, aDefinesBy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDefinesByAt(IsDefinedInTermsOf aDefinesBy, int index)
  {
    boolean wasAdded = false;
    if(definesBy.contains(aDefinesBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDefinesBy()) { index = numberOfDefinesBy() - 1; }
      definesBy.remove(aDefinesBy);
      definesBy.add(index, aDefinesBy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDefinesByAt(aDefinesBy, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDefinedBy()
  {
    return 0;
  }

  public IsDefinedInTermsOf addDefinedBy(Type aDefinedBy)
  {
    return new IsDefinedInTermsOf(aDefinedBy, this);
  }

  public boolean addDefinedBy(IsDefinedInTermsOf aDefinedBy)
  {
    boolean wasAdded = false;
    if (definedBy.contains(aDefinedBy)) { return false; }
    if (definedBy.contains(aDefinedBy)) { return false; }
    if (definedBy.contains(aDefinedBy)) { return false; }
    if (definedBy.contains(aDefinedBy)) { return false; }
    Type existingDefinesBy = aDefinedBy.getDefinesBy();
    boolean isNewDefinesBy = existingDefinesBy != null && !this.equals(existingDefinesBy);
    if (isNewDefinesBy)
    {
      aDefinedBy.setDefinesBy(this);
    }
    else
    {
      definedBy.add(aDefinedBy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDefinedBy(IsDefinedInTermsOf aDefinedBy)
  {
    boolean wasRemoved = false;
    //Unable to remove aDefinedBy, as it must always have a definesBy
    if (!this.equals(aDefinedBy.getDefinesBy()))
    {
      definedBy.remove(aDefinedBy);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDefinedByAt(IsDefinedInTermsOf aDefinedBy, int index)
  {  
    boolean wasAdded = false;
    if(addDefinedBy(aDefinedBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDefinedBy()) { index = numberOfDefinedBy() - 1; }
      definedBy.remove(aDefinedBy);
      definedBy.add(index, aDefinedBy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDefinedByAt(IsDefinedInTermsOf aDefinedBy, int index)
  {
    boolean wasAdded = false;
    if(definedBy.contains(aDefinedBy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDefinedBy()) { index = numberOfDefinedBy() - 1; }
      definedBy.remove(aDefinedBy);
      definedBy.add(index, aDefinedBy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDefinedByAt(aDefinedBy, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfIsOfTypes()
  {
    return 0;
  }

  public IsOfType addIsOfType(Value aValue)
  {
    return new IsOfType(aValue, this);
  }

  public boolean addIsOfType(IsOfType aIsOfType)
  {
    boolean wasAdded = false;
    if (isOfTypes.contains(aIsOfType)) { return false; }
    if (isOfTypes.contains(aIsOfType)) { return false; }
    if (isOfTypes.contains(aIsOfType)) { return false; }
    if (isOfTypes.contains(aIsOfType)) { return false; }
    Type existingType = aIsOfType.getType();
    boolean isNewType = existingType != null && !this.equals(existingType);
    if (isNewType)
    {
      aIsOfType.setType(this);
    }
    else
    {
      isOfTypes.add(aIsOfType);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsOfType(IsOfType aIsOfType)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsOfType, as it must always have a type
    if (!this.equals(aIsOfType.getType()))
    {
      isOfTypes.remove(aIsOfType);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsOfTypeAt(IsOfType aIsOfType, int index)
  {  
    boolean wasAdded = false;
    if(addIsOfType(aIsOfType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsOfTypes()) { index = numberOfIsOfTypes() - 1; }
      isOfTypes.remove(aIsOfType);
      isOfTypes.add(index, aIsOfType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsOfTypeAt(IsOfType aIsOfType, int index)
  {
    boolean wasAdded = false;
    if(isOfTypes.contains(aIsOfType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsOfTypes()) { index = numberOfIsOfTypes() - 1; }
      isOfTypes.remove(aIsOfType);
      isOfTypes.add(index, aIsOfType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsOfTypeAt(aIsOfType, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=definesBy.size(); i > 0; i--)
    {
      IsDefinedInTermsOf aDefinesBy = definesBy.get(i - 1);
      aDefinesBy.delete();
    }
    for(int i=definedBy.size(); i > 0; i--)
    {
      IsDefinedInTermsOf aDefinedBy = definedBy.get(i - 1);
      aDefinedBy.delete();
    }
    for(int i=isOfTypes.size(); i > 0; i--)
    {
      IsOfType aIsOfType = isOfTypes.get(i - 1);
      aIsOfType.delete();
    }
    super.delete();
  }

}