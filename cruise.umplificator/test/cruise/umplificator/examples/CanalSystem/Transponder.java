/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 64 "CanalSystem.ump"
// line 143 "CanalSystem.ump"
public class Transponder
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transponder Attributes
  private String id;

  //Transponder Associations
  private Craft craft;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transponder(String aId)
  {
    id = aId;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public Craft getCraft()
  {
    return craft;
  }

  public boolean hasCraft()
  {
    boolean has = craft != null;
    return has;
  }

  public boolean setCraft(Craft aNewCraft)
  {
    boolean wasSet = false;
    if (aNewCraft == null)
    {
      Craft existingCraft = craft;
      craft = null;
      
      if (existingCraft != null && existingCraft.getTransponder() != null)
      {
        existingCraft.setTransponder(null);
      }
      wasSet = true;
      return wasSet;
    }

    Craft currentCraft = getCraft();
    if (currentCraft != null && !currentCraft.equals(aNewCraft))
    {
      currentCraft.setTransponder(null);
    }

    craft = aNewCraft;
    Transponder existingTransponder = aNewCraft.getTransponder();

    if (!equals(existingTransponder))
    {
      aNewCraft.setTransponder(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (craft != null)
    {
      craft.setTransponder(null);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "craft = "+(getCraft()!=null?Integer.toHexString(System.identityHashCode(getCraft())):"null")
     + outputString;
  }
}