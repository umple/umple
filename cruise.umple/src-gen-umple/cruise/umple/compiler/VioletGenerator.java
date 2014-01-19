/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource Violet.ump 13
 * @umplesource Violet_Code.ump 11
 */
// line 13 "../../../../src/Violet.ump"
// line 11 "../../../../src/Violet_Code.ump"
public class VioletGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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

  @umplesourcefile(line={16},file={"Violet_Code.ump"},javaline={256},length={6})
   public void generate(){
    UmpleFile umpleFile = model.getUmpleFile();
    String filename = umpleFile.getPath() + File.separator + umpleFile.getFileName() + ".violet";
    draw(model);
    SampleFileWriter.createFile(filename, toXml());
  }

  @umplesourcefile(line={25},file={"Violet_Code.ump"},javaline={264},length={19})
   public VioletClass newClass(String name){
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

  @umplesourcefile(line={46},file={"Violet_Code.ump"},javaline={285},length={5})
   public VioletAssociation newAssociation(String startLabel, String endLabel, VioletClass startClass, VioletClass endClass){
    VioletAssociation vAss = new VioletAssociation(startLabel,endLabel,startClass,endClass);
    addVioletAssociation(vAss);
    return vAss;
  }

  @umplesourcefile(line={53},file={"Violet_Code.ump"},javaline={292},length={36})
   public void draw(UmpleModel model){
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

  @umplesourcefile(line={92},file={"Violet_Code.ump"},javaline={330},length={14})
   public String toXml(){
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


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={21},file={"Generator.ump"},javaline={345},length={2})
  @Override
  public boolean setOutput(String aString){
          return false;
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={23},file={"Generator.ump"},javaline={356},length={2})
  @Override
  public void prepare(){
          return ;
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={24},file={"Generator.ump"},javaline={367},length={2})
  @Override
  public void postpare(){
          return ;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "filename" + ":" + getFilename()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}