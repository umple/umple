/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package cruise.umple.docs;

public class Template
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String HtmlTemplate = htmlTemplate();
  public static final String ExampleTemplate = exampleTemplate();
  public static final String SyntaxTemplate = syntaxTemplate();
  public static final String NavigationHeaderTemplate = navigationHeaderTemplate();
  public static final String NavigationItemTemplate = navigationItemTemplate();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Template()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private static String navigationHeaderTemplate()
  {
    return "        <div class=\"level1\">@@NAVIGATION_HEADER_NAME@@</div>" + "\n";
  }
  
  private static String navigationItemTemplate()
  {
    return "        <div class=\"level2\"><a href=\"@@NAVIGATION_ITEM_FILENAME@@\" >@@NAVIGATION_ITEM_NAME@@</a></div>" + "\n";
  }
  
  private static String exampleTemplate()
  {
    String template = "" + 
      "      <h3>@@EXAMPLE_NUMBER@@</h3>" + "\n" +
      "      <pre name=\"code\" class=\"c-sharp\">" + "\n" +
      "@@EXAMPLE_CODE@@" + "\n" +
      "      </pre>" + "\n" +
      "<p class=\"description\">" +
      "<a href=\"http://try.umple.org?text=@@EXAMPLE_CODE_URL@@\">" +
        "Load the above code into UmpleOnline</a></p>" + "\n" +
      "&nbsp; <br/>" + "\n";
    return template;
  }
  
  private static String syntaxTemplate()
  {
    String template = "" + 
      "      <h3>Syntax</h3>" + "\n" +
      "      <pre class=\"syntax\">" + "\n" +
      "@@SYNTAX_CODE@@" + "\n" +
       "      </pre>" + "\n" +
        "" + "\n";
    return template;
  }

  private static String htmlTemplate()
  {
    String template = "" + 
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + "\n" +
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">" + "\n" +
        "<head>" + "\n" +
        "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" + "\n" +
        "  <link rel=\"stylesheet\" type=\"text/css\" href=\"files/layout.css\" />" + "\n" +
        "  <script type=\"text/javascript\" src=\"files/script.js\"></script>" + "\n" +
        "  <title>@@TITLE@@</title>" + "\n" +
        "</head>" + "\n" +
        "" + "\n" +
        "<body>" + "\n" +
        "" + "\n" +
        "  <span class=\"header\" summary=\"University of Ottawa banner\"><a href=\"http://www.uottawa.ca/welcome.html\" target=\"_blank\"><img src=\"files/left_generic.jpg\" alt=\"uOttawa\" class=\"uOttawaAbbr\" /></a><img src=\"files/bg_header_title.jpg\" class=\"uOttawa\" alt=\"University of Ottawa - Canadas University\" /></span>" + "\n" +
        "  " + "\n" +
        "  <table class=\"body\" >" + "\n" +
        "  <tbody>" + "\n" +
        "  <tr>" + "\n" +
        "    <td class=\"indicatorBlocks\"><img src=\"files/indicator_blocks.gif\" /></td>" + "\n" +
        "" + "\n" +
        "    <td class=\"menu\">" + "\n" +
        "      <div class=\"title\"><a href=\"http://cruise.site.uottawa.ca/umple\">Umple Home<br/>Page</a></div>" + "\n" +
        "@@NAVIGATION@@" + "\n" +
        "    </td>" + "\n" +
        "" + "\n" +
        "    <td class=\"dotSeparator\"><img src=\"files/dots.gif\" alt=\"list of dots\" /></td>" + "\n" +
        "" + "\n" +
        "      <td class=\"content\">" + "\n" +
        "" + "\n" +
        "      <h1>@@TITLE@@</h1>" + "\n" +
        "      <p class=\"description\">@@DESCRIPTION@@</p>" + "\n" +
        "" + "\n" +
        "@@SYNTAX@@" + "\n" +
        "@@EXAMPLE@@" + "\n" +
        "      </td>" + "\n" +
        "    </tr>" + "\n" +
        "  </tbody></table>" + "\n" +
        "<link type=\"text/css\" rel=\"stylesheet\" href=\"syntaxhighlighter/SyntaxHighlighter.css\"></link>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shCore.js\"></script>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shBrushCSharp.js\"></script>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shBrushXml.js\"></script>" + "\n" +
        "<script language=\"javascript\">" + "\n" +
        "dp.SyntaxHighlighter.ClipboardSwf = 'syntaxhighlighter/clipboard.swf';" + "\n" +
        "dp.SyntaxHighlighter.HighlightAll('code');" + "\n" +
        "</script>" + "\n" +
        "</body>" + "\n" +
        "</html>";
    return template; 
  }
}