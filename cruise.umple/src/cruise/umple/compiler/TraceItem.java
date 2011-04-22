/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.0.352 modeling language!*/

package cruise.umple.compiler;

public class TraceItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceItem Associations
  private Attribute attribute;
  private UmpleClass umpleClass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceItem()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public Attribute getAttribute()
  {
    return attribute;
  }

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public boolean setAttribute(Attribute newAttribute)
  {
    boolean wasSet = false;
    if (newAttribute == null)
    {
      Attribute existingAttribute = attribute;
      attribute = null;
      
      if (existingAttribute != null && existingAttribute.getTraceItem() != null)
      {
        existingAttribute.setTraceItem(null);
      }
      wasSet = true;
      return wasSet;
    }

    Attribute currentAttribute = getAttribute();
    if (currentAttribute != null && !currentAttribute.equals(newAttribute))
    {
      currentAttribute.setTraceItem(null);
    }

    attribute = newAttribute;
    TraceItem existingTraceItem = newAttribute.getTraceItem();

    if (!equals(existingTraceItem))
    {
      newAttribute.setTraceItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasSet = false;
    UmpleClass existingUmpleClass = umpleClass;
    umpleClass = aUmpleClass;
    if (existingUmpleClass != null && !existingUmpleClass.equals(aUmpleClass))
    {
      existingUmpleClass.removeTraceItem(this);
    }
    if (aUmpleClass != null)
    {
      aUmpleClass.addTraceItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (attribute != null)
    {
      attribute.setTraceItem(null);
    }
    if (umpleClass != null)
    {
      UmpleClass placeholderUmpleClass = umpleClass;
      this.umpleClass = null;
      placeholderUmpleClass.removeTraceItem(this);
    }
  }

}