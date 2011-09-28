/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class Comment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Comment Attributes
  private String text;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Comment(String aText)
  {
    text = aText;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setText(String aText)
  {
    boolean wasSet = false;
    text = aText;
    wasSet = true;
    return wasSet;
  }

  public String getText()
  {
    return text;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Boolean isInline = true;

  public static String format(String type,List<Comment> allComments)
  {
  
    String commentDelimiter = type == "Hash" ? "# " : (type == "Javadoc") ? " * " : (type == "RubyMultiline") ? "" : (type == "Multiline") ? "" : "// ";
  
    if (allComments.size() == 0)
    {
      return null;
    }

    String output = "";
      
    for(Comment c : allComments)
    {
      output += commentDelimiter + c.getText() + "\n"; 
    }
    
    if(type == "Javadoc")
      output = "/**\n" + output + " */";
     
       if (type == "RubyMultiline")
     output = "=begin\n" + output + "=end";
      
      if (type == "Multiline")
      output = "/*\n" + output + "*/";
    return output.trim();
  }
}