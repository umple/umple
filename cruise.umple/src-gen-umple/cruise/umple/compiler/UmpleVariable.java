/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Superclass for tracking member variables in all target languages
 * TODO: Code smell because we have both an association variable and also an association
 * This class should go and instead AssociationEnd should be the member variable
 * @umplesource Umple.ump 429
 * @umplesource Umple_Code.ump 1050
 * @umplesource Trace_Code.ump 16
 */
// line 429 "../../../../src/Umple.ump"
// line 1050 "../../../../src/Umple_Code.ump"
// line 16 "../../../../src/Trace_Code.ump"
public class UmpleVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleVariable Attributes
  private String name;
  private String type;
  private String modifier;
  private String value;

  //UmpleVariable Associations
  private List<AttributeTraceItem> attributeTraceItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleVariable(String aName, String aType, String aModifier, String aValue)
  {
    name = aName;
    type = aType;
    modifier = aModifier;
    value = aValue;
    attributeTraceItems = new ArrayList<AttributeTraceItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 443 "../../../../src/Umple.ump"
    if (aName == null) { throw new RuntimeException("Name must be set, cannot be null"); }
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setModifier(String aModifier)
  {
    boolean wasSet = false;
    modifier = aModifier;
    wasSet = true;
    return wasSet;
  }

  public boolean setValue(String aValue)
  {
    boolean wasSet = false;
    value = aValue;
    wasSet = true;
    return wasSet;
  }

  /**
   * The name of the Umple variable.
   */
  public String getName()
  {
    return name;
  }

  /**
   * The type of the Umple variable.
   */
  public String getType()
  {
    return type;
  }

  /**
   * The modifier associated with the Umple variable.
   */
  public String getModifier()
  {
    // line 445 "../../../../src/Umple.ump"
    if (modifier == null) { return "settable"; }
    return modifier;
  }

  /**
   * potential enum, 'settable'
   * The value of the Umple variable.
   */
  public String getValue()
  {
    return value;
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

  public static int minimumNumberOfAttributeTraceItems()
  {
    return 0;
  }

  public boolean addAttributeTraceItem(AttributeTraceItem aAttributeTraceItem)
  {
    boolean wasAdded = false;
    if (attributeTraceItems.contains(aAttributeTraceItem)) { return false; }
    attributeTraceItems.add(aAttributeTraceItem);
    if (aAttributeTraceItem.indexOfUmpleVariable(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAttributeTraceItem.addUmpleVariable(this);
      if (!wasAdded)
      {
        attributeTraceItems.remove(aAttributeTraceItem);
      }
    }
    return wasAdded;
  }

  public boolean removeAttributeTraceItem(AttributeTraceItem aAttributeTraceItem)
  {
    boolean wasRemoved = false;
    if (!attributeTraceItems.contains(aAttributeTraceItem))
    {
      return wasRemoved;
    }

    int oldIndex = attributeTraceItems.indexOf(aAttributeTraceItem);
    attributeTraceItems.remove(oldIndex);
    if (aAttributeTraceItem.indexOfUmpleVariable(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAttributeTraceItem.removeUmpleVariable(this);
      if (!wasRemoved)
      {
        attributeTraceItems.add(oldIndex,aAttributeTraceItem);
      }
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

  public void delete()
  {
    ArrayList<AttributeTraceItem> copyOfAttributeTraceItems = new ArrayList<AttributeTraceItem>(attributeTraceItems);
    attributeTraceItems.clear();
    for(AttributeTraceItem aAttributeTraceItem : copyOfAttributeTraceItems)
    {
      aAttributeTraceItem.removeUmpleVariable(this);
    }
  }


  /**
   * Retrieve the AttributeTraceItem associated with this UmpleVariable
   * @params method: for example get or set, each specifying the context to call the gotten trace item
   * @params uClass: the umple class to look within for the trace item
   * @return Attribute_Traceitem for this UmpleVariable(either association or attribute);
   */
  @umplesourcefile(line=24,file="../../../../src/Trace_Code.ump",javaline=245,length=32)
  public TraceItem getTraced(String method, UmpleClass uClass){
    //go through all of the trace directives from the passed umple class
    for(TraceDirective td: uClass.getTraceDirectives())
    {
      //find all of its AttributeTraceItem
      for(AttributeTraceItem ati: td.getAttributeTraceItems())
      {
      	//if the method passed and the method for which the trace attribute is applied, agree
        if(("setMethod".equals(method)&&ati.getTraceSet())||("getMethod".equals(method)&&ati.getTraceGet()))
        {
          //go through all the variables
          for(UmpleVariable variable: ati.getUmpleVariables())
          {
          	//and try to find one that is the same as the one variable calling this method 
            if(variable.equals(this))
            //return the trace item containing this umple variable
              return ati;
          }
        }
        else if("constructor".equals(method)&&ati.getTraceConstructor())
        {
          for(UmpleVariable variable: ati.getUmpleVariables())
          {
          	//and try to find one that is the same as the one variable calling this method 
            if(variable.equals(this))
            //return the trace item containing this umple variable
              return ati;
          }
        }
      }
    }
    //if no umple variable was found, return null
    return null;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "type" + ":" + getType()+ "," +
            "modifier" + ":" + getModifier()+ "," +
            "value" + ":" + getValue()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 1052 ../../../../src/Umple_Code.ump
  @umplesourcefile(line=1052,file="Umple_Code.ump",javaline=304,length=15)
  public String getUpperCaseName()
  {
    if (name == null || name.length() == 0)
    {
      return name;
    }
    else if (name.length() == 1)
    {
      return name.toUpperCase();
    }
    else
    {
      return name.toUpperCase().charAt(0) + name.substring(1);
    }
  }

  @umplesourcefile(line=1068,file="Umple_Code.ump",javaline=321,length=4)
  public boolean isImmutable()
  {
    return "immutable".equals(modifier);
  }

}