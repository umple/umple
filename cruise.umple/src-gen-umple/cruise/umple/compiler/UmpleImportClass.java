/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * @umplesource UmpleImport.ump 55
 * @umplesource UmpleImport_CodeModels.ump 35
 */
// line 55 "../../../../src/UmpleImport.ump"
// line 35 "../../../../src/UmpleImport_CodeModels.ump"
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
  private List<String> superTypes;

  //UmpleImportClass Associations
  private List<UmpleImportAttribute> umpleImportAttributes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportClass(String aId, String aName, String aPackageName, boolean aIsAbstract, boolean aIsInterface)
  {
    super(aId, aName);
    packageName = aPackageName;
    isAbstract = aIsAbstract;
    isInterface = aIsInterface;
    superTypes = new ArrayList<String>();
    umpleImportAttributes = new ArrayList<UmpleImportAttribute>();
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

  public boolean addSuperType(String aSuperType)
  {
    boolean wasAdded = false;
    wasAdded = superTypes.add(aSuperType);
    return wasAdded;
  }

  public boolean removeSuperType(String aSuperType)
  {
    boolean wasRemoved = false;
    wasRemoved = superTypes.remove(aSuperType);
    return wasRemoved;
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

  public String getSuperType(int index)
  {
    String aSuperType = superTypes.get(index);
    return aSuperType;
  }

  public String[] getSuperTypes()
  {
    String[] newSuperTypes = superTypes.toArray(new String[superTypes.size()]);
    return newSuperTypes;
  }

  public int numberOfSuperTypes()
  {
    int number = superTypes.size();
    return number;
  }

  public boolean hasSuperTypes()
  {
    boolean has = superTypes.size() > 0;
    return has;
  }

  public int indexOfSuperType(String aSuperType)
  {
    int index = superTypes.indexOf(aSuperType);
    return index;
  }

  public UmpleImportAttribute getUmpleImportAttribute(int index)
  {
    UmpleImportAttribute aUmpleImportAttribute = umpleImportAttributes.get(index);
    return aUmpleImportAttribute;
  }

  public List<UmpleImportAttribute> getUmpleImportAttributes()
  {
    List<UmpleImportAttribute> newUmpleImportAttributes = Collections.unmodifiableList(umpleImportAttributes);
    return newUmpleImportAttributes;
  }

  public int numberOfUmpleImportAttributes()
  {
    int number = umpleImportAttributes.size();
    return number;
  }

  public boolean hasUmpleImportAttributes()
  {
    boolean has = umpleImportAttributes.size() > 0;
    return has;
  }

  public int indexOfUmpleImportAttribute(UmpleImportAttribute aUmpleImportAttribute)
  {
    int index = umpleImportAttributes.indexOf(aUmpleImportAttribute);
    return index;
  }

  public static int minimumNumberOfUmpleImportAttributes()
  {
    return 0;
  }

  public boolean addUmpleImportAttribute(UmpleImportAttribute aUmpleImportAttribute)
  {
    boolean wasAdded = false;
    if (umpleImportAttributes.contains(aUmpleImportAttribute)) { return false; }
    umpleImportAttributes.add(aUmpleImportAttribute);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUmpleImportAttribute(UmpleImportAttribute aUmpleImportAttribute)
  {
    boolean wasRemoved = false;
    if (umpleImportAttributes.contains(aUmpleImportAttribute))
    {
      umpleImportAttributes.remove(aUmpleImportAttribute);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUmpleImportAttributeAt(UmpleImportAttribute aUmpleImportAttribute, int index)
  {  
    boolean wasAdded = false;
    if(addUmpleImportAttribute(aUmpleImportAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleImportAttributes()) { index = numberOfUmpleImportAttributes() - 1; }
      umpleImportAttributes.remove(aUmpleImportAttribute);
      umpleImportAttributes.add(index, aUmpleImportAttribute);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmpleImportAttributeAt(UmpleImportAttribute aUmpleImportAttribute, int index)
  {
    boolean wasAdded = false;
    if(umpleImportAttributes.contains(aUmpleImportAttribute))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleImportAttributes()) { index = numberOfUmpleImportAttributes() - 1; }
      umpleImportAttributes.remove(aUmpleImportAttribute);
      umpleImportAttributes.add(index, aUmpleImportAttribute);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmpleImportAttributeAt(aUmpleImportAttribute, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    umpleImportAttributes.clear();
    super.delete();
  }

  @umplesourcefile(line={39},file={"UmpleImport_CodeModels.ump"},javaline={227},length={20})
  public String generateUmple(){
    StringBuilder umpleBuilder = this.getUmpleBuilder();
		umpleBuilder.append("\n\n");
		if(isInterface){
			umpleBuilder.append("interface "+this.getName() +"\n{");
		}else{
			umpleBuilder.append("class "+ this.getName() +"\n{");
			if(superTypes.size()!=0){
				for (String superType : superTypes) {
				    if(!superType.isEmpty())
						umpleBuilder.append("\n  isA "+ superType+";");
				}
			}
		}
		for (UmpleImportAttribute umpleImportAttribute : umpleImportAttributes) {
			umpleBuilder.append(umpleImportAttribute.generateUmple());
		}
		umpleBuilder.append("\n}");
		return umpleBuilder.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "packageName" + ":" + getPackageName()+ "," +
            "isAbstract" + ":" + getIsAbstract()+ "," +
            "isInterface" + ":" + getIsInterface()+ "]"
     + outputString;
  }
}