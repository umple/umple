/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents a interface.
 * Like a class, but can't have any concrete methods, attributes or associations.
 * 
 * @umplesource Umple.ump 346
 * @umplesource Umple_Code.ump 636
 */
// line 346 "../../../../src/Umple.ump"
// line 636 "../../../../src/Umple_Code.ump"
public class UmpleInterface extends UmpleClassifier
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={640},file={"Umple_Code.ump"},javaline={137},length={24})
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