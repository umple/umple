/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.ArrayList;
import java.util.List;

/**
 * @umplesource UmpleImport.ump 41
 * @umplesource UmpleImport_CodeModels.ump 13
 */
// line 41 "../../../../src/UmpleImport.ump"
// line 13 "../../../../src/UmpleImport_CodeModels.ump"
public class UmpleImportModel
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleImportModel Attributes
  private String currentPackageName;
  private StringBuilder umpleBuilder;
  private List<UmpleImportElement> components;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportModel(String aCurrentPackageName)
  {
    currentPackageName = aCurrentPackageName;
    umpleBuilder = new StringBuilder();
    components = new ArrayList<UmpleImportElement>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCurrentPackageName(String aCurrentPackageName)
  {
    boolean wasSet = false;
    currentPackageName = aCurrentPackageName;
    wasSet = true;
    return wasSet;
  }

  public String getCurrentPackageName()
  {
    return currentPackageName;
  }

  public void delete()
  {}

  @umplesourcefile(line={20},file={"UmpleImport_CodeModels.ump"},javaline={61},length={6})
   public void addComponet(UmpleImportElement component){
    components.add(component);
		if (isPackage(component)) {
			currentPackageName = component.getName();
		}
  }

  @umplesourcefile(line={27},file={"UmpleImport_CodeModels.ump"},javaline={69},length={7})
   public String generateUmple(){
    umpleBuilder = new StringBuilder();
		for (UmpleImportElement component : components) {
			umpleBuilder.append(component.generateUmple());
		}
		return umpleBuilder.toString();
  }

  @umplesourcefile(line={35},file={"UmpleImport_CodeModels.ump"},javaline={78},length={3})
   private static  boolean isPackage(UmpleImportElement component){
    return component.getId().equals(UmpleImportConstants.ECOREPACKAGE);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "currentPackageName" + ":" + getCurrentPackageName()+ "]"
     + outputString;
  }
}