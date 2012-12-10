/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents an Umple interface.
 */
// line 224 "../../../../src/Umple.ump"
// line 426 "../../../../src/Umple_Code.ump"
public class UmpleInterface extends UmpleElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleInterface Associations
  private List<UmpleInterface> extendsInterface;
  private List<Method> methods;
  private List<Depend> depends;
  private List<Constant> constants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleInterface(String aName)
  {
    super(aName);
    extendsInterface = new ArrayList<UmpleInterface>();
    methods = new ArrayList<Method>();
    depends = new ArrayList<Depend>();
    constants = new ArrayList<Constant>();
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

  public Method getMethod(int index)
  {
    Method aMethod = methods.get(index);
    return aMethod;
  }

  /**
   * The methods contained within the Umple interface.
   */
  public List<Method> getMethods()
  {
    List<Method> newMethods = Collections.unmodifiableList(methods);
    return newMethods;
  }

  public int numberOfMethods()
  {
    int number = methods.size();
    return number;
  }

  public boolean hasMethods()
  {
    boolean has = methods.size() > 0;
    return has;
  }

  public int indexOfMethod(Method aMethod)
  {
    int index = methods.indexOf(aMethod);
    return index;
  }

  public Depend getDepend(int index)
  {
    Depend aDepend = depends.get(index);
    return aDepend;
  }

  public List<Depend> getDepends()
  {
    List<Depend> newDepends = Collections.unmodifiableList(depends);
    return newDepends;
  }

  public int numberOfDepends()
  {
    int number = depends.size();
    return number;
  }

  public boolean hasDepends()
  {
    boolean has = depends.size() > 0;
    return has;
  }

  public int indexOfDepend(Depend aDepend)
  {
    int index = depends.indexOf(aDepend);
    return index;
  }

  public Constant getConstant(int index)
  {
    Constant aConstant = constants.get(index);
    return aConstant;
  }

  /**
   * The constants contained within the Umple interface.
   */
  public List<Constant> getConstants()
  {
    List<Constant> newConstants = Collections.unmodifiableList(constants);
    return newConstants;
  }

  public int numberOfConstants()
  {
    int number = constants.size();
    return number;
  }

  public boolean hasConstants()
  {
    boolean has = constants.size() > 0;
    return has;
  }

  public int indexOfConstant(Constant aConstant)
  {
    int index = constants.indexOf(aConstant);
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

  public static int minimumNumberOfMethods()
  {
    return 0;
  }

  public boolean addMethod(Method aMethod)
  {
    boolean wasAdded = false;
    if (methods.contains(aMethod)) { return false; }
    methods.add(aMethod);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMethod(Method aMethod)
  {
    boolean wasRemoved = false;
    if (methods.contains(aMethod))
    {
      methods.remove(aMethod);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addMethodAt(Method aMethod, int index)
  {  
    boolean wasAdded = false;
    if(addMethod(aMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethods()) { index = numberOfMethods() - 1; }
      methods.remove(aMethod);
      methods.add(index, aMethod);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMethodAt(Method aMethod, int index)
  {
    boolean wasAdded = false;
    if(methods.contains(aMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethods()) { index = numberOfMethods() - 1; }
      methods.remove(aMethod);
      methods.add(index, aMethod);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMethodAt(aMethod, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfDepends()
  {
    return 0;
  }

  public boolean addDepend(Depend aDepend)
  {
    boolean wasAdded = false;
    // line 239 "../../../../src/Umple.ump"
    if (depends.contains(aDepend)) { return false; }
    if (depends.contains(aDepend)) { return false; }
    depends.add(aDepend);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDepend(Depend aDepend)
  {
    boolean wasRemoved = false;
    if (depends.contains(aDepend))
    {
      depends.remove(aDepend);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addDependAt(Depend aDepend, int index)
  {  
    boolean wasAdded = false;
    if(addDepend(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDependAt(Depend aDepend, int index)
  {
    boolean wasAdded = false;
    if(depends.contains(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDependAt(aDepend, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfConstants()
  {
    return 0;
  }

  public boolean addConstant(Constant aConstant)
  {
    boolean wasAdded = false;
    if (constants.contains(aConstant)) { return false; }
    constants.add(aConstant);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConstant(Constant aConstant)
  {
    boolean wasRemoved = false;
    if (constants.contains(aConstant))
    {
      constants.remove(aConstant);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addConstantAt(Constant aConstant, int index)
  {  
    boolean wasAdded = false;
    if(addConstant(aConstant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConstants()) { index = numberOfConstants() - 1; }
      constants.remove(aConstant);
      constants.add(index, aConstant);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConstantAt(Constant aConstant, int index)
  {
    boolean wasAdded = false;
    if(constants.contains(aConstant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConstants()) { index = numberOfConstants() - 1; }
      constants.remove(aConstant);
      constants.add(index, aConstant);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConstantAt(aConstant, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    extendsInterface.clear();
    methods.clear();
    depends.clear();
    constants.clear();
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 428 ../../../../src/Umple_Code.ump
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