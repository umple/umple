/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 39 "DMMModelElementHierarchy.ump"
// line 236 "DMMModelElementHierarchy.ump"
public class DMMPackage extends ModelElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DMMPackage Associations
  private DMMPackage isSubpackageOf;
  private List<DMMPackage> dMMPackages;
  private List<Contains> contain;
  private List<Imports> imports;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DMMPackage(String aVisibility)
  {
    super(aVisibility);
    dMMPackages = new ArrayList<DMMPackage>();
    contain = new ArrayList<Contains>();
    imports = new ArrayList<Imports>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DMMPackage getIsSubpackageOf()
  {
    return isSubpackageOf;
  }

  public boolean hasIsSubpackageOf()
  {
    boolean has = isSubpackageOf != null;
    return has;
  }

  public DMMPackage getDMMPackage(int index)
  {
    DMMPackage aDMMPackage = dMMPackages.get(index);
    return aDMMPackage;
  }

  public List<DMMPackage> getDMMPackages()
  {
    List<DMMPackage> newDMMPackages = Collections.unmodifiableList(dMMPackages);
    return newDMMPackages;
  }

  public int numberOfDMMPackages()
  {
    int number = dMMPackages.size();
    return number;
  }

  public boolean hasDMMPackages()
  {
    boolean has = dMMPackages.size() > 0;
    return has;
  }

  public int indexOfDMMPackage(DMMPackage aDMMPackage)
  {
    int index = dMMPackages.indexOf(aDMMPackage);
    return index;
  }

  public Contains getContain(int index)
  {
    Contains aContain = contain.get(index);
    return aContain;
  }

  public List<Contains> getContain()
  {
    List<Contains> newContain = Collections.unmodifiableList(contain);
    return newContain;
  }

  public int numberOfContain()
  {
    int number = contain.size();
    return number;
  }

  public boolean hasContain()
  {
    boolean has = contain.size() > 0;
    return has;
  }

  public int indexOfContain(Contains aContain)
  {
    int index = contain.indexOf(aContain);
    return index;
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

  public boolean setIsSubpackageOf(DMMPackage aIsSubpackageOf)
  {
    boolean wasSet = false;
    DMMPackage existingIsSubpackageOf = isSubpackageOf;
    isSubpackageOf = aIsSubpackageOf;
    if (existingIsSubpackageOf != null && !existingIsSubpackageOf.equals(aIsSubpackageOf))
    {
      existingIsSubpackageOf.removeDMMPackage(this);
    }
    if (aIsSubpackageOf != null)
    {
      aIsSubpackageOf.addDMMPackage(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfDMMPackages()
  {
    return 0;
  }

  public boolean addDMMPackage(DMMPackage aDMMPackage)
  {
    boolean wasAdded = false;
    if (dMMPackages.contains(aDMMPackage)) { return false; }
    DMMPackage existingIsSubpackageOf = aDMMPackage.getIsSubpackageOf();
    if (existingIsSubpackageOf == null)
    {
      aDMMPackage.setIsSubpackageOf(this);
    }
    else if (!this.equals(existingIsSubpackageOf))
    {
      existingIsSubpackageOf.removeDMMPackage(aDMMPackage);
      addDMMPackage(aDMMPackage);
    }
    else
    {
      dMMPackages.add(aDMMPackage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDMMPackage(DMMPackage aDMMPackage)
  {
    boolean wasRemoved = false;
    if (dMMPackages.contains(aDMMPackage))
    {
      dMMPackages.remove(aDMMPackage);
      aDMMPackage.setIsSubpackageOf(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDMMPackageAt(DMMPackage aDMMPackage, int index)
  {  
    boolean wasAdded = false;
    if(addDMMPackage(aDMMPackage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDMMPackages()) { index = numberOfDMMPackages() - 1; }
      dMMPackages.remove(aDMMPackage);
      dMMPackages.add(index, aDMMPackage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDMMPackageAt(DMMPackage aDMMPackage, int index)
  {
    boolean wasAdded = false;
    if(dMMPackages.contains(aDMMPackage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDMMPackages()) { index = numberOfDMMPackages() - 1; }
      dMMPackages.remove(aDMMPackage);
      dMMPackages.add(index, aDMMPackage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDMMPackageAt(aDMMPackage, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfContain()
  {
    return 0;
  }

  public Contains addContain(ModelElement aModelElement)
  {
    return new Contains(this, aModelElement);
  }

  public boolean addContain(Contains aContain)
  {
    boolean wasAdded = false;
    if (contain.contains(aContain)) { return false; }
    DMMPackage existingPartOf = aContain.getPartOf();
    boolean isNewPartOf = existingPartOf != null && !this.equals(existingPartOf);
    if (isNewPartOf)
    {
      aContain.setPartOf(this);
    }
    else
    {
      contain.add(aContain);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeContain(Contains aContain)
  {
    boolean wasRemoved = false;
    //Unable to remove aContain, as it must always have a partOf
    if (!this.equals(aContain.getPartOf()))
    {
      contain.remove(aContain);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addContainAt(Contains aContain, int index)
  {  
    boolean wasAdded = false;
    if(addContain(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContain()) { index = numberOfContain() - 1; }
      contain.remove(aContain);
      contain.add(index, aContain);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveContainAt(Contains aContain, int index)
  {
    boolean wasAdded = false;
    if(contain.contains(aContain))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContain()) { index = numberOfContain() - 1; }
      contain.remove(aContain);
      contain.add(index, aContain);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addContainAt(aContain, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfImports()
  {
    return 0;
  }

  public Imports addImport(DMMClass aDMMClass)
  {
    return new Imports(this, aDMMClass);
  }

  public boolean addImport(Imports aImport)
  {
    boolean wasAdded = false;
    if (imports.contains(aImport)) { return false; }
    DMMPackage existingDMMPackage = aImport.getDMMPackage();
    boolean isNewDMMPackage = existingDMMPackage != null && !this.equals(existingDMMPackage);
    if (isNewDMMPackage)
    {
      aImport.setDMMPackage(this);
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
    //Unable to remove aImport, as it must always have a dMMPackage
    if (!this.equals(aImport.getDMMPackage()))
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

  public void delete()
  {
    if (isSubpackageOf != null)
    {
      DMMPackage placeholderIsSubpackageOf = isSubpackageOf;
      this.isSubpackageOf = null;
      placeholderIsSubpackageOf.removeDMMPackage(this);
    }
    while( !dMMPackages.isEmpty() )
    {
      dMMPackages.get(0).setIsSubpackageOf(null);
    }
    for(int i=contain.size(); i > 0; i--)
    {
      Contains aContain = contain.get(i - 1);
      aContain.delete();
    }
    for(int i=imports.size(); i > 0; i--)
    {
      Imports aImport = imports.get(i - 1);
      aImport.delete();
    }
    super.delete();
  }

}