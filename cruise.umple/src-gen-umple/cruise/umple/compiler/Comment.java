/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

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
    String commentDelimiter = type == "Hash" ? "# " : (type == "Javadoc") ? " * " : (type == "Attribute Javadoc") ? "   * " : (type == "Method Javadoc") ? "   * " : (type == "RubyMultiline") ? "" : (type == "Multiline") ? "" : "// ";
  
    if (allComments.size() == 0)
    {
    	return null;
    }

    String output = "";
      
    for (Comment c : allComments)
    {
    	if (type == "Javadoc" || type == "Attribute Javadoc" || type == "Method Javadoc")
    	{
    		int startIndex = 0;
    		
    		// Go through each letter of the current comment to find start of content.
    		for (int i = 0; i < c.getText().length(); i++)
    		{
    			char letter = c.getText().charAt(i);
    			// Remove these letters until the actual content is found in the line.
    			if (letter == ' ' || letter == '\t' || letter == '*')
    			{
    				startIndex++;
    			}
    			// Comment content found, set comment to start here.
    			else
    			{
    				c.setText(c.getText().substring(startIndex));
    				break;
    			}
    		}
    	}
    	output += commentDelimiter + c.getText() + "\n"; 
    }
    
    if (type == "Javadoc")
    {
    	output = "/**\n" + output + " */";
    }
    
    if (type == "Attribute Javadoc")
    {
    	output = "  /**\n" + output + "   */";
    }
    
    if (type == "Method Javadoc")
    {
    	output = "  /**\n" + output + "   */";
    }
    
    if (type == "RubyMultiline")
    {
    	output = "=begin\n" + output + "=end";
   	}
   	
   	if (type == "Multiline")
   	{
   		output = "/*\n" + output + "*/";
   	}
   	
    return output.trim();
  }
}