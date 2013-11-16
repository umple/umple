/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource UmpleImport.ump 54
 * @umplesource UmpleImport_CodeModels.ump 47
 */
// line 54 "../../../../src/UmpleImport.ump"
// line 47 "../../../../src/UmpleImport_CodeModels.ump"
public class UmpleImportClass extends UmpleImportElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleImportClass Attributes
  private String packageName;
  private boolean isAbstract;
  private boolean isInterface;
  private ArrayList<String> superTypes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportClass(String aId, String aName, String aPackageName, boolean aIsAbstract, boolean aIsInterface, ArrayList<String> aSuperTypes)
  {
    super(aId, aName);
    packageName = aPackageName;
    isAbstract = aIsAbstract;
    isInterface = aIsInterface;
    superTypes = aSuperTypes;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPackageName(String aPackageName)
  {
    boolean wasSet = false;
    packageName = aPackageName;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsAbstract(boolean aIsAbstract)
  {
    boolean wasSet = false;
    isAbstract = aIsAbstract;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInterface(boolean aIsInterface)
  {
    boolean wasSet = false;
    isInterface = aIsInterface;
    wasSet = true;
    return wasSet;
  }

  public boolean setSuperTypes(ArrayList<String> aSuperTypes)
  {
    boolean wasSet = false;
    superTypes = aSuperTypes;
    wasSet = true;
    return wasSet;
  }

  public String getPackageName()
  {
    return packageName;
  }

  public boolean getIsAbstract()
  {
    return isAbstract;
  }

  public boolean getIsInterface()
  {
    return isInterface;
  }

  public ArrayList<String> getSuperTypes()
  {
    return superTypes;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={51},file={"UmpleImport_CodeModels.ump"},javaline={104},length={16})
  public String generateUmple(){
    StringBuilder umpleBuilder = this.getUmpleBuilder();
		umpleBuilder.append("\n\n");
		if(isInterface){
			umpleBuilder.append("interface "+this.getName() +"\n{");
		}else{
			umpleBuilder.append("class "+ this.getName() +"\n{");
			if(superTypes.size()!=0){
				for (String superType : superTypes) {
					umpleBuilder.append("\n  isA "+ superType+";");
				}
			}
		}
		umpleBuilder.append("\n}");
		return umpleBuilder.toString();
  }

  @umplesourcefile(line={68},file={"UmpleImport_CodeModels.ump"},javaline={122},length={5})
   public void addSuperType(String superType){
    if (superType != null && !superType.isEmpty()) {
			superTypes.add(superType);
		}
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "packageName" + ":" + getPackageName()+ "," +
            "isAbstract" + ":" + getIsAbstract()+ "," +
            "isInterface" + ":" + getIsInterface()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "superTypes" + "=" + (getSuperTypes() != null ? !getSuperTypes().equals(this)  ? getSuperTypes().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}