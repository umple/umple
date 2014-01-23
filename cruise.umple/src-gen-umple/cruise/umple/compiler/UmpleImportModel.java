/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.SampleFileWriter;
import java.util.*;

/**
 * integration of all importElements as a model
 * @umplesource UmpleImport.ump 56
 * @umplesource UmpleImport_CodeModels.ump 13
 */
// line 56 "../../../../src/UmpleImport.ump"
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

  @umplesourcefile(line={19},file={"UmpleImport_CodeModels.ump"},javaline={153},length={8})
  public String generateUmple(){
    umpleBuilder = new StringBuilder();
		for (UmpleImportElement umpleImportElement : umpleImportElements) {
			if(umpleImportElement.getId()!=UmpleImportConstants.ECORE_REFERENCE)
				umpleBuilder.append(umpleImportElement.generateUmple());
		}
		return umpleBuilder.toString();
  }


  /**
   * resolve assoications by global lookup
   */
  @umplesourcefile(line={29},file={"UmpleImport_CodeModels.ump"},javaline={163},length={29})
  public UmpleImportAssociation checkIfOppositeExist(UmpleImportAssociation currEnd){
    this.addUmpleImportElement(currEnd);
	  UmpleImportAssociation oppoEnd = null;
	  for (UmpleImportElement umpleImportElement : umpleImportElements) {
		  if(umpleImportElement.getId() == UmpleImportConstants.ECORE_REFERENCE){
			  UmpleImportAssociation tempEnd = (UmpleImportAssociation)umpleImportElement;
			  String oppoStartClass = tempEnd.getStartClass();
			  String oppoEndClass = tempEnd.getEndClass();
			  String currStartClass = currEnd.getStartClass();
			  String currEndClass = currEnd.getEndClass();
			  if(currStartClass.equals(oppoEndClass) && currEndClass.equals(oppoStartClass))
				  oppoEnd = tempEnd;
		  }
	  }
	  //update existing association with crrEnd info
	  if(oppoEnd!=null)
	  {
		  for (UmpleImportElement umpleImportElement : umpleImportElements) {
			  if(umpleImportElement.getName() == oppoEnd.getStartClass()){
				  UmpleImportClass umpleClass = (UmpleImportClass)umpleImportElement;
				  umpleClass.removeUmpleImportAssociation(oppoEnd);
				  oppoEnd.setOtherLowerBound(currEnd.getLowerBound());
				  oppoEnd.setOtherUpperBound(currEnd.getUpperBound());
				  umpleClass.addUmpleImportAssociation(oppoEnd);
			  }
		  }  
	  }
	  return oppoEnd;
  }

  @umplesourcefile(line={59},file={"UmpleImport_CodeModels.ump"},javaline={198},length={9})
  public boolean generateUmpleFile(String filename){
    String input = this.generateUmple();
		boolean isSuccess = false;
		if (input != null && !input.isEmpty()) {
			SampleFileWriter.createFile(filename, input);
			isSuccess = true;
		}
		return isSuccess;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "currentPackageName" + ":" + getCurrentPackageName()+ "]"
     + outputString;
  }
}