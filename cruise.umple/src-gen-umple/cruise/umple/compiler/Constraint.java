/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * The Constraint object related to Umple Classes
 * @umplesource Umple.ump 253
 */
// line 253 "../../../../src/Umple.ump"
public class Constraint
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Constraint Attributes
  private List<ConstraintVariable> expressions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Constraint()
  {
    expressions = new ArrayList<ConstraintVariable>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addExpression(ConstraintVariable aExpression)
  {
    boolean wasAdded = false;
    wasAdded = expressions.add(aExpression);
    return wasAdded;
  }

  public boolean removeExpression(ConstraintVariable aExpression)
  {
    boolean wasRemoved = false;
    wasRemoved = expressions.remove(aExpression);
    return wasRemoved;
  }

  public ConstraintVariable getExpression(int index)
  {
    ConstraintVariable aExpression = expressions.get(index);
    return aExpression;
  }

  public ConstraintVariable[] getExpressions()
  {
    ConstraintVariable[] newExpressions = expressions.toArray(new ConstraintVariable[expressions.size()]);
    return newExpressions;
  }

  public int numberOfExpressions()
  {
    int number = expressions.size();
    return number;
  }

  public boolean hasExpressions()
  {
    boolean has = expressions.size() > 0;
    return has;
  }

  public int indexOfExpression(ConstraintVariable aExpression)
  {
    int index = expressions.indexOf(aExpression);
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