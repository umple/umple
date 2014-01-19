/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource Umlet.ump 13
 * @umplesource Umlet_Code.ump 11
 */
// line 13 "../../../../src/Umlet.ump"
// line 11 "../../../../src/Umlet_Code.ump"
public class UmletGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmletGenerator Attributes
  private String filename;
  private UmpleModel model;

  //UmletGenerator Associations
  private List<UmletElement> classElements;
  private List<UmletElement> associationElements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmletGenerator()
  {
    filename = null;
    model = null;
    classElements = new ArrayList<UmletElement>();
    associationElements = new ArrayList<UmletElement>();
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

  public UmletElement getClassElement(int index)
  {
    UmletElement aClassElement = classElements.get(index);
    return aClassElement;
  }

  public List<UmletElement> getClassElements()
  {
    List<UmletElement> newClassElements = Collections.unmodifiableList(classElements);
    return newClassElements;
  }

  public int numberOfClassElements()
  {
    int number = classElements.size();
    return number;
  }

  public boolean hasClassElements()
  {
    boolean has = classElements.size() > 0;
    return has;
  }

  public int indexOfClassElement(UmletElement aClassElement)
  {
    int index = classElements.indexOf(aClassElement);
    return index;
  }

  public UmletElement getAssociationElement(int index)
  {
    UmletElement aAssociationElement = associationElements.get(index);
    return aAssociationElement;
  }

  public List<UmletElement> getAssociationElements()
  {
    List<UmletElement> newAssociationElements = Collections.unmodifiableList(associationElements);
    return newAssociationElements;
  }

  public int numberOfAssociationElements()
  {
    int number = associationElements.size();
    return number;
  }

  public boolean hasAssociationElements()
  {
    boolean has = associationElements.size() > 0;
    return has;
  }

  public int indexOfAssociationElement(UmletElement aAssociationElement)
  {
    int index = associationElements.indexOf(aAssociationElement);
    return index;
  }

  public static int minimumNumberOfClassElements()
  {
    return 0;
  }

  public boolean addClassElement(UmletElement aClassElement)
  {
    boolean wasAdded = false;
    if (classElements.contains(aClassElement)) { return false; }
    classElements.add(aClassElement);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeClassElement(UmletElement aClassElement)
  {
    boolean wasRemoved = false;
    if (classElements.contains(aClassElement))
    {
      classElements.remove(aClassElement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addClassElementAt(UmletElement aClassElement, int index)
  {  
    boolean wasAdded = false;
    if(addClassElement(aClassElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClassElements()) { index = numberOfClassElements() - 1; }
      classElements.remove(aClassElement);
      classElements.add(index, aClassElement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveClassElementAt(UmletElement aClassElement, int index)
  {
    boolean wasAdded = false;
    if(classElements.contains(aClassElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfClassElements()) { index = numberOfClassElements() - 1; }
      classElements.remove(aClassElement);
      classElements.add(index, aClassElement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addClassElementAt(aClassElement, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfAssociationElements()
  {
    return 0;
  }

  public boolean addAssociationElement(UmletElement aAssociationElement)
  {
    boolean wasAdded = false;
    if (associationElements.contains(aAssociationElement)) { return false; }
    associationElements.add(aAssociationElement);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssociationElement(UmletElement aAssociationElement)
  {
    boolean wasRemoved = false;
    if (associationElements.contains(aAssociationElement))
    {
      associationElements.remove(aAssociationElement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAssociationElementAt(UmletElement aAssociationElement, int index)
  {  
    boolean wasAdded = false;
    if(addAssociationElement(aAssociationElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociationElements()) { index = numberOfAssociationElements() - 1; }
      associationElements.remove(aAssociationElement);
      associationElements.add(index, aAssociationElement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssociationElementAt(UmletElement aAssociationElement, int index)
  {
    boolean wasAdded = false;
    if(associationElements.contains(aAssociationElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociationElements()) { index = numberOfAssociationElements() - 1; }
      associationElements.remove(aAssociationElement);
      associationElements.add(index, aAssociationElement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssociationElementAt(aAssociationElement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    classElements.clear();
    associationElements.clear();
  }

  @umplesourcefile(line={17},file={"Umlet_Code.ump"},javaline={256},length={6})
   public void generate(){
    UmpleFile umpleFile = model.getUmpleFile();
    String filename = umpleFile.getPath() + File.separator + umpleFile.getFileName() + ".uxf";
    draw(model);
    SampleFileWriter.createFile(filename, toXml());
  }

  @umplesourcefile(line={25},file={"Umlet_Code.ump"},javaline={264},length={24})
   public void draw(UmpleModel model){
    Map<UmpleClass,UmletElement> classToElementMap = new HashMap<UmpleClass,UmletElement>();
    
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      UmletElement element = newClass(aClass.getName());
      classToElementMap.put(aClass, element);
    }
    
    for (Association association : model.getAssociations())
    {
      UmpleClass class1 = model.getUmpleClass(association.getEnd(0).getClassName());
      UmpleClass class2 = model.getUmpleClass(association.getEnd(1).getClassName());
      
      UmletElement classElement1 = classToElementMap.get(class1);
      UmletElement classElement2 = classToElementMap.get(class2);
      String mult1 = association.getEnd(0).toGenericString();
      String mult2 = association.getEnd(1).toGenericString();
      String role1 = association.getEnd(0).getRoleName();
      String role2 = association.getEnd(1).getRoleName();
      
      newAssociation(classElement1, classElement2, mult2, mult1, role2, role1);
    }
  }

  @umplesourcefile(line={51},file={"Umlet_Code.ump"},javaline={290},length={19})
   public UmletElement newClass(String name){
    int elementOffset = numberOfClassElements();
  
    int width = 100;
    int height = 100;
    int spacing = 100;
    
    int startX = 40;
    int startY = 20;
    
    Point position = Point.create(elementOffset);
    int myX = startX + (position.getY()-1)*(spacing+width);
    int myY = startY + (position.getX()-1)*(spacing+height);

    Coordinate c = new Coordinate(myX,myY,width,height);
    UmletElement e = new UmletElement("com.umlet.element.base.Class",name + "\n--","",c);
    addClassElement(e);
    return e;
  }

  @umplesourcefile(line={72},file={"Umlet_Code.ump"},javaline={311},length={19})
   public UmletElement newAssociation(UmletElement firstClass, UmletElement secondClass, String firstMultiplicity, String secondMultiplicity, String firstRole, String secondRole){
    String whereIs = firstClass.getCoordinate().whereIs(secondClass.getCoordinate());
    if ("top".equals(whereIs))
    {
      return newAssociationTopToBottom(secondClass, firstClass, secondMultiplicity, firstMultiplicity, secondRole, firstRole);
    }
    else if ("right".equals(whereIs))
    {
      return newAssociationLeftToRight(firstClass, secondClass, firstMultiplicity, secondMultiplicity, firstRole, secondRole);
    }
    else if ("left".equals(whereIs))
    {
      return newAssociationLeftToRight(secondClass, firstClass, secondMultiplicity, firstMultiplicity, secondRole, firstRole);
    }
    else
    {
      return newAssociationTopToBottom(firstClass, secondClass, firstMultiplicity, secondMultiplicity, firstRole, secondRole);
    }
  }

  @umplesourcefile(line={93},file={"Umlet_Code.ump"},javaline={332},length={14})
   private UmletElement newAssociationLeftToRight(UmletElement firstClass, UmletElement secondClass, String firstMultiplicity, String secondMultiplicity, String firstRole, String secondRole){
    Coordinate firstCoordinate = firstClass.getCoordinate();
    Coordinate secondCoordinate = secondClass.getCoordinate();
    
    Coordinate c = new Coordinate(firstCoordinate.getRightMiddle().getX(), firstCoordinate.getRightMiddle().getY(),1,1);
    int xOffset = secondCoordinate.getLeftMiddle().getX() - c.getX();
    int yOffset = secondCoordinate.getLeftMiddle().getY() - c.getY();

    String panel = "lt=-\nm1="+firstMultiplicity+"\nm2="+secondMultiplicity+"\nr1="+firstRole+"\nr2="+secondRole;
    String additional = xOffset + ";" + yOffset + ";0;0";
    UmletElement e = new UmletElement("com.umlet.element.base.Relation",panel,additional,c);
    addAssociationElement(e);
    return e;
  }

  @umplesourcefile(line={109},file={"Umlet_Code.ump"},javaline={348},length={14})
   private UmletElement newAssociationTopToBottom(UmletElement firstClass, UmletElement secondClass, String firstMultiplicity, String secondMultiplicity, String firstRole, String secondRole){
    Coordinate firstCoordinate = firstClass.getCoordinate();
    Coordinate secondCoordinate = secondClass.getCoordinate();
    
    int xOffset = (secondCoordinate.getX() + secondCoordinate.getWidth()/2) - (firstCoordinate.getX() + firstCoordinate.getWidth()/2);
    int yOffset = secondCoordinate.getY() - (firstCoordinate.getY() + firstCoordinate.getHeight());

    String panel = "lt=-\nm1="+firstMultiplicity+"\nm2="+secondMultiplicity+"\nr1="+firstRole+"\nr2="+secondRole;
    String additional = xOffset + ";" + yOffset + ";0;0";
    Coordinate c = new Coordinate(firstCoordinate.getX() + firstCoordinate.getWidth()/2,firstCoordinate.getY()+firstCoordinate.getHeight(),1,1);
    UmletElement e = new UmletElement("com.umlet.element.base.Relation",panel,additional,c);
    addAssociationElement(e);
    return e;
  }

  @umplesourcefile(line={125},file={"Umlet_Code.ump"},javaline={364},length={14})
   public String toXml(){
    UmletDiagram diagram = new UmletDiagram();
    
    for(UmletElement e : classElements)
    {
      diagram.addUmletElement(e);
    }
    
    for(UmletElement e : associationElements)
    {
      diagram.addUmletElement(e);
    }
    return diagram.toXml();
  }


  /**
   * Allows independent code generation tools
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={21},file={"Generator.ump"},javaline={379},length={2})
  @Override
  public boolean setOutput(String aString){
          return false;
  }


  /**
   * Allows independent code generation tools
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={23},file={"Generator.ump"},javaline={392},length={2})
  @Override
  public void prepare(){
          return ;
  }


  /**
   * Allows independent code generation tools
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={24},file={"Generator.ump"},javaline={405},length={2})
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