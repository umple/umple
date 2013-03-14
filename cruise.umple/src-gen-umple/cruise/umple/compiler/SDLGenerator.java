/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.sdl.*;

/**
 * @umplesource Generator.ump 249
 * @umplesource Generator_CodeSDL.ump 12
 */
// line 249 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeSDL.ump"
public class SDLGenerator implements CodeGenerator,CodeTranslator
{

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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + getModel() != null ? !getModel() .equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 15 ../../../../src/Generator_CodeSDL.ump
  private static List<String> SdlPrimitives;

  static
  {   
    SdlPrimitives = new ArrayList<String>();
    //SDL types
    SdlPrimitives.add("TINYTEXT");

  }
  
  public void prepare()
  {
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
  
   
  public ILang getLanguageFor(UmpleElement aElement)
  {
    if (aElement instanceof UmpleInterface)
    {
    	return null;
    }
    else if (aElement instanceof UmpleClass)
    {
      return new SDLClassGenerator();
    } 
    else{
    	return null;    	
    }
  }
  
  public String translate(String format, Constraint constraint)
  {
  	return "{0}";
  }
  
  public String translate(String name, UmpleInterface aInterface)
  {
    String result = "";
    if ("packageDefinition".equals(name) && aInterface.getPackageName().length() > 0)
    {
	
    }
    return result;
  }
  
  public String translate(String name, UmpleClass aClass)
  {
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
  
   private String getExtendAndImplements(UmpleClass uClass)
  {
	return ""; 
  }
  
   private String getImplementsInterfacesNames(UmpleClass uClass)
   {
	return ""; 
   }

 private String getExtendClassesNames(UmpleClass uClass)
  {
	return ""; 
  }


  private String translate(String keyName, UmpleVariable av, boolean isMany)
  {
   
    return "UNKNOWN ID: " + keyName;
  }
  
  public String translate(String keyName, State state)
  {
   
    return "UNKNOWN ID: " + keyName;
  }
  
  public String translate(String keyName, StateMachine sm)
  {
   
    return "UNKNOWN ID: " + keyName;
  }
  
  public String translate(String keyName, Event event)
  {
    return "UNKNOWN ID: " + keyName;
  }
  
  public void generate()
  {
    prepare();
    writeFile();
    GeneratorHelper.postpare(model);
  }
  
  
  private void writeFile()
  {
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
  

public String translate(String id, Attribute attribute) {

	return null;
}

@Override
public String translate(String id, AssociationVariable aVar) {
	return null;
}

  private String getUpperCaseName(String name)
  {
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
  
  private void prepare(UmpleClass aClass)
  {
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
  
  
  public String nameOf(AssociationVariable av)
  {
	return "";
  }
  
  
  private void generateNullableConstructorSignature(GeneratedClass genClass)
  {
    String currentConstructor = genClass.getLookup("constructorSignature");
    genClass.setLookup("constructorSignature_nulled", StringFormatter.appendParameter(currentConstructor, " = null"));
  }
  

  private void addImports(UmpleClass aClass, GeneratedClass genClass)
  {

  }

  private void addAssociationImports(UmpleClass aClass, GeneratedClass genClass)
  {

  }
}