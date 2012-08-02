<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Main program that generates UmpleOnline
require_once ("scripts/compiler_config.php");
cleanupOldFiles();
$filename = extractFilename();

// Core options after ? and between &. One of the first four is allowed

// example=xxx means load the .ump file named xxx

// filename=xxx means load the URL named xxx (but without the leading http://

// model=nnnn means load the saved bookmark

// text=zzzzz means load the URLencoded text for short examples (as in the user manual)

// nochrome means hide the banner at the top to save real estate
if (isset($_REQUEST["nochrome"])) {$showChrome=false;} else {$showChrome=true;}

// nodiagram means suppress creation of the diagram - passed to JavaScript
if (isset($_REQUEST["nodiagram"])) {$showDiagram=false;} else {$showDiagram=true;}

// notext means suppress creation of the text pane - passed to JavaScript
// ignored if nodiagram is also set
if ($showDiagram && isset($_REQUEST["notext"])) {$showText=false;} else {$showText=true;}

// nomenu means suppress display of menu. Can only happen if diagram OR text hidden
if ((!$showDiagram || !$showText) && isset($_REQUEST["nomenu"])) {$showMenu=false;} else {$showMenu=true;}

// readOnly means suppress ability to edit - passed to JavaScript
$readOnly = isset($_REQUEST["readOnly"]);

$output = readTemporaryFile("ump/" . $filename);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="scripts/_load.js" type="text/javascript"></script>
  <title>UmpleOnline: Generate Java, PHP, or Ruby code from Umple</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
</head>
<body>
<?php if ($showChrome) { ?>
  <table class="pagetitle">
<?php } else { ?>
  <table class="pagetitle" style="display:none;">
<?php } ?>
    <tr>
      <td>
        <img src="scripts/umpleonline_title.jpg" title="UmpleOnline - Draw and Type your next model" />
      </td>
      <td>
        <p class="pagedescription">
        Draw on the right, write (Umple) model code on the left. Generate Java, PHP or Ruby code from your models. <br/>
        Visit <a href="http://cruise.site.uottawa.ca/umple/UsingUmpleOnline.html" target=helppage">the User Manual</a> or <a href="http://cruise.site.uottawa.ca/umple/">the Umple Home Page</a> for help.
        &nbsp;&nbsp;&nbsp;<a href="download_eclipse_umple_plugin.html">Download Umple</a>
        &nbsp;&nbsp;&nbsp;<a href="http://code.google.com/p/umple/issues/entry" target="newissue">Report an Issue</a>


        </p>
      </td>
    </tr>
  </table>

  <noscript>
    <br/><font color="red">Since you have JavaScript disabled this page will not work. To use Umple, download the command line compiler or use Eclipse.</font>
    <pre>
<?php echo $output ?>
    </pre>
  </noscript> 
          
<input id="filename" type="hidden" value="<?php echo $filename ?>" />
<input id="advancedMode" type="hidden" value="0" />

<div id="topLine" class="bookmarkableUrl">

<span id=linetext>Line=<input size=2 id=linenum value=1 onChange="Action.setCaretPosition(value);"></input>&nbsp; &nbsp;</span> 

<?php if (isBookmark($filename)) { ?>
  <a id="topBookmarkable" href="umple.php?model=<?php echo extractModelId($filename) ?>">Changes at this URL are saved</a>
<?php } else { ?>
  <a id="topBookmarkable" href="bookmark.php?model=<?php echo extractModelId($filename) ?>">Create Bookmarkable URL</a>
<?php } ?>

&nbsp; &nbsp;<span id=feedbackMessage></span>

</div>

<table id="container" class="container">

<tr class="mainApplication">   

  <td id="textEditorColumn"  tabIndex="2"  class="textEditorColumn">
    <textarea id="umpleModelEditor" class="umpleModelEditor" wrap="off" rows="48" cols="80">
    </textarea>
    <textarea id="umpleLayoutEditor" class="umpleLayoutEditor" wrap="off"> </textarea>
  </td>
  
  <td id="paletteColumn" class="paletteColumn">

  
    <div class="paletteWrapper" id="paletteWrapper">
    <div id="palette" class="palette">


    <!-- GROUP 1 OF OPTIONS -->
    
      <h3><a href="#">SAVE & RESET</a></h3>
      <div class="section">


        <ul class="first">
          <li class="subtitle">SAVE</li>
