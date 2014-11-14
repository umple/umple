/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 132 "DMMModelElementHierarchy.ump"
// line 281 "DMMModelElementHierarchy.ump"
public class Imports
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Imports Associations
  private DMMPackage dMMPackage;
  private DMMClass dMMClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Imports(DMMPackage aDMMPackage, DMMClass aDMMClass)
  {
    boolean didAddDMMPackage = setDMMPackage(aDMMPackage);
    if (!didAddDMMPackage)
    {
      throw new RuntimeException("Unable to create import due to dMMPackage");
    }
    boolean didAddDMMClass = setDMMClass(aDMMClass);
    if (!didAddDMMClass)
    {
      throw new RuntimeException("Unable to create import due to dMMClass");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public DMMPackage getDMMPackage()
  {
    return dMMPackage;
  }

  public DMMClass getDMMClass()
  {
    return dMMClass;
  }

  public boolean setDMMPackage(DMMPackage aDMMPackage)
  {
    boolean wasSet = false;
    if (aDMMPackage == null)
    {
      return wasSet;
    }

    DMMPackage existingDMMPackage = dMMPackage;
    dMMPackage = aDMMPackage;
    if (existingDMMPackage != null && !existingDMMPackage.equals(aDMMPackage))
    {
      existingDMMPackage.removeImport(this);
    }
    dMMPackage.addImport(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setDMMClass(DMMClass aDMMClass)
  {
    boolean wasSet = false;
    if (aDMMClass == null)
    {
      return wasSet;
    }

    DMMClass existingDMMClass = dMMClass;
    dMMClass = aDMMClass;
    if (existingDMMClass != null && !existingDMMClass.equals(aDMMClass))
    {
      existingDMMClass.removeImport(this);
    }
    dMMClass.addImport(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DMMPackage placeholderDMMPackage = dMMPackage;
    this.dMMPackage = null;
    placeholderDMMPackage.removeImport(this);
    DMMClass placeholderDMMClass = dMMClass;
    this.dMMClass = null;
    placeholderDMMClass.removeImport(this);
  }

}