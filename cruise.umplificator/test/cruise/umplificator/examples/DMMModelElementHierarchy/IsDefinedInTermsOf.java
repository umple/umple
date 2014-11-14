/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 53 "DMMModelElementHierarchy.ump"
// line 289 "DMMModelElementHierarchy.ump"
public class IsDefinedInTermsOf
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IsDefinedInTermsOf Associations
  private Type definedBy;
  private Type definesBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IsDefinedInTermsOf(Type aDefinedBy, Type aDefinesBy)
  {
    boolean didAddDefinedBy = setDefinedBy(aDefinedBy);
    if (!didAddDefinedBy)
    {
      throw new RuntimeException("Unable to create definesBy due to definedBy");
    }
    boolean didAddDefinesBy = setDefinesBy(aDefinesBy);
    if (!didAddDefinesBy)
    {
      throw new RuntimeException("Unable to create definedBy due to definesBy");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Type getDefinedBy()
  {
    return definedBy;
  }

  public Type getDefinesBy()
  {
    return definesBy;
  }

  public boolean setDefinedBy(Type aDefinedBy)
  {
    boolean wasSet = false;
    if (aDefinedBy == null)
    {
      return wasSet;
    }

    Type existingDefinedBy = definedBy;
    definedBy = aDefinedBy;
    if (existingDefinedBy != null && !existingDefinedBy.equals(aDefinedBy))
    {
      existingDefinedBy.removeDefinesBy(this);
    }
    definedBy.addDefinesBy(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setDefinesBy(Type aDefinesBy)
  {
    boolean wasSet = false;
    if (aDefinesBy == null)
    {
      return wasSet;
    }

    Type existingDefinesBy = definesBy;
    definesBy = aDefinesBy;
    if (existingDefinesBy != null && !existingDefinesBy.equals(aDefinesBy))
    {
      existingDefinesBy.removeDefinedBy(this);
    }
    definesBy.addDefinedBy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Type placeholderDefinedBy = definedBy;
    this.definedBy = null;
    placeholderDefinedBy.removeDefinesBy(this);
    Type placeholderDefinesBy = definesBy;
    this.definesBy = null;
    placeholderDefinesBy.removeDefinedBy(this);
  }

}