<?php if (isBookmark($filename)) { ?>
            <div id="menuBookmarkable" class="bookmarkableUrl"><a href="umple.php?model=<?php echo extractModelId($filename) ?>">Bookmark this Link for Future Use</a></div>
<?php } else { ?>
            <div id="menuBookmarkable" class="bookmarkableUrl"><a href="bookmark.php?model=<?php echo extractModelId($filename) ?>">Save Model For Future Editing</a></div>
<?php } ?>
          <li id="buttonCopy" class="copy"><img src="scripts/copy.png" title="Copy" /> Source</li>
          <li id="buttonCopyEncodedURL" class="copyEncoded"><img src="scripts/copy.png" title="Copy" /> Encoded URL</li>
        </ul>
        
        <ul class="second">
          <li class="subtitle">RESET</li>
          <li> <div id="buttonStartOver" class="jQueryPaletteButton" value="Start Over"></div> </li>
        </ul>

      </div>

    
    <!-- GROUP 2 OF OPTIONS -->
          
      <h3><a href="#tools">TOOLS</a></h3>
      <div class="section">

      <ul id="mainLoadMenu" class="first">
        <li class="subtitle"> Load </li>
        <li id="itemLoadExamples">
          <select id="inputExample" name="inputExample" class="button" size = "1">
            <option name = "optionExample" id = "defaultExampleOption" value="">Select Example</option>
            <option name = "optionExample" value="2DShapes.ump">2DShapes</option>
            <option name = "optionExample" value="AccessControl.ump">AccessControl</option>
            <option name = "optionExample" value="Accidents.ump">Accidents</option>
            <option name = "optionExample" value="Accommodations.ump">Accommodations</option>
            <option name = "optionExample" value="AfghanRainDesign.ump">AfghanRainDesign</option>
            <option name = "optionExample" value="AirlineExample.ump">AirlineExample</option>
            <option name = "optionExample" value="BankingSystemA.ump">BankingSystemA</option>
            <option name = "optionExample" value="BankingSystemB.ump">BankingSystemB</option>
                        <option name = "optionExample" value="CanalSystem.ump">Canal</option>
                        <option name = "optionExample" value="CanalLockStateMachine.ump">CanalLockStateMachine</option>
                        <option name = "optionExample" value="OhHellWhist.ump">CardGames</option>
            <option name = "optionExample" value="Claim.ump">Claim</option>
                        <option name = "optionExample" value="CommunityAssociation.ump">CommunityAssociation</option>
                        <option name = "optionExample" value="CoOpSystem.ump">Co-OpSystem</option>
            <option name = "optionExample" value="DMMOverview.ump">DMMOverview</option>
            <!-- <option name = "optionExample" value="DMMModelElementHierarchy.ump">DMMModelElementHierarchy</option> -->
            <option name = "optionExample" value="DMMSourceObjectHierarchy.ump">DMMSourceObjectHierarchy</option>
            <option name = "optionExample" value="DMMRelationshipHierarchy.ump">DMMRelationshipHierarchy</option>
            <option name = "optionExample" value="DMMExtensionCTF.ump">DMMExtensionCTF</option>
            <option name = "optionExample" value="ElectionSystem.ump">ElectionSystem</option>
            <option name = "optionExample" value="ElevatorSystemA.ump">ElevatorSystemA</option>
            <option name = "optionExample" value="ElevatorSystemB.ump">ElevatorSystemB</option>
            <option name = "optionExample" value="GenealogyA.ump">GenealogyA</option>
            <option name = "optionExample" value="GenealogyB.ump">GenealogyB</option>
            <option name = "optionExample" value="GenealogyC.ump">GenealogyC</option>
            <option name = "optionExample" value="GeographicalInformationSystem.ump">GeographicalInformationSystem</option>
            <option name = "optionExample" value="Hospital.ump">Hospital</option>
            <option name = "optionExample" value="Hotel.ump">Hotel</option>
            <option name = "optionExample" value="Insurance.ump">Insurance</option>
            <option name = "optionExample" value="InventoryManagement.ump">InventoryManagement</option>
            <option name = "optionExample" value="Library.ump">Library</option>
            <option name = "optionExample" value="MailOrderSystemClientOrder.ump">MailOrderSystemClientOrder</option>
            <option name = "optionExample" value="ManufactoringPlantController.ump">ManufactoringPlantController</option>   
                        <option name = "optionExample" value="Pizza.ump">PizzaSystem</option>  
            <option name = "optionExample" value="PoliceSystem.ump">PoliceSystem</option>
            <option name = "optionExample" value="PoliticalEntities.ump">PoliticalEntities</option>
            <option name = "optionExample" value="realestate.ump">RealEstate</option>
                        <option name = "optionExample" value="RoutesAndLocations.ump">RoutesAndLocations</option>
            <option name = "optionExample" value="School.ump">School</option>
            <option name = "optionExample" value="TelephoneSystem.ump">TelephoneSystem</option>
            <option name = "optionExample" value="TrafficLightsA.ump">TrafficLights</option>
            <option name = "optionExample" value="UniversitySystem.ump">UniversitySystem</option>
                        <option name = "optionExample" value="VendingMachineClassDiagram.ump">VendingMachineClassDiagram</option>
            <option name = "optionExample" value="WarehouseSystem.ump">WarehouseSystem</option>
          </select>
        </li>
        </ul>
      
      <ul id="mainDrawMenu" class = "second toggle">
        <li class="subtitle"> Draw </li>
        <li id="buttonAddClass" class="toggleToolItem" name="paletteItem" title="Select and click on the canvas to add a new class."><img id="buttonAddClass" src="scripts/class.png" title="Add Class" /> Class</li>
        <li id="buttonAddAssociation" class="toggleToolItem" name="paletteItem" title="Select and click on a class to draw an association."><img id="buttonAddAssociation" src="scripts/assoc.png" title="Add Assocation" /> Association</li>
        <!-- <li id="buttonBendAssociation" class="toggleToolItem" name="paletteItem"><img id="buttonBendAssociation" src="scripts/assocbend.jpg" title="Bend Assocation" /> Bend Assoc.</li> -->
        <li id="buttonAddGeneralization" class="toggleToolItem" name="paletteItem" title="Select and click on the child class to draw a generalization line to the parent class."><img id="buttonAddGeneralization" src="scripts/generalization.png" title="Add Generalization" /> Generalization</li>
        <li id="buttonDeleteEntity" class="toggleToolItem" name="paletteItem" title="Select and click on an element to remove it from your model."><img id="buttonDeleteEntity" src="scripts/delete.png" title="Delete" /> Delete</li>
        <li id="buttonUndo" name="paletteItem"><img src="scripts/undo.png" title="Undo"> Undo </li>
        <li id="buttonRedo" name="paletteItem"><img src="scripts/redo.png" title="Redo"> Redo </li>
        <li id="buttonSyncDiagram" name="paletteItem"><img id="buttonSyncDiagram" src="scripts/sync_diagram.png" title="Manually sync the diagram" /> Sync Diagram </li>        
      </ul>
      
      <div id="buttonCodeComplete" title="Code Generation Complete">See below.</div>

      <?php generateMenu("") ?>
      
      </div>



    <!-- GROUP 2 OF OPTIONS -->
      
      <h3><a href="#options">OPTIONS</a></h3>
      <div class="section">
        <div id="buttonViewComplete" title="View Complete">Selected view has opened in a new window.</div>
        <ul class="first">
          <li class="subtitle"> Show View </li>
          <li> <input id="buttonShowHideCanvas" class="checkbox" type="checkbox" title="Show/hide the canvas" name="buttonShowHideCanvas" value="buttonShowHideCanvas"/> Canvas </li>
          <li> <input id="buttonShowHideTextEditor" class="checkbox" type="checkbox" title="Show/hide the text editor" name="buttonShowHideTextEditor" value="buttonShowHideTextEditor"/> Text Editor </li>
          <li id="layoutListItem"> <input id="buttonShowHideLayoutEditor" class="checkbox" type="checkbox" title="Show/hide the layout editor" name="buttonShowHideLayoutEditor" value="buttonShowHideLayoutEditor"/> Layout Editor </li>          
        </ul>
        <ul>
          <li id="preferencesTitle" class="subtitle"> Preferences </li>
          <li id="photoReadyListItem"> <input id="buttonPhotoReady" class="checkbox" type="checkbox" title="Remove editing handles from diagram" name="photoReady" value="photoReady"/> Photo Ready </li>
          <li id="manualSyncListItem"> <input id="buttonManualSync" class="checkbox" type="checkbox" name="manualSync" value="manualSync"/> Manual Sync </li>          
        </ul>
        <ul>
          <li id="canvasSizeTitle" class="subtitle"> Canvas Size </li>
          <li id="buttonSmaller" name="paletteItem"><img id="buttonSmaller" src="scripts/smaller.png" title="Reduce the size of the canvas" /> Smaller</li>
          <li id="buttonLarger" name="paletteItem"><img id="buttonLarger" src="scripts/larger.png" title="Increase the size of the canvas" /> Larger</li>
        </ul>
        <ul>
          <li class="subtitle"> Other Views </li>
          <!--<li id="buttonPngImage" class="png"><img src="scripts/png.png" title="Generate PNG Image" /> PNG View</li>-->
          <li id="buttonYumlImage" class="yuml"><img src="scripts/yuml.png" title="Generate Yuml Image" /> Yuml View</li>
          <li id="buttonSimulateCode" class="simulate"><img src="scripts/simulate.png" title="Simulate Code" /> Simulate</li>

        </ul>
      </div>
    </div>
    </div> 
  </td>
 
  <td id="umpleCanvasColumn" class="umpleCanvasColumn">
    <div id="umpleCanvas"  tabIndex="1" class="surface"></div>
  </td>   
</tr>

</table>
<div id="generatedCodeRow" colspan="3"></div>

<script language="JavaScript">
  Page.init(
    <?php if($showDiagram) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($showText) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($showMenu) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($readOnly) { ?> true  <?php } else { ?> false <?php } ?>);
</script>



</body>
</html>
