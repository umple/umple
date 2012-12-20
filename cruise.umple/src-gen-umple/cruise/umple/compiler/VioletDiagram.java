/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

// line 28 "../../../../src/Violet.ump"
// line 110 "../../../../src/Violet_Code.ump"
public class VioletDiagram
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VioletDiagram Associations
  private List<VioletClass> violetClasses;
  private List<VioletAssociation> violetAssociations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VioletDiagram()
  {
    violetClasses = new ArrayList<VioletClass>();
    violetAssociations = new ArrayList<VioletAssociation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public VioletClass getVioletClass(int index)
  {
    VioletClass aVioletClass = violetClasses.get(index);
    return aVioletClass;
  }

  public List<VioletClass> getVioletClasses()
  {
    List<VioletClass> newVioletClasses = Collections.unmodifiableList(violetClasses);
    return newVioletClasses;
  }

  public int numberOfVioletClasses()
  {
    int number = violetClasses.size();
    return number;
  }

  public boolean hasVioletClasses()
  {
    boolean has = violetClasses.size() > 0;
    return has;
  }

  public int indexOfVioletClass(VioletClass aVioletClass)
  {
    int index = violetClasses.indexOf(aVioletClass);
    return index;
  }

  public VioletAssociation getVioletAssociation(int index)
  {
    VioletAssociation aVioletAssociation = violetAssociations.get(index);
    return aVioletAssociation;
  }

  public List<VioletAssociation> getVioletAssociations()
  {
    List<VioletAssociation> newVioletAssociations = Collections.unmodifiableList(violetAssociations);
    return newVioletAssociations;
  }

  public int numberOfVioletAssociations()
  {
    int number = violetAssociations.size();
    return number;
  }

  public boolean hasVioletAssociations()
  {
    boolean has = violetAssociations.size() > 0;
    return has;
  }

  public int indexOfVioletAssociation(VioletAssociation aVioletAssociation)
  {
    int index = violetAssociations.indexOf(aVioletAssociation);
    return index;
  }

  public static int minimumNumberOfVioletClasses()
  {
    return 0;
  }

  public boolean addVioletClass(VioletClass aVioletClass)
  {
    boolean wasAdded = false;
    if (violetClasses.contains(aVioletClass)) { return false; }
    violetClasses.add(aVioletClass);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVioletClass(VioletClass aVioletClass)
  {
    boolean wasRemoved = false;
    if (violetClasses.contains(aVioletClass))
    {
      violetClasses.remove(aVioletClass);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVioletClassAt(VioletClass aVioletClass, int index)
  {  
    boolean wasAdded = false;
    if(addVioletClass(aVioletClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletClasses()) { index = numberOfVioletClasses() - 1; }
      violetClasses.remove(aVioletClass);
      violetClasses.add(index, aVioletClass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVioletClassAt(VioletClass aVioletClass, int index)
  {
    boolean wasAdded = false;
    if(violetClasses.contains(aVioletClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletClasses()) { index = numberOfVioletClasses() - 1; }
      violetClasses.remove(aVioletClass);
      violetClasses.add(index, aVioletClass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVioletClassAt(aVioletClass, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfVioletAssociations()
  {
    return 0;
  }

  public boolean addVioletAssociation(VioletAssociation aVioletAssociation)
  {
    boolean wasAdded = false;
    if (violetAssociations.contains(aVioletAssociation)) { return false; }
    violetAssociations.add(aVioletAssociation);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVioletAssociation(VioletAssociation aVioletAssociation)
  {
    boolean wasRemoved = false;
    if (violetAssociations.contains(aVioletAssociation))
    {
      violetAssociations.remove(aVioletAssociation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addVioletAssociationAt(VioletAssociation aVioletAssociation, int index)
  {  
    boolean wasAdded = false;
    if(addVioletAssociation(aVioletAssociation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletAssociations()) { index = numberOfVioletAssociations() - 1; }
      violetAssociations.remove(aVioletAssociation);
      violetAssociations.add(index, aVioletAssociation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVioletAssociationAt(VioletAssociation aVioletAssociation, int index)
  {
    boolean wasAdded = false;
    if(violetAssociations.contains(aVioletAssociation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVioletAssociations()) { index = numberOfVioletAssociations() - 1; }
      violetAssociations.remove(aVioletAssociation);
      violetAssociations.add(index, aVioletAssociation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVioletAssociationAt(aVioletAssociation, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    violetClasses.clear();
    violetAssociations.clear();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 113 ../../../../src/Violet_Code.ump
  public String toXml()
  {
    StringBuffer answer = new StringBuffer();
    answer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    answer.append("<java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">");
    answer.append("<object class=\"com.horstmann.violet.ClassDiagramGraph\">");
    
    for (VioletClass vClass : getVioletClasses())
    {
      answer.append("<void method=\"addNode\">");
      answer.append("<object id=\"ClassNode"+ vClass.getName() +"\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>"+ vClass.getName() +"</string></void></void></object>");
      answer.append("<object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>"+ vClass.getX() +"</double><double>"+ vClass.getY() +"</double></void></object>");
      answer.append("</void>");
    }
    
    for (VioletClass child : getVioletClasses())
    {
      VioletClass parent = child.getParentClass();
      if (parent != null)
      {
        answer.append("<void method=\"connect\">");
        answer.append("<object class=\"com.horstmann.violet.ClassRelationshipEdge\"><void property=\"bentStyle\"><object class=\"com.horstmann.violet.BentStyle\" field=\"VHV\"/></void><void property=\"endArrowHead\"><object class=\"com.horstmann.violet.ArrowHead\" field=\"TRIANGLE\"/></void></object>");
        answer.append("<object idref=\"ClassNode"+ child.getName() +"\"/>");
        answer.append("<object idref=\"ClassNode"+ parent.getName() +"\"/>");
        answer.append("</void>");
      }
    }    
    
    for(VioletAssociation vAss : getVioletAssociations())
    {
      answer.append("<void method=\"connect\">"); 
      answer.append("<object class=\"com.horstmann.violet.ClassRelationshipEdge\">"); 
      answer.append("<void property=\"bentStyle\"><object class=\"com.horstmann.violet.BentStyle\" field=\"HVH\"/></void>"); 
      answer.append("<void property=\"startLabel\"><string>"+ vAss.getStartLabel() +"</string></void>");
      answer.append("<void property=\"endLabel\"><string>"+ vAss.getEndLabel() +"</string></void>");
      answer.append("</object>");
      answer.append("<object idref=\"ClassNode"+ vAss.getVioletClass(0).getName() +"\"/>");
      answer.append("<object idref=\"ClassNode"+ vAss.getVioletClass(1).getName() +"\"/>");
      answer.append("</void>");
    }
    
    answer.append("</object>");
    answer.append("</java>");
    return answer.toString();
  }
}