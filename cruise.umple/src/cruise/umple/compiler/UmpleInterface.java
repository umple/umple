/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class UmpleInterface extends UmpleElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleInterface Attributes
  private List<String> namespaces;
  private String packageName;
  private String extraCode;

  //UmpleInterface Associations
  private List<Method> methods;
  private List<Depend> depends;
  private List<Constant> constants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleInterface(String aName)
  {
    super(aName);
    namespaces = new ArrayList<String>();
    packageName = "";
    extraCode = "";
    methods = new ArrayList<Method>();
    depends = new ArrayList<Depend>();
    constants = new ArrayList<Constant>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean addNamespace(String aNamespace)
  {
    boolean wasAdded = false;
    wasAdded = namespaces.add(aNamespace);
    return wasAdded;
  }

  public boolean removeNamespace(String aNamespace)
  {
    boolean wasRemoved = false;
    wasRemoved = namespaces.remove(aNamespace);
    return wasRemoved;
  }

  public boolean setPackageName(String aPackageName)
  {
    boolean wasSet = false;
    if (aPackageName == null) { return false; }
    packageName = aPackageName;
    wasSet = true;
    return wasSet;
  }

  public boolean setExtraCode(String aExtraCode)
  {
    boolean wasSet = false;
    extraCode = aExtraCode;
    wasSet = true;
    return wasSet;
  }

  public String getNamespace(int index)
  {
    String aNamespace = namespaces.get(index);
    return aNamespace;
  }

  public String[] getNamespaces()
  {
    String[] newNamespaces = namespaces.toArray(new String[namespaces.size()]);
    return newNamespaces;
  }

  public int numberOfNamespaces()
  {
    int number = namespaces.size();
    return number;
  }

  public boolean hasNamespaces()
  {
    boolean has = namespaces.size() > 0;
    return has;
  }

  public int indexOfNamespace(String aNamespace)
  {
    int index = namespaces.indexOf(aNamespace);
    return index;
  }

  public String getPackageName()
  {
    return packageName;
  }

  public String getExtraCode()
  {
    return extraCode;
  }

  public Method getMethod(int index)
  {
    Method aMethod = methods.get(index);
    return aMethod;
  }

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

  public static int minimumNumberOfDepends()
  {
    return 0;
  }

  public boolean addDepend(Depend aDepend)
  {
    boolean wasAdded = false;
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

  public void delete()
  {
    methods.clear();
    depends.clear();
    constants.clear();
    super.delete();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public boolean hasMethod(Method comparedMethod){
	  String methodName = comparedMethod.getName();
	  int numberOfParams = comparedMethod.getMethodParameters().size();
	  for (Method aMethod : this.getMethods()){
		  if (aMethod.getName().equals(methodName)){
			  if (numberOfParams == aMethod.getMethodParameters().size()){
				  return true;				  
			  }
		  }
	  }
	  return false;  
  }

 protected GeneratedInterface gInterface = null;
  public GeneratedInterface getGeneratedInterface()
  {
    return gInterface;
  }

  public GeneratedInterface createGeneratedInterface(UmpleModel model)
  {
    gInterface = new GeneratedInterface(model, this);
    return getGeneratedInterface();
  }
}