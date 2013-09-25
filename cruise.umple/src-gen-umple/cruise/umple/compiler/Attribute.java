/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents an attribute.
 * An attribute is more abstract than an instance variable / property in that
 * it can be derived, and have various other modifiers such as being
 * initialized, lazy (does not appear in constructor and must be initialized
 * after construction), etc.
 * @umplesource Umple.ump 468
 * @umplesource Umple_Code.ump 1187
 */
// line 468 "../../../../src/Umple.ump"
// line 1187 "../../../../src/Umple_Code.ump"
public class Attribute extends UmpleVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attribute Attributes
  private boolean isAutounique;
  private boolean isList;
  private boolean isDerived;
  private CodeBlock codeblock;
  private boolean isLazy;

  //Attribute Associations
  private List<Comment> comments;
  private Position position;
  private Position endPosition;
  private UmpleClass umpleClass;
  private List<TraceRecord> traceRecords;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={482},file={"Umple.ump"},javaline={62},length={1})
  public Attribute(String aName, String aType, String aModifier, String aValue, boolean aIsAutounique, UmpleClass aUmpleClass)
  {
    super(aName, aType, aModifier, aValue);
    isAutounique = aIsAutounique;
    isList = false;
    isDerived = false;
    codeblock = null;
    isLazy = false;
    comments = new ArrayList<Comment>();
    boolean didAddUmpleClass = setUmpleClass(aUmpleClass);
    if (!didAddUmpleClass)
    {
      throw new RuntimeException("Unable to create attribute due to umpleClass");
    }
    traceRecords = new ArrayList<TraceRecord>();
    // line 482 "../../../../src/Umple.ump"
    codeblock = aValue!=null ? new CodeBlock(aValue) : new CodeBlock();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsAutounique(boolean aIsAutounique)
  {
    boolean wasSet = false;
    isAutounique = aIsAutounique;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsList(boolean aIsList)
  {
    boolean wasSet = false;
    isList = aIsList;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDerived(boolean aIsDerived)
  {
    boolean wasSet = false;
    isDerived = aIsDerived;
    wasSet = true;
    return wasSet;
  }

  public boolean setCodeblock(CodeBlock aCodeblock)
  {
    boolean wasSet = false;
    codeblock = aCodeblock;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsLazy(boolean aIsLazy)
  {
    boolean wasSet = false;
    isLazy = aIsLazy;
    wasSet = true;
    return wasSet;
  }

  /**
   * Specifies whether or not the method parameter is auto unique.
   */
  public boolean getIsAutounique()
  {
    return isAutounique;
  }

  /**
   * TODO: should default to false, but constructors would need updating
   * Specifies whether or not the method parameter is a list.
   */
  public boolean getIsList()
  {
    return isList;
  }

  /**
   * Specifies whether or not the method parameter is derived.
   */
  public boolean getIsDerived()
  {
    return isDerived;
  }

  public CodeBlock getCodeblock()
  {
    return codeblock;
  }

  /**
   * Specifies whether or not the method parameter is lazy.
   */
  public boolean getIsLazy()
  {
    return isLazy;
  }

  public boolean isIsAutounique()
  {
    return isAutounique;
  }

  public boolean isIsList()
  {
    return isList;
  }

  public boolean isIsDerived()
  {
    return isDerived;
  }

  public boolean isIsLazy()
  {
    return isLazy;
  }

  public Comment getComment(int index)
  {
    Comment aComment = comments.get(index);
    return aComment;
  }

  /**
   * The comments associated with the attribute (such as the Javadoc above it).
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

  public Position getPosition()
  {
    return position;
  }

  public Position getEndPosition()
  {
    return endPosition;
  }

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public TraceRecord getTraceRecord(int index)
  {
    TraceRecord aTraceRecord = traceRecords.get(index);
    return aTraceRecord;
  }

  public List<TraceRecord> getTraceRecords()
  {
    List<TraceRecord> newTraceRecords = Collections.unmodifiableList(traceRecords);
    return newTraceRecords;
  }

  public int numberOfTraceRecords()
  {
    int number = traceRecords.size();
    return number;
  }

  public boolean hasTraceRecords()
  {
    boolean has = traceRecords.size() > 0;
    return has;
  }

  public int indexOfTraceRecord(TraceRecord aTraceRecord)
  {
    int index = traceRecords.indexOf(aTraceRecord);
    return index;
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

  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    position = aNewPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndPosition(Position aNewEndPosition)
  {
    boolean wasSet = false;
    endPosition = aNewEndPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    if (aUmpleClass == null)
    {
      return wasSet;
    }

    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeAttribute(this);
    }
    umpleClass.addAttribute(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfTraceRecords()
  {
    return 0;
  }

  public boolean addTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasAdded = false;
    if (traceRecords.contains(aTraceRecord)) { return false; }
    traceRecords.add(aTraceRecord);
    if (aTraceRecord.indexOfAttribute(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceRecord.addAttribute(this);
      if (!wasAdded)
      {
        traceRecords.remove(aTraceRecord);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceRecord(TraceRecord aTraceRecord)
  {
    boolean wasRemoved = false;
    if (!traceRecords.contains(aTraceRecord))
    {
      return wasRemoved;
    }

    int oldIndex = traceRecords.indexOf(aTraceRecord);
    traceRecords.remove(oldIndex);
    if (aTraceRecord.indexOfAttribute(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceRecord.removeAttribute(this);
      if (!wasRemoved)
      {
        traceRecords.add(oldIndex,aTraceRecord);
      }
    }
    return wasRemoved;
  }

  public boolean addTraceRecordAt(TraceRecord aTraceRecord, int index)
  {  
    boolean wasAdded = false;
    if(addTraceRecord(aTraceRecord))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceRecords()) { index = numberOfTraceRecords() - 1; }
      traceRecords.remove(aTraceRecord);
      traceRecords.add(index, aTraceRecord);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTraceRecordAt(TraceRecord aTraceRecord, int index)
  {
    boolean wasAdded = false;
    if(traceRecords.contains(aTraceRecord))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTraceRecords()) { index = numberOfTraceRecords() - 1; }
      traceRecords.remove(aTraceRecord);
      traceRecords.add(index, aTraceRecord);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTraceRecordAt(aTraceRecord, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    comments.clear();
    position = null;
    endPosition = null;
    UmpleClass placeholderUmpleClass = umpleClass;
    this.umpleClass = null;
    placeholderUmpleClass.removeAttribute(this);
    ArrayList<TraceRecord> copyOfTraceRecords = new ArrayList<TraceRecord>(traceRecords);
    traceRecords.clear();
    for(TraceRecord aTraceRecord : copyOfTraceRecords)
    {
      aTraceRecord.removeAttribute(this);
    }
    super.delete();
  }

  @umplesourcefile(line={1189},file={"Umple_Code.ump"},javaline={437},length={3})
   public boolean isConstant(){
    return "const".equals(getModifier());
  }

  @umplesourcefile(line={1194},file={"Umple_Code.ump"},javaline={442},length={3})
   public boolean isPrimitive(){
    return getType() == null || "String".equals(getType()) || "Integer".equals(getType()) || "Double".equals(getType()) || "Boolean".equals(getType()) || "Date".equals(getType()) || "Time".equals(getType());
  }

  @umplesourcefile(line={1200},file={"Umple_Code.ump"},javaline={447},length={6})
   public boolean isImmutable(){
    boolean varIsImmutable = super.isImmutable();
    boolean classIsImmutable = (this.getUmpleClass() == null) ? false : getUmpleClass().isImmutable();

    return (varIsImmutable || classIsImmutable);
  }

  @umplesourcefile(line={1208},file={"Umple_Code.ump"},javaline={455},length={3})
   public String getValue(){
    return codeblock.getCode()!=null ? codeblock.getCode() : super.getValue();
  }

  @umplesourcefile(line={1212},file={"Umple_Code.ump"},javaline={460},length={3})
   public void setValue(String lang, String code){
    codeblock.setCode(lang,code);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isAutounique" + ":" + getIsAutounique()+ "," +
            "isList" + ":" + getIsList()+ "," +
            "isDerived" + ":" + getIsDerived()+ "," +
            "isLazy" + ":" + getIsLazy()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "codeblock" + "=" + (getCodeblock() != null ? !getCodeblock().equals(this)  ? getCodeblock().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "endPosition = "+(getEndPosition()!=null?Integer.toHexString(System.identityHashCode(getEndPosition())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass = "+(getUmpleClass()!=null?Integer.toHexString(System.identityHashCode(getUmpleClass())):"null")
     + outputString;
  }
}