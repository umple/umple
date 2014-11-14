/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 29 "DMMModelElementHierarchy.ump"
// line 260 "DMMModelElementHierarchy.ump"
public class Invokes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Invokes Associations
  private BehaviouralElement invokes;
  private BehaviouralElement invoked;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Invokes(BehaviouralElement aInvokes, BehaviouralElement aInvoked)
  {
    boolean didAddInvokes = setInvokes(aInvokes);
    if (!didAddInvokes)
    {
      throw new RuntimeException("Unable to create invoked due to invokes");
    }
    boolean didAddInvoked = setInvoked(aInvoked);
    if (!didAddInvoked)
    {
      throw new RuntimeException("Unable to create invoke due to invoked");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BehaviouralElement getInvokes()
  {
    return invokes;
  }

  public BehaviouralElement getInvoked()
  {
    return invoked;
  }

  public boolean setInvokes(BehaviouralElement aInvokes)
  {
    boolean wasSet = false;
    if (aInvokes == null)
    {
      return wasSet;
    }

    BehaviouralElement existingInvokes = invokes;
    invokes = aInvokes;
    if (existingInvokes != null && !existingInvokes.equals(aInvokes))
    {
      existingInvokes.removeInvoked(this);
    }
    invokes.addInvoked(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setInvoked(BehaviouralElement aInvoked)
  {
    boolean wasSet = false;
    if (aInvoked == null)
    {
      return wasSet;
    }

    BehaviouralElement existingInvoked = invoked;
    invoked = aInvoked;
    if (existingInvoked != null && !existingInvoked.equals(aInvoked))
    {
      existingInvoked.removeInvoke(this);
    }
    invoked.addInvoke(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BehaviouralElement placeholderInvokes = invokes;
    this.invokes = null;
    placeholderInvokes.removeInvoked(this);
    BehaviouralElement placeholderInvoked = invoked;
    this.invoked = null;
    placeholderInvoked.removeInvoke(this);
  }

}