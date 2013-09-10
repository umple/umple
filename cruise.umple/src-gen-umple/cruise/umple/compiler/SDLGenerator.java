/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.sdl.*;

/**
 * @umplesource Generator.ump 291
 * @umplesource Generator_CodeSDL.ump 12
 */
// line 291 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeSDL.ump"
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

  @umplesourcefile(line={25},file={"Generator_CodeSDL.ump"},javaline={78},length={18})
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

  @umplesourcefile(line={46},file={"Generator_CodeSDL.ump"},javaline={98},length={13})
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

  @umplesourcefile(line={61},file={"Generator_CodeSDL.ump"},javaline={113},length={3})
   public String translate(String format, Constraint constraint){
    return "{0}";
  }

  @umplesourcefile(line={66},file={"Generator_CodeSDL.ump"},javaline={118},length={8})
   public String translate(String name, UmpleInterface aInterface){
    String result = "";
    if ("packageDefinition".equals(name) && aInterface.getPackageName().length() > 0)
    {
	
    }
    return result;
  }

  @umplesourcefile(line={76},file={"Generator_CodeSDL.ump"},javaline={128},length={43})
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

  @umplesourcefile(line={121},file={"Generator_CodeSDL.ump"},javaline={173},length={3})
   private String getExtendAndImplements(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={126},file={"Generator_CodeSDL.ump"},javaline={178},length={3})
   private String getImplementsInterfacesNames(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={131},file={"Generator_CodeSDL.ump"},javaline={183},length={3})
   private String getExtendClassesNames(UmpleClass uClass){
    return "";
  }

  @umplesourcefile(line={137},file={"Generator_CodeSDL.ump"},javaline={188},length={3})
   private String translate(String keyName, UmpleVariable av, boolean isMany){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={143},file={"Generator_CodeSDL.ump"},javaline={193},length={3})
   public String translate(String keyName, State state){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={149},file={"Generator_CodeSDL.ump"},javaline={198},length={3})
   public String translate(String keyName, StateMachine sm){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={155},file={"Generator_CodeSDL.ump"},javaline={203},length={3})
   public String translate(String keyName, Event event){
    return "UNKNOWN ID: " + keyName;
  }

  @umplesourcefile(line={160},file={"Generator_CodeSDL.ump"},javaline={208},length={5})
   public void generate(){
    prepare();
    writeFile();
    GeneratorHelper.postpare(model);
  }

  @umplesourcefile(line={168},file={"Generator_CodeSDL.ump"},javaline={215},length={27})
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

  @umplesourcefile(line={198},file={"Generator_CodeSDL.ump"},javaline={244},length={3})
   public String translate(String id, Attribute attribute){
    return null;
  }

  @umplesourcefile(line={203},file={"Generator_CodeSDL.ump"},javaline={249},length={3})
   public String translate(String keyName, TraceItem ti){
    return null;
  }

  @umplesourcefile(line={214},file={"Generator_CodeSDL.ump"},javaline={254},length={14})
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

  @umplesourcefile(line={230},file={"Generator_CodeSDL.ump"},javaline={270},length={23})
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

  @umplesourcefile(line={258},file={"Generator_CodeSDL.ump"},javaline={295},length={3})
   public String nameOf(AssociationVariable av){
    return "";
  }

  @umplesourcefile(line={264},file={"Generator_CodeSDL.ump"},javaline={300},length={4})
   private void generateNullableConstructorSignature(GeneratedClass genClass){
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }

  @umplesourcefile(line={271},file={"Generator_CodeSDL.ump"},javaline={306},length={3})
   private void addImports(UmpleClass aClass, GeneratedClass genClass){
    
  }

  @umplesourcefile(line={276},file={"Generator_CodeSDL.ump"},javaline={311},length={3})
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
  //  @umplesourcefile(line={14},file={"Generator_CodeSDL.ump"},javaline={328},length={16})
  private static List<String> SdlPrimitives ;

//  @umplesourcefile(line={16},file={"Generator_CodeSDL.ump"},javaline={331},length={13})
  static 
  {
    SdlPrimitives = new ArrayList<String>();
    //SDL types
    SdlPrimitives.add("TINYTEXT");
  }

//  @umplesourcefile(line={208},file={"Generator_CodeSDL.ump"},javaline={339},length={5})
  @Override public String translate(String id, AssociationVariable aVar) 
  {
    return null;
  }

}