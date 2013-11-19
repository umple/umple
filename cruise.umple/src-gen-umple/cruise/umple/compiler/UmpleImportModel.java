/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * integration of all elements as a model
 * @umplesource UmpleImport.ump 43
 * @umplesource UmpleImport_CodeModels.ump 13
 */
// line 43 "../../../../src/UmpleImport.ump"
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

  //UmpleImportModel Associations
  private List<UmpleImportElement> umpleImportElements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportModel(String aCurrentPackageName)
  {
    currentPackageName = aCurrentPackageName;
    umpleBuilder = new StringBuilder();
    umpleImportElements = new ArrayList<UmpleImportElement>();
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

  public UmpleImportElement getUmpleImportElement(int index)
  {
    UmpleImportElement aUmpleImportElement = umpleImportElements.get(index);
    return aUmpleImportElement;
  }

  public List<UmpleImportElement> getUmpleImportElements()
  {
    List<UmpleImportElement> newUmpleImportElements = Collections.unmodifiableList(umpleImportElements);
    return newUmpleImportElements;
  }

  public int numberOfUmpleImportElements()
  {
    int number = umpleImportElements.size();
    return number;
  }

  public boolean hasUmpleImportElements()
  {
    boolean has = umpleImportElements.size() > 0;
    return has;
  }

  public int indexOfUmpleImportElement(UmpleImportElement aUmpleImportElement)
  {
    int index = umpleImportElements.indexOf(aUmpleImportElement);
    return index;
  }

  public static int minimumNumberOfUmpleImportElements()
  {
    return 0;
  }

  public boolean addUmpleImportElement(UmpleImportElement aUmpleImportElement)
  {
    boolean wasAdded = false;
    if (umpleImportElements.contains(aUmpleImportElement)) { return false; }
    umpleImportElements.add(aUmpleImportElement);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUmpleImportElement(UmpleImportElement aUmpleImportElement)
  {
    boolean wasRemoved = false;
    if (umpleImportElements.contains(aUmpleImportElement))
    {
      umpleImportElements.remove(aUmpleImportElement);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addUmpleImportElementAt(UmpleImportElement aUmpleImportElement, int index)
  {  
    boolean wasAdded = false;
    if(addUmpleImportElement(aUmpleImportElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleImportElements()) { index = numberOfUmpleImportElements() - 1; }
      umpleImportElements.remove(aUmpleImportElement);
      umpleImportElements.add(index, aUmpleImportElement);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUmpleImportElementAt(UmpleImportElement aUmpleImportElement, int index)
  {
    boolean wasAdded = false;
    if(umpleImportElements.contains(aUmpleImportElement))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUmpleImportElements()) { index = numberOfUmpleImportElements() - 1; }
      umpleImportElements.remove(aUmpleImportElement);
      umpleImportElements.add(index, aUmpleImportElement);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUmpleImportElementAt(aUmpleImportElement, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    umpleImportElements.clear();
  }

  @umplesourcefile(line={19},file={"UmpleImport_CodeModels.ump"},javaline={152},length={7})
   public String generateUmple(){
    umpleBuilder = new StringBuilder();
		for (UmpleImportElement umpleImportElement : umpleImportElements) {
			umpleBuilder.append(umpleImportElement.generateUmple());
		}
		return umpleBuilder.toString();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "currentPackageName" + ":" + getCurrentPackageName()+ "]"
     + outputString;
  }
}