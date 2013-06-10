/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Violet.ump 42
 */
// line 42 "../../../../src/Violet.ump"
public class VioletAssociation
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VioletAssociation Attributes
  private String startLabel;
  private String endLabel;

  //VioletAssociation Associations
  private List<VioletClass> violetClasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VioletAssociation(String aStartLabel, String aEndLabel, VioletClass... allVioletClasses)
  {
    startLabel = aStartLabel;
    endLabel = aEndLabel;
    violetClasses = new ArrayList<VioletClass>();
    boolean didAddVioletClasses = setVioletClasses(allVioletClasses);
    if (!didAddVioletClasses)
    {
      throw new RuntimeException("Unable to create VioletAssociation, must have 1 to 2 violetClasses");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartLabel(String aStartLabel)
  {
    boolean wasSet = false;
    startLabel = aStartLabel;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndLabel(String aEndLabel)
  {
    boolean wasSet = false;
    endLabel = aEndLabel;
    wasSet = true;
    return wasSet;
  }

  public String getStartLabel()
  {
    return startLabel;
  }

  public String getEndLabel()
  {
    return endLabel;
  }

  public VioletClass getVioletClass(int index)
  {
    VioletClass aVioletClass = violetClasses.get(index);
    return aVioletClass;
  }

  public List<VioletClass> getVioletClasses()
  {
    List<VioletClass> newVioletClasses = Collections.unmodifiableList(violetClasses);
    return newVioletClasses;
  }

  public int numberOfVioletClasses()
  {
    int number = violetClasses.size();
    return number;
  }

  public boolean hasVioletClasses()
  {
    boolean has = violetClasses.size() > 0;
    return has;
  }

  public int indexOfVioletClass(VioletClass aVioletClass)
  {
    int index = violetClasses.indexOf(aVioletClass);
    return index;
  }

  public static int minimumNumberOfVioletClasses()
  {
    return 1;
  }

  public static int maximumNumberOfVioletClasses()
  {
    return 2;
  }

  public boolean addVioletClass(VioletClass aVioletClass)
  {
    boolean wasAdded = false;
    if (violetClasses.contains(aVioletClass)) { return false; }
    if (numberOfVioletClasses() < maximumNumberOfVioletClasses())
    {
      violetClasses.add(aVioletClass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeVioletClass(VioletClass aVioletClass)
  {
    boolean wasRemoved = false;
    if (!violetClasses.contains(aVioletClass))
    {
      return wasRemoved;
    }

    if (numberOfVioletClasses() <= minimumNumberOfVioletClasses())
    {
      return wasRemoved;
    }

    violetClasses.remove(aVioletClass);
    wasRemoved = true;
    return wasRemoved;
  }

  public boolean setVioletClasses(VioletClass... newVioletClasses)
  {
    boolean wasSet = false;
    ArrayList<VioletClass> verifiedVioletClasses = new ArrayList<VioletClass>();
    for (VioletClass aVioletClass : newVioletClasses)
    {
      if (verifiedVioletClasses.contains(aVioletClass))
      {
        continue;
      }
      verifiedVioletClasses.add(aVioletClass);
    }

    if (verifiedVioletClasses.size() != newVioletClasses.length || verifiedVioletClasses.size() < minimumNumberOfVioletClasses() || verifiedVioletClasses.size() > maximumNumberOfVioletClasses())
    {
      return wasSet;
    }

    violetClasses.clear();
    violetClasses.addAll(verifiedVioletClasses);
    wasSet = true;
    return wasSet;
  }

  public boolean addVioletClassAt(VioletClass aVioletClass, int index)
  {  
    boolean wasAdded = false;
    if(addVioletClass(aVioletClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletClasses()) { index = numberOfVioletClasses() - 1; }
      violetClasses.remove(aVioletClass);
      violetClasses.add(index, aVioletClass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVioletClassAt(VioletClass aVioletClass, int index)
  {
    boolean wasAdded = false;
    if(violetClasses.contains(aVioletClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletClasses()) { index = numberOfVioletClasses() - 1; }
      violetClasses.remove(aVioletClass);
      violetClasses.add(index, aVioletClass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVioletClassAt(aVioletClass, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    violetClasses.clear();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "startLabel" + ":" + getStartLabel()+ "," +
            "endLabel" + ":" + getEndLabel()+ "]"
     + outputString;
  }
}