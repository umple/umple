/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

public class UmpleClass extends UmpleElement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleClass Attributes
  private boolean isSingleton;
  private List<String> namespaces;
  private String modifier;
  private List<Association> associations;
  private Key key;
  private String extraCode;
  private String packageName;

  //UmpleClass Associations
  private List<CodeInjection> codeInjections;
  private UmpleClass extendsClass;
  private List<UmpleInterface> parentInterface;
  private List<Depend> depends;
  private List<Method> methods;
  private List<Constant> constants;
  private UniqueIdentifier uniqueIdentifier;
  private List<Attribute> attributes;
  private List<AssociationVariable> associationVariables;
  private List<StateMachine> stateMachines;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleClass(String aName)
  {
    super(aName);
    isSingleton = false;
    namespaces = new ArrayList<String>();
    modifier = "class";
    associations = new ArrayList<Association>();
    key = new Key();
    extraCode = "";
    packageName = "";
    codeInjections = new ArrayList<CodeInjection>();
    parentInterface = new ArrayList<UmpleInterface>();
    depends = new ArrayList<Depend>();
    methods = new ArrayList<Method>();
    constants = new ArrayList<Constant>();
    attributes = new ArrayList<Attribute>();
    associationVariables = new ArrayList<AssociationVariable>();
    stateMachines = new ArrayList<StateMachine>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsSingleton(boolean aIsSingleton)
  {
    boolean wasSet = false;
    isSingleton = aIsSingleton;
    wasSet = true;
    return wasSet;
  }

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

  public boolean setModifier(String aModifier)
  {
    boolean wasSet = false;
    modifier = aModifier;
    wasSet = true;
    return wasSet;
  }

  public boolean addAssociation(Association aAssociation)
  {
    boolean wasAdded = false;
    wasAdded = associations.add(aAssociation);
    return wasAdded;
  }

  public boolean removeAssociation(Association aAssociation)
  {
    boolean wasRemoved = false;
    wasRemoved = associations.remove(aAssociation);
    return wasRemoved;
  }

  public boolean setKey(Key aKey)
  {
    boolean wasSet = false;
    key = aKey;
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

  public boolean setPackageName(String aPackageName)
  {
    boolean wasSet = false;
    if (aPackageName == null) { return false; }
    packageName = aPackageName;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsSingleton()
  {
    return isSingleton;
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

  public String getModifier()
  {
    return modifier;
  }

  public Association getAssociation(int index)
  {
    Association aAssociation = associations.get(index);
    return aAssociation;
  }

  public Association[] getAssociations()
  {
    Association[] newAssociations = associations.toArray(new Association[associations.size()]);
    return newAssociations;
  }

  public int numberOfAssociations()
  {
    int number = associations.size();
    return number;
  }

  public boolean hasAssociations()
  {
    boolean has = associations.size() > 0;
    return has;
  }

  public int indexOfAssociation(Association aAssociation)
  {
    int index = associations.indexOf(aAssociation);
    return index;
  }

  public Key getKey()
  {
    return key;
  }

  public String getExtraCode()
  {
    return extraCode;
  }

  public String getPackageName()
  {
    return packageName;
  }

  public CodeInjection getCodeInjection(int index)
  {
    CodeInjection aCodeInjection = codeInjections.get(index);
    return aCodeInjection;
  }

  public List<CodeInjection> getCodeInjections()
  {
    List<CodeInjection> newCodeInjections = Collections.unmodifiableList(codeInjections);
    return newCodeInjections;
  }

  public int numberOfCodeInjections()
  {
    int number = codeInjections.size();
    return number;
  }

  public boolean hasCodeInjections()
  {
    boolean has = codeInjections.size() > 0;
    return has;
  }

  public int indexOfCodeInjection(CodeInjection aCodeInjection)
  {
    int index = codeInjections.indexOf(aCodeInjection);
    return index;
  }

  public UmpleClass getExtendsClass()
  {
    return extendsClass;
  }

  public UmpleInterface getParentInterface(int index)
  {
    UmpleInterface aParentInterface = parentInterface.get(index);
    return aParentInterface;
  }

  public List<UmpleInterface> getParentInterface()
  {
    List<UmpleInterface> newParentInterface = Collections.unmodifiableList(parentInterface);
    return newParentInterface;
  }

  public int numberOfParentInterface()
  {
    int number = parentInterface.size();
    return number;
  }

  public boolean hasParentInterface()
  {
    boolean has = parentInterface.size() > 0;
    return has;
  }

  public int indexOfParentInterface(UmpleInterface aParentInterface)
  {
    int index = parentInterface.indexOf(aParentInterface);
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

  public UniqueIdentifier getUniqueIdentifier()
  {
    return uniqueIdentifier;
  }

  public Attribute getAttribute(int index)
  {
    Attribute aAttribute = attributes.get(index);
    return aAttribute;
  }

  public List<Attribute> getAttributes()
  {
    List<Attribute> newAttributes = Collections.unmodifiableList(attributes);
    return newAttributes;
  }

  public int numberOfAttributes()
  {
    int number = attributes.size();
    return number;
  }

  public boolean hasAttributes()
  {
    boolean has = attributes.size() > 0;
    return has;
  }

  public int indexOfAttribute(Attribute aAttribute)
  {
    int index = attributes.indexOf(aAttribute);
    return index;
  }

  public AssociationVariable getAssociationVariable(int index)
  {
    AssociationVariable aAssociationVariable = associationVariables.get(index);
    return aAssociationVariable;
  }

  public List<AssociationVariable> getAssociationVariables()
  {
    List<AssociationVariable> newAssociationVariables = Collections.unmodifiableList(associationVariables);
    return newAssociationVariables;
  }

  public int numberOfAssociationVariables()
  {
    int number = associationVariables.size();
    return number;
  }

  public boolean hasAssociationVariables()
  {
    boolean has = associationVariables.size() > 0;
    return has;
  }

  public int indexOfAssociationVariable(AssociationVariable aAssociationVariable)
  {
    int index = associationVariables.indexOf(aAssociationVariable);
    return index;
  }

  public StateMachine getStateMachine(int index)
  {
    StateMachine aStateMachine = stateMachines.get(index);
    return aStateMachine;
  }

  public List<StateMachine> getStateMachines()
  {
    List<StateMachine> newStateMachines = Collections.unmodifiableList(stateMachines);
    return newStateMachines;
  }

  public int numberOfStateMachines()
  {
    int number = stateMachines.size();
    return number;
  }

  public boolean hasStateMachines()
  {
    boolean has = stateMachines.size() > 0;
    return has;
  }

  public int indexOfStateMachine(StateMachine aStateMachine)
  {
    int index = stateMachines.indexOf(aStateMachine);
    return index;
  }

  public static int minimumNumberOfCodeInjections()
  {
    return 0;
  }

  public boolean addCodeInjection(CodeInjection aCodeInjection)
  {
    boolean wasAdded = false;
    if (codeInjections.contains(aCodeInjection)) { return false; }
    codeInjections.add(aCodeInjection);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCodeInjection(CodeInjection aCodeInjection)
  {
    boolean wasRemoved = false;
    if (codeInjections.contains(aCodeInjection))
    {
      codeInjections.remove(aCodeInjection);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean setExtendsClass(UmpleClass newExtendsClass)
  {
    boolean wasSet = false;
    extendsClass = newExtendsClass;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfParentInterface()
  {
    return 0;
  }

  public boolean addParentInterface(UmpleInterface aParentInterface)
  {
    boolean wasAdded = false;
    if (parentInterface.contains(aParentInterface)) { return false; }
    parentInterface.add(aParentInterface);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParentInterface(UmpleInterface aParentInterface)
  {
    boolean wasRemoved = false;
    if (parentInterface.contains(aParentInterface))
    {
      parentInterface.remove(aParentInterface);
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

  public boolean setUniqueIdentifier(UniqueIdentifier newUniqueIdentifier)
  {
    boolean wasSet = false;
    uniqueIdentifier = newUniqueIdentifier;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfAttributes()
  {
    return 0;
  }

  public boolean addAttribute(Attribute aAttribute)
  {
    boolean wasAdded = false;
    if (attributes.contains(aAttribute)) { return false; }
    attributes.add(aAttribute);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAttribute(Attribute aAttribute)
  {
    boolean wasRemoved = false;
    if (attributes.contains(aAttribute))
    {
      attributes.remove(aAttribute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfAssociationVariables()
  {
    return 0;
  }

  public boolean addAssociationVariable(AssociationVariable aAssociationVariable)
  {
    boolean wasAdded = false;
    if (associationVariables.contains(aAssociationVariable)) { return false; }
    associationVariables.add(aAssociationVariable);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssociationVariable(AssociationVariable aAssociationVariable)
  {
    boolean wasRemoved = false;
    if (associationVariables.contains(aAssociationVariable))
    {
      associationVariables.remove(aAssociationVariable);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfStateMachines()
  {
    return 0;
  }

  public boolean addStateMachine(StateMachine aStateMachine)
  {
    boolean wasAdded = false;
    if (stateMachines.contains(aStateMachine)) { return false; }
    UmpleClass existingUmpleClass = aStateMachine.getUmpleClass();
    if (existingUmpleClass == null)
    {
      aStateMachine.setUmpleClass(this);
    }
    else if (!this.equals(existingUmpleClass))
    {
      existingUmpleClass.removeStateMachine(aStateMachine);
      addStateMachine(aStateMachine);
    }
    else
    {
      stateMachines.add(aStateMachine);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateMachine(StateMachine aStateMachine)
  {
    boolean wasRemoved = false;
    if (stateMachines.contains(aStateMachine))
    {
      stateMachines.remove(aStateMachine);
      aStateMachine.setUmpleClass(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    codeInjections.clear();
    extendsClass = null;
    parentInterface.clear();
    depends.clear();
    methods.clear();
    constants.clear();
    uniqueIdentifier = null;
    attributes.clear();
    associationVariables.clear();
    for(StateMachine aStateMachine : stateMachines)
    {
      aStateMachine.setUmpleClass(null);
    }
    super.delete();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public List<StateMachine> getAllStateMachines()
  {
    ArrayList<StateMachine> all = new ArrayList<StateMachine>();
    all.addAll(getStateMachines());
    for (StateMachine sm : getStateMachines())
    {
      all.addAll(sm.getNestedStateMachines());
    }
    return all;
  }

  public List<CodeInjection> getApplicableCodeInjections(String type, String method)
  {  
    ArrayList<CodeInjection> all = new ArrayList<CodeInjection>();
    if (type == null || method == null)
    {
      return all;
    }
    String formattedMethod = StringFormatter.toUnderscore(method);
    
    for (CodeInjection code : getCodeInjections())
    {
      if (code.getOperation() == null || !type.equals(code.getType()))
      {
        continue;
      }

      boolean isAllExcludes = true;
      TriState isMatch = new TriState(false);
      TriState isMatchOnExclude = new TriState(true);
      
      String[] allOperations = code.getOperation().split(",");
      for (String operation : allOperations)
      {
        
        boolean isNot = false;
        if (operation.startsWith("!"))
        {
          isNot = true;
          operation = operation.substring(1);
        }
        else
        {
          isAllExcludes = false;
        }
        isMatchOnExclude.setIsSet(true);
        
        String regexOperation = StringFormatter.toUnderscore(operation);
        regexOperation = regexOperation.replace("_*", "*");
        regexOperation = regexOperation.replace("*", ".*");
        boolean isCurrentMatch = formattedMethod.matches(regexOperation);

        if (isNot && isCurrentMatch)
        {
          isMatch.setStatus(false);
          isMatchOnExclude.setStatus(false);
        }
        else if (!isNot && isCurrentMatch)
        {
          isMatch.setStatus(true);
        }
      }
      
      if ((isAllExcludes && isMatchOnExclude.isTrue()) || isMatch.isTrue()) 
      {
        all.add(code);
      }
    } 
    
    return all;
  }

  public List<StateMachine> getStateMachines(Event e)
  { 
    List<StateMachine> allStateMachines = new ArrayList<StateMachine>();
    for (StateMachine sm : getAllStateMachines())
    {
      List<Event> allEvents = sm.getEvents();
      if (allEvents.contains(e))
      {
        allStateMachines.add(sm);
      }
    }
    return allStateMachines;
  }

  public List<Event> getEvents()
  {
    List<Event> allEvents = new ArrayList<Event>();
    for (StateMachine sm : getAllStateMachines())
    {
      allEvents.addAll(sm.getEvents());
    }
    
    List<Event> allUniqueEvents = new ArrayList<Event>();
    for (Event e : allEvents)
    {
      if (!allUniqueEvents.contains(e))
      {
        allUniqueEvents.add(e);
      }
    }
    return allUniqueEvents;
  }

  public Event findOrCreateEvent(String aName)
  {
    if (aName == null)
    {
      return null;
    }
    
    for (StateMachine sm : getStateMachines())
    {
      for (Event aEvent : sm.getEvents())
      {
        if (aName.equals(aEvent.getName()))
        {
          return aEvent;
        }
      }
    }
    return new Event(aName);
  }

  public void addReferencedPackage(String aNamespace)
  {
    if (indexOfNamespace(aNamespace) == -1 && !aNamespace.equals(getPackageName()))
    {
      addNamespace(aNamespace);
    }
  }
  
  public AssociationVariable getAssociationVariable(String name)
  {
    for (AssociationVariable av : associationVariables)
    {
      if (av.getName().equals(name))
      {
        return av;
      }
    }
    return null;
  }
  
  public AssociationVariable getAssociationVariableFor(UmpleClass uClass)
  {
    for (AssociationVariable av : associationVariables)
    {
      if (av.getType().equals(uClass.getName()))
      {
        return av;
      }
    }
    return null;
  }
  
  
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
  
  public Attribute getAttribute(String name)
  {
    for (Attribute av : attributes)
    {
      if (av.getName().equals(name))
      {
        return av;
      }
    }
    return null;
  }
  
  public boolean isRoot()
  {
    return extendsClass == null;
  }
  
  protected GeneratedClass gClass = null;
  public GeneratedClass getGeneratedClass()
  {
    return gClass;
  }

  public GeneratedClass createGeneratedClass(UmpleModel model)
  {
    gClass = new GeneratedClass(model, this);
    if (getExtendsClass() != null)
    {
      gClass.setParentClass(getExtendsClass().getGeneratedClass());
    }
    return getGeneratedClass();
  }
  
  
  
  public boolean hasUniqueIdentifier()
  {
    return getUniqueIdentifier() != null;
  }
  
  public boolean isAttributeClass()
  {
    for (AssociationVariable association : getAssociationVariables())
    {
      if (association.getIsNavigable())
      {
        return false;
      }
    }
    return true;
  }
}