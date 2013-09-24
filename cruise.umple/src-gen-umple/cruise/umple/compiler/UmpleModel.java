/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import java.util.*;

/**
 * Class UmpleModel is the central class describing the system being compiled.
 * 
 * The model contains everything that was derived from an Umple file (.ump) when it was parsed such as 
 * the classes, attributes, associations, state machines, methods, etc that were in it.
 * 
 * Put another way, when an Umple file (.ump) is parsed an Umple model is populated with everything that was parsed from that file.
 * 
 * Because of this it is absolutely critical to understand the model since it is basically the "root" of everything.
 * 
 * In Umple_Code.ump: Methods for manipulating the Model
 * @umplesource Umple.ump 25
 * @umplesource Trace.ump 17
 * @umplesource UmpleVersion.ump 13
 * @umplesource Umple_Code.ump 18
 */
// line 25 "../../../../src/Umple.ump"
// line 17 "../../../../src/Trace.ump"
// line 13 "../../../../src/UmpleVersion.ump"
// line 18 "../../../../src/Umple_Code.ump"
public class UmpleModel implements Runnable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String versionNumber = "1.17.0.2716";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleModel Attributes
  private UmpleFile umpleFile;
  private String defaultPackage;
  private List<GenerateTarget> generates;
  private boolean shouldGenerate;
  private Glossary glossary;
  private String defaultNamespace;
  private String code;
  private boolean debugMode;
  private ParseResult lastResult;
  private Map<String,String> generatedCode;

  /**
   * data for default class positioning
   */
  private Coordinate levelOffset;
  private Coordinate initialOffset;
  private Coordinate classSize;
  private int maxYLevels;

  /**
   * data for default association positioning
   */
  private Coordinate offsetFromEdge;
  private int reflexiveSegmentLength;
  private Tracer tracer;

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
    generates = new ArrayList<GenerateTarget>();
    shouldGenerate = true;
    glossary = new Glossary();
    defaultNamespace = null;
    code = null;
    debugMode = false;
    lastResult = null;
    generatedCode = new HashMap<String,String>();
    levelOffset = new Coordinate(200,100,0,0);
    initialOffset = new Coordinate(50,30,0,0);
    classSize = new Coordinate(0,0,109,45);
    maxYLevels = 5;
    offsetFromEdge = new Coordinate(10,30,0,0);
    reflexiveSegmentLength = 15;
    tracer = new Tracer("Console");
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

  public boolean addGenerate(GenerateTarget aGenerate)
  {
    boolean wasAdded = false;
    wasAdded = generates.add(aGenerate);
    return wasAdded;
  }

  public boolean removeGenerate(GenerateTarget aGenerate)
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

  public boolean setDebugMode(boolean aDebugMode)
  {
    boolean wasSet = false;
    debugMode = aDebugMode;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastResult(ParseResult aLastResult)
  {
    boolean wasSet = false;
    lastResult = aLastResult;
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

  public boolean setTracer(Tracer aTracer)
  {
    boolean wasSet = false;
    tracer = aTracer;
    wasSet = true;
    return wasSet;
  }

  /**
   * The Umple file (.ump) that was used to populate the model.
   */
  public UmpleFile getUmpleFile()
  {
    return umpleFile;
  }

  public String getDefaultPackage()
  {
    return defaultPackage;
  }

  public GenerateTarget getGenerate(int index)
  {
    GenerateTarget aGenerate = generates.get(index);
    return aGenerate;
  }

  public GenerateTarget[] getGenerates()
  {
    GenerateTarget[] newGenerates = generates.toArray(new GenerateTarget[generates.size()]);
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

  public int indexOfGenerate(GenerateTarget aGenerate)
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

  public boolean getDebugMode()
  {
    return debugMode;
  }

  public ParseResult getLastResult()
  {
    return lastResult;
  }

  public Map<String,String> getGeneratedCode()
  {
    return generatedCode;
  }

  @umplesourcefile(line={19},file={"Trace.ump"},javaline={286},length={2})
  public String getTraceType()
  {
    return getTracer().getName();
  }

  public Tracer getTracer()
  {
    return tracer;
  }

  public boolean isShouldGenerate()
  {
    return shouldGenerate;
  }

  public boolean isDebugMode()
  {
    return debugMode;
  }

  public Association getAssociation(int index)
  {
    Association aAssociation = associations.get(index);
    return aAssociation;
  }

  /**
   * The Associations contained within the model.
   */
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

  /**
   * The Umple Classes contained within the model.
   */
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

  /**
   * The State Machines contained within the model.
   */
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

  /**
   * The Umple interfaces contained within the model.
   */
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

  public boolean addAssociationAt(Association aAssociation, int index)
  {  
    boolean wasAdded = false;
    if(addAssociation(aAssociation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociations()) { index = numberOfAssociations() - 1; }
      associations.remove(aAssociation);
      associations.add(index, aAssociation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssociationAt(Association aAssociation, int index)
  {
    boolean wasAdded = false;
    if(associations.contains(aAssociation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssociations()) { index = numberOfAssociations() - 1; }
      associations.remove(aAssociation);
      associations.add(index, aAssociation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssociationAt(aAssociation, index);
    }
    return wasAdded;
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

  public boolean addUmpleClassAt(UmpleClass aUmpleClass, int index)
  {  
    boolean wasAdded = false;
    if(addUmpleClass(aUmpleClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleClasses()) { index = numberOfUmpleClasses() - 1; }
      umpleClasses.remove(aUmpleClass);
      umpleClasses.add(index, aUmpleClass);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmpleClassAt(UmpleClass aUmpleClass, int index)
  {
    boolean wasAdded = false;
    if(umpleClasses.contains(aUmpleClass))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleClasses()) { index = numberOfUmpleClasses() - 1; }
      umpleClasses.remove(aUmpleClass);
      umpleClasses.add(index, aUmpleClass);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmpleClassAt(aUmpleClass, index);
    }
    return wasAdded;
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

  public boolean addStateMachineDefinitionAt(StateMachine aStateMachineDefinition, int index)
  {  
    boolean wasAdded = false;
    if(addStateMachineDefinition(aStateMachineDefinition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineDefinitions()) { index = numberOfStateMachineDefinitions() - 1; }
      stateMachineDefinitions.remove(aStateMachineDefinition);
      stateMachineDefinitions.add(index, aStateMachineDefinition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStateMachineDefinitionAt(StateMachine aStateMachineDefinition, int index)
  {
    boolean wasAdded = false;
    if(stateMachineDefinitions.contains(aStateMachineDefinition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStateMachineDefinitions()) { index = numberOfStateMachineDefinitions() - 1; }
      stateMachineDefinitions.remove(aStateMachineDefinition);
      stateMachineDefinitions.add(index, aStateMachineDefinition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStateMachineDefinitionAt(aStateMachineDefinition, index);
    }
    return wasAdded;
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

  public boolean addUmpleInterfaceAt(UmpleInterface aUmpleInterface, int index)
  {  
    boolean wasAdded = false;
    if(addUmpleInterface(aUmpleInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleInterfaces()) { index = numberOfUmpleInterfaces() - 1; }
      umpleInterfaces.remove(aUmpleInterface);
      umpleInterfaces.add(index, aUmpleInterface);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmpleInterfaceAt(UmpleInterface aUmpleInterface, int index)
  {
    boolean wasAdded = false;
    if(umpleInterfaces.contains(aUmpleInterface))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleInterfaces()) { index = numberOfUmpleInterfaces() - 1; }
      umpleInterfaces.remove(aUmpleInterface);
      umpleInterfaces.add(index, aUmpleInterface);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmpleInterfaceAt(aUmpleInterface, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    associations.clear();
    umpleClasses.clear();
    stateMachineDefinitions.clear();
    umpleInterfaces.clear();
  }

  @umplesourcefile(line={20},file={"Umple_Code.ump"},javaline={672},length={6})
   public List<UmpleElement> getUmpleElements(){
    List<UmpleElement> all = new ArrayList<UmpleElement>();
    all.addAll(getUmpleClasses());
    all.addAll(getUmpleInterfaces());
    return all;
  }

  @umplesourcefile(line={28},file={"Umple_Code.ump"},javaline={680},length={9})
   public UmpleInterface addUmpleInterface(String name){
    UmpleInterface newInterface = getUmpleInterface(name);
    if (newInterface == null)
    {
      newInterface = new UmpleInterface(name);
      addUmpleInterface(newInterface);
    }
    return newInterface;
  }

  @umplesourcefile(line={39},file={"Umple_Code.ump"},javaline={691},length={9})
   public UmpleClass addUmpleClass(String name){
    UmpleClass newClass = getUmpleClass(name);
    if (newClass == null)
    {
      newClass = new UmpleClass(name, this);
      addUmpleClass(newClass);
    }
    return newClass;
  }

  @umplesourcefile(line={50},file={"Umple_Code.ump"},javaline={702},length={10})
   public Association getAssociation(String name){
    for (Association a : associations)
    {
      if (a.getName().equals(name))
      {
        return a;
      }
    }
    return null;
  }

  @umplesourcefile(line={62},file={"Umple_Code.ump"},javaline={714},length={9})
   public AssociationClass addAssociationClass(String className){
    AssociationClass newClass = (AssociationClass) getUmpleClass(className);
    if (newClass == null)
    {
      newClass = new AssociationClass(className);
      addUmpleClass(newClass);
    }
    return newClass;
  }

  @umplesourcefile(line={73},file={"Umple_Code.ump"},javaline={725},length={3})
   public void addGenerate(String lang){
    addGenerate(new GenerateTarget(lang, null));
  }

  @umplesourcefile(line={83},file={"Umple_Code.ump"},javaline={730},length={12})
   public String getDefaultGenerate(){
    // Note that this method should be getDefaultGenerateLanguage
    // To avoid rippling changes throughout the code, the name is left as is 
    if (numberOfGenerates() == 0)
    {
      return null;
    }
    else
    {
      return getGenerate(0).getLanguage();
    }
  }

  @umplesourcefile(line={97},file={"Umple_Code.ump"},javaline={744},length={10})
   public String getDefaultGeneratePath(){
    if (numberOfGenerates() == 0)
    {
      return null;
    }
    else
    {
      return getGenerate(0).getPath() == null ? "./" : getGenerate(0).getPath();
    }
  }

  @umplesourcefile(line={109},file={"Umple_Code.ump"},javaline={756},length={3})
   public void clearGenerates(){
    generates.clear();
  }

  @umplesourcefile(line={114},file={"Umple_Code.ump"},javaline={761},length={10})
   public UmpleClass getUmpleClass(String name){
    for (UmpleClass aClass : getUmpleClasses())
    {
      if (aClass.getName().equals(name))
      {
        return aClass;
      }
    }
    return null;
  }

  @umplesourcefile(line={126},file={"Umple_Code.ump"},javaline={773},length={10})
   public UmpleInterface getUmpleInterface(String name){
    for (UmpleInterface aInterface : getUmpleInterfaces())
    {
      if (aInterface.getName().equals(name))
      {
        return aInterface;
      }
    }
    return null;
  }

  @umplesourcefile(line={139},file={"Umple_Code.ump"},javaline={785},length={10})
   public StateMachine getStateMachineDefinition(String name){
    for (StateMachine aStateMachine : getStateMachineDefinitions())
    {
      if (aStateMachine.getName().equals(name))
      {
        return aStateMachine;
      }
    }
    return null;
  }


  /**
   * Creates a new parser, loads the input, parses, then analyses
   */
  @umplesourcefile(line={154},file={"Umple_Code.ump"},javaline={797},length={24})
   public void run(){
    boolean failed = false;
    String input;
    UmpleParser parser = new UmpleInternalParser(this);
    try {
      input = SampleFileWriter.readContent(getUmpleFile().getFile());
      // this adds command-based linked umple files to the content of file.
	  input = input+getUmpleFile().getLinkedFiles();
    }
    catch (RuntimeException e){
      input = "use "+getUmpleFile().getFileName()+";\n";
    }
    ParseResult result = parser.parse("program", input);
    failed = !result.getWasSuccess();
    lastResult = result;

    if(!failed)
      result = parser.analyze(getShouldGenerate());

    failed |= !result.getWasSuccess();

    if(failed || result.getHasWarnings())
      throw new UmpleCompilerException(result.toString(),null);
  }


  /**
   * Generates the actual code for each generation target
   */
  @umplesourcefile(line={182},file={"Umple_Code.ump"},javaline={827},length={36})
   public void generate(){
    boolean foundGenerator;
    Class<?> classDefinition = null;
    try
    {
      for (GenerateTarget target : getGenerates())
      {
        // Set the proper code generator for the target language.  (the "{0}" gets replaced by the language, so it could be "JavaGenerator")
        String className = StringFormatter.format("cruise.umple.compiler.{0}Generator",target.getLanguage());
    
        try {
          classDefinition = Class.forName(className);
          CodeGenerator generator = (CodeGenerator) classDefinition.newInstance();

          // Since the model contains everything that needs to be translated into generated code (such as Java or Cpp) set the model to use.
          generator.setModel(this);

          generator.setOutput(target.getPath());
          if(generator instanceof Uigu2Generator){
            ((Uigu2Generator)generator).setSharedFilesPath(target.getOption("sharedFilesPathname"));
          }
          CodeBlock.languageUsed = target.getLanguage();
          generator.generate();
        }
        catch (ClassNotFoundException cnf) {
          System.err.println("Code generator "+target.getLanguage()+ " not found. Check spelling.");
        }
      }
    }
    catch (Exception ex)
    {
      System.err.println("Code Generator error. Unable to generate code: Stack Trace Follows.");
      cruise.umple.util.ExceptionDumper.dumpCompilerError(ex);
      System.exit(-1);    
    }
  }

  @umplesourcefile(line={221},file={"Umple_Code.ump"},javaline={869},length={13})
   public Coordinate getDefaultClassPosition(int numDefaults){
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

  @umplesourcefile(line={236},file={"Umple_Code.ump"},javaline={884},length={91})
   public Coordinate[] getDefaultAssociationPosition(Association a){
    Coordinate[] defaults = new Coordinate[2];
    int offsetY = offsetFromEdge.getX();
    int offsetX = offsetFromEdge.getY();

    String classOne = a.getEnd(0).getClassName();
    String classTwo = a.getEnd(1).getClassName();
    Coordinate classOnePos = getUmpleClass(classOne).getCoordinates();
    Coordinate classTwoPos = getUmpleClass(classTwo).getCoordinates();

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

  @umplesourcefile(line={329},file={"Umple_Code.ump"},javaline={977},length={59})
   private Coordinate[] getDefaultReflexiveAssociationPosition(Association a){
    Coordinate[] defaults = new Coordinate[2];
    String name  = a.getEnd(0).getClassName();
    Coordinate position = getUmpleClass(name).getCoordinates();

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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "defaultPackage" + ":" + getDefaultPackage()+ "," +
            "shouldGenerate" + ":" + getShouldGenerate()+ "," +
            "defaultNamespace" + ":" + getDefaultNamespace()+ "," +
            "code" + ":" + getCode()+ "," +
            "debugMode" + ":" + getDebugMode()+ "," +
            "traceType" + ":" + getTraceType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "umpleFile" + "=" + (getUmpleFile() != null ? !getUmpleFile().equals(this)  ? getUmpleFile().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "glossary" + "=" + (getGlossary() != null ? !getGlossary().equals(this)  ? getGlossary().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lastResult" + "=" + (getLastResult() != null ? !getLastResult().equals(this)  ? getLastResult().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "generatedCode" + "=" + (getGeneratedCode() != null ? !getGeneratedCode().equals(this)  ? getGeneratedCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tracer" + "=" + (getTracer() != null ? !getTracer().equals(this)  ? getTracer().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={77},file={"Umple_Code.ump"},javaline={1059},length={5})
  @umplesourcefile(line={78},file={"Umple_Code.ump"},javaline={1060},length={4})
  public void addGenerate(Collection <?extends GenerateTarget> c) 
  {
    generates.addAll(c);
  }

}