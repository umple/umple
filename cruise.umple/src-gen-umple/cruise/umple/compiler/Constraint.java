/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Under Development
 * The Constraint object related to Umple Classes
 */
// line 204 "../../../../src/Umple.ump"
public class Constraint
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Constraint Attributes
  private String constrainedVariable;
  private List<String> expression;
  private List<String> type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Constraint(String aConstrainedVariable)
  {
    constrainedVariable = aConstrainedVariable;
    expression = new ArrayList<String>();
    type = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setConstrainedVariable(String aConstrainedVariable)
  {
    boolean wasSet = false;
    constrainedVariable = aConstrainedVariable;
    wasSet = true;
    return wasSet;
  }

  public boolean addExpression(String aExpression)
  {
    boolean wasAdded = false;
    wasAdded = expression.add(aExpression);
    return wasAdded;
  }

  public boolean removeExpression(String aExpression)
  {
    boolean wasRemoved = false;
    wasRemoved = expression.remove(aExpression);
    return wasRemoved;
  }

  public boolean addType(String aType)
  {
    boolean wasAdded = false;
    wasAdded = type.add(aType);
    return wasAdded;
  }

  public boolean removeType(String aType)
  {
    boolean wasRemoved = false;
    wasRemoved = type.remove(aType);
    return wasRemoved;
  }

  public String getConstrainedVariable()
  {
    return constrainedVariable;
  }

  public String getExpression(int index)
  {
    String aExpression = expression.get(index);
    return aExpression;
  }

  public String[] getExpression()
  {
    String[] newExpression = expression.toArray(new String[expression.size()]);
    return newExpression;
  }

  public int numberOfExpression()
  {
    int number = expression.size();
    return number;
  }

  public boolean hasExpression()
  {
    boolean has = expression.size() > 0;
    return has;
  }

  public int indexOfExpression(String aExpression)
  {
    int index = expression.indexOf(aExpression);
    return index;
  }

  public String getType(int index)
  {
    String aType = type.get(index);
    return aType;
  }

  public String[] getType()
  {
    String[] newType = type.toArray(new String[type.size()]);
    return newType;
  }

  public int numberOfType()
  {
    int number = type.size();
    return number;
  }

  public boolean hasType()
  {
    boolean has = type.size() > 0;
    return has;
  }

  public int indexOfType(String aType)
  {
    int index = type.indexOf(aType);
    return index;
  }

  public void delete()
  {}

}