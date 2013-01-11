/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents a comment, such as those found around classes, methods, attributes and associations.
 */
// line 508 "../../../../src/Umple.ump"
// line 1664 "../../../../src/Umple_Code.ump"
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

  /**
   * The text associated with the comment.
   */
  public String getText()
  {
    return text;
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 1666 ../../../../src/Umple_Code.ump
  public Boolean isInline = true;

  /**
   * Used to take a comment and process it into a format appropriate for displaying in generated code.
   * 
   * For example, you may want a bunch of inline comments put together and displayed as Javadoc.  This accomplishes that (among others).
   * 
   * @param type Indicates the type of comment which determines how the comments are formatted.  The types are: Hash, Javadoc, Attribute Javadoc, Association Javadoc, Method Javadoc, RubyMultiline, RubyMultiline Internal and Multiline.  Defaults to "//" if not specified.
   * @param allComments A list of comments to be processed and formatted all together as one.
   * 
   * @return The processed/formatted comment appropriate for use in generated code output.
   */
  public static String format(String type,List<Comment> allComments)
  {
    //String commentDelimiter = type == "Hash" ? "# " : (type == "Javadoc") ? " * " : (type == "Attribute Javadoc") ? "   * " : (type == "Association Javadoc") ? "   * " : (type == "Method Javadoc") ? "   * " : (type == "RubyMultiline") ? "  " : (type == "Multiline") ? "" : "// ";

    String commentDelimiter;

    // Set the comment delimiter based on the type of the comment. (ex. For Javadoc prepend "*" before every comment line)
    if (type == "Hash")
    {
      commentDelimiter = "# ";
    }
    else if (type == "Javadoc")
    {
      commentDelimiter = " * ";
    }
    else if (type == "Attribute Javadoc")
    {
      commentDelimiter = "   * ";
    }
    else if (type == "Association Javadoc")
    {
      commentDelimiter = "   * ";
    }
    else if (type == "Method Javadoc")
    {
      commentDelimiter = "   * ";
    }
    else if (type == "RubyMultiline")
    {
      commentDelimiter = "";
    }
    else if (type == "RubyMultiline Internal")
    {
      commentDelimiter = "  ";
    }
    else if (type == "Multiline")
    {
      commentDelimiter = "";
    }
    else
    {
      commentDelimiter = "// ";
    }

    if (allComments.size() == 0)
    {
      return null;
    }

    String output = "";

    for (Comment c : allComments)
    {
      if (type == "Javadoc" || type == "Attribute Javadoc" || type == "Association Javadoc" || type == "Method Javadoc" || type == "RubyMultiline" || type == "RubyMultiline Internal")
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

        // Special case where the comment line had no content (only spaces, tabs or asterisks).
        if (startIndex == c.getText().length())
        {
          c.setText(c.getText().substring(startIndex));
        }
      }
      output += commentDelimiter + c.getText() + "\n"; 
    }

    // Finalize the comment based on what type it was. (ex. For Javadoc place the "/**" and "*/" around the comment)
    if (type == "Javadoc")
    {
      output = "/**\n" + output + " */";
    }
    else if (type == "Attribute Javadoc")
    {
      output = "  /**\n" + output + "   */";
    }
    else if (type == "Association Javadoc")
    {
      output = "  /**\n" + output + "   */";
    }
    else if (type == "Method Javadoc")
    {
      output = "  /**\n" + output + "   */";
    }
    else if (type == "RubyMultiline")
    {
      output = "=begin\n" + output + "=end";
    }
    else if (type == "RubyMultiline Internal")
    {
      output = "  =begin\n" + output + "  =end";
    }
    else if (type == "Multiline")
    {
      output = "/*\n" + output + "*/";
    }

    return output.trim();
  }
}