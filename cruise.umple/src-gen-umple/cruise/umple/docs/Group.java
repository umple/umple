/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.docs;
import java.util.*;

public class Group
{

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

  public void delete()
  {
    contents.clear();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public String getGroupIdName()
  {
    return name.replace(" ","");
  }
}