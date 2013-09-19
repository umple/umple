/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource Generator.ump 37
 * @umplesource Generator_SuperCodeGenerator.ump 1
 */
// line 37 "../../../../src/Generator.ump"
// line 1 "../../../../src/Generator_SuperCodeGenerator.ump"
public abstract class SuperCodeGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SuperCodeGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={2},file={"Generator_SuperCodeGenerator.ump"},javaline={36},length={3})
  public SuperCodeGenerator()
  {
    model = null;
    output = "";
    // line 2 "../../../../src/Generator_SuperCodeGenerator.ump"
    UmpleToPrimitiveMap = new HashMap<String, String>();
    	TraceLookupMap = new HashMap<String,String>();
    	initializeLangaugeBasedVariables();
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

  @umplesourcefile(line={13},file={"Generator_SuperCodeGenerator.ump"},javaline={75},length={15})
   public String getType(UmpleVariable av){
    String myType = av.getType();
    	if (myType == null || myType.length() == 0)
    	{
      		return UmpleToPrimitiveMap.get("String");
    	}
    	else if (UmpleToPrimitiveMap.containsKey(myType))
    	{
      		return UmpleToPrimitiveMap.get(myType);
    	}
    	else
    	{
      		return myType;
   		 }
  }

  @umplesourcefile(line={29},file={"Generator_SuperCodeGenerator.ump"},javaline={92},length={8})
   public String translate(String keyName, TraceItem ti){
    if (keyName.length()>5&&"trace".equals(keyName.substring(0,5))){
			return TraceLookupMap.get(keyName.substring(5).toLowerCase());
    	}
    	else {
    		return "INVALID KEYNAME IN TRANSLATE";
    	}
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={22},file={"Generator.ump"},javaline={102},length={2})
  @Override
  public void generate(){
          return ;
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
  //  @umplesourcefile(line={7},file={"Generator_SuperCodeGenerator.ump"},javaline={125},length={8})
  Map <String,String> UmpleToPrimitiveMap ;

//  @umplesourcefile(line={8},file={"Generator_SuperCodeGenerator.ump"},javaline={128},length={5})
  Map <String,String> TraceLookupMap ;

//  @umplesourcefile(line={10},file={"Generator_SuperCodeGenerator.ump"},javaline={131},length={2})
  @umplesourcefile(line={11},file={"Generator_SuperCodeGenerator.ump"},javaline={132},length={1})
  public abstract void initializeLangaugeBasedVariables() ;

}