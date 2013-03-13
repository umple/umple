/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents a interface.
 * Like a class, but can't have any concrete methods, attributes or associations.
 * @umplesource Umple.ump 310
 * @umplesource Umple_Code.ump 558
 */
// line 310 "../../../../src/Umple.ump"
// line 558 "../../../../src/Umple_Code.ump"
public class UmpleInterface extends UmpleClassifier
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleInterface Associations
  private List<UmpleInterface> extendsInterface;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleInterface(String aName)
  {
    super(aName);
    extendsInterface = new ArrayList<UmpleInterface>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public UmpleInterface getExtendsInterface(int index)
  {
    UmpleInterface aExtendsInterface = extendsInterface.get(index);
    return aExtendsInterface;
  }

  public List<UmpleInterface> getExtendsInterface()
  {
    List<UmpleInterface> newExtendsInterface = Collections.unmodifiableList(extendsInterface);
    return newExtendsInterface;
  }

  public int numberOfExtendsInterface()
  {
    int number = extendsInterface.size();
    return number;
  }

  public boolean hasExtendsInterface()
  {
    boolean has = extendsInterface.size() > 0;
    return has;
  }

  public int indexOfExtendsInterface(UmpleInterface aExtendsInterface)
  {
    int index = extendsInterface.indexOf(aExtendsInterface);
    return index;
  }

  public static int minimumNumberOfExtendsInterface()
  {
    return 0;
  }

  public boolean addExtendsInterface(UmpleInterface aExtendsInterface)
  {
    boolean wasAdded = false;
    if (extendsInterface.contains(aExtendsInterface)) { return false; }
    extendsInterface.add(aExtendsInterface);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExtendsInterface(UmpleInterface aExtendsInterface)
  {
    boolean wasRemoved = false;
    if (extendsInterface.contains(aExtendsInterface))
    {
      extendsInterface.remove(aExtendsInterface);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addExtendsInterfaceAt(UmpleInterface aExtendsInterface, int index)
  {  
    boolean wasAdded = false;
    if(addExtendsInterface(aExtendsInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExtendsInterface()) { index = numberOfExtendsInterface() - 1; }
      extendsInterface.remove(aExtendsInterface);
      extendsInterface.add(index, aExtendsInterface);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExtendsInterfaceAt(UmpleInterface aExtendsInterface, int index)
  {
    boolean wasAdded = false;
    if(extendsInterface.contains(aExtendsInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExtendsInterface()) { index = numberOfExtendsInterface() - 1; }
      extendsInterface.remove(aExtendsInterface);
      extendsInterface.add(index, aExtendsInterface);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExtendsInterfaceAt(aExtendsInterface, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    extendsInterface.clear();
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 560 ../../../../src/Umple_Code.ump
  public boolean hasMethod(Method comparedMethod){
    boolean isMethod=false;
    String methodName = comparedMethod.getName();
    int numberOfParams = comparedMethod.getMethodParameters().size();
    for (Method aMethod : this.getMethods()){
      // Compare method names
      if (aMethod.getName().equals(methodName)){  
        // Now compare parameters
        if (numberOfParams == aMethod.getMethodParameters().size()){
          for (MethodParameter param: aMethod.getMethodParameters()){
            for (MethodParameter paramToCompare: comparedMethod.getMethodParameters()){
              if (param.getType().equals(paramToCompare.getType())){
                isMethod=true;        
              }
              else{
                return false;
              }
            }
          }
        }
      }
    }
    return isMethod;  
  }
}