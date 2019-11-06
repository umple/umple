/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.direction;
import java.util.*;

// line 8 "../../../directionMutation_uModel_useFiles2.ump"
public class A
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //A Associations
  private List<C> cs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public A()
  {
    cs = new ArrayList<C>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public C getC(int index)
  {
    C aC = cs.get(index);
    return aC;
  }

  public List<C> getCs()
  {
    List<C> newCs = Collections.unmodifiableList(cs);
    return newCs;
  }

  public int numberOfCs()
  {
    int number = cs.size();
    return number;
  }

  public boolean hasCs()
  {
    boolean has = cs.size() > 0;
    return has;
  }

  public int indexOfC(C aC)
  {
    int index = cs.indexOf(aC);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public C addC()
  {
    return new C(this);
  }

  public boolean addC(C aC)
  {
    boolean wasAdded = false;
    A existingA = aC.getA();
    boolean isNewA = existingA != null && !this.equals(existingA);
    if (isNewA)
    {
      aC.setA(this);
    }
    else
    {
      cs.add(aC);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeC(C aC)
  {
    boolean wasRemoved = false;
    //Unable to remove aC, as it must always have a a
    if (!this.equals(aC.getA()))
    {
      cs.remove(aC);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCAt(C aC, int index)
  {  
    boolean wasAdded = false;
    if(addC(aC))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCs()) { index = numberOfCs() - 1; }
      cs.remove(aC);
      cs.add(index, aC);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCAt(C aC, int index)
  {
    boolean wasAdded = false;
    if(cs.contains(aC))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCs()) { index = numberOfCs() - 1; }
      cs.remove(aC);
      cs.add(index, aC);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCAt(aC, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=cs.size(); i > 0; i--)
    {
      C aC = cs.get(i - 1);
      aC.delete();
    }
  }

}