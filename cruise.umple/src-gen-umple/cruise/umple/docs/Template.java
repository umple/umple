/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.docs;

/**
 * Set of html templates used in the Umple User manual for certain
 * kinds of page elements
 * @umplesource Documenter.ump 79
 * @umplesource Documenter_Code.ump 412
 */
// line 79 "../../../../src/Documenter.ump"
// line 412 "../../../../src/Documenter_Code.ump"
public class Template
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String htmlTemplate = htmlTemplate();
  public static final String exampleTemplate = exampleTemplate();
  public static final String syntaxTemplate = syntaxTemplate();
  public static final String navigationHeaderTemplate = navigationHeaderTemplate();
  public static final String navigationItemTemplate = navigationItemTemplate();
  public static final String navigationItemTemplateNoAnchor = navigationItemTemplateNoAnchor();

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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 415 ../../../../src/Documenter_Code.ump
  @umplesourcefile(line=415,file="Documenter_Code.ump",javaline=61,length=5)
  private static String navigationHeaderTemplate()
  {
    return "        <div class=\"level1\"><a href=\"javascript:showHide('@@NAVIGATION_HEADER_ID@@');\">@@NAVIGATION_HEADER_NAME@@</a></div>" + "\n" +
           "        <div id=\"@@NAVIGATION_HEADER_ID@@\">";
  }
  
  @umplesourcefile(line=421,file="Documenter_Code.ump",javaline=68,length=4)
  private static String navigationItemTemplate()
  {
    return "          <div class=\"level2\"><a href=\"@@NAVIGATION_ITEM_FILENAME@@\" >@@NAVIGATION_ITEM_NAME@@</a></div>" + "\n";
  }
 
  @umplesourcefile(line=426,file="Documenter_Code.ump",javaline=74,length=4)
  private static String navigationItemTemplateNoAnchor()
  {
    return "          <div class=\"level2\"><b>@@NAVIGATION_ITEM_NAME@@</b></div>" + "\n";
  }
    
  @umplesourcefile(line=431,file="Documenter_Code.ump",javaline=80,length=13)
  private static String exampleTemplate()
  {
    String template = "" + 
      "      <h3>@@EXAMPLE_NUMBER@@</h3>" + "\n" +
      "      <pre name=\"code\" class=\"c-sharp\">" + "\n" +
      "@@EXAMPLE_CODE@@" + "\n" +
      "      </pre>" + "\n" +
      "<p class=\"description\">" +
      "<a target=\"uol\" href=\"http://try.umple.org?text=@@EXAMPLE_CODE_URL@@\">" +
        "Load the above code into UmpleOnline</a></p>" + "\n" +
      "&nbsp; <br/>" + "\n";
    return template;
  }
  
  @umplesourcefile(line=445,file="Documenter_Code.ump",javaline=95,length=10)
  private static String syntaxTemplate()
  {
    String template = "" + 
      "      <h3>Syntax</h3>" + "\n" +
      "      \n" +
      "@@SYNTAX_CODE@@" + "\n" +
       "     <br/>\n" +
        "" + "\n";
    return template;
  }

  @umplesourcefile(line=456,file="Documenter_Code.ump",javaline=107,length=84)
  private static String htmlTemplate()
  {
    String template = "" + 
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + "\n" +
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">" + "\n" +
        "<head>" + "\n" +
        "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" + "\n" +
        "  <link rel=\"stylesheet\" type=\"text/css\" href=\"files/layout.css\" />" + "\n" +
        "  <script type=\"text/javascript\" src=\"files/script.js\"></script>" + "\n" +
        "  <title>Umple User Manual: @@TITLE@@</title>" + "\n" +
        "  <script type=\"text/javascript\">" + "\n" +
        "    function showHide(section)" + "\n" +
        "    {" + "\n" +
        "      var sectionDivStyle = document.getElementById(section).style;" + "\n" +
        "      if(sectionDivStyle.display==\"none\") {" + "\n" +
        "        sectionDivStyle.display=\"inherit\";" + "\n" +
        "      }" + "\n" +
        "      else {" + "\n" +
        "        sectionDivStyle.display=\"none\";" + "\n" +
        "      }" + "\n" +
        "    }" + "\n" +
        "  </script>" + "\n" +
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
        "<div class=\"level1\">@@PREVNEXT@@</div>\n" +
        "    </td>" + "\n" +
        "" + "\n" +
        "    <td class=\"dotSeparator\"><img src=\"files/dots.gif\" alt=\"list of dots\" /></td>" + "\n" +
        "" + "\n" +
        "      <td class=\"content\">" + "\n" +
        "" + "\n" +
        "      <h2><i>Umple User Manual @@PREVNEXT@@</i></h2>"  + "\n" +
        
// Code from Google

"<div style=\"border:1px solid black\" id=\"cse\" style=\"width: 100%;\">Loading</div>" + "\n" +
"<script src=\"http://www.google.com/jsapi\" type=\"text/javascript\"></script>" + "\n" +
"<script type=\"text/javascript\"> " + "\n" +
"  google.load('search', '1', {language : 'en', style : google.loader.themes.V2_DEFAULT});" + "\n" +
"  google.setOnLoadCallback(function() {" + "\n" +
"    var customSearchOptions = {};  var customSearchControl = new google.search.CustomSearchControl(" + "\n" +
"      '014719661006816508785:azyvserhylq', customSearchOptions);" + "\n" +
"    customSearchControl.setResultSetSize(google.search.Search.FILTERED_CSE_RESULTSET);" + "\n" +
"    var options = new google.search.DrawOptions();" + "\n" +
"    options.setAutoComplete(true);" + "\n" +
"    customSearchControl.draw('cse', options);" + "\n" +
"  }, true);" + "\n" +
"</script>" + "\n" +
        
        
/// End code from Google
        "      <h1><font size=\"+1\">@@TITLE@@</font></h1>" + "\n" +
        "      <p class=\"description\">@@DESCRIPTION@@</p>" + "\n" +
        "" + "\n" +
        "@@EXAMPLE@@" + "\n" +
        "@@SYNTAX@@" + "\n" +
        "      </td>" + "\n" +
        "    </tr>" + "\n" +
        "  </tbody></table>" + 
        "<link type=\"text/css\" rel=\"stylesheet\" href=\"syntaxhighlighter/SyntaxHighlighter.css\"></link>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shCore.js\"></script>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shBrushCSharp.js\"></script>" + "\n" +
        "<script language=\"javascript\" src=\"syntaxhighlighter/shBrushXml.js\"></script>" + "\n" +
        "<script language=\"javascript\">" + "\n" +
        "@@SECTIONSTOHIDE@@" + "\n" +
        "dp.SyntaxHighlighter.ClipboardSwf = 'syntaxhighlighter/clipboard.swf';" + "\n" +
        "dp.SyntaxHighlighter.HighlightAll('code');" + "\n" +
        "</script>" + "\n" +
        "</body>" + "\n" +
        "</html>";
    return template; 
  }

}