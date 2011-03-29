<?php
require_once ("scripts/compiler_config.php");
$filename = extractFilename();
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="scripts/_load_vml.js" type="text/javascript"></script> 
  <title>UmpleOnline: Generate Java, PHP, or Ruby code from Umple</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
</head>
<body>
  <span class="header" summary="University of Ottawa banner"><a href="http://www.uottawa.ca/welcome.html" target="_blank"><img src="scripts/left_generic.jpg" alt="uOttawa" class="uOttawaAbbr" /></a><img src="scripts/bg_header_title.jpg" class="uOttawa" alt="University of Ottawa - Canadas University" /></span>

  <div class="pagetitle">VML Online</div>
 
  <p class="pagedescription">
  Add your VML structure, and then include the appropriate invocations to generate the desired system.
  Note that this implementation has been set to work with <a href="http://cruise.site.uottawa.ca/umpleonline">Umple</a>,
  so if your generation code is Umple, you can compile it directly to Java, PHP, or Ruby.
  </p>  

<input id="filename" type="hidden" value="<?php echo $filename ?>" />

<table id="container" class="container">
<tr>
  
  <td>
    <div id="palette" class="palette">

      <div class="title">GENERATE</div>
      <input id="buttonGenericCode" type="button" class="button" value="Generic Code" />
      
      <ul></ul>
      
      <div class="title">UMPLE PLUGIN</div>
      <input id="buttonPhpCode" type="button" class="button" value="Php Code" />
      <input id="buttonJavaCode" type="button" class="button" value="Java Code" />
      <input id="buttonRubyCode" type="button" class="button" value="Ruby Code" />
      <input id="buttonEcoreCode" type="button" class="button" value="Ecore XML" />
      <input id="buttonTextUmlCode" type="button" class="button" value="TextUml Code" />
      <input id="buttonPapyrusCode" type="button" class="button" value="Papyrus XMI" />
      <input id="buttonYumlCode" type="button" class="button" value="Yuml Code" />
      <input id="buttonJsonCode" type="button" class="button" value="Json Code" />
      
      <div id="buttonCodeComplete" class="doneMessage">Done<br /> (See Below)</div>
      <div id="buttonCodeWaiting" class="waiting"><img src="scripts/ajax-loader.gif" /></div>

      <ul></ul>
      
      <div class="title">EXAMPLES</div>
      <ul>
        <li id="itemLoadExamples">
          <select id="inputExample" name="inputExample" class="button">
            <option value="simple.vml">Simple</option>
            <option value="invoke_anuko_with_product_line.vml">Anuko</option>
            <option value="invoke_base_case_with_product_line.vml">Base Case</option>
            <option value="invoke_klok_with_product_line.vml">Klok</option>
            <option value="invoke_leia_with_product_line.vml">Lei</option>
            <option value="invoke_timetrex_with_product_line.vml">Timetrex</option>
          </select>
          <input id="buttonExample" type="button" class="button" value="Load Example" />
        </li>
      </ul>
      
    </div>
  </td>
  <td>
    <div id="texteditor" class="surface" ><textarea id="vmltext" wrap="off" rows="24" ></textarea></div>
  </td>
</tr>
</table>

<div id="generatedCodeRow" colspan="3"></div>

<script>
Page.init();
</script>

</body>
</html>