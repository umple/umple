/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.docs;
import java.util.*;
import cruise.umple.compiler.*;

public class ContentParser extends Parser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ContentParser Attributes
  private int init;

  //ContentParser Associations
  private List<Group> groups;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ContentParser(String aName)
  {
    super(aName);
    init = init();
    groups = new ArrayList<Group>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Group getGroup(int index)
  {
    Group aGroup = groups.get(index);
    return aGroup;
  }

  public List<Group> getGroups()
  {
    List<Group> newGroups = Collections.unmodifiableList(groups);
    return newGroups;
  }

  public int numberOfGroups()
  {
    int number = groups.size();
    return number;
  }

  public boolean hasGroups()
  {
    boolean has = groups.size() > 0;
    return has;
  }

  public int indexOfGroup(Group aGroup)
  {
    int index = groups.indexOf(aGroup);
    return index;
  }

  public static int minimumNumberOfGroups()
  {
    return 0;
  }

  public boolean addGroup(Group aGroup)
  {
    boolean wasAdded = false;
    if (groups.contains(aGroup)) { return false; }
    groups.add(aGroup);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGroup(Group aGroup)
  {
    boolean wasRemoved = false;
    if (groups.contains(aGroup))
    {
      groups.remove(aGroup);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    groups.clear();
    super.delete();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private int init()
  {
    addRule("groupOrder : ( [**group] ; )*");
    addRule("content : [*title] [*group] [=noreferences]? @@description [**description] (@@syntax [**syntax])? [[example]]*");
    addRule("example- : @@example [**example] @@endexample");
    init += 1;
    return init;
  }

  public Group getGroup(String name)
  {
    for (Group g : getGroups())
    {
      if (g.getName().equals(name))
      {
        return g;
      }
    }
    Group newGroup = new Group(name);
    addGroup(newGroup);
    return newGroup;
  }
  
  public ParseResult analyze()
  {
    for (Token t : getRootToken().getSubTokens())
    {
      if (t.is("content"))
      {
        Group g = getGroup(t.getValue("group"));
        Content content = new Content(t.getValue("title"), t.getValue("description"), t.getValue("syntax"));
        
        if (t.getValue("noreferences") != null)
        {
          content.setShouldIncludeReferences(false);
        }
        
        for (Token exampleToken : t.getSubTokens())
        {
          if (exampleToken.is("example"))
          {
            content.addExample(exampleToken.getValue());
          }
        }
        g.addContent(content);
      }
      else if (t.is("groupOrder"))
      {
        for (Token groupToken : t.getSubTokens())
        {
          if (!groupToken.isStatic())
          {
            addGroup(new Group(groupToken.getValue()));
          }
        }
      }
    }
    return getParseResult();
  }
}