/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;

// line 113 "../../../src/TestHarnessAssociations.ump"
public class MentorH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorH Attributes
  private String name;

  //MentorH Associations
  private MentorH superMentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorH(String aName)
  {
    name = aName;
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

  public MentorH getSuperMentor()
  {
    return superMentor;
  }

  public boolean setSuperMentor(MentorH newSuperMentor)
  {
    boolean wasSet = false;
    if (newSuperMentor == null)
    {
      MentorH existingSuperMentor = superMentor;
      superMentor = null;
      
      if (existingSuperMentor != null && existingSuperMentor.getSuperMentor() != null)
      {
        existingSuperMentor.setSuperMentor(null);
      }
      wasSet = true;
      return wasSet;
    }

    MentorH currentSuperMentor = getSuperMentor();
    if (currentSuperMentor != null && !currentSuperMentor.equals(newSuperMentor))
    {
      currentSuperMentor.setSuperMentor(null);
    }

    superMentor = newSuperMentor;
    MentorH existingSuperMentor = newSuperMentor.getSuperMentor();

    if (!equals(existingSuperMentor))
    {
      newSuperMentor.setSuperMentor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (superMentor != null)
    {
      superMentor.setSuperMentor(null);
    }
  }

}