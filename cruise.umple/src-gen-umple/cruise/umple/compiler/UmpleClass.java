/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * An UmpleClass can contain attributes, associations, state machines and methods.
 * It can also have various other information such as a key (to identify uniqueness),
 * code to inject into generated code, and comments. It can be tagged with various
 * patterns, such as 'singleton', meaning that there can only be one instance,
 * and abstract, meaning it can't have any instances.
 * In Umple_Code.ump: Methods for computing complex properties
 * @umplesource Umple.ump 340
 * @umplesource Trace.ump 112
 * @umplesource Umple_Code.ump 623
 */
// line 340 "../../../../src/Umple.ump"
// line 112 "../../../../src/Trace.ump"
// line 623 "../../../../src/Umple_Code.ump"
public class UmpleClass extends UmpleClassifier
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleClass Attributes
  private boolean isAbstract;
  private boolean isSingleton;
  private List<Association> associations;
  private Key key;
  private boolean iAmImmutable;
  private boolean ancestorIsImmutable;
  private UmpleModel sourceModel;

  //UmpleClass Associations
  private List<CodeInjection> codeInjections;
  private List<Precondition> preconditions;
  private List<Constraint> constraints;
  private UmpleClass extendsClass;
  private List<UmpleInterface> parentInterface;
  private UniqueIdentifier uniqueIdentifier;
  private List<Attribute> attributes;
  private List<AssociationVariable> associationVariables;
  private List<Comment> comments;
  private List<TraceDirective> traceDirectives;
  private List<TraceCase> traceCases;
  private List<StateMachine> stateMachines;
  private List<UmpleClass> subclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleClass(String aName, UmpleModel aSourceModel)
  {
    super(aName);
    isAbstract = false;
    isSingleton = false;
    associations = new ArrayList<Association>();
    key = new Key();
    iAmImmutable = false;
    ancestorIsImmutable = false;
    sourceModel = aSourceModel;
    codeInjections = new ArrayList<CodeInjection>();
    preconditions = new ArrayList<Precondition>();
    constraints = new ArrayList<Constraint>();
    parentInterface = new ArrayList<UmpleInterface>();
    attributes = new ArrayList<Attribute>();
    associationVariables = new ArrayList<AssociationVariable>();
    comments = new ArrayList<Comment>();
    traceDirectives = new ArrayList<TraceDirective>();
    traceCases = new ArrayList<TraceCase>();
    stateMachines = new ArrayList<StateMachine>();
    subclasses = new ArrayList<UmpleClass>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsAbstract(boolean aIsAbstract)
  {
    boolean wasSet = false;
    isAbstract = aIsAbstract;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsSingleton(boolean aIsSingleton)
  {
    boolean wasSet = false;
    isSingleton = aIsSingleton;
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

  public boolean setSourceModel(UmpleModel aSourceModel)
  {
    boolean wasSet = false;
    sourceModel = aSourceModel;
    wasSet = true;
    return wasSet;
  }

  /**
   * Specifies whether or not the Umple class is an abstract class.
   */
  public boolean getIsAbstract()
  {
    return isAbstract;
  }

  /**
   * Specifies whether or not the Umple class is a singleton.
   */
  public boolean getIsSingleton()
  {
    return isSingleton;
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

  public UmpleModel getSourceModel()
  {
    return sourceModel;
  }

  public boolean isIsAbstract()
  {
    return isAbstract;
  }

  public boolean isIsSingleton()
  {
    return isSingleton;
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

  public Precondition getPrecondition(int index)
  {
    Precondition aPrecondition = preconditions.get(index);
    return aPrecondition;
  }

  /**
   * The possible Preconditions related to the Umple Class
   */
  public List<Precondition> getPreconditions()
  {
    List<Precondition> newPreconditions = Collections.unmodifiableList(preconditions);
    return newPreconditions;
  }

  public int numberOfPreconditions()
  {
    int number = preconditions.size();
    return number;
  }

  public boolean hasPreconditions()
  {
    boolean has = preconditions.size() > 0;
    return has;
  }

  public int indexOfPrecondition(Precondition aPrecondition)
  {
    int index = preconditions.indexOf(aPrecondition);
    return index;
  }

  public Constraint getConstraint(int index)
  {
    Constraint aConstraint = constraints.get(index);
    return aConstraint;
  }

  /**
   * The possible Constraints related to the Umple Class
   */
  public List<Constraint> getConstraints()
  {
    List<Constraint> newConstraints = Collections.unmodifiableList(constraints);
    return newConstraints;
  }

  public int numberOfConstraints()
  {
    int number = constraints.size();
    return number;
  }

  public boolean hasConstraints()
  {
    boolean has = constraints.size() > 0;
    return has;
  }

  public int indexOfConstraint(Constraint aConstraint)
  {
    int index = constraints.indexOf(aConstraint);
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

  public UniqueIdentifier getUniqueIdentifier()
  {
    return uniqueIdentifier;
  }

  public Attribute getAttribute(int index)
  {
    Attribute aAttribute = attributes.get(index);
    return aAttribute;
  }

  /**
   * The attributes contained within the Umple class.
   */
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

  /**
   * The associations contained within the Umple class.
   */
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

  public Comment getComment(int index)
  {
    Comment aComment = comments.get(index);
    return aComment;
  }

  /**
   * The comments associated with the Umple Class (such as the Javadoc above it).
   */
  public List<Comment> getComments()
  {
    List<Comment> newComments = Collections.unmodifiableList(comments);
    return newComments;
  }

  public int numberOfComments()
  {
    int number = comments.size();
    return number;
  }

  public boolean hasComments()
  {
    boolean has = comments.size() > 0;
    return has;
  }

  public int indexOfComment(Comment aComment)
  {
    int index = comments.indexOf(aComment);
    return index;
  }

  public TraceDirective getTraceDirective(int index)
  {
    TraceDirective aTraceDirective = traceDirectives.get(index);
    return aTraceDirective;
  }

  public List<TraceDirective> getTraceDirectives()
  {
    List<TraceDirective> newTraceDirectives = Collections.unmodifiableList(traceDirectives);
    return newTraceDirectives;
  }

  public int numberOfTraceDirectives()
  {
    int number = traceDirectives.size();
    return number;
  }

  public boolean hasTraceDirectives()
  {
    boolean has = traceDirectives.size() > 0;
    return has;
  }

  public int indexOfTraceDirective(TraceDirective aTraceDirective)
  {
    int index = traceDirectives.indexOf(aTraceDirective);
    return index;
  }

  public TraceCase getTraceCase(int index)
  {
    TraceCase aTraceCase = traceCases.get(index);
    return aTraceCase;
  }

  public List<TraceCase> getTraceCases()
  {
    List<TraceCase> newTraceCases = Collections.unmodifiableList(traceCases);
    return newTraceCases;
  }

  public int numberOfTraceCases()
  {
    int number = traceCases.size();
    return number;
  }

  public boolean hasTraceCases()
  {
    boolean has = traceCases.size() > 0;
    return has;
  }

  public int indexOfTraceCase(TraceCase aTraceCase)
  {
    int index = traceCases.indexOf(aTraceCase);
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

  public UmpleClass getSubclass(int index)
  {
    UmpleClass aSubclass = subclasses.get(index);
    return aSubclass;
  }

  public List<UmpleClass> getSubclasses()
  {
    List<UmpleClass> newSubclasses = Collections.unmodifiableList(subclasses);
    return newSubclasses;
  }

  public int numberOfSubclasses()
  {
    int number = subclasses.size();
    return number;
  }

  public boolean hasSubclasses()
  {
    boolean has = subclasses.size() > 0;
    return has;
  }

  public int indexOfSubclass(UmpleClass aSubclass)
  {
    int index = subclasses.indexOf(aSubclass);
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

  public boolean addCodeInjectionAt(CodeInjection aCodeInjection, int index)
  {  
    boolean wasAdded = false;
    if(addCodeInjection(aCodeInjection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCodeInjections()) { index = numberOfCodeInjections() - 1; }
      codeInjections.remove(aCodeInjection);
      codeInjections.add(index, aCodeInjection);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCodeInjectionAt(CodeInjection aCodeInjection, int index)
  {
    boolean wasAdded = false;
    if(codeInjections.contains(aCodeInjection))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCodeInjections()) { index = numberOfCodeInjections() - 1; }
      codeInjections.remove(aCodeInjection);
      codeInjections.add(index, aCodeInjection);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCodeInjectionAt(aCodeInjection, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPreconditions()
  {
    return 0;
  }

  public boolean addPrecondition(Precondition aPrecondition)
  {
    boolean wasAdded = false;
    if (preconditions.contains(aPrecondition)) { return false; }
    preconditions.add(aPrecondition);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePrecondition(Precondition aPrecondition)
  {
    boolean wasRemoved = false;
    if (preconditions.contains(aPrecondition))
    {
      preconditions.remove(aPrecondition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPreconditionAt(Precondition aPrecondition, int index)
  {  
    boolean wasAdded = false;
    if(addPrecondition(aPrecondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreconditions()) { index = numberOfPreconditions() - 1; }
      preconditions.remove(aPrecondition);
      preconditions.add(index, aPrecondition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePreconditionAt(Precondition aPrecondition, int index)
  {
    boolean wasAdded = false;
    if(preconditions.contains(aPrecondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreconditions()) { index = numberOfPreconditions() - 1; }
      preconditions.remove(aPrecondition);
      preconditions.add(index, aPrecondition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPreconditionAt(aPrecondition, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfConstraints()
  {
    return 0;
  }

  public boolean addConstraint(Constraint aConstraint)
  {
    boolean wasAdded = false;
    if (constraints.contains(aConstraint)) { return false; }
    constraints.add(aConstraint);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeConstraint(Constraint aConstraint)
  {
    boolean wasRemoved = false;
    if (constraints.contains(aConstraint))
    {
      constraints.remove(aConstraint);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addConstraintAt(Constraint aConstraint, int index)
  {  
    boolean wasAdded = false;
    if(addConstraint(aConstraint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConstraints()) { index = numberOfConstraints() - 1; }
      constraints.remove(aConstraint);
      constraints.add(index, aConstraint);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConstraintAt(Constraint aConstraint, int index)
  {
    boolean wasAdded = false;
    if(constraints.contains(aConstraint))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfConstraints()) { index = numberOfConstraints() - 1; }
      constraints.remove(aConstraint);
      constraints.add(index, aConstraint);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConstraintAt(aConstraint, index);
    }
    return wasAdded;
  }

  public boolean setExtendsClass(UmpleClass aExtendsClass)
  {
    boolean wasSet = false;
    // line 393 "../../../../src/Umple.ump"
    if (!enforceImmutabilityInheritanceRules(aExtendsClass)) { return false; }
    UmpleClass existingExtendsClass = extendsClass;
    extendsClass = aExtendsClass;
    if (existingExtendsClass != null && !existingExtendsClass.equals(aExtendsClass))
    {
      existingExtendsClass.removeSubclass(this);
    }
    if (aExtendsClass != null)
    {
      aExtendsClass.addSubclass(this);
    }
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

  public boolean addParentInterfaceAt(UmpleInterface aParentInterface, int index)
  {  
    boolean wasAdded = false;
    if(addParentInterface(aParentInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParentInterface()) { index = numberOfParentInterface() - 1; }
      parentInterface.remove(aParentInterface);
      parentInterface.add(index, aParentInterface);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParentInterfaceAt(UmpleInterface aParentInterface, int index)
  {
    boolean wasAdded = false;
    if(parentInterface.contains(aParentInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParentInterface()) { index = numberOfParentInterface() - 1; }
      parentInterface.remove(aParentInterface);
      parentInterface.add(index, aParentInterface);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParentInterfaceAt(aParentInterface, index);
    }
    return wasAdded;
  }

  public boolean setUniqueIdentifier(UniqueIdentifier aNewUniqueIdentifier)
  {
    boolean wasSet = false;
    uniqueIdentifier = aNewUniqueIdentifier;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfAttributes()
  {
    return 0;
  }

  public Attribute addAttribute(String aName, String aType, String aModifier, String aValue, boolean aIsAutounique)
  {
    return new Attribute(aName, aType, aModifier, aValue, aIsAutounique, this);
  }

  public boolean addAttribute(Attribute aAttribute)
  {
    boolean wasAdded = false;
    if (attributes.contains(aAttribute)) { return false; }
    UmpleClass existingUmpleClass = aAttribute.getUmpleClass();
    boolean isNewUmpleClass = existingUmpleClass != null && !this.equals(existingUmpleClass);
    if (isNewUmpleClass)
    {
      aAttribute.setUmpleClass(this);
    }
    else
    {
      attributes.add(aAttribute);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAttribute(Attribute aAttribute)
  {
    boolean wasRemoved = false;
    //Unable to remove aAttribute, as it must always have a umpleClass
    if (!this.equals(aAttribute.getUmpleClass()))
    {
      attributes.remove(aAttribute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAttributeAt(Attribute aAttribute, int index)
  {  
    boolean wasAdded = false;
    if(addAttribute(aAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttributes()) { index = numberOfAttributes() - 1; }
      attributes.remove(aAttribute);
      attributes.add(index, aAttribute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAttributeAt(Attribute aAttribute, int index)
  {
    boolean wasAdded = false;
    if(attributes.contains(aAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttributes()) { index = numberOfAttributes() - 1; }
      attributes.remove(aAttribute);
      attributes.add(index, aAttribute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAttributeAt(aAttribute, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAssociationVariables()
  {
    return 0;
  }

  public boolean addAssociationVariable(AssociationVariable aAssociationVariable)
  {
    boolean wasAdded = false;
    // line 391 "../../../../src/Umple.ump"
    if (!immutabilityAssociationRulesSatisfied(aAssociationVariable, this.isImmutable())) { return false; }
    if (associationVariables.contains(aAssociationVariable)) { return false; }
    UmpleClass existingUmpleClass = aAssociationVariable.getUmpleClass();
    if (existingUmpleClass == null)
    {
      aAssociationVariable.setUmpleClass(this);
    }
    else if (!this.equals(existingUmpleClass))
    {
      existingUmpleClass.removeAssociationVariable(aAssociationVariable);
      addAssociationVariable(aAssociationVariable);
    }
    else
    {
      associationVariables.add(aAssociationVariable);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssociationVariable(AssociationVariable aAssociationVariable)
  {
    boolean wasRemoved = false;
    if (associationVariables.contains(aAssociationVariable))
    {
      associationVariables.remove(aAssociationVariable);
      aAssociationVariable.setUmpleClass(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssociationVariableAt(AssociationVariable aAssociationVariable, int index)
  {  
    boolean wasAdded = false;
    if(addAssociationVariable(aAssociationVariable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociationVariables()) { index = numberOfAssociationVariables() - 1; }
      associationVariables.remove(aAssociationVariable);
      associationVariables.add(index, aAssociationVariable);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssociationVariableAt(AssociationVariable aAssociationVariable, int index)
  {
    boolean wasAdded = false;
    if(associationVariables.contains(aAssociationVariable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociationVariables()) { index = numberOfAssociationVariables() - 1; }
      associationVariables.remove(aAssociationVariable);
      associationVariables.add(index, aAssociationVariable);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssociationVariableAt(aAssociationVariable, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfComments()
  {
    return 0;
  }

  public boolean addComment(Comment aComment)
  {
    boolean wasAdded = false;
    if (comments.contains(aComment)) { return false; }
    comments.add(aComment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeComment(Comment aComment)
  {
    boolean wasRemoved = false;
    if (comments.contains(aComment))
    {
      comments.remove(aComment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCommentAt(Comment aComment, int index)
  {  
    boolean wasAdded = false;
    if(addComment(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommentAt(Comment aComment, int index)
  {
    boolean wasAdded = false;
    if(comments.contains(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommentAt(aComment, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTraceDirectives()
  {
    return 0;
  }

  public boolean addTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasAdded = false;
    if (traceDirectives.contains(aTraceDirective)) { return false; }
    UmpleClass existingUmpleClass = aTraceDirective.getUmpleClass();
    if (existingUmpleClass == null)
    {
      aTraceDirective.setUmpleClass(this);
    }
    else if (!this.equals(existingUmpleClass))
    {
      existingUmpleClass.removeTraceDirective(aTraceDirective);
      addTraceDirective(aTraceDirective);
    }
    else
    {
      traceDirectives.add(aTraceDirective);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTraceDirective(TraceDirective aTraceDirective)
  {
    boolean wasRemoved = false;
    if (traceDirectives.contains(aTraceDirective))
    {
      traceDirectives.remove(aTraceDirective);
      aTraceDirective.setUmpleClass(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {  
    boolean wasAdded = false;
    if(addTraceDirective(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceDirectiveAt(TraceDirective aTraceDirective, int index)
  {
    boolean wasAdded = false;
    if(traceDirectives.contains(aTraceDirective))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceDirectives()) { index = numberOfTraceDirectives() - 1; }
      traceDirectives.remove(aTraceDirective);
      traceDirectives.add(index, aTraceDirective);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceDirectiveAt(aTraceDirective, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTraceCases()
  {
    return 0;
  }

  public boolean addTraceCase(TraceCase aTraceCase)
  {
    boolean wasAdded = false;
    if (traceCases.contains(aTraceCase)) { return false; }
    UmpleClass existingUmpleClass = aTraceCase.getUmpleClass();
    if (existingUmpleClass == null)
    {
      aTraceCase.setUmpleClass(this);
    }
    else if (!this.equals(existingUmpleClass))
    {
      existingUmpleClass.removeTraceCase(aTraceCase);
      addTraceCase(aTraceCase);
    }
    else
    {
      traceCases.add(aTraceCase);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTraceCase(TraceCase aTraceCase)
  {
    boolean wasRemoved = false;
    if (traceCases.contains(aTraceCase))
    {
      traceCases.remove(aTraceCase);
      aTraceCase.setUmpleClass(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTraceCaseAt(TraceCase aTraceCase, int index)
  {  
    boolean wasAdded = false;
    if(addTraceCase(aTraceCase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceCases()) { index = numberOfTraceCases() - 1; }
      traceCases.remove(aTraceCase);
      traceCases.add(index, aTraceCase);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceCaseAt(TraceCase aTraceCase, int index)
  {
    boolean wasAdded = false;
    if(traceCases.contains(aTraceCase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceCases()) { index = numberOfTraceCases() - 1; }
      traceCases.remove(aTraceCase);
      traceCases.add(index, aTraceCase);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceCaseAt(aTraceCase, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfStateMachines()
  {
    return 0;
  }

  public boolean addStateMachine(StateMachine aStateMachine)
  {
    boolean wasAdded = false;
    // line 395 "../../../../src/Umple.ump"
    if (isImmutable()) { return false; }
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

  public boolean addStateMachineAt(StateMachine aStateMachine, int index)
  {  
    boolean wasAdded = false;
    if(addStateMachine(aStateMachine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachines()) { index = numberOfStateMachines() - 1; }
      stateMachines.remove(aStateMachine);
      stateMachines.add(index, aStateMachine);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateMachineAt(StateMachine aStateMachine, int index)
  {
    boolean wasAdded = false;
    if(stateMachines.contains(aStateMachine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachines()) { index = numberOfStateMachines() - 1; }
      stateMachines.remove(aStateMachine);
      stateMachines.add(index, aStateMachine);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateMachineAt(aStateMachine, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSubclasses()
  {
    return 0;
  }

  public boolean addSubclass(UmpleClass aSubclass)
  {
    boolean wasAdded = false;
    if (subclasses.contains(aSubclass)) { return false; }
    UmpleClass existingExtendsClass = aSubclass.getExtendsClass();
    if (existingExtendsClass == null)
    {
      aSubclass.setExtendsClass(this);
    }
    else if (!this.equals(existingExtendsClass))
    {
      existingExtendsClass.removeSubclass(aSubclass);
      addSubclass(aSubclass);
    }
    else
    {
      subclasses.add(aSubclass);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSubclass(UmpleClass aSubclass)
  {
    boolean wasRemoved = false;
    if (subclasses.contains(aSubclass))
    {
      subclasses.remove(aSubclass);
      aSubclass.setExtendsClass(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSubclassAt(UmpleClass aSubclass, int index)
  {  
    boolean wasAdded = false;
    if(addSubclass(aSubclass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubclasses()) { index = numberOfSubclasses() - 1; }
      subclasses.remove(aSubclass);
      subclasses.add(index, aSubclass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubclassAt(UmpleClass aSubclass, int index)
  {
    boolean wasAdded = false;
    if(subclasses.contains(aSubclass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubclasses()) { index = numberOfSubclasses() - 1; }
      subclasses.remove(aSubclass);
      subclasses.add(index, aSubclass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubclassAt(aSubclass, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    codeInjections.clear();
    preconditions.clear();
    constraints.clear();
    if (extendsClass != null)
    {
      UmpleClass placeholderExtendsClass = extendsClass;
      this.extendsClass = null;
      placeholderExtendsClass.removeSubclass(this);
    }
    parentInterface.clear();
    uniqueIdentifier = null;
    for(int i=attributes.size(); i > 0; i--)
    {
      Attribute aAttribute = attributes.get(i - 1);
      aAttribute.delete();
    }
    for(AssociationVariable aAssociationVariable : associationVariables)
    {
      aAssociationVariable.setUmpleClass(null);
    }
    comments.clear();
    for(TraceDirective aTraceDirective : traceDirectives)
    {
      aTraceDirective.setUmpleClass(null);
    }
    for(TraceCase aTraceCase : traceCases)
    {
      aTraceCase.setUmpleClass(null);
    }
    for(StateMachine aStateMachine : stateMachines)
    {
      aStateMachine.setUmpleClass(null);
    }
    for(UmpleClass aSubclass : subclasses)
    {
      aSubclass.setExtendsClass(null);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "isAbstract" + ":" + getIsAbstract()+ "," +
            "isSingleton" + ":" + getIsSingleton()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "uniqueIdentifier" + "=" + getKey() != null ? !getKey() .equals(this)  ? getKey().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "extendsClass" + "=" + getSourceModel() != null ? !getSourceModel() .equals(this)  ? getSourceModel().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "key" + "=" + getExtendsClass() != null ? !getExtendsClass() .equals(this)  ? getExtendsClass().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "sourceModel" + "=" + getUniqueIdentifier() != null ? !getUniqueIdentifier() .equals(this)  ? getUniqueIdentifier().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
   public UmpleClass(String name)  {
this(name, null);
  }
// line 631 ../../../../src/Umple_Code.ump
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
      for (Event aEvent : sm.getAllEvents())
      {
        if (aName.equals(aEvent.getName()))
        {
          return aEvent;
        }
      }
    }
    return new Event(aName);
  }

  public StateMachine getStateMachine(String name)
  {
    for (StateMachine sm : stateMachines)
    {
      if (sm.getName().equals(name))
      {
        return sm;
      }
    }
    return null;
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
  
  /* @return true if this class is immutable, either because it has the "immutable" modifier or 
   * because an ancestor class is immutable; false if this class neither has the "immutable" modifier 
   * nor an immutable ancestor.
   */
  public boolean isImmutable()
   {
     return (iAmImmutable || ancestorIsImmutable);
  }
    
  public boolean setImmutable()
  {
    boolean wasSet = false;
    if (extendsClass != null && !ancestorIsImmutable) { return wasSet; }
    
    if (propagateImmutabilityToAllRelationships(true)) 
    { 
      iAmImmutable = true;
      wasSet = true;
    }
    return wasSet;
  }
  
  private boolean propagateImmutabilityToAllRelationships(boolean isImmutable)
  {
    if (isImmutable)
    {
      if (this.hasStateMachines()) { return false; }

      for (AssociationVariable av : associationVariables)
      {
        if (!immutabilityAssociationRulesSatisfied(av, true)) { return false; }
      }
    }
    
    return notifySubclassesAncestorImmutable(isImmutable);
  }
  
  private boolean notifySubclassesAncestorImmutable(boolean isImmutable)
  {
    boolean notified = true;
    List<UmpleClass> wereSet = new ArrayList<UmpleClass>();
    for (UmpleClass subclass : getSubclasses())
    {
      notified = subclass.setAncestorIsImmutable(isImmutable);
      if (!notified)
      {
        for (UmpleClass wasSet : wereSet)
        {
          wasSet.setAncestorIsImmutable(!isImmutable);
        }
        return notified;
      }
    }
    return notified;
  }
  
  protected boolean setAncestorIsImmutable(boolean isImmutable)
  {
    if (iAmImmutable)
    {
      ancestorIsImmutable = isImmutable;
      return true;
    }
    else
    {
      boolean success = propagateImmutabilityToAllRelationships(isImmutable);
      if (success) { ancestorIsImmutable = isImmutable; }
      return success;
    }
  }
  
  private boolean enforceImmutabilityInheritanceRules(UmpleClass newSuperClass)
  {
    // A subclass may not be immutable if the superclass is not immutable
    if (iAmImmutable && newSuperClass != null && !newSuperClass.isImmutable()) { return false; }
    boolean ancestorImmutable = (newSuperClass == null) ? false : newSuperClass.isImmutable();
    return setAncestorIsImmutable(ancestorImmutable);
  }

  protected static boolean immutabilityAssociationRulesSatisfied(AssociationVariable myAV, UmpleClass myClass, boolean myClassImmutable, 
      AssociationVariable yourAV, UmpleClass yourClass, boolean yourClassImmutable)
  {
    boolean satisfied = false;
    if (myAV == null || yourAV == null)
    {
      satisfied = true;
    }
    else if (!myClassImmutable && !yourClassImmutable && !"immutable".equals(myAV.getModifier()) && !"immutable".equals(yourAV.getModifier()))
    {
      satisfied = true;
    } 
    else if (myAV.getIsNavigable() && yourAV.getIsNavigable())
    {
      //satisfied = false;
    }
    else if (myClass == null && yourClass == null)
    {
      satisfied = true;
    }
    else if (!yourAV.getIsNavigable() && (yourClass == null || yourClassImmutable))
    {
      if (yourClass != null && yourClass == myClass && myAV.isMandatory())
      {
        // reflexive associations may not be mandatory:
        //satisfied = false
      }
      else
      {
        satisfied = true;
      }
    }
    else if (!myAV.getIsNavigable() && (myClass == null || myClassImmutable))
    {
      if (myClass != null && yourClass == myClass && yourAV.isMandatory())
      {
        // reflexive associations may not be mandatory:
        //satisfied = false
      }
      else
      {
        satisfied = true;
      }
    }
    return satisfied;
  }

  protected boolean immutabilityAssociationRulesSatisfied(AssociationVariable myAV, boolean myClassImmutable)
  {
    AssociationVariable relatedAV = myAV.getRelatedAssociation();
    UmpleClass relatedClass = (relatedAV == null) ? null : relatedAV.getUmpleClass();
    boolean relatedClassImmutable = (relatedClass == null) ? false : ((relatedClass == this) ? myClassImmutable : relatedClass.isImmutable());

    return immutabilityAssociationRulesSatisfied(myAV, this, myClassImmutable, relatedAV, relatedClass, relatedClassImmutable);
  }
}