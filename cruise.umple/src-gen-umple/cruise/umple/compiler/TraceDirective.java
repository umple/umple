/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * A statement found in Umple that directs code to be generated
 * to trace a model element and generate output using some tracing tool
 * @umplesource Trace.ump 70
 */
// line 70 "../../../../src/Trace.ump"
public class TraceDirective
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceDirective Attributes
  private int id;

  //TraceDirective Associations
  private Tracer tracer;
  private List<AttributeTraceItem> attributeTraceItems;
  private List<StateMachineTraceItem> stateMachineTraceItems;
  private List<MethodTraceEntity> methodTraceEntities;
  private AssociationVariable associationVariable;
  private List<TraceCondition> condition;
  private TraceRecord traceRecord;
  private List<TraceCase> traceCases;
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceDirective(Tracer aTracer)
  {
    id = 0;
    if (!setTracer(aTracer))
    {
      throw new RuntimeException("Unable to create TraceDirective due to aTracer");
    }
    attributeTraceItems = new ArrayList<AttributeTraceItem>();
    stateMachineTraceItems = new ArrayList<StateMachineTraceItem>();
    methodTraceEntities = new ArrayList<MethodTraceEntity>();
    condition = new ArrayList<TraceCondition>();
    traceCases = new ArrayList<TraceCase>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  @umplesourcefile(line={74},file={"Trace.ump"},javaline={75},length={2})
  public String getTracerType()
  {
    return getTracer().getName();
  }

  public Tracer getTracer()
  {
    return tracer;
  }

  public AttributeTraceItem getAttributeTraceItem(int index)
  {
    AttributeTraceItem aAttributeTraceItem = attributeTraceItems.get(index);
    return aAttributeTraceItem;
  }

  public List<AttributeTraceItem> getAttributeTraceItems()
  {
    List<AttributeTraceItem> newAttributeTraceItems = Collections.unmodifiableList(attributeTraceItems);
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

  public int indexOfAttributeTraceItem(AttributeTraceItem aAttributeTraceItem)
  {
    int index = attributeTraceItems.indexOf(aAttributeTraceItem);
    return index;
  }

  public StateMachineTraceItem getStateMachineTraceItem(int index)
  {
    StateMachineTraceItem aStateMachineTraceItem = stateMachineTraceItems.get(index);
    return aStateMachineTraceItem;
  }

  public List<StateMachineTraceItem> getStateMachineTraceItems()
  {
    List<StateMachineTraceItem> newStateMachineTraceItems = Collections.unmodifiableList(stateMachineTraceItems);
    return newStateMachineTraceItems;
  }

  public int numberOfStateMachineTraceItems()
  {
    int number = stateMachineTraceItems.size();
    return number;
  }

  public boolean hasStateMachineTraceItems()
  {
    boolean has = stateMachineTraceItems.size() > 0;
    return has;
  }

  public int indexOfStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    int index = stateMachineTraceItems.indexOf(aStateMachineTraceItem);
    return index;
  }

  public MethodTraceEntity getMethodTraceEntity(int index)
  {
    MethodTraceEntity aMethodTraceEntity = methodTraceEntities.get(index);
    return aMethodTraceEntity;
  }

  public List<MethodTraceEntity> getMethodTraceEntities()
  {
    List<MethodTraceEntity> newMethodTraceEntities = Collections.unmodifiableList(methodTraceEntities);
    return newMethodTraceEntities;
  }

  public int numberOfMethodTraceEntities()
  {
    int number = methodTraceEntities.size();
    return number;
  }

  public boolean hasMethodTraceEntities()
  {
    boolean has = methodTraceEntities.size() > 0;
    return has;
  }

  public int indexOfMethodTraceEntity(MethodTraceEntity aMethodTraceEntity)
  {
    int index = methodTraceEntities.indexOf(aMethodTraceEntity);
    return index;
  }

  public AssociationVariable getAssociationVariable()
  {
    return associationVariable;
  }

  public TraceCondition getCondition(int index)
  {
    TraceCondition aCondition = condition.get(index);
    return aCondition;
  }

  public List<TraceCondition> getCondition()
  {
    List<TraceCondition> newCondition = Collections.unmodifiableList(condition);
    return newCondition;
  }

  public int numberOfCondition()
  {
    int number = condition.size();
    return number;
  }

  public boolean hasCondition()
  {
    boolean has = condition.size() > 0;
    return has;
  }

  public int indexOfCondition(TraceCondition aCondition)
  {
    int index = condition.indexOf(aCondition);
    return index;
  }

  public TraceRecord getTraceRecord()
  {
    return traceRecord;
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

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public boolean setTracer(Tracer aNewTracer)
  {
    boolean wasSet = false;
    if (aNewTracer != null)
    {
      tracer = aNewTracer;
      wasSet = true;
    }
    return wasSet;
  }

  public static int minimumNumberOfAttributeTraceItems()
  {
    return 0;
  }

  public AttributeTraceItem addAttributeTraceItem()
  {
    return new AttributeTraceItem(this);
  }

  public boolean addAttributeTraceItem(AttributeTraceItem aAttributeTraceItem)
  {
    boolean wasAdded = false;
    if (attributeTraceItems.contains(aAttributeTraceItem)) { return false; }
    TraceDirective existingTraceDirective = aAttributeTraceItem.getTraceDirective();
    boolean isNewTraceDirective = existingTraceDirective != null && !this.equals(existingTraceDirective);
    if (isNewTraceDirective)
    {
      aAttributeTraceItem.setTraceDirective(this);
    }
    else
    {
      attributeTraceItems.add(aAttributeTraceItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAttributeTraceItem(AttributeTraceItem aAttributeTraceItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aAttributeTraceItem, as it must always have a traceDirective
    if (!this.equals(aAttributeTraceItem.getTraceDirective()))
    {
      attributeTraceItems.remove(aAttributeTraceItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAttributeTraceItemAt(AttributeTraceItem aAttributeTraceItem, int index)
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

  public boolean addOrMoveAttributeTraceItemAt(AttributeTraceItem aAttributeTraceItem, int index)
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

  public static int minimumNumberOfStateMachineTraceItems()
  {
    return 0;
  }

  public StateMachineTraceItem addStateMachineTraceItem()
  {
    return new StateMachineTraceItem(this);
  }

  public boolean addStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    boolean wasAdded = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem)) { return false; }
    TraceDirective existingTraceDirective = aStateMachineTraceItem.getTraceDirective();
    boolean isNewTraceDirective = existingTraceDirective != null && !this.equals(existingTraceDirective);
    if (isNewTraceDirective)
    {
      aStateMachineTraceItem.setTraceDirective(this);
    }
    else
    {
      stateMachineTraceItems.add(aStateMachineTraceItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateMachineTraceItem(StateMachineTraceItem aStateMachineTraceItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aStateMachineTraceItem, as it must always have a traceDirective
    if (!this.equals(aStateMachineTraceItem.getTraceDirective()))
    {
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStateMachineTraceItemAt(StateMachineTraceItem aStateMachineTraceItem, int index)
  {  
    boolean wasAdded = false;
    if(addStateMachineTraceItem(aStateMachineTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineTraceItems()) { index = numberOfStateMachineTraceItems() - 1; }
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      stateMachineTraceItems.add(index, aStateMachineTraceItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateMachineTraceItemAt(StateMachineTraceItem aStateMachineTraceItem, int index)
  {
    boolean wasAdded = false;
    if(stateMachineTraceItems.contains(aStateMachineTraceItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineTraceItems()) { index = numberOfStateMachineTraceItems() - 1; }
      stateMachineTraceItems.remove(aStateMachineTraceItem);
      stateMachineTraceItems.add(index, aStateMachineTraceItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateMachineTraceItemAt(aStateMachineTraceItem, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfMethodTraceEntities()
  {
    return 0;
  }

  public boolean addMethodTraceEntity(MethodTraceEntity aMethodTraceEntity)
  {
    boolean wasAdded = false;
    if (methodTraceEntities.contains(aMethodTraceEntity)) { return false; }
    methodTraceEntities.add(aMethodTraceEntity);
    if (aMethodTraceEntity.indexOfTraceDirective(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMethodTraceEntity.addTraceDirective(this);
      if (!wasAdded)
      {
        methodTraceEntities.remove(aMethodTraceEntity);
      }
    }
    return wasAdded;
  }

  public boolean removeMethodTraceEntity(MethodTraceEntity aMethodTraceEntity)
  {
    boolean wasRemoved = false;
    if (!methodTraceEntities.contains(aMethodTraceEntity))
    {
      return wasRemoved;
    }

    int oldIndex = methodTraceEntities.indexOf(aMethodTraceEntity);
    methodTraceEntities.remove(oldIndex);
    if (aMethodTraceEntity.indexOfTraceDirective(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMethodTraceEntity.removeTraceDirective(this);
      if (!wasRemoved)
      {
        methodTraceEntities.add(oldIndex,aMethodTraceEntity);
      }
    }
    return wasRemoved;
  }

  public boolean addMethodTraceEntityAt(MethodTraceEntity aMethodTraceEntity, int index)
  {  
    boolean wasAdded = false;
    if(addMethodTraceEntity(aMethodTraceEntity))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethodTraceEntities()) { index = numberOfMethodTraceEntities() - 1; }
      methodTraceEntities.remove(aMethodTraceEntity);
      methodTraceEntities.add(index, aMethodTraceEntity);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMethodTraceEntityAt(MethodTraceEntity aMethodTraceEntity, int index)
  {
    boolean wasAdded = false;
    if(methodTraceEntities.contains(aMethodTraceEntity))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMethodTraceEntities()) { index = numberOfMethodTraceEntities() - 1; }
      methodTraceEntities.remove(aMethodTraceEntity);
      methodTraceEntities.add(index, aMethodTraceEntity);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMethodTraceEntityAt(aMethodTraceEntity, index);
    }
    return wasAdded;
  }

  public boolean setAssociationVariable(AssociationVariable aNewAssociationVariable)
  {
    boolean wasSet = false;
    if (aNewAssociationVariable == null)
    {
      AssociationVariable existingAssociationVariable = associationVariable;
      associationVariable = null;
      
      if (existingAssociationVariable != null && existingAssociationVariable.getTraceDirective() != null)
      {
        existingAssociationVariable.setTraceDirective(null);
      }
      wasSet = true;
      return wasSet;
    }

    AssociationVariable currentAssociationVariable = getAssociationVariable();
    if (currentAssociationVariable != null && !currentAssociationVariable.equals(aNewAssociationVariable))
    {
      currentAssociationVariable.setTraceDirective(null);
    }

    associationVariable = aNewAssociationVariable;
    TraceDirective existingTraceDirective = aNewAssociationVariable.getTraceDirective();

    if (!equals(existingTraceDirective))
    {
      aNewAssociationVariable.setTraceDirective(this);
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfCondition()
  {
    return 0;
  }

  public boolean addCondition(TraceCondition aCondition)
  {
    boolean wasAdded = false;
    if (condition.contains(aCondition)) { return false; }
    condition.add(aCondition);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCondition(TraceCondition aCondition)
  {
    boolean wasRemoved = false;
    if (condition.contains(aCondition))
    {
      condition.remove(aCondition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addConditionAt(TraceCondition aCondition, int index)
  {  
    boolean wasAdded = false;
    if(addCondition(aCondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCondition()) { index = numberOfCondition() - 1; }
      condition.remove(aCondition);
      condition.add(index, aCondition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveConditionAt(TraceCondition aCondition, int index)
  {
    boolean wasAdded = false;
    if(condition.contains(aCondition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCondition()) { index = numberOfCondition() - 1; }
      condition.remove(aCondition);
      condition.add(index, aCondition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addConditionAt(aCondition, index);
    }
    return wasAdded;
  }

  public boolean setTraceRecord(TraceRecord aNewTraceRecord)
  {
    boolean wasSet = false;
    if (traceRecord != null && !traceRecord.equals(aNewTraceRecord) && equals(traceRecord.getTraceDirective()))
    {
      //Unable to setTraceRecord, as existing traceRecord would become an orphan
      return wasSet;
    }

    traceRecord = aNewTraceRecord;
    TraceDirective anOldTraceDirective = aNewTraceRecord != null ? aNewTraceRecord.getTraceDirective() : null;

    if (!this.equals(anOldTraceDirective))
    {
      if (anOldTraceDirective != null)
      {
        anOldTraceDirective.traceRecord = null;
      }
      if (traceRecord != null)
      {
        traceRecord.setTraceDirective(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfTraceCases()
  {
    return 0;
  }

  public boolean addTraceCase(TraceCase aTraceCase)
  {
    boolean wasAdded = false;
    if (traceCases.contains(aTraceCase)) { return false; }
    traceCases.add(aTraceCase);
    if (aTraceCase.indexOfTraceDirective(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTraceCase.addTraceDirective(this);
      if (!wasAdded)
      {
        traceCases.remove(aTraceCase);
      }
    }
    return wasAdded;
  }

  public boolean removeTraceCase(TraceCase aTraceCase)
  {
    boolean wasRemoved = false;
    if (!traceCases.contains(aTraceCase))
    {
      return wasRemoved;
    }

    int oldIndex = traceCases.indexOf(aTraceCase);
    traceCases.remove(oldIndex);
    if (aTraceCase.indexOfTraceDirective(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTraceCase.removeTraceDirective(this);
      if (!wasRemoved)
      {
        traceCases.add(oldIndex,aTraceCase);
      }
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

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeTraceDirective(this);
    }
    if (aUmpleClass != null)
    {
      aUmpleClass.addTraceDirective(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    tracer = null;
    for(int i=attributeTraceItems.size(); i > 0; i--)
    {
      AttributeTraceItem aAttributeTraceItem = attributeTraceItems.get(i - 1);
      aAttributeTraceItem.delete();
    }
    for(int i=stateMachineTraceItems.size(); i > 0; i--)
    {
      StateMachineTraceItem aStateMachineTraceItem = stateMachineTraceItems.get(i - 1);
      aStateMachineTraceItem.delete();
    }
    ArrayList<MethodTraceEntity> copyOfMethodTraceEntities = new ArrayList<MethodTraceEntity>(methodTraceEntities);
    methodTraceEntities.clear();
    for(MethodTraceEntity aMethodTraceEntity : copyOfMethodTraceEntities)
    {
      aMethodTraceEntity.removeTraceDirective(this);
    }
    if (associationVariable != null)
    {
      associationVariable.setTraceDirective(null);
    }
    condition.clear();
    TraceRecord existingTraceRecord = traceRecord;
    traceRecord = null;
    if (existingTraceRecord != null)
    {
      existingTraceRecord.delete();
    }
    ArrayList<TraceCase> copyOfTraceCases = new ArrayList<TraceCase>(traceCases);
    traceCases.clear();
    for(TraceCase aTraceCase : copyOfTraceCases)
    {
      aTraceCase.removeTraceDirective(this);
    }
    if (umpleClass != null)
    {
      UmpleClass placeholderUmpleClass = umpleClass;
      this.umpleClass = null;
      placeholderUmpleClass.removeTraceDirective(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "tracerType" + ":" + getTracerType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tracer = "+(getTracer()!=null?Integer.toHexString(System.identityHashCode(getTracer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "associationVariable = "+(getAssociationVariable()!=null?Integer.toHexString(System.identityHashCode(getAssociationVariable())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "traceRecord = "+(getTraceRecord()!=null?Integer.toHexString(System.identityHashCode(getTraceRecord())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "umpleClass = "+(getUmpleClass()!=null?Integer.toHexString(System.identityHashCode(getUmpleClass())):"null")
     + outputString;
  }
}