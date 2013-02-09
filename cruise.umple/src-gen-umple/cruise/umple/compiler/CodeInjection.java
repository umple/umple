/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.Position;
import java.util.*;

// line 222 "../../../../src/Umple.ump"
public class CodeInjection
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeInjection Attributes
  private String type;
  private String operation;
  private String code;
  private Position position;
  private boolean isInternal;

  //CodeInjection Associations
  private UmpleClass umpleClass;
  private List<CodeLanguage> language;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeInjection(String aType, String aOperation, String aCode, UmpleClass aUmpleClass)
  {
    type = aType;
    operation = aOperation;
    code = aCode;
    isInternal = false;
    if (!setUmpleClass(aUmpleClass))
    {
      throw new RuntimeException("Unable to create CodeInjection due to aUmpleClass");
    }
    language = new ArrayList<CodeLanguage>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setOperation(String aOperation)
  {
    boolean wasSet = false;
    operation = aOperation;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsInternal(boolean aIsInternal)
  {
    boolean wasSet = false;
    isInternal = aIsInternal;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public String getOperation()
  {
    return operation;
  }

  public String getCode()
  {
    return code;
  }

  public Position getPosition()
  {
    return position;
  }

  public boolean getIsInternal()
  {
    return isInternal;
  }

  public boolean isIsInternal()
  {
    return isInternal;
  }

  public UmpleClass getUmpleClass()
  {
    return umpleClass;
  }

  public CodeLanguage getLanguage(int index)
  {
    CodeLanguage aLanguage = language.get(index);
    return aLanguage;
  }

  public List<CodeLanguage> getLanguage()
  {
    List<CodeLanguage> newLanguage = Collections.unmodifiableList(language);
    return newLanguage;
  }

  public int numberOfLanguage()
  {
    int number = language.size();
    return number;
  }

  public boolean hasLanguage()
  {
    boolean has = language.size() > 0;
    return has;
  }

  public int indexOfLanguage(CodeLanguage aLanguage)
  {
    int index = language.indexOf(aLanguage);
    return index;
  }

  public boolean setUmpleClass(UmpleClass newUmpleClass)
  {
    boolean wasSet = false;
    if (newUmpleClass != null)
    {
      umpleClass = newUmpleClass;
      wasSet = true;
    }
    return wasSet;
  }

  public static int minimumNumberOfLanguage()
  {
    return 0;
  }

  public boolean addLanguage(CodeLanguage aLanguage)
  {
    boolean wasAdded = false;
    if (language.contains(aLanguage)) { return false; }
    language.add(aLanguage);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLanguage(CodeLanguage aLanguage)
  {
    boolean wasRemoved = false;
    if (language.contains(aLanguage))
    {
      language.remove(aLanguage);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLanguageAt(CodeLanguage aLanguage, int index)
  {  
    boolean wasAdded = false;
    if(addLanguage(aLanguage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLanguage()) { index = numberOfLanguage() - 1; }
      language.remove(aLanguage);
      language.add(index, aLanguage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLanguageAt(CodeLanguage aLanguage, int index)
  {
    boolean wasAdded = false;
    if(language.contains(aLanguage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLanguage()) { index = numberOfLanguage() - 1; }
      language.remove(aLanguage);
      language.add(index, aLanguage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLanguageAt(aLanguage, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    umpleClass = null;
    language.clear();
  }

}