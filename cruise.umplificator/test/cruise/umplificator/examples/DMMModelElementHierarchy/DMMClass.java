/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 122 "DMMModelElementHierarchy.ump"
// line 165 "DMMModelElementHierarchy.ump"
public class DMMClass extends StructuredType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DMMClass Attributes
  private String isSubclassable;

  //DMMClass Associations
  private InheritsFrom transmits;
  private InheritsFrom inherits;
  private List<Imports> imports;
  private List<IsMethodOf> isMethodOfs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DMMClass(String aVisibility, String aIsSubclassable, InheritsFrom aTransmits, InheritsFrom aInherits)
  {
    super(aVisibility);
    isSubclassable = aIsSubclassable;
    boolean didAddTransmits = setTransmits(aTransmits);
    if (!didAddTransmits)
    {
      throw new RuntimeException("Unable to create inherit due to transmits");
    }
    boolean didAddInherits = setInherits(aInherits);
    if (!didAddInherits)
    {
      throw new RuntimeException("Unable to create transmit due to inherits");
    }
    imports = new ArrayList<Imports>();
    isMethodOfs = new ArrayList<IsMethodOf>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsSubclassable(String aIsSubclassable)
  {
    boolean wasSet = false;
    isSubclassable = aIsSubclassable;
    wasSet = true;
    return wasSet;
  }

  public String getIsSubclassable()
  {
    return isSubclassable;
  }

  public InheritsFrom getTransmits()
  {
    return transmits;
  }

  public InheritsFrom getInherits()
  {
    return inherits;
  }

  public Imports getImport(int index)
  {
    Imports aImport = imports.get(index);
    return aImport;
  }

  public List<Imports> getImports()
  {
    List<Imports> newImports = Collections.unmodifiableList(imports);
    return newImports;
  }

  public int numberOfImports()
  {
    int number = imports.size();
    return number;
  }

  public boolean hasImports()
  {
    boolean has = imports.size() > 0;
    return has;
  }

  public int indexOfImport(Imports aImport)
  {
    int index = imports.indexOf(aImport);
    return index;
  }

  public IsMethodOf getIsMethodOf(int index)
  {
    IsMethodOf aIsMethodOf = isMethodOfs.get(index);
    return aIsMethodOf;
  }

  public List<IsMethodOf> getIsMethodOfs()
  {
    List<IsMethodOf> newIsMethodOfs = Collections.unmodifiableList(isMethodOfs);
    return newIsMethodOfs;
  }

  public int numberOfIsMethodOfs()
  {
    int number = isMethodOfs.size();
    return number;
  }

  public boolean hasIsMethodOfs()
  {
    boolean has = isMethodOfs.size() > 0;
    return has;
  }

  public int indexOfIsMethodOf(IsMethodOf aIsMethodOf)
  {
    int index = isMethodOfs.indexOf(aIsMethodOf);
    return index;
  }

  public boolean setTransmits(InheritsFrom aTransmits)
  {
    boolean wasSet = false;
    if (aTransmits == null)
    {
      return wasSet;
    }

    InheritsFrom existingTransmits = transmits;
    transmits = aTransmits;
    if (existingTransmits != null && !existingTransmits.equals(aTransmits))
    {
      existingTransmits.removeInherit(this);
    }
    transmits.addInherit(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setInherits(InheritsFrom aInherits)
  {
    boolean wasSet = false;
    if (aInherits == null)
    {
      return wasSet;
    }

    InheritsFrom existingInherits = inherits;
    inherits = aInherits;
    if (existingInherits != null && !existingInherits.equals(aInherits))
    {
      existingInherits.removeTransmit(this);
    }
    inherits.addTransmit(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfImports()
  {
    return 0;
  }

  public Imports addImport(DMMPackage aDMMPackage)
  {
    return new Imports(aDMMPackage, this);
  }

  public boolean addImport(Imports aImport)
  {
    boolean wasAdded = false;
    if (imports.contains(aImport)) { return false; }
    DMMClass existingDMMClass = aImport.getDMMClass();
    boolean isNewDMMClass = existingDMMClass != null && !this.equals(existingDMMClass);
    if (isNewDMMClass)
    {
      aImport.setDMMClass(this);
    }
    else
    {
      imports.add(aImport);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeImport(Imports aImport)
  {
    boolean wasRemoved = false;
    //Unable to remove aImport, as it must always have a dMMClass
    if (!this.equals(aImport.getDMMClass()))
    {
      imports.remove(aImport);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addImportAt(Imports aImport, int index)
  {  
    boolean wasAdded = false;
    if(addImport(aImport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImports()) { index = numberOfImports() - 1; }
      imports.remove(aImport);
      imports.add(index, aImport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveImportAt(Imports aImport, int index)
  {
    boolean wasAdded = false;
    if(imports.contains(aImport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfImports()) { index = numberOfImports() - 1; }
      imports.remove(aImport);
      imports.add(index, aImport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addImportAt(aImport, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfIsMethodOfs()
  {
    return 0;
  }

  public IsMethodOf addIsMethodOf(Method aHasMethod)
  {
    return new IsMethodOf(this, aHasMethod);
  }

  public boolean addIsMethodOf(IsMethodOf aIsMethodOf)
  {
    boolean wasAdded = false;
    if (isMethodOfs.contains(aIsMethodOf)) { return false; }
    DMMClass existingMethodOf = aIsMethodOf.getMethodOf();
    boolean isNewMethodOf = existingMethodOf != null && !this.equals(existingMethodOf);
    if (isNewMethodOf)
    {
      aIsMethodOf.setMethodOf(this);
    }
    else
    {
      isMethodOfs.add(aIsMethodOf);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIsMethodOf(IsMethodOf aIsMethodOf)
  {
    boolean wasRemoved = false;
    //Unable to remove aIsMethodOf, as it must always have a methodOf
    if (!this.equals(aIsMethodOf.getMethodOf()))
    {
      isMethodOfs.remove(aIsMethodOf);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIsMethodOfAt(IsMethodOf aIsMethodOf, int index)
  {  
    boolean wasAdded = false;
    if(addIsMethodOf(aIsMethodOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsMethodOfs()) { index = numberOfIsMethodOfs() - 1; }
      isMethodOfs.remove(aIsMethodOf);
      isMethodOfs.add(index, aIsMethodOf);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIsMethodOfAt(IsMethodOf aIsMethodOf, int index)
  {
    boolean wasAdded = false;
    if(isMethodOfs.contains(aIsMethodOf))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIsMethodOfs()) { index = numberOfIsMethodOfs() - 1; }
      isMethodOfs.remove(aIsMethodOf);
      isMethodOfs.add(index, aIsMethodOf);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIsMethodOfAt(aIsMethodOf, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    InheritsFrom placeholderTransmits = transmits;
    this.transmits = null;
    placeholderTransmits.removeInherit(this);
    InheritsFrom placeholderInherits = inherits;
    this.inherits = null;
    placeholderInherits.removeTransmit(this);
    for(int i=imports.size(); i > 0; i--)
    {
      Imports aImport = imports.get(i - 1);
      aImport.delete();
    }
    for(int i=isMethodOfs.size(); i > 0; i--)
    {
      IsMethodOf aIsMethodOf = isMethodOfs.get(i - 1);
      aIsMethodOf.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isSubclassable" + ":" + getIsSubclassable()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transmits = "+(getTransmits()!=null?Integer.toHexString(System.identityHashCode(getTransmits())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "inherits = "+(getInherits()!=null?Integer.toHexString(System.identityHashCode(getInherits())):"null")
     + outputString;
  }
}