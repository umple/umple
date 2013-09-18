/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Umlet.ump 26
 * @umplesource Umlet_Code.ump 140
 */
// line 26 "../../../../src/Umlet.ump"
// line 140 "../../../../src/Umlet_Code.ump"
public class UmletDiagram
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmletDiagram Associations
  private List<UmletElement> umletElements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmletDiagram()
  {
    umletElements = new ArrayList<UmletElement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public UmletElement getUmletElement(int index)
  {
    UmletElement aUmletElement = umletElements.get(index);
    return aUmletElement;
  }

  public List<UmletElement> getUmletElements()
  {
    List<UmletElement> newUmletElements = Collections.unmodifiableList(umletElements);
    return newUmletElements;
  }

  public int numberOfUmletElements()
  {
    int number = umletElements.size();
    return number;
  }

  public boolean hasUmletElements()
  {
    boolean has = umletElements.size() > 0;
    return has;
  }

  public int indexOfUmletElement(UmletElement aUmletElement)
  {
    int index = umletElements.indexOf(aUmletElement);
    return index;
  }

  public static int minimumNumberOfUmletElements()
  {
    return 0;
  }

  public boolean addUmletElement(UmletElement aUmletElement)
  {
    boolean wasAdded = false;
    if (umletElements.contains(aUmletElement)) { return false; }
    umletElements.add(aUmletElement);
    if (aUmletElement.indexOfUmletDiagram(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUmletElement.addUmletDiagram(this);
      if (!wasAdded)
      {
        umletElements.remove(aUmletElement);
      }
    }
    return wasAdded;
  }

  public boolean removeUmletElement(UmletElement aUmletElement)
  {
    boolean wasRemoved = false;
    if (!umletElements.contains(aUmletElement))
    {
      return wasRemoved;
    }

    int oldIndex = umletElements.indexOf(aUmletElement);
    umletElements.remove(oldIndex);
    if (aUmletElement.indexOfUmletDiagram(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUmletElement.removeUmletDiagram(this);
      if (!wasRemoved)
      {
        umletElements.add(oldIndex,aUmletElement);
      }
    }
    return wasRemoved;
  }

  public boolean addUmletElementAt(UmletElement aUmletElement, int index)
  {  
    boolean wasAdded = false;
    if(addUmletElement(aUmletElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmletElements()) { index = numberOfUmletElements() - 1; }
      umletElements.remove(aUmletElement);
      umletElements.add(index, aUmletElement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmletElementAt(UmletElement aUmletElement, int index)
  {
    boolean wasAdded = false;
    if(umletElements.contains(aUmletElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmletElements()) { index = numberOfUmletElements() - 1; }
      umletElements.remove(aUmletElement);
      umletElements.add(index, aUmletElement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmletElementAt(aUmletElement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<UmletElement> copyOfUmletElements = new ArrayList<UmletElement>(umletElements);
    umletElements.clear();
    for(UmletElement aUmletElement : copyOfUmletElements)
    {
      aUmletElement.removeUmletDiagram(this);
    }
  }

  @umplesourcefile(line={143},file={"Umlet_Code.ump"},javaline={161},length={19})
   public String toXml(){
    StringBuffer answer = new StringBuffer();
    answer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    answer.append("<umlet_diagram>");
    
    for(UmletElement e : getUmletElements())
    {
      Coordinate c = e.getCoordinate();
      
      answer.append("<element>");
      answer.append("<type>" + e.getType() + "</type>");
      answer.append("<coordinates><x>"+ c.getX() +"</x><y>"+ c.getY() +"</y><w>"+ c.getWidth() +"</w><h>"+ c.getHeight() +"</h></coordinates>");
      answer.append("<panel_attributes>" + e.getPanelAttributes() + "</panel_attributes>");
      answer.append("<additional_attributes>" + e.getAdditionalAttributes() + "</additional_attributes>");
      answer.append("</element>");
    }
    answer.append("</umlet_diagram>");
    return answer.toString();
  }

}