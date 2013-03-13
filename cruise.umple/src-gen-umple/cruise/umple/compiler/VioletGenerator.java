/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource Violet.ump 14
 * @umplesource Violet_Code.ump 12
 */
// line 14 "../../../../src/Violet.ump"
// line 12 "../../../../src/Violet_Code.ump"
public class VioletGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VioletGenerator Attributes
  private String filename;
  private UmpleModel model;

  //VioletGenerator Associations
  private List<VioletClass> violetClasses;
  private List<VioletAssociation> violetAssociations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VioletGenerator()
  {
    filename = null;
    model = null;
    violetClasses = new ArrayList<VioletClass>();
    violetAssociations = new ArrayList<VioletAssociation>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFilename(String aFilename)
  {
    boolean wasSet = false;
    filename = aFilename;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public String getFilename()
  {
    return filename;
  }

  public UmpleModel getModel()
  {
    return model;
  }

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


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  // line 21 "../../../../src/Generator.ump"
  @Override
  public boolean setOutput(String aString){
          return false;
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "filename" + ":" + getFilename()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + getModel() != null ? !getModel() .equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 14 ../../../../src/Violet_Code.ump
  public void generate()
  {
    UmpleFile umpleFile = model.getUmpleFile();
    String filename = umpleFile.getPath() + File.separator + umpleFile.getFileName() + ".violet";
    draw(model);
    SampleFileWriter.createFile(filename, toXml());
  }
  
  public VioletClass newClass(String name)
  {
  
    int elementOffset = numberOfVioletClasses();
  
    double width = 100.0;
    double height = 60.0;
    double widthSpacing = 110.0;
    double heightSpacing = 50.0;
    
    double startX = 40.0;
    double startY = 40.0;
    
    Point position = Point.create(elementOffset);
    double myX = startX + (position.getY()-1)*(widthSpacing+width);
    double myY = startY + (position.getX()-1)*(heightSpacing+height);
  
    VioletClass vClass = new VioletClass(name,myX,myY);
    addVioletClass(vClass);
    return vClass;
  }
  
  public VioletAssociation newAssociation(String startLabel, String endLabel, VioletClass startClass, VioletClass endClass)
  {
    VioletAssociation vAss = new VioletAssociation(startLabel,endLabel,startClass,endClass);
    addVioletAssociation(vAss);
    return vAss;
  }

  public void draw(UmpleModel model)
  {
    Map<UmpleClass,VioletClass> classToVioletMap = new HashMap<UmpleClass,VioletClass>();
    
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      VioletClass vClass = newClass(aClass.getName());
      classToVioletMap.put(aClass, vClass);
    }

    for (UmpleClass child : model.getUmpleClasses())
    {
      UmpleClass parent = child.getExtendsClass();

      if (parent != null)
      {
        VioletClass violetChild = classToVioletMap.get(child);
        VioletClass violetParent = classToVioletMap.get(parent);
        violetChild.setParentClass(violetParent);
      }
    }
    
    for (Association association : model.getAssociations())
    {
      UmpleClass class1 = model.getUmpleClass(association.getEnd(0).getClassName());
      UmpleClass class2 = model.getUmpleClass(association.getEnd(1).getClassName());

      VioletClass startClass = classToVioletMap.get(class1);
      VioletClass endClass = classToVioletMap.get(class2);
      String startLabel = association.getEnd(0).toGenericString();
      String endLabel = association.getEnd(1).toGenericString();
      //String role1 = association.getEnd(0).getRoleName();
      //String role2 = association.getEnd(1).getRoleName();

      newAssociation(startLabel, endLabel, startClass, endClass);
    }
  }


  public String toXml()
  {
    VioletDiagram diagram = new VioletDiagram();
    
    for(VioletClass v : violetClasses)
    {
      diagram.addVioletClass(v);
    }
    
    for(VioletAssociation v : violetAssociations)
    {
      diagram.addVioletAssociation(v);
    }
    return diagram.toXml();
  }
}