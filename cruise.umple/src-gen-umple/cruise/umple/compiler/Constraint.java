/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * The Constraint object related to Umple Classes
 * @umplesource Umple.ump 267
 */
// line 267 "../../../../src/Umple.ump"
public class Constraint extends CodeBlock
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Constraint Attributes
  private String format;
  private String inject;
  private CodeTranslator gen;
  private boolean negated;
  private List<ConstraintVariable> expressions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Constraint()
  {
    super();
    format = "allParameterClosed";
    inject = "";
    gen = null;
    negated = false;
    expressions = new ArrayList<ConstraintVariable>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFormat(String aFormat)
  {
    boolean wasSet = false;
    format = aFormat;
    wasSet = true;
    return wasSet;
  }

  public boolean setInject(String aInject)
  {
    boolean wasSet = false;
    inject = aInject;
    wasSet = true;
    return wasSet;
  }

  public boolean setGen(CodeTranslator aGen)
  {
    boolean wasSet = false;
    gen = aGen;
    wasSet = true;
    return wasSet;
  }

  public boolean setNegated(boolean aNegated)
  {
    boolean wasSet = false;
    negated = aNegated;
    wasSet = true;
    return wasSet;
  }

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

  public String getFormat()
  {
    return format;
  }

  public String getInject()
  {
    return inject;
  }

  public CodeTranslator getGen()
  {
    return gen;
  }

  public boolean getNegated()
  {
    return negated;
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
  {
    super.delete();
  }

  @umplesourcefile(line={276},file={"Umple.ump"},javaline={149},length={23})
  public void mergeWith(Constraint constraint){
    if(numberOfExpressions()>0)
    {
      if(getNegated()&&!constraint.getNegated())
      {
        addExpression(new ConstraintVariable("OPERATOR","||"));
      }
      else 
      {
        addExpression(new ConstraintVariable("OPERATOR","&&"));
      }
    }
    if(constraint.getNegated())
    {
      addExpression(new ConstraintVariable("OPERATOR","!"));
    }  
    addExpression(new ConstraintVariable("SYNTAX","("));
    for(ConstraintVariable cv: constraint.getExpressions())
    {
      addExpression(cv);
    }
    addExpression(new ConstraintVariable("SYNTAX",")"));
  }

  @umplesourcefile(line={300},file={"Umple.ump"},javaline={174},length={3})
  public String getCode(){
    return StringFormatter.format(gen.translate((getNegated()?"Not":"")+format,this),inject);
  }

}