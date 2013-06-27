/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.docs;
import java.util.*;

/**
 * A section of the Umple user manual
 * Defined in the build/references/order.group
 * @umplesource Documenter.ump 59
 * @umplesource Documenter_Code.ump 339
 */
// line 59 "../../../../src/Documenter.ump"
// line 339 "../../../../src/Documenter_Code.ump"
public class Group
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Group Attributes
  private String name;

  //Group Associations
  private List<Content> contents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Group(String aName)
  {
    name = aName;
    contents = new ArrayList<Content>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Content getContent(int index)
  {
    Content aContent = contents.get(index);
    return aContent;
  }

  public List<Content> getContents()
  {
    List<Content> newContents = Collections.unmodifiableList(contents);
    return newContents;
  }

  public int numberOfContents()
  {
    int number = contents.size();
    return number;
  }

  public boolean hasContents()
  {
    boolean has = contents.size() > 0;
    return has;
  }

  public int indexOfContent(Content aContent)
  {
    int index = contents.indexOf(aContent);
    return index;
  }

  public static int minimumNumberOfContents()
  {
    return 0;
  }

  public boolean addContent(Content aContent)
  {
    boolean wasAdded = false;
    if (contents.contains(aContent)) { return false; }
    contents.add(aContent);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeContent(Content aContent)
  {
    boolean wasRemoved = false;
    if (contents.contains(aContent))
    {
      contents.remove(aContent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addContentAt(Content aContent, int index)
  {  
    boolean wasAdded = false;
    if(addContent(aContent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContents()) { index = numberOfContents() - 1; }
      contents.remove(aContent);
      contents.add(index, aContent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveContentAt(Content aContent, int index)
  {
    boolean wasAdded = false;
    if(contents.contains(aContent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfContents()) { index = numberOfContents() - 1; }
      contents.remove(aContent);
      contents.add(index, aContent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addContentAt(aContent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    contents.clear();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={340},file={"Documenter_Code.ump"},javaline={162},length={5})
  @umplesourcefile(line={341},file={"Documenter_Code.ump"},javaline={163},length={4})
  public String getGroupIdName()
  {
    return name.replace(" ","");
  }

}