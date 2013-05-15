/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * TO DO: Determine if this can be deleted
 * @umplesource Umple.ump 138
 */
// line 138 "../../../../src/Umple.ump"
public class Modifier
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Modifier Attributes
  private List<String> name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Modifier()
  {
    name = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addName(String aName)
  {
    boolean wasAdded = false;
    wasAdded = name.add(aName);
    return wasAdded;
  }

  public boolean removeName(String aName)
  {
    boolean wasRemoved = false;
    wasRemoved = name.remove(aName);
    return wasRemoved;
  }

  public String getName(int index)
  {
    String aName = name.get(index);
    return aName;
  }

  public String[] getName()
  {
    String[] newName = name.toArray(new String[name.size()]);
    return newName;
  }

  public int numberOfName()
  {
    int number = name.size();
    return number;
  }

  public boolean hasName()
  {
    boolean has = name.size() > 0;
    return has;
  }

  public int indexOfName(String aName)
  {
    int index = name.indexOf(aName);
    return index;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]"
     + outputString;
  }
}