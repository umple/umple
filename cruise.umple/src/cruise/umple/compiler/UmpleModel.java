/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import java.util.*;

public class UmpleModel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleModel Attributes
  private UmpleFile umpleFile;
  private String defaultPackage;
  private List<String> generates;
  private boolean shouldGenerate;
  private Glossary glossary;
  private String defaultNamespace;
  private String code;
  private Map<String,String> generatedCode;
  private Coordinate levelOffset;
  private Coordinate initialOffset;
  private Coordinate classSize;
  private int maxYLevels;
  private Coordinate offsetFromEdge;
  private int reflexiveSegmentLength;
  private String traceType;

  //UmpleModel Associations
  private List<Association> associations;
  private List<UmpleClass> umpleClasses;
  private List<StateMachine> stateMachineDefinitions;
  private List<UmpleInterface> umpleInterfaces;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleModel(UmpleFile aUmpleFile)
  {
    umpleFile = aUmpleFile;
    defaultPackage = null;
    generates = new ArrayList<String>();
    shouldGenerate = true;
    glossary = new Glossary();
    defaultNamespace = null;
    code = null;
    generatedCode = new HashMap<String,String>();
    levelOffset = new Coordinate(200,100,0,0);
    initialOffset = new Coordinate(50,30,0,0);
    classSize = new Coordinate(0,0,109,45);
    maxYLevels = 5;
    offsetFromEdge = new Coordinate(10,30,0,0);
    reflexiveSegmentLength = 15;
    traceType = "Console";
    associations = new ArrayList<Association>();
    umpleClasses = new ArrayList<UmpleClass>();
    stateMachineDefinitions = new ArrayList<StateMachine>();
    umpleInterfaces = new ArrayList<UmpleInterface>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUmpleFile(UmpleFile aUmpleFile)
  {
    boolean wasSet = false;
    umpleFile = aUmpleFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setDefaultPackage(String aDefaultPackage)
  {
    boolean wasSet = false;
    defaultPackage = aDefaultPackage;
    wasSet = true;
    return wasSet;
  }

  public boolean addGenerate(String aGenerate)
  {
    boolean wasAdded = false;
    wasAdded = generates.add(aGenerate);
    return wasAdded;
  }

  public boolean removeGenerate(String aGenerate)
  {
    boolean wasRemoved = false;
    wasRemoved = generates.remove(aGenerate);
    return wasRemoved;
  }

  public boolean setShouldGenerate(boolean aShouldGenerate)
  {
    boolean wasSet = false;
    shouldGenerate = aShouldGenerate;
    wasSet = true;
    return wasSet;
  }

  public boolean setGlossary(Glossary aGlossary)
  {
    boolean wasSet = false;
    glossary = aGlossary;
    wasSet = true;
    return wasSet;
  }

  public boolean setDefaultNamespace(String aDefaultNamespace)
  {
    boolean wasSet = false;
    defaultNamespace = aDefaultNamespace;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setGeneratedCode(Map<String,String> aGeneratedCode)
  {
    boolean wasSet = false;
    generatedCode = aGeneratedCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setTraceType(String aTraceType)
  {
    boolean wasSet = false;
    traceType = aTraceType;
    wasSet = true;
    return wasSet;
  }

  public UmpleFile getUmpleFile()
  {
    return umpleFile;
  }

  public String getDefaultPackage()
  {
    return defaultPackage;
  }

  public String getGenerate(int index)
  {
    String aGenerate = generates.get(index);
    return aGenerate;
  }

  public String[] getGenerates()
  {
    String[] newGenerates = generates.toArray(new String[generates.size()]);
    return newGenerates;
  }

  public int numberOfGenerates()
  {
    int number = generates.size();
    return number;
  }

  public boolean hasGenerates()
  {
    boolean has = generates.size() > 0;
    return has;
  }

  public int indexOfGenerate(String aGenerate)
  {
    int index = generates.indexOf(aGenerate);
    return index;
  }

  public boolean getShouldGenerate()
  {
    return shouldGenerate;
  }

  public Glossary getGlossary()
  {
    return glossary;
  }

  public String getDefaultNamespace()
  {
    return defaultNamespace;
  }

  public String getCode()
  {
    return code;
  }

  public Map<String,String> getGeneratedCode()
  {
    return generatedCode;
  }

  public String getTraceType()
  {
    return traceType;
  }

  public boolean isShouldGenerate()
  {
    return shouldGenerate;
  }

  public Association getAssociation(int index)
  {
    Association aAssociation = associations.get(index);
    return aAssociation;
  }

  public List<Association> getAssociations()
  {
    List<Association> newAssociations = Collections.unmodifiableList(associations);
    return newAssociations;
  }

  public int numberOfAssociations()
  {
    int number = associations.size();
    return number;
  }

  public boolean hasAssociations()
  {
    boolean has = associations.size() > 0;
    return has;
  }

  public int indexOfAssociation(Association aAssociation)
  {
    int index = associations.indexOf(aAssociation);
    return index;
  }

  public UmpleClass getUmpleClass(int index)
  {
    UmpleClass aUmpleClass = umpleClasses.get(index);
    return aUmpleClass;
  }

  public List<UmpleClass> getUmpleClasses()
  {
    List<UmpleClass> newUmpleClasses = Collections.unmodifiableList(umpleClasses);
    return newUmpleClasses;
  }

  public int numberOfUmpleClasses()
  {
    int number = umpleClasses.size();
    return number;
  }

  public boolean hasUmpleClasses()
  {
    boolean has = umpleClasses.size() > 0;
    return has;
  }

  public int indexOfUmpleClass(UmpleClass aUmpleClass)
  {
    int index = umpleClasses.indexOf(aUmpleClass);
    return index;
  }

  public StateMachine getStateMachineDefinition(int index)
  {
    StateMachine aStateMachineDefinition = stateMachineDefinitions.get(index);
    return aStateMachineDefinition;
  }

  public List<StateMachine> getStateMachineDefinitions()
  {
    List<StateMachine> newStateMachineDefinitions = Collections.unmodifiableList(stateMachineDefinitions);
    return newStateMachineDefinitions;
  }

  public int numberOfStateMachineDefinitions()
  {
    int number = stateMachineDefinitions.size();
    return number;
  }

  public boolean hasStateMachineDefinitions()
  {
    boolean has = stateMachineDefinitions.size() > 0;
    return has;
  }

  public int indexOfStateMachineDefinition(StateMachine aStateMachineDefinition)
  {
    int index = stateMachineDefinitions.indexOf(aStateMachineDefinition);
    return index;
  }

  public UmpleInterface getUmpleInterface(int index)
  {
    UmpleInterface aUmpleInterface = umpleInterfaces.get(index);
    return aUmpleInterface;
  }

  public List<UmpleInterface> getUmpleInterfaces()
  {
    List<UmpleInterface> newUmpleInterfaces = Collections.unmodifiableList(umpleInterfaces);
    return newUmpleInterfaces;
  }

  public int numberOfUmpleInterfaces()
  {
    int number = umpleInterfaces.size();
    return number;
  }

  public boolean hasUmpleInterfaces()
  {
    boolean has = umpleInterfaces.size() > 0;
    return has;
  }

  public int indexOfUmpleInterface(UmpleInterface aUmpleInterface)
  {
    int index = umpleInterfaces.indexOf(aUmpleInterface);
    return index;
  }

  public static int minimumNumberOfAssociations()
  {
    return 0;
  }

  public boolean addAssociation(Association aAssociation)
  {
    boolean wasAdded = false;
    if (associations.contains(aAssociation)) { return false; }
    associations.add(aAssociation);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssociation(Association aAssociation)
  {
    boolean wasRemoved = false;
    if (associations.contains(aAssociation))
    {
      associations.remove(aAssociation);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfUmpleClasses()
  {
    return 0;
  }

  public boolean addUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasAdded = false;
    if (umpleClasses.contains(aUmpleClass)) { return false; }
    umpleClasses.add(aUmpleClass);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUmpleClass(UmpleClass aUmpleClass)
  {
    boolean wasRemoved = false;
    if (umpleClasses.contains(aUmpleClass))
    {
      umpleClasses.remove(aUmpleClass);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfStateMachineDefinitions()
  {
    return 0;
  }

  public boolean addStateMachineDefinition(StateMachine aStateMachineDefinition)
  {
    boolean wasAdded = false;
    if (stateMachineDefinitions.contains(aStateMachineDefinition)) { return false; }
    stateMachineDefinitions.add(aStateMachineDefinition);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStateMachineDefinition(StateMachine aStateMachineDefinition)
  {
    boolean wasRemoved = false;
    if (stateMachineDefinitions.contains(aStateMachineDefinition))
    {
      stateMachineDefinitions.remove(aStateMachineDefinition);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public static int minimumNumberOfUmpleInterfaces()
  {
    return 0;
  }

  public boolean addUmpleInterface(UmpleInterface aUmpleInterface)
  {
    boolean wasAdded = false;
    if (umpleInterfaces.contains(aUmpleInterface)) { return false; }
    umpleInterfaces.add(aUmpleInterface);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUmpleInterface(UmpleInterface aUmpleInterface)
  {
    boolean wasRemoved = false;
    if (umpleInterfaces.contains(aUmpleInterface))
    {
      umpleInterfaces.remove(aUmpleInterface);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    associations.clear();
    umpleClasses.clear();
    stateMachineDefinitions.clear();
    umpleInterfaces.clear();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public List<UmpleElement> getUmpleElements()
  {
    List<UmpleElement> all = new ArrayList<UmpleElement>();
    all.addAll(getUmpleClasses());
    all.addAll(getUmpleInterfaces());
    return all;
  }

  public UmpleInterface addUmpleInterface(String name)
  {
    UmpleInterface newInterface = getUmpleInterface(name);
    if (newInterface == null)
    {
      newInterface = new UmpleInterface(name);
      addUmpleInterface(newInterface);
    }
    return newInterface;
  }

  public UmpleClass addUmpleClass(String name)
  {
    UmpleClass newClass = getUmpleClass(name);
    if (newClass == null)
    {
      newClass = new UmpleClass(name);
      addUmpleClass(newClass);
    }
    return newClass;
  }
  
  public Association getAssociation(String name)
  {
    for (Association a : associations)
    {
      if (a.getName().equals(name))
      {
        return a;
      }
    }
    return null;
  }
  
  public AssociationClass addAssociationClass(String className)
  {
    AssociationClass newClass = (AssociationClass) getUmpleClass(className);
    if (newClass == null)
    {
      newClass = new AssociationClass(className);
      addUmpleClass(newClass);
    }
    return newClass;
  }

  public String getDefaultGenerate()
  {
    if (numberOfGenerates() == 0)
    {
      return null;
    }
    else
    {
      return getGenerate(0);
    }
  }
  
  public UmpleClass getUmpleClass(String name)
  {
    for (UmpleClass aClass : getUmpleClasses())
    {
      if (aClass.getName().equals(name))
      {
        return aClass;
      }
    }
    return null;
  }
  
  public UmpleInterface getUmpleInterface(String name)
  {
    for (UmpleInterface aInterface : getUmpleInterfaces())
    {
      if (aInterface.getName().equals(name))
      {
        return aInterface;
      }
    }
    return null;
  }
  
  
  public StateMachine getStateMachineDefinition(String name)
  {
    for (StateMachine aStateMachine : getStateMachineDefinitions())
    {
      if (aStateMachine.getName().equals(name))
      {
        return aStateMachine;
      }
    }
    return null;
  }
    
  public void run()
  {
    UmpleParser parser = new UmpleInternalParser(this);
    String input = SampleFileWriter.readContent(getUmpleFile().getFile());
    ParseResult result = parser.parse("program", input);
    
    if (!result.getWasSuccess())
    {
      Position position = result.getPosition();
      String errorMessage = "Syntax error:\n" + "Line:" + position.getLineNumber() + " Char:" + position.getCharacterOffset();
      throw new UmpleCompilerException(errorMessage,null);
    }
    
    result = parser.analyze(getShouldGenerate());
    
    if (result.getWasSuccess())
    {
    
    }
    else
    {
      Position position = result.getPosition();
      String errorMessage = "Semantic error:\n" + "Line:" + position.getLineNumber() + " Char:" + position.getCharacterOffset();
      throw new UmpleCompilerException(errorMessage,null);
    }
  }  
  
   // Generates the actual code
  public void generate()
  {
    try
    {
      for (String target : getGenerates())
      {
        String className = StringFormatter.format("cruise.umple.compiler.{0}Generator",target);
        Class<?> classDefinition = Class.forName(className);
        CodeGenerator generator = (CodeGenerator) classDefinition.newInstance();
        generator.setModel(this);
        generator.generate();
      }
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("Unable to generate code",e);
    }
  }
  
  public Coordinate getDefaultClassPosition(int numDefaults)
  {
    int xIndex  = 0;
    int yIndex = 0;
    int yOffset = 0;
    int xOffset = 0;
    
    xIndex = (numDefaults-1) / (maxYLevels);
    yIndex = (numDefaults-1) % (maxYLevels);
    yOffset = (yIndex * levelOffset.getY()) + initialOffset.getY();
    xOffset = (xIndex * levelOffset.getX()) + initialOffset.getX();

    return new Coordinate(xOffset,yOffset,classSize.getWidth(),classSize.getHeight());
  }
  
  public Coordinate[] getDefaultAssociationPosition(Association a)
  {
    Coordinate[] defaults = new Coordinate[2];
    int offsetY = offsetFromEdge.getX();
  	int offsetX = offsetFromEdge.getY();
  	
  	String classOne = a.getEnd(0).getClassName();
  	String classTwo = a.getEnd(1).getClassName();
  	Coordinate classOnePos = getUmpleClass(classOne).getPosition();
  	Coordinate classTwoPos = getUmpleClass(classTwo).getPosition();
  	
  	if (classOne.equals(classTwo))
  	{
  	  return getDefaultReflexiveAssociationPosition(a);
  	}
  	
  	int num = 1;
  	String tempClass1 = "";
  	String tempClass2 = "";
  	for (Association temp : getAssociations())
  	{
  	  tempClass1 = temp.getEnd(0).getClassName();
  	  tempClass2 = temp.getEnd(1).getClassName();
  	  
  	  if (temp.getName().equals(a.getName()) &&
  	  	  tempClass1.equals(classOne)        && 
  	  	  tempClass2.equals(classTwo)) 
  	  {
  	  	 break; 
  	  }
  	  
  	  if (tempClass1.equals(classOne) && tempClass2.equals(classTwo)){ ++num; break; }
  	  else if (tempClass1.equals(classTwo) && tempClass2.equals(classOne)){ ++num; break; }
  	}
  	
  	Coordinate classOneNoX = new Coordinate(classOnePos.getX(),classOnePos.getY(),classOnePos.getWidth(),classOnePos.getHeight());
  	Coordinate classTwoNoX = new Coordinate(classTwoPos.getX(),classTwoPos.getY(),classTwoPos.getWidth(),classTwoPos.getHeight());
  	Coordinate classOneNoY = new Coordinate(classOnePos.getX(),classOnePos.getY(),classOnePos.getWidth(),classOnePos.getHeight());
  	Coordinate classTwoNoY = new Coordinate(classTwoPos.getX(),classTwoPos.getY(),classTwoPos.getWidth(),classTwoPos.getHeight());
  	classOneNoX.setX(0);
  	classTwoNoX.setX(0);
  	classOneNoY.setY(0);
  	classTwoNoY.setY(0);
  	String whereVert = classOneNoX.whereIs(classTwoNoX);
  	String whereHorz = classOneNoY.whereIs(classTwoNoY);
  	 
  	// alternative 1: left/right wall of class one to left/right wall of class two
  	int offsetOneX = whereHorz.equals("right")? classOnePos.getWidth() : 0;
  	int offsetTwoX = whereHorz.equals("right")? 0 : classTwoPos.getWidth();
  	int offsetOneY = num > 1 ? (num+1)*offsetY : offsetY;
  	int offsetTwoY = num > 1 ? (num+1)*offsetY : offsetY;
  	Coordinate offsetOne = new Coordinate(offsetOneX, offsetOneY, 0, 0);
  	Coordinate offsetTwo = new Coordinate(offsetTwoX, offsetTwoY, 0, 0);
  	Coordinate start = new Coordinate(classOnePos.getX() + offsetOne.getX(),
  									  classOnePos.getY() + offsetOne.getY(),
  									  0,0);
  	Coordinate end = new Coordinate(  classTwoPos.getX() + offsetTwo.getX(),
  									  classTwoPos.getY() + offsetTwo.getY(),
  									  0,0);
  	
  	int distance = start.distanceTo(end);
  	
  	// alternative 2: top/bottom wall of class one to top/bottom wall of class two
  	int altXOne = num*offsetX;
  	int altXTwo = num*offsetX;
  	int altYOne = whereVert.equals("top")? 0 : classOnePos.getHeight();
  	int altYTwo = whereVert.equals("top")? classTwoPos.getHeight() : 0;
  	Coordinate altOffsetOne = new Coordinate(altXOne, altYOne, 0, 0);
  	Coordinate altOffsetTwo = new Coordinate(altXTwo, altYTwo, 0, 0);
  	Coordinate altStart = new Coordinate(classOnePos.getX() + altOffsetOne.getX(),
  									     classOnePos.getY() + altOffsetOne.getY(),
  									     0,0);
  	Coordinate altEnd = new Coordinate(  classTwoPos.getX() + altOffsetTwo.getX(),
  									     classTwoPos.getY() + altOffsetTwo.getY(),
  									     0,0);
  	
  	int altDistance = altStart.distanceTo(altEnd);
  	
  	// choose alternative that generates the shortest line
  	if (altDistance < distance)
  	{
      defaults[0] = altOffsetOne;
  	  defaults[1] = altOffsetTwo;
  	} 
  	else
    {
      defaults[0] = offsetOne;
      defaults[1] = offsetTwo;
  	}
    
    return defaults;
  }
  
  private Coordinate[] getDefaultReflexiveAssociationPosition(Association a)
  {
    Coordinate[] defaults = new Coordinate[2];
    String name  = a.getEnd(0).getClassName();
    Coordinate position = getUmpleClass(name).getPosition();
    
    // determine which corner the association should be positioned at
    int index = 0;
    for (int i=0; i < numberOfAssociations(); i++)
    {
      Association current = getAssociation(i);
      if (current.getEnd(0).getClassName().equals(name) && current.getEnd(1).getClassName().equals(name))
      {    
        if (current.numberOfPositions() > 0)
        {
          if (current.getPosition(0).getStatus().equals(Coordinate.Status.Defaulted))
          {
            index += 1;
          }
        }
      }
    }
    
    Coordinate offsetOne = new Coordinate(0,0,0,0);
    Coordinate offsetTwo = new Coordinate(0,0,0,0);
    
    if (index % 4 == 0)
    {
      offsetOne.setX(reflexiveSegmentLength);
      offsetOne.setY(position.getHeight());
      offsetTwo.setX(0);
      offsetTwo.setY(position.getHeight() - reflexiveSegmentLength);
    }
    else if (index % 4 == 1)
    {
      offsetOne.setX(position.getWidth() - reflexiveSegmentLength);
      offsetOne.setY(position.getHeight());
      offsetTwo.setX(position.getWidth());
      offsetTwo.setY(position.getHeight() - reflexiveSegmentLength);
    }
    else if (index % 4 == 2)
    {
      offsetOne.setX(position.getWidth() - reflexiveSegmentLength);
      offsetOne.setY(0);
      offsetTwo.setX(position.getWidth());
      offsetTwo.setY(reflexiveSegmentLength);
    }
    else
    {
      offsetOne.setX(reflexiveSegmentLength);
      offsetOne.setY(0);
      offsetTwo.setX(0);
      offsetTwo.setY(reflexiveSegmentLength);
    }
    
    defaults[0] = offsetOne;
    defaults[1] = offsetTwo;
    
    return defaults;
   }
}