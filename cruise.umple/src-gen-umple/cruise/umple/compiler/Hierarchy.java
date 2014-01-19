/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Used to persist hirarchy information for given elemnts (owner, and children)
 * Used to persist hirarchy information for given elemnts (owner, and children)
 * @umplesource Generator_UmpleModelWalker.ump 50
 */
// line 50 "../../../../src/Generator_UmpleModelWalker.ump"
public class Hierarchy
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hierarchy Attributes
  private UmpleClassifier element;

  //Hierarchy Associations
  private UmpleClass parentClass;
  private List<UmpleInterface> parentInterfaces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hierarchy(UmpleClassifier aElement)
  {
    element = aElement;
    parentInterfaces = new ArrayList<UmpleInterface>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setElement(UmpleClassifier aElement)
  {
    boolean wasSet = false;
    element = aElement;
    wasSet = true;
    return wasSet;
  }

  public UmpleClassifier getElement()
  {
    return element;
  }

  public UmpleClass getParentClass()
  {
    return parentClass;
  }

  public UmpleInterface getParentInterface(int index)
  {
    UmpleInterface aParentInterface = parentInterfaces.get(index);
    return aParentInterface;
  }

  public List<UmpleInterface> getParentInterfaces()
  {
    List<UmpleInterface> newParentInterfaces = Collections.unmodifiableList(parentInterfaces);
    return newParentInterfaces;
  }

  public int numberOfParentInterfaces()
  {
    int number = parentInterfaces.size();
    return number;
  }

  public boolean hasParentInterfaces()
  {
    boolean has = parentInterfaces.size() > 0;
    return has;
  }

  public int indexOfParentInterface(UmpleInterface aParentInterface)
  {
    int index = parentInterfaces.indexOf(aParentInterface);
    return index;
  }

  public boolean setParentClass(UmpleClass aNewParentClass)
  {
    boolean wasSet = false;
    parentClass = aNewParentClass;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfParentInterfaces()
  {
    return 0;
  }

  public boolean addParentInterface(UmpleInterface aParentInterface)
  {
    boolean wasAdded = false;
    if (parentInterfaces.contains(aParentInterface)) { return false; }
    parentInterfaces.add(aParentInterface);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParentInterface(UmpleInterface aParentInterface)
  {
    boolean wasRemoved = false;
    if (parentInterfaces.contains(aParentInterface))
    {
      parentInterfaces.remove(aParentInterface);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addParentInterfaceAt(UmpleInterface aParentInterface, int index)
  {  
    boolean wasAdded = false;
    if(addParentInterface(aParentInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParentInterfaces()) { index = numberOfParentInterfaces() - 1; }
      parentInterfaces.remove(aParentInterface);
      parentInterfaces.add(index, aParentInterface);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParentInterfaceAt(UmpleInterface aParentInterface, int index)
  {
    boolean wasAdded = false;
    if(parentInterfaces.contains(aParentInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParentInterfaces()) { index = numberOfParentInterfaces() - 1; }
      parentInterfaces.remove(aParentInterface);
      parentInterfaces.add(index, aParentInterface);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParentInterfaceAt(aParentInterface, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    parentClass = null;
    parentInterfaces.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "element" + "=" + (getElement() != null ? !getElement().equals(this)  ? getElement().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parentClass = "+(getParentClass()!=null?Integer.toHexString(System.identityHashCode(getParentClass())):"null")
     + outputString;
  }
}