/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.cpp.generator.UmpleCppPoliciesProcessor;
import cruise.umple.cpp.core.ContentsDescriptor;

/**
 * @umplesource Generator.ump 212
 * @umplesource Generator_CodeRTCpp.ump 12
 */
// line 212 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeRTCpp.ump"
public class RTCppGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RTCppGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RTCppGenerator()
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
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={14},file={"Generator_CodeRTCpp.ump"},javaline={91},length={48})
  @umplesourcefile(line={15},file={"Generator_CodeRTCpp.ump"},javaline={92},length={22})
  public void generate()
  {
  	try {
  		final StringBuilder code = new StringBuilder();
  		new UmpleCppPoliciesProcessor() {
			@Override
  @umplesourcefile(line={21},file={"Generator_CodeRTCpp.ump"},javaline={99},length={10})
			public void handleGeneratedContents(List<ContentsDescriptor> contentsDescriptor) {
				try {
					for(ContentsDescriptor descriptor:contentsDescriptor){
						generateContents(model, code, descriptor.getFileName(), descriptor.getContents(), descriptor.getPath());
					}
				} catch (IOException e) {
					throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
				}
				
			}
		}.generateRootElement(model);
		model.setCode(code.toString());
	} catch (Exception e) {
		throw new UmpleCompilerException("There was a problem with generating classes. " + e, e);
	}
  }
  
  @umplesourcefile(line={38},file={"Generator_CodeRTCpp.ump"},javaline={117},length={24})
  protected void generateContents(UmpleModel model ,StringBuilder model_code, String filename, String content, String owingFolder) throws IOException {		
		 String path = model.getUmpleFile().getPath() + "/";
		 owingFolder= owingFolder.replace(".", "::").replace("::", "/");
		 String qualifiedPath = path+ owingFolder;
		 File folder = new File(qualifiedPath);
		 if (!folder.exists()) {
			 folder.mkdirs();
		 }
		 
		 File folderFile = new File(qualifiedPath+ "/"+ filename); 	
		 
		 if (!folderFile.exists()) {
		 	folderFile.createNewFile();
		 }
		 
		 model.getGeneratedCode().put(filename,content);
		 
		 model_code.append(content);
		 model_code.append("\n\n");
		 
		 BufferedWriter output = new BufferedWriter(new FileWriter(folderFile));
		 output.write(content);
		 output.close();
	}

}