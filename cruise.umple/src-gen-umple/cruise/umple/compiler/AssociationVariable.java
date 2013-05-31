/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * An association variable represents one of the variables used to represent
 * an association. In a two-directional association (navigable) there would
 * be one of these in each associated class.
 * 
 * See also AssociationEnd
 * 
 * TODO: Code smell. Should be replaced by the 'otherEnd' of the AssociationEnd
 * In Umple_Code.ump: Methods for testing various complex properties
 * @umplesource Umple.ump 541
 * @umplesource Umple_Code.ump 1347
 */
// line 541 "../../../../src/Umple.ump"
// line 1347 "../../../../src/Umple_Code.ump"
public class AssociationVariable extends UmpleVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssociationVariable Attributes
  private Multiplicity multiplicity;
  private boolean isNavigable;
  private String priority;

  //AssociationVariable Associations
  private AssociationVariable relatedAssociation;
  private List<Comment> comments;
  private UmpleClass umpleClass;
  private TraceDirective traceDirective;

  //Helper Variables
  private boolean canSetIsNavigable;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssociationVariable(String aName, String aType, String aModifier, String aValue, Multiplicity aMultiplicity, boolean aIsNavigable)
  {
    super(aName, aType, aModifier, aValue);
    multiplicity = aMultiplicity;
    isNavigable = aIsNavigable;
    canSetIsNavigable = false;
    priority = "";
    comments = new ArrayList<Comment>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMultiplicity(Multiplicity aMultiplicity)
  {
    boolean wasSet = false;
    multiplicity = aMultiplicity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPriority(String aPriority)
  {
    boolean wasSet = false;
    priority = aPriority;
    wasSet = true;
    return wasSet;
  }

  public Multiplicity getMultiplicity()
  {
    return multiplicity;
  }

  public boolean getIsNavigable()
  {
    return isNavigable;
  }

  public String getPriority()
  {
    return priority;
  }

  public boolean isIsNavigable()
  {
    return isNavigable;
  }

  public AssociationVariable getRelatedAssociation()
  {
    return relatedAssociation;
  }

  public Comment getComment(int index)
  {
    Comment aComment = comments.get(index);
    return aComment;
  }

  /**
   * The comments associated with the association (such as the Javadoc above it).
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

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public TraceDirective getTraceDirective()
  {
    return traceDirective;
  }

  @umplesourcefile(line={555},file={"Umple.ump"},javaline={153},length={1})
  public boolean setRelatedAssociation(AssociationVariable aNewRelatedAssociation)
  {
    boolean wasSet = false;
    // line 555 "../../../../src/Umple.ump"
    if(!canBeRelatedAssociation(aNewRelatedAssociation)) { return false; }
    if (aNewRelatedAssociation == null)
    {
      AssociationVariable existingRelatedAssociation = relatedAssociation;
      relatedAssociation = null;
      
      if (existingRelatedAssociation != null && existingRelatedAssociation.getRelatedAssociation() != null)
      {
        existingRelatedAssociation.setRelatedAssociation(null);
      }
      wasSet = true;
      return wasSet;
    }

    AssociationVariable currentRelatedAssociation = getRelatedAssociation();
    if (currentRelatedAssociation != null && !currentRelatedAssociation.equals(aNewRelatedAssociation))
    {
      currentRelatedAssociation.setRelatedAssociation(null);
    }

    relatedAssociation = aNewRelatedAssociation;
    AssociationVariable existingRelatedAssociation = aNewRelatedAssociation.getRelatedAssociation();

    if (!equals(existingRelatedAssociation))
    {
      aNewRelatedAssociation.setRelatedAssociation(this);
    }
    wasSet = true;
    return wasSet;
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

  @umplesourcefile(line={553},file={"Umple.ump"},javaline={245},length={1})
  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    // line 553 "../../../../src/Umple.ump"
    if ((aUmpleClass != null) && !aUmpleClass.immutabilityAssociationRulesSatisfied(this, aUmpleClass.isImmutable())) { return false; }
    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeAssociationVariable(this);
    }
    if (aUmpleClass != null)
    {
      aUmpleClass.addAssociationVariable(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceDirective(TraceDirective aNewTraceDirective)
  {
    boolean wasSet = false;
    if (aNewTraceDirective == null)
    {
      TraceDirective existingTraceDirective = traceDirective;
      traceDirective = null;
      
      if (existingTraceDirective != null && existingTraceDirective.getAssociationVariable() != null)
      {
        existingTraceDirective.setAssociationVariable(null);
      }
      wasSet = true;
      return wasSet;
    }

    TraceDirective currentTraceDirective = getTraceDirective();
    if (currentTraceDirective != null && !currentTraceDirective.equals(aNewTraceDirective))
    {
      currentTraceDirective.setAssociationVariable(null);
    }

    traceDirective = aNewTraceDirective;
    AssociationVariable existingAssociationVariable = aNewTraceDirective.getAssociationVariable();

    if (!equals(existingAssociationVariable))
    {
      aNewTraceDirective.setAssociationVariable(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (relatedAssociation != null)
    {
      relatedAssociation.setRelatedAssociation(null);
    }
    comments.clear();
    if (umpleClass != null)
    {
      UmpleClass placeholderUmpleClass = umpleClass;
      this.umpleClass = null;
      placeholderUmpleClass.removeAssociationVariable(this);
    }
    if (traceDirective != null)
    {
      traceDirective.setAssociationVariable(null);
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "isNavigable" + ":" + getIsNavigable()+ "," +
            "priority" + ":" + getPriority()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "traceDirective" + "=" + (getMultiplicity() != null ? !getMultiplicity().equals(this)  ? getMultiplicity().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass" + "=" + (getRelatedAssociation() != null ? !getRelatedAssociation().equals(this)  ? getRelatedAssociation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "relatedAssociation" + "=" + (getUmpleClass() != null ? !getUmpleClass().equals(this)  ? getUmpleClass().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "multiplicity" + "=" + (getTraceDirective() != null ? !getTraceDirective().equals(this)  ? getTraceDirective().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 1349 ../../../../src/Umple_Code.ump
  @umplesourcefile(line={1349},file={"Umple_Code.ump"},javaline={331},length={4})
  public boolean isReflexive()
  {
    return getRelatedAssociation() != null && getType().equals(getRelatedAssociation().getType());
  }

  @umplesourcefile(line={1354},file={"Umple_Code.ump"},javaline={337},length={4})
  public boolean isSymmetricReflexive()
  {
    return getRelatedAssociation() != null && "symmetricreflexive".equals(getModifier());
  }

  @umplesourcefile(line={1359},file={"Umple_Code.ump"},javaline={343},length={12})
  public void configureRelatedAssociation(AssociationVariable newRelatedAssociation)
  {
    if (newRelatedAssociation == null || !getType().equals(newRelatedAssociation.getType()))
    {
      setRelatedAssociation(newRelatedAssociation);
    }
    else
    {
      multiplicity.minimizeRange(newRelatedAssociation.getMultiplicity());
      setRelatedAssociation(this);
    }
  }

  @umplesourcefile(line={1372},file={"Umple_Code.ump"},javaline={357},length={4})
  public static int min(int first, int second)
  {
    return first == -1 ? second : second == -1 ? first : Math.min(first, second);
  }

  @umplesourcefile(line={1377},file={"Umple_Code.ump"},javaline={363},length={4})
  public static int max(int first, int second)
  {
    return first == -1 ? first : second == -1 ? second : Math.max(first, second);
  }

  @umplesourcefile(line={1382},file={"Umple_Code.ump"},javaline={369},length={4})
  public boolean isMany()
  {
    return multiplicity.getUpperBound() == -1 || multiplicity.getUpperBound() > 1;
  }

  @umplesourcefile(line={1387},file={"Umple_Code.ump"},javaline={375},length={4})
  public boolean isOptionalN()
  {
    return multiplicity.getLowerBound() == 0 && multiplicity.getUpperBound() > 1;
  }

  @umplesourcefile(line={1392},file={"Umple_Code.ump"},javaline={381},length={4})
  public boolean isOne()
  {
    return multiplicity.getUpperBound() == 1;
  }

  @umplesourcefile(line={1397},file={"Umple_Code.ump"},javaline={387},length={4})
  public boolean isOnlyOne()
  {
    return multiplicity.getUpperBound() == 1 && multiplicity.getLowerBound() == 1;
  }

  @umplesourcefile(line={1402},file={"Umple_Code.ump"},javaline={393},length={4})
  public boolean isOptionalOne()
  {
    return multiplicity.getUpperBound() == 1 && multiplicity.getLowerBound() == 0;
  }

  @umplesourcefile(line={1407},file={"Umple_Code.ump"},javaline={399},length={4})
  public boolean isOptionalMany()
  {
    return multiplicity.getLowerBound() == 0 && isMany();
  }
  
  @umplesourcefile(line={1412},file={"Umple_Code.ump"},javaline={405},length={4})
  public boolean isUpperBounded()
  {
    return multiplicity.getUpperBound() >= 0;
  }

  @umplesourcefile(line={1417},file={"Umple_Code.ump"},javaline={411},length={4})
  public boolean isN()
  {
    return multiplicity.getLowerBound() > 1 && multiplicity.getLowerBound() == multiplicity.getUpperBound();
  }

  @umplesourcefile(line={1422},file={"Umple_Code.ump"},javaline={417},length={4})
  public boolean isMN()
  {
    return multiplicity.getLowerBound() > 0 && (multiplicity.getUpperBound() > multiplicity.getLowerBound() || multiplicity.getUpperBound() == -1);
  }

  @umplesourcefile(line={1427},file={"Umple_Code.ump"},javaline={423},length={4})
  public boolean isMStar()
  {
    return multiplicity.getLowerBound() > 0 && multiplicity.getUpperBound() == -1;
  }

  @umplesourcefile(line={1432},file={"Umple_Code.ump"},javaline={429},length={4})
  public boolean isStar()
  {
    return multiplicity.getUpperBound() == -1;
  }

  @umplesourcefile(line={1437},file={"Umple_Code.ump"},javaline={435},length={4})
  public boolean isMandatory()
  {
    return multiplicity.getLowerBound() > 0;
  }

  @umplesourcefile(line={1442},file={"Umple_Code.ump"},javaline={441},length={4})
  public boolean isMandatoryOne()
  {
    return multiplicity.getLowerBound() == 1 && multiplicity.getUpperBound() == 1;
  }

  @umplesourcefile(line={1447},file={"Umple_Code.ump"},javaline={447},length={4})
  public boolean isMandatoryMany()
  {
    return multiplicity.getLowerBound() > 0 && isMany();
  }

  @umplesourcefile(line={1452},file={"Umple_Code.ump"},javaline={453},length={13})
  public boolean isImmutable()
  {
    AssociationVariable related = getRelatedAssociation();
    Boolean relatedAssocIsImmutable = (related == null) ? false : "immutable".equals(related.getModifier());

    Boolean myUmpleClassIsImmutable = 
      (getIsNavigable() && getUmpleClass() != null) ? getUmpleClass().isImmutable() : false;
    Boolean yourUmpleClassIsImmutable = 
      (related != null && related.getIsNavigable() && related.getUmpleClass() != null) ? related.getUmpleClass().isImmutable() : false;

    return (super.isImmutable() || relatedAssocIsImmutable 
        || myUmpleClassIsImmutable || yourUmpleClassIsImmutable);
  }

  @umplesourcefile(line={1466},file={"Umple_Code.ump"},javaline={468},length={10})
  public boolean setImmutable()
  {
    boolean wasSet = false;
    if (canBeImmutable())
    {
      setModifier("immutable");
      wasSet = true;
    }
    return wasSet;
  }

  @umplesourcefile(line={1477},file={"Umple_Code.ump"},javaline={480},length={4})
  public boolean isSorted()
  {
    return !priority.equals("");
  }

  @umplesourcefile(line={1482},file={"Umple_Code.ump"},javaline={486},length={20})
  private boolean canBeImmutable()
  {
    AssociationVariable related = getRelatedAssociation();
    if (related == null) { return true; }

    boolean canBe = true;
    if (getIsNavigable() && related.getIsNavigable())
    {
      canBe = false;
    }
    else if (related.getIsNavigable() && (umpleClass != null) && !umpleClass.isImmutable())
    {
      canBe = false;
    }
    else if (getIsNavigable() && (related.getUmpleClass() != null) && !related.getUmpleClass().isImmutable())
    {
      canBe = false;
    }
    return canBe;
  }

  @umplesourcefile(line={1503},file={"Umple_Code.ump"},javaline={508},length={12})
  private boolean canBeRelatedAssociation(AssociationVariable related)
  {
    if (related == null)
    {
      return true;
    }
    Boolean myUmpleClassIsImmutable = (getUmpleClass() != null) ? getUmpleClass().isImmutable() : false;
    Boolean yourUmpleClassIsImmutable = (related.getUmpleClass() != null) ? related.getUmpleClass().isImmutable() : false;

    return UmpleClass.immutabilityAssociationRulesSatisfied(this, umpleClass, myUmpleClassIsImmutable, 
        related, related.getUmpleClass(), yourUmpleClassIsImmutable);
  }

}