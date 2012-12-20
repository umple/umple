<?php
require_once ("scripts/compiler_config.php");
cleanupOldFiles();
$filename = extractFilename();
$output = readTemporaryFile($filename);
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
  <table class="pagetitle">
    <tr>
      <td>
        <img src="scripts/vmlonline_title.jpg" title="VML-Online" />
      </td>
      <td>
        <p class="pagedescription">
          
          Add your VML structure, and then include the appropriate invocations to generate the desired system.<br />
          Note that this implementation has been set to work with <a href="http://cruise.site.uottawa.ca/umpleonline">UmpleOnline</a>,<br />
          so if your generation code is Umple, you can compile it directly to Java, PHP, or Ruby.
        </p>
      </td>
    </tr>
  </table>

<input id="filename" type="hidden" value="<?php echo $filename ?>" />

<table id="container" class="container">
<tr>
  
  <td>
    <div id="palette" class="palette-vml">

      <ul></ul>
      
      <div class="title">GENERATE</div>
      <input id="buttonGenericCode" type="button" class="button" value="Generic Code" />
      
      <ul></ul>
      
      <div class="title">UMPLE PLUGIN</div>
      <input id="buttonPhpCode" type="button" class="button" value="Php Code" /> <br />
      <input id="buttonJavaCode" type="button" class="button" value="Java Code" /> <br />
      <input id="buttonRubyCode" type="button" class="button" value="Ruby Code" /> <br />
      <input id="buttonEcoreCode" type="button" class="button" value="Ecore XML" /> <br />
      <input id="buttonTextUmlCode" type="button" class="button" value="TextUml Code" /> <br />
      <input id="buttonPapyrusCode" type="button" class="button" value="Papyrus XMI" /> <br />
      <input id="buttonYumlCode" type="button" class="button" value="Yuml Code" /> <br />
      <input id="buttonJsonCode" type="button" class="button" value="Json Code" /> <br />
      
      <div id="buttonCodeComplete" class="doneMessage">Done<br /> (See Below)</div>
      <div id="buttonCodeWaiting" class="waiting"><img src="scripts/ajax-loader.gif" /></div>

      <ul></ul>
      
      <div class="title">EXAMPLES</div>
        <select id="inputExample" name="inputExample" class="button" style="padding:0; margin:0;">
          <option name="optionExample" id = "defaultExampleOption" value="">Select Example</option>
          <option name="optionExample" value="simple.vml">Simple</option>
          <option name="optionExample" value="invoke_anuko_with_product_line.vml">Anuko</option>
          <option name="optionExample" value="invoke_base_case_with_product_line.vml">Base Case</option>
          <option name="optionExample" value="invoke_klok_with_product_line.vml">Klok</option>
          <option name="optionExample" value="invoke_leia_with_product_line.vml">Lei</option>
          <option name="optionExample" value="invoke_timetrex_with_product_line.vml">Timetrex</option>
          <option name="optionExample" value="bCMS.vml">bCMS</option>
        </select> <br />
        <input id="buttonExample" type="button" class="button" value="Load Example" />
      </div>
    </div>
  </td>
  <td>
    <textarea id="vmltext" class="umpleModelEditor" wrap="off" rows="24" > </textarea>
  </td>
</tr>
</table>

<div id="generatedCodeRow" colspan="3"> </div>

<script>
Page.init();
</script>

</body>
</html>