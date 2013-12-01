/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.sdl.*;

/**
 * @umplesource Generator.ump 322
 * @umplesource Generator_CodeSDL.ump 11
 */
// line 322 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeSDL.ump"
public class SDLGenerator implements CodeGenerator,CodeTranslator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SDLGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SDLGenerator()
  {
    model = null;
    output = "";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutput(String aOutput)
  {
    boolean wasSet = false;
    output = aOutput;
    wasSet = true;
    return wasSet;
  }

  /**
   * Contains various aspects from an Umple file (.ump), such as classes, attributes, associations and methods.  Generated output is based
   * off of what's contained in here.
   */
  public UmpleModel getModel()
  {
    return model;
  }

  public String getOutput()
  {
    return output;
  }

  public void delete()
  {}

  @umplesourcefile(line={27},file={"Generator_CodeSDL.ump"},javaline={79},length={18})
   public void prepare(){
    List<UmpleClass> allClasses = new ArrayList<UmpleClass>(model.getUmpleClasses());
    for (UmpleClass aClass : allClasses)
    {
      prepare(aClass);
    }
    
    for (UmpleClass aClass : model.getUmpleClasses())
    {
      GeneratedClass genClass = aClass.getGeneratedClass();
 
    }  
    //Add internal association class to replace M..N or * associations
    for (int i = 0; i < model.numberOfUmpleClasses(); i++)
    {
   
    }
  }

  @umplesourcefile(line={48},file={"Generator_CodeSDL.ump"},javaline={99},length={13})
   public ILang getLanguageFor(UmpleElement aElement){
    if (aElement instanceof UmpleInterface)
    {
    	return null;
    }
    else if (aElement instanceof UmpleClass)
    {
      return (ILang) new SDLClassGenerator();
    } 
    else{
    	return null;    	
    }
  }

  @umplesourcefile(line={63},file={"Generator_CodeSDL.ump"},javaline={114},length={3})
   public String translate(String format, Constraint constraint){
    return "{0}";
  }

  @umplesourcefile(line={68},file={"Generator_CodeSDL.ump"},javaline={119},length={8})
   public String translate(String name, UmpleInterface aInterface){
    String result = "";
    if ("packageDefinition".equals(name) && aInterface.getPackageName().length() > 0)
    {
	
    }
    return result;
  }

  @umplesourcefile(line={78},file={"Generator_CodeSDL.ump"},javaline={129},length={43})
   public String translate(String name, UmpleClass aClass){
    if ("constructorMandatory".equals(name))
    {
    }
    else if ("packageName".equals(name))
    {
    }
    else if ("packageNameQuoted".equals(name))
    {
     }
    else if ("packageDefinition".equals(name))
    {
    }
    else if ("packageDefinitionEnd".equals(name))
    {
      return "\n";
    }
    else if ("type".equals(name))
    {

    } 
    else if ("typeQuoted".equals(name))
    {

    } 
    else if ("typeWithPackage".equals(name))
    {

    } 
    else if ("isA".equals(name))
    {

    }
    else if ("beforeCode".equals(name))
    {

    }
    else if ("afterCode".equals(name))
    {

    }
    return "UNKNOWN ID: " + name;
  }

  @umplesourcefile(line={123},file={"Generator_CodeSDL.ump"},javaline={174},length={3})
   private String getExtendAndImplements(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={128},file={"Generator_CodeSDL.ump"},javaline={179},length={3})
   private String getImplementsInterfacesNames(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={133},file={"Generator_CodeSDL.ump"},javaline={184},length={3})
   private String getExtendClassesNames(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={140},file={"Generator_CodeSDL.ump"},javaline={189},length={3})
   private String translate(String keyName, UmpleVariable av, boolean isMany){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={146},file={"Generator_CodeSDL.ump"},javaline={194},length={3})
   public String translate(String keyName, State state){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={152},file={"Generator_CodeSDL.ump"},javaline={199},length={3})
   public String translate(String keyName, StateMachine sm){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={157},file={"Generator_CodeSDL.ump"},javaline={204},length={3})
   public String translate(String keyName, Event event){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={162},file={"Generator_CodeSDL.ump"},javaline={209},length={5})
   public void generate(){
    prepare();
    writeFile();
    GeneratorHelper.postpare(model);
  }

  @umplesourcefile(line={170},file={"Generator_CodeSDL.ump"},javaline={216},length={27})
   private void writeFile(){
    try //Output all elements in a single file
    {
      String path = StringFormatter.addPathOrAbsolute( 
    						  model.getUmpleFile().getPath(), 
        	                  getOutput());
      
      File file = new File(path);
      file.mkdirs();

      String sqlName = model.getUmpleFile().getFileName();
      if (sqlName.endsWith(".ump"))
      {
        sqlName = sqlName.substring(0, sqlName.length() - 4);
      }
      String filename = path + File.separator + sqlName + ".sdl";
      BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
      String finalResult = "";
      bw.write(finalResult);
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
    }
  }

  @umplesourcefile(line={200},file={"Generator_CodeSDL.ump"},javaline={245},length={3})
   public String translate(String id, Attribute attribute){
    return null;
  }

  @umplesourcefile(line={205},file={"Generator_CodeSDL.ump"},javaline={250},length={3})
   public String translate(String keyName, TraceItem ti){
    return null;
  }

  @umplesourcefile(line={216},file={"Generator_CodeSDL.ump"},javaline={255},length={14})
   private String getUpperCaseName(String name){
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

  @umplesourcefile(line={232},file={"Generator_CodeSDL.ump"},javaline={271},length={23})
   private void prepare(UmpleClass aClass){
    if (aClass.getGeneratedClass() != null)
    {
      return;
    }
    else if (aClass.isRoot())
    {
      GeneratedClass genClass = aClass.createGeneratedClass(model);

    }
    else
    {
      UmpleClass parent = model.getUmpleClass(aClass.getExtendsClass().getName());
      prepare(parent);
      GeneratedClass genClass = aClass.createGeneratedClass(model);

    }
    
    if (aClass.getIsSingleton())
    {

    }
  }

  @umplesourcefile(line={260},file={"Generator_CodeSDL.ump"},javaline={296},length={3})
   public String nameOf(AssociationVariable av){
    return "";
  }

  @umplesourcefile(line={266},file={"Generator_CodeSDL.ump"},javaline={301},length={4})
   private void generateNullableConstructorSignature(GeneratedClass genClass){
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }

  @umplesourcefile(line={274},file={"Generator_CodeSDL.ump"},javaline={307},length={3})
   private void addImports(UmpleClass aClass, GeneratedClass genClass){
    
  }

  @umplesourcefile(line={279},file={"Generator_CodeSDL.ump"},javaline={312},length={3})
   private void addAssociationImports(UmpleClass aClass, GeneratedClass genClass){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={14},file={"Generator_CodeSDL.ump"},javaline={328},length={17})
  private static List<String> SdlPrimitives ;

//  @umplesourcefile(line={16},file={"Generator_CodeSDL.ump"},javaline={331},length={14})
  static 
  {
    SdlPrimitives = new ArrayList<String>();
    //SDL types
    SdlPrimitives.add("TINYTEXT");
  }

//  @umplesourcefile(line={207},file={"Generator_CodeSDL.ump"},javaline={339},length={6})
  @Override
  @umplesourcefile(line={209},file={"Generator_CodeSDL.ump"},javaline={341},length={4})
public String translate (String id, AssociationVariable aVar) 
  {
    return null;
  }

  
}