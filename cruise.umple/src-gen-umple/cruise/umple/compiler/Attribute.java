/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents an attribute.
 */
// line 345 "../../../../src/Umple.ump"
// line 902 "../../../../src/Umple_Code.ump"
public class Attribute extends UmpleVariable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attribute Attributes
  private boolean isAutounique;
  private boolean isList;
  private boolean isDerived;
  private boolean isLazy;

  //Attribute Associations
  private List<Comment> comments;
  private UmpleClass umpleClass;
  private List<TraceRecord> traceRecords;
  private List<Attribute_TraceItem> attributeTraceItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Attribute(String aName, String aType, String aModifier, String aValue, boolean aIsAutounique, UmpleClass aUmpleClass)
  {
    super(aName, aType, aModifier, aValue);
    isAutounique = aIsAutounique;
    isList = false;
    isDerived = false;
    isLazy = false;
    comments = new ArrayList<Comment>();
    boolean didAddUmpleClass = setUmpleClass(aUmpleClass);
    if (!didAddUmpleClass)
    {
      throw new RuntimeException("Unable to create attribute due to umpleClass");
    }
    traceRecords = new ArrayList<TraceRecord>();
    attributeTraceItems = new ArrayList<Attribute_TraceItem>();
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

  public Attribute_TraceItem getAttributeTraceItem(int index)
  {
    Attribute_TraceItem aAttributeTraceItem = attributeTraceItems.get(index);
    return aAttributeTraceItem;
  }

  public List<Attribute_TraceItem> getAttributeTraceItems()
  {
    List<Attribute_TraceItem> newAttributeTraceItems = Collections.unmodifiableList(attributeTraceItems);
    return newAttributeTraceItems;
  }

  public int numberOfAttributeTraceItems()
  {
    int number = attributeTraceItems.size();
    return number;
  }

  public boolean hasAttributeTraceItems()
  {
    boolean has = attributeTraceItems.size() > 0;
    return has;
  }

  public int indexOfAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    int index = attributeTraceItems.indexOf(aAttributeTraceItem);
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

  public static int minimumNumberOfAttributeTraceItems()
  {
    return 0;
  }

  public boolean addAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    boolean wasAdded = false;
    if (attributeTraceItems.contains(aAttributeTraceItem)) { return false; }
    attributeTraceItems.add(aAttributeTraceItem);
    if (aAttributeTraceItem.indexOfAttribute(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttributeTraceItem.addAttribute(this);
      if (!wasAdded)
      {
        attributeTraceItems.remove(aAttributeTraceItem);
      }
    }
    return wasAdded;
  }

  public boolean removeAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
  {
    boolean wasRemoved = false;
    if (!attributeTraceItems.contains(aAttributeTraceItem))
    {
      return wasRemoved;
    }

    int oldIndex = attributeTraceItems.indexOf(aAttributeTraceItem);
    attributeTraceItems.remove(oldIndex);
    if (aAttributeTraceItem.indexOfAttribute(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttributeTraceItem.removeAttribute(this);
      if (!wasRemoved)
      {
        attributeTraceItems.add(oldIndex,aAttributeTraceItem);
      }
    }
    return wasRemoved;
  }

  public boolean addAttributeTraceItemAt(Attribute_TraceItem aAttributeTraceItem, int index)
  {  
    boolean wasAdded = false;
    if(addAttributeTraceItem(aAttributeTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttributeTraceItems()) { index = numberOfAttributeTraceItems() - 1; }
      attributeTraceItems.remove(aAttributeTraceItem);
      attributeTraceItems.add(index, aAttributeTraceItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAttributeTraceItemAt(Attribute_TraceItem aAttributeTraceItem, int index)
  {
    boolean wasAdded = false;
    if(attributeTraceItems.contains(aAttributeTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAttributeTraceItems()) { index = numberOfAttributeTraceItems() - 1; }
      attributeTraceItems.remove(aAttributeTraceItem);
      attributeTraceItems.add(index, aAttributeTraceItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAttributeTraceItemAt(aAttributeTraceItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    comments.clear();
    UmpleClass placeholderUmpleClass = umpleClass;
    this.umpleClass = null;
    placeholderUmpleClass.removeAttribute(this);
    ArrayList<TraceRecord> copyOfTraceRecords = new ArrayList<TraceRecord>(traceRecords);
    traceRecords.clear();
    for(TraceRecord aTraceRecord : copyOfTraceRecords)
    {
      aTraceRecord.removeAttribute(this);
    }
    ArrayList<Attribute_TraceItem> copyOfAttributeTraceItems = new ArrayList<Attribute_TraceItem>(attributeTraceItems);
    attributeTraceItems.clear();
    for(Attribute_TraceItem aAttributeTraceItem : copyOfAttributeTraceItems)
    {
      aAttributeTraceItem.removeAttribute(this);
    }
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 904 ../../../../src/Umple_Code.ump
  public boolean isConstant()
  {
    return "const".equals(getModifier());
  }  

  public boolean isPrimitive()
  {
    return getType() == null || "String".equals(getType()) || "Integer".equals(getType()) || "Double".equals(getType()) || "Boolean".equals(getType()) || "Date".equals(getType()) || "Time".equals(getType());
  }


  public boolean isImmutable()
  {
    boolean varIsImmutable = super.isImmutable();
    boolean classIsImmutable = (this.getUmpleClass() == null) ? false : getUmpleClass().isImmutable();

    return (varIsImmutable || classIsImmutable);
  }
}