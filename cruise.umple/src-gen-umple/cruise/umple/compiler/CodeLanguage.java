/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;

// line 209 "../../../../src/Umple.ump"
public class CodeLanguage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeLanguage Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeLanguage(String aName)
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

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 212 ../../../../src/Umple.ump
  public boolean equals(Object O)
	{
		return name.equals(((CodeLanguage)O).getName());
	}
}