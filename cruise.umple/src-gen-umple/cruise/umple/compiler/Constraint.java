/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * The Constraint object related to Umple Classes
 * @umplesource Umple.ump 247
 * @umplesource Umple_Code.ump 1374
 */
// line 247 "../../../../src/Umple.ump"
// line 1374 "../../../../src/Umple_Code.ump"
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

  @umplesourcefile(line={1376},file={"Umple_Code.ump"},javaline={151},length={42})
   public String toString(){
    String out = "";
    if(numberOfExpressions()==1)
    {
      return getExpression(0).getValue();
    }
    else
    {
      List<ConstraintVariable> alreadyDone = new ArrayList<ConstraintVariable>();
      for(int m = 0; m < numberOfExpressions()-1; m++)
      {
        if(getExpression(m).getIsAttribute()&&!alreadyDone.contains(getExpression(m)))
        {
          alreadyDone.add(getExpression(m));
      	  out += getExpression(m).getValue()+", ";
      	}
      }
      boolean onlyOne = false;
      if(getExpression(numberOfExpressions()-1).getIsAttribute()&&!alreadyDone.contains(getExpression(numberOfExpressions()-1)))
      {
        if(alreadyDone.size()==1)
      	{
      	  out = out.substring(0,out.length()-2);
      	} 
      	if(alreadyDone.size()>0)
      	{
      	  out += " and " ;
      	}	
      	else
      	{
      	  onlyOne = true;
      	}
       	out += getExpression(numberOfExpressions()-1).getValue();
       	alreadyDone.add(getExpression(numberOfExpressions()-1));
      }  
      if(alreadyDone.size()==1 && !onlyOne)
      {
        out = out.substring(0,out.length()-2);
      } 
    }      
    return out;
  }

  @umplesourcefile(line={1420},file={"Umple_Code.ump"},javaline={195},length={23})
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

  @umplesourcefile(line={1444},file={"Umple_Code.ump"},javaline={220},length={3})
  public String getCode(){
    return StringFormatter.format(gen.translate((getNegated()?"Not":"")+format,this),inject);
  }

  @umplesourcefile(line={1448},file={"Umple_Code.ump"},javaline={225},length={23})
   public boolean equals(Object object){
    if(object==null)
    {
      return false;
    }
    else
    {
      Constraint constraint = (Constraint)object;
      int size = constraint.numberOfExpressions();
      if(numberOfExpressions()!=size)
      {
        return false;
      }
      for(int i=0;i<size;i++)
      {
        if(!getExpression(i).equals(constraint.getExpression(i)))
        {
          return false;
        }
      }
    }
    return true;
  }

}