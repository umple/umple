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

  @umplesourcefile(line={2},file={"Generator_SuperCodeGenerator.ump"},javaline={36},length={2})
  public SuperCodeGenerator()
  {
    model = null;
    output = "";
    // line 2 "../../../../src/Generator_SuperCodeGenerator.ump"
    UmpleToPrimitiveMap = new HashMap<String, String>();
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
  //  @umplesourcefile(line={6},file={"Generator_SuperCodeGenerator.ump"},javaline={86},length={25})
  Map <String,String> UmpleToPrimitiveMap;
	
	//This method is because of issue number 373;
  @umplesourcefile(line={10},file={"Generator_SuperCodeGenerator.ump"},javaline={90},length={3})
	public void generate() {
	
	}
	
  @umplesourcefile(line={14},file={"Generator_SuperCodeGenerator.ump"},javaline={95},length={17})
	public abstract void initializeLangaugeBasedVariables();
	
  @umplesourcefile(line={16},file={"Generator_SuperCodeGenerator.ump"},javaline={98},length={15})
 	public String getType(UmpleVariable av)	{
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

}