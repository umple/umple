/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class TraceDirective
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceDirective Attributes
  private int id;

  //TraceDirective Associations
  private List<Attribute_TraceItem> attributeTraceItems;
  private List<StateMachine_TraceItem> stateMachineTraceItems;
  private List<MethodTraceEntity> methodTraceEntities;
  private AssociationVariable associationVariable;
  private List<TraceCondition> condition;
  private TraceRecord traceRecord;
  private List<TraceCase> traceCases;
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceDirective()
  {
    id = 0;
    attributeTraceItems = new ArrayList<Attribute_TraceItem>();
    stateMachineTraceItems = new ArrayList<StateMachine_TraceItem>();
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

  public StateMachine_TraceItem getStateMachineTraceItem(int index)
  {
    StateMachine_TraceItem aStateMachineTraceItem = stateMachineTraceItems.get(index);
    return aStateMachineTraceItem;
  }

  public List<StateMachine_TraceItem> getStateMachineTraceItems()
  {
    List<StateMachine_TraceItem> newStateMachineTraceItems = Collections.unmodifiableList(stateMachineTraceItems);
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

  public int indexOfStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
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

  public static int minimumNumberOfAttributeTraceItems()
  {
    return 0;
  }

  public Attribute_TraceItem addAttributeTraceItem()
  {
    return new Attribute_TraceItem(this);
  }

  public boolean addAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
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

  public boolean removeAttributeTraceItem(Attribute_TraceItem aAttributeTraceItem)
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

  public static int minimumNumberOfStateMachineTraceItems()
  {
    return 0;
  }

  public boolean addStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    boolean wasAdded = false;
    if (stateMachineTraceItems.contains(aStateMachineTraceItem)) { return false; }
    stateMachineTraceItems.add(aStateMachineTraceItem);
    if (aStateMachineTraceItem.indexOfTraceDirective(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStateMachineTraceItem.addTraceDirective(this);
      if (!wasAdded)
      {
        stateMachineTraceItems.remove(aStateMachineTraceItem);
      }
    }
    return wasAdded;
  }

  public boolean removeStateMachineTraceItem(StateMachine_TraceItem aStateMachineTraceItem)
  {
    boolean wasRemoved = false;
    if (!stateMachineTraceItems.contains(aStateMachineTraceItem))
    {
      return wasRemoved;
    }

    int oldIndex = stateMachineTraceItems.indexOf(aStateMachineTraceItem);
    stateMachineTraceItems.remove(oldIndex);
    if (aStateMachineTraceItem.indexOfTraceDirective(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStateMachineTraceItem.removeTraceDirective(this);
      if (!wasRemoved)
      {
        stateMachineTraceItems.add(oldIndex,aStateMachineTraceItem);
      }
    }
    return wasRemoved;
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

  public boolean setAssociationVariable(AssociationVariable newAssociationVariable)
  {
    boolean wasSet = false;
    if (newAssociationVariable == null)
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
    if (currentAssociationVariable != null && !currentAssociationVariable.equals(newAssociationVariable))
    {
      currentAssociationVariable.setTraceDirective(null);
    }

    associationVariable = newAssociationVariable;
    TraceDirective existingTraceDirective = newAssociationVariable.getTraceDirective();

    if (!equals(existingTraceDirective))
    {
      newAssociationVariable.setTraceDirective(this);
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

  public boolean setTraceRecord(TraceRecord newTraceRecord)
  {
    boolean wasSet = false;
    if (traceRecord != null && !traceRecord.equals(newTraceRecord) && equals(traceRecord.getTraceDirective()))
    {
      //Unable to setTraceRecord, as existing traceRecord would become an orphan
      return wasSet;
    }

    traceRecord = newTraceRecord;
    TraceDirective oldTraceDirective = newTraceRecord != null ? newTraceRecord.getTraceDirective() : null;

    if (!this.equals(oldTraceDirective))
    {
      if (oldTraceDirective != null)
      {
        oldTraceDirective.traceRecord = null;
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
    for(int i=attributeTraceItems.size(); i > 0; i--)
    {
      Attribute_TraceItem aAttributeTraceItem = attributeTraceItems.get(i - 1);
      aAttributeTraceItem.delete();
    }
    ArrayList<StateMachine_TraceItem> copyOfStateMachineTraceItems = new ArrayList<StateMachine_TraceItem>(stateMachineTraceItems);
    stateMachineTraceItems.clear();
    for(StateMachine_TraceItem aStateMachineTraceItem : copyOfStateMachineTraceItems)
    {
      aStateMachineTraceItem.removeTraceDirective(this);
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

}