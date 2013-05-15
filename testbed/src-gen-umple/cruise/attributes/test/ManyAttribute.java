/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;
import java.util.*;

// line 51 "../../../../src/TestHarnessAttributes.ump"
public class ManyAttribute
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ManyAttribute Attributes
  private List<Integer> works;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ManyAttribute()
  {
    works = new ArrayList<Integer>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addWork(Integer aWork)
  {
    boolean wasAdded = false;
    wasAdded = works.add(aWork);
    return wasAdded;
  }

  public boolean removeWork(Integer aWork)
  {
    boolean wasRemoved = false;
    wasRemoved = works.remove(aWork);
    return wasRemoved;
  }

  public Integer getWork(int index)
  {
    Integer aWork = works.get(index);
    return aWork;
  }

  public Integer[] getWorks()
  {
    Integer[] newWorks = works.toArray(new Integer[works.size()]);
    return newWorks;
  }

  public int numberOfWorks()
  {
    int number = works.size();
    return number;
  }

  public boolean hasWorks()
  {
    boolean has = works.size() > 0;
    return has;
  }

  public int indexOfWork(Integer aWork)
  {
    int index = works.indexOf(aWork);
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