/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import java.util.*;

/**
 * An UmpleTrait can contain attributes, associations, state machines and methods.
 * It can also have various other information such as a key (to identify uniqueness),
 * code to inject into generated code, and comments. It can be tagged with various
 * patterns.
 * An UmpleTrait can contain attributes, associations, state machines and methods.
 * It can also have various other information such as a key (to identify uniqueness),
 * code to inject into generated code, and comments. It can be tagged with various
 * patterns.
 * ----------------------------------------------------------
 * ----------------------------------------------------------
 * @umplesource Umple.ump 436
 * @umplesource Umple_Code_Trait.ump 29
 */
// line 436 "../../../../src/Umple.ump"
// line 29 "../../../../src/Umple_Code_Trait.ump"
public class UmpleTrait extends UmpleClassifier
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleTrait Attributes
  private boolean isAbstract;
  private boolean isSingleton;
  private List<Association> associations;
  private List<Method> unimplementedMethods;
  private Key key;

  /**
   * Specifies whether or not the Umple trait is immutable.
   */
  private boolean iAmImmutable;
  private boolean ancestorIsImmutable;
  private UmpleModel sourceModel;

  //UmpleTrait Associations
  private List<CodeInjection> codeInjections;
  private List<Precondition> preconditions;
  private List<Postcondition> postconditions;
  private List<Constraint> constraints;
  private List<UmpleTrait> extendsTraits;
  private UniqueIdentifier uniqueIdentifier;
  private List<Attribute> attributes;
  private List<AssociationVariable> associationVariables;
  private List<Comment> comments;
  private List<UmpleClass> subClasses;
  private List<UmpleTrait> subTraits;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleTrait(String aName, UmpleModel aSourceModel)
  {
    super(aName);
    isAbstract = false;
    isSingleton = false;
    associations = new ArrayList<Association>();
    unimplementedMethods = new ArrayList<Method>();
    key = new Key();
    iAmImmutable = false;
    ancestorIsImmutable = false;
    sourceModel = aSourceModel;
    codeInjections = new ArrayList<CodeInjection>();
    preconditions = new ArrayList<Precondition>();
    postconditions = new ArrayList<Postcondition>();
    constraints = new ArrayList<Constraint>();
    extendsTraits = new ArrayList<UmpleTrait>();
    attributes = new ArrayList<Attribute>();
    associationVariables = new ArrayList<AssociationVariable>();
    comments = new ArrayList<Comment>();
    subClasses = new ArrayList<UmpleClass>();
    subTraits = new ArrayList<UmpleTrait>();
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

  public boolean addUnimplementedMethod(Method aUnimplementedMethod)
  {
    boolean wasAdded = false;
    wasAdded = unimplementedMethods.add(aUnimplementedMethod);
    return wasAdded;
  }

  public boolean removeUnimplementedMethod(Method aUnimplementedMethod)
  {
    boolean wasRemoved = false;
    wasRemoved = unimplementedMethods.remove(aUnimplementedMethod);
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
   * Specifies whether or not the Umple trait is a singleton.
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

  public Method getUnimplementedMethod(int index)
  {
    Method aUnimplementedMethod = unimplementedMethods.get(index);
    return aUnimplementedMethod;
  }

  public Method[] getUnimplementedMethods()
  {
    Method[] newUnimplementedMethods = unimplementedMethods.toArray(new Method[unimplementedMethods.size()]);
    return newUnimplementedMethods;
  }

  public int numberOfUnimplementedMethods()
  {
    int number = unimplementedMethods.size();
    return number;
  }

  public boolean hasUnimplementedMethods()
  {
    boolean has = unimplementedMethods.size() > 0;
    return has;
  }

  public int indexOfUnimplementedMethod(Method aUnimplementedMethod)
  {
    int index = unimplementedMethods.indexOf(aUnimplementedMethod);
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
   * The possible Preconditions related to the Umple Trait
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

  public Postcondition getPostcondition(int index)
  {
    Postcondition aPostcondition = postconditions.get(index);
    return aPostcondition;
  }

  /**
   * The possible Preconditions related to the Umple Trait
   */
  public List<Postcondition> getPostconditions()
  {
    List<Postcondition> newPostconditions = Collections.unmodifiableList(postconditions);
    return newPostconditions;
  }

  public int numberOfPostconditions()
  {
    int number = postconditions.size();
    return number;
  }

  public boolean hasPostconditions()
  {
    boolean has = postconditions.size() > 0;
    return has;
  }

  public int indexOfPostcondition(Postcondition aPostcondition)
  {
    int index = postconditions.indexOf(aPostcondition);
    return index;
  }

  public Constraint getConstraint(int index)
  {
    Constraint aConstraint = constraints.get(index);
    return aConstraint;
  }

  /**
   * The possible Constraints related to the Umple Trait
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

  public UmpleTrait getExtendsTrait(int index)
  {
    UmpleTrait aExtendsTrait = extendsTraits.get(index);
    return aExtendsTrait;
  }

  /**
   * The Umple Trait's super Traits (if there are ones).
   */
  public List<UmpleTrait> getExtendsTraits()
  {
    List<UmpleTrait> newExtendsTraits = Collections.unmodifiableList(extendsTraits);
    return newExtendsTraits;
  }

  public int numberOfExtendsTraits()
  {
    int number = extendsTraits.size();
    return number;
  }

  public boolean hasExtendsTraits()
  {
    boolean has = extendsTraits.size() > 0;
    return has;
  }

  public int indexOfExtendsTrait(UmpleTrait aExtendsTrait)
  {
    int index = extendsTraits.indexOf(aExtendsTrait);
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
   * The attributes contained within the Umple trait.
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
   * The associations contained within the Umple trait.
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
   * The comments associated with the Umple Trait (such as the Javadoc above it).
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

  public UmpleClass getSubClass(int index)
  {
    UmpleClass aSubClass = subClasses.get(index);
    return aSubClass;
  }

  public List<UmpleClass> getSubClasses()
  {
    List<UmpleClass> newSubClasses = Collections.unmodifiableList(subClasses);
    return newSubClasses;
  }

  public int numberOfSubClasses()
  {
    int number = subClasses.size();
    return number;
  }

  public boolean hasSubClasses()
  {
    boolean has = subClasses.size() > 0;
    return has;
  }

  public int indexOfSubClass(UmpleClass aSubClass)
  {
    int index = subClasses.indexOf(aSubClass);
    return index;
  }

  public UmpleTrait getSubTrait(int index)
  {
    UmpleTrait aSubTrait = subTraits.get(index);
    return aSubTrait;
  }

  public List<UmpleTrait> getSubTraits()
  {
    List<UmpleTrait> newSubTraits = Collections.unmodifiableList(subTraits);
    return newSubTraits;
  }

  public int numberOfSubTraits()
  {
    int number = subTraits.size();
    return number;
  }

  public boolean hasSubTraits()
  {
    boolean has = subTraits.size() > 0;
    return has;
  }

  public int indexOfSubTrait(UmpleTrait aSubTrait)
  {
    int index = subTraits.indexOf(aSubTrait);
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

  public static int minimumNumberOfPostconditions()
  {
    return 0;
  }

  public boolean addPostcondition(Postcondition aPostcondition)
  {
    boolean wasAdded = false;
    if (postconditions.contains(aPostcondition)) { return false; }
    postconditions.add(aPostcondition);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePostcondition(Postcondition aPostcondition)
  {
    boolean wasRemoved = false;
    if (postconditions.contains(aPostcondition))
    {
      postconditions.remove(aPostcondition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPostconditionAt(Postcondition aPostcondition, int index)
  {  
    boolean wasAdded = false;
    if(addPostcondition(aPostcondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPostconditions()) { index = numberOfPostconditions() - 1; }
      postconditions.remove(aPostcondition);
      postconditions.add(index, aPostcondition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePostconditionAt(Postcondition aPostcondition, int index)
  {
    boolean wasAdded = false;
    if(postconditions.contains(aPostcondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPostconditions()) { index = numberOfPostconditions() - 1; }
      postconditions.remove(aPostcondition);
      postconditions.add(index, aPostcondition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPostconditionAt(aPostcondition, index);
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

  public static int minimumNumberOfExtendsTraits()
  {
    return 0;
  }

  public boolean addExtendsTrait(UmpleTrait aExtendsTrait)
  {
    boolean wasAdded = false;
    if (extendsTraits.contains(aExtendsTrait)) { return false; }
    extendsTraits.add(aExtendsTrait);
    if (aExtendsTrait.indexOfSubTrait(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aExtendsTrait.addSubTrait(this);
      if (!wasAdded)
      {
        extendsTraits.remove(aExtendsTrait);
      }
    }
    return wasAdded;
  }

  public boolean removeExtendsTrait(UmpleTrait aExtendsTrait)
  {
    boolean wasRemoved = false;
    if (!extendsTraits.contains(aExtendsTrait))
    {
      return wasRemoved;
    }

    int oldIndex = extendsTraits.indexOf(aExtendsTrait);
    extendsTraits.remove(oldIndex);
    if (aExtendsTrait.indexOfSubTrait(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aExtendsTrait.removeSubTrait(this);
      if (!wasRemoved)
      {
        extendsTraits.add(oldIndex,aExtendsTrait);
      }
    }
    return wasRemoved;
  }

  public boolean addExtendsTraitAt(UmpleTrait aExtendsTrait, int index)
  {  
    boolean wasAdded = false;
    if(addExtendsTrait(aExtendsTrait))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExtendsTraits()) { index = numberOfExtendsTraits() - 1; }
      extendsTraits.remove(aExtendsTrait);
      extendsTraits.add(index, aExtendsTrait);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExtendsTraitAt(UmpleTrait aExtendsTrait, int index)
  {
    boolean wasAdded = false;
    if(extendsTraits.contains(aExtendsTrait))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExtendsTraits()) { index = numberOfExtendsTraits() - 1; }
      extendsTraits.remove(aExtendsTrait);
      extendsTraits.add(index, aExtendsTrait);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExtendsTraitAt(aExtendsTrait, index);
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

  public boolean addAttribute(Attribute aAttribute)
  {
    boolean wasAdded = false;
    if (attributes.contains(aAttribute)) { return false; }
    UmpleTrait existingUmpleTrait = aAttribute.getUmpleTrait();
    if (existingUmpleTrait == null)
    {
      aAttribute.setUmpleTrait(this);
    }
    else if (!this.equals(existingUmpleTrait))
    {
      existingUmpleTrait.removeAttribute(aAttribute);
      addAttribute(aAttribute);
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
    if (attributes.contains(aAttribute))
    {
      attributes.remove(aAttribute);
      aAttribute.setUmpleTrait(null);
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
    if (associationVariables.contains(aAssociationVariable)) { return false; }
    UmpleTrait existingUmpleTrait = aAssociationVariable.getUmpleTrait();
    if (existingUmpleTrait == null)
    {
      aAssociationVariable.setUmpleTrait(this);
    }
    else if (!this.equals(existingUmpleTrait))
    {
      existingUmpleTrait.removeAssociationVariable(aAssociationVariable);
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
      aAssociationVariable.setUmpleTrait(null);
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

  public static int minimumNumberOfSubClasses()
  {
    return 0;
  }

  public boolean addSubClass(UmpleClass aSubClass)
  {
    boolean wasAdded = false;
    if (subClasses.contains(aSubClass)) { return false; }
    subClasses.add(aSubClass);
    if (aSubClass.indexOfExtendsTrait(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSubClass.addExtendsTrait(this);
      if (!wasAdded)
      {
        subClasses.remove(aSubClass);
      }
    }
    return wasAdded;
  }

  public boolean removeSubClass(UmpleClass aSubClass)
  {
    boolean wasRemoved = false;
    if (!subClasses.contains(aSubClass))
    {
      return wasRemoved;
    }

    int oldIndex = subClasses.indexOf(aSubClass);
    subClasses.remove(oldIndex);
    if (aSubClass.indexOfExtendsTrait(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSubClass.removeExtendsTrait(this);
      if (!wasRemoved)
      {
        subClasses.add(oldIndex,aSubClass);
      }
    }
    return wasRemoved;
  }

  public boolean addSubClassAt(UmpleClass aSubClass, int index)
  {  
    boolean wasAdded = false;
    if(addSubClass(aSubClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubClasses()) { index = numberOfSubClasses() - 1; }
      subClasses.remove(aSubClass);
      subClasses.add(index, aSubClass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubClassAt(UmpleClass aSubClass, int index)
  {
    boolean wasAdded = false;
    if(subClasses.contains(aSubClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubClasses()) { index = numberOfSubClasses() - 1; }
      subClasses.remove(aSubClass);
      subClasses.add(index, aSubClass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubClassAt(aSubClass, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSubTraits()
  {
    return 0;
  }

  public boolean addSubTrait(UmpleTrait aSubTrait)
  {
    boolean wasAdded = false;
    if (subTraits.contains(aSubTrait)) { return false; }
    subTraits.add(aSubTrait);
    if (aSubTrait.indexOfExtendsTrait(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aSubTrait.addExtendsTrait(this);
      if (!wasAdded)
      {
        subTraits.remove(aSubTrait);
      }
    }
    return wasAdded;
  }

  public boolean removeSubTrait(UmpleTrait aSubTrait)
  {
    boolean wasRemoved = false;
    if (!subTraits.contains(aSubTrait))
    {
      return wasRemoved;
    }

    int oldIndex = subTraits.indexOf(aSubTrait);
    subTraits.remove(oldIndex);
    if (aSubTrait.indexOfExtendsTrait(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aSubTrait.removeExtendsTrait(this);
      if (!wasRemoved)
      {
        subTraits.add(oldIndex,aSubTrait);
      }
    }
    return wasRemoved;
  }

  public boolean addSubTraitAt(UmpleTrait aSubTrait, int index)
  {  
    boolean wasAdded = false;
    if(addSubTrait(aSubTrait))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubTraits()) { index = numberOfSubTraits() - 1; }
      subTraits.remove(aSubTrait);
      subTraits.add(index, aSubTrait);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSubTraitAt(UmpleTrait aSubTrait, int index)
  {
    boolean wasAdded = false;
    if(subTraits.contains(aSubTrait))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSubTraits()) { index = numberOfSubTraits() - 1; }
      subTraits.remove(aSubTrait);
      subTraits.add(index, aSubTrait);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSubTraitAt(aSubTrait, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    codeInjections.clear();
    preconditions.clear();
    postconditions.clear();
    constraints.clear();
    ArrayList<UmpleTrait> copyOfExtendsTraits = new ArrayList<UmpleTrait>(extendsTraits);
    extendsTraits.clear();
    for(UmpleTrait aExtendsTrait : copyOfExtendsTraits)
    {
      aExtendsTrait.removeSubTrait(this);
    }
    uniqueIdentifier = null;
    while( !attributes.isEmpty() )
    {
      attributes.get(0).setUmpleTrait(null);
    }
    while( !associationVariables.isEmpty() )
    {
      associationVariables.get(0).setUmpleTrait(null);
    }
    comments.clear();
    ArrayList<UmpleClass> copyOfSubClasses = new ArrayList<UmpleClass>(subClasses);
    subClasses.clear();
    for(UmpleClass aSubClass : copyOfSubClasses)
    {
      aSubClass.removeExtendsTrait(this);
    }
    ArrayList<UmpleTrait> copyOfSubTraits = new ArrayList<UmpleTrait>(subTraits);
    subTraits.clear();
    for(UmpleTrait aSubTrait : copyOfSubTraits)
    {
      aSubTrait.removeExtendsTrait(this);
    }
    super.delete();
  }

  @umplesourcefile(line={34},file={"Umple_Code_Trait.ump"},javaline={1293},length={13})
   public boolean setImmutable(){
    boolean wasSet = false;
    	/*
    	if (extendsTraits != null && !ancestorIsImmutable) { return wasSet; }
    
    	if (propagateImmutabilityToAllRelationships(true)) 
    	{ 
      	iAmImmutable = true;
      	wasSet = true;
    	}	
    	*/
    	return wasSet;
  }

  @umplesourcefile(line={47},file={"Umple_Code_Trait.ump"},javaline={1308},length={27})
   public boolean hasMethod(Method comparedMethod){
    String methodName = comparedMethod.getName();
    int numberOfParams = comparedMethod.getMethodParameters().size();
    for (Method aMethod : this.getMethods()){
      // Compare method names
      if (aMethod.getName().equals(methodName)){  
        // Now compare parameters
        if (numberOfParams == aMethod.getMethodParameters().size())
        {
          boolean allSame = true;
          for (int i = 0; i < numberOfParams; i++)
          {
            if(!aMethod.getMethodParameter(i).getType().equals(comparedMethod.getMethodParameter(i).getType()))
            {
              allSame = false;
              break;
            }
          }
          if(allSame)
          {
            return true;
          }
        }
      }
    }
    return false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isAbstract" + ":" + getIsAbstract()+ "," +
            "isSingleton" + ":" + getIsSingleton()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "key" + "=" + (getKey() != null ? !getKey().equals(this)  ? getKey().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sourceModel" + "=" + (getSourceModel() != null ? !getSourceModel().equals(this)  ? getSourceModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "uniqueIdentifier = "+(getUniqueIdentifier()!=null?Integer.toHexString(System.identityHashCode(getUniqueIdentifier())):"null")
     + outputString;
  }
}