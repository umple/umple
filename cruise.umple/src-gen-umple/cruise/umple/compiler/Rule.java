/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents a rule, which has a name and contains definitions that describe it.
 * 
 * Examples of this are a class definition.
 */
public class Rule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Rule Attributes
  private String name;
  private boolean shouldHide;
  private List<String> definitions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Rule(String aName)
  {
    name = aName;
    shouldHide = false;
    definitions = new ArrayList<String>();
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

  public boolean setShouldHide(boolean aShouldHide)
  {
    boolean wasSet = false;
    shouldHide = aShouldHide;
    wasSet = true;
    return wasSet;
  }

  public boolean addDefinition(String aDefinition)
  {
    boolean wasAdded = false;
    wasAdded = definitions.add(aDefinition);
    return wasAdded;
  }

  public boolean removeDefinition(String aDefinition)
  {
    boolean wasRemoved = false;
    wasRemoved = definitions.remove(aDefinition);
    return wasRemoved;
  }

  /**
   * The name of the rule.
   */
  public String getName()
  {
    return name;
  }

  public boolean getShouldHide()
  {
    return shouldHide;
  }

  public String getDefinition(int index)
  {
    String aDefinition = definitions.get(index);
    return aDefinition;
  }

  public String[] getDefinitions()
  {
    String[] newDefinitions = definitions.toArray(new String[definitions.size()]);
    return newDefinitions;
  }

  public int numberOfDefinitions()
  {
    int number = definitions.size();
    return number;
  }

  public boolean hasDefinitions()
  {
    boolean has = definitions.size() > 0;
    return has;
  }

  public int indexOfDefinition(String aDefinition)
  {
    int index = definitions.indexOf(aDefinition);
    return index;
  }

  public boolean isShouldHide()
  {
    return shouldHide;
  }

  public void delete()
  {}

